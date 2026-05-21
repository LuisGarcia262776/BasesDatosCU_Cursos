/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.fitlifegym_DAO;

import com.mycompany.fitlifegym_PersistenciaException.PersistenciaException;
import com.mycompany.fitlifegym_persistencia.entidades.Administrador;

/**
 * Interfaz que define las operaciones
 * de persistencia relacionadas con
 * los administradores.
 * 
 * Permite buscar administradores
 * mediante sus credenciales.
 * 
 * @author PC GAMER MASTER RACE
 */
public interface IAdministradorDAO {
    /**
     * Busca un administrador mediante
     * su PIN y contraseña.
     * 
     * @param pin PIN del administrador.
     * @param contrasenia Contraseña del administrador.
     * @return Administrador encontrado o null
     * si no existe.
     * @throws PersistenciaException Se lanza cuando ocurre
     * un error durante la consulta.
     */
    public abstract Administrador buscarPorPinYContrasenia(String pin, String contrasenia) throws PersistenciaException; 
}
