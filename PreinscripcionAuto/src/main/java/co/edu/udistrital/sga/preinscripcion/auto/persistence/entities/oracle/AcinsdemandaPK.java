package co.edu.udistrital.sga.preinscripcion.auto.persistence.entities.oracle;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ACINSDEMANDA database table.
 * 
 */
@Embeddable
public class AcinsdemandaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="INSDE_ANO")
	private long insdeAno;

	@Column(name="INSDE_PER")
	private long insdePer;

	@Column(name="INSDE_EST_COD")
	private long insdeEstCod;

	@Column(name="INSDE_ASI_COD")
	private long insdeAsiCod;

	public AcinsdemandaPK() {
	}
	public long getInsdeAno() {
		return this.insdeAno;
	}
	public void setInsdeAno(long insdeAno) {
		this.insdeAno = insdeAno;
	}
	public long getInsdePer() {
		return this.insdePer;
	}
	public void setInsdePer(long insdePer) {
		this.insdePer = insdePer;
	}
	public long getInsdeEstCod() {
		return this.insdeEstCod;
	}
	public void setInsdeEstCod(long insdeEstCod) {
		this.insdeEstCod = insdeEstCod;
	}
	public long getInsdeAsiCod() {
		return this.insdeAsiCod;
	}
	public void setInsdeAsiCod(long insdeAsiCod) {
		this.insdeAsiCod = insdeAsiCod;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AcinsdemandaPK)) {
			return false;
		}
		AcinsdemandaPK castOther = (AcinsdemandaPK)other;
		return 
			(this.insdeAno == castOther.insdeAno)
			&& (this.insdePer == castOther.insdePer)
			&& (this.insdeEstCod == castOther.insdeEstCod)
			&& (this.insdeAsiCod == castOther.insdeAsiCod);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.insdeAno ^ (this.insdeAno >>> 32)));
		hash = hash * prime + ((int) (this.insdePer ^ (this.insdePer >>> 32)));
		hash = hash * prime + ((int) (this.insdeEstCod ^ (this.insdeEstCod >>> 32)));
		hash = hash * prime + ((int) (this.insdeAsiCod ^ (this.insdeAsiCod >>> 32)));
		
		return hash;
	}
}