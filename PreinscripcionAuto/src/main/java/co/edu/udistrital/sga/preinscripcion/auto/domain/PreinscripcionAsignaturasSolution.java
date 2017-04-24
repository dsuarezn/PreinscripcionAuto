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

import co.edu.udistrital.sga.preinscripcion.auto.services.CursosService;
import co.edu.udistrital.sga.preinscripcion.auto.services.EstudiantesService;
import co.edu.udistrital.sga.preinscripcion.auto.services.ProyectoService;


@PlanningSolution
//@XStreamAlias("PreinscripcionAsignaturasSolution")
public class PreinscripcionAsignaturasSolution implements Solution<HardSoftScore> {

//	@Autowired
    private ProyectoService proyectoService;
//	@Autowired
    private CursosService cursosService;
//	@Autowired
    private EstudiantesService estudiantesService;

    public PreinscripcionAsignaturasSolution(){
    	
    }

	public PreinscripcionAsignaturasSolution(ProyectoService proyectoService, CursosService cursosService,
			EstudiantesService estudiantesService) {
		super();
		this.proyectoService = proyectoService;
		this.cursosService = cursosService;
		this.estudiantesService = estudiantesService;
	}

	/***
	 * Listas de hechos
	 * A continuación estan las listas de echos del problema de planificacion
	 */	
//	private List<AsignaturaGrupo> listaAsignaturasVigentes;
	private List<Estudiante> listaEstudiantesActivos;
	private Map<String, Integer> listaDeConflictos;
//	private List<AsignaturaRequerida> listaAsignaturasPorDemanda;

	
	private List<EstudianteXCurso> listaProgramacionEstudiantes;
	 
//	@XStreamConverter(value = XStreamScoreConverter.class, types = {HardSoftScoreDefinition.class})
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
//        facts.add(listaEstudiantesActivos);
//        facts.add(listaAsignaturasVigentes);
        facts.add(this.listaDeConflictos);
        facts.add(this.listaEstudiantesActivos);
        return facts;
	}
	
	


//	public List<AsignaturaGrupo> getListaAsignaturasVigentes() {
//		return listaAsignaturasVigentes;
//	}
//
//	public void setListaAsignaturasVigentes(List<AsignaturaGrupo> listaAsignaturasVigentes) {
//		this.listaAsignaturasVigentes = listaAsignaturasVigentes;
//	}

	
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

	
	
	@PlanningEntityCollectionProperty
	public List<EstudianteXCurso> getListaProgramacionEstudiantes() {
		
		return listaProgramacionEstudiantes;
	}

	public void setListaProgramacionEstudiantes(List<EstudianteXCurso> listaProgramacionEstudiantes) {
		this.listaProgramacionEstudiantes = listaProgramacionEstudiantes;
	}

	public void initFacts(Integer anio, Integer periodo, Long codCarrera){
		List<AsignaturaGrupo> listaAsignaturasVigentes = new ArrayList<>();
		List<AsignaturaRequerida> listaAsignaturasPorDemanda=new ArrayList<>();
		this.listaEstudiantesActivos=estudiantesService.obtenerListaEstudiantes();
		listaAsignaturasPorDemanda=cursosService.obtenerListaMateriasPreinsDemanda(anio, periodo, codCarrera,"%A%");		
		listaAsignaturasVigentes=cursosService.obtenerCursosProgramados(anio, periodo, codCarrera);	
		listaAsignaturasVigentes=removerAsignaturasSinHorario(listaAsignaturasVigentes);
		establecerAsignaturasPorDemanda(listaEstudiantesActivos, listaAsignaturasPorDemanda);
		establecerAsignaturasPosibles(listaEstudiantesActivos,listaAsignaturasVigentes);
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
	
	public List<AsignaturaGrupo> removerAsignaturasSinHorario(List<AsignaturaGrupo> listaTotalAsignaturas){
		return listaTotalAsignaturas.stream().filter(e->e.getHorarios()!=null).filter(e->e.getHorarios().size()>0).collect(Collectors.toList());
	}
	
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
	public void establecerAsignaturasPosibles(List<Estudiante> listaEstudiantes, List<AsignaturaGrupo> listaAsignaturasProgramadas){
		for (Estudiante estudiante : listaEstudiantes) {			
			
			List<AsignaturaRequerida> listaCodigosAsigxDemanda=estudiante.getPreinscripcionPorDemanda();	
			List<AsignaturaGrupo> listaAsignaturasPermitidas = new ArrayList<>();
			for (AsignaturaRequerida asignaturaRequerida : listaCodigosAsigxDemanda) 
			{
				List<AsignaturaGrupo> listaTemporalAsignaturas=listaAsignaturasProgramadas.stream().filter(e->asignaturaRequerida.getCodigoAsignatura().equals(e.getCodigoAsignatura())).collect(Collectors.toList());
				listaTemporalAsignaturas.stream().forEach(f->f.setCreditosOptional(listaCodigosAsigxDemanda.stream().filter(a->a.getCodigoAsignatura().equals(f.getCodigoAsignatura())).map(AsignaturaRequerida::getCreditos).findFirst()));							
				listaAsignaturasPermitidas.addAll(listaTemporalAsignaturas);
			}			
			estudiante.setAsignaturasPosibles(listaAsignaturasPermitidas);
		}
	}
	
	public List<AsignaturaGrupo> establecerCreditosAsignaturas(List<AsignaturaRequerida> listaAsignaturasDemanda, List<AsignaturaGrupo> listaAsignaturasProg){
		return null;
	}

	
//	 private List<ConflictoCursos> precalculateCourseConflictList(List<AsignaturaGrupo> listaAsignaturasVig) {
//	        Map<String, ConflictoCursos> courseConflictList = new HashMap<String, ConflictoCursos>();
//	        for (AsignaturaGrupo leftCourse : listaAsignaturasVig) {
//	            for (AsignaturaGrupo rightCourse : listaAsignaturasVig) {
//	                if (leftCourse.getIdAsignaturaGrupo() != rightCourse.getIdAsignaturaGrupo()) {
//	                	int conflictCount = 0;	                  	                 	                    
//	                    for (Horario horizq : leftCourse.getHorarios()) {
//	                    	for (Horario horder : rightCourse.getHorarios()) {
//								if(horizq.cruze(horder)){
//									conflictCount++;
//								}
//							}
//						}	     
//	                    if(conflictCount>0){
//	                    	agregarConflicto(courseConflictList, new ConflictoCursos(leftCourse, rightCourse, conflictCount));
//	                    }	                   	                   
//	                }
//	            }
//	        }	        	        	        
//	        return new ArrayList<ConflictoCursos>(courseConflictList.values());
//	    }
//	

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

	
	
	 private void agregarConflicto(Map<String, Integer> courseConflictList, Long courseone, Long coursetwo, Integer pesoConflicto){		 
		 String key=(courseone<coursetwo?courseone+"-"+coursetwo:coursetwo+"-"+courseone);
		 if(!courseConflictList.containsKey(key)){
//			 Integer conflicto = courseConflictList.get(key);
			 courseConflictList.put(key, pesoConflicto);
		 }
	 }

	public ProyectoService getProyectoService() {
		return proyectoService;
	}

	public void setProyectoService(ProyectoService proyectoService) {
		this.proyectoService = proyectoService;
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

	 
	 
	 

}
