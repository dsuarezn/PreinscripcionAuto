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

	private Integer anioIngreso;
	private AsignaturasPreInscritasPorDemanda preinscripcionPorDemanda;
	private AsignaturasPreInscritasPorSistema preinscripcionPorSistema;
	private Long codigo;
	private Pensum m_Pensum;
	private ProyectoCurricular m_ProyectoCurricular;
	private String nombre;
	
//	private Integer periodoIngreso;
//	private Integer creditosMaximosPorPeriodo;
//	
	

	public Estudiante(){

	}


	
}