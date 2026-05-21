/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.fitlifegym_DAO;

import com.mycompany.fitlifegym_PersistenciaException.PersistenciaException;
import com.mycompany.fitlifegym_persistencia.entidades.Curso;
import java.util.List;

/**
 * Interfaz que define las operaciones
 * de persistencia relacionadas con
 * los cursos.
 * 
 * Permite registrar, consultar,
 * actualizar y eliminar cursos
 * dentro de la base de datos.
 * 
 * @author PC GAMER MASTER RACE
 */
public interface ICursoDAO {
    /**
     * Obtiene todos los cursos registrados.
     * 
     * @return Lista de cursos.
     * @throws PersistenciaException Se lanza cuando ocurre
     * un error durante la consulta.
     */
    public abstract List<Curso> obtenerTodos() throws PersistenciaException;

    /**
     * Obtiene un curso mediante su ID.
     * 
     * @param idCurso ID del curso.
     * @return Curso encontrado o null
     * si no existe.
     * @throws PersistenciaException Se lanza cuando ocurre
     * un error durante la consulta.
     */
    public abstract Curso obtenerPorId(String idCurso) throws PersistenciaException;

    /**
     * Guarda un nuevo curso
     * dentro de la base de datos.
     * 
     * @param curso Curso a guardar.
     * @return Curso guardado.
     * @throws PersistenciaException Se lanza cuando ocurre
     * un error durante el guardado.
     */
    public abstract Curso guardar(Curso curso) throws PersistenciaException;

    /**
     * Actualiza la información
     * de un curso existente.
     * 
     * @param curso Curso con información actualizada.
     * @return Curso actualizado.
     * @throws PersistenciaException Se lanza cuando ocurre
     * un error durante la actualización.
     */
    public abstract Curso actualizar(Curso curso) throws PersistenciaException;

    /**
     * Elimina un curso mediante su ID.
     * 
     * @param idCurso ID del curso.
     * @return true si el curso fue eliminado correctamente.
     * @throws PersistenciaException Se lanza cuando ocurre
     * un error durante la eliminación.
     */
    public abstract boolean eliminar(String idCurso) throws PersistenciaException;
    
}
