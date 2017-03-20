package co.edu.udistrital.sga.preinscripcion.auto.domain;

import java.util.ArrayList;
import java.util.List;

import co.edu.udistrital.sga.preinscripcion.auto.common.domain.AbstractPersistable;


/**
 * @author Alexander
 * @version 1.0
 * @created 07-feb.-2017 15:56:31
 */
public class Horario extends AbstractPersistable {

	private DiasSemana diaSemana;
	public List<IntervaloDeTiempo> m_Franjas;

	public Horario(DiasSemana dia, IntervaloDeTiempo ... deTiempos ){
		this.diaSemana=dia;
		this.m_Franjas=new ArrayList<IntervaloDeTiempo>();
		for (IntervaloDeTiempo intervaloDeTiempo : deTiempos) {
			m_Franjas.add(intervaloDeTiempo);
		}
	}

	/**
	 * 
	 * @exception Throwable Throwable
	 */
	public void finalize()
	  throws Throwable{

	}

	public DiasSemana getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(DiasSemana diaSemana) {
		this.diaSemana = diaSemana;
	}

	public List<IntervaloDeTiempo> getM_Franjas() {
		return m_Franjas;
	}

	public void setM_Franjas(List<IntervaloDeTiempo> m_Franjas) {
		this.m_Franjas = m_Franjas;
	}



}