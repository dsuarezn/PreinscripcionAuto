package co.edu.udistrital.sga.preinscripcion.auto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udistrital.sga.preinscripcion.auto.domain.ProyectoCurricular;
import co.edu.udistrital.sga.preinscripcion.auto.persistence.repositories.oracle.AccraRepository;

@Service
@Transactional
public class ProyectoServiceImpl implements ProyectoService {

	@Autowired
	private AccraRepository accraRepository;
	
	@Override
	public List<ProyectoCurricular> obtenerProyectosCoordinador(long codigoCarrera) {
		return accraRepository.obtenerProyectosCoordinador(codigoCarrera);
	}

}
