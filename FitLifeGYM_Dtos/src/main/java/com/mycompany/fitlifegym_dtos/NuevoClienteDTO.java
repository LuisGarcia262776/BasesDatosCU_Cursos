/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitlifegym_dtos;

import java.time.LocalDate;

/**
 *
 * @author Diego
 */
public class NuevoClienteDTO {
    private String idCliente;
    private String nombre;
    private String apellidos;
    private String correo;
    private String telefono;
    private String contrasenia;
    private LocalDate fechaNacimiento;
    private String pin;
    private NuevaMembresiaCompradaDTO membresiaComprada;

    public NuevoClienteDTO() {
    }

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

    public NuevoClienteDTO(String nombre, String apellidos, String correo, String telefono, String contrasenia, LocalDate fechaNacimiento, String pin) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
        this.contrasenia = contrasenia;
        this.fechaNacimiento = fechaNacimiento;
        this.pin = pin;
    }

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

    public String getIdCliente() {
        return idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getPin() {
        return pin;
    }

    public NuevaMembresiaCompradaDTO getMembresiaComprada() {
        return membresiaComprada;
    }
 
}
