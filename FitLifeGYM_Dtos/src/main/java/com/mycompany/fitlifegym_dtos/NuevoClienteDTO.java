/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitlifegym_dtos;

import java.time.LocalDate;

/**
 * DTO que representa la información de un nuevo cliente
 * dentro del sistema.
 * 
 * Contiene los datos personales, credenciales
 * y membresía asociada del cliente.
 * 
 * @author Diego
 */
public class NuevoClienteDTO {
    /**
     * ID único del cliente.
     */
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
     * PIN del cliente.
     */
    private String pin;
    
    /**
     * Membresía comprada asociada al cliente.
     */
    private NuevaMembresiaCompradaDTO membresiaComprada;

    /**
     * Constructor vacío.
     */
    public NuevoClienteDTO() {
    }

    /**
     * Constructor que inicializa todos los datos del cliente.
     * 
     * @param idCliente ID del cliente.
     * @param nombre Nombre del cliente.
     * @param apellidos Apellidos del cliente.
     * @param correo Correo electrónico.
     * @param telefono Número telefónico.
     * @param contrasenia Contraseña del cliente.
     * @param fechaNacimiento Fecha de nacimiento.
     * @param pin PIN del cliente.
     * @param membresiaComprada Membresía asociada.
     */
    public NuevoClienteDTO(String idCliente, String nombre, String apellidos, String correo, String telefono, String contrasenia, LocalDate fechaNacimiento, String pin, NuevaMembresiaCompradaDTO membresiaComprada) {
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
     * Constructor para registrar un cliente sin membresía.
     * 
     * @param nombre Nombre del cliente.
     * @param apellidos Apellidos del cliente.
     * @param correo Correo electrónico.
     * @param telefono Número telefónico.
     * @param contrasenia Contraseña del cliente.
     * @param fechaNacimiento Fecha de nacimiento.
     * @param pin PIN del cliente.
     */
    public NuevoClienteDTO(String nombre, String apellidos, String correo, String telefono, String contrasenia, LocalDate fechaNacimiento, String pin) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
        this.contrasenia = contrasenia;
        this.fechaNacimiento = fechaNacimiento;
        this.pin = pin;
    }

    /**
     * Constructor para registrar un cliente con membresía.
     * 
     * @param nombre Nombre del cliente.
     * @param apellidos Apellidos del cliente.
     * @param correo Correo electrónico.
     * @param telefono Número telefónico.
     * @param contrasenia Contraseña del cliente.
     * @param fechaNacimiento Fecha de nacimiento.
     * @param pin PIN del cliente.
     * @param membresiaComprada Membresía asociada.
     */
    public NuevoClienteDTO(String nombre, String apellidos, String correo, String telefono, String contrasenia, LocalDate fechaNacimiento, String pin, NuevaMembresiaCompradaDTO membresiaComprada) {
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
     * Obtiene el nombre del cliente.
     * 
     * @return Nombre del cliente.
     */
    public String getNombre() {
        return nombre;
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
     * Obtiene el correo electrónico del cliente.
     * 
     * @return Correo electrónico.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Obtiene el número telefónico del cliente.
     * 
     * @return Número telefónico.
     */
    public String getTelefono() {
        return telefono;
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
     * Obtiene la fecha de nacimiento del cliente.
     * 
     * @return Fecha de nacimiento.
     */
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
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
     * Obtiene la membresía comprada asociada.
     * 
     * @return Membresía comprada.
     */
    public NuevaMembresiaCompradaDTO getMembresiaComprada() {
        return membresiaComprada;
    }
 
}
