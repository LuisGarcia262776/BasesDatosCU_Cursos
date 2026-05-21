/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitlifegym_persistencia.entidades;

import java.util.Objects;
import org.bson.BsonType;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonRepresentation;

/**
 * Entidad que representa
 * un curso dentro del sistema.
 * 
 * Contiene la información general
 * relacionada con los cursos
 * ofrecidos por el gimnasio.
 * 
 * @author PC GAMER MASTER RACE
 */
public class Curso {
    /**
     * ID único del curso.
     */
    @BsonId
    @BsonRepresentation(BsonType.OBJECT_ID)
    private String idCurso;
    
    /**
     * Nombre del curso.
     */
    private String nombre;
    
    /**
     * Imagen asociada al curso.
     */
    private Imagen imagen;
    
    /**
     * Descripción del curso.
     */
    private String descripcion;
    
    /**
     * Cupo mínimo requerido
     * para el curso.
     */
    private Integer cupoMinimo;
    
    /**
     * Disponibilidad actual del curso.
     */
    private DisponibilidadCurso disponibilidad;
    
    /**
     * Constructor vacío de la clase.
     */
    public Curso() {
        
    }

    /**
     * Constructor que inicializa
     * los datos principales del curso.
     * 
     * @param nombre Nombre del curso.
     * @param imagen Imagen del curso.
     * @param descripcion Descripción del curso.
     * @param cupoMinimo Cupo mínimo del curso.
     * @param disponibilidad Disponibilidad del curso.
     */
    public Curso(String nombre, Imagen imagen, String descripcion, Integer cupoMinimo, DisponibilidadCurso disponibilidad) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.descripcion = descripcion;
        this.cupoMinimo = cupoMinimo;
        this.disponibilidad = disponibilidad;
    }

    /**
     * Constructor completo del curso.
     * 
     * @param idCurso ID del curso.
     * @param nombre Nombre del curso.
     * @param imagen Imagen del curso.
     * @param descripcion Descripción del curso.
     * @param cupoMinimo Cupo mínimo del curso.
     * @param disponibilidad Disponibilidad del curso.
     */
    public Curso(String idCurso, String nombre, Imagen imagen, String descripcion, Integer cupoMinimo, DisponibilidadCurso disponibilidad) {
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
     * Establece el ID del curso.
     * 
     * @param idCurso Nuevo ID del curso.
     */
    public void setIdCurso(String idCurso) {
        this.idCurso = idCurso;
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
     * Establece el nombre del curso.
     * 
     * @param nombre Nuevo nombre del curso.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la imagen del curso.
     * 
     * @return Imagen del curso.
     */
    public Imagen getImagen() {
        return imagen;
    }

    /**
     * Establece la imagen del curso.
     * 
     * @param imagen Nueva imagen del curso.
     */
    public void setImagen(Imagen imagen) {
        this.imagen = imagen;
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
     * Establece la descripción del curso.
     * 
     * @param descripcion Nueva descripción del curso.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene el cupo mínimo del curso.
     * 
     * @return Cupo mínimo del curso.
     */
    public Integer getCupoMinimo() {
        return cupoMinimo;
    }

    /**
     * Establece el cupo mínimo del curso.
     * 
     * @param cupoMinimo Nuevo cupo mínimo del curso.
     */
    public void setCupoMinimo(Integer cupoMinimo) {
        this.cupoMinimo = cupoMinimo;
    }

    /**
     * Obtiene la disponibilidad del curso.
     * 
     * @return Disponibilidad del curso.
     */
    public DisponibilidadCurso getDisponibilidad() {
        return disponibilidad;
    }

    /**
     * Establece la disponibilidad del curso.
     * 
     * @param disponibilidad Nueva disponibilidad del curso.
     */
    public void setDisponibilidad(DisponibilidadCurso disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    /**
     * Genera el hashCode del curso.
     * 
     * @return Valor hash del curso.
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.idCurso);
        return hash;
    }

    /**
     * Compara si dos cursos
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
        final Curso other = (Curso) obj;
        return Objects.equals(this.idCurso, other.idCurso);
    }

    /**
     * Obtiene la representación
     * en texto del curso.
     * 
     * @return Cadena con la información del curso.
     */
    @Override
    public String toString() {
        return "Curso{" + "idCurso=" + idCurso + ", nombre=" + nombre + ", imagen=" + imagen + ", descripcion=" + descripcion + ", cupoMinimo=" + cupoMinimo + ", disponibilidad=" + disponibilidad + '}';
    }
    
}
