package co.edu.udistrital.sga.preinscripcion.auto.domain;

import co.edu.udistrital.sga.preinscripcion.auto.common.domain.AbstractPersistable;
import lombok.Data;

/**
 * @author Alexander
 * @version 1.0
 * @created 07-feb.-2017 15:56:29
 * Asignatura fact class
 */
@Data
public class Asignatura extends AbstractPersistable {

	private Integer creditos;
	private Long codigoAsignatura;
	private String nombreAsignatura;
	

	public Asignatura(){

	}

	public Asignatura(Integer creditos, Long codigoAsignatura) {
		super();
		this.creditos = creditos;
		this.codigoAsignatura = codigoAsignatura;		
	}

	public Integer getCreditos() {
		return creditos;
	}

	public void setCreditos(Integer creditos) {
		this.creditos = creditos;
	}

	public Long getCodigoAsignatura() {
		return codigoAsignatura;
	}

	public void setCodigoAsignatura(Long codigoAsignatura) {
		this.codigoAsignatura = codigoAsignatura;
	}

	public String getNombreAsignatura() {
		return nombreAsignatura;
	}

	public void setNombreAsignatura(String nombreAsignatura) {
		this.nombreAsignatura = nombreAsignatura;
	}

	
	

}