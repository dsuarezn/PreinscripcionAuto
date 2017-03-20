package co.edu.udistrital.sga.preinscripcion.auto.persistence;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.edu.udistrital.sga.preinscripcion.auto.domain.ProyectoCurricular;
import co.edu.udistrital.sga.preinscripcion.auto.persistence.entities.oracle.Accra;

@Repository
public interface AccraRepository extends JpaRepository<Accra, Long> {
	 
	 @Query("select NEW co.edu.udistrital.sga.preinscripcion.auto.domain.ProyectoCurricular(pc.craCod,pc.craNombre) FROM Accra pc where pc.craEmpNroIden=(select p.craEmpNroIden from Accra p where p.craCod = :codigoCarrera)")
	 List<ProyectoCurricular> obtenerProyectosCoordinador(@Param("codigoCarrera") long codigoCarrera);
}
