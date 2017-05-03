package co.edu.udistrital.sga.preinscripcion.auto.domain;

import java.util.List;
import java.util.stream.Collectors;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Alexander
 * @version 1.0
 * @created 07-feb.-2017 15:56:30
 * Facts estudiante
 */
@Getter
@Setter
//@XStreamAlias("Estudiante")
public class Estudiante {

	private List<AsignaturaRequerida> preinscripcionPorDemanda;	
	private List<AsignaturaGrupo> asignaturasPosibles;
	private List<Long> asignaturasHomologadoras;
	private List<AsignaturaGrupo> asignaturasProgramadas;
	private Long codigo;	
	private Integer codigoPensum;	
	private Long codigoProyectoCurricular;
	private String nombre;
	private Integer clasificacion;
	private String tipo;
	

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



	public List<Long> getListaCodigosPorDemanda(){
		if(preinscripcionPorDemanda!=null){
			List<Long> listaCodigos=preinscripcionPorDemanda.stream().map(AsignaturaRequerida::getCodigoAsignatura).collect(Collectors.toList());			
			if(asignaturasHomologadoras!=null){
				listaCodigos.addAll(asignaturasHomologadoras);
			}
			return listaCodigos;
		}
		return null;
	}
	
	@Override
	public String toString(){
		return "sc:"+this.getCodigo();
	}
	
}