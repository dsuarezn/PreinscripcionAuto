package co.edu.udistrital.sga.preinscripcion.auto.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.Solution;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.impl.score.buildin.hardsoft.HardSoftScoreDefinition;
import org.optaplanner.persistence.xstream.impl.score.XStreamScoreConverter;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;

import co.edu.udistrital.sga.preinscripcion.auto.domain.solver.ConflictoCursos;
import co.edu.udistrital.sga.preinscripcion.auto.services.CursosService;
import co.edu.udistrital.sga.preinscripcion.auto.services.EstudiantesService;
import co.edu.udistrital.sga.preinscripcion.auto.services.ProyectoService;


@PlanningSolution
@XStreamAlias("PreinscripcionAsignaturasSolution")
public class PreinscripcionAsignaturasSolution implements Solution<HardSoftScore> {

//	@Autowired
    private ProyectoService proyectoService;
//	@Autowired
    private CursosService cursosService;
//	@Autowired
    private EstudiantesService estudiantesService;

	

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
	private List<AsignaturaGrupo> listaAsignaturasVigentes;
	private List<Estudiante> listaEstudiantesActivos;
	private List<ConflictoCursos> listaDeConflictos;
	private List<AsignaturaRequerida> listaAsignaturasPorDemanda;

	
	private List<EstudianteXCurso> listaProgramaciónEstudiantes;
	 
	@XStreamConverter(value = XStreamScoreConverter.class, types = {HardSoftScoreDefinition.class})
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
        facts.add(listaEstudiantesActivos);
        facts.add(listaAsignaturasVigentes);
        return facts;
	}
	
	
	
	public List<ConflictoCursos> getListaDeConflictos() {
		return listaDeConflictos;
	}

	public void setListaDeConflictos(List<ConflictoCursos> listaDeConflictos) {
		this.listaDeConflictos = listaDeConflictos;
	}

	public List<AsignaturaGrupo> getListaAsignaturasVigentes() {
		return listaAsignaturasVigentes;
	}

	public void setListaAsignaturasVigentes(List<AsignaturaGrupo> listaAsignaturasVigentes) {
		this.listaAsignaturasVigentes = listaAsignaturasVigentes;
	}

	@ValueRangeProvider(id = "rangoEstudiantes")
	public List<Estudiante> getListaEstudiantesActivos() {
		return listaEstudiantesActivos;
	}

	public void setListaEstudiantesActivos(List<Estudiante> listaEstudiantesActivos) {
		this.listaEstudiantesActivos = listaEstudiantesActivos;
	}

	@PlanningEntityCollectionProperty
	public List<EstudianteXCurso> getListaProgramaciónEstudiantes() {
		return listaProgramaciónEstudiantes;
	}

	public void setListaProgramaciónEstudiantes(List<EstudianteXCurso> listaProgramaciónEstudiantes) {
		this.listaProgramaciónEstudiantes = listaProgramaciónEstudiantes;
	}

	public void initFacts(Integer anio, Integer periodo, Long codCarrera){
		this.listaEstudiantesActivos=estudiantesService.obtenerListaEstudiantes();
		this.listaAsignaturasVigentes=cursosService.obtenerCursosProgramados(anio, periodo, codCarrera);
		this.listaAsignaturasPorDemanda=cursosService.obtenerListaMateriasPreinsDemanda(anio, periodo, codCarrera,"%A%");
		establecerAsignaturasPorDemanda(listaEstudiantesActivos, listaAsignaturasPorDemanda);
		establecerAsignaturasPosibles(listaEstudiantesActivos,listaAsignaturasVigentes);
		this.listaDeConflictos=precalculateCourseConflictList(this.listaAsignaturasVigentes);
	}
	
	public void establecerAsignaturasPorDemanda(List<Estudiante> listaEstudiantes, List<AsignaturaRequerida> listaAsignaturasPorDemanda){
		for (Estudiante estudiante : listaEstudiantes) {
			estudiante.setPreinscripcionPorDemanda(listaAsignaturasPorDemanda.stream().filter(est -> estudiante.getCodigo().equals(est.getCodigoEstudiante())).collect(Collectors.toList()));             
		}
	}
	public void establecerAsignaturasPosibles(List<Estudiante> listaEstudiantes, List<AsignaturaGrupo> listaAsignaturasProgramadas){
		for (Estudiante estudiante : listaEstudiantes) {
			List<AsignaturaRequerida> listaCodigosAsignaturas=estudiante.getPreinscripcionPorDemanda();			
			List<AsignaturaGrupo> listaAsignaturasPermitidas=listaAsignaturasProgramadas.stream().filter(e->listaCodigosAsignaturas.contains(e.getCodigoAsignatura())).collect(Collectors.toList());
			listaAsignaturasPermitidas.stream().forEach(f->f.setCreditosOptional(listaCodigosAsignaturas.stream().filter(a->a.getCodigoAsignatura().equals(f.getCodigoAsignatura())).map(AsignaturaRequerida::getCreditos).findFirst()));			
			estudiante.setAsignaturasPosibles(listaAsignaturasPermitidas);
		}
	}

	
	 private List<ConflictoCursos> precalculateCourseConflictList(List<AsignaturaGrupo> listaAsignaturasVig) {
	        Map<String, ConflictoCursos> courseConflictList = new HashMap<String, ConflictoCursos>();
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
	                    	agregarConflicto(courseConflictList, new ConflictoCursos(leftCourse, rightCourse, conflictCount));
	                    }	                   	                   
	                }
	            }
	        }	        
	        return new ArrayList<ConflictoCursos>(courseConflictList.values());
	    }
	
	
	 private void agregarConflicto(Map<String, ConflictoCursos> courseConflictList, ConflictoCursos conflicto){
		 Long curseone=conflicto.getLeftCourse().getIdAsignaturaGrupo();
		 Long cursetwo=conflicto.getRightCourse().getIdAsignaturaGrupo();
		 String key=(curseone<cursetwo?curseone+"-"+cursetwo:cursetwo+"-"+curseone);
		 if(!courseConflictList.containsKey(key)){
			 courseConflictList.put(key, conflicto);
		 }
	 }


	 
	 

}
