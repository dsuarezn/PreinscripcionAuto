package co.edu.udistrital.sga.preinscripcion.auto.domain;


import co.edu.udistrital.sga.preinscripcion.auto.common.domain.AbstractPersistable;
import lombok.Data;

import java.util.List;


/**
 * @author Alexander
 * @version 1.0
 * @created 07-feb.-2017 15:56:30
 * fact asignaturas por grupos generadas
 */
@Data
public class AsignaturaGrupo extends AbstractPersistable {
	
	private Long idAsignaturaGrupo;
	private Asignatura asignatura;
	private Long codigoAsignatura;
	private Integer cupos;	
	private Integer inscritos;
	private Integer capacidadMaxima;
	private List<Horario> horario;
	private Ubicacion ubicacion;
	private Long codigoUbicacion;
	private Long codigoGrupo;
	

	public AsignaturaGrupo(){

	}

	public AsignaturaGrupo(Long idAsignaturaGrupo, Long codigoAsignatura, Integer cupos, Integer inscritos,
			Integer capacidadMaxima, Long codigoUbicacion, Long codigoGrupo) {
		super();
		this.idAsignaturaGrupo = idAsignaturaGrupo;
		this.codigoAsignatura = codigoAsignatura;
		this.cupos = cupos;
		this.inscritos = inscritos;
		this.capacidadMaxima = capacidadMaxima;
	
		this.codigoUbicacion = codigoUbicacion;
		this.codigoGrupo = codigoGrupo;
	}



	
	

}