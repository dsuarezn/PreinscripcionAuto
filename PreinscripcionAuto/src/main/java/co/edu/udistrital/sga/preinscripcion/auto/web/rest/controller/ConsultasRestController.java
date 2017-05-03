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
import co.edu.udistrital.sga.preinscripcion.auto.domain.solver.PreinscripcionAutomaticaSolverManagerImpl;
import co.edu.udistrital.sga.preinscripcion.auto.services.CursosService;
import co.edu.udistrital.sga.preinscripcion.auto.services.EstudiantesService;
import co.edu.udistrital.sga.preinscripcion.auto.services.ControlService;


@RestController
@RequestMapping("/rest")
public class ConsultasRestController {

	@Autowired
    private ControlService proyectoService;
	@Autowired
    private CursosService cursosService;
	@Autowired
    private EstudiantesService estudiantesService;
	
	@RequestMapping(value = "/carreras", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<ProyectoCurricular> consultarConnexiones() {     	    	
		return proyectoService.obtenerProyectosCoordinador(25);
    }
	
	@RequestMapping(value = "/asignaturas", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<AsignaturaGrupo> consultarCursos() {     	    	
		return cursosService.obtenerCursosProgramados(2017, 1, 25L);
    }

	@RequestMapping(value = "/estudiantes", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<Estudiante> consultarEstudiantes() {     	    	
		return estudiantesService.obtenerListaEstudiantes();
    }
	
	@RequestMapping(value = "/demanda", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<AsignaturaRequerida> consultarAsignaturasPorDemanda() {     	    	
		return cursosService.obtenerListaMateriasPreinsDemanda(2017, 1, 25L,"%A%");
    }
//	
//	@RequestMapping(value = "/preins", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody List<AsignaturaRequerida> consultarAsignaturasInsPre() {     	    	
//		return cursosService.obtenerListaMateriasPreinsPre(2017, 1, 25L,"%A%");
//    }
	
	
}
