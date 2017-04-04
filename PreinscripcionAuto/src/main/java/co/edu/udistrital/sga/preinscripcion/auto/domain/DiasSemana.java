package co.edu.udistrital.sga.preinscripcion.auto.domain;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @author Alexander
 * @version 1.0
 * @created 07-feb.-2017 15:56:31
 * fact emuneration
 */
@XStreamAlias("DiasSemana")
public enum DiasSemana {

	 D_LUNES ("Lunes", 1), 
	 D_MARTES ("Martes",2),
	 D_MIERCOLES ("Miercoles", 3),
	 D_JUEVES ("Jueves", 4),
	 D_VIERNES ("Viernes", 5),
	 D_SABADO ("Sabado", 6);
	 
		   
    private final String nombreDia; 
    private final Integer horaEntera; 
    
    DiasSemana (String nombreDia, Integer horaInt) { 
        this.nombreDia = nombreDia;
        this.horaEntera = horaInt;
    } 
 
	    
	
}