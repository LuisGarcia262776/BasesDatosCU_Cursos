/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.fitlifegym_negocio;

import com.mycompany.fitlifegym_dtos.DatosReporteDTO;
import com.mycompany.fitlifegym_dtos.ReporteDTO;

/**
 * Interfaz que define las operaciones de negocio
 * relacionadas con la generación de reportes
 * dentro del sistema.
 * 
 * Permite validar filtros y generar reportes
 * basados en cursos y horarios.
 * 
 * @author PC GAMER MASTER RACE
 */
public interface IReporteBO {
    /**
     * Obtiene y valida los datos necesarios
     * para generar un reporte.
     * 
     * @param datosReporteDTO DTO con los filtros del reporte.
     * @return DTO validado con los datos del reporte.
     * @throws NegocioException Se lanza cuando los filtros
     * son inválidos o ocurre un error de negocio.
     */
    public DatosReporteDTO obtenerDatosReporte(DatosReporteDTO datosReporteDTO) throws NegocioException;

    /**
     * Genera un reporte utilizando los filtros proporcionados.
     * 
     * @param datosReporteDTO DTO con los filtros del reporte.
     * @return DTO con la información del reporte generado.
     * @throws NegocioException Se lanza cuando los filtros
     * son inválidos o ocurre un error de negocio.
     */
    public ReporteDTO generarReporte(DatosReporteDTO datosReporteDTO) throws NegocioException;

    /**
     * Valida los filtros utilizados
     * para generar un reporte.
     * 
     * @param datosReporteDTO DTO con los filtros del reporte.
     * @return true si los filtros son válidos.
     * @throws NegocioException Se lanza cuando ocurre
     * un error durante la validación.
     */
    public boolean validarFiltros(DatosReporteDTO datosReporteDTO) throws NegocioException;
    
}
