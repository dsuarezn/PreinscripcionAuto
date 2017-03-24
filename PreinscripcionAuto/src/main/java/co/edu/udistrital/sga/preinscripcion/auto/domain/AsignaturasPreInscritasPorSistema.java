package co.edu.udistrital.sga.preinscripcion.auto.domain;

import java.util.List;

import co.edu.udistrital.sga.preinscripcion.auto.common.domain.AbstractPersistable;
import lombok.Data;

/**
 * @author Alexander
 * @version 1.0
 * @created 07-feb.-2017 15:56:30
 * Asignaturas Programadas fact class
 */
@Data
public class AsignaturasPreInscritasPorSistema extends AbstractPersistable {

	private Integer anio;
	private List<AsignaturaRequerida> asignaturasSolicitadas;
	private Integer periodo;	

	public AsignaturasPreInscritasPorSistema(){

	}

	

}