package co.edu.udistrital.sga.preinscripcion.auto.persistence.repositories.oracle;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.edu.udistrital.sga.preinscripcion.auto.domain.ProyectoCurricular;
import co.edu.udistrital.sga.preinscripcion.auto.persistence.entities.oracle.Accra;
import co.edu.udistrital.sga.preinscripcion.auto.persistence.entities.oracle.Acest;
import co.edu.udistrital.sga.preinscripcion.auto.persistence.entities.oracle.Acestado;
import co.edu.udistrital.sga.preinscripcion.auto.persistence.entities.oracle.AcestadoPK;

@Repository
public interface AcestadoRepository extends JpaRepository<Acestado, AcestadoPK> {
	
}
