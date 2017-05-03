package co.edu.udistrital.sga.preinscripcion.auto.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.Solution;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

import co.edu.udistrital.sga.preinscripcion.auto.persistence.entities.oracle.Actablahomologacion;
import co.edu.udistrital.sga.preinscripcion.auto.services.CursosService;
import co.edu.udistrital.sga.preinscripcion.auto.services.EstudiantesService;
import co.edu.udistrital.sga.preinscripcion.auto.services.ControlService;

/**
 * Esta clase toma el papel principal de la solucion, esta anotada con PlanningSolution para que pueda ser
 * identificada por Optaplanner, es el punto de entrada para la solucion del problema de planificación
 * @author Deivid Suarez
 */
@PlanningSolution
public class PreinscripcionAsignaturasSolution implements Solution<HardSoftScore> {

	private Integer anio;
	private Integer periodo; 
	private Long codCarrera;
	
//	@Autowired
    private ControlService controlService;
//	@Autowired
    private CursosService cursosService;
//	@Autowired
    private EstudiantesService estudiantesService;

    public PreinscripcionAsignaturasSolution(){
    	
    }

    /**
     * El constructor recibe por parametro los servicios de spring dado que no puede tomar la 
     * condicion de componente necesaria para la inyeccion de dependencias.
     * @param controlService
     * @param cursosService
     * @param estudiantesService
     */
	public PreinscripcionAsignaturasSolution(ControlService controlService, CursosService cursosService,
			EstudiantesService estudiantesService) {
		super();
		this.controlService = controlService;
		this.cursosService = cursosService;
		this.estudiantesService = estudiantesService;
	}

	/***
	 * Listas de hechos
	 * A continuación estan las listas de echos del problema de planificacion
	 */	

	private List<Estudiante> listaEstudiantesActivos;
	private Map<String, Integer> listaDeConflictos;
	private Map<String, Integer> listaDeConflictosHomologaciones;

	private List<EstudianteXCurso> listaProgramacionEstudiantes;
	 	
    private HardSoftScore score;
	
	@Override
	public HardSoftScore getScore() {	
		return score;
	}

	@Override
	public void setScore(HardSoftScore score) {
		this.score=score;
	}

	@Override
	public Collection<? extends Object> getProblemFacts() {
		List<Object> facts = new ArrayList<Object>();
        facts.add(this.listaDeConflictos);
        facts.add(this.listaEstudiantesActivos);
        facts.add(this.listaDeConflictosHomologaciones);
        return facts;
	}

	public Map<String, Integer> getListaDeConflictos() {
		return listaDeConflictos;
	}

	public void setListaDeConflictos(Map<String, Integer> listaDeConflictos) {
		this.listaDeConflictos = listaDeConflictos;
	}

	public List<Estudiante> getListaEstudiantesActivos() {
		return listaEstudiantesActivos;
	}

	public void setListaEstudiantesActivos(List<Estudiante> listaEstudiantesActivos) {
		this.listaEstudiantesActivos = listaEstudiantesActivos;
	}
	/**
	 * Getter anotado con planningEntityCollectionProperty dado que es la entidad principal 
	 * que cambiara en la planificación
	 * @return
	 */
	@PlanningEntityCollectionProperty
	public List<EstudianteXCurso> getListaProgramacionEstudiantes() {
		
		return listaProgramacionEstudiantes;
	}

