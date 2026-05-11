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
 *
 * @author PC GAMER MASTER RACE
 */
public class Curso {
    @BsonId
    @BsonRepresentation(BsonType.OBJECT_ID)
    private String idCurso;
    private String nombre;
    private String imagen;
    private String descripcion;
    private Integer cupoMinimo;
    private DisponibilidadCurso disponibilidad;
    
    public Curso() {
        
    }

    public Curso(String nombre, String imagen, String descripcion, Integer cupoMinimo, DisponibilidadCurso disponibilidad) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.descripcion = descripcion;
        this.cupoMinimo = cupoMinimo;
        this.disponibilidad = disponibilidad;
    }

    public Curso(String idCurso, String nombre, String imagen, String descripcion, Integer cupoMinimo, DisponibilidadCurso disponibilidad) {
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

    public void setIdCurso(String idCurso) {
        this.idCurso = idCurso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getCupoMinimo() {
        return cupoMinimo;
    }

    public void setCupoMinimo(Integer cupoMinimo) {
        this.cupoMinimo = cupoMinimo;
    }

    public DisponibilidadCurso getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(DisponibilidadCurso disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.idCurso);
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
        final Curso other = (Curso) obj;
        return Objects.equals(this.idCurso, other.idCurso);
    }

    @Override
    public String toString() {
        return "Curso{" + "idCurso=" + idCurso + ", nombre=" + nombre + ", imagen=" + imagen + ", descripcion=" + descripcion + ", cupoMinimo=" + cupoMinimo + ", disponibilidad=" + disponibilidad + '}';
    }
    
}
