package co.edu.udistrital.sga.preinscripcion.auto.drools.ext;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.kie.api.runtime.rule.AccumulateFunction;

public class AsigPreinscritasEstudiantesAcumFunction implements AccumulateFunction {

	protected static class RankingEstudiantesScoreData implements Serializable{
        public List<Long> codigosAsignaturasInscritas = new ArrayList<>();	      
	}
	

	@Override
	public void accumulate(Serializable context, Object value) {
		Long codigoAsignatura=(Long)value;
		RankingEstudiantesScoreData data = (RankingEstudiantesScoreData) context;				
		data.codigosAsignaturasInscritas.add(codigoAsignatura);
		
	}

	@Override
	public Serializable createContext() {
		return new RankingEstudiantesScoreData();
	}

	@Override
	public Object getResult(Serializable context) throws Exception {
		RankingEstudiantesScoreData data = (RankingEstudiantesScoreData) context;
		return data.codigosAsignaturasInscritas;
	}

	@Override
	public Class<?> getResultType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(Serializable context) throws Exception {
		RankingEstudiantesScoreData data = (RankingEstudiantesScoreData) context;	
		data.codigosAsignaturasInscritas.clear();
	}

	@Override
	public void reverse(Serializable context, Object value) throws Exception {
		Long codigoAsignatura=(Long)value;
		RankingEstudiantesScoreData data = (RankingEstudiantesScoreData) context;				
		data.codigosAsignaturasInscritas.remove(codigoAsignatura);	
	}

	@Override
	public boolean supportsReverse() {
		return true;
	}
	

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
	}

}
