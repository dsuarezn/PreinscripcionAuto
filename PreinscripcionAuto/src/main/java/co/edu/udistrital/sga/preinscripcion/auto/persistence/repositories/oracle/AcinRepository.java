package co.edu.udistrital.sga.preinscripcion.auto.persistence.repositories.oracle;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udistrital.sga.preinscripcion.auto.persistence.entities.oracle.Acin;
import co.edu.udistrital.sga.preinscripcion.auto.persistence.entities.oracle.AcinPK;

@Repository
public interface AcinRepository extends JpaRepository<Acin, AcinPK> {
	@Modifying
    @Transactional	
	@Query("delete from Acin a where a.id.insAno = :anio and a.id.insPer = :periodo and a.insCraCod = :codCarrera")
	public void borrarRegistrosPorCodCarreraAnioPeriodo(@Param("anio")Integer anio,@Param("periodo")Integer periodo,@Param("codCarrera") Long codCarrera);
}
