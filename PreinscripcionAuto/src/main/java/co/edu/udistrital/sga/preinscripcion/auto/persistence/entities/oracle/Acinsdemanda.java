package co.edu.udistrital.sga.preinscripcion.auto.persistence.entities.oracle;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the ACINSDEMANDA database table.
 * 
 */
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

	public AcinsdemandaPK getId() {
		return this.id;
	}

	public void setId(AcinsdemandaPK id) {
		this.id = id;
	}

	public BigDecimal getInsdeCeaCod() {
		return this.insdeCeaCod;
	}

	public void setInsdeCeaCod(BigDecimal insdeCeaCod) {
		this.insdeCeaCod = insdeCeaCod;
	}

	public BigDecimal getInsdeCraCod() {
		return this.insdeCraCod;
	}

	public void setInsdeCraCod(BigDecimal insdeCraCod) {
		this.insdeCraCod = insdeCraCod;
	}

	public BigDecimal getInsdeCred() {
		return this.insdeCred;
	}

	public void setInsdeCred(BigDecimal insdeCred) {
		this.insdeCred = insdeCred;
	}

	public BigDecimal getInsdeEquivalente() {
		return this.insdeEquivalente;
	}

	public void setInsdeEquivalente(BigDecimal insdeEquivalente) {
		this.insdeEquivalente = insdeEquivalente;
	}

	public String getInsdeEstado() {
		return this.insdeEstado;
	}

	public void setInsdeEstado(String insdeEstado) {
		this.insdeEstado = insdeEstado;
	}

	public BigDecimal getInsdeHta() {
		return this.insdeHta;
	}

	public void setInsdeHta(BigDecimal insdeHta) {
		this.insdeHta = insdeHta;
	}

	public BigDecimal getInsdeHtc() {
		return this.insdeHtc;
	}

	public void setInsdeHtc(BigDecimal insdeHtc) {
		this.insdeHtc = insdeHtc;
	}

	public BigDecimal getInsdeHtd() {
		return this.insdeHtd;
	}

	public void setInsdeHtd(BigDecimal insdeHtd) {
		this.insdeHtd = insdeHtd;
	}

	public String getInsdePerdido() {
		return this.insdePerdido;
	}

	public void setInsdePerdido(String insdePerdido) {
		this.insdePerdido = insdePerdido;
	}

	public BigDecimal getInsdeSem() {
		return this.insdeSem;
	}

	public void setInsdeSem(BigDecimal insdeSem) {
		this.insdeSem = insdeSem;
	}

}