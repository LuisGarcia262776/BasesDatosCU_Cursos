/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.fitlifegym_negocio;

import com.mycompany.fitlifegym_dtos.AdministradorLogueadoDTO;

/**
 *
 * @author PC GAMER MASTER RACE
 */
public interface IAdministradorBO {
    public abstract AdministradorLogueadoDTO iniciarSesion(String pin, String contrasenia) throws NegocioException;
    
}
