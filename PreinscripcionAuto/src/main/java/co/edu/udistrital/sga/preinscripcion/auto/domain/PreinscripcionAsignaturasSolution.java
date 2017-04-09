package co.edu.udistrital.sga.preinscripcion.auto.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.Solution;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.impl.score.buildin.hardsoft.HardSoftScoreDefinition;
import org.optaplanner.persistence.xstream.impl.score.XStreamScoreConverter;
import org.springframework.beans.factory.annotation.Autowired;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;

import co.edu.udistrital.sga.preinscripcion.auto.services.CursosService;
import co.edu.udistrital.sga.preinscripcion.auto.services.EstudiantesService;
import co.edu.udistrital.sga.preinscripcion.auto.services.ProyectoService;

@PlanningSolution
@XStreamAlias("PreinscripcionAsignaturasSolution")
public class PreinscripcionAsignaturasSolution implements Solution<HardSoftScore> {

	@Autowired
    private ProyectoService proyectoService;
	@Autowired
    private CursosService cursosService;
	@Autowired
    private EstudiantesService estudiantesService;

	
	/***
	 * Listas de hechos
	 * A continuación estan las listas de echos del problema de planificacion
	 */	
	private List<AsignaturaGrupo> listaAsignaturasVigentes;
	private List<Estudiante> listaEstudiantesActivos;
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
	}
	
	public void establecerAsignaturasPorDemanda(List<Estudiante> listaEstudiantes, List<AsignaturaRequerida> listaAsignaturasPorDemanda){
		for (Estudiante estudiante : listaEstudiantes) {
			estudiante.setPreinscripcionPorDemanda(listaAsignaturasPorDemanda.stream().filter(est -> estudiante.getCodigo().equals(est.getCodigoEstudiante())).collect(Collectors.toList()));             
		}
	}
	public void establecerAsignaturasPosibles(List<Estudiante> listaEstudiantes, List<AsignaturaGrupo> listaAsignaturasProgramadas){
		for (Estudiante estudiante : listaEstudiantes) {
			List<Long> listaCodigosAsignaturas=estudiante.getPreinscripcionPorDemanda().stream().map(AsignaturaRequerida::getCodigoAsignatura).collect(Collectors.toList());
			List<AsignaturaGrupo> listaAsignaturasPermitidas=listaAsignaturasProgramadas.stream().filter(e->listaCodigosAsignaturas.contains(e.getCodigoAsignatura())).collect(Collectors.toList());
			estudiante.setAsignaturasPosibles(listaAsignaturasPermitidas);
		}
	}
	

}
