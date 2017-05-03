package co.edu.udistrital.sga.preinscripcion.auto.services;

import java.util.List;

import co.edu.udistrital.sga.preinscripcion.auto.common.domain.EstadoProcesoPlanificacion;
import co.edu.udistrital.sga.preinscripcion.auto.domain.ProyectoCurricular;
import co.edu.udistrital.sga.preinscripcion.auto.persistence.entities.mysql.SgaEjecutaInscripcionAuto;

public interface ControlService {

	List<ProyectoCurricular> obtenerProyectosCoordinador(long codigoCarrera);
	
	public void setUpdateEventoInscripcionAutomatica(Long codigoCarrera, Integer anio, Integer periodo, EstadoProcesoPlanificacion estado);
	public SgaEjecutaInscripcionAuto obtenerEvento(Long codigoCarrera, Integer anio, Integer periodo);
	
}
