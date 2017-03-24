package co.edu.udistrital.sga.preinscripcion.auto.persistence.entities.oracle;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

/**
 * The primary key class for the ACINSDEMANDA database table.
 * 
 */
@Data
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
}