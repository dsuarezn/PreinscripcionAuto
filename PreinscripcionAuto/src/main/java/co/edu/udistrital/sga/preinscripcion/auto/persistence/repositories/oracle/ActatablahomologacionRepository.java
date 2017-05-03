package co.edu.udistrital.sga.preinscripcion.auto.persistence.repositories.oracle;


import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.edu.udistrital.sga.preinscripcion.auto.domain.ProyectoCurricular;
import co.edu.udistrital.sga.preinscripcion.auto.persistence.entities.oracle.Actablahomologacion;

@Repository
public interface ActatablahomologacionRepository extends JpaRepository<Actablahomologacion, Long> {
	 @Query("select a from Actablahomologacion a where a.homCraCodPpal = :codigoCarrera and a.homTipoHom = :tipo and a.homEstado like %:estado%")
	 List<Actablahomologacion> obtenerHomologacionesCarrera(@Param("codigoCarrera") Long codigoCarrera, @Param("tipo") Long tipoHom, @Param("estado") String estado);
}
