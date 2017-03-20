package co.edu.udistrital.sga.preinscripcion.auto.domain;

import java.util.List;

import co.edu.udistrital.sga.preinscripcion.auto.common.domain.AbstractPersistable;

/**
 * @author Alexander
 * @version 1.0
 * @created 07-feb.-2017 15:56:31
 */
public class Pensum extends AbstractPersistable {

	private Integer codigoPensum;	
//	public List<AsignaturaDePensum> m_AsignaturaDePensum;
//	private String versionPensum;

	public Pensum(){

	}

	public Integer getCodigoPensum() {
		return codigoPensum;
	}

	public void setCodigoPensum(Integer codigoPensum) {
		this.codigoPensum = codigoPensum;
	}


//	public List<AsignaturaDePensum> getM_AsignaturaDePensum() {
//		return m_AsignaturaDePensum;
//	}
//
//	public void setM_AsignaturaDePensum(List<AsignaturaDePensum> m_AsignaturaDePensum) {
//		this.m_AsignaturaDePensum = m_AsignaturaDePensum;
//	}

//	public String getVersionPensum() {
//		return versionPensum;
//	}
//
//	public void setVersionPensum(String versionPensum) {
//		this.versionPensum = versionPensum;
//	}

	

}