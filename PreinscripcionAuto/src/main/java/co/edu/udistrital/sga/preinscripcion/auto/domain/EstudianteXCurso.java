package co.edu.udistrital.sga.preinscripcion.auto.domain;

import java.util.ArrayList;
import java.util.List;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

import co.edu.udistrital.sga.preinscripcion.auto.common.domain.AbstractPersistable;

@PlanningEntity
//@XStreamAlias("ProgramacionEstudiante")
public class EstudianteXCurso extends AbstractPersistable {

	private Estudiante estudiante;
	private AsignaturaGrupo curso;
	private List<Problema> listaProblemas;
	
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
	
	@PlanningVariable(valueRangeProviderRefs = {"rangoAsignaturas"}, nullable = true)
//	@PlanningVariable(valueRangeProviderRefs = {"rangoAsignaturas"})
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
	
	public Long getIdAsignaturaGrupo(){
		return curso.getIdAsignaturaGrupo();
	}
	
	public Long getCodigoAsignatura(){
		return curso.getCodigoAsignatura();
	}
	
	public Long getCodigoCarreraAsignatura(){
		return curso.getCodCarrera();
	}
	
	public Long getEstudianteCodigo(){
		return estudiante.getCodigo();
	}
	
	public List<Long> getListaCodigosPorDemanda(){
		return estudiante.getListaCodigosPorDemanda();
		
	}
	
	public void addProblem(String regla, Object...listaObjetos ){
		if(listaProblemas==null){
			listaProblemas=new ArrayList<>();
		}
		Problema problema=new Problema(regla, listaObjetos);
	}
	
	public Integer getCreditos(){
		return curso.getCreditos();
		
	}
	
	public Integer getCupos(){
		return curso.getCupos();
	}
	
	public List<Horario> getHorarios(){
		return curso.getHorarios();
	}
	
	public Integer getRanking(){
		return curso.getRanking();
	}
	
}
