/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.fitlifegym_DAO;

import com.mycompany.fitlifegym_PersistenciaException.PersistenciaException;
import com.mycompany.fitlifegym_persistencia.entidades.Inscripcion;
import java.util.List;

/**
 * Interfaz que define las operaciones
 * de persistencia relacionadas con
 * las inscripciones.
 * 
 * Permite registrar, consultar,
 * actualizar y contar inscripciones
 * dentro de la base de datos.
 * 
 * @author PC GAMER MASTER RACE
 */
public interface IInscripcionDAO {
    
    /**
     * Obtiene todas las inscripciones registradas.
     * 
     * @return Lista de inscripciones.
     * @throws PersistenciaException Se lanza cuando ocurre
     * un error durante la consulta.
     */
    public abstract List<Inscripcion> obtenerTodas() throws PersistenciaException;

    /**
     * Obtiene una inscripción mediante su ID.
     * 
     * @param idInscripcion ID de la inscripción.
     * @return Inscripción encontrada o null
     * si no existe.
     * @throws PersistenciaException Se lanza cuando ocurre
     * un error durante la consulta.
     */
    public abstract Inscripcion obtenerPorId(String idInscripcion) throws PersistenciaException;

    /**
     * Guarda una nueva inscripción
     * dentro de la base de datos.
     * 
     * @param inscripcion Inscripción a guardar.
     * @return Inscripción guardada.
     * @throws PersistenciaException Se lanza cuando ocurre
     * un error durante el guardado.
     */
    public abstract Inscripcion guardar(Inscripcion inscripcion) throws PersistenciaException;

    /**
     * Actualiza la información
     * de una inscripción existente.
     * 
     * @param inscripcion Inscripción con información actualizada.
     * @return Inscripción actualizada.
     * @throws PersistenciaException Se lanza cuando ocurre
     * un error durante la actualización.
     */
    public abstract Inscripcion actualizar(Inscripcion inscripcion) throws PersistenciaException;

    /**
     * Cuenta el total de inscripciones registradas.
     * 
     * @return Total de inscripciones.
     * @throws PersistenciaException Se lanza cuando ocurre
     * un error durante el conteo.
     */
    public abstract Integer contarTotales() throws PersistenciaException;

    /**
     * Cuenta las inscripciones activas
     * asociadas a un horario.
     * 
     * @param idHorario ID del horario.
     * @return Total de inscripciones activas.
     * @throws PersistenciaException Se lanza cuando ocurre
     * un error durante el conteo.
     */
    public abstract Integer contarPorHorario(String idHorario) throws PersistenciaException;

    /**
     * Obtiene las inscripciones activas
     * asociadas a un horario específico.
     * 
     * @param idHorario ID del horario.
     * @return Lista de inscripciones activas.
     * @throws PersistenciaException Se lanza cuando ocurre
     * un error durante la consulta.
     */
    public abstract List<Inscripcion> obtenerActivasPorHorario(String idHorario) throws PersistenciaException;

    /**
     * Obtiene las inscripciones
     * asociadas a un cliente.
     * 
     * @param idCliente ID del cliente.
     * @return Lista de inscripciones del cliente.
     * @throws PersistenciaException Se lanza cuando ocurre
     * un error durante la consulta.
     */
    public abstract List<Inscripcion> obtenerPorCliente(String idCliente) throws PersistenciaException;
    
}
