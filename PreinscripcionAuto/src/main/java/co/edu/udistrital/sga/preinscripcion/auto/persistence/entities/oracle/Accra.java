package co.edu.udistrital.sga.preinscripcion.auto.persistence.entities.oracle;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ACCRA database table.
 * 
 */
@Data
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

//	//bi-directional many-to-one association to Acin
//	@OneToMany(mappedBy="accra")
//	private List<Acin> acins;

	public Accra() {
	}

}