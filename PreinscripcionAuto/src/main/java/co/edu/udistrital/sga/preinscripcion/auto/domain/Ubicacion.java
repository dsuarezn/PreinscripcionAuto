package co.edu.udistrital.sga.preinscripcion.auto.domain;

import co.edu.udistrital.sga.preinscripcion.auto.common.domain.AbstractPersistable;
import lombok.Data;

/**
 * @author Alexander
 * @version 1.0
 * @created 07-feb.-2017 15:56:30
 * fact ubicacion
 */
@Data
public class Ubicacion extends AbstractPersistable {

	private Long idUbicacion;
	private String sede;
	private String bloque_edificio;
	private String salon;
	
	
	
	
	
	
}
