package co.edu.udistrital.sga.preinscripcion.auto.domain;

import java.util.List;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;
import co.edu.udistrital.sga.preinscripcion.auto.common.domain.AbstractPersistable;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@PlanningEntity
@XStreamAlias("ProgramacionEstudiante")
public class ProgramacionEstudiante extends AbstractPersistable {

	private Estudiante estudiante;
	private List<AsignaturaGrupo> listaAsignaturas;
	
	@PlanningVariable
	public Estudiante getEstudiante() {
		return estudiante;
	}
	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}
	
	@PlanningVariable
	public List<AsignaturaGrupo> getListaAsignaturas() {
		return listaAsignaturas;
	}
	public void setListaAsignaturas(List<AsignaturaGrupo> listaAsignaturas) {
		this.listaAsignaturas = listaAsignaturas;
	}
	
	
	
}
