/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitlifegym_persistencia.entidades;

import java.util.Objects;
import org.bson.BsonType;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonRepresentation;

/**
 *
 * @author PC GAMER MASTER RACE
 */
public class Administrador {
    
    @BsonId
    @BsonRepresentation(BsonType.OBJECT_ID)
    private String idAdministrador;
    private String nombre;
    private String pin;
    private String contrasenia;

    public Administrador() {}

    public Administrador(String nombre, String pin, String contrasenia) {
        this.nombre = nombre;
        this.pin = pin;
        this.contrasenia = contrasenia;
    }

    public String getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(String idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + Objects.hashCode(this.idAdministrador);
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
        final Administrador other = (Administrador) obj;
        return Objects.equals(this.idAdministrador, other.idAdministrador);
    }

    @Override
    public String toString() {
        return "Administrador{" + "idAdministrador=" + idAdministrador + ", nombre=" + nombre + ", pin=" + pin + ", contrasenia=" + contrasenia + '}';
    }
    
}
