/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitlifegym_dtos;

import java.util.Date;

/**
 * DTO que representa los filtros y datos necesarios
 * para generar reportes dentro del sistema.
 * 
 * Permite filtrar información por fechas, cantidad mínima,
 * días de la semana y curso.
 * 
 * @author PC GAMER MASTER RACE
 */
public class DatosReporteDTO {
    /**
     * Fecha inicial del rango del reporte.
     */
    private Date fechaInicio;
    
    /**
     * Fecha final del rango del reporte.
     */
    private Date fechaFin;
    
    /**
     * Cantidad mínima utilizada como filtro.
     */
    private Integer cantidadMin;
    
    /**
     * Día de la semana utilizado como filtro.
     */
    private HorarioDiaSemanaDTO dias;
    
    /**
     * ID del curso asociado al reporte.
     */
    private String Idcurso;

    /**
     * Constructor vacío.
     */
    public DatosReporteDTO() {
    }

    /**
     * Constructor que inicializa todos los filtros
     * necesarios para generar un reporte.
     * 
     * @param fechaInicio Fecha inicial del reporte.
     * @param fechaFin Fecha final del reporte.
     * @param cantidadMin Cantidad mínima utilizada como filtro.
     * @param dias Día de la semana utilizado como filtro.
     * @param Idcurso ID del curso asociado al reporte.
     */
    public DatosReporteDTO(Date fechaInicio, Date fechaFin, Integer cantidadMin, HorarioDiaSemanaDTO dias, String Idcurso) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.cantidadMin = cantidadMin;
        this.dias = dias;
        this.Idcurso = Idcurso;
    }

    /**
     * Obtiene la fecha inicial del reporte.
     * 
     * @return Fecha inicial.
     */
    public Date getFechaInicio() {
        return fechaInicio;
    }

    /**
     * Obtiene la fecha final del reporte.
     * 
     * @return Fecha final.
     */
    public Date getFechaFin() {
        return fechaFin;
    }

    /**
     * Obtiene la cantidad mínima utilizada como filtro.
     * 
     * @return Cantidad mínima.
     */
    public Integer getCantidadMin() {
        return cantidadMin;
    }

    /**
     * Obtiene el día de la semana utilizado como filtro.
     * 
     * @return Día de la semana.
     */
    public HorarioDiaSemanaDTO getDias() {
        return dias;
    }

    /**
     * Obtiene el ID del curso asociado al reporte.
     * 
     * @return ID del curso.
     */
    public String getCurso() {
        return Idcurso;
    }
    
}
