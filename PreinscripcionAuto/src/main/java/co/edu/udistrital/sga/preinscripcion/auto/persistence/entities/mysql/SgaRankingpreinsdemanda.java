package co.edu.udistrital.sga.preinscripcion.auto.persistence.entities.mysql;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the sga_rankingpreinsdemanda database table.
 * 
 */
@Entity
@Table(name="sga_rankingpreinsdemanda")
public class SgaRankingpreinsdemanda implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SgaRankingpreinsdemandaPK id;

	private String rank_nombreEspacio;

	private String rank_nombreFacultad;

	private String rank_nombreProyecto;

	private int rank_numeroPreinscritos;

	@Column(name="rank_posicion")
	private int rankPosicion;

	public SgaRankingpreinsdemanda() {
	}

	public SgaRankingpreinsdemandaPK getId() {
		return this.id;
	}

	public void setId(SgaRankingpreinsdemandaPK id) {
		this.id = id;
	}

	public String getRank_nombreEspacio() {
		return this.rank_nombreEspacio;
	}

	public void setRank_nombreEspacio(String rank_nombreEspacio) {
		this.rank_nombreEspacio = rank_nombreEspacio;
	}

	public String getRank_nombreFacultad() {
		return this.rank_nombreFacultad;
	}

	public void setRank_nombreFacultad(String rank_nombreFacultad) {
		this.rank_nombreFacultad = rank_nombreFacultad;
	}

	public String getRank_nombreProyecto() {
		return this.rank_nombreProyecto;
	}

	public void setRank_nombreProyecto(String rank_nombreProyecto) {
		this.rank_nombreProyecto = rank_nombreProyecto;
	}

	public int getRank_numeroPreinscritos() {
		return this.rank_numeroPreinscritos;
	}

	public void setRank_numeroPreinscritos(int rank_numeroPreinscritos) {
		this.rank_numeroPreinscritos = rank_numeroPreinscritos;
	}

	public int getRankPosicion() {
		return this.rankPosicion;
	}

	public void setRankPosicion(int rankPosicion) {
		this.rankPosicion = rankPosicion;
	}

}