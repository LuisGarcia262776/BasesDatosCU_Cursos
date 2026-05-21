/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.fitlifegym_negocio;

import com.mycompany.fitlifegym_dtos.AdministradorLogueadoDTO;

/**
 * Interfaz que define las operaciones de negocio
 * relacionadas con los administradores del sistema.
 * 
 * Permite validar el inicio de sesión
 * de administradores.
 * 
 * @author PC GAMER MASTER RACE
 */
public interface IAdministradorBO {
    /**
     * Valida las credenciales de un administrador
     * e inicia sesión dentro del sistema.
     * 
     * @param pin PIN del administrador.
     * @param contrasenia Contraseña del administrador.
     * @return DTO con la información del administrador autenticado.
     * @throws NegocioException Se lanza cuando las credenciales
     * son inválidas o ocurre un error de negocio.
     */
    public abstract AdministradorLogueadoDTO iniciarSesion(String pin, String contrasenia) throws NegocioException;
    
}
