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
import org.optaplanner.core.config.solver.termination.TerminationCompositionStyle;
import org.optaplanner.core.config.solver.termination.TerminationConfig;
import org.optaplanner.core.impl.score.director.ScoreDirector;
import org.optaplanner.core.impl.score.director.ScoreDirectorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import co.edu.udistrital.sga.preinscripcion.auto.common.domain.EstadoProcesoPlanificacion;
import co.edu.udistrital.sga.preinscripcion.auto.domain.PreinscripcionAsignaturasSolution;
import co.edu.udistrital.sga.preinscripcion.auto.services.CursosService;
import co.edu.udistrital.sga.preinscripcion.auto.services.EstudiantesService;
import co.edu.udistrital.sga.preinscripcion.auto.services.PersistenceService;
import co.edu.udistrital.sga.preinscripcion.auto.services.ControlService;
import lombok.extern.java.Log;

@Component
@Log
@Qualifier("preinscripcionAutomaticaSolverManager")
public class PreinscripcionAutomaticaSolverManagerImpl implements Serializable, PreinscripcionAutomaticaSolverManager{

	
	@Autowired
    private ControlService controlService;
	@Autowired
    private CursosService cursosService;
	@Autowired
    private EstudiantesService estudiantesService;
	@Autowired
	private PersistenceService persistenceService;

	
	private static final long serialVersionUID = 3663335141070683532L;
	private final String bestScoreLimit="0hard/0soft";


	private static final String SOLVER_CONFIG = "co/edu/udistrital/sga/preinscripcion/auto/solver/PreinscripcionAutomaticaSolverConfig.xml";
	
	private SolverFactory<PreinscripcionAsignaturasSolution> solverFactory;
	private Map<String, PreinscripcionAsignaturasSolution> sessionSolutionMap;
	private Map<String, Solver<PreinscripcionAsignaturasSolution>> sessionSolverMap;

	private ExecutorService executor;
	
	public static ScoreDirector scoreDirector;
	
	@PostConstruct
	public synchronized void init(){
		log.info("entro en inicia manager");
		 solverFactory = SolverFactory.createFromXmlResource(SOLVER_CONFIG);
	        // Always terminate a solver after 2 minutes	     
	        executor = Executors.newFixedThreadPool(2); // Only 2 because the other examples have their own Executor
	        // TODO these probably don't need to be thread-safe because all access is synchronized
	        sessionSolutionMap = new ConcurrentHashMap<>();
	        sessionSolverMap = new ConcurrentHashMap<>();
	}
	
	@PreDestroy
	public synchronized void destroy(){
		log.info("entro en destroy");
		   for (Solver<PreinscripcionAsignaturasSolution> solver : sessionSolverMap.values()) {
	            solver.terminateEarly();
	        }
	        executor.shutdown();
	}
	
	public synchronized PreinscripcionAsignaturasSolution retrieveOrCreateSolution(String sessionid, Integer anio, Integer periodo, Long codCarrera){
		PreinscripcionAsignaturasSolution solution = sessionSolutionMap.get(sessionid);
        if (solution == null && anio !=null && periodo != null && codCarrera != null) {
        	solution=new PreinscripcionAsignaturasSolution(controlService, cursosService, estudiantesService);        	
        	solution.initFacts(anio, periodo, codCarrera);
            sessionSolutionMap.put(sessionid, solution);
        }
        return solution;
	}
	
	public synchronized boolean solve(final String sessionid, Integer anio, Integer periodo, Long codCarrera, Integer minutesSpent){
		
		controlService.setUpdateEventoInscripcionAutomatica(codCarrera, anio, periodo, EstadoProcesoPlanificacion.PROCESO_EN_EJECUCION);
		
		Solver<PreinscripcionAsignaturasSolution> solverTemp=null;		
		if(minutesSpent!=null){
			SolverFactory<PreinscripcionAsignaturasSolution> ownSolverFactory=solverFactory.cloneSolverFactory();
			ownSolverFactory.getSolverConfig().getPhaseConfigList().get(0).getTerminationConfig().setMinutesSpentLimit(minutesSpent.longValue());			
			solverTemp = ownSolverFactory.buildSolver();
		}
		else{
			solverTemp = solverFactory.buildSolver();
		}
		
		final Solver<PreinscripcionAsignaturasSolution> solver = solverTemp;
				
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
	            controlService.setUpdateEventoInscripcionAutomatica(codCarrera, anio, periodo, EstadoProcesoPlanificacion.PROCESO_YA_EJECUTADO);
	            persistenceService.deleteAcinsPreData(solution.getCodCarrera(), solution.getPeriodo(), solution.getAnio());
	            persistenceService.persistirSolucionAcinsPre(solution);
	        });
	        
	        return true;
	}
	
	public synchronized boolean terminateEarly(String sessionid){
		   Solver<PreinscripcionAsignaturasSolution> solver = sessionSolverMap.remove(sessionid);
	        if (solver != null) {
	            solver.terminateEarly();
	            Long codCarrera=solver.getBestSolution().getCodCarrera();
	            Integer anio=solver.getBestSolution().getAnio();
	            Integer periodo=solver.getBestSolution().getPeriodo();
	            return true;
	        } else {
	            return false;
	        }
	}
	

	
}
