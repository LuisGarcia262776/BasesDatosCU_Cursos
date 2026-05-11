
package com.mycompany.fitlifegym_persistencia.entidades;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author Luis
 */
public class Membresia {
    private TipoMembresia tipoMembresia;
    private Double precio;
    private LocalDate vigencia;

    public Membresia() {
    }

    public Membresia(TipoMembresia tipoMembresia, Double precio) {
        this.tipoMembresia = tipoMembresia;
        this.precio = precio;
    }

    public Membresia(TipoMembresia tipoMembresia, Double precio, LocalDate vigencia) {
        this.tipoMembresia = tipoMembresia;
        this.precio = precio;
        this.vigencia = vigencia;
    }

    public TipoMembresia getTipoMembresia() {
        return tipoMembresia;
    }

    public void setTipoMembresia(TipoMembresia tipoMembresia) {
        this.tipoMembresia = tipoMembresia;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public LocalDate getVigencia() {
        return vigencia;
    }

    public void setVigencia(LocalDate vigencia) {
        this.vigencia = vigencia;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.tipoMembresia);
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
        final Membresia other = (Membresia) obj;
        return this.tipoMembresia == other.tipoMembresia;
    }

    @Override
    public String toString() {
        return "Membresia{" + "tipoMembresia=" + tipoMembresia + ", precio=" + precio + ", vigencia=" + vigencia + '}';
    }
    
    
}
    