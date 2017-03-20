package co.edu.udistrital.sga.preinscripcion.auto.persistence.entities.mysql;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the sga_clasificacion_estudiantes database table.
 * 
 */
@Entity
@Table(name="sga_clasificacion_estudiantes")
public class SgaClasificacionEstudiante implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SgaClasificacionEstudiantePK id;

	@Column(name="cle_clasificacion")
	private int cleClasificacion;

	private int cle_codProyectoCurricular;

	@Lob
	private String cle_tipoEstudiante;

	public SgaClasificacionEstudiante() {
	}

	public SgaClasificacionEstudiantePK getId() {
		return this.id;
	}

	public void setId(SgaClasificacionEstudiantePK id) {
		this.id = id;
	}

	public int getCleClasificacion() {
		return this.cleClasificacion;
	}

	public void setCleClasificacion(int cleClasificacion) {
		this.cleClasificacion = cleClasificacion;
	}

	public int getCle_codProyectoCurricular() {
		return this.cle_codProyectoCurricular;
	}

	public void setCle_codProyectoCurricular(int cle_codProyectoCurricular) {
		this.cle_codProyectoCurricular = cle_codProyectoCurricular;
	}

	public String getCle_tipoEstudiante() {
		return this.cle_tipoEstudiante;
	}

	public void setCle_tipoEstudiante(String cle_tipoEstudiante) {
		this.cle_tipoEstudiante = cle_tipoEstudiante;
	}

}