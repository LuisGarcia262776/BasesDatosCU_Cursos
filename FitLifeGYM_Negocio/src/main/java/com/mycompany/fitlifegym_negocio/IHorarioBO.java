/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.fitlifegym_negocio;

import com.mycompany.fitlifegym_dtos.HorarioDTO;
import java.util.List;

/**
 * Interfaz que define las operaciones de negocio
 * relacionadas con los horarios del sistema.
 * 
 * Permite registrar, actualizar, eliminar
 * y consultar horarios.
 * 
 * @author PC GAMER MASTER RACE
 */
public interface IHorarioBO {
    /**
     * Obtiene todos los horarios asociados
     * a un curso específico.
     * 
     * @param idCurso ID del curso.
     * @return Lista de horarios del curso.
     * @throws NegocioException Se lanza cuando el ID
     * es inválido o ocurre un error de negocio.
     */
    public List<HorarioDTO> obtenerPorCurso(String idCurso) throws NegocioException;

    /**
     * Obtiene todos los horarios registrados.
     * 
     * @return Lista de horarios.
     * @throws NegocioException Se lanza cuando ocurre
     * un error al consultar horarios.
     */
    public List<HorarioDTO> obtenerTodos() throws NegocioException;

    /**
     * Obtiene un horario mediante su ID.
     * 
     * @param idHorario ID del horario.
     * @return DTO con la información del horario.
     * @throws NegocioException Se lanza cuando el ID
     * es inválido o ocurre un error de negocio.
     */
    public HorarioDTO obtenerPorId(String idHorario) throws NegocioException;

    /**
     * Guarda un nuevo horario dentro del sistema.
     * 
     * @param horarioDTO DTO con la información del horario.
     * @return DTO del horario guardado.
     * @throws NegocioException Se lanza cuando los datos
     * son inválidos o ocurre un error de negocio.
     */
    public HorarioDTO guardar(HorarioDTO horarioDTO) throws NegocioException;

    /**
     * Actualiza la información de un horario existente.
     * 
     * @param horarioDTO DTO con la información actualizada.
     * @return DTO del horario actualizado.
     * @throws NegocioException Se lanza cuando los datos
     * son inválidos o ocurre un error de negocio.
     */
    public HorarioDTO actualizar(HorarioDTO horarioDTO) throws NegocioException;

    /**
     * Elimina un horario mediante su ID.
     * 
     * @param idHorario ID del horario.
     * @return true si el horario fue eliminado correctamente.
     * @throws NegocioException Se lanza cuando el ID
     * es inválido o ocurre un error de negocio.
     */
    public boolean eliminar(String idHorario) throws NegocioException;
    
}
