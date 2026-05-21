/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.fitlifegym_persistencia_Fachada;

import com.mycompany.fitlifegym_DAO.IAdministradorDAO;
import com.mycompany.fitlifegym_DAO.IClientesDAO;
import com.mycompany.fitlifegym_DAO.ICursoDAO;
import com.mycompany.fitlifegym_DAO.IHorarioDAO;
import com.mycompany.fitlifegym_DAO.IInscripcionDAO;

/**
 * Interfaz que define los métodos
 * de acceso a los DAOs del sistema.
 * 
 * Funciona como una fachada
 * para centralizar el acceso
 * a la capa de persistencia.
 * 
 * @author PC GAMER MASTER RACE
 */
public interface IPersistenciaFachada {
    /**
     * Obtiene el DAO de clientes.
     * 
     * @return DAO de clientes.
     */
    public abstract IClientesDAO obtenerClienteDAO();

    /**
     * Obtiene el DAO de cursos.
     * 
     * @return DAO de cursos.
     */
    public abstract ICursoDAO obtenerCursoDAO();

    /**
     * Obtiene el DAO de horarios.
     * 
     * @return DAO de horarios.
     */
    public abstract IHorarioDAO obtenerHorarioDAO();

    /**
     * Obtiene el DAO de inscripciones.
     * 
     * @return DAO de inscripciones.
     */
    public abstract IInscripcionDAO obtenerInscripcionDAO();
    
    /**
     * Obtiene el DAO de administradores.
     * 
     * @return DAO de administradores.
     */
    public abstract IAdministradorDAO obtenerAdministradorDAO();
    
}
