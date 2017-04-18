package co.edu.udistrital.sga.preinscripcion.auto.web.rest.controller;

import java.util.List;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.udistrital.sga.preinscripcion.auto.domain.AsignaturaGrupo;
import co.edu.udistrital.sga.preinscripcion.auto.domain.AsignaturaRequerida;
import co.edu.udistrital.sga.preinscripcion.auto.domain.Estudiante;
import co.edu.udistrital.sga.preinscripcion.auto.domain.PreinscripcionAsignaturasSolution;
import co.edu.udistrital.sga.preinscripcion.auto.domain.ProyectoCurricular;
import co.edu.udistrital.sga.preinscripcion.auto.domain.solver.PreinscripcionAutomaticaSolverManager;
import co.edu.udistrital.sga.preinscripcion.auto.domain.solver.PreinscripcionAutomaticaSolverManagerImpl;
import co.edu.udistrital.sga.preinscripcion.auto.services.CursosService;
import co.edu.udistrital.sga.preinscripcion.auto.services.EstudiantesService;
import co.edu.udistrital.sga.preinscripcion.auto.services.ProyectoService;
import co.edu.udistrital.sga.preinscripcion.auto.web.rest.domain.JsonMessage;
import co.edu.udistrital.sga.preinscripcion.auto.web.rest.domain.JsonPreinscripcionAutomaticaSolution;


@RestController
@RequestMapping("/rest")
public class PreinscripcionAutomaticaRestControllerImpl {

	@Autowired
	private PreinscripcionAutomaticaSolverManager preinscripcionAutomaticaSolverManagerImpl;
	
	
	@RequestMapping(value = "/solution", method = RequestMethod.GET, produces = "application/json") 
	public JsonPreinscripcionAutomaticaSolution getSolution(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return convertToJsonPreinscripcionAutomaticaSolution(preinscripcionAutomaticaSolverManagerImpl.retrieveOrCreateSolution(request.getSession().getId(), 2017, 1, 25L));		
	}
	
	protected JsonPreinscripcionAutomaticaSolution convertToJsonPreinscripcionAutomaticaSolution(PreinscripcionAsignaturasSolution solution){
		return new JsonPreinscripcionAutomaticaSolution(solution.getListaProgramacionEstudiantes());
	}

	@RequestMapping(value = "/solution/solve", method = RequestMethod.GET, produces = "application/json")
	public JsonMessage solve(HttpServletRequest request) {
		boolean success = preinscripcionAutomaticaSolverManagerImpl.solve(request.getSession().getId(), 2017, 1, 25L);
        return new JsonMessage(success ? "Solving started." : "Solver was already running.");
	}

	@RequestMapping(value = "/solution/terminateEarly", method = RequestMethod.POST, produces = "application/json")
	public JsonMessage terminateEarly(HttpServletRequest request) {
		boolean success = preinscripcionAutomaticaSolverManagerImpl.terminateEarly(request.getSession().getId());
		return new JsonMessage(success ? "Solver terminating early." : "Solver was already terminated.");
	}

	@RequestMapping(value = "/solution/solve/static", method = RequestMethod.GET, produces = "application/json")
	public JsonPreinscripcionAutomaticaSolution solveStatic(HttpServletRequest request) {
		try {
			PreinscripcionAsignaturasSolution solution = preinscripcionAutomaticaSolverManagerImpl.testSolver();
			return convertToJsonPreinscripcionAutomaticaSolution(solution);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
