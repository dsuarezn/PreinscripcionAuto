package co.edu.udistrital.sga.preinscripcion.auto.domain;

import lombok.Data;

/**
 * @author Alexander
 * @version 1.0
 * @created 07-feb.-2017 15:56:31
 * fact de proyectos curriculares
 */
@Data //Se comenta el data debido a que no funcionan los gets al devolverlos por restcontroller
//@XStreamAlias("ProyectoCurricular")
public class ProyectoCurricular{

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



}