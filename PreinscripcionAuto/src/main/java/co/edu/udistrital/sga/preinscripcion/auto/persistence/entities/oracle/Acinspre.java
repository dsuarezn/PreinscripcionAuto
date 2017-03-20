package co.edu.udistrital.sga.preinscripcion.auto.persistence.entities.oracle;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the ACINSPRE database table.
 * 
 */
@Entity
@NamedQuery(name="Acinspre.findAll", query="SELECT a FROM Acinspre a")
public class Acinspre implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AcinsprePK id;

	@Column(name="INS_CEA_COD")
	private BigDecimal insCeaCod;

	@Column(name="INS_CRED")
	private BigDecimal insCred;

	@Column(name="INS_ESTADO")
	private String insEstado;

	@Column(name="INS_GR")
	private BigDecimal insGr;

	@Column(name="INS_HOR_ALTERNATIVO")
	private BigDecimal insHorAlternativo;

	@Column(name="INS_NRO_AUT")
	private BigDecimal insNroAut;

	@Column(name="INS_NRO_HP")
	private BigDecimal insNroHp;

	@Column(name="INS_NRO_HT")
	private BigDecimal insNroHt;

	@Column(name="INS_SEM")
	private BigDecimal insSem;

	public Acinspre() {
	}

	public AcinsprePK getId() {
		return this.id;
	}

	public void setId(AcinsprePK id) {
		this.id = id;
	}

	public BigDecimal getInsCeaCod() {
		return this.insCeaCod;
	}

	public void setInsCeaCod(BigDecimal insCeaCod) {
		this.insCeaCod = insCeaCod;
	}

	public BigDecimal getInsCred() {
		return this.insCred;
	}

	public void setInsCred(BigDecimal insCred) {
		this.insCred = insCred;
	}

	public String getInsEstado() {
		return this.insEstado;
	}

	public void setInsEstado(String insEstado) {
		this.insEstado = insEstado;
	}

	public BigDecimal getInsGr() {
		return this.insGr;
	}

	public void setInsGr(BigDecimal insGr) {
		this.insGr = insGr;
	}

	public BigDecimal getInsHorAlternativo() {
		return this.insHorAlternativo;
	}

	public void setInsHorAlternativo(BigDecimal insHorAlternativo) {
		this.insHorAlternativo = insHorAlternativo;
	}

	public BigDecimal getInsNroAut() {
		return this.insNroAut;
	}

	public void setInsNroAut(BigDecimal insNroAut) {
		this.insNroAut = insNroAut;
	}

	public BigDecimal getInsNroHp() {
		return this.insNroHp;
	}

	public void setInsNroHp(BigDecimal insNroHp) {
		this.insNroHp = insNroHp;
	}

	public BigDecimal getInsNroHt() {
		return this.insNroHt;
	}

	public void setInsNroHt(BigDecimal insNroHt) {
		this.insNroHt = insNroHt;
	}

	public BigDecimal getInsSem() {
		return this.insSem;
	}

	public void setInsSem(BigDecimal insSem) {
		this.insSem = insSem;
	}

}