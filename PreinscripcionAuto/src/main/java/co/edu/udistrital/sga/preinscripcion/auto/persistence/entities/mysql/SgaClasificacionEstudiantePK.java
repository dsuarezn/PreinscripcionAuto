package co.edu.udistrital.sga.preinscripcion.auto.persistence.entities.mysql;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the sga_clasificacion_estudiantes database table.
 * 
 */
@Embeddable
public class SgaClasificacionEstudiantePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="`﻿cle_id`")
	private int _cleId;

	private String cle_codEstudiante;

	public SgaClasificacionEstudiantePK() {
	}
	public int get_cleId() {
		return this._cleId;
	}
	public void set_cleId(int _cleId) {
		this._cleId = _cleId;
	}
	public String getCle_codEstudiante() {
		return this.cle_codEstudiante;
	}
	public void setCle_codEstudiante(String cle_codEstudiante) {
		this.cle_codEstudiante = cle_codEstudiante;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SgaClasificacionEstudiantePK)) {
			return false;
		}
		SgaClasificacionEstudiantePK castOther = (SgaClasificacionEstudiantePK)other;
		return 
			(this._cleId == castOther._cleId)
			&& this.cle_codEstudiante.equals(castOther.cle_codEstudiante);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this._cleId;
		hash = hash * prime + this.cle_codEstudiante.hashCode();
		
		return hash;
	}
}