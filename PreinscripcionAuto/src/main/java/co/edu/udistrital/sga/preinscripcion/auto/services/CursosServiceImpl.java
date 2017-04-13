package co.edu.udistrital.sga.preinscripcion.auto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udistrital.sga.preinscripcion.auto.domain.AsignaturaGrupo;
import co.edu.udistrital.sga.preinscripcion.auto.domain.AsignaturaRequerida;
import co.edu.udistrital.sga.preinscripcion.auto.persistence.entities.mysql.SgaClasificacionEstudiante;
import co.edu.udistrital.sga.preinscripcion.auto.persistence.entities.mysql.SgaRankingpreinsdemanda;
import co.edu.udistrital.sga.preinscripcion.auto.persistence.entities.oracle.Acest;
import co.edu.udistrital.sga.preinscripcion.auto.persistence.repositories.mysql.SgaRankingPreinscDemandaRepository;
import co.edu.udistrital.sga.preinscripcion.auto.persistence.repositories.oracle.AccursosRepository;
import co.edu.udistrital.sga.preinscripcion.auto.persistence.repositories.oracle.AcinsdemandaRepository;
import co.edu.udistrital.sga.preinscripcion.auto.persistence.repositories.oracle.AcinspreRepository;


@Service
@Transactional
@Qualifier("cursosServiceImpl")
public class CursosServiceImpl implements CursosService {

	@Autowired
	private AccursosRepository accursosRepository;
	
	@Autowired
	private AcinsdemandaRepository acinsdemandaRepository;
	
	@Autowired
	private AcinspreRepository acinspreRepository;
	
	@Autowired
	private SgaRankingPreinscDemandaRepository sgaRankingPreinscDemandaRepository;
	
	@Override
	public List<AsignaturaGrupo> obtenerCursosProgramados(Integer anio, Integer periodo, Long codigoCarrera) {		
		List<AsignaturaGrupo> listaAsignaturasGrupos=accursosRepository.obtenerAsignaturasProgramadas(anio, periodo, codigoCarrera, "A");		
		List<SgaRankingpreinsdemanda> listaRanking = sgaRankingPreinscDemandaRepository.findAll();
		for (SgaRankingpreinsdemanda asignaturaRank : listaRanking) {
			Long asignaturaCode=Long.valueOf(asignaturaRank.getId().getRank_codEspacio());
			listaAsignaturasGrupos.stream().filter(e->e.getCodigoAsignatura().equals(asignaturaCode)).forEach(e->e.setRanking(asignaturaRank.getRankPosicion()));
		}	
		return listaAsignaturasGrupos;
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
