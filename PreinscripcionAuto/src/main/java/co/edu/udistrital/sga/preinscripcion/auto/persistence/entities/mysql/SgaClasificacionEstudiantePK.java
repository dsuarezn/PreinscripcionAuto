package co.edu.udistrital.sga.preinscripcion.auto.persistence.entities.mysql;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The primary key class for the sga_clasificacion_estudiantes database table.
 * 
 */
@Data
@Embeddable
public class SgaClasificacionEstudiantePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="cle_id")
	private int cleId;

	private long cle_codEstudiante;

	public SgaClasificacionEstudiantePK() {
	}
	
	
	
}