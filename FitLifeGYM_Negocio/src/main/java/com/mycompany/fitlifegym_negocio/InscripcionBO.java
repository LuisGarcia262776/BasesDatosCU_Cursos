/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitlifegym_negocio;

import Adapter.DtosAEntidadesAdapter;
import com.mycompany.fitlifegym_PersistenciaException.PersistenciaException;
import com.mycompany.fitlifegym_dtos.InscripcionDTO;
import com.mycompany.fitlifegym_persistencia.entidades.Horario;
import com.mycompany.fitlifegym_persistencia.entidades.Inscripcion;
import com.mycompany.fitlifegym_persistencia_Fachada.IPersistenciaFachada;
import com.mycompany.fitlifegym_persistencia_Fachada.PersistenciaFachada;
import java.util.List;

/**
 * Clase de negocio encargada de gestionar
 * las operaciones relacionadas con las inscripciones.
 * 
 * Permite registrar, actualizar, consultar
 * y contar inscripciones mediante la capa
 * de persistencia.
 * 
 * @author PC GAMER MASTER RACE
 */
public class InscripcionBO implements IInscripcionBO{
    /**
     * Fachada utilizada para acceder a la capa de persistencia.
     */
    private final IPersistenciaFachada fachada;

    /**
     * Constructor que inicializa la fachada
     * de persistencia.
     */
    public InscripcionBO() {
        this.fachada = new PersistenciaFachada();
    }

    /**
     * Obtiene todas las inscripciones registradas.
     * 
     * @return Lista de inscripciones.
     * @throws NegocioException Se lanza cuando ocurre
     * un error al consultar las inscripciones.
     */
    @Override
    public List<InscripcionDTO> obtenerTodas() throws NegocioException {
        try {
            List<Inscripcion> inscripciones = fachada.obtenerInscripcionDAO().obtenerTodas();

            return DtosAEntidadesAdapter.adaptarListaInscripciones(inscripciones);
            
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al obtener inscripciones.",ex);
        }
    }

    /**
     * Obtiene una inscripción mediante su ID.
     * 
     * @param idInscripcion ID de la inscripción.
     * @return DTO con la información de la inscripción.
     * @throws NegocioException Se lanza cuando el ID
     * es inválido o ocurre un error en persistencia.
     */
    @Override
    public InscripcionDTO obtenerPorId(String idInscripcion) throws NegocioException {
        try {
            if (idInscripcion == null || idInscripcion.isBlank()) {
                throw new NegocioException("El idInscripcion es obligatorio");
            }

            Inscripcion inscripcion = fachada.obtenerInscripcionDAO().obtenerPorId(idInscripcion);

            return DtosAEntidadesAdapter.adaptarInscripcion(inscripcion);
            
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al obtener inscripción.",ex);
        }
    }

    /**
     * Guarda una nueva inscripción dentro del sistema.
     * 
     * @param inscripcionDTO DTO con la información de la inscripción.
     * @return DTO de la inscripción guardada.
     * @throws NegocioException Se lanza cuando los datos
     * son inválidos o el horario ya no tiene cupo.
     */
    @Override
    public InscripcionDTO guardar(InscripcionDTO inscripcionDTO) throws NegocioException {
        try {
            validarInscripcion(inscripcionDTO);

            Horario horario = fachada.obtenerHorarioDAO().obtenerPorId(inscripcionDTO.getIdHorario());
            
            if (horario == null) {
                throw new NegocioException("El horario no existe");
            }

            if (horario.getCupoActual() >= horario.getCupoMax()) {
                throw new NegocioException("El horario ya no tiene cupo");
            }

            Inscripcion inscripcion = DtosAEntidadesAdapter.adaptarInscripcionDTO(inscripcionDTO);

            Inscripcion guardada = fachada.obtenerInscripcionDAO().guardar(inscripcion);

            return DtosAEntidadesAdapter.adaptarInscripcion(guardada);
            
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al guardar inscripción.",ex);
        }
    }

