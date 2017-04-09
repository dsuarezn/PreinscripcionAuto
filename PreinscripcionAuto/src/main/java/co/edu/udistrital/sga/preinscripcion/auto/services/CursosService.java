package co.edu.udistrital.sga.preinscripcion.auto.services;

import java.util.List;

import co.edu.udistrital.sga.preinscripcion.auto.domain.AsignaturaGrupo;
import co.edu.udistrital.sga.preinscripcion.auto.domain.AsignaturaRequerida;

public interface CursosService {

	public List<AsignaturaGrupo> obtenerCursosProgramados(Integer anio, Integer periodo, Long codigoCarrera);
	public List<AsignaturaRequerida> obtenerListaMateriasPreinsDemanda(Integer anio, Integer periodo, Long codCarrera, String estado);
	public List<AsignaturaRequerida> obtenerListaMateriasPreinsPre(Integer anio, Integer periodo, Long codCarrera, String estado);
}
