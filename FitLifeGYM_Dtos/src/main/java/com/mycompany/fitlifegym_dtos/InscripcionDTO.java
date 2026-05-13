/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitlifegym_dtos;

import java.time.LocalDateTime;

/**
 *
 * @author PC GAMER MASTER RACE
 */
public class InscripcionDTO {
    private String idInscripcion;
    private String idCliente;
    private String idHorario;
    private LocalDateTime fechaRegistro;
    private EstadoInscripcionDTO estado;

    public InscripcionDTO() {
    }

    public InscripcionDTO(String idCliente, String idHorario) {
        this.idCliente = idCliente;
        this.idHorario = idHorario;
        this.fechaRegistro = LocalDateTime.now();
        this.estado = EstadoInscripcionDTO.ACTIVA;
    }

    public InscripcionDTO(String idInscripcion, String idCliente, String idHorario, LocalDateTime fechaRegistro, EstadoInscripcionDTO estado) {
        this.idInscripcion = idInscripcion;
        this.idCliente = idCliente;
        this.idHorario = idHorario;
        this.fechaRegistro = fechaRegistro;
        this.estado = estado;
    }

    public String getIdInscripcion() {
        return idInscripcion;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public String getIdHorario() {
        return idHorario;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public EstadoInscripcionDTO getEstado() {
        return estado;
    }
    
    
    
}
