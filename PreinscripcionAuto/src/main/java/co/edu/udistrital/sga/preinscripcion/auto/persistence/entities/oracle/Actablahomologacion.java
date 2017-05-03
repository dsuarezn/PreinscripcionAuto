package co.edu.udistrital.sga.preinscripcion.auto.persistence.entities.oracle;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import lombok.Data;


/**
 * The persistent class for the ACTABLAHOMOLOGACION database table.
 * 
 */
@Data
@Entity
@NamedQuery(name="Actablahomologacion.findAll", query="SELECT a FROM Actablahomologacion a")
public class Actablahomologacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="HOM_ID")
	private long homId;

	@Column(name="HOM_ASI_COD_HOM")
	private Long homAsiCodHom;

	@Column(name="HOM_ASI_COD_PPAL")
	private Long homAsiCodPpal;

	@Column(name="HOM_CRA_COD_HOM")
	private Long homCraCodHom;

	@Column(name="HOM_CRA_COD_PPAL")
	private Long homCraCodPpal;

	@Column(name="HOM_ESTADO")
	private String homEstado;

	@Column(name="HOM_FECHA_REG")
	private BigDecimal homFechaReg;

	@Column(name="HOM_TIPO_HOM")
	private Long homTipoHom;

	public Actablahomologacion() {
	}

	
}