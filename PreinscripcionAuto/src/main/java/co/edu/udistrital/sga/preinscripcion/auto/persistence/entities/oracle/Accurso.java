package co.edu.udistrital.sga.preinscripcion.auto.persistence.entities.oracle;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the ACCURSOS database table.
 * 
 */
@Entity
@Table(name="ACCURSOS")
@NamedQuery(name="Accurso.findAll", query="SELECT a FROM Accurso a")
public class Accurso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CUR_ID")
	private long curId;

	@Column(name="CUR_APE_ANO")
	private Integer curApeAno;

	@Column(name="CUR_APE_PER")
	private Integer curApePer;

	@Column(name="CUR_ASI_COD")
	private BigDecimal curAsiCod;

	@Column(name="CUR_CAP_MAX")
	private BigDecimal curCapMax;

	@Column(name="CUR_CRA_COD")
	private Integer curCraCod;

	@Column(name="CUR_DEP_COD")
	private BigDecimal curDepCod;

	@Column(name="CUR_ESTADO")
	private String curEstado;

	@Column(name="CUR_EXA")
	private BigDecimal curExa;

	@Column(name="CUR_GRUPO")
	private BigDecimal curGrupo;

	@Column(name="CUR_HAB")
	private BigDecimal curHab;

	@Column(name="CUR_HOR_ALTERNATIVO")
	private BigDecimal curHorAlternativo;

	@Column(name="CUR_LAB")
	private BigDecimal curLab;

	@Column(name="CUR_NRO_CUPO")
	private BigDecimal curNroCupo;

	@Column(name="CUR_NRO_INS")
	private BigDecimal curNroIns;

	@Column(name="CUR_PAR1")
	private BigDecimal curPar1;

	@Column(name="CUR_PAR2")
	private BigDecimal curPar2;

	@Column(name="CUR_PAR3")
	private BigDecimal curPar3;

	@Column(name="CUR_PAR4")
	private BigDecimal curPar4;

	@Column(name="CUR_PAR5")
	private BigDecimal curPar5;

	@Column(name="CUR_PAR6")
	private BigDecimal curPar6;

	@Column(name="CUR_TIPO")
	private BigDecimal curTipo;

	//bi-directional many-to-one association to Achorario
	@OneToMany(mappedBy="accurso")
	private List<Achorario> achorarios;

	public Accurso() {
	}

	public long getCurId() {
		return this.curId;
	}

	public void setCurId(long curId) {
		this.curId = curId;
	}

	
	
	public Integer getCurApeAno() {
		return curApeAno;
	}

	public void setCurApeAno(Integer curApeAno) {
		this.curApeAno = curApeAno;
	}

	public Integer getCurApePer() {
		return curApePer;
	}

	public void setCurApePer(Integer curApePer) {
		this.curApePer = curApePer;
	}

	public void setCurCraCod(Integer curCraCod) {
		this.curCraCod = curCraCod;
	}

	public BigDecimal getCurAsiCod() {
		return this.curAsiCod;
	}

	public void setCurAsiCod(BigDecimal curAsiCod) {
		this.curAsiCod = curAsiCod;
	}

	public BigDecimal getCurCapMax() {
		return this.curCapMax;
	}

	public void setCurCapMax(BigDecimal curCapMax) {
		this.curCapMax = curCapMax;
	}

	
	
	public Integer getCurCraCod() {
		return curCraCod;
	}

	public BigDecimal getCurDepCod() {
		return this.curDepCod;
	}

	public void setCurDepCod(BigDecimal curDepCod) {
		this.curDepCod = curDepCod;
	}

	public String getCurEstado() {
		return this.curEstado;
	}

	public void setCurEstado(String curEstado) {
		this.curEstado = curEstado;
	}

	public BigDecimal getCurExa() {
		return this.curExa;
	}

	public void setCurExa(BigDecimal curExa) {
		this.curExa = curExa;
	}

	public BigDecimal getCurGrupo() {
		return this.curGrupo;
	}

	public void setCurGrupo(BigDecimal curGrupo) {
		this.curGrupo = curGrupo;
	}

	public BigDecimal getCurHab() {
		return this.curHab;
	}

	public void setCurHab(BigDecimal curHab) {
		this.curHab = curHab;
	}

	public BigDecimal getCurHorAlternativo() {
		return this.curHorAlternativo;
	}

	public void setCurHorAlternativo(BigDecimal curHorAlternativo) {
		this.curHorAlternativo = curHorAlternativo;
	}

	public BigDecimal getCurLab() {
		return this.curLab;
	}

	public void setCurLab(BigDecimal curLab) {
		this.curLab = curLab;
	}

	public BigDecimal getCurNroCupo() {
		return this.curNroCupo;
	}

	public void setCurNroCupo(BigDecimal curNroCupo) {
		this.curNroCupo = curNroCupo;
	}

	public BigDecimal getCurNroIns() {
		return this.curNroIns;
	}

	public void setCurNroIns(BigDecimal curNroIns) {
		this.curNroIns = curNroIns;
	}

	public BigDecimal getCurPar1() {
		return this.curPar1;
	}

	public void setCurPar1(BigDecimal curPar1) {
		this.curPar1 = curPar1;
	}

	public BigDecimal getCurPar2() {
		return this.curPar2;
	}

	public void setCurPar2(BigDecimal curPar2) {
		this.curPar2 = curPar2;
	}

	public BigDecimal getCurPar3() {
		return this.curPar3;
	}

	public void setCurPar3(BigDecimal curPar3) {
		this.curPar3 = curPar3;
	}

	public BigDecimal getCurPar4() {
		return this.curPar4;
	}

	public void setCurPar4(BigDecimal curPar4) {
		this.curPar4 = curPar4;
	}

	public BigDecimal getCurPar5() {
		return this.curPar5;
	}

	public void setCurPar5(BigDecimal curPar5) {
		this.curPar5 = curPar5;
	}

	public BigDecimal getCurPar6() {
		return this.curPar6;
	}

	public void setCurPar6(BigDecimal curPar6) {
		this.curPar6 = curPar6;
	}

	public BigDecimal getCurTipo() {
		return this.curTipo;
	}

	public void setCurTipo(BigDecimal curTipo) {
		this.curTipo = curTipo;
	}

	public List<Achorario> getAchorarios() {
		return this.achorarios;
	}

	public void setAchorarios(List<Achorario> achorarios) {
		this.achorarios = achorarios;
	}

	public Achorario addAchorario(Achorario achorario) {
		getAchorarios().add(achorario);
		achorario.setAccurso(this);

		return achorario;
	}

	public Achorario removeAchorario(Achorario achorario) {
		getAchorarios().remove(achorario);
		achorario.setAccurso(null);

		return achorario;
	}

}