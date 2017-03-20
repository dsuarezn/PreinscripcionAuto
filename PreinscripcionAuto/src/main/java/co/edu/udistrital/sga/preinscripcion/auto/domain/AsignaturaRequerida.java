package co.edu.udistrital.sga.preinscripcion.auto.domain;


import co.edu.udistrital.sga.preinscripcion.auto.common.domain.AbstractPersistable;
import co.edu.udistrital.sga.preinscripcion.auto.common.domain.AbstractPersistable;

/**
 * @author Alexander
 * @version 1.0
 * @created 07-feb.-2017 15:56:30
 * fact de listado de asignaturas
 */
public class AsignaturaRequerida extends AbstractPersistable {

	private Asignatura asignatura;
	private String estado;	
	

	public AsignaturaRequerida(){

	}

	public void finalize() throws Throwable {

	}

	public Asignatura getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
	
}