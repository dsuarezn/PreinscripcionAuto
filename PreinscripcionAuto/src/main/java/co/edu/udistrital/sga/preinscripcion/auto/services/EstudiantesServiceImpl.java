package co.edu.udistrital.sga.preinscripcion.auto.services;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udistrital.sga.preinscripcion.auto.domain.Estudiante;
import co.edu.udistrital.sga.preinscripcion.auto.persistence.entities.mysql.SgaClasificacionEstudiante;
import co.edu.udistrital.sga.preinscripcion.auto.persistence.entities.oracle.Acest;
import co.edu.udistrital.sga.preinscripcion.auto.persistence.repositories.mysql.SgaClasificacionEstudianteRepository;
import co.edu.udistrital.sga.preinscripcion.auto.persistence.repositories.oracle.AcestRepository;

@Service
@Transactional
@Qualifier("estudiantesServiceImpl")
public class EstudiantesServiceImpl implements EstudiantesService {

	
	private final Integer CLASIFICACION_MINIMA=6;
	
	@Autowired
	private SgaClasificacionEstudianteRepository sgaClasificacionEstudianteRepository;
	
	@Autowired
	private AcestRepository acestRepository;
	
	@Override
	public List<Estudiante> obtenerListaEstudiantes() {
		
		List<SgaClasificacionEstudiante> clasificacionList= sgaClasificacionEstudianteRepository.findAllByOrderByCleClasificacion();
//		List<Acest> estudianteList=acestRepository.findByEstEstadoEstContaining("A");
//		List<Acest> estudianteList=acestRepository.findByEstCod(20122025041L);
		List<Acest> estudianteList=acestRepository.findByEstCodLessThan(20142025041L);
		List<Estudiante> listaDominio=new ArrayList<>();
		
		for (Acest estudiante : estudianteList) {
			SgaClasificacionEstudiante result =clasificacionList.stream().filter(x -> x.getId().getCle_codEstudiante()==estudiante.getEstCod()).findAny().orElse(null);
			Estudiante estd=new Estudiante();
			estd.setCodigo(estudiante.getEstCod());
			estd.setCodigoPensum(estudiante.getEstPenNro());	
			estd.setCodigoProyectoCurricular(estudiante.getAccra().getCraCod());
			estd.setNombre(estudiante.getEstNombre());
			if(result!=null){
				estd.setTipo(result.getCle_tipoEstudiante());
				estd.setClasificacion(result.getCleClasificacion());
			}	
			else{
				System.out.println("Estudiante sin clasificacion:"+estd.getCodigo());
				estd.setClasificacion(CLASIFICACION_MINIMA);
			}
			listaDominio.add(estd);
			
			
		}
		return listaDominio;
	}

}