	public void setListaProgramacionEstudiantes(List<EstudianteXCurso> listaProgramacionEstudiantes) {
		this.listaProgramacionEstudiantes = listaProgramacionEstudiantes;
	}

	
	public void initFacts(Integer anio, Integer periodo, Long codCarrera){
		this.anio=anio;
		this.periodo=periodo;
		this.codCarrera=codCarrera;
		List<AsignaturaGrupo> listaAsignaturasVigentes = new ArrayList<>();
		List<AsignaturaRequerida> listaAsignaturasPorDemanda=new ArrayList<>();
		this.listaEstudiantesActivos=estudiantesService.obtenerListaEstudiantes();
		listaAsignaturasPorDemanda=cursosService.obtenerListaMateriasPreinsDemanda(anio, periodo, codCarrera,"A");
		
		List<Actablahomologacion> listaHomologaciones=cursosService.obtenerListaHomologaciones(codCarrera, "A");
		listaDeConflictosHomologaciones=precalculateHomologationConflictList(listaHomologaciones);
		
		listaAsignaturasVigentes=cursosService.obtenerCursosProgramados(anio, periodo, codCarrera);	
		listaAsignaturasVigentes=removerAsignaturasSinHorario(listaAsignaturasVigentes);
		establecerAsignaturasPorDemanda(listaEstudiantesActivos, listaAsignaturasPorDemanda);
		establecerAsignaturasPosibles(listaEstudiantesActivos,listaAsignaturasVigentes,listaHomologaciones);
		this.listaDeConflictos=precalculateCourseConflictList(listaAsignaturasVigentes);		
		this.listaEstudiantesActivos=removerEstudiantesSinPosibilidades(this.listaEstudiantesActivos);		
		listaProgramacionEstudiantes=constructPreSolution(this.listaEstudiantesActivos);
		
	}
	
	public List<EstudianteXCurso> constructPreSolution(List<Estudiante> listaEstudiantes){
		List<EstudianteXCurso> preSolution=new ArrayList<>();
		for (Estudiante estudiante : listaEstudiantes) {
			Map<Long, List<AsignaturaGrupo>> agrupados=estudiante.getAsignaturasPosibles().stream().collect(Collectors.groupingBy(AsignaturaGrupo::getCodigoAsignatura));	
			AsignaturaGrupo asignatura=null;
			for (Entry<Long, List<AsignaturaGrupo>> entry : agrupados.entrySet()) {
				EstudianteXCurso escur=new EstudianteXCurso();
				escur.setEstudiante(estudiante);
				escur.setCurso(entry.getValue().stream().findAny().get());
				preSolution.add(escur);
			}
		}
		
		return preSolution;		
	}
	/***
	 * De los cursos programados, remueven las asignaturas que no tienen horarios definios, sean nulos o en blanco
	 * con la finalidad de que no interfieran en el proceso de planificación.
	 * @param listaTotalAsignaturas
	 * @return
	 */
	public List<AsignaturaGrupo> removerAsignaturasSinHorario(List<AsignaturaGrupo> listaTotalAsignaturas){
		return listaTotalAsignaturas.stream().filter(e->e.getHorarios()!=null).filter(e->e.getHorarios().size()>0).collect(Collectors.toList());
	}
	
	/***
	 * Remueven de la lista a los estudiantes que no han preinscrito por demanda nada con la finalidad de
	 * que no interfieran en el proceso de planificación.
	 * @param listaEstudiantes
	 * @return
	 */
	public List<Estudiante> removerEstudiantesSinPosibilidades(List<Estudiante> listaEstudiantes){
		List<Estudiante> listaTemporal=new ArrayList<>();
		for (Estudiante estudiante : listaEstudiantes) {
			if(estudiante.getAsignaturasPosibles()!=null && estudiante.getAsignaturasPosibles().size()>0){
				listaTemporal.add(estudiante);
			}
			else{
				System.out.println(estudiante.getCodigo()+":");
				estudiante.getAsignaturasPosibles().stream().forEach(item->System.out.println(item));
			}
		}
		return listaTemporal;
	}
	
	public void establecerAsignaturasPorDemanda(List<Estudiante> listaEstudiantes, List<AsignaturaRequerida> listaAsignaturasPorDemanda){
		for (Estudiante estudiante : listaEstudiantes) {
			estudiante.setPreinscripcionPorDemanda(listaAsignaturasPorDemanda.stream().filter(est -> estudiante.getCodigo().equals(est.getCodigoEstudiante())).collect(Collectors.toList()));             
		}
	}
	
