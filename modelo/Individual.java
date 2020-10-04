
package modelo;

import java.util.Objects;

/**
 *
 * @author famil
 */
public class Individual extends Cliente {
    private String Dpi;

    public Individual(String nombre, String apellido, int telefono, String Dpi) {
        super(nombre, apellido, telefono);
        this.Dpi = Dpi;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Individual other = (Individual) obj;
        if (!Objects.equals(this.Dpi, other.Dpi)) {
            return false;
        }
        return true;
    }

    public String getDpi() {
        return Dpi;
    }

    public void setDpi(String Dpi) {
        this.Dpi = Dpi;
    }
}
