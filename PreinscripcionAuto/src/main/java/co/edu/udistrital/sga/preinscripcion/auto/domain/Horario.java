package co.edu.udistrital.sga.preinscripcion.auto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import lombok.Data;


/**
 * @author Alexander
 * @version 1.0
 * @created 07-feb.-2017 15:56:31
 */
@Data
//@XStreamAlias("Horario")
public class Horario {

	private DiasSemana diaSemana;
	public List<IntervaloDeTiempo> m_Franjas;
	public List<Integer> franjasEnteras;
	
	public Horario(DiasSemana dia, List<IntervaloDeTiempo> deTiempos ){
		this.diaSemana=dia;
		this.m_Franjas=new ArrayList<IntervaloDeTiempo>();
		this.franjasEnteras=new ArrayList<Integer>();
		for (IntervaloDeTiempo intervaloDeTiempo : deTiempos) {
			m_Franjas.add(intervaloDeTiempo);
			franjasEnteras.add(intervaloDeTiempo.getHora24Entera());
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Horario other = (Horario) obj;
		if (diaSemana != other.diaSemana)
			return false;
		if (m_Franjas == null) {
			if (other.m_Franjas != null)
				return false;
		} else if (!m_Franjas.equals(other.m_Franjas))
			return false;
		return true;
	}

    public boolean cruze(Horario horario){
    	boolean haycruze=false;
    	if(this.diaSemana==horario.diaSemana){
    		List<Integer> listadoHoras=horario.getM_Franjas().stream().map(IntervaloDeTiempo::getHora24Entera).collect(Collectors.toList());
    		haycruze=m_Franjas.stream().map(IntervaloDeTiempo::getHora24Entera).anyMatch(e->listadoHoras.contains(e));
    	}
    	return haycruze;
    }
	
	public String getNombreDia(){
		return this.getDiaSemana().getNombreDia();
	}

}