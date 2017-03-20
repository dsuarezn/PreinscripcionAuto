package co.edu.udistrital.sga.preinscripcion.auto.persistence.entities.oracle;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ACINS database table.
 * 
 */
@Embeddable
public class AcinPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="INS_ANO")
	private long insAno;

	@Column(name="INS_PER")
	private long insPer;

	@Column(name="INS_EST_COD")
	private long insEstCod;

	@Column(name="INS_ASI_COD")
	private long insAsiCod;

	public AcinPK() {
	}
	public long getInsAno() {
		return this.insAno;
	}
	public void setInsAno(long insAno) {
		this.insAno = insAno;
	}
	public long getInsPer() {
		return this.insPer;
	}
	public void setInsPer(long insPer) {
		this.insPer = insPer;
	}
	public long getInsEstCod() {
		return this.insEstCod;
	}
	public void setInsEstCod(long insEstCod) {
		this.insEstCod = insEstCod;
	}
	public long getInsAsiCod() {
		return this.insAsiCod;
	}
	public void setInsAsiCod(long insAsiCod) {
		this.insAsiCod = insAsiCod;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AcinPK)) {
			return false;
		}
		AcinPK castOther = (AcinPK)other;
		return 
			(this.insAno == castOther.insAno)
			&& (this.insPer == castOther.insPer)
			&& (this.insEstCod == castOther.insEstCod)
			&& (this.insAsiCod == castOther.insAsiCod);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.insAno ^ (this.insAno >>> 32)));
		hash = hash * prime + ((int) (this.insPer ^ (this.insPer >>> 32)));
		hash = hash * prime + ((int) (this.insEstCod ^ (this.insEstCod >>> 32)));
		hash = hash * prime + ((int) (this.insAsiCod ^ (this.insAsiCod >>> 32)));
		
		return hash;
	}
}