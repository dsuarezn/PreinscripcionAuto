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
	private Integer insdeAno;

	@Column(name="INSDE_PER")
	private Integer insdePer;

	@Column(name="INSDE_EST_COD")
	private Long insdeEstCod;

	@Column(name="INSDE_ASI_COD")
	private Long insdeAsiCod;

	public AcinsdemandaPK() {
	}
}