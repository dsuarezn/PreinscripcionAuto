package co.edu.udistrital.sga.preinscripcion.auto.persistence.entities.oracle;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the ACEST database table.
 * 
 */
@Entity
@NamedQuery(name="Acest.findAll", query="SELECT a FROM Acest a")
public class Acest implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="EST_COD")
	private long estCod;

	@Column(name="EST_ACUERDO")
	private BigDecimal estAcuerdo;

	@Column(name="EST_CORRESPONDENCIA")
	private String estCorrespondencia;

	@Column(name="EST_DIFERIDO")
	private String estDiferido;

	@Column(name="EST_DIRECCION")
	private String estDireccion;

	@Column(name="EST_ESTADO")
	private String estEstado;

	@Column(name="EST_ESTADO_EST")
	private String estEstadoEst;

	@Column(name="EST_EXENTO")
	private String estExento;

	@Column(name="EST_FALLECIDO")
	private String estFallecido;

	@Column(name="EST_IND_CRED",columnDefinition = "char")
	private String estIndCred;

	@Column(name="EST_INGRESOS_ANUALES")
	private BigDecimal estIngresosAnuales;

	@Column(name="EST_JORNADA")
	private String estJornada;

	@Column(name="EST_LIB_MILITAR")
	private String estLibMilitar;

	@Column(name="EST_MOTIVO_EXENTO")
	private String estMotivoExento;

	@Column(name="EST_NOMBRE")
	private String estNombre;

	@Column(name="EST_NRO_DIS_MILITAR")
	private BigDecimal estNroDisMilitar;

	@Column(name="EST_NRO_IDEN")
	private BigDecimal estNroIden;

	@Column(name="EST_NRO_IDEN_ANT")
	private BigDecimal estNroIdenAnt;

	@Column(name="EST_OPCION_MAT")
	private BigDecimal estOpcionMat;

	@Column(name="EST_PATRIMONIO_LIQUIDO")
	private BigDecimal estPatrimonioLiquido;

	@Column(name="EST_PBM")
	private BigDecimal estPbm;

	@Column(name="EST_PEN_NRO")
	private BigDecimal estPenNro;

	@Column(name="EST_PORCENTAJE")
	private BigDecimal estPorcentaje;

	@Column(name="EST_RENTA_LIQUIDA")
	private BigDecimal estRentaLiquida;

	@Column(name="EST_SEXO")
	private String estSexo;

	@Column(name="EST_TELEFONO")
	private BigDecimal estTelefono;

	@Column(name="EST_TIPO_IDEN")
	private String estTipoIden;

	@Column(name="EST_TIPO_IDEN_ANT")
	private String estTipoIdenAnt;

	@Column(name="EST_VALOR_MATRICULA")
	private BigDecimal estValorMatricula;

	@Column(name="EST_ZONA_POSTAL")
	private BigDecimal estZonaPostal;

	//bi-directional many-to-one association to Accra
	@ManyToOne
	@JoinColumn(name="EST_CRA_COD")
	private Accra accra;

	//bi-directional many-to-one association to Acin
	@OneToMany(mappedBy="acest")
	private List<Acin> acins;

	public Acest() {
	}

	public long getEstCod() {
		return this.estCod;
	}

	public void setEstCod(long estCod) {
		this.estCod = estCod;
	}

	public BigDecimal getEstAcuerdo() {
		return this.estAcuerdo;
	}

	public void setEstAcuerdo(BigDecimal estAcuerdo) {
		this.estAcuerdo = estAcuerdo;
	}

	public String getEstCorrespondencia() {
		return this.estCorrespondencia;
	}

	public void setEstCorrespondencia(String estCorrespondencia) {
		this.estCorrespondencia = estCorrespondencia;
	}

	public String getEstDiferido() {
		return this.estDiferido;
	}

	public void setEstDiferido(String estDiferido) {
		this.estDiferido = estDiferido;
	}

	public String getEstDireccion() {
		return this.estDireccion;
	}

	public void setEstDireccion(String estDireccion) {
		this.estDireccion = estDireccion;
	}

	public String getEstEstado() {
		return this.estEstado;
	}

	public void setEstEstado(String estEstado) {
		this.estEstado = estEstado;
	}

	public String getEstEstadoEst() {
		return this.estEstadoEst;
	}

	public void setEstEstadoEst(String estEstadoEst) {
		this.estEstadoEst = estEstadoEst;
	}

	public String getEstExento() {
		return this.estExento;
	}

	public void setEstExento(String estExento) {
		this.estExento = estExento;
	}

	public String getEstFallecido() {
		return this.estFallecido;
	}

	public void setEstFallecido(String estFallecido) {
		this.estFallecido = estFallecido;
	}

	public String getEstIndCred() {
		return this.estIndCred;
	}

	public void setEstIndCred(String estIndCred) {
		this.estIndCred = estIndCred;
	}

	public BigDecimal getEstIngresosAnuales() {
		return this.estIngresosAnuales;
	}

	public void setEstIngresosAnuales(BigDecimal estIngresosAnuales) {
		this.estIngresosAnuales = estIngresosAnuales;
	}

	public String getEstJornada() {
		return this.estJornada;
	}

	public void setEstJornada(String estJornada) {
		this.estJornada = estJornada;
	}

	public String getEstLibMilitar() {
		return this.estLibMilitar;
	}

	public void setEstLibMilitar(String estLibMilitar) {
		this.estLibMilitar = estLibMilitar;
	}

	public String getEstMotivoExento() {
		return this.estMotivoExento;
	}

	public void setEstMotivoExento(String estMotivoExento) {
		this.estMotivoExento = estMotivoExento;
	}

	public String getEstNombre() {
		return this.estNombre;
	}

	public void setEstNombre(String estNombre) {
		this.estNombre = estNombre;
	}

	public BigDecimal getEstNroDisMilitar() {
		return this.estNroDisMilitar;
	}

	public void setEstNroDisMilitar(BigDecimal estNroDisMilitar) {
		this.estNroDisMilitar = estNroDisMilitar;
	}

	public BigDecimal getEstNroIden() {
		return this.estNroIden;
	}

	public void setEstNroIden(BigDecimal estNroIden) {
		this.estNroIden = estNroIden;
	}

	public BigDecimal getEstNroIdenAnt() {
		return this.estNroIdenAnt;
	}

	public void setEstNroIdenAnt(BigDecimal estNroIdenAnt) {
		this.estNroIdenAnt = estNroIdenAnt;
	}

	public BigDecimal getEstOpcionMat() {
		return this.estOpcionMat;
	}

	public void setEstOpcionMat(BigDecimal estOpcionMat) {
		this.estOpcionMat = estOpcionMat;
	}

	public BigDecimal getEstPatrimonioLiquido() {
		return this.estPatrimonioLiquido;
	}

	public void setEstPatrimonioLiquido(BigDecimal estPatrimonioLiquido) {
		this.estPatrimonioLiquido = estPatrimonioLiquido;
	}

	public BigDecimal getEstPbm() {
		return this.estPbm;
	}

	public void setEstPbm(BigDecimal estPbm) {
		this.estPbm = estPbm;
	}

	public BigDecimal getEstPenNro() {
		return this.estPenNro;
	}

	public void setEstPenNro(BigDecimal estPenNro) {
		this.estPenNro = estPenNro;
	}

	public BigDecimal getEstPorcentaje() {
		return this.estPorcentaje;
	}

	public void setEstPorcentaje(BigDecimal estPorcentaje) {
		this.estPorcentaje = estPorcentaje;
	}

	public BigDecimal getEstRentaLiquida() {
		return this.estRentaLiquida;
	}

	public void setEstRentaLiquida(BigDecimal estRentaLiquida) {
		this.estRentaLiquida = estRentaLiquida;
	}

	public String getEstSexo() {
		return this.estSexo;
	}

	public void setEstSexo(String estSexo) {
		this.estSexo = estSexo;
	}

	public BigDecimal getEstTelefono() {
		return this.estTelefono;
	}

	public void setEstTelefono(BigDecimal estTelefono) {
		this.estTelefono = estTelefono;
	}

	public String getEstTipoIden() {
		return this.estTipoIden;
	}

	public void setEstTipoIden(String estTipoIden) {
		this.estTipoIden = estTipoIden;
	}

	public String getEstTipoIdenAnt() {
		return this.estTipoIdenAnt;
	}

	public void setEstTipoIdenAnt(String estTipoIdenAnt) {
		this.estTipoIdenAnt = estTipoIdenAnt;
	}

	public BigDecimal getEstValorMatricula() {
		return this.estValorMatricula;
	}

	public void setEstValorMatricula(BigDecimal estValorMatricula) {
		this.estValorMatricula = estValorMatricula;
	}

	public BigDecimal getEstZonaPostal() {
		return this.estZonaPostal;
	}

	public void setEstZonaPostal(BigDecimal estZonaPostal) {
		this.estZonaPostal = estZonaPostal;
	}

	public Accra getAccra() {
		return this.accra;
	}

	public void setAccra(Accra accra) {
		this.accra = accra;
	}

	public List<Acin> getAcins() {
		return this.acins;
	}

	public void setAcins(List<Acin> acins) {
		this.acins = acins;
	}

//	public Acin addAcin(Acin acin) {
//		getAcins().add(acin);
//		acin.setAcest(this);
//
//		return acin;
//	}
//
//	public Acin removeAcin(Acin acin) {
//		getAcins().remove(acin);
//		acin.setAcest(null);
//
//		return acin;
//	}

}