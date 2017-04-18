package co.edu.udistrital.sga.preinscripcion.auto.domain;

import java.util.List;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import co.edu.udistrital.sga.preinscripcion.auto.common.domain.AbstractPersistable;

@PlanningEntity
//@XStreamAlias("ProgramacionEstudiante")
public class EstudianteXCurso extends AbstractPersistable {

	private Estudiante estudiante;
	private AsignaturaGrupo curso;
	
	@PlanningVariable(valueRangeProviderRefs = {"rangoEstudiantes"})
	public Estudiante getEstudiante() {
		return estudiante;
	}
	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}
	
	@ValueRangeProvider(id = "rangoAsignaturas")
	public List<AsignaturaGrupo> getListaAsignaturasPosibles(){
		return this.estudiante.getAsignaturasPosibles();
	}
	
	@PlanningVariable(valueRangeProviderRefs = {"rangoAsignaturas"})
	public AsignaturaGrupo getCurso() {
		return this.curso;
	}
	public void setCurso(AsignaturaGrupo curso) {
		this.curso = curso;
	}
	
	@Override
	public String toString(){
		return "{"+this.estudiante+"} : {"+this.curso+"}";
	}
	
}
