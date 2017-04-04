package co.edu.udistrital.sga.preinscripcion.auto.persistence.repositories.mysql;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.udistrital.sga.preinscripcion.auto.persistence.entities.mysql.SgaRankingpreinsdemanda;
import co.edu.udistrital.sga.preinscripcion.auto.persistence.entities.mysql.SgaRankingpreinsdemandaPK;

@Repository
public interface SgaRankingPreinscDemandaRepository extends JpaRepository<SgaRankingpreinsdemanda, SgaRankingpreinsdemandaPK> {
	 
}
