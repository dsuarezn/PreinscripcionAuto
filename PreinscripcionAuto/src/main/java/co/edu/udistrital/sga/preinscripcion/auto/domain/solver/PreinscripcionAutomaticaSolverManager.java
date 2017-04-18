package co.edu.udistrital.sga.preinscripcion.auto.domain.solver;

import java.io.Serializable;

import co.edu.udistrital.sga.preinscripcion.auto.domain.PreinscripcionAsignaturasSolution;

public interface PreinscripcionAutomaticaSolverManager extends Serializable{

	public void init();
	
	public void destroy();
	
	public PreinscripcionAsignaturasSolution retrieveOrCreateSolution(String sessionid, Integer anio, Integer periodo, Long codCarrera);
	
	public boolean solve(final String sessionid, Integer anio, Integer periodo, Long codCarrera);
	
	public boolean terminateEarly(String sessionid);
	
	public PreinscripcionAsignaturasSolution testSolver();
}
