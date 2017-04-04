package co.edu.udistrital.sga.preinscripcion.auto.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.Solution;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.impl.score.buildin.hardsoft.HardSoftScoreDefinition;
import co.edu.udistrital.sga.preinscripcion.auto.common.domain.AbstractPersistable;
import co.edu.udistrital.sga.preinscripcion.auto.services.CursosService;
import co.edu.udistrital.sga.preinscripcion.auto.services.EstudiantesService;
import co.edu.udistrital.sga.preinscripcion.auto.services.ProyectoService;

import org.optaplanner.persistence.xstream.impl.score.XStreamScoreConverter;
import org.springframework.beans.factory.annotation.Autowired;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;

@PlanningSolution
@XStreamAlias("PreinscripcionAsignaturasSolution")
public class PreinscripcionAsignaturasSolution extends AbstractPersistable implements Solution<HardSoftScore> {

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
	
	private List<ProgramacionEstudiante> listaProgramaciónEstudiantes;
	 
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
        // Student isn't used in the DRL at the moment
        // Notice that asserting them is not a noticable performance cost, only a memory cost.
        // facts.addAll(studentList);      
    //    facts.addAll(periodPenaltyList);
    //    facts.addAll(roomPenaltyList);
        // A faster alternative to a insertLogicalTopicConflicts rule.
    //    facts.addAll(precalculateTopicConflictList());
        // Do not add the planning entity's (examList) because that will be done automatically
        return facts;
	}

	public List<AsignaturaGrupo> getListaAsignaturasVigentes() {
		return listaAsignaturasVigentes;
	}

	public void setListaAsignaturasVigentes(List<AsignaturaGrupo> listaAsignaturasVigentes) {
		this.listaAsignaturasVigentes = listaAsignaturasVigentes;
	}

	public List<Estudiante> getListaEstudiantesActivos() {
		return listaEstudiantesActivos;
	}

	public void setListaEstudiantesActivos(List<Estudiante> listaEstudiantesActivos) {
		this.listaEstudiantesActivos = listaEstudiantesActivos;
	}

	@PlanningEntityCollectionProperty
	public List<ProgramacionEstudiante> getListaProgramaciónEstudiantes() {
		return listaProgramaciónEstudiantes;
	}

	public void setListaProgramaciónEstudiantes(List<ProgramacionEstudiante> listaProgramaciónEstudiantes) {
		this.listaProgramaciónEstudiantes = listaProgramaciónEstudiantes;
	}

	
	

}
