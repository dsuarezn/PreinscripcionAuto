package co.edu.udistrital.sga.preinscripcion.auto.web.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.udistrital.sga.preinscripcion.auto.domain.AsignaturaGrupo;
import co.edu.udistrital.sga.preinscripcion.auto.domain.AsignaturaRequerida;
import co.edu.udistrital.sga.preinscripcion.auto.domain.Estudiante;
import co.edu.udistrital.sga.preinscripcion.auto.domain.ProyectoCurricular;
import co.edu.udistrital.sga.preinscripcion.auto.domain.solver.PreinscripcionAutomaticaSolverManager;
import co.edu.udistrital.sga.preinscripcion.auto.services.CursosService;
import co.edu.udistrital.sga.preinscripcion.auto.services.EstudiantesService;
import co.edu.udistrital.sga.preinscripcion.auto.services.ProyectoService;
import co.edu.udistrital.sga.preinscripcion.auto.web.rest.domain.JsonMessage;
import co.edu.udistrital.sga.preinscripcion.auto.web.rest.domain.JsonPreinscripcionAutomaticaSolution;


@RequestMapping("/rest")
public class PreinscripcionAutomaticaRestControllerImpl {

	@Autowired
	private PreinscripcionAutomaticaSolverManager preinscripcionAutomaticaSolverManager;
	
	
	@RequestMapping(value = "/solution", method = RequestMethod.GET, produces = "application/json") 
	public JsonPreinscripcionAutomaticaSolution getSolution() {
		// TODO Auto-generated method stub
		return null;
	}

	@RequestMapping(value = "/solution/solve", method = RequestMethod.POST, produces = "application/json")
	public JsonMessage solve() {
		// TODO Auto-generated method stub
		return null;
	}

	@RequestMapping(value = "/solution/terminateEarly", method = RequestMethod.POST, produces = "application/json")
	public JsonMessage terminateEarly() {
		// TODO Auto-generated method stub
		return null;
	}


}
