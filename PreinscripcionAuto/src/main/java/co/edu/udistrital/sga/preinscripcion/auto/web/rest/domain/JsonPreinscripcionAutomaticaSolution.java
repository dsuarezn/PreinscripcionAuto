package co.edu.udistrital.sga.preinscripcion.auto.web.rest.domain;

import java.util.List;

import co.edu.udistrital.sga.preinscripcion.auto.domain.EstudianteXCurso;
import lombok.Data;
@Data
public class JsonPreinscripcionAutomaticaSolution {

	public JsonPreinscripcionAutomaticaSolution(List<EstudianteXCurso> listaProgramaciónEstudiantes) {
		this.listaProgramaciónEstudiantes = listaProgramaciónEstudiantes;
	}

	private List<EstudianteXCurso> listaProgramaciónEstudiantes;
	
	
}
