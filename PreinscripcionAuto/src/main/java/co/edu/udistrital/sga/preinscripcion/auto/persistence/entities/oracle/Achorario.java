package co.edu.udistrital.sga.preinscripcion.auto.persistence.entities.oracle;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the ACHORARIOS database table.
 * 
 */
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

	public long getHorId() {
		return this.horId;
	}

	public void setHorId(long horId) {
		this.horId = horId;
	}

	public BigDecimal getHorAlternativa() {
		return this.horAlternativa;
	}

	public void setHorAlternativa(BigDecimal horAlternativa) {
		this.horAlternativa = horAlternativa;
	}

	public BigDecimal getHorDiaNro() {
		return this.horDiaNro;
	}

	public void setHorDiaNro(BigDecimal horDiaNro) {
		this.horDiaNro = horDiaNro;
	}

	public String getHorEstado() {
		return this.horEstado;
	}

	public void setHorEstado(String horEstado) {
		this.horEstado = horEstado;
	}

	public BigDecimal getHorHora() {
		return this.horHora;
	}

	public void setHorHora(BigDecimal horHora) {
		this.horHora = horHora;
	}

	public String getHorSalIdEspacio() {
		return this.horSalIdEspacio;
	}

	public void setHorSalIdEspacio(String horSalIdEspacio) {
		this.horSalIdEspacio = horSalIdEspacio;
	}

	public Accurso getAccurso() {
		return this.accurso;
	}

	public void setAccurso(Accurso accurso) {
		this.accurso = accurso;
	}

}