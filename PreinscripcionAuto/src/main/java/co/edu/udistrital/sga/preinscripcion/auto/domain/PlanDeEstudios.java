package co.edu.udistrital.sga.preinscripcion.auto.domain;

import java.util.List;

import co.edu.udistrital.sga.preinscripcion.auto.common.domain.AbstractPersistable;


/**
 * @author Alexander
 * @version 1.0
 * @created 07-feb.-2017 15:56:31
 */
public class PlanDeEstudios extends AbstractPersistable {

	private String nombrePlanEstudios;
	private List<Pensum> m_Pensum;

	public PlanDeEstudios(){

	}

	/**
	 * 
	 * @exception Throwable Throwable
	 */
	public void finalize()
	  throws Throwable{

	}

	public List<Pensum> getPensum(){
		return m_Pensum;
	}

	/**
	 * 
	 * @param newVal    newVal
	 */
	public void setPensum(List<Pensum> newVal){
		m_Pensum = newVal;
	}

}