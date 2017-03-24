package co.edu.udistrital.sga.preinscripcion.auto.domain;

import co.edu.udistrital.sga.preinscripcion.auto.common.domain.AbstractPersistable;
import lombok.Data;

/**
 * @author Alexander
 * @version 1.0
 * @created 07-feb.-2017 15:56:31
 * fact de proyectos curriculares
 */
@Data
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

	/**
	 * 
	 * @exception Throwable Throwable
	 */
	public void finalize()
	  throws Throwable{

	}

	public Long getcodigoProyecto(){
		return codigoProyecto;
	}

	public String getnombreProyecto(){
		return nombreProyecto;
	}

	/**
	 * 
	 * @param newVal    newVal
	 */
	public void setcodigoProyecto(Long newVal){
		codigoProyecto = newVal;
	}

	/**
	 * 
	 * @param newVal    newVal
	 */
	public void setnombreProyecto(String newVal){
		nombreProyecto = newVal;
	}

}