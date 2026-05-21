/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.fitlifegym_negocio;

import com.mycompany.fitlifegym_dtos.InscripcionDTO;
import java.util.List;

/**
 * Interfaz que define las operaciones de negocio
 * relacionadas con las inscripciones del sistema.
 * 
 * Permite registrar, actualizar, consultar
 * y contar inscripciones.
 * 
 * @author PC GAMER MASTER RACE
 */
public interface IInscripcionBO {
    
    /**
     * Obtiene todas las inscripciones registradas.
     * 
     * @return Lista de inscripciones.
     * @throws NegocioException Se lanza cuando ocurre
     * un error al consultar las inscripciones.
     */
    public List<InscripcionDTO> obtenerTodas() throws NegocioException;

    /**
     * Obtiene una inscripción mediante su ID.
     * 
     * @param idInscripcion ID de la inscripción.
     * @return DTO con la información de la inscripción.
     * @throws NegocioException Se lanza cuando el ID
     * es inválido o ocurre un error de negocio.
     */
    public InscripcionDTO obtenerPorId(String idInscripcion) throws NegocioException;

    /**
     * Guarda una nueva inscripción dentro del sistema.
     * 
     * @param inscripcionDTO DTO con la información de la inscripción.
     * @return DTO de la inscripción guardada.
     * @throws NegocioException Se lanza cuando los datos
     * son inválidos o ocurre un error de negocio.
     */
    public InscripcionDTO guardar(InscripcionDTO inscripcionDTO) throws NegocioException;

    /**
     * Actualiza la información de una inscripción existente.
     * 
     * @param inscripcionDTO DTO con la información actualizada.
     * @return DTO de la inscripción actualizada.
     * @throws NegocioException Se lanza cuando los datos
     * son inválidos o ocurre un error de negocio.
     */
    public InscripcionDTO actualizar(InscripcionDTO inscripcionDTO) throws NegocioException;

    /**
     * Cuenta el total de inscripciones registradas.
     * 
     * @return Total de inscripciones.
     * @throws NegocioException Se lanza cuando ocurre
     * un error de negocio.
     */
    public Integer contarTotales() throws NegocioException;

    /**
     * Cuenta las inscripciones asociadas a un horario.
     * 
     * @param idHorario ID del horario.
     * @return Total de inscripciones del horario.
     * @throws NegocioException Se lanza cuando el ID
     * es inválido o ocurre un error de negocio.
     */
    public Integer contarPorHorario(String idHorario) throws NegocioException;

    /**
     * Obtiene las inscripciones activas
     * asociadas a un horario.
     * 
     * @param idHorario ID del horario.
     * @return Lista de inscripciones activas.
     * @throws NegocioException Se lanza cuando el ID
     * es inválido o ocurre un error de negocio.
     */
    public List<InscripcionDTO> obtenerActivasPorHorario(String idHorario) throws NegocioException;

    /**
     * Obtiene las inscripciones asociadas
     * a un cliente.
     * 
     * @param idCliente ID del cliente.
     * @return Lista de inscripciones del cliente.
     * @throws NegocioException Se lanza cuando el ID
     * es inválido o ocurre un error de negocio.
     */
    public List<InscripcionDTO> obtenerPorCliente(String idCliente) throws NegocioException;
    
}
