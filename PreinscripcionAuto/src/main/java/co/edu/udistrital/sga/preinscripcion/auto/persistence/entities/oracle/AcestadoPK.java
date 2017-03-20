package co.edu.udistrital.sga.preinscripcion.auto.persistence.entities.oracle;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ACESTADO database table.
 * 
 */
@Embeddable
public class AcestadoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ESTADO_COD")
	private String estadoCod;

	@Column(name="ESTADO_NOMBRE")
	private String estadoNombre;

	@Column(name="ESTADO_DESCRIPCION")
	private String estadoDescripcion;

	@Column(name="ESTADO_ACTIVO")
	private String estadoActivo;

	public AcestadoPK() {
	}
	public String getEstadoCod() {
		return this.estadoCod;
	}
	public void setEstadoCod(String estadoCod) {
		this.estadoCod = estadoCod;
	}
	public String getEstadoNombre() {
		return this.estadoNombre;
	}
	public void setEstadoNombre(String estadoNombre) {
		this.estadoNombre = estadoNombre;
	}
	public String getEstadoDescripcion() {
		return this.estadoDescripcion;
	}
	public void setEstadoDescripcion(String estadoDescripcion) {
		this.estadoDescripcion = estadoDescripcion;
	}
	public String getEstadoActivo() {
		return this.estadoActivo;
	}
	public void setEstadoActivo(String estadoActivo) {
		this.estadoActivo = estadoActivo;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AcestadoPK)) {
			return false;
		}
		AcestadoPK castOther = (AcestadoPK)other;
		return 
			this.estadoCod.equals(castOther.estadoCod)
			&& this.estadoNombre.equals(castOther.estadoNombre)
			&& this.estadoDescripcion.equals(castOther.estadoDescripcion)
			&& this.estadoActivo.equals(castOther.estadoActivo);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.estadoCod.hashCode();
		hash = hash * prime + this.estadoNombre.hashCode();
		hash = hash * prime + this.estadoDescripcion.hashCode();
		hash = hash * prime + this.estadoActivo.hashCode();
		
		return hash;
	}
}