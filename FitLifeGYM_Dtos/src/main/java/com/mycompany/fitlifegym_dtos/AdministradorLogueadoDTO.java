/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitlifegym_dtos;

/**
 * DTO que representa la información de un administrador autenticado
 * dentro del sistema.
 * 
 * Contiene los datos básicos necesarios después del inicio de sesión.
 * 
 * @author PC GAMER MASTER RACE
 */
public class AdministradorLogueadoDTO {
    /**
     * ID único del administrador.
     */
    private String idAdministrador;
    
    /**
     * Nombre del administrador.
     */
    private String nombre;
    
    /**
     * PIN utilizado para iniciar sesión.
     */
    private String pin;
    
    /**
     * Contraseña del administrador.
     */
    private String contrasenia;

    /**
     * Constructor vacío.
     */
    public AdministradorLogueadoDTO() {}

    /**
     * Constructor que inicializa los datos principales
     * del administrador autenticado.
     * 
     * @param idAdministrador ID del administrador.
     * @param nombre Nombre del administrador.
     */
    public AdministradorLogueadoDTO(String idAdministrador, String nombre) {
        this.idAdministrador = idAdministrador;
        this.nombre = nombre;
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
     * Obtiene el nombre del administrador.
     * 
     * @return Nombre del administrador.
     */
    public String getNombre() {
        return nombre;
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
     * Obtiene la contraseña del administrador.
     * 
     * @return Contraseña del administrador.
     */
    public String getContrasenia() {
        return contrasenia;
    }
    
}
