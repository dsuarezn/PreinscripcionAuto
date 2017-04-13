package co.edu.udistrital.sga.preinscripcion.auto.drools.ext;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.kie.api.runtime.rule.AccumulateFunction;

import co.edu.udistrital.sga.preinscripcion.auto.domain.Horario;
import co.edu.udistrital.sga.preinscripcion.auto.domain.IntervaloDeTiempo;

public class HorariosScoreAcumulateFunction implements AccumulateFunction {

	protected static class HorariosScoreData implements Serializable{
	        public Map<String, List<Integer>> horariosUsados = null;
	      
	}
	
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub

	}

	@Override
	public void accumulate(Serializable context, Object value) {
		List<Horario> listahorarios=(List<Horario>)value;
		HorariosScoreData data = (HorariosScoreData) context;		
		for (Horario horario : listahorarios) {
			List<Integer> listadoEnteros=data.horariosUsados.get(horario.getDiaSemana().getNombreDia());
			if(listadoEnteros==null){listadoEnteros=new ArrayList<>();}
			for (IntervaloDeTiempo intervalo : horario.m_Franjas) {
				listadoEnteros.add(intervalo.getHora24Entera());
			}
			listadoEnteros.sort((p1, p2) -> p1.compareTo(p2));
			data.horariosUsados.put(horario.getDiaSemana().getNombreDia(), listadoEnteros);
		}		
	}

	@Override
	public Serializable createContext() {
		return new HorariosScoreData();
	}

	@Override
	public Object getResult(Serializable context) throws Exception {
		HorariosScoreData data = (HorariosScoreData) context;
		Integer scoreNegativoAcumulado=0;
		for (Map.Entry<String, List<Integer>> entry : data.horariosUsados.entrySet())
		{
		    scoreNegativoAcumulado+=carcularScoreNegativo(entry.getValue());
		}
		return scoreNegativoAcumulado;
	}

	@Override
	public Class<?> getResultType() {
		return null;
	}

	@Override
	public void init(Serializable context) throws Exception {
		HorariosScoreData data = (HorariosScoreData) context;
	}

	@Override
	public void reverse(Serializable arg0, Object arg1) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean supportsReverse() {
		// TODO Auto-generated method stub
		return false;
	}
	
	private Integer carcularScoreNegativo(List<Integer> espacios)
	{
		Integer valorIteracion=espacios.get(0);
		Integer conteo=0;
		for(int iterador=1;iterador<espacios.size();iterador++){
			Integer conteoInterno=0;
			if(!espacios.get(iterador).equals(valorIteracion+1)){
				conteoInterno=espacios.get(iterador)-(valorIteracion+1);
				conteo+=conteoInterno;
			}
			valorIteracion+=conteoInterno+1;
		}
		return conteo;
	}

	@Test
	public void test(){
		List<Integer> lista=new ArrayList<>();
		lista.add(6);

		lista.add(18);
		System.out.println("calculo:"+carcularScoreNegativo(lista));
	}
	
}
