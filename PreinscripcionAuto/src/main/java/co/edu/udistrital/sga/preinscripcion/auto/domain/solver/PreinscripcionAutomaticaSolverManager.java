package co.edu.udistrital.sga.preinscripcion.auto.domain.solver;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;
import org.optaplanner.core.config.solver.termination.TerminationConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import co.edu.udistrital.sga.preinscripcion.auto.domain.PreinscripcionAsignaturasSolution;
import lombok.extern.java.Log;

@Component
@Log
@Qualifier("preinscripcionAutomaticaSolverManager")
public class PreinscripcionAutomaticaSolverManager implements Serializable{

	
	private static final long serialVersionUID = 3663335141070683532L;


	private static final String SOLVER_CONFIG = "co/edu/udistrital/sga/preinscripcion/auto/solver/PreinscripcionAutomaticaScoreRules.xml";
	
	private SolverFactory<PreinscripcionAsignaturasSolution> solverFactory;
	private Map<String, PreinscripcionAsignaturasSolution> sessionSolutionMap;
	private Map<String, Solver<PreinscripcionAsignaturasSolution>> sessionSolverMap;

	private ExecutorService executor;
	
	@PostConstruct
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
	
	@PreDestroy
	public synchronized void destroy(){
		log.info("entro en destroy");
		   for (Solver<PreinscripcionAsignaturasSolution> solver : sessionSolverMap.values()) {
	            solver.terminateEarly();
	        }
	        executor.shutdown();
	}
	
	public synchronized PreinscripcionAsignaturasSolution retrieveOrCreateSolution(String sessionid){
		log.info("entro en retrieveorcreate");

		return null;
	}
	
	public synchronized boolean solve(final String sessionid){
		log.info("entro en solve");
		
		return false;
	}
	
	public synchronized boolean terminateEarly(String sessionid){
		log.info("entro en terminateearly");
				
		return false;
	}
	
}
