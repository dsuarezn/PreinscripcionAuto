package co.edu.udistrital.sga.preinscripcion.auto.persistence.entities.oracle;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the ACEST database table.
 * 
 */
@Data
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
	private Integer estPenNro;

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

}