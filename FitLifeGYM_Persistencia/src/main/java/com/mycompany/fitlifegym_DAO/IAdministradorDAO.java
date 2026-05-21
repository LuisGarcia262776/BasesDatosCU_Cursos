/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.fitlifegym_DAO;

import com.mycompany.fitlifegym_PersistenciaException.PersistenciaException;
import com.mycompany.fitlifegym_persistencia.entidades.Administrador;

/**
 *
 * @author PC GAMER MASTER RACE
 */
public interface IAdministradorDAO {
    public abstract Administrador buscarPorPinYContrasenia(String pin, String contrasenia) throws PersistenciaException; 
}
