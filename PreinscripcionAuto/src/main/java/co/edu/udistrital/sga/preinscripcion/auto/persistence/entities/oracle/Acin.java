package co.edu.udistrital.sga.preinscripcion.auto.persistence.entities.oracle;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

import java.math.BigDecimal;


/**
 * The persistent class for the ACINS database table.
 * 
 */
@Data
@Entity
@Table(name="ACINS")
@NamedQuery(name="Acin.findAll", query="SELECT a FROM Acin a")
public class Acin implements Serializable {
	private static final long serialVersionUID = 1L;
		

	@EmbeddedId
	private AcinPK id;

	@Column(name="INS_CRA_COD")
	private Long insCraCod;
	
	@Column(name="INS_CEA_COD")
	private Integer insCeaCod;

	@Column(name="INS_CRED")
	private Integer insCred;

	@Column(name="INS_ESTADO")
	private String insEstado;

	@Column(name="INS_GR")
	private Long insGr;

	@Column(name="INS_HOR_ALTERNATIVO")
	private Integer insHorAlternativo;

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
	private Integer insSem;

	@Column(name="INS_TOT_FALLAS")
	private Integer insTotFallas;

	@Column(name="INS_USUARIO")
	private String insUsuario;

	//bi-directional many-to-one association to Accra
//	@ManyToOne
//	@JoinColumn(name="INS_CRA_COD", insertable = false, updatable = false)
//	private Accra accra;

	//bi-directional many-to-one association to Acest
	@ManyToOne
	@JoinColumn(name="INS_EST_COD", insertable = false, updatable = false)
	private Acest acest;

	public Acin(Acinspre acinspre) {
		AcinPK pk=new AcinPK();
		pk.setInsAno(acinspre.getId().getInsAno());
		pk.setInsPer(acinspre.getId().getInsPer());
		pk.setInsEstCod(acinspre.getId().getInsEstCod());
		pk.setInsAsiCod(acinspre.getId().getInsAsiCod());
		this.setId(pk);
		this.setInsCraCod(acinspre.getId().getInsCraCod());
		this.setInsGr(acinspre.getInsGr());
		this.setInsCred(acinspre.getInsCred());
		this.setInsSem(acinspre.getInsSem());
		this.setInsCeaCod(acinspre.getInsCeaCod());
		this.setInsEstado(acinspre.getInsEstado());
		this.setInsHorAlternativo(acinspre.getInsHorAlternativo());
		this.setInsTotFallas(0);
	}

	public Acin() {
		
	}
	
	

}