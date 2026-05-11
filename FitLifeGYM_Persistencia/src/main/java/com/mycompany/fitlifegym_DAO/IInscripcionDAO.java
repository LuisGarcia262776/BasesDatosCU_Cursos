/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.fitlifegym_DAO;

import com.mycompany.fitlifegym_PersistenciaException.PersistenciaException;
import com.mycompany.fitlifegym_persistencia.entidades.Inscripcion;
import java.util.List;

/**
 *
 * @author PC GAMER MASTER RACE
 */
public interface IInscripcionDAO {
    
    public abstract List<Inscripcion> obtenerTodas() throws PersistenciaException;

    public abstract Inscripcion obtenerPorId(String idInscripcion) throws PersistenciaException;

    public abstract Inscripcion guardar(Inscripcion inscripcion) throws PersistenciaException;

    public abstract Inscripcion actualizar(Inscripcion inscripcion) throws PersistenciaException;

    public abstract Integer contarTotales() throws PersistenciaException;

    public abstract Integer contarPorHorario(String idHorario) throws PersistenciaException;

    public abstract List<Inscripcion> obtenerActivasPorHorario(String idHorario) throws PersistenciaException;

    public abstract List<Inscripcion> obtenerPorCliente(String idCliente) throws PersistenciaException;
    
}
