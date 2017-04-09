package co.edu.udistrital.sga.preinscripcion.auto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udistrital.sga.preinscripcion.auto.domain.AsignaturaGrupo;
import co.edu.udistrital.sga.preinscripcion.auto.domain.AsignaturaRequerida;
import co.edu.udistrital.sga.preinscripcion.auto.persistence.repositories.oracle.AccursosRepository;
import co.edu.udistrital.sga.preinscripcion.auto.persistence.repositories.oracle.AcinsdemandaRepository;
import co.edu.udistrital.sga.preinscripcion.auto.persistence.repositories.oracle.AcinspreRepository;


@Service
@Transactional
public class CursosServiceImpl implements CursosService {

	@Autowired
	private AccursosRepository accursosRepository;
	
	@Autowired
	private AcinsdemandaRepository acinsdemandaRepository;
	
	@Autowired
	private AcinspreRepository acinspreRepository;
	
	@Override
	public List<AsignaturaGrupo> obtenerCursosProgramados(Integer anio, Integer periodo, Long codigoCarrera) {
		return accursosRepository.obtenerAsignaturasProgramadas(anio, periodo, codigoCarrera, "A");
	}

	@Override
	public List<AsignaturaRequerida> obtenerListaMateriasPreinsDemanda(Integer anio, Integer periodo, Long codCarrera, String estado) {
		return acinsdemandaRepository.obtenerListaAsignaturasPreinsPorDemamda(anio, periodo,codCarrera, estado);
	}

	@Override
	public List<AsignaturaRequerida> obtenerListaMateriasPreinsPre(Integer anio, Integer periodo, Long codCarrera, String estado) {
		return acinspreRepository.obtenerListaAsignaturasPreinsPre(anio, periodo, codCarrera, estado);
	}

}
