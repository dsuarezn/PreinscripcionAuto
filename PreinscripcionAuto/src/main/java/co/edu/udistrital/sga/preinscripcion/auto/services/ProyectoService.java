package co.edu.udistrital.sga.preinscripcion.auto.services;

import java.util.List;

import co.edu.udistrital.sga.preinscripcion.auto.domain.ProyectoCurricular;

public interface ProyectoService {

	List<ProyectoCurricular> obtenerProyectosCoordinador(long codigoCarrera);
}
