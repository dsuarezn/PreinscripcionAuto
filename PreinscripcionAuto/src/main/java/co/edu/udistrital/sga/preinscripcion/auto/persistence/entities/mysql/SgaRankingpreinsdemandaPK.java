package co.edu.udistrital.sga.preinscripcion.auto.persistence.entities.mysql;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the sga_rankingpreinsdemanda database table.
 * 
 */
@Embeddable
public class SgaRankingpreinsdemandaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int rank_codFacultad;

	private int rank_codProyecto;

	private int rank_codEspacio;

	public SgaRankingpreinsdemandaPK() {
	}
	public int getRank_codFacultad() {
		return this.rank_codFacultad;
	}
	public void setRank_codFacultad(int rank_codFacultad) {
		this.rank_codFacultad = rank_codFacultad;
	}
	public int getRank_codProyecto() {
		return this.rank_codProyecto;
	}
	public void setRank_codProyecto(int rank_codProyecto) {
		this.rank_codProyecto = rank_codProyecto;
	}
	public int getRank_codEspacio() {
		return this.rank_codEspacio;
	}
	public void setRank_codEspacio(int rank_codEspacio) {
		this.rank_codEspacio = rank_codEspacio;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SgaRankingpreinsdemandaPK)) {
			return false;
		}
		SgaRankingpreinsdemandaPK castOther = (SgaRankingpreinsdemandaPK)other;
		return 
			(this.rank_codFacultad == castOther.rank_codFacultad)
			&& (this.rank_codProyecto == castOther.rank_codProyecto)
			&& (this.rank_codEspacio == castOther.rank_codEspacio);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.rank_codFacultad;
		hash = hash * prime + this.rank_codProyecto;
		hash = hash * prime + this.rank_codEspacio;
		
		return hash;
	}
}