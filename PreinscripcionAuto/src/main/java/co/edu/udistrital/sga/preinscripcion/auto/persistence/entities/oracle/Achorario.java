package co.edu.udistrital.sga.preinscripcion.auto.persistence.entities.oracle;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

import java.math.BigDecimal;


/**
 * The persistent class for the ACHORARIOS database table.
 * 
 */
@Data
@Entity
@Table(name="ACHORARIOS")
@NamedQuery(name="Achorario.findAll", query="SELECT a FROM Achorario a")
public class Achorario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="HOR_ID")
	private long horId;

	@Column(name="HOR_ALTERNATIVA")
	private BigDecimal horAlternativa;

	@Column(name="HOR_DIA_NRO")
	private BigDecimal horDiaNro;

	@Column(name="HOR_ESTADO")
	private String horEstado;

	@Column(name="HOR_HORA")
	private BigDecimal horHora;

	@Column(name="HOR_SAL_ID_ESPACIO")
	private String horSalIdEspacio;

	//bi-directional many-to-one association to Accurso
	@ManyToOne
	@JoinColumn(name="HOR_ID_CURSO")
	private Accurso accurso;

	public Achorario() {
	}

}