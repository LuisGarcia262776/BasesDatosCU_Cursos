/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitlifegym_dtos;

import java.util.Date;

/**
 * DTO que representa una inscripción realizada
 * por un cliente a un horario de curso dentro del sistema.
 * 
 * Contiene la información necesaria para registrar
 * y consultar inscripciones.
 * 
 * @author PC GAMER MASTER RACE
 */
public class InscripcionDTO {
    /**
     * ID único de la inscripción.
     */
    private String idInscripcion;
    
    /**
     * ID del cliente inscrito.
     */
    private String idCliente;
    
    /**
     * ID del horario asociado a la inscripción.
     */
    private String idHorario;
    
    /**
     * Fecha en la que se realizó la inscripción.
     */
    private Date fechaRegistro;
    
    /**
     * Estado actual de la inscripción.
     */
    private EstadoInscripcionDTO estado;

    /**
     * Constructor vacío.
     */
    public InscripcionDTO() {
    }

    /**
     * Constructor para registrar una nueva inscripción.
     * 
     * Inicializa automáticamente la fecha actual
     * y el estado ACTIVO.
     * 
     * @param idCliente ID del cliente.
     * @param idHorario ID del horario.
     */
    public InscripcionDTO(String idCliente, String idHorario) {
        this.idCliente = idCliente;
        this.idHorario = idHorario;
        this.fechaRegistro = new Date();
        this.estado = EstadoInscripcionDTO.ACTIVO;
    }

    /**
     * Constructor que inicializa todos los datos
     * de la inscripción.
     * 
     * @param idInscripcion ID de la inscripción.
     * @param idCliente ID del cliente.
     * @param idHorario ID del horario.
     * @param fechaRegistro Fecha de registro.
     * @param estado Estado de la inscripción.
     */
    public InscripcionDTO(String idInscripcion, String idCliente, String idHorario, Date fechaRegistro, EstadoInscripcionDTO estado) {
        this.idInscripcion = idInscripcion;
        this.idCliente = idCliente;
        this.idHorario = idHorario;
        this.fechaRegistro = fechaRegistro;
        this.estado = estado;
    }

    /**
     * Obtiene el ID de la inscripción.
     * 
     * @return ID de la inscripción.
     */
    public String getIdInscripcion() {
        return idInscripcion;
    }

    /**
     * Obtiene el ID del cliente.
     * 
     * @return ID del cliente.
     */
    public String getIdCliente() {
        return idCliente;
    }

    /**
     * Obtiene el ID del horario.
     * 
     * @return ID del horario.
     */
    public String getIdHorario() {
        return idHorario;
    }

    /**
     * Obtiene la fecha de registro de la inscripción.
     * 
     * @return Fecha de registro.
     */
    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    /**
     * Obtiene el estado de la inscripción.
     * 
     * @return Estado de la inscripción.
     */
    public EstadoInscripcionDTO getEstado() {
        return estado;
    }
    
}
