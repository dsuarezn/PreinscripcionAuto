package co.edu.udistrital.sga.preinscripcion.auto.domain;


import lombok.Data;

/**
 * @author Alexander
 * @version 1.0
 * @created 07-feb.-2017 15:56:30
 * fact de listado de asignaturas
 */
@Data
//@XStreamAlias("AsignaturaRequerida")
public class AsignaturaRequerida  {

	//private Asignatura asignatura;
	private String estado;	
	private Integer periodo;
	private Integer anio;
	private Long codigoEstudiante;
	private Long codigoAsignatura;
	private Integer creditos;
	private Integer semestre;
	private Integer ceaCode;
	

	public AsignaturaRequerida(Integer creditos, Long codigoAsignatura, String estado, Integer periodo, Integer anio,
			Long codigoEstudiante, Integer semestre, Integer ceaCode) {
		super();		
		//this.asignatura = new Asignatura(creditos,codigoAsignatura);	
		this.estado = estado;
		this.periodo = periodo;
		this.anio = anio;
		this.codigoEstudiante = codigoEstudiante;
		this.codigoAsignatura=codigoAsignatura;
		this.creditos=creditos;	
		this.semestre=semestre;
		this.ceaCode=ceaCode;
	}

	
	
	
}