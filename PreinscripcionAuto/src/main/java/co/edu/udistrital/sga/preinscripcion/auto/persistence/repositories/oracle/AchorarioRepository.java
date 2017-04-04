package co.edu.udistrital.sga.preinscripcion.auto.persistence.repositories.oracle;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.udistrital.sga.preinscripcion.auto.persistence.entities.oracle.Acinsdemanda;
import co.edu.udistrital.sga.preinscripcion.auto.persistence.entities.oracle.AcinsdemandaPK;

@Repository
public interface AchorarioRepository extends JpaRepository<Acinsdemanda, AcinsdemandaPK> {
	
}
