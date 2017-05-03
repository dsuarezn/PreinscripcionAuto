package co.edu.udistrital.sga.preinscripcion.auto.persistence.repositories.oracle;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udistrital.sga.preinscripcion.auto.persistence.entities.oracle.Acin;
import co.edu.udistrital.sga.preinscripcion.auto.persistence.entities.oracle.Acinspre;
import co.edu.udistrital.sga.preinscripcion.auto.persistence.entities.oracle.AcinsprePK;

@Repository
public interface AcinspreRepository extends JpaRepository<Acinspre, AcinsprePK> {
	@Modifying
    @Transactional
	@Query("delete from Acinspre a where a.id.insAno = :anio and a.id.insPer = :periodo and a.id.insCraCod = :codCarrera")
	public void borrarRegistrosPorCodCarreraAnioPeriodo(@Param("anio")Integer anio,@Param("periodo")Integer periodo,@Param("codCarrera") Long codCarrera);

	@Query("select new co.edu.udistrital.sga.preinscripcion.auto.persistence.entities.oracle.Acin(ac) from Acinspre ac where ac.id.insCraCod = :codCarrera and ac.id.insPer = :periodo and ac.id.insAno = :anio")
	public List<Acin> obtenerAcinPorCodCarreraAnioPeriodo(@Param("anio")Integer anio,@Param("periodo")Integer periodo,@Param("codCarrera") Long codCarrera);
	
}
