package co.edu.udistrital.sga.preinscripcion.auto.services;

import java.util.List;

import co.edu.udistrital.sga.preinscripcion.auto.domain.Estudiante;
import co.edu.udistrital.sga.preinscripcion.auto.persistence.entities.oracle.Acinsdemanda;

public interface EstudiantesService {

	public List<Estudiante> obtenerListaEstudiantes();
	
	
}
