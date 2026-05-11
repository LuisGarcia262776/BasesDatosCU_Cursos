/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitlifegym_persistencia.entidades;

import java.time.LocalTime;
import java.util.Objects;
import org.bson.BsonType;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonRepresentation;

/**
 *
 * @author PC GAMER MASTER RACE
 */
public class Horario { 
    @BsonId
    @BsonRepresentation(BsonType.OBJECT_ID)
    private String idHorario;

    @BsonRepresentation(BsonType.OBJECT_ID)
    private String idCurso;

    private HorarioDiaSemana dias;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private Integer cupoMax;
    private Integer cupoActual;

    public Horario() {
    }

    public Horario(String idCurso, HorarioDiaSemana dias, LocalTime horaInicio, LocalTime horaFin, Integer cupoMax, Integer cupoActual) {
        this.idCurso = idCurso;
        this.dias = dias;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.cupoMax = cupoMax;
        this.cupoActual = cupoActual;
    }

    public Horario(String idHorario, String idCurso, HorarioDiaSemana dias, LocalTime horaInicio, LocalTime horaFin, Integer cupoMax, Integer cupoActual) {
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

    public void setIdHorario(String idHorario) {
        this.idHorario = idHorario;
    }

    public String getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(String idCurso) {
        this.idCurso = idCurso;
    }

    public HorarioDiaSemana getDias() {
        return dias;
    }

    public void setDias(HorarioDiaSemana dias) {
        this.dias = dias;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    public Integer getCupoMax() {
        return cupoMax;
    }

    public void setCupoMax(Integer cupoMax) {
        this.cupoMax = cupoMax;
    }

    public Integer getCupoActual() {
        return cupoActual;
    }

    public void setCupoActual(Integer cupoActual) {
        this.cupoActual = cupoActual;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.idHorario);
        return hash;
    }

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

    @Override
    public String toString() {
        return "Horario{" + "idHorario=" + idHorario + ", idCurso=" + idCurso + ", dias=" + dias + ", horaInicio=" + horaInicio + ", horaFin=" + horaFin + ", cupoMax=" + cupoMax + ", cupoActual=" + cupoActual + '}';
    }
    
    
    
}
