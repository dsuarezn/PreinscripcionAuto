package co.edu.udistrital.sga.preinscripcion.auto.domain;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


import com.thoughtworks.xstream.annotations.XStreamAlias;

import co.edu.udistrital.sga.preinscripcion.auto.common.domain.AbstractPersistable;
import co.edu.udistrital.sga.preinscripcion.auto.persistence.entities.oracle.Accurso;
import co.edu.udistrital.sga.preinscripcion.auto.persistence.entities.oracle.Achorario;
import lombok.Getter;
import lombok.Setter;


/**
 * @author Alexander
 * @version 1.0
 * @created 07-feb.-2017 15:56:30
 * fact asignaturas por grupos generadas
 */
@Getter
@Setter
//@XStreamAlias("AsignaturaGrupo")
public class AsignaturaGrupo extends AbstractPersistable {
	
	private Long idAsignaturaGrupo;
//	private Asignatura asignatura;
	private Long codigoAsignatura;
	private Integer cupos;	
	private Integer inscritos;
	private Integer capacidadMaxima;
	private List<Horario> horarios;
	private Ubicacion ubicacion;
	private Long codigoUbicacion;
	private Long codigoGrupo;
	private Integer creditos;
	private Integer ranking;
	private Integer semestre;
	private Integer ceaCode;
	private Long codCarrera;
	

	public AsignaturaGrupo(){

	}

//	@SuppressWarnings({ "unchecked", "rawtypes" })
//	public AsignaturaGrupo(Long idAsignaturaGrupo, Long codigoAsignatura, Integer cupos, Integer inscritos,
//			Integer capacidadMaxima, Long codigoUbicacion, Long codigoGrupo) {
//		super();
//		this.idAsignaturaGrupo = idAsignaturaGrupo;
//		this.codigoAsignatura = codigoAsignatura;
//		this.cupos = cupos;
//		this.inscritos = inscritos;
//		this.capacidadMaxima = capacidadMaxima;
//	
//		this.codigoUbicacion = codigoUbicacion;
//		this.codigoGrupo = codigoGrupo;
////		this.achorarios=curso.getAchorarios();
//	}

	
	public AsignaturaGrupo(Accurso curso) {
		super();
		this.idAsignaturaGrupo = curso.getCurId();
		this.codigoAsignatura = curso.getCurAsiCod();
		this.cupos = curso.getCurNroCupo();
		this.inscritos = curso.getCurNroIns();
		this.capacidadMaxima = curso.getCurCapMax();
	
		this.codigoUbicacion = curso.getCurDepCod();
		this.codigoGrupo = curso.getCurGrupo();
		this.horarios=obtenerHorarioAchorarios(curso.getAchorarios());
		this.codCarrera=curso.getCurCraCod();
		this.ranking=0;
		
		
	}
	
	public List<Horario> obtenerHorarioAchorarios(List<Achorario> achorarios){
		List<Horario> horarios=new ArrayList<Horario>();		
		Map<Integer,List<Achorario>> horariosAgrupados=achorarios.stream().collect(Collectors.groupingBy(Achorario::getHorDiaNro));		
		for (Map.Entry<Integer,List<Achorario>> entry : horariosAgrupados.entrySet())
		{
			Horario horario=new Horario(DiasSemana.obtenerDesdeEnterio(entry.getKey()), obtenerIntervaloDeTiempo(entry.getValue()));
			horarios.add(horario);
		}
		return horarios;
	}
	
	
	public List<IntervaloDeTiempo> obtenerIntervaloDeTiempo(List<Achorario> lista){
		List<IntervaloDeTiempo> listaIntervalos=new ArrayList<>();		
		for (Achorario achorario : lista) {			
			listaIntervalos.add(IntervaloDeTiempo.obtenerDesdeEntero(achorario.getHorHora()));
		}
		return listaIntervalos;
	}

	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AsignaturaGrupo other = (AsignaturaGrupo) obj;
		if (idAsignaturaGrupo == null) {
			if (other.idAsignaturaGrupo != null)
				return false;
		} else if (!idAsignaturaGrupo.equals(other.idAsignaturaGrupo))
			return false;
		return true;
	}
	
	
//	public void setCreditosOptional(Optional<Integer> value){
//		this.creditos=value.get();
//	}
	
	@Override
	public String toString(){
		return "ac:"+this.codigoAsignatura+": aid:"+this.idAsignaturaGrupo;
	}

}