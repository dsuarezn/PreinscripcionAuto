package co.edu.udistrital.sga.preinscripcion.auto.persistence.entities.mysql;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;


/**
 * The persistent class for the sga_ejecuta_inscripcion_auto database table.
 * 
 */
@Data
@Entity
@Table(name="sga_ejecuta_inscripcion_auto")
public class SgaEjecutaInscripcionAuto implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SgaEjecutaInscripcionAutoPK id;

	public SgaEjecutaInscripcionAuto() {
	}	

}