/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.fitlifegym_persistencia_Fachada;

import com.mycompany.fitlifegym_DAO.IClientesDAO;
import com.mycompany.fitlifegym_DAO.ICursoDAO;
import com.mycompany.fitlifegym_DAO.IHorarioDAO;
import com.mycompany.fitlifegym_DAO.IInscripcionDAO;

/**
 *
 * @author PC GAMER MASTER RACE
 */
public interface IPersistenciaFachada {
    public abstract IClientesDAO obtenerClienteDAO();

    public abstract ICursoDAO obtenerCursoDAO();

    public abstract IHorarioDAO obtenerHorarioDAO();

    public abstract IInscripcionDAO obtenerInscripcionDAO();
    
}
