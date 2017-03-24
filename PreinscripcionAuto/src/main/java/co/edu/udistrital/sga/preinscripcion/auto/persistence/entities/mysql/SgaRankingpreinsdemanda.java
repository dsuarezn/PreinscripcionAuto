package co.edu.udistrital.sga.preinscripcion.auto.persistence.entities.mysql;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;


/**
 * The persistent class for the sga_rankingpreinsdemanda database table.
 * 
 */
@Data
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


}