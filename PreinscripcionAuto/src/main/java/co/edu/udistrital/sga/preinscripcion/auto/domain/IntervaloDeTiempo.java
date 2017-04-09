package co.edu.udistrital.sga.preinscripcion.auto.domain;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @author Alexander
 * @version 1.0
 * @created 07-feb.-2017 15:56:31
 * fact emuneration
 */
@XStreamAlias("IntervaloDeTiempo")
public enum IntervaloDeTiempo {

	 H_6AM ("06:00", 6),
	 H_7AM ("07:00", 7),
	 H_8AM ("08:00", 8),
	 H_9AM ("09:00", 9),
	 H_10AM ("10:00", 10),
	 H_11AM ("11:00", 11),
	 H_12AM ("12:00", 12),
	 H_1PM ("13:00", 13),
	 H_2PM ("14:00", 14),
	 H_3PM ("15:00", 15),
	 H_4PM ("16:00", 16),
	 H_5PM ("17:00", 17),
	 H_6PM ("18:00", 18),
	 H_7PM ("19:00", 19),
	 H_8PM ("20:00", 20),
	 H_9PM ("21:00", 21);
		   
    private final String horaf24; 
    private final Integer horaEntera; 
    
    IntervaloDeTiempo (String hora24f, Integer horaInt) { 
        this.horaf24 = hora24f;
        this.horaEntera = horaInt;
    } 
    
    public static IntervaloDeTiempo obtenerDesdeEntero(Integer valor){
    	 for(IntervaloDeTiempo e: IntervaloDeTiempo.values()) 
    	 {
		    if(e.horaEntera == valor) {
		      return e;
		    }
		 }
    	 return null;
    }
 
	    
	
}