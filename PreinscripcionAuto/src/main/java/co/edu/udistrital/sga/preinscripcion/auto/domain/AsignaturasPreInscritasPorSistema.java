package co.edu.udistrital.sga.preinscripcion.auto.domain;

import java.util.List;

import co.edu.udistrital.sga.preinscripcion.auto.common.domain.AbstractPersistable;

/**
 * @author Alexander
 * @version 1.0
 * @created 07-feb.-2017 15:56:30
 * Asignaturas Programadas fact class
 */
public class AsignaturasPreInscritasPorSistema extends AbstractPersistable {

	private Integer anio;
	private List<AsignaturaRequerida> asignaturasSolicitadas;
	private Integer periodo;	

	public AsignaturasPreInscritasPorSistema(){

	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public Integer getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Integer periodo) {
		this.periodo = periodo;
	}

	public List<AsignaturaRequerida> getAsignaturasSolicitadas() {
		return asignaturasSolicitadas;
	}

	public void setAsignaturasSolicitadas(List<AsignaturaRequerida> asignaturasSolicitadas) {
		this.asignaturasSolicitadas = asignaturasSolicitadas;
	}

	


}