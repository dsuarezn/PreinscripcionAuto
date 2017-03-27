package co.edu.udistrital.sga.preinscripcion.auto.domain;


import co.edu.udistrital.sga.preinscripcion.auto.common.domain.AbstractPersistable;
import lombok.Data;

import java.util.List;


/**
 * @author Alexander
 * @version 1.0
 * @created 07-feb.-2017 15:56:30
 * fact asignaturas por grupos generadas
 */
@Data //Se comenta el data debido a que no funcionan los gets al devolverlos por restcontroller
public class AsignaturaGrupo extends AbstractPersistable {
	
	private Long idAsignaturaGrupo;
	private Asignatura asignatura;
	private Long codigoAsignatura;
	private Integer cupos;	
	private Integer inscritos;
	private Integer capacidadMaxima;
	private List<Horario> horario;
	private Ubicacion ubicacion;
	private Long codigoUbicacion;
	private Long codigoGrupo;
	

	public AsignaturaGrupo(){

	}

	public AsignaturaGrupo(Long idAsignaturaGrupo, Long codigoAsignatura, Integer cupos, Integer inscritos,
			Integer capacidadMaxima, Long codigoUbicacion, Long codigoGrupo) {
		super();
		this.idAsignaturaGrupo = idAsignaturaGrupo;
		this.codigoAsignatura = codigoAsignatura;
		this.cupos = cupos;
		this.inscritos = inscritos;
		this.capacidadMaxima = capacidadMaxima;
	
		this.codigoUbicacion = codigoUbicacion;
		this.codigoGrupo = codigoGrupo;
		
	}

	public Long getIdAsignaturaGrupo() {
		return idAsignaturaGrupo;
	}

	public void setIdAsignaturaGrupo(Long idAsignaturaGrupo) {
		this.idAsignaturaGrupo = idAsignaturaGrupo;
	}

	public Asignatura getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}

	public Long getCodigoAsignatura() {
		return codigoAsignatura;
	}

	public void setCodigoAsignatura(Long codigoAsignatura) {
		this.codigoAsignatura = codigoAsignatura;
	}

	public Integer getCupos() {
		return cupos;
	}

	public void setCupos(Integer cupos) {
		this.cupos = cupos;
	}

	public Integer getInscritos() {
		return inscritos;
	}

	public void setInscritos(Integer inscritos) {
		this.inscritos = inscritos;
	}

	public Integer getCapacidadMaxima() {
		return capacidadMaxima;
	}

	public void setCapacidadMaxima(Integer capacidadMaxima) {
		this.capacidadMaxima = capacidadMaxima;
	}

	public List<Horario> getHorario() {
		return horario;
	}

	public void setHorario(List<Horario> horario) {
		this.horario = horario;
	}

	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Long getCodigoUbicacion() {
		return codigoUbicacion;
	}

	public void setCodigoUbicacion(Long codigoUbicacion) {
		this.codigoUbicacion = codigoUbicacion;
	}

	public Long getCodigoGrupo() {
		return codigoGrupo;
	}

	public void setCodigoGrupo(Long codigoGrupo) {
		this.codigoGrupo = codigoGrupo;
	}

	
	

	
	

}