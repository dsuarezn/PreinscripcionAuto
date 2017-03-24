package co.edu.udistrital.sga.preinscripcion.auto.persistence.entities.mysql;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

/**
 * The primary key class for the sga_rankingpreinsdemanda database table.
 * 
 */
@Data
@Embeddable
public class SgaRankingpreinsdemandaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="rank_codFacultad")
	private int rank_codFacultad;

	private int rank_codProyecto;

	private int rank_codEspacio;

	public SgaRankingpreinsdemandaPK() {
	}

}