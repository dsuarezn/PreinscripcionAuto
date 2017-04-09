package co.edu.udistrital.sga.preinscripcion.auto.persistence.repositories.oracle;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.edu.udistrital.sga.preinscripcion.auto.domain.AsignaturaRequerida;
import co.edu.udistrital.sga.preinscripcion.auto.persistence.entities.oracle.Acinsdemanda;
import co.edu.udistrital.sga.preinscripcion.auto.persistence.entities.oracle.AcinsdemandaPK;

@Repository
public interface AcinsdemandaRepository extends JpaRepository<Acinsdemanda, AcinsdemandaPK> {
	
	@Query("select NEW co.edu.udistrital.sga.preinscripcion.auto.domain.AsignaturaRequerida(ad.insdeCred,ad.id.insdeAsiCod,ad.insdeEstado,ad.id.insdePer,ad.id.insdeAno,ad.id.insdeEstCod) from Acinsdemanda ad where ad.id.insdeAno=:anio and ad.id.insdePer=:periodo and ad.insdeCraCod=:codigoCarrera and ad.insdeEstado like %:estado%")
	public List<AsignaturaRequerida> obtenerListaAsignaturasPreinsPorDemamda(@Param("anio") Integer anio, @Param("periodo") Integer periodo, @Param("codigoCarrera") Long codigoCarrera,@Param("estado")String estado);
	
}
