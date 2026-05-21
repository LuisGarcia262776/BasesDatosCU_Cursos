/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.fitlifegym_DAO;

import com.mycompany.fitlifegym_PersistenciaException.PersistenciaException;
import com.mycompany.fitlifegym_persistencia.entidades.Horario;
import java.util.List;

/**
 * Interfaz que define las operaciones
 * de persistencia relacionadas con
 * los horarios.
 * 
 * Permite registrar, consultar,
 * actualizar y eliminar horarios
 * dentro de la base de datos.
 * 
 * @author PC GAMER MASTER RACE
 */
public interface IHorarioDAO {
    /**
     * Obtiene todos los horarios
     * asociados a un curso.
     * 
     * @param idCurso ID del curso.
     * @return Lista de horarios del curso.
     * @throws PersistenciaException Se lanza cuando ocurre
     * un error durante la consulta.
     */
    public abstract List<Horario> obtenerPorCurso(String idCurso) throws PersistenciaException;

    /**
     * Obtiene todos los horarios registrados.
     * 
     * @return Lista de horarios.
     * @throws PersistenciaException Se lanza cuando ocurre
     * un error durante la consulta.
     */
    public abstract List<Horario> obtenerTodos() throws PersistenciaException;

    /**
     * Obtiene un horario mediante su ID.
     * 
     * @param idHorario ID del horario.
     * @return Horario encontrado o null
     * si no existe.
     * @throws PersistenciaException Se lanza cuando ocurre
     * un error durante la consulta.
     */
    public abstract Horario obtenerPorId(String idHorario) throws PersistenciaException;

    /**
     * Guarda un nuevo horario
     * dentro de la base de datos.
     * 
     * @param horario Horario a guardar.
     * @return Horario guardado.
     * @throws PersistenciaException Se lanza cuando ocurre
     * un error durante el guardado.
     */
    public abstract Horario guardar(Horario horario) throws PersistenciaException;

    /**
     * Actualiza la información
     * de un horario existente.
     * 
     * @param horario Horario con información actualizada.
     * @return Horario actualizado.
     * @throws PersistenciaException Se lanza cuando ocurre
     * un error durante la actualización.
     */
    public abstract Horario actualizar(Horario horario) throws PersistenciaException;

    /**
     * Elimina un horario mediante su ID.
     * 
     * @param idHorario ID del horario.
     * @return true si el horario fue eliminado correctamente.
     * @throws PersistenciaException Se lanza cuando ocurre
     * un error durante la eliminación.
     */
    public abstract boolean eliminar(String idHorario) throws PersistenciaException;
    
}
