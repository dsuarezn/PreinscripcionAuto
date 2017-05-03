package co.edu.udistrital.sga.preinscripcion.auto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udistrital.sga.preinscripcion.auto.common.domain.EstadoProcesoPlanificacion;
import co.edu.udistrital.sga.preinscripcion.auto.domain.ProyectoCurricular;
import co.edu.udistrital.sga.preinscripcion.auto.persistence.entities.mysql.SgaEjecutaInscripcionAuto;
import co.edu.udistrital.sga.preinscripcion.auto.persistence.entities.mysql.SgaEjecutaInscripcionAutoPK;
import co.edu.udistrital.sga.preinscripcion.auto.persistence.repositories.mysql.SgaEjecutaInscripcionRepository;
import co.edu.udistrital.sga.preinscripcion.auto.persistence.repositories.oracle.AccraRepository;

@Service
@Transactional
@Qualifier("controlServiceImpl")
public class ControlServiceImpl implements ControlService {

	@Autowired
	private AccraRepository accraRepository;
	

	@Autowired
	private SgaEjecutaInscripcionRepository sgaEjecutaInscripcionRepository;
	
	
	@Override
	public List<ProyectoCurricular> obtenerProyectosCoordinador(long codigoCarrera) {
		return accraRepository.obtenerProyectosCoordinador(codigoCarrera);
	}
	
	

	@Override
	public void setUpdateEventoInscripcionAutomatica(Long codigoCarrera, Integer anio, Integer periodo,
			EstadoProcesoPlanificacion estado) {

		SgaEjecutaInscripcionAutoPK llave = new SgaEjecutaInscripcionAutoPK();
		llave.setInsAno(anio);
		llave.setInsPer(periodo);
		llave.setInsCraCod(codigoCarrera.intValue());
		
		SgaEjecutaInscripcionAuto test=new SgaEjecutaInscripcionAuto();
		test.setId(llave);
		
		Example<SgaEjecutaInscripcionAuto> example = Example.of(test);		
		SgaEjecutaInscripcionAuto evento= sgaEjecutaInscripcionRepository.findOne(example);

		if(evento==null){
			llave.setInsEstado(estado.getCodigo());
			SgaEjecutaInscripcionAuto sga=new SgaEjecutaInscripcionAuto();
			sga.setId(llave);
			sgaEjecutaInscripcionRepository.saveAndFlush(sga);
		}
		else{
			sgaEjecutaInscripcionRepository.delete(evento);
			evento.getId().setInsEstado(estado.getCodigo());
			sgaEjecutaInscripcionRepository.saveAndFlush(evento);
		}						
	}
	
	@Override
	public SgaEjecutaInscripcionAuto obtenerEvento(Long codigoCarrera, Integer anio, Integer periodo){
		SgaEjecutaInscripcionAutoPK llave = new SgaEjecutaInscripcionAutoPK();
		llave.setInsAno(anio);
		llave.setInsPer(periodo);
		llave.setInsCraCod(codigoCarrera.intValue());
		
		SgaEjecutaInscripcionAuto test=new SgaEjecutaInscripcionAuto();
		test.setId(llave);
		
		Example<SgaEjecutaInscripcionAuto> example = Example.of(test);		
		SgaEjecutaInscripcionAuto evento= sgaEjecutaInscripcionRepository.findOne(example);

		return evento;
	}

}
