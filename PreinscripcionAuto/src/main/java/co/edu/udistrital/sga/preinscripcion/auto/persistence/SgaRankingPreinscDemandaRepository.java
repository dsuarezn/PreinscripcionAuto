package co.edu.udistrital.sga.preinscripcion.auto.persistence;


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
public interface SgaRankingPreinscDemandaRepository extends JpaRepository<Accurso, Long> {
	 
	 @Query("select NEW co.edu.udistrital.sga.preinscripcion.auto.domain.Asignatura(cu.curId, cu.curAsiCod, cu.curNroCupo, cu.curNroIns, cu.curCapMax, cu.curDepCod, cu.curGrupo) FROM Accurso cu where cu.curCraCod=:codigoProyecto and cu.curApeAno=:anio and cu.curApePer=:periodo")
	 List<AsignaturaGrupo> obtenerAsignaturasGrupoProgramadas(@Param("codigoProyecto") BigDecimal codigoProyecto, @Param("periodo") Integer periodo, @Param("anio") Integer anio);
}
