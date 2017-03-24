package co.edu.udistrital.sga.preinscripcion.auto.persistence.entities.oracle;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

import java.math.BigDecimal;


/**
 * The persistent class for the ACINSDEMANDA database table.
 * 
 */
@Data
@Entity
@NamedQuery(name="Acinsdemanda.findAll", query="SELECT a FROM Acinsdemanda a")
public class Acinsdemanda implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AcinsdemandaPK id;

	@Column(name="INSDE_CEA_COD")
	private BigDecimal insdeCeaCod;

	@Column(name="INSDE_CRA_COD")
	private BigDecimal insdeCraCod;

	@Column(name="INSDE_CRED")
	private BigDecimal insdeCred;

	@Column(name="INSDE_EQUIVALENTE")
	private BigDecimal insdeEquivalente;

	@Column(name="INSDE_ESTADO")
	private String insdeEstado;

	@Column(name="INSDE_HTA")
	private BigDecimal insdeHta;

	@Column(name="INSDE_HTC")
	private BigDecimal insdeHtc;

	@Column(name="INSDE_HTD")
	private BigDecimal insdeHtd;

	@Column(name="INSDE_PERDIDO")
	private String insdePerdido;

	@Column(name="INSDE_SEM")
	private BigDecimal insdeSem;

	public Acinsdemanda() {
	}

}