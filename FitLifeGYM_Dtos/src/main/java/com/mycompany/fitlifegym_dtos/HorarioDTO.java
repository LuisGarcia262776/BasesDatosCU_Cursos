/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitlifegym_dtos;

import java.time.LocalTime;
import java.util.List;

/**
 * DTO que representa la información de un horario
 * asociado a un curso dentro del sistema.
 * 
 * Contiene los datos necesarios para administrar
 * horarios e inscripciones de cursos.
 * 
 * @author PC GAMER MASTER RACE
 */
public class HorarioDTO {
    /**
     * ID único del horario.
     */
    private String idHorario;
    
    /**
     * ID del curso asociado al horario.
     */
    private String idCurso;
    
    /**
     * Lista de días en los que se imparte el horario.
     */
    private List<HorarioDiaSemanaDTO> dias;
    
    /**
     * Hora de inicio del horario.
     */
    private LocalTime horaInicio;
    
    /**
     * Hora de finalización del horario.
     */
    private LocalTime horaFin;
    
    /**
     * Cupo máximo permitido en el horario.
     */
    private Integer cupoMax;
    
    /**
     * Cupo actual registrado en el horario.
     */
    private Integer cupoActual;

    /**
     * Constructor vacío.
     */
    public HorarioDTO() {
    }

    /**
     * Constructor para registrar un nuevo horario.
     * 
     * @param idCurso ID del curso asociado.
     * @param dias Lista de días del horario.
     * @param horaInicio Hora de inicio.
     * @param horaFin Hora de finalización.
     * @param cupoMax Cupo máximo permitido.
     * @param cupoActual Cupo actual registrado.
     */
    public HorarioDTO(String idCurso, List<HorarioDiaSemanaDTO> dias, LocalTime horaInicio, LocalTime horaFin, Integer cupoMax, Integer cupoActual) {
        this.idCurso = idCurso;
        this.dias = dias;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.cupoMax = cupoMax;
        this.cupoActual = cupoActual;
    }

    /**
     * Constructor que inicializa todos los datos del horario.
     * 
     * @param idHorario ID del horario.
     * @param idCurso ID del curso asociado.
     * @param dias Lista de días del horario.
     * @param horaInicio Hora de inicio.
     * @param horaFin Hora de finalización.
     * @param cupoMax Cupo máximo permitido.
     * @param cupoActual Cupo actual registrado.
     */
    public HorarioDTO(String idHorario, String idCurso, List<HorarioDiaSemanaDTO> dias, LocalTime horaInicio, LocalTime horaFin, Integer cupoMax, Integer cupoActual) {
        this.idHorario = idHorario;
        this.idCurso = idCurso;
        this.dias = dias;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.cupoMax = cupoMax;
        this.cupoActual = cupoActual;
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
     * Obtiene el ID del curso asociado.
     * 
     * @return ID del curso.
     */
    public String getIdCurso() {
        return idCurso;
    }

    /**
     * Obtiene los días del horario.
     * 
     * @return Lista de días.
     */
    public List<HorarioDiaSemanaDTO> getDias() {
        return dias;
    }

    /**
     * Obtiene la hora de inicio.
     * 
     * @return Hora de inicio.
     */
    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    /**
     * Obtiene la hora de finalización.
     * 
     * @return Hora de finalización.
     */
    public LocalTime getHoraFin() {
        return horaFin;
    }

    /**
     * Obtiene el cupo máximo permitido.
     * 
     * @return Cupo máximo.
     */
    public Integer getCupoMax() {
        return cupoMax;
    }

    /**
     * Obtiene el cupo actual registrado.
     * 
     * @return Cupo actual.
     */
    public Integer getCupoActual() {
        return cupoActual;
    }
    
}
