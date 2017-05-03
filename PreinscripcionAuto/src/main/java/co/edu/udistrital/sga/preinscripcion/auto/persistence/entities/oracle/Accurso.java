package co.edu.udistrital.sga.preinscripcion.auto.persistence.entities.oracle;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;


/**
 * The persistent class for the ACCURSOS database table.
 * 
 */
@Data
@Entity
@Table(name="ACCURSOS")
@NamedQuery(name="Accurso.findAll", query="SELECT a FROM Accurso a")
public class Accurso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CUR_ID")
	private Long curId;

	@Column(name="CUR_APE_ANO")
	private Integer curApeAno;

	@Column(name="CUR_APE_PER")
	private Integer curApePer;

	@Column(name="CUR_ASI_COD")
	private Long curAsiCod;

	@Column(name="CUR_CAP_MAX")
	private Integer curCapMax;

	@Column(name="CUR_CRA_COD")
	private Long curCraCod;

	@Column(name="CUR_DEP_COD")
	private Long curDepCod;

	@Column(name="CUR_ESTADO")
	private String curEstado;

	@Column(name="CUR_EXA")
	private BigDecimal curExa;

	@Column(name="CUR_GRUPO")
	private Long curGrupo;

	@Column(name="CUR_HAB")
	private BigDecimal curHab;

	@Column(name="CUR_HOR_ALTERNATIVO")
	private BigDecimal curHorAlternativo;

	@Column(name="CUR_LAB")
	private BigDecimal curLab;

	@Column(name="CUR_NRO_CUPO")
	private Integer curNroCupo;

	@Column(name="CUR_NRO_INS")
	private Integer curNroIns;

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
	@OneToMany
	@JoinColumn(name="HOR_ID_CURSO",referencedColumnName="CUR_ID")
	private List<Achorario> achorarios;

	public Accurso() {
	}

	
	
}