/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitlifegym_persistencia_Fachada;

import com.mycompany.fitlifegym_DAO.AdministradorDAO;
import com.mycompany.fitlifegym_DAO.ClienteDAO;
import com.mycompany.fitlifegym_DAO.CursoDAO;
import com.mycompany.fitlifegym_DAO.HorarioDAO;
import com.mycompany.fitlifegym_DAO.IAdministradorDAO;
import com.mycompany.fitlifegym_DAO.IClientesDAO;
import com.mycompany.fitlifegym_DAO.ICursoDAO;
import com.mycompany.fitlifegym_DAO.IHorarioDAO;
import com.mycompany.fitlifegym_DAO.IInscripcionDAO;
import com.mycompany.fitlifegym_DAO.InscripcionDAO;

/**
 * Clase fachada encargada
 * de proporcionar acceso
 * a los DAOs del sistema.
 * 
 * Centraliza la creación
 * y obtención de los objetos DAO
 * utilizados en la capa de persistencia.
 * 
 * @author PC GAMER MASTER RACE
 */
public class PersistenciaFachada implements IPersistenciaFachada {
    /**
     * DAO encargado de las operaciones
     * relacionadas con clientes.
     */
    private final IClientesDAO clienteDAO;
    
    /**
     * DAO encargado de las operaciones
     * relacionadas con cursos.
     */
    private final ICursoDAO cursoDAO;
    
    /**
     * DAO encargado de las operaciones
     * relacionadas con horarios.
     */
    private final IHorarioDAO horarioDAO;
    
    /**
     * DAO encargado de las operaciones
     * relacionadas con inscripciones.
     */
    private final IInscripcionDAO inscripcionDAO;
    
    /**
     * DAO encargado de las operaciones
     * relacionadas con administradores.
     */
    private final IAdministradorDAO administradorDAO;

    /**
     * Constructor de la fachada.
     * 
     * Inicializa todos los DAOs
     * utilizados por el sistema.
     */
    public PersistenciaFachada() {
        this.clienteDAO = new ClienteDAO();
        this.cursoDAO = new CursoDAO();
        this.horarioDAO = new HorarioDAO();
        this.inscripcionDAO = new InscripcionDAO();
        this.administradorDAO = new AdministradorDAO();
    }

    /**
     * Obtiene el DAO de clientes.
     * 
     * @return DAO de clientes.
     */
    @Override
    public IClientesDAO obtenerClienteDAO() {
        return clienteDAO;
    }

    /**
     * Obtiene el DAO de cursos.
     * 
     * @return DAO de cursos.
     */
    @Override
    public ICursoDAO obtenerCursoDAO() {
        return cursoDAO;
    }

    /**
     * Obtiene el DAO de horarios.
     * 
     * @return DAO de horarios.
     */
    @Override
    public IHorarioDAO obtenerHorarioDAO() {
        return horarioDAO;
    }

    /**
     * Obtiene el DAO de inscripciones.
     * 
     * @return DAO de inscripciones.
     */
    @Override
    public IInscripcionDAO obtenerInscripcionDAO() {
        return inscripcionDAO;
    }

    /**
     * Obtiene el DAO de administradores.
     * 
     * @return DAO de administradores.
     */
    @Override
    public IAdministradorDAO obtenerAdministradorDAO() {
        return administradorDAO;
    }
    
}
