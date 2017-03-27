package co.edu.udistrital.sga.preinscripcion.auto.domain;


import co.edu.udistrital.sga.preinscripcion.auto.common.domain.AbstractPersistable;
import lombok.Data;
import co.edu.udistrital.sga.preinscripcion.auto.common.domain.AbstractPersistable;

/**
 * @author Alexander
 * @version 1.0
 * @created 07-feb.-2017 15:56:30
 * fact de listado de asignaturas
 */
@Data
public class AsignaturaRequerida extends AbstractPersistable {

	private Asignatura asignatura;
	private String estado;	
	private Integer periodo;
	private Integer anio;
	private Long codigoEstudiante;
	

	public AsignaturaRequerida(Integer creditos, Long codigoAsignatura, String estado, Integer periodo, Integer anio,
			Long codigoEstudiante) {
		super();		
		this.asignatura = new Asignatura(creditos,codigoAsignatura);	
		this.estado = estado;
		this.periodo = periodo;
		this.anio = anio;
		this.codigoEstudiante = codigoEstudiante;
	}

	
	
	
}