/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.fitlifegym_negocio;

import com.mycompany.fitlifegym_dtos.NuevaMembresiaDTO;
import com.mycompany.fitlifegym_dtos.TipoMembresiaDTO;
import java.util.List;

/**
 *
 * @author Diego
 */
public interface IMembresiaBO {

    public abstract List<NuevaMembresiaDTO>obtenerTodas() throws NegocioException;

    public abstract NuevaMembresiaDTO buscarPorTipo(TipoMembresiaDTO tipo) throws NegocioException;
}
