package co.edu.udistrital.sga.preinscripcion.auto.persistence.repositories.oracle;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.edu.udistrital.sga.preinscripcion.auto.domain.AsignaturaGrupo;
import co.edu.udistrital.sga.preinscripcion.auto.persistence.entities.oracle.Acinsdemanda;
import co.edu.udistrital.sga.preinscripcion.auto.persistence.entities.oracle.AcinsdemandaPK;

@Repository
public interface AchorarioRepository extends JpaRepository<Acinsdemanda, AcinsdemandaPK> {
	
	

	
}
