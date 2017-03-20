package co.edu.udistrital.sga.preinscripcion.auto.web.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.udistrital.sga.preinscripcion.auto.domain.ProyectoCurricular;
import co.edu.udistrital.sga.preinscripcion.auto.persistence.AccraRepository;


@RestController
@RequestMapping("/rest/carreras")
public class PruebaConsultas {

	@Autowired
    private AccraRepository accraRepository;
	
	
	@RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<ProyectoCurricular> consultarConnexiones() {     	
    	System.out.println("Entra a controlador");
		return accraRepository.obtenerProyectosCoordinador(25);
    }
	
}
