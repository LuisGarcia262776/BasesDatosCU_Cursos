/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.fitlifegym_negocio;

import com.mycompany.fitlifegym_dtos.CursoDTO;
import java.util.List;

/**
 * Interfaz que define las operaciones de negocio
 * relacionadas con los cursos del sistema.
 * 
 * Permite registrar, actualizar, eliminar
 * y consultar cursos.
 * 
 * @author PC GAMER MASTER RACE
 */
public interface ICursoBO {
    
    /**
     * Obtiene todos los cursos registrados.
     * 
     * @return Lista de cursos.
     * @throws NegocioException Se lanza cuando ocurre
     * un error al consultar los cursos.
     */
    public abstract List<CursoDTO> obtenerTodos() throws NegocioException;

    /**
     * Obtiene un curso mediante su ID.
     * 
     * @param idCurso ID del curso.
     * @return DTO con la información del curso.
     * @throws NegocioException Se lanza cuando el ID
     * es inválido o ocurre un error de negocio.
     */
    public abstract CursoDTO obtenerPorId(String idCurso) throws NegocioException;

    /**
     * Guarda un nuevo curso dentro del sistema.
     * 
     * @param cursoDTO DTO con la información del curso.
     * @return DTO del curso guardado.
     * @throws NegocioException Se lanza cuando los datos
     * son inválidos o ocurre un error de negocio.
     */
    public abstract CursoDTO guardar(CursoDTO cursoDTO) throws NegocioException;

    /**
     * Actualiza la información de un curso existente.
     * 
     * @param cursoDTO DTO con la información actualizada.
     * @return DTO del curso actualizado.
     * @throws NegocioException Se lanza cuando los datos
     * son inválidos o ocurre un error de negocio.
     */
    public abstract CursoDTO actualizar(CursoDTO cursoDTO) throws NegocioException;

    /**
     * Elimina un curso mediante su ID.
     * 
     * @param idCurso ID del curso.
     * @return true si el curso fue eliminado correctamente.
     * @throws NegocioException Se lanza cuando el ID
     * es inválido o ocurre un error de negocio.
     */
    public abstract boolean eliminar(String idCurso) throws NegocioException;
    
}
