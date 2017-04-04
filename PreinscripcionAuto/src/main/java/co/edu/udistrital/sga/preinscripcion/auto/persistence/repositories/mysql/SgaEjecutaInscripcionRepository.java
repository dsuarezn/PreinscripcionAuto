package co.edu.udistrital.sga.preinscripcion.auto.persistence.repositories.mysql;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.udistrital.sga.preinscripcion.auto.persistence.entities.mysql.SgaEjecutaInscripcionAuto;
import co.edu.udistrital.sga.preinscripcion.auto.persistence.entities.mysql.SgaEjecutaInscripcionAutoPK;

@Repository
public interface SgaEjecutaInscripcionRepository extends JpaRepository<SgaEjecutaInscripcionAuto, SgaEjecutaInscripcionAutoPK> {
	 
}