    /**
     * Actualiza la información de una inscripción.
     * 
     * @param inscripcionDTO DTO con la información actualizada.
     * @return DTO de la inscripción actualizada.
     * @throws NegocioException Se lanza cuando los datos
     * son inválidos o ocurre un error en persistencia.
     */
    @Override
    public InscripcionDTO actualizar(InscripcionDTO inscripcionDTO) throws NegocioException {
        try {
            validarInscripcion(inscripcionDTO);

            Inscripcion inscripcion = DtosAEntidadesAdapter.adaptarInscripcionDTO(inscripcionDTO);

            Inscripcion actualizada = fachada.obtenerInscripcionDAO().actualizar(inscripcion);

            return DtosAEntidadesAdapter.adaptarInscripcion(actualizada);
            
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al actualizar inscripción.",ex);
        }
    }

    /**
     * Cuenta el total de inscripciones registradas.
     * 
     * @return Total de inscripciones.
     * @throws NegocioException Se lanza cuando ocurre
     * un error en persistencia.
     */
    @Override
    public Integer contarTotales() throws NegocioException {
        try {
            return fachada.obtenerInscripcionDAO().contarTotales();
            
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al contar inscripciones.",ex);
        }
    }

    /**
     * Cuenta las inscripciones asociadas a un horario.
     * 
     * @param idHorario ID del horario.
     * @return Total de inscripciones del horario.
     * @throws NegocioException Se lanza cuando el ID
     * es inválido o ocurre un error en persistencia.
     */
    @Override
    public Integer contarPorHorario(String idHorario) throws NegocioException {
        try {
            if (idHorario == null || idHorario.isBlank()) {
                throw new NegocioException("El idHorario es obligatorio");
            }

            return fachada.obtenerInscripcionDAO().contarPorHorario(idHorario);
            
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al contar inscripciones.",ex);
        }
    }

    /**
     * Obtiene las inscripciones activas
     * asociadas a un horario.
     * 
     * @param idHorario ID del horario.
     * @return Lista de inscripciones activas.
     * @throws NegocioException Se lanza cuando el ID
     * es inválido o ocurre un error en persistencia.
     */
    @Override
    public List<InscripcionDTO> obtenerActivasPorHorario(String idHorario) throws NegocioException {
        try {
            if (idHorario == null || idHorario.isBlank()) {
                throw new NegocioException("El idHorario es obligatorio");
            }

            List<Inscripcion> inscripciones = fachada.obtenerInscripcionDAO().obtenerActivasPorHorario(idHorario);

            return DtosAEntidadesAdapter.adaptarListaInscripciones(inscripciones);
            
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al obtener inscripciones.",ex);
        }
    }

    /**
     * Obtiene todas las inscripciones
     * asociadas a un cliente.
     * 
     * @param idCliente ID del cliente.
     * @return Lista de inscripciones del cliente.
     * @throws NegocioException Se lanza cuando el ID
     * es inválido o ocurre un error en persistencia.
     */
    @Override
    public List<InscripcionDTO> obtenerPorCliente(String idCliente) throws NegocioException {
        try {
            if (idCliente == null || idCliente.isBlank()) {
                throw new NegocioException("El idCliente es obligatorio");
            }

            List<Inscripcion> inscripciones = fachada.obtenerInscripcionDAO().obtenerPorCliente(idCliente);

            return DtosAEntidadesAdapter.adaptarListaInscripciones(inscripciones);
            
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al obtener inscripciones.",ex);
        }
    }
    
    /**
     * Valida la información de una inscripción
     * antes de guardarla o actualizarla.
     * 
     * @param inscripcionDTO DTO de la inscripción a validar.
     * @throws NegocioException Se lanza cuando
     * los datos son inválidos.
     */
    private void validarInscripcion(InscripcionDTO inscripcionDTO) throws NegocioException {

        if (inscripcionDTO == null) {
            throw new NegocioException("La inscripción no puede ser null");
        }

        if (inscripcionDTO.getIdCliente() == null || inscripcionDTO.getIdCliente().isBlank()) {
            throw new NegocioException("El idCliente es obligatorio");
        }

        if (inscripcionDTO.getIdHorario() == null || inscripcionDTO.getIdHorario().isBlank()) {
            throw new NegocioException("El idHorario es obligatorio");
        }

        if (inscripcionDTO.getFechaRegistro() == null) {
            throw new NegocioException("La fechaRegistro es obligatoria");
        }
    }
    
}
