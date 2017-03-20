package co.edu.udistrital.sga.preinscripcion.auto.persistence.entities.oracle;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ACCRA database table.
 * 
 */
@Entity
public class Accra implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CRA_COD")
	private long craCod;

	@Column(name="CRA_ABREV")
	private String craAbrev;

	@Column(name="CRA_COD_ICFES")
	private BigDecimal craCodIcfes;

	@Column(name="CRA_COD_SNIES")
	private BigDecimal craCodSnies;

	@Column(name="CRA_DEP_COD")
	private BigDecimal craDepCod;

	@Column(name="CRA_EMAIL")
	private String craEmail;

	@Column(name="CRA_EMP_COD")
	private BigDecimal craEmpCod;

	@Column(name="CRA_EMP_NRO_IDEN")
	private BigDecimal craEmpNroIden;

	@Column(name="CRA_ESTADO")
	private String craEstado;

	@Temporal(TemporalType.DATE)
	@Column(name="CRA_FECHA_APROB_ICFES")
	private Date craFechaAprobIcfes;

	@Temporal(TemporalType.DATE)
	@Column(name="CRA_FECHA_ULT_RENOV")
	private Date craFechaUltRenov;

	@Column(name="CRA_IND_CICLO")
	private String craIndCiclo;

	@Column(name="CRA_JORNADA")
	private String craJornada;

	@Column(name="CRA_JUST_COD")
	private BigDecimal craJustCod;

	@Column(name="CRA_NOMBRE")
	private String craNombre;

	@Column(name="CRA_NOTA_APROB")
	private BigDecimal craNotaAprob;

	@Column(name="CRA_PRO_COOR")
	private String craProCoor;

	@Column(name="CRA_RESOL_SUP")
	private String craResolSup;

	@Column(name="CRA_SE_OFRECE")
	private String craSeOfrece;

	@Column(name="CRA_TIP_CRA")
	private BigDecimal craTipCra;

	//bi-directional many-to-one association to Acest
	@OneToMany(mappedBy="accra")
	private List<Acest> acests;

	//bi-directional many-to-one association to Acin
	@OneToMany(mappedBy="accra")
	private List<Acin> acins;

	public Accra() {
	}

	public long getCraCod() {
		return this.craCod;
	}

	public void setCraCod(long craCod) {
		this.craCod = craCod;
	}

	public String getCraAbrev() {
		return this.craAbrev;
	}

	public void setCraAbrev(String craAbrev) {
		this.craAbrev = craAbrev;
	}

	public BigDecimal getCraCodIcfes() {
		return this.craCodIcfes;
	}

	public void setCraCodIcfes(BigDecimal craCodIcfes) {
		this.craCodIcfes = craCodIcfes;
	}

	public BigDecimal getCraCodSnies() {
		return this.craCodSnies;
	}

	public void setCraCodSnies(BigDecimal craCodSnies) {
		this.craCodSnies = craCodSnies;
	}

	public BigDecimal getCraDepCod() {
		return this.craDepCod;
	}

	public void setCraDepCod(BigDecimal craDepCod) {
		this.craDepCod = craDepCod;
	}

	public String getCraEmail() {
		return this.craEmail;
	}

	public void setCraEmail(String craEmail) {
		this.craEmail = craEmail;
	}

	public BigDecimal getCraEmpCod() {
		return this.craEmpCod;
	}

	public void setCraEmpCod(BigDecimal craEmpCod) {
		this.craEmpCod = craEmpCod;
	}

	public BigDecimal getCraEmpNroIden() {
		return this.craEmpNroIden;
	}

	public void setCraEmpNroIden(BigDecimal craEmpNroIden) {
		this.craEmpNroIden = craEmpNroIden;
	}

	public String getCraEstado() {
		return this.craEstado;
	}

	public void setCraEstado(String craEstado) {
		this.craEstado = craEstado;
	}

	public Date getCraFechaAprobIcfes() {
		return this.craFechaAprobIcfes;
	}

	public void setCraFechaAprobIcfes(Date craFechaAprobIcfes) {
		this.craFechaAprobIcfes = craFechaAprobIcfes;
	}

	public Date getCraFechaUltRenov() {
		return this.craFechaUltRenov;
	}

	public void setCraFechaUltRenov(Date craFechaUltRenov) {
		this.craFechaUltRenov = craFechaUltRenov;
	}

	public String getCraIndCiclo() {
		return this.craIndCiclo;
	}

	public void setCraIndCiclo(String craIndCiclo) {
		this.craIndCiclo = craIndCiclo;
	}

	public String getCraJornada() {
		return this.craJornada;
	}

	public void setCraJornada(String craJornada) {
		this.craJornada = craJornada;
	}

	public BigDecimal getCraJustCod() {
		return this.craJustCod;
	}

	public void setCraJustCod(BigDecimal craJustCod) {
		this.craJustCod = craJustCod;
	}

	public String getCraNombre() {
		return this.craNombre;
	}

	public void setCraNombre(String craNombre) {
		this.craNombre = craNombre;
	}

	public BigDecimal getCraNotaAprob() {
		return this.craNotaAprob;
	}

	public void setCraNotaAprob(BigDecimal craNotaAprob) {
		this.craNotaAprob = craNotaAprob;
	}

	public String getCraProCoor() {
		return this.craProCoor;
	}

	public void setCraProCoor(String craProCoor) {
		this.craProCoor = craProCoor;
	}

	public String getCraResolSup() {
		return this.craResolSup;
	}

	public void setCraResolSup(String craResolSup) {
		this.craResolSup = craResolSup;
	}

	public String getCraSeOfrece() {
		return this.craSeOfrece;
	}

	public void setCraSeOfrece(String craSeOfrece) {
		this.craSeOfrece = craSeOfrece;
	}

	public BigDecimal getCraTipCra() {
		return this.craTipCra;
	}

	public void setCraTipCra(BigDecimal craTipCra) {
		this.craTipCra = craTipCra;
	}

	public List<Acest> getAcests() {
		return this.acests;
	}

	public void setAcests(List<Acest> acests) {
		this.acests = acests;
	}

	public Acest addAcest(Acest acest) {
		getAcests().add(acest);
		acest.setAccra(this);

		return acest;
	}

	public Acest removeAcest(Acest acest) {
		getAcests().remove(acest);
		acest.setAccra(null);

		return acest;
	}

	public List<Acin> getAcins() {
		return this.acins;
	}

	public void setAcins(List<Acin> acins) {
		this.acins = acins;
	}

	public Acin addAcin(Acin acin) {
		getAcins().add(acin);
		acin.setAccra(this);

		return acin;
	}

	public Acin removeAcin(Acin acin) {
		getAcins().remove(acin);
		acin.setAccra(null);

		return acin;
	}

}