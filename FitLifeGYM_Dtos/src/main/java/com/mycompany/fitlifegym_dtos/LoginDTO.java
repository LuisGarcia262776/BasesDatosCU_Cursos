/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitlifegym_dtos;

/**
 * DTO que representa las credenciales necesarias
 * para iniciar sesión dentro del sistema.
 * 
 * Contiene el PIN y la contraseña del usuario.
 * 
 * @author PC GAMER MASTER RACE
 */
public class LoginDTO {
    /**
     * PIN del usuario.
     */
    private final String pin;
    
    /**
     * Contraseña del usuario.
     */
    private final String contrasenia;

    /**
     * Constructor que inicializa las credenciales
     * de inicio de sesión.
     * 
     * @param pin PIN del usuario.
     * @param contrasenia Contraseña del usuario.
     */
    public LoginDTO(String pin, String contrasenia) {
        this.pin = pin;
        this.contrasenia = contrasenia;
    }

    /**
     * Obtiene el PIN del usuario.
     * 
     * @return PIN del usuario.
     */
    public String getPin() {
        return pin;
    }

    /**
     * Obtiene la contraseña del usuario.
     * 
     * @return Contraseña del usuario.
     */
    public String getContrasenia() {
        return contrasenia;
    }
    
}
