package co.edu.udistrital.sga.preinscripcion.auto.persistence.entities.mysql;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

/**
 * The primary key class for the sga_ejecuta_inscripcion_auto database table.
 * 
 */
@Data
@Embeddable
public class SgaEjecutaInscripcionAutoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ins_ano")
	private int insAno;

	@Column(name="ins_cra_cod")
	private int insCraCod;

	@Column(name="ins_estado")
	private String insEstado;

	@Column(name="ins_per")
	private int insPer;

	public SgaEjecutaInscripcionAutoPK() {
	}
	
}