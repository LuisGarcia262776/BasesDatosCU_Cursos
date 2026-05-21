/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.fitlifegym_negocio;

import com.mycompany.fitlifegym_dtos.NuevaMembresiaCompradaDTO;
import com.mycompany.fitlifegym_persistencia.entidades.MembresiaComprada;
import java.util.List;

/**
 * Interfaz que define las operaciones de negocio
 * relacionadas con las membresías compradas
 * dentro del sistema.
 * 
 * Permite guardar y consultar membresías
 * adquiridas por los clientes.
 * 
 * @author Diego
 */
public interface IMembresiaCompradaBO {

    /**
     * Guarda una membresía comprada dentro del sistema.
     * 
     * @param compra DTO con la información de la membresía comprada.
     * @return Entidad de la membresía comprada guardada.
     * @throws NegocioException Se lanza cuando los datos
     * son inválidos o ocurre un error de negocio.
     */
    public abstract MembresiaComprada guardar(NuevaMembresiaCompradaDTO compra) throws NegocioException;

    /**
     * Obtiene todas las membresías compradas registradas.
     * 
     * @return Lista de membresías compradas.
     * @throws NegocioException Se lanza cuando ocurre
     * un error al consultar las membresías compradas.
     */
    public abstract List<MembresiaComprada> obtenerTodas() throws NegocioException;
}
