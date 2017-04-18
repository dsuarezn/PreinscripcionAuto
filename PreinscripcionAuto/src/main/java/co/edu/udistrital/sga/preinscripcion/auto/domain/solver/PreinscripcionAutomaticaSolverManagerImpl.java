package co.edu.udistrital.sga.preinscripcion.auto.domain.solver;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.optaplanner.core.api.domain.solution.Solution;
import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;
import org.optaplanner.core.config.solver.termination.TerminationConfig;
import org.optaplanner.core.impl.score.director.ScoreDirector;
import org.optaplanner.core.impl.score.director.ScoreDirectorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import co.edu.udistrital.sga.preinscripcion.auto.domain.PreinscripcionAsignaturasSolution;
import co.edu.udistrital.sga.preinscripcion.auto.services.CursosService;
import co.edu.udistrital.sga.preinscripcion.auto.services.EstudiantesService;
import co.edu.udistrital.sga.preinscripcion.auto.services.ProyectoService;
import lombok.extern.java.Log;

@Component
@Log
@Qualifier("preinscripcionAutomaticaSolverManager")
public class PreinscripcionAutomaticaSolverManagerImpl implements Serializable, PreinscripcionAutomaticaSolverManager{

	
	@Autowired
    private ProyectoService proyectoService;
	@Autowired
    private CursosService cursosService;
	@Autowired
    private EstudiantesService estudiantesService;

	
	private static final long serialVersionUID = 3663335141070683532L;


	private static final String SOLVER_CONFIG = "co/edu/udistrital/sga/preinscripcion/auto/solver/PreinscripcionAutomaticaSolverConfig.xml";
	
	private SolverFactory<PreinscripcionAsignaturasSolution> solverFactory;
	private Map<String, PreinscripcionAsignaturasSolution> sessionSolutionMap;
	private Map<String, Solver<PreinscripcionAsignaturasSolution>> sessionSolverMap;

	private ExecutorService executor;
	
	public static ScoreDirector scoreDirector;
	
//	@PostConstruct
	public synchronized void init(){
		log.info("entro en inicia manager");
		 solverFactory = SolverFactory.createFromXmlResource(SOLVER_CONFIG);
	        // Always terminate a solver after 2 minutes
	        TerminationConfig terminationConfig = new TerminationConfig();
	        terminationConfig.setMinutesSpentLimit(2L);
	        solverFactory.getSolverConfig().setTerminationConfig(terminationConfig);
	        executor = Executors.newFixedThreadPool(2); // Only 2 because the other examples have their own Executor
	        // TODO these probably don't need to be thread-safe because all access is synchronized
	        sessionSolutionMap = new ConcurrentHashMap<>();
	        sessionSolverMap = new ConcurrentHashMap<>();
	}
	
//	@PreDestroy
	public synchronized void destroy(){
		log.info("entro en destroy");
		   for (Solver<PreinscripcionAsignaturasSolution> solver : sessionSolverMap.values()) {
	            solver.terminateEarly();
	        }
	        executor.shutdown();
	}
	
	public synchronized PreinscripcionAsignaturasSolution retrieveOrCreateSolution(String sessionid, Integer anio, Integer periodo, Long codCarrera){
		PreinscripcionAsignaturasSolution solution = sessionSolutionMap.get(sessionid);
        if (solution == null) {
        	solution=new PreinscripcionAsignaturasSolution(proyectoService, cursosService, estudiantesService);        	
        	solution.initFacts(anio, periodo, codCarrera);
            sessionSolutionMap.put(sessionid, solution);
        }
        return solution;
	}
	
	public synchronized boolean solve(final String sessionid, Integer anio, Integer periodo, Long codCarrera){
		 final Solver<PreinscripcionAsignaturasSolution> solver = solverFactory.buildSolver();
	        solver.addEventListener(event -> {
	        	PreinscripcionAsignaturasSolution bestSolution = event.getNewBestSolution();
	            synchronized (PreinscripcionAutomaticaSolverManagerImpl.this) {
	                sessionSolutionMap.put(sessionid, bestSolution);
	            }
	        });
	        if (sessionSolverMap.containsKey(sessionid)) {
	            return false;
	        }
	        sessionSolverMap.put(sessionid, solver);
	        final PreinscripcionAsignaturasSolution solution = retrieveOrCreateSolution(sessionid,anio,periodo,codCarrera);
	        executor.submit((Runnable) () -> {
	        	PreinscripcionAsignaturasSolution bestSolution = solver.solve(solution);
	            synchronized (PreinscripcionAutomaticaSolverManagerImpl.this) {
	                sessionSolutionMap.put(sessionid, bestSolution);
	                sessionSolverMap.remove(sessionid);
	            }
	        });
	        return true;
	}
	
	public synchronized boolean terminateEarly(String sessionid){
		   Solver<PreinscripcionAsignaturasSolution> solver = sessionSolverMap.remove(sessionid);
	        if (solver != null) {
	            solver.terminateEarly();
	            return true;
	        } else {
	            return false;
	        }
	}
	
	public PreinscripcionAsignaturasSolution testSolver() {
		Solver solver = SolverFactory.createFromXmlResource(SOLVER_CONFIG).buildSolver();
		ScoreDirectorFactory scoreDirectorFactory = solver.getScoreDirectorFactory();
		scoreDirector = scoreDirectorFactory.buildScoreDirector();
		PreinscripcionAsignaturasSolution preSolution = new PreinscripcionAsignaturasSolution(proyectoService, cursosService, estudiantesService);
		preSolution.initFacts(2017, 1, 25L);
		scoreDirector.setWorkingSolution(preSolution);		
		solver.solve(preSolution);
		PreinscripcionAsignaturasSolution bestPreSolution = (PreinscripcionAsignaturasSolution) solver.getBestSolution();
		return bestPreSolution;
	}
	
}
