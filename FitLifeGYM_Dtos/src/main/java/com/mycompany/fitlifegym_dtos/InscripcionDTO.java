/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitlifegym_dtos;

import java.util.Date;

/**
 *
 * @author PC GAMER MASTER RACE
 */
public class InscripcionDTO {
    private String idInscripcion;
    private String idCliente;
    private String idHorario;
    private Date fechaRegistro;
    private EstadoInscripcionDTO estado;

    public InscripcionDTO() {
    }

    public InscripcionDTO(String idCliente, String idHorario) {
        this.idCliente = idCliente;
        this.idHorario = idHorario;
        this.fechaRegistro = new Date();
        this.estado = EstadoInscripcionDTO.ACTIVO;
    }

    public InscripcionDTO(String idInscripcion, String idCliente, String idHorario, Date fechaRegistro, EstadoInscripcionDTO estado) {
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

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public EstadoInscripcionDTO getEstado() {
        return estado;
    }
    
    
    
}
