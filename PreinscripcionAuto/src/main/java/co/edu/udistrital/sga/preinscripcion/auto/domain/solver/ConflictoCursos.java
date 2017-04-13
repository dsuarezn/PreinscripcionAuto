package co.edu.udistrital.sga.preinscripcion.auto.domain.solver;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import co.edu.udistrital.sga.preinscripcion.auto.domain.AsignaturaGrupo;
import co.edu.udistrital.sga.preinscripcion.auto.domain.AsignaturaRequerida;
import co.edu.udistrital.sga.preinscripcion.auto.domain.Pensum;
import co.edu.udistrital.sga.preinscripcion.auto.domain.ProyectoCurricular;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Lista de conflictos calculados durante la inicialización
 */
@Getter
@Setter
public class ConflictoCursos implements Serializable, Comparable<ConflictoCursos> {

    private final AsignaturaGrupo leftCourse;
    private final AsignaturaGrupo rightCourse;
    private final int conflictCount;

    public ConflictoCursos(AsignaturaGrupo leftCourse, AsignaturaGrupo rightCourse, int conflictCount) {
        this.leftCourse = leftCourse;
        this.rightCourse = rightCourse;
        this.conflictCount = conflictCount;
    }

    public AsignaturaGrupo getLeftCourse() {
        return leftCourse;
    }

    public AsignaturaGrupo getRightCourse() {
        return rightCourse;
    }

    public int getConflictCount() {
        return conflictCount;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o instanceof ConflictoCursos) {
            ConflictoCursos other = (ConflictoCursos) o;
            return new EqualsBuilder()
                    .append(leftCourse, other.leftCourse)
                    .append(rightCourse, other.rightCourse)
                    .isEquals();
        } else {
            return false;
        }
    }

    public int hashCode() {
        return new HashCodeBuilder()
                .append(leftCourse)
                .append(rightCourse)
                .toHashCode();
    }

    public int compareTo(ConflictoCursos other) {
        return new CompareToBuilder()
                .append(leftCourse, other.leftCourse)
                .append(rightCourse, other.rightCourse)
                .toComparison();
    }

    @Override
    public String toString() {
        return leftCourse + " & " + rightCourse;
    }

}
