package co.edu.udistrital.sga.preinscripcion.auto.persistence.repositories.oracle;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.edu.udistrital.sga.preinscripcion.auto.domain.ProyectoCurricular;
import co.edu.udistrital.sga.preinscripcion.auto.persistence.entities.oracle.Accra;
import co.edu.udistrital.sga.preinscripcion.auto.persistence.entities.oracle.Acest;

@Repository
public interface AcestRepository extends JpaRepository<Acest, Long> {
	
	public List<Acest> findByEstEstadoEstContaining(String estEstadoEst);
	
}
