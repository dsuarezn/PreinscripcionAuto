package co.edu.udistrital.sga.preinscripcion.auto.domain;

import java.util.List;

import co.edu.udistrital.sga.preinscripcion.auto.common.domain.AbstractPersistable;
import lombok.Data;

/**
 * @author Alexander
 * @version 1.0
 * @created 07-feb.-2017 15:56:31
 * facts de grupos generados con materias
 */
@Data
public class Grupo extends AbstractPersistable {

	private Integer anio;
	private Long codigo;
	private List<AsignaturaGrupo> m_AsignaturaGrupo;
	private ProyectoCurricular m_ProyectoCurricular;
	private Integer periodo;
	private Long codigoGrupo;	
	
	

	public Grupo(){

	}

}