package co.edu.udistrital.sga.preinscripcion.auto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;
import org.optaplanner.core.api.domain.entity.PlanningEntity;
import co.edu.udistrital.sga.preinscripcion.auto.common.domain.AbstractPersistable;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @author Alexander
 * @version 1.0
 * @created 07-feb.-2017 15:56:30
 * Facts estudiante
 */
@Getter
@Setter
@XStreamAlias("Estudiante")
public class Estudiante extends AbstractPersistable{


	private List<AsignaturaRequerida> preinscripcionPorDemanda;	
	private List<AsignaturaGrupo> asignaturasPosibles;	
	private Long codigo;
	private Pensum m_Pensum;
	private Integer codigoPensum;
	private ProyectoCurricular m_ProyectoCurricular;
	private Long codigoProyectoCurricular;
	private String nombre;
	private Integer clasificacion;
	private String tipo;
	
//	private Integer periodoIngreso;
//	private Integer creditosMaximosPorPeriodo;
//	
	

	public Estudiante(){

	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estudiante other = (Estudiante) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

//	public static Double valorarCompletitudAsignaturas(List<Integer> listaMateriasInscritas, List<Integer> listaPreinsPorDemanda){
//		if(listaMateriasInscritas.size()<1){return 0D;}
//		if(listaPreinsPorDemanda.size()<1){return 0D;}
//		Long valor = 0L;
//		for (Integer asignaturacod : listaPreinsPorDemanda) {
//			if(listaMateriasInscritas.contains(asignaturacod)){
//				valor++;
//			}
//		}
//		return (double) (valor.doubleValue()/((double)listaPreinsPorDemanda.size()));		
//	}

	public List<Long> getListaCodigosPorDemanda(){
		if(preinscripcionPorDemanda!=null){
			return preinscripcionPorDemanda.stream().map(AsignaturaRequerida::getCodigoAsignatura).collect(Collectors.toList());			
		}
		return null;
	}
//	@Test
//	public void test(){
//		List<Integer> listaPorDemanda=new ArrayList<>();
//		listaPorDemanda.add(75896);
//		listaPorDemanda.add(50236);
//		listaPorDemanda.add(47589);
//		listaPorDemanda.add(67890);
//		List<Integer> listaPreinscrita=new ArrayList<>();
//		listaPreinscrita.add(75896);
//		listaPreinscrita.add(50236);
////		listaPreinscrita.add(47589);
//		System.out.println(valorarCompletitudAsignaturas(listaPreinscrita, listaPorDemanda));
//	}
	
//	@Test
//	public void test(){	
//		System.out.println(valorarCompletitudAsignaturas(1, 0.5));
//	}


//	public static Double valorarCompletitudAsignaturas(Integer clasificacion, Double porcentajeCompletitud){
//		if(clasificacion<1){
//			return 0.1 * porcentajeCompletitud;
//		}		
//		return (100/clasificacion.doubleValue())*(porcentajeCompletitud);			
//	}
	
	
}