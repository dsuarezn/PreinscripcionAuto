package co.edu.udistrital.sga.preinscripcion.auto.persistence.entities.oracle;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

/**
 * The primary key class for the ACINSPRE database table.
 * 
 */
@Data
@Embeddable
public class AcinsprePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="INS_ANO")
	private Integer insAno;

	@Column(name="INS_PER")
	private Integer insPer;

	@Column(name="INS_CRA_COD")
	private Long insCraCod;

	@Column(name="INS_EST_COD")
	private Long insEstCod;

	@Column(name="INS_ASI_COD")
	private Long insAsiCod;

	public AcinsprePK() {
	}
}