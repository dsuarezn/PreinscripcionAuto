package co.edu.udistrital.sga.preinscripcion.auto.persistence.entities.oracle;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the ACINS database table.
 * 
 */
@Entity
@Table(name="ACINS")
@NamedQuery(name="Acin.findAll", query="SELECT a FROM Acin a")
public class Acin implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AcinPK id;

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

	@Column(name="INS_NOTA")
	private BigDecimal insNota;

	@Column(name="INS_NOTA_ACU")
	private BigDecimal insNotaAcu;

	@Column(name="INS_NOTA_EXA")
	private BigDecimal insNotaExa;

	@Column(name="INS_NOTA_HAB")
	private BigDecimal insNotaHab;

	@Column(name="INS_NOTA_LAB")
	private BigDecimal insNotaLab;

	@Column(name="INS_NOTA_PAR1")
	private BigDecimal insNotaPar1;

	@Column(name="INS_NOTA_PAR2")
	private BigDecimal insNotaPar2;

	@Column(name="INS_NOTA_PAR3")
	private BigDecimal insNotaPar3;

	@Column(name="INS_NOTA_PAR4")
	private BigDecimal insNotaPar4;

	@Column(name="INS_NOTA_PAR5")
	private BigDecimal insNotaPar5;

	@Column(name="INS_NOTA_PAR6")
	private BigDecimal insNotaPar6;

	@Column(name="INS_NRO_AUT")
	private BigDecimal insNroAut;

	@Column(name="INS_NRO_HP")
	private BigDecimal insNroHp;

	@Column(name="INS_NRO_HT")
	private BigDecimal insNroHt;

	@Column(name="INS_OBS")
	private BigDecimal insObs;

	@Column(name="INS_SECUENCIA")
	private BigDecimal insSecuencia;

	@Column(name="INS_SEM")
	private BigDecimal insSem;

	@Column(name="INS_TOT_FALLAS")
	private BigDecimal insTotFallas;

	@Column(name="INS_USUARIO")
	private String insUsuario;

	//bi-directional many-to-one association to Accra
	@ManyToOne
	@JoinColumn(name="INS_CRA_COD", insertable = false, updatable = false)
	private Accra accra;

	//bi-directional many-to-one association to Acest
	@ManyToOne
	@JoinColumn(name="INS_EST_COD", insertable = false, updatable = false)
	private Acest acest;

	public Acin() {
	}

	public AcinPK getId() {
		return this.id;
	}

	public void setId(AcinPK id) {
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

	public BigDecimal getInsNota() {
		return this.insNota;
	}

	public void setInsNota(BigDecimal insNota) {
		this.insNota = insNota;
	}

	public BigDecimal getInsNotaAcu() {
		return this.insNotaAcu;
	}

	public void setInsNotaAcu(BigDecimal insNotaAcu) {
		this.insNotaAcu = insNotaAcu;
	}

	public BigDecimal getInsNotaExa() {
		return this.insNotaExa;
	}

	public void setInsNotaExa(BigDecimal insNotaExa) {
		this.insNotaExa = insNotaExa;
	}

	public BigDecimal getInsNotaHab() {
		return this.insNotaHab;
	}

	public void setInsNotaHab(BigDecimal insNotaHab) {
		this.insNotaHab = insNotaHab;
	}

	public BigDecimal getInsNotaLab() {
		return this.insNotaLab;
	}

	public void setInsNotaLab(BigDecimal insNotaLab) {
		this.insNotaLab = insNotaLab;
	}

	public BigDecimal getInsNotaPar1() {
		return this.insNotaPar1;
	}

	public void setInsNotaPar1(BigDecimal insNotaPar1) {
		this.insNotaPar1 = insNotaPar1;
	}

	public BigDecimal getInsNotaPar2() {
		return this.insNotaPar2;
	}

	public void setInsNotaPar2(BigDecimal insNotaPar2) {
		this.insNotaPar2 = insNotaPar2;
	}

	public BigDecimal getInsNotaPar3() {
		return this.insNotaPar3;
	}

	public void setInsNotaPar3(BigDecimal insNotaPar3) {
		this.insNotaPar3 = insNotaPar3;
	}

	public BigDecimal getInsNotaPar4() {
		return this.insNotaPar4;
	}

	public void setInsNotaPar4(BigDecimal insNotaPar4) {
		this.insNotaPar4 = insNotaPar4;
	}

	public BigDecimal getInsNotaPar5() {
		return this.insNotaPar5;
	}

	public void setInsNotaPar5(BigDecimal insNotaPar5) {
		this.insNotaPar5 = insNotaPar5;
	}

	public BigDecimal getInsNotaPar6() {
		return this.insNotaPar6;
	}

	public void setInsNotaPar6(BigDecimal insNotaPar6) {
		this.insNotaPar6 = insNotaPar6;
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

	public BigDecimal getInsObs() {
		return this.insObs;
	}

	public void setInsObs(BigDecimal insObs) {
		this.insObs = insObs;
	}

	public BigDecimal getInsSecuencia() {
		return this.insSecuencia;
	}

	public void setInsSecuencia(BigDecimal insSecuencia) {
		this.insSecuencia = insSecuencia;
	}

	public BigDecimal getInsSem() {
		return this.insSem;
	}

	public void setInsSem(BigDecimal insSem) {
		this.insSem = insSem;
	}

	public BigDecimal getInsTotFallas() {
		return this.insTotFallas;
	}

	public void setInsTotFallas(BigDecimal insTotFallas) {
		this.insTotFallas = insTotFallas;
	}

	public String getInsUsuario() {
		return this.insUsuario;
	}

	public void setInsUsuario(String insUsuario) {
		this.insUsuario = insUsuario;
	}

	public Accra getAccra() {
		return this.accra;
	}

	public void setAccra(Accra accra) {
		this.accra = accra;
	}

	public Acest getAcest() {
		return this.acest;
	}

	public void setAcest(Acest acest) {
		this.acest = acest;
	}

}