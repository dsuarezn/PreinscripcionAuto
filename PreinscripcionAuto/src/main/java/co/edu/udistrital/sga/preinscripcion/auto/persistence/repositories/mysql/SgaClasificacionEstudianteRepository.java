package co.edu.udistrital.sga.preinscripcion.auto.persistence.repositories.mysql;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.udistrital.sga.preinscripcion.auto.persistence.entities.mysql.SgaClasificacionEstudiante;
import co.edu.udistrital.sga.preinscripcion.auto.persistence.entities.mysql.SgaClasificacionEstudiantePK;

@Repository
public interface SgaClasificacionEstudianteRepository extends JpaRepository<SgaClasificacionEstudiante, SgaClasificacionEstudiantePK> {
	 
}
