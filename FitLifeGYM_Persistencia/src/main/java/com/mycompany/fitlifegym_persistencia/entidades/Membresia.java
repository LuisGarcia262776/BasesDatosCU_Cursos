
package com.mycompany.fitlifegym_persistencia.entidades;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Entidad que representa
 * una membresía dentro del sistema.
 * 
 * Contiene la información relacionada
 * con el tipo de membresía,
 * precio y vigencia.
 * 
 * @author Luis
 */
public class Membresia {
    /**
     * Tipo de membresía.
     */
    private TipoMembresia tipoMembresia;
    
    /**
     * Precio de la membresía.
     */
    private Double precio;
    
    /**
     * Fecha de vigencia
     * de la membresía.
     */
    private LocalDate vigencia;

    /**
     * Constructor vacío de la clase.
     */
    public Membresia() {
    }

    /**
     * Constructor que inicializa
     * el tipo y precio de la membresía.
     * 
     * @param tipoMembresia Tipo de membresía.
     * @param precio Precio de la membresía.
     */
    public Membresia(TipoMembresia tipoMembresia, Double precio) {
        this.tipoMembresia = tipoMembresia;
        this.precio = precio;
    }

    /**
     * Constructor completo
     * de la membresía.
     * 
     * @param tipoMembresia Tipo de membresía.
     * @param precio Precio de la membresía.
     * @param vigencia Vigencia de la membresía.
     */
    public Membresia(TipoMembresia tipoMembresia, Double precio, LocalDate vigencia) {
        this.tipoMembresia = tipoMembresia;
        this.precio = precio;
        this.vigencia = vigencia;
    }

    /**
     * Obtiene el tipo de membresía.
     * 
     * @return Tipo de membresía.
     */
    public TipoMembresia getTipoMembresia() {
        return tipoMembresia;
    }

    /**
     * Establece el tipo de membresía.
     * 
     * @param tipoMembresia Nuevo tipo de membresía.
     */
    public void setTipoMembresia(TipoMembresia tipoMembresia) {
        this.tipoMembresia = tipoMembresia;
    }

    /**
     * Obtiene el precio de la membresía.
     * 
     * @return Precio de la membresía.
     */
    public Double getPrecio() {
        return precio;
    }

    /**
     * Establece el precio de la membresía.
     * 
     * @param precio Nuevo precio de la membresía.
     */
    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    /**
     * Obtiene la vigencia de la membresía.
     * 
     * @return Vigencia de la membresía.
     */
    public LocalDate getVigencia() {
        return vigencia;
    }

    /**
     * Establece la vigencia de la membresía.
     * 
     * @param vigencia Nueva vigencia de la membresía.
     */
    public void setVigencia(LocalDate vigencia) {
        this.vigencia = vigencia;
    }

    /**
     * Genera el hashCode
     * de la membresía.
     * 
     * @return Valor hash de la membresía.
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.tipoMembresia);
        return hash;
    }

    /**
     * Compara si dos membresías
     * son iguales mediante su tipo.
     * 
     * @param obj Objeto a comparar.
     * @return true si son iguales,
     * false en caso contrario.
     */
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

    /**
     * Obtiene la representación
     * en texto de la membresía.
     * 
     * @return Cadena con la información
     * de la membresía.
     */
    @Override
    public String toString() {
        return "Membresia{" + "tipoMembresia=" + tipoMembresia + ", precio=" + precio + ", vigencia=" + vigencia + '}';
    }
    
    
}
    