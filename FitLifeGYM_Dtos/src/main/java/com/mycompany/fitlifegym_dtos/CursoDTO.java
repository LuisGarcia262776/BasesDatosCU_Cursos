/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitlifegym_dtos;

/**
 *
 * @author PC GAMER MASTER RACE
 */
public class CursoDTO {
    private String idCurso;
    private String nombre;
    private String imagen;
    private String descripcion;
    private Integer cupoMinimo;
    private DisponibilidadCursoDTO disponibilidad;

    public CursoDTO() {
    }

    public CursoDTO(String nombre, String imagen, String descripcion, Integer cupoMinimo, DisponibilidadCursoDTO disponibilidad) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.descripcion = descripcion;
        this.cupoMinimo = cupoMinimo;
        this.disponibilidad = disponibilidad;
    }

    public CursoDTO(String idCurso, String nombre, String imagen, String descripcion, Integer cupoMinimo, DisponibilidadCursoDTO disponibilidad) {
        this.idCurso = idCurso;
        this.nombre = nombre;
        this.imagen = imagen;
        this.descripcion = descripcion;
        this.cupoMinimo = cupoMinimo;
        this.disponibilidad = disponibilidad;
    }

    public String getIdCurso() {
        return idCurso;
    }

    public String getNombre() {
        return nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Integer getCupoMinimo() {
        return cupoMinimo;
    }

    public DisponibilidadCursoDTO getDisponibilidad() {
        return disponibilidad;
    }
    
    
    
}