	/***
	 * Este metodo establece la lista de asignaturas posibles para cada estudiante, que seran usadas luego por el planificador
	 * se debe tener en cuenta que los listados de asignaturas homologables solo actuan en un sentido segun la tabla de homologacion
	 * suministrada 
	 * @param listaEstudiantes lista de estudiantes
	 * @param listaAsignaturasProgramadas Listado de cursos ofrecidos
	 * @param listaHomologaciones Lista de homologaciones
	 */
	public void establecerAsignaturasPosibles(List<Estudiante> listaEstudiantes, List<AsignaturaGrupo> listaAsignaturasProgramadas, List<Actablahomologacion> listaHomologaciones){
		for (Estudiante estudiante : listaEstudiantes) {			
			List<AsignaturaGrupo> listaHomologacionesEstudiante=new ArrayList<>();
			List<AsignaturaRequerida> listaCodigosAsigxDemanda=estudiante.getPreinscripcionPorDemanda();	
			List<AsignaturaGrupo> listaAsignaturasPermitidas = new ArrayList<>();
			for (AsignaturaRequerida asignaturaRequerida : listaCodigosAsigxDemanda) 
			{
				List<AsignaturaGrupo> listaTemporalAsignaturas=listaAsignaturasProgramadas.stream().filter(e->asignaturaRequerida.getCodigoAsignatura().equals(e.getCodigoAsignatura())).collect(Collectors.toList());
				listaTemporalAsignaturas.stream().forEach(f->f.setCreditos(asignaturaRequerida.getCreditos()));	
				listaTemporalAsignaturas.stream().forEach(f->f.setSemestre(asignaturaRequerida.getSemestre()));	
				listaTemporalAsignaturas.stream().forEach(f->f.setCeaCode(asignaturaRequerida.getCeaCode()));	
//				listaTemporalAsignaturas.stream().forEach(f->f.setCreditosOptional(listaCodigosAsigxDemanda.stream().filter(a->a.getCodigoAsignatura().equals(f.getCodigoAsignatura())).map(AsignaturaRequerida::getCreditos).findFirst()));
				listaAsignaturasPermitidas.addAll(listaTemporalAsignaturas);
				
				List<Actablahomologacion> listaHomologadores= listaHomologaciones.stream().filter(e->e.getHomAsiCodPpal().equals(asignaturaRequerida.getCodigoAsignatura())).collect(Collectors.toList());
				
				//Se revisa en las homologaciones verifica si la materia tiene homologadores y los agrega a la lista de asignaturas 
				//permitidas
				for (Actablahomologacion homologador : listaHomologadores) {
					List<AsignaturaGrupo> listaCursosHomologadores=listaAsignaturasProgramadas.stream().filter(e->homologador.getHomAsiCodHom().equals(e.getCodigoAsignatura())).collect(Collectors.toList());
					listaCursosHomologadores.stream().forEach(f->f.setCreditos(asignaturaRequerida.getCreditos()));
					listaCursosHomologadores.stream().forEach(f->f.setSemestre(asignaturaRequerida.getSemestre()));	
					listaCursosHomologadores.stream().forEach(f->f.setCeaCode(asignaturaRequerida.getCeaCode()));
					listaAsignaturasPermitidas.addAll(listaCursosHomologadores);
					listaHomologacionesEstudiante.addAll(listaCursosHomologadores);
				}				
			}
			//Seteamos al estudiante las asignaturas homologadoras y las posibles
			estudiante.setAsignaturasHomologadoras(listaHomologacionesEstudiante.stream().map(AsignaturaGrupo::getCodigoAsignatura).collect(Collectors.toList()));
			estudiante.setAsignaturasPosibles(listaAsignaturasPermitidas);			
		}
	}
	
	public List<AsignaturaGrupo> establecerCreditosAsignaturas(List<AsignaturaRequerida> listaAsignaturasDemanda, List<AsignaturaGrupo> listaAsignaturasProg){
		return null;
	}

