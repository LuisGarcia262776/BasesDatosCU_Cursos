package com.mycompany.fitlifegym_persistencia.entidades;

import java.time.LocalDate;
import java.util.Objects;
import org.bson.BsonType;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonRepresentation;

/**
 *
 * @author Luis
 */
public class Cliente {
    @BsonId
    @BsonRepresentation(BsonType.OBJECT_ID)
    private String idCliente;

    private String nombre;
    private String apellidos;
    private String correo;
    private String telefono;
    private String contrasenia;
    private LocalDate fechaNacimiento;
    private String pin;
    private MembresiaComprada membresiaComprada;

    public Cliente() {
    }

    public Cliente(String nombre, String apellidos, String correo, String telefono, String contrasenia, LocalDate fechaNacimiento, String pin) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
        this.contrasenia = contrasenia;
        this.fechaNacimiento = fechaNacimiento;
        this.pin = pin;
    }

    public Cliente(String nombre, String apellidos, String correo, String telefono, String contrasenia, LocalDate fechaNacimiento, String pin, MembresiaComprada membresiaComprada) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
        this.contrasenia = contrasenia;
        this.fechaNacimiento = fechaNacimiento;
        this.pin = pin;
        this.membresiaComprada = membresiaComprada;
    }

    public Cliente(String idCliente, String nombre, String apellidos, String correo, String telefono, String contrasenia, LocalDate fechaNacimiento, String pin, MembresiaComprada membresiaComprada) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
        this.contrasenia = contrasenia;
        this.fechaNacimiento = fechaNacimiento;
        this.pin = pin;
        this.membresiaComprada = membresiaComprada;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public MembresiaComprada getMembresiaComprada() {
        return membresiaComprada;
    }

    public void setMembresiaComprada(MembresiaComprada membresiaComprada) {
        this.membresiaComprada = membresiaComprada;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.idCliente);
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
        final Cliente other = (Cliente) obj;
        return Objects.equals(this.idCliente, other.idCliente);
    }

    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", nombre=" + nombre + ", apellidos=" + apellidos + ", correo=" + correo + ", telefono=" + telefono + ", contrasenia=" + contrasenia + ", fechaNacimiento=" + fechaNacimiento + ", pin=" + pin + ", membresiaComprada=" + membresiaComprada + '}';
    }
    
    
    
    
    
}
    