package co.edu.udistrital.sga.preinscripcion.auto.domain;

import java.util.List;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import co.edu.udistrital.sga.preinscripcion.auto.common.domain.AbstractPersistable;
import lombok.Data;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @author Alexander
 * @version 1.0
 * @created 07-feb.-2017 15:56:30
 * Facts estudiante
 */
@Data
@XStreamAlias("Estudiante")
public class Estudiante extends AbstractPersistable{


	private List<AsignaturaRequerida> preinscripcionPorDemanda;
	private List<AsignaturaRequerida> preinscripcionPorSistema;
	private Long codigo;
	private Pensum m_Pensum;
	private Integer codigoPensum;
	private ProyectoCurricular m_ProyectoCurricular;
	private Long codigoProyectoCurricular;
	private String nombre;
	private Integer clasificacion;
	private String tipo;
	
//	private Integer periodoIngreso;
//	private Integer creditosMaximosPorPeriodo;
//	
	

	public Estudiante(){

	}


	
}