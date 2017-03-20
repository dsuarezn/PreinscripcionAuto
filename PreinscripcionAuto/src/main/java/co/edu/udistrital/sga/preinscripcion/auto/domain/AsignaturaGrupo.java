package co.edu.udistrital.sga.preinscripcion.auto.domain;


import co.edu.udistrital.sga.preinscripcion.auto.common.domain.AbstractPersistable;
import java.util.List;


/**
 * @author Alexander
 * @version 1.0
 * @created 07-feb.-2017 15:56:30
 * fact asignaturas por grupos generadas
 */
public class AsignaturaGrupo extends AbstractPersistable {
	
	private Long idAsignaturaGrupo;
	private Asignatura asignatura;
	private Long codigoAsignatura;
	private Integer cupos;	
	private Integer inscritos;
	private Integer capacidadMaxima;
	private List<Horario> horario;
	private Ubicacion ubicacion;
	private Long codigoUbicacion;
	private Long codigoGrupo;
	

	public AsignaturaGrupo(){

	}
	
	
	
	
	
	





	public AsignaturaGrupo(Long idAsignaturaGrupo, Long codigoAsignatura, Integer cupos, Integer inscritos,
			Integer capacidadMaxima, Long codigoUbicacion, Long codigoGrupo) {
		super();
		this.idAsignaturaGrupo = idAsignaturaGrupo;
		this.codigoAsignatura = codigoAsignatura;
		this.cupos = cupos;
		this.inscritos = inscritos;
		this.capacidadMaxima = capacidadMaxima;
	
		this.codigoUbicacion = codigoUbicacion;
		this.codigoGrupo = codigoGrupo;
	}











	/**
	 * 
	 * @exception Throwable Throwable
	 */
	public void finalize()
	  throws Throwable{

	}

	public Asignatura getasignatura(){
		return asignatura;
	}

	public Integer getcupos(){
		return cupos;
	}

	

	
	public void setasignatura(Asignatura newVal){
		asignatura = newVal;
	}

	
	public void setcupos(Integer newVal){
		cupos = newVal;
	}

	

	public Integer getCupos() {
		return cupos;
	}

	public void setCupos(Integer cupos) {
		this.cupos = cupos;
	}

	

	public Asignatura getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}


	public Long getCodigoGrupo() {
		return codigoGrupo;
	}

	public void setCodigoGrupo(Long codigoGrupo) {
		this.codigoGrupo = codigoGrupo;
	}

	public Long getIdAsignaturaGrupo() {
		return idAsignaturaGrupo;
	}

	public void setIdAsignaturaGrupo(Long idAsignaturaGrupo) {
		this.idAsignaturaGrupo = idAsignaturaGrupo;
	}

	public Integer getInscritos() {
		return inscritos;
	}

	public void setInscritos(Integer inscritos) {
		this.inscritos = inscritos;
	}

	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Integer getCapacidadMaxima() {
		return capacidadMaxima;
	}

	public void setCapacidadMaxima(Integer capacidadMaxima) {
		this.capacidadMaxima = capacidadMaxima;
	}


	
	

}