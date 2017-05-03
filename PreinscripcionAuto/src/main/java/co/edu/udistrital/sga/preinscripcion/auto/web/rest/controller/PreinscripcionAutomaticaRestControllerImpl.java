package co.edu.udistrital.sga.preinscripcion.auto.web.rest.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.udistrital.sga.preinscripcion.auto.common.domain.EstadoProcesoPlanificacion;
import co.edu.udistrital.sga.preinscripcion.auto.domain.PreinscripcionAsignaturasSolution;
import co.edu.udistrital.sga.preinscripcion.auto.domain.solver.PreinscripcionAutomaticaSolverManager;
import co.edu.udistrital.sga.preinscripcion.auto.persistence.entities.mysql.SgaEjecutaInscripcionAuto;
import co.edu.udistrital.sga.preinscripcion.auto.persistence.entities.oracle.Acin;
import co.edu.udistrital.sga.preinscripcion.auto.services.ControlService;
import co.edu.udistrital.sga.preinscripcion.auto.services.PersistenceService;
import co.edu.udistrital.sga.preinscripcion.auto.web.rest.domain.JsonMessage;
import co.edu.udistrital.sga.preinscripcion.auto.web.rest.domain.JsonPreinscripcionAutomaticaSolution;


@RestController
@RequestMapping("/rest")
public class PreinscripcionAutomaticaRestControllerImpl {

	@Autowired
	private PreinscripcionAutomaticaSolverManager preinscripcionAutomaticaSolverManagerImpl;
	
	@Autowired
	private PersistenceService persistenceService;
	
	@Autowired
	private ControlService controlService;
	
	@RequestMapping(value = "/solution", method = RequestMethod.GET, produces = "application/json") 
	public JsonPreinscripcionAutomaticaSolution getSolution(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return convertToJsonPreinscripcionAutomaticaSolution(preinscripcionAutomaticaSolverManagerImpl.retrieveOrCreateSolution(request.getSession().getId(), 2017, 1, 25L));		
	}
	
	protected JsonPreinscripcionAutomaticaSolution convertToJsonPreinscripcionAutomaticaSolution(PreinscripcionAsignaturasSolution solution){
		return new JsonPreinscripcionAutomaticaSolution(solution.getListaProgramacionEstudiantes());
	}

	@RequestMapping(value = "/solution/solve", method = RequestMethod.GET, produces = "application/json")
	public JsonMessage solve(HttpServletRequest request, 
			@RequestParam(value = "anio", required = true) Integer anio,
    		@RequestParam(value = "periodo", required = false) Integer periodo,
    		@RequestParam(value = "codCarrera", required = false) Long codCarrera,
    		@RequestParam(value = "minutes", required = false) Integer minutos
			) {
		if(anio!=null && periodo!=null && codCarrera!=null){
						
			SgaEjecutaInscripcionAuto evento=controlService.obtenerEvento(codCarrera, anio, periodo);
			if(evento!=null){
				EstadoProcesoPlanificacion enumCode= EstadoProcesoPlanificacion.obtenerDesdeCodigo(evento.getId().getInsEstado());								
				if(!enumCode.equals(EstadoProcesoPlanificacion.PROCESO_EN_EJECUCION)){
					boolean success = preinscripcionAutomaticaSolverManagerImpl.solve(request.getSession().getId(), anio, periodo, codCarrera, minutos);	        
					return new JsonMessage(success ? "Planificacion inicia." : "La planificacion ya habia iniciado.");			
				}
				else{
					return new JsonMessage("El proceso de planificación ya habia iniciado, por favor espere hasta que finalize");
				}
			}
			else{
				boolean success = preinscripcionAutomaticaSolverManagerImpl.solve(request.getSession().getId(), anio, periodo, codCarrera, minutos);	        
				return new JsonMessage(success ? "Planificacion inicia." : "La planificacion ya habia iniciado.");
			}					
		}
		else{
			return new JsonMessage("La planificacion no puede empezar, año, periodo y codigo de carrera no pueden ser nulos");
		}		
	}
	
	
	@RequestMapping(value = "/solution/estado", method = RequestMethod.GET, produces = "application/json")
	public JsonMessage obtenerEstado(HttpServletRequest request, 
			@RequestParam(value = "anio", required = true) Integer anio,
    		@RequestParam(value = "periodo", required = false) Integer periodo,
    		@RequestParam(value = "codCarrera", required = false) Long codCarrera
			) {
		if(anio!=null && periodo!=null && codCarrera!=null){
			SgaEjecutaInscripcionAuto evento=controlService.obtenerEvento(codCarrera, anio, periodo);
			EstadoProcesoPlanificacion enumCode= EstadoProcesoPlanificacion.obtenerDesdeCodigo(evento.getId().getInsEstado());
			if(enumCode.equals(EstadoProcesoPlanificacion.PROCESO_EN_EJECUCION)){
				return new JsonMessage("El proceso de planificacion para estas variables año:"+anio+" periodo:"+periodo+" codigo carrera:"+codCarrera+" esta en ejecución");
			}
			else if(enumCode.equals(EstadoProcesoPlanificacion.PROCESO_YA_EJECUTADO)){
				return new JsonMessage("Ya se ha ejecutado un proceso para las variables año:"+anio+" periodo:"+periodo+" codigo carrera:"+codCarrera);
			}
			else if(enumCode.equals(EstadoProcesoPlanificacion.NO_EXISTENTE)){
				return new JsonMessage("No existe proceso para las variables año:"+anio+" periodo:"+periodo+" codigo carrera:"+codCarrera);
			}	
			return new JsonMessage("El código de estado no puede ser reconocido");
		}
		else{
			return new JsonMessage("Para consultar el estado año, periodo y codigo de carrera no pueden ser nulos");
		}
				
	}

	@RequestMapping(value = "/solution/terminateEarly", method = RequestMethod.GET, produces = "application/json")
	public JsonMessage terminateEarly(HttpServletRequest request) {
		boolean success = preinscripcionAutomaticaSolverManagerImpl.terminateEarly(request.getSession().getId());
		return new JsonMessage(success ? "Solver terminating early." : "Solver was already terminated.");
	}
	
	@RequestMapping(value = "/solution/persistir", method = RequestMethod.GET, produces = "application/json") 
	public JsonMessage persistirSolucion(HttpServletRequest request, 
			@RequestParam(value = "anio", required = true) Integer anio,
    		@RequestParam(value = "periodo", required = false) Integer periodo,
    		@RequestParam(value = "codCarrera", required = false) Long codCarrera
			) {
		// TODO 
		persistenceService.deleteAcinData(codCarrera, periodo, anio);
		List<Acin> listaDatos=persistenceService.obtenerAcinsPrePorCodigoCarreraPeriodoAnio(codCarrera, periodo, anio);
		persistenceService.persistirListaAcin(listaDatos);
		persistenceService.deleteAcinsPreData(codCarrera, periodo, anio);
		return new JsonMessage("Se han publicado los resultados");
	}


	
}
