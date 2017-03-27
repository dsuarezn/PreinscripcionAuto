package co.edu.udistrital.sga.preinscripcion.auto.persistence.entities.mysql;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;


/**
 * The persistent class for the sga_clasificacion_estudiantes database table.
 * 
 */
@Data
@Entity
@Table(name="sga_clasificacion_estudiantes")
public class SgaClasificacionEstudiante implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SgaClasificacionEstudiantePK id;

	@Column(name="cle_clasificacion")
	private int cleClasificacion;

	private int cle_codProyectoCurricular;

	private String cle_tipoEstudiante;

	public SgaClasificacionEstudiante() {
	}

	
	


}