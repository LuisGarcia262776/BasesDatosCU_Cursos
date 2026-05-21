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
 * Entidad que representa
 * a un administrador dentro
 * del sistema.
 * 
 * Contiene la información necesaria
 * para la autenticación y gestión
 * de administradores.
 * 
 * @author PC GAMER MASTER RACE
 */
public class Administrador {
    
    /**
     * ID único del administrador.
     */
    @BsonId
    @BsonRepresentation(BsonType.OBJECT_ID)
    private String idAdministrador;
    
    /**
     * Nombre del administrador.
     */
    private String nombre;
    
    /**
     * PIN de acceso del administrador.
     */
    private String pin;
    
    /**
     * Contraseña del administrador.
     */
    private String contrasenia;

    /**
     * Constructor vacío de la clase.
     */
    public Administrador() {}

    /**
     * Constructor que inicializa
     * los datos principales del administrador.
     * 
     * @param nombre Nombre del administrador.
     * @param pin PIN del administrador.
     * @param contrasenia Contraseña del administrador.
     */
    public Administrador(String nombre, String pin, String contrasenia) {
        this.nombre = nombre;
        this.pin = pin;
        this.contrasenia = contrasenia;
    }

    /**
     * Obtiene el ID del administrador.
     * 
     * @return ID del administrador.
     */
    public String getIdAdministrador() {
        return idAdministrador;
    }

    /**
     * Establece el ID del administrador.
     * 
     * @param idAdministrador Nuevo ID del administrador.
     */
    public void setIdAdministrador(String idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    /**
     * Obtiene el nombre del administrador.
     * 
     * @return Nombre del administrador.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del administrador.
     * 
     * @param nombre Nuevo nombre del administrador.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el PIN del administrador.
     * 
     * @return PIN del administrador.
     */
    public String getPin() {
        return pin;
    }

    /**
     * Establece el PIN del administrador.
     * 
     * @param pin Nuevo PIN del administrador.
     */
    public void setPin(String pin) {
        this.pin = pin;
    }

    /**
     * Obtiene la contraseña del administrador.
     * 
     * @return Contraseña del administrador.
     */
    public String getContrasenia() {
        return contrasenia;
    }

    /**
     * Establece la contraseña del administrador.
     * 
     * @param contrasenia Nueva contraseña del administrador.
     */
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    /**
     * Genera el hashCode
     * del administrador.
     * 
     * @return Valor hash del administrador.
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + Objects.hashCode(this.idAdministrador);
        return hash;
    }

    /**
     * Compara si dos administradores
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
        final Administrador other = (Administrador) obj;
        return Objects.equals(this.idAdministrador, other.idAdministrador);
    }

    /**
     * Obtiene la representación
     * en texto del administrador.
     * 
     * @return Cadena con la información
     * del administrador.
     */
    @Override
    public String toString() {
        return "Administrador{" + "idAdministrador=" + idAdministrador + ", nombre=" + nombre + ", pin=" + pin + ", contrasenia=" + contrasenia + '}';
    }
    
}
