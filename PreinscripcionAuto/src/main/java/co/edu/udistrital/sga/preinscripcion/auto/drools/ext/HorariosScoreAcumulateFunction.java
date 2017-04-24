package co.edu.udistrital.sga.preinscripcion.auto.drools.ext;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.kie.api.runtime.rule.AccumulateFunction;

import co.edu.udistrital.sga.preinscripcion.auto.domain.Horario;

public class HorariosScoreAcumulateFunction implements AccumulateFunction {

	protected static class HorariosScoreData implements Serializable{
	        public List<List<Horario>> horariosUsados = new ArrayList<>();	    
	}

	@Override
	public void accumulate(Serializable context, Object value) {
		HorariosScoreData data = (HorariosScoreData) context;
		List<Horario> listahorarios=(List<Horario>)value;
	    data.horariosUsados.add(listahorarios);		
	}

	@Override
	public Serializable createContext() {
		return new HorariosScoreData();
	}

	@Override
	public Object getResult(Serializable context) throws Exception {
		HorariosScoreData data = (HorariosScoreData) context;
		Integer scoreNegativoAcumulado=0;
		List<Horario> listaHorario=new ArrayList<>();
		for (List<Horario> listahor : data.horariosUsados) {
			listaHorario.addAll(listahor);
		}
		Map<String, List<Horario>> listaHorarioDias=listaHorario.stream().collect(Collectors.groupingBy(Horario::getNombreDia));

		for (String key : listaHorarioDias.keySet())
		{
			List<Integer> listaHoras = new ArrayList<>();
			for (Horario horario : listaHorarioDias.get(key)) {
				listaHoras.addAll(horario.getFranjasEnteras()); 
			}						
			Set<Integer> setHoras = new HashSet<Integer>(listaHoras);
		    scoreNegativoAcumulado+=carcularScoreNegativo(new ArrayList<>(setHoras));
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
		data.horariosUsados.clear();
	}

	@Override
	public void reverse(Serializable context, Object value) throws Exception {
		HorariosScoreData data = (HorariosScoreData) context;
		List<Horario> listahorarios=(List<Horario>)value;
	    data.horariosUsados.remove(listahorarios);

	}

	@Override
	public boolean supportsReverse() {
		// TODO Auto-generated method stub
		return true;
	}
	
	private Integer carcularScoreNegativo(List<Integer> espacios)
	{
		Collections.sort(espacios);
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

//	@Test
//	public void test(){
//		List<Integer> lista=new ArrayList<>();
//		lista.add(6);
//
//		lista.add(18);
//		System.out.println("calculo:"+carcularScoreNegativo(lista));
//	}
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub

	}
}
