/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitlifegym_dtos;

import java.time.LocalTime;

/**
 *
 * @author PC GAMER MASTER RACE
 */
public class HorarioDTO {
    private String idHorario;
    private String idCurso;
    private HorarioDiaSemanaDTO dias;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private Integer cupoMax;
    private Integer cupoActual;

    public HorarioDTO() {
    }

    public HorarioDTO(String idCurso, HorarioDiaSemanaDTO dias, LocalTime horaInicio, LocalTime horaFin, Integer cupoMax, Integer cupoActual) {
        this.idCurso = idCurso;
        this.dias = dias;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.cupoMax = cupoMax;
        this.cupoActual = cupoActual;
    }

    public HorarioDTO(String idHorario, String idCurso, HorarioDiaSemanaDTO dias, LocalTime horaInicio, LocalTime horaFin, Integer cupoMax, Integer cupoActual) {
        this.idHorario = idHorario;
        this.idCurso = idCurso;
        this.dias = dias;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.cupoMax = cupoMax;
        this.cupoActual = cupoActual;
    }

    public String getIdHorario() {
        return idHorario;
    }

    public String getIdCurso() {
        return idCurso;
    }

    public HorarioDiaSemanaDTO getDias() {
        return dias;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public Integer getCupoMax() {
        return cupoMax;
    }

    public Integer getCupoActual() {
        return cupoActual;
    }
    
    
    
}
