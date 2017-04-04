package co.edu.udistrital.sga.preinscripcion.auto.domain;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import co.edu.udistrital.sga.preinscripcion.auto.common.domain.AbstractPersistable;
import lombok.Data;


/**
 * @author Alexander
 * @version 1.0
 * @created 07-feb.-2017 15:56:31
 */
@Data
@XStreamAlias("Horario")
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


}