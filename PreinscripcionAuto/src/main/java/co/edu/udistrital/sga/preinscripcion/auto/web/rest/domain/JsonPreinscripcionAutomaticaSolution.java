package co.edu.udistrital.sga.preinscripcion.auto.web.rest.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import co.edu.udistrital.sga.preinscripcion.auto.domain.AsignaturaGrupo;
import co.edu.udistrital.sga.preinscripcion.auto.domain.Estudiante;
import co.edu.udistrital.sga.preinscripcion.auto.domain.EstudianteXCurso;
import lombok.Data;
@Data
public class JsonPreinscripcionAutomaticaSolution {

	private List<Estudiante> listaEstudiantes=new ArrayList<>();
	
	public JsonPreinscripcionAutomaticaSolution(List<EstudianteXCurso> listaProgramaciónEstudiantes) {
		if(listaProgramaciónEstudiantes==null){return;}
		Map<Estudiante, List<EstudianteXCurso>> agrupados=listaProgramaciónEstudiantes.stream().collect(Collectors.groupingBy(EstudianteXCurso::getEstudiante));
	
		List<Estudiante> listaEstudiantes=new ArrayList<>();
 		for (Map.Entry<Estudiante, List<EstudianteXCurso>> entry : agrupados.entrySet())
		{
 			Estudiante estudiante=entry.getKey();
// 			estudiante.setAsignaturasPosibles(null);
// 			estudiante.setPreinscripcionPorDemanda(null);
 			List<AsignaturaGrupo> listaAsignaturas=new ArrayList<>();
 			for (EstudianteXCurso estcurso : entry.getValue()) {
				listaAsignaturas.add(estcurso.getCurso());
			} 			
 			estudiante.setAsignaturasProgramadas(listaAsignaturas);
		    listaEstudiantes.add(estudiante);
		}
		
 		this.listaEstudiantes=listaEstudiantes;
	}

	
	
	
}
