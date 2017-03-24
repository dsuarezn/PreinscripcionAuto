package co.edu.udistrital.sga.preinscripcion.auto.persistence.entities.oracle;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

import java.math.BigDecimal;


/**
 * The persistent class for the ACINSPRE database table.
 * 
 */
@Data
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

}