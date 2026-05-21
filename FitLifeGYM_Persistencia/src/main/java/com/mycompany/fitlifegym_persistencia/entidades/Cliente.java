package com.mycompany.fitlifegym_persistencia.entidades;

import java.time.LocalDate;
import java.util.Objects;
import org.bson.BsonType;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonRepresentation;

/**
 * Entidad que representa
 * a un cliente dentro del sistema.
 * 
 * Contiene la información personal,
 * credenciales y membresía asociada
 * del cliente.
 * 
 * @author Luis
 */
public class Cliente {
    /**
     * ID único del cliente.
     */
    @BsonId
    @BsonRepresentation(BsonType.OBJECT_ID)
    private String idCliente;

    /**
     * Nombre del cliente.
     */
    private String nombre;
    
    /**
     * Apellidos del cliente.
     */
    private String apellidos;
    
    /**
     * Correo electrónico del cliente.
     */
    private String correo;
    
    /**
     * Número telefónico del cliente.
     */
    private String telefono;
    
    /**
     * Contraseña del cliente.
     */
    private String contrasenia;
    
    /**
     * Fecha de nacimiento del cliente.
     */
    private LocalDate fechaNacimiento;
    
    /**
     * PIN de acceso del cliente.
     */
    private String pin;
    
    /**
     * Membresía comprada del cliente.
     */
    private MembresiaComprada membresiaComprada;

    /**
     * Constructor vacío de la clase.
     */
    public Cliente() {
    }

    /**
     * Constructor que inicializa
     * los datos principales del cliente.
     * 
     * @param nombre Nombre del cliente.
     * @param apellidos Apellidos del cliente.
     * @param correo Correo del cliente.
     * @param telefono Teléfono del cliente.
     * @param contrasenia Contraseña del cliente.
     * @param fechaNacimiento Fecha de nacimiento del cliente.
     * @param pin PIN del cliente.
     */
    public Cliente(String nombre, String apellidos, String correo, String telefono, String contrasenia, LocalDate fechaNacimiento, String pin) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
        this.contrasenia = contrasenia;
        this.fechaNacimiento = fechaNacimiento;
        this.pin = pin;
    }

    /**
     * Constructor que inicializa
     * los datos del cliente junto
     * con su membresía comprada.
     * 
     * @param nombre Nombre del cliente.
     * @param apellidos Apellidos del cliente.
     * @param correo Correo del cliente.
     * @param telefono Teléfono del cliente.
     * @param contrasenia Contraseña del cliente.
     * @param fechaNacimiento Fecha de nacimiento del cliente.
     * @param pin PIN del cliente.
     * @param membresiaComprada Membresía comprada del cliente.
     */
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

    /**
     * Constructor completo del cliente.
     * 
     * @param idCliente ID del cliente.
     * @param nombre Nombre del cliente.
     * @param apellidos Apellidos del cliente.
     * @param correo Correo del cliente.
     * @param telefono Teléfono del cliente.
     * @param contrasenia Contraseña del cliente.
     * @param fechaNacimiento Fecha de nacimiento del cliente.
     * @param pin PIN del cliente.
     * @param membresiaComprada Membresía comprada del cliente.
     */
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
     * Obtiene el nombre del cliente.
     * 
     * @return Nombre del cliente.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del cliente.
     * 
     * @param nombre Nuevo nombre del cliente.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene los apellidos del cliente.
     * 
     * @return Apellidos del cliente.
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Establece los apellidos del cliente.
     * 
     * @param apellidos Nuevos apellidos del cliente.
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * Obtiene el correo electrónico del cliente.
     * 
     * @return Correo electrónico del cliente.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece el correo electrónico del cliente.
     * 
     * @param correo Nuevo correo electrónico del cliente.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Obtiene el teléfono del cliente.
     * 
     * @return Teléfono del cliente.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el teléfono del cliente.
     * 
     * @param telefono Nuevo teléfono del cliente.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtiene la contraseña del cliente.
     * 
     * @return Contraseña del cliente.
     */
    public String getContrasenia() {
        return contrasenia;
    }

    /**
     * Establece la contraseña del cliente.
     * 
     * @param contrasenia Nueva contraseña del cliente.
     */
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    /**
     * Obtiene la fecha de nacimiento del cliente.
     * 
     * @return Fecha de nacimiento del cliente.
     */
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Establece la fecha de nacimiento del cliente.
     * 
     * @param fechaNacimiento Nueva fecha de nacimiento.
     */
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Obtiene el PIN del cliente.
     * 
     * @return PIN del cliente.
     */
    public String getPin() {
        return pin;
    }

    /**
     * Establece el PIN del cliente.
     * 
     * @param pin Nuevo PIN del cliente.
     */
    public void setPin(String pin) {
        this.pin = pin;
    }

    /**
     * Obtiene la membresía comprada del cliente.
     * 
     * @return Membresía comprada.
     */
    public MembresiaComprada getMembresiaComprada() {
        return membresiaComprada;
    }

    /**
     * Establece la membresía comprada del cliente.
     * 
     * @param membresiaComprada Nueva membresía comprada.
     */
    public void setMembresiaComprada(MembresiaComprada membresiaComprada) {
        this.membresiaComprada = membresiaComprada;
    }

    /**
     * Genera el hashCode del cliente.
     * 
     * @return Valor hash del cliente.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.idCliente);
        return hash;
    }

    /**
     * Compara si dos clientes
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
        final Cliente other = (Cliente) obj;
        return Objects.equals(this.idCliente, other.idCliente);
    }

    /**
     * Obtiene la representación
     * en texto del cliente.
     * 
     * @return Cadena con la información del cliente.
     */
    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", nombre=" + nombre + ", apellidos=" + apellidos + ", correo=" + correo + ", telefono=" + telefono + ", contrasenia=" + contrasenia + ", fechaNacimiento=" + fechaNacimiento + ", pin=" + pin + ", membresiaComprada=" + membresiaComprada + '}';
    }
    
}
    