/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitlifegym_persistencia.entidades;

import java.util.Date;
import java.util.Objects;
import org.bson.BsonType;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonRepresentation;

/**
 * Entidad que representa
 * una inscripción dentro del sistema.
 * 
 * Contiene la información relacionada
 * con la inscripción de un cliente
 * a un horario.
 * 
 * @author PC GAMER MASTER RACE
 */
public class Inscripcion {
    /**
     * ID único de la inscripción.
     */
    @BsonId
    @BsonRepresentation(BsonType.OBJECT_ID)
    private String idInscripcion;

    /**
     * ID del cliente asociado
     * a la inscripción.
     */
    @BsonRepresentation(BsonType.OBJECT_ID)
    private String idCliente;

    /**
     * ID del horario asociado
     * a la inscripción.
     */
    @BsonRepresentation(BsonType.OBJECT_ID)
    private String idHorario;

    /**
     * Fecha en la que se realizó
     * la inscripción.
     */
    private Date fechaRegistro;
    
    /**
     * Estado actual de la inscripción.
     */
    private EstadoInscripcion estado;

    /**
     * Constructor vacío de la clase.
     */
    public Inscripcion() {
    }

    /**
     * Constructor que inicializa
     * los datos principales
     * de la inscripción.
     * 
     * @param idCliente ID del cliente.
     * @param idHorario ID del horario.
     * @param fechaRegistro Fecha de registro.
     * @param estado Estado de la inscripción.
     */
    public Inscripcion(String idCliente, String idHorario, Date fechaRegistro, EstadoInscripcion estado) {
        this.idCliente = idCliente;
        this.idHorario = idHorario;
        this.fechaRegistro = fechaRegistro;
        this.estado = estado;
    }

    /**
     * Constructor completo
     * de la inscripción.
     * 
     * @param idInscripcion ID de la inscripción.
     * @param idCliente ID del cliente.
     * @param idHorario ID del horario.
     * @param fechaRegistro Fecha de registro.
     * @param estado Estado de la inscripción.
     */
    public Inscripcion(String idInscripcion, String idCliente, String idHorario, Date fechaRegistro, EstadoInscripcion estado) {
        this.idInscripcion = idInscripcion;
        this.idCliente = idCliente;
        this.idHorario = idHorario;
        this.fechaRegistro = fechaRegistro;
        this.estado = estado;
    }

    /**
     * Obtiene el ID de la inscripción.
     * 
     * @return ID de la inscripción.
     */
    public String getIdInscripcion() {
        return idInscripcion;
    }

    /**
     * Establece el ID de la inscripción.
     * 
     * @param idInscripcion Nuevo ID de la inscripción.
     */
    public void setIdInscripcion(String idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    /**
     * Obtiene el ID del cliente.
     * 
     * @return ID del cliente.
     */
    public String getIdCliente() {
        return idCliente;
    }

    /**
     * Establece el ID del cliente.
     * 
     * @param idCliente Nuevo ID del cliente.
     */
    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * Obtiene el ID del horario.
     * 
     * @return ID del horario.
     */
    public String getIdHorario() {
        return idHorario;
    }

    /**
     * Establece el ID del horario.
     * 
     * @param idHorario Nuevo ID del horario.
     */
    public void setIdHorario(String idHorario) {
        this.idHorario = idHorario;
    }

    /**
     * Obtiene la fecha de registro.
     * 
     * @return Fecha de registro.
     */
    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    /**
     * Establece la fecha de registro.
     * 
     * @param fechaRegistro Nueva fecha de registro.
     */
    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    /**
     * Obtiene el estado
     * de la inscripción.
     * 
     * @return Estado de la inscripción.
     */
    public EstadoInscripcion getEstado() {
        return estado;
    }

    /**
     * Establece el estado
     * de la inscripción.
     * 
     * @param estado Nuevo estado de la inscripción.
     */
    public void setEstado(EstadoInscripcion estado) {
        this.estado = estado;
    }

    /**
     * Genera el hashCode
     * de la inscripción.
     * 
     * @return Valor hash de la inscripción.
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.idInscripcion);
        return hash;
    }

    /**
     * Compara si dos inscripciones
     * son iguales mediante su ID.
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
        final Inscripcion other = (Inscripcion) obj;
        return Objects.equals(this.idInscripcion, other.idInscripcion);
    }

    /**
     * Obtiene la representación
     * en texto de la inscripción.
     * 
     * @return Cadena con la información
     * de la inscripción.
     */
    @Override
    public String toString() {
        return "Inscripcion{" + "idInscripcion=" + idInscripcion + ", idCliente=" + idCliente + ", idHorario=" + idHorario + ", fechaRegistro=" + fechaRegistro + ", estado=" + estado + '}';
    }
    
    
}
