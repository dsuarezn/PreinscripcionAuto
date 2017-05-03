package co.edu.udistrital.sga.preinscripcion.auto.services;

import java.util.List;

import co.edu.udistrital.sga.preinscripcion.auto.domain.AsignaturaGrupo;
import co.edu.udistrital.sga.preinscripcion.auto.domain.AsignaturaRequerida;
import co.edu.udistrital.sga.preinscripcion.auto.persistence.entities.oracle.Actablahomologacion;

public interface CursosService {

	public List<AsignaturaGrupo> obtenerCursosProgramados(Integer anio, Integer periodo, Long codigoCarrera);
	public List<AsignaturaRequerida> obtenerListaMateriasPreinsDemanda(Integer anio, Integer periodo, Long codCarrera, String estado);
	public List<Actablahomologacion> obtenerListaHomologaciones(Long codCarrera, String estado);
	
	
	
}
