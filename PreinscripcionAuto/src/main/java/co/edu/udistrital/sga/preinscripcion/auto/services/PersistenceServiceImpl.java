package co.edu.udistrital.sga.preinscripcion.auto.services;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udistrital.sga.preinscripcion.auto.domain.EstudianteXCurso;
import co.edu.udistrital.sga.preinscripcion.auto.domain.PreinscripcionAsignaturasSolution;
import co.edu.udistrital.sga.preinscripcion.auto.persistence.entities.oracle.Acin;
import co.edu.udistrital.sga.preinscripcion.auto.persistence.entities.oracle.Acinspre;
import co.edu.udistrital.sga.preinscripcion.auto.persistence.entities.oracle.AcinsprePK;
import co.edu.udistrital.sga.preinscripcion.auto.persistence.repositories.oracle.AcinRepository;
import co.edu.udistrital.sga.preinscripcion.auto.persistence.repositories.oracle.AcinspreRepository;


@Service
@Transactional
@Qualifier("persistenceServiceImpl")
public class PersistenceServiceImpl implements PersistenceService {

	@Autowired
	private AcinspreRepository acinspreRepository;
	
	@Autowired
	private AcinRepository acinRepository;

	
	private final String ESTADO_DEFAULT_PREINSCRIPCION="A";
	private final Integer DEFAULT_HORARIO_ALTERNATIVO=0;
	


	@Override
	public void deleteAcinsPreData(Long codCarrera, Integer periodo, Integer anio) {
		// TODO Auto-generated method stub
		acinspreRepository.borrarRegistrosPorCodCarreraAnioPeriodo(anio, periodo, codCarrera);
	}

	@Override
	public void deleteAcinData(Long codCarrera, Integer periodo, Integer anio) {
		// TODO Auto-generated method stub
		acinRepository.borrarRegistrosPorCodCarreraAnioPeriodo(anio, periodo, codCarrera);
	}

	@Override
	public List<Acin> obtenerAcinsPrePorCodigoCarreraPeriodoAnio(Long codCarrera, Integer periodo, Integer anio) {
		return acinspreRepository.obtenerAcinPorCodCarreraAnioPeriodo(anio, periodo, codCarrera);
	}

	@Override
	public void persistirListaAcinspre(List<Acinspre> listaAcinspre) {
		acinspreRepository.save(listaAcinspre);
	}

	@Override
	public void persistirListaAcin(List<Acin> listaAcin) {
		acinRepository.save(listaAcin);
	}

	@Override
	public void persistirSolucionAcinsPre(PreinscripcionAsignaturasSolution solution) {
		List<Acinspre> listaAcinspre=new ArrayList<>();
		for (EstudianteXCurso estudianteXCurso : solution.getListaProgramacionEstudiantes()) {
			if(estudianteXCurso.getCurso()!=null && estudianteXCurso.getEstudiante()!=null){
				AcinsprePK pk=new AcinsprePK();
				pk.setInsAno(solution.getAnio());
				pk.setInsPer(solution.getPeriodo());
				pk.setInsAsiCod(estudianteXCurso.getCodigoAsignatura());
				pk.setInsCraCod(estudianteXCurso.getCodigoCarreraAsignatura());
				pk.setInsEstCod(estudianteXCurso.getEstudianteCodigo());				
				Acinspre acinspre=new Acinspre();
				acinspre.setId(pk);
				acinspre.setInsCeaCod(estudianteXCurso.getCurso().getCeaCode());
				acinspre.setInsCred(estudianteXCurso.getCreditos());
				acinspre.setInsGr(estudianteXCurso.getCurso().getCodigoGrupo());
				acinspre.setInsSem(estudianteXCurso.getCurso().getSemestre());
				acinspre.setInsEstado(ESTADO_DEFAULT_PREINSCRIPCION);
				acinspre.setInsHorAlternativo(DEFAULT_HORARIO_ALTERNATIVO);
				listaAcinspre.add(acinspre);
			}		
		}
		this.persistirListaAcinspre(listaAcinspre);		
	}
	

}
