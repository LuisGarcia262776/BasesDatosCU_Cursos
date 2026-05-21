/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitlifegym_dtos;

/**
 *
 * @author PC GAMER MASTER RACE
 */
public class AdministradorLogueadoDTO {
    private String idAdministrador;
    private String nombre;
    private String pin;
    private String contrasenia;

    public AdministradorLogueadoDTO() {}

    public AdministradorLogueadoDTO(String idAdministrador, String nombre) {
        this.idAdministrador = idAdministrador;
        this.nombre = nombre;
    }

    public String getIdAdministrador() {
        return idAdministrador;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPin() {
        return pin;
    }

    public String getContrasenia() {
        return contrasenia;
    }
    
    
    
    
    
}
