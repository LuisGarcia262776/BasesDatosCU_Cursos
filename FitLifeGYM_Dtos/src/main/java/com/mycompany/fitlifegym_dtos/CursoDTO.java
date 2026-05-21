/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitlifegym_dtos;

/**
 * DTO que representa la información de un curso dentro del sistema.
 * 
 * Contiene los datos necesarios para registrar, consultar
 * y administrar cursos.
 * 
 * @author PC GAMER MASTER RACE
 */
public class CursoDTO {
    /**
     * ID único del curso.
     */
    private String idCurso;
    
    /**
     * Nombre del curso.
     */
    private String nombre;
    
    /**
     * Imagen representativa del curso.
     */
    private ImagenDTO imagen;
    
    /**
     * Descripción del curso.
     */
    private String descripcion;
    
    /**
     * Cupo mínimo requerido para el curso.
     */
    private Integer cupoMinimo;
    
    /**
     * Disponibilidad actual del curso.
     */
    private DisponibilidadCursoDTO disponibilidad;

    /**
     * Constructor vacío.
     */
    public CursoDTO() {
    }

    /**
     * Constructor para registrar un nuevo curso.
     * 
     * @param nombre Nombre del curso.
     * @param imagen Imagen representativa del curso.
     * @param descripcion Descripción del curso.
     * @param cupoMinimo Cupo mínimo del curso.
     * @param disponibilidad Disponibilidad del curso.
     */
    public CursoDTO(String nombre, ImagenDTO imagen, String descripcion, Integer cupoMinimo, DisponibilidadCursoDTO disponibilidad) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.descripcion = descripcion;
        this.cupoMinimo = cupoMinimo;
        this.disponibilidad = disponibilidad;
    }

    /**
     * Constructor que inicializa todos los datos del curso.
     * 
     * @param idCurso ID del curso.
     * @param nombre Nombre del curso.
     * @param imagen Imagen representativa del curso.
     * @param descripcion Descripción del curso.
     * @param cupoMinimo Cupo mínimo del curso.
     * @param disponibilidad Disponibilidad del curso.
     */
    public CursoDTO(String idCurso, String nombre, ImagenDTO imagen, String descripcion, Integer cupoMinimo, DisponibilidadCursoDTO disponibilidad) {
        this.idCurso = idCurso;
        this.nombre = nombre;
        this.imagen = imagen;
        this.descripcion = descripcion;
        this.cupoMinimo = cupoMinimo;
        this.disponibilidad = disponibilidad;
    }

    /**
     * Obtiene el ID del curso.
     * 
     * @return ID del curso.
     */
    public String getIdCurso() {
        return idCurso;
    }

    /**
     * Obtiene el nombre del curso.
     * 
     * @return Nombre del curso.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene la imagen del curso.
     * 
     * @return Imagen representativa del curso.
     */
    public ImagenDTO getImagen() {
        return imagen;
    }

    /**
     * Obtiene la descripción del curso.
     * 
     * @return Descripción del curso.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Obtiene el cupo mínimo del curso.
     * 
     * @return Cupo mínimo.
     */
    public Integer getCupoMinimo() {
        return cupoMinimo;
    }

    /**
     * Obtiene la disponibilidad del curso.
     * 
     * @return Disponibilidad del curso.
     */
    public DisponibilidadCursoDTO getDisponibilidad() {
        return disponibilidad;
    }
    
}
