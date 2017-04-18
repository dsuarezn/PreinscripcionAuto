package co.edu.udistrital.sga.preinscripcion.auto.domain;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import co.edu.udistrital.sga.preinscripcion.auto.common.domain.AbstractPersistable;
import lombok.Data;


/**
 * @author Alexander
 * @version 1.0
 * @created 07-feb.-2017 15:56:31
 */
@Data
//@XStreamAlias("PlanDeEstudios")
public class PlanDeEstudios extends AbstractPersistable {

	private String nombrePlanEstudios;
	private List<Pensum> m_Pensum;

	public PlanDeEstudios(){

	}

}