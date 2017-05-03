package co.edu.udistrital.sga.preinscripcion.auto.common.domain;

import co.edu.udistrital.sga.preinscripcion.auto.domain.IntervaloDeTiempo;

public enum EstadoProcesoPlanificacion {
	NO_EXISTENTE ("0"),
	PROCESO_EN_EJECUCION ("7"),
	PROCESO_YA_EJECUTADO ("14"),
	PROCESO_TERMINADO_TEMPRANO ("31");
	
	private final String codigoEstadoProceso;
	
	EstadoProcesoPlanificacion (String codigo) { 
        this.codigoEstadoProceso = codigo;        
    } 
	
	
	public String getCodigo(){
    	return this.codigoEstadoProceso;
    }
	
	public static EstadoProcesoPlanificacion obtenerDesdeCodigo(String valor){
    	 for(EstadoProcesoPlanificacion e: EstadoProcesoPlanificacion.values()) 
    	 {
		    if(e.getCodigo().equals(valor)) {
		      return e;
		    }
		 }
    	 return null;
    }
 
}