	/***
	 * Esta función permite precalcular la lista de conflictos horarios entre todos los cursos ofrecidos
	 * @param listaAsignaturasVig Lista de cursos ofrecidos List<AsignaturaGrupo>
	 * @return Map<String, Integer> Mapa de conflictos donde se guardan las claves en conflicto de la siguiente manera llave=codigoMenor-codigoMayor valor=Numero conflictos horarios
	 */
	private Map<String, Integer> precalculateCourseConflictList(List<AsignaturaGrupo> listaAsignaturasVig) {
        Map<String, Integer> courseConflictList = new HashMap<String, Integer>();
        for (AsignaturaGrupo leftCourse : listaAsignaturasVig) {
            for (AsignaturaGrupo rightCourse : listaAsignaturasVig) {
                if (leftCourse.getIdAsignaturaGrupo() != rightCourse.getIdAsignaturaGrupo()) {
                	int conflictCount = 0;	                  	                 	                    
                    for (Horario horizq : leftCourse.getHorarios()) {
                    	for (Horario horder : rightCourse.getHorarios()) {
							if(horizq.cruze(horder)){
								conflictCount++;
							}
						}
					}	     
                    if(conflictCount>0){
                    	agregarConflicto(courseConflictList,leftCourse.getIdAsignaturaGrupo(),rightCourse.getIdAsignaturaGrupo(), conflictCount);
                    }	                   	                   
                }
            }
        }	        	        	        
        return courseConflictList;
    }
	/***
	 * Esta función permite precalcular los conflictos por homologación que puedan darse 
	 * @param listaAsignaturasVig Lista elementos Actatablahomologacion a partir de los cuales construye el mapa
	 * @return Map<String, Integer> Mapa de conflictos donde se guardan las claves en conflicto de la siguiente manera llave=codigoMayor-codigoMenor valor=1
	 */
	private Map<String, Integer> precalculateHomologationConflictList(List<Actablahomologacion> listaAsignaturasVig) {
		Map<String, Integer> courseConflictList = new HashMap<String, Integer>();
		for (Actablahomologacion homologacion : listaAsignaturasVig) {
			if(homologacion.getHomAsiCodPpal()>homologacion.getHomAsiCodHom()){
				String clave = homologacion.getHomAsiCodPpal()+"-"+homologacion.getHomAsiCodHom();
				courseConflictList.put(clave, 1);
			}
		}
		return courseConflictList;
	}

	
	
	 private void agregarConflicto(Map<String, Integer> courseConflictList, Long courseone, Long coursetwo, Integer pesoConflicto){		 
		 String key=(courseone<coursetwo?courseone+"-"+coursetwo:coursetwo+"-"+courseone);
		 if(!courseConflictList.containsKey(key)){
			 courseConflictList.put(key, pesoConflicto);
		 }
	 }



	public ControlService getControlService() {
		return controlService;
	}

	public void setControlService(ControlService controlService) {
		this.controlService = controlService;
	}

	public CursosService getCursosService() {
		return cursosService;
	}

	public void setCursosService(CursosService cursosService) {
		this.cursosService = cursosService;
	}

	public EstudiantesService getEstudiantesService() {
		return estudiantesService;
	}

	public void setEstudiantesService(EstudiantesService estudiantesService) {
		this.estudiantesService = estudiantesService;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public Integer getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Integer periodo) {
		this.periodo = periodo;
	}

	public Long getCodCarrera() {
		return codCarrera;
	}

	public void setCodCarrera(Long codCarrera) {
		this.codCarrera = codCarrera;
	}

	public Map<String, Integer> getListaDeConflictosHomologaciones() {
		return listaDeConflictosHomologaciones;
	}

	public void setListaDeConflictosHomologaciones(Map<String, Integer> listaDeConflictosHomologaciones) {
		this.listaDeConflictosHomologaciones = listaDeConflictosHomologaciones;
	}

	 
	 
	 

}
