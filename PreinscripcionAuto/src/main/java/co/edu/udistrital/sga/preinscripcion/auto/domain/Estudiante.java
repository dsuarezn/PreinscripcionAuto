package co.edu.udistrital.sga.preinscripcion.auto.domain;

import java.util.List;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import co.edu.udistrital.sga.preinscripcion.auto.common.domain.AbstractPersistable;


import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @author Alexander
 * @version 1.0
 * @created 07-feb.-2017 15:56:30
 * Facts estudiante
 */
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

	

	public AsignaturasPreInscritasPorDemanda getPreinscripcionPorDemanda() {
		return preinscripcionPorDemanda;
	}



	public void setPreinscripcionPorDemanda(AsignaturasPreInscritasPorDemanda preinscripcionPorDemanda) {
		this.preinscripcionPorDemanda = preinscripcionPorDemanda;
	}



	public Integer getAnioIngreso() {
		return anioIngreso;
	}


	public void setAnioIngreso(Integer anioIngreso) {
		this.anioIngreso = anioIngreso;
	}

	

	public Long getCodigo() {
		return codigo;
	}


	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}


	public Pensum getM_Pensum() {
		return m_Pensum;
	}


	public void setM_Pensum(Pensum m_Pensum) {
		this.m_Pensum = m_Pensum;
	}


	public ProyectoCurricular getM_ProyectoCurricular() {
		return m_ProyectoCurricular;
	}


	public void setM_ProyectoCurricular(ProyectoCurricular m_ProyectoCurricular) {
		this.m_ProyectoCurricular = m_ProyectoCurricular;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}





//	public Integer getPeriodoIngreso() {
//		return periodoIngreso;
//	}
//
//
//	public void setPeriodoIngreso(Integer periodoIngreso) {
//		this.periodoIngreso = periodoIngreso;
//	}
//
//
//	public Integer getCreditosMaximosPorPeriodo() {
//		return creditosMaximosPorPeriodo;
//	}
//
//
//	public void setCreditosMaximosPorPeriodo(Integer creditosMaximosPorPeriodo) {
//		this.creditosMaximosPorPeriodo = creditosMaximosPorPeriodo;
//	}




	
}