package co.edu.udistrital.sga.preinscripcion.auto.domain;

import co.edu.udistrital.sga.preinscripcion.auto.common.domain.AbstractPersistable;
import lombok.Data;

/**
 * @author Alexander
 * @version 1.0
 * @created 07-feb.-2017 15:56:31
 * fact de proyectos curriculares
 */
//@Data //Se comenta el data debido a que no funcionan los gets al devolverlos por restcontroller
public class ProyectoCurricular extends AbstractPersistable {

	private Long codigoProyecto;
	//public PlanDeEstudios m_PlanDeEstudios;
	private String nombreProyecto;
	
	public ProyectoCurricular(Long codigoProyecto, String nombreProyecto) {
		super();
		this.codigoProyecto = codigoProyecto;
		this.nombreProyecto = nombreProyecto;
	}

	public ProyectoCurricular(){

	}

	public Long getCodigoProyecto() {
		return codigoProyecto;
	}

	public void setCodigoProyecto(Long codigoProyecto) {
		this.codigoProyecto = codigoProyecto;
	}

	public String getNombreProyecto() {
		return nombreProyecto;
	}

	public void setNombreProyecto(String nombreProyecto) {
		this.nombreProyecto = nombreProyecto;
	}

	


}