package co.edu.udistrital.sga.preinscripcion.auto.services;

import java.util.List;

import co.edu.udistrital.sga.preinscripcion.auto.domain.EstudianteXCurso;
import co.edu.udistrital.sga.preinscripcion.auto.domain.PreinscripcionAsignaturasSolution;
import co.edu.udistrital.sga.preinscripcion.auto.persistence.entities.oracle.Acin;
import co.edu.udistrital.sga.preinscripcion.auto.persistence.entities.oracle.Acinspre;

public interface PersistenceService {

	
	public void deleteAcinsPreData(Long codCarrera, Integer periodo, Integer anio);
	public void deleteAcinData(Long codCarrera, Integer periodo, Integer anio);
	
	public List<Acin> obtenerAcinsPrePorCodigoCarreraPeriodoAnio(Long codCarrera, Integer periodo, Integer anio);
	
	public void persistirSolucionAcinsPre(PreinscripcionAsignaturasSolution solution);	
	public void persistirListaAcinspre(List<Acinspre> listaAcinspre);
	public void persistirListaAcin(List<Acin> listaAcinspre);
}
