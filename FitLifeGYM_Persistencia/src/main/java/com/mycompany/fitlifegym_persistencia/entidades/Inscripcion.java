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
 *
 * @author PC GAMER MASTER RACE
 */
public class Inscripcion {
    @BsonId
    @BsonRepresentation(BsonType.OBJECT_ID)
    private String idInscripcion;

    @BsonRepresentation(BsonType.OBJECT_ID)
    private String idCliente;

    @BsonRepresentation(BsonType.OBJECT_ID)
    private String idHorario;

    private Date fechaRegistro;
    private EstadoInscripcion estado;

    public Inscripcion() {
    }

    public Inscripcion(String idCliente, String idHorario, Date fechaRegistro, EstadoInscripcion estado) {
        this.idCliente = idCliente;
        this.idHorario = idHorario;
        this.fechaRegistro = fechaRegistro;
        this.estado = estado;
    }

    public Inscripcion(String idInscripcion, String idCliente, String idHorario, Date fechaRegistro, EstadoInscripcion estado) {
        this.idInscripcion = idInscripcion;
        this.idCliente = idCliente;
        this.idHorario = idHorario;
        this.fechaRegistro = fechaRegistro;
        this.estado = estado;
    }

    public String getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(String idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(String idHorario) {
        this.idHorario = idHorario;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public EstadoInscripcion getEstado() {
        return estado;
    }

    public void setEstado(EstadoInscripcion estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.idInscripcion);
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
        final Inscripcion other = (Inscripcion) obj;
        return Objects.equals(this.idInscripcion, other.idInscripcion);
    }

    @Override
    public String toString() {
        return "Inscripcion{" + "idInscripcion=" + idInscripcion + ", idCliente=" + idCliente + ", idHorario=" + idHorario + ", fechaRegistro=" + fechaRegistro + ", estado=" + estado + '}';
    }
    
    
}
