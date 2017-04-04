package co.edu.udistrital.sga.preinscripcion.auto.persistence.repositories.oracle;


import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.edu.udistrital.sga.preinscripcion.auto.domain.AsignaturaGrupo;
import co.edu.udistrital.sga.preinscripcion.auto.persistence.entities.oracle.Accra;
import co.edu.udistrital.sga.preinscripcion.auto.persistence.entities.oracle.Accurso;

@Repository
public interface AccursosRepository extends JpaRepository<Accurso, Long> {
	
	@Query("select NEW co.edu.udistrital.sga.preinscripcion.auto.domain.AsignaturaGrupo(cu.curId,cu.curAsiCod,cu.curNroCupo,cu.curNroIns, cu.curCapMax, cu.curDepCod,cu.curGrupo) from Accurso cu where cu.curApeAno=:anio and cu.curApePer=:periodo and cu.curCraCod=:codCarrera")
	public List<AsignaturaGrupo> obtenerAsignaturasProgramadas(@Param("anio")Integer anio,@Param("periodo")Integer periodo,@Param("codCarrera") Integer codCarrera);
	
}
