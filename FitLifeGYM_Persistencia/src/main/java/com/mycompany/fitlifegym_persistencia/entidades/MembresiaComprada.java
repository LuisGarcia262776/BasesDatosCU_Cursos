
package com.mycompany.fitlifegym_persistencia.entidades;

import java.time.LocalDate;

/**
 * Entidad que representa
 * una membresía comprada
 * dentro del sistema.
 * 
 * Contiene la información relacionada
 * con la compra de una membresía
 * realizada por un cliente.
 * 
 * @author Luis
 */
public class MembresiaComprada {
    /**
     * Membresía adquirida.
     */
    private Membresia membresia;
    
    /**
     * Fecha de inicio
     * de la membresía.
     */
    private LocalDate fechaInicio;
    
    /**
     * Fecha de finalización
     * de la membresía.
     */
    private LocalDate fechaFin;
    
    /**
     * Precio pagado
     * por la membresía.
     */
    private Double precioPagado;
    
    /**
     * Estado actual
     * de la membresía comprada.
     */
    private Estado estado;

    /**
     * Constructor vacío de la clase.
     */
    public MembresiaComprada() {
    }

    /**
     * Constructor que inicializa
     * los datos principales
     * de la membresía comprada.
     * 
     * @param membresia Membresía adquirida.
     * @param fechaInicio Fecha de inicio.
     * @param fechaFin Fecha de finalización.
     * @param precioPagado Precio pagado.
     * @param estado Estado de la membresía.
     */
    public MembresiaComprada(Membresia membresia, LocalDate fechaInicio, LocalDate fechaFin, Double precioPagado, Estado estado) {
        this.membresia = membresia;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.precioPagado = precioPagado;
        this.estado = estado;
    }

    /**
     * Obtiene la membresía adquirida.
     * 
     * @return Membresía adquirida.
     */
    public Membresia getMembresia() {
        return membresia;
    }

    /**
     * Establece la membresía adquirida.
     * 
     * @param membresia Nueva membresía adquirida.
     */
    public void setMembresia(Membresia membresia) {
        this.membresia = membresia;
    }

    /**
     * Obtiene la fecha de inicio
     * de la membresía.
     * 
     * @return Fecha de inicio.
     */
    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    /**
     * Establece la fecha de inicio
     * de la membresía.
     * 
     * @param fechaInicio Nueva fecha de inicio.
     */
    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * Obtiene la fecha de finalización
     * de la membresía.
     * 
     * @return Fecha de finalización.
     */
    public LocalDate getFechaFin() {
        return fechaFin;
    }

    /**
     * Establece la fecha de finalización
     * de la membresía.
     * 
     * @param fechaFin Nueva fecha de finalización.
     */
    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    /**
     * Obtiene el precio pagado
     * por la membresía.
     * 
     * @return Precio pagado.
     */
    public Double getPrecioPagado() {
        return precioPagado;
    }

    /**
     * Establece el precio pagado
     * por la membresía.
     * 
     * @param precioPagado Nuevo precio pagado.
     */
    public void setPrecioPagado(Double precioPagado) {
        this.precioPagado = precioPagado;
    }

    /**
     * Obtiene el estado
     * de la membresía comprada.
     * 
     * @return Estado de la membresía.
     */
    public Estado getEstado() {
        return estado;
    }

    /**
     * Establece el estado
     * de la membresía comprada.
     * 
     * @param estado Nuevo estado de la membresía.
     */
    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    /**
     * Obtiene la representación
     * en texto de la membresía comprada.
     * 
     * @return Cadena con la información
     * de la membresía comprada.
     */
    @Override
    public String toString() {
        return "MembresiaComprada{" + "membresia=" + membresia + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", precioPagado=" + precioPagado + ", estado=" + estado + '}';
    }
    
    
    

}
    