package co.edu.udistrital.sga.preinscripcion.auto.domain;

import java.util.List;

import co.edu.udistrital.sga.preinscripcion.auto.common.domain.AbstractPersistable;

/**
 * @author Alexander
 * @version 1.0
 * @created 07-feb.-2017 15:56:31
 * facts de grupos generados con materias
 */
public class Grupo extends AbstractPersistable {

	private Integer anio;
	private Long codigo;
	private List<AsignaturaGrupo> m_AsignaturaGrupo;
	private ProyectoCurricular m_ProyectoCurricular;
	private Integer periodo;
	private Long codigoGrupo;	
	
	

	public Grupo(){

	}

	/**
	 * 
	 * @exception Throwable Throwable
	 */
	public void finalize()
	  throws Throwable{

	}

	public Integer getanio(){
		return anio;
	}

	public Long getcodigo(){
		return codigo;
	}

	public Integer getperiodo(){
		return periodo;
	}

	public ProyectoCurricular getProyectoCurricular(){
		return m_ProyectoCurricular;
	}

	/**
	 * 
	 * @param newVal    newVal
	 */
	public void setanio(Integer newVal){
		anio = newVal;
	}

	/**
	 * 
	 * @param newVal    newVal
	 */
	public void setcodigo(Long newVal){
		codigo = newVal;
	}

	/**
	 * 
	 * @param newVal    newVal
	 */
	public void setperiodo(Integer newVal){
		periodo = newVal;
	}

	/**
	 * 
	 * @param newVal    newVal
	 */
	public void setProyectoCurricular(ProyectoCurricular newVal){
		m_ProyectoCurricular = newVal;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public List<AsignaturaGrupo> getM_AsignaturaGrupo() {
		return m_AsignaturaGrupo;
	}

	public void setM_AsignaturaGrupo(List<AsignaturaGrupo> m_AsignaturaGrupo) {
		this.m_AsignaturaGrupo = m_AsignaturaGrupo;
	}

	public ProyectoCurricular getM_ProyectoCurricular() {
		return m_ProyectoCurricular;
	}

	public void setM_ProyectoCurricular(ProyectoCurricular m_ProyectoCurricular) {
		this.m_ProyectoCurricular = m_ProyectoCurricular;
	}

	public Integer getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Integer periodo) {
		this.periodo = periodo;
	}

	public Long getCodigoGrupo() {
		return codigoGrupo;
	}

	public void setCodigoGrupo(Long codigoGrupo) {
		this.codigoGrupo = codigoGrupo;
	}
	
	

}