package co.edu.udistrital.sga.preinscripcion.auto.persistence.entities.oracle;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;


/**
 * The persistent class for the ACESTADO database table.
 * 
 */
@Data
@Entity
@NamedQuery(name="Acestado.findAll", query="SELECT a FROM Acestado a")
public class Acestado implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AcestadoPK id;

	public Acestado() {
	}


}