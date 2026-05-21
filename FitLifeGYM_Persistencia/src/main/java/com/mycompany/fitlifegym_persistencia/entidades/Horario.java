/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitlifegym_persistencia.entidades;

import java.time.LocalTime;
import java.util.List;
import java.util.Objects;
import org.bson.BsonType;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonRepresentation;

/**
 * Entidad que representa
 * un horario dentro del sistema.
 * 
 * Contiene la información relacionada
 * con los horarios asignados
 * a los cursos.
 * 
 * @author PC GAMER MASTER RACE
 */
public class Horario { 
    /**
     * ID único del horario.
     */
    @BsonId
    @BsonRepresentation(BsonType.OBJECT_ID)
    private String idHorario;

    /**
     * ID del curso asociado
     * al horario.
     */
    @BsonRepresentation(BsonType.OBJECT_ID)
    private String idCurso;

    /**
     * Días de la semana
     * en los que se imparte el horario.
     */
    private List<HorarioDiaSemana> dias;
    
    /**
     * Hora de inicio del horario.
     */
    private LocalTime horaInicio;
    
    /**
     * Hora de finalización del horario.
     */
    private LocalTime horaFin;
    
    /**
     * Cupo máximo permitido
     * para el horario.
     */
    private Integer cupoMax;
    
    /**
     * Cupo actual ocupado
     * dentro del horario.
     */
    private Integer cupoActual;

    /**
     * Constructor vacío de la clase.
     */
    public Horario() {
    }

    /**
     * Constructor completo del horario.
     * 
     * @param idHorario ID del horario.
     * @param idCurso ID del curso asociado.
     * @param dias Días del horario.
     * @param horaInicio Hora de inicio.
     * @param horaFin Hora de finalización.
     * @param cupoMax Cupo máximo.
     * @param cupoActual Cupo actual.
     */
    public Horario(String idHorario, String idCurso, List<HorarioDiaSemana> dias, LocalTime horaInicio, LocalTime horaFin, Integer cupoMax, Integer cupoActual) {
        this.idHorario = idHorario;
        this.idCurso = idCurso;
        this.dias = dias;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.cupoMax = cupoMax;
        this.cupoActual = cupoActual;
    }

    /**
     * Constructor que inicializa
     * los datos principales del horario.
     * 
     * @param idCurso ID del curso asociado.
     * @param dias Días del horario.
     * @param horaInicio Hora de inicio.
     * @param horaFin Hora de finalización.
     * @param cupoMax Cupo máximo.
     * @param cupoActual Cupo actual.
     */
    public Horario(String idCurso, List<HorarioDiaSemana> dias, LocalTime horaInicio, LocalTime horaFin, Integer cupoMax, Integer cupoActual) {
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
     * Establece el ID del horario.
     * 
     * @param idHorario Nuevo ID del horario.
     */
    public void setIdHorario(String idHorario) {
        this.idHorario = idHorario;
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
     * Establece el ID del curso asociado.
     * 
     * @param idCurso Nuevo ID del curso.
     */
    public void setIdCurso(String idCurso) {
        this.idCurso = idCurso;
    }

    /**
     * Obtiene los días del horario.
     * 
     * @return Lista de días del horario.
     */
    public List<HorarioDiaSemana> getDias() {
        return dias;
    }

    /**
     * Establece los días del horario.
     * 
     * @param dias Nueva lista de días.
     */
    public void setDias(List<HorarioDiaSemana> dias) {
        this.dias = dias;
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
     * Establece la hora de inicio.
     * 
     * @param horaInicio Nueva hora de inicio.
     */
    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
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
     * Establece la hora de finalización.
     * 
     * @param horaFin Nueva hora de finalización.
     */
    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    /**
     * Obtiene el cupo máximo del horario.
     * 
     * @return Cupo máximo.
     */
    public Integer getCupoMax() {
        return cupoMax;
    }

    /**
     * Establece el cupo máximo del horario.
     * 
     * @param cupoMax Nuevo cupo máximo.
     */
    public void setCupoMax(Integer cupoMax) {
        this.cupoMax = cupoMax;
    }

    /**
     * Obtiene el cupo actual del horario.
     * 
     * @return Cupo actual.
     */
    public Integer getCupoActual() {
        return cupoActual;
    }

    /**
     * Establece el cupo actual del horario.
     * 
     * @param cupoActual Nuevo cupo actual.
     */
    public void setCupoActual(Integer cupoActual) {
        this.cupoActual = cupoActual;
    }

    /**
     * Genera el hashCode del horario.
     * 
     * @return Valor hash del horario.
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.idHorario);
        return hash;
    }

    /**
     * Compara si dos horarios
     * son iguales mediante su ID.
     * 
     * @param obj Objeto a comparar.
     * @return true si son iguales,
     * false en caso contrario.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Horario other = (Horario) obj;
        return Objects.equals(this.idHorario, other.idHorario);
    }

    /**
     * Obtiene la representación
     * en texto del horario.
     * 
     * @return Cadena con la información del horario.
     */
    @Override
    public String toString() {
        return "Horario{" + "idHorario=" + idHorario + ", idCurso=" + idCurso + ", dias=" + dias + ", horaInicio=" + horaInicio + ", horaFin=" + horaFin + ", cupoMax=" + cupoMax + ", cupoActual=" + cupoActual + '}';
    }
    
    
    
}
