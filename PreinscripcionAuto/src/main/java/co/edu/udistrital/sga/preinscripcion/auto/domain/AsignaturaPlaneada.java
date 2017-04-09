package co.edu.udistrital.sga.preinscripcion.auto.domain;


import co.edu.udistrital.sga.preinscripcion.auto.common.domain.AbstractPersistable;
import lombok.Data;

import java.util.List;

import org.optaplanner.core.api.domain.variable.PlanningVariable;

import com.thoughtworks.xstream.annotations.XStreamAlias;


/**
 * @author Alexander
 * @version 1.0
 * @created 07-feb.-2017 15:56:30
 * fact asignaturas por grupos generadas
 */
@Data 
@XStreamAlias("AsignaturaGrupo")
public class AsignaturaPlaneada extends AbstractPersistable {
	
	@PlanningVariable(valueRangeProviderRefs= {"rowRange"})
	private AsignaturaGrupo asignaturaGrupo;
	
	private Estudiante estudiante;

	public AsignaturaPlaneada(Estudiante estudiante){
		this.estudiante=estudiante;
	}
	
	
}