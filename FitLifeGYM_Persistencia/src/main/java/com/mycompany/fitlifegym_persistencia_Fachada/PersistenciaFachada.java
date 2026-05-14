/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitlifegym_persistencia_Fachada;

import com.mycompany.fitlifegym_DAO.ClienteDAO;
import com.mycompany.fitlifegym_DAO.CursoDAO;
import com.mycompany.fitlifegym_DAO.HorarioDAO;
import com.mycompany.fitlifegym_DAO.IClientesDAO;
import com.mycompany.fitlifegym_DAO.ICursoDAO;
import com.mycompany.fitlifegym_DAO.IHorarioDAO;
import com.mycompany.fitlifegym_DAO.IInscripcionDAO;
import com.mycompany.fitlifegym_DAO.InscripcionDAO;

/**
 *
 * @author PC GAMER MASTER RACE
 */
public class PersistenciaFachada implements IPersistenciaFachada {
    private final IClientesDAO clienteDAO;
    private final ICursoDAO cursoDAO;
    private final IHorarioDAO horarioDAO;
    private final IInscripcionDAO inscripcionDAO;

    public PersistenciaFachada() {
        this.clienteDAO = new ClienteDAO();
        this.cursoDAO = new CursoDAO();
        this.horarioDAO = new HorarioDAO();
        this.inscripcionDAO = new InscripcionDAO();
    }

    @Override
    public IClientesDAO obtenerClienteDAO() {
        return clienteDAO;
    }

    @Override
    public ICursoDAO obtenerCursoDAO() {
        return cursoDAO;
    }

    @Override
    public IHorarioDAO obtenerHorarioDAO() {
        return horarioDAO;
    }

    @Override
    public IInscripcionDAO obtenerInscripcionDAO() {
        return inscripcionDAO;
    }
    
}
