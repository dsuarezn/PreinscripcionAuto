package co.edu.udistrital.sga.preinscripcion.auto.persistence.entities.mysql;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the sga_ejecuta_inscripcion_auto database table.
 * 
 */
@Embeddable
public class SgaEjecutaInscripcionAutoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ins_ano")
	private int insAno;

	@Column(name="ins_per")
	private int insPer;

	@Column(name="ins_cra_cod")
	private int insCraCod;

	@Column(name="ins_estado")
	private String insEstado;

	public SgaEjecutaInscripcionAutoPK() {
	}
	public int getInsAno() {
		return this.insAno;
	}
	public void setInsAno(int insAno) {
		this.insAno = insAno;
	}
	public int getInsPer() {
		return this.insPer;
	}
	public void setInsPer(int insPer) {
		this.insPer = insPer;
	}
	public int getInsCraCod() {
		return this.insCraCod;
	}
	public void setInsCraCod(int insCraCod) {
		this.insCraCod = insCraCod;
	}
	public String getInsEstado() {
		return this.insEstado;
	}
	public void setInsEstado(String insEstado) {
		this.insEstado = insEstado;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SgaEjecutaInscripcionAutoPK)) {
			return false;
		}
		SgaEjecutaInscripcionAutoPK castOther = (SgaEjecutaInscripcionAutoPK)other;
		return 
			(this.insAno == castOther.insAno)
			&& (this.insPer == castOther.insPer)
			&& (this.insCraCod == castOther.insCraCod)
			&& this.insEstado.equals(castOther.insEstado);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.insAno;
		hash = hash * prime + this.insPer;
		hash = hash * prime + this.insCraCod;
		hash = hash * prime + this.insEstado.hashCode();
		
		return hash;
	}
}