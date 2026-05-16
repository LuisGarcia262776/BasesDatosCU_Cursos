/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitlifegym_negocio;

import com.mycompany.fitlifegym_dtos.NuevaMembresiaDTO;
import com.mycompany.fitlifegym_dtos.TipoMembresiaDTO;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author PC GAMER MASTER RACE
 */
public class MembresiaBO implements IMembresiaBO {
    
    public MembresiaBO() {
    }

    @Override
    public List<NuevaMembresiaDTO>obtenerTodas() throws NegocioException {
        List<NuevaMembresiaDTO> lista = new LinkedList<>();

        lista.add(new NuevaMembresiaDTO(TipoMembresiaDTO.ORO, 1200.00, LocalDate.now().plusMonths(1)));

        lista.add(new NuevaMembresiaDTO(TipoMembresiaDTO.PLATA, 800.00, LocalDate.now().plusMonths(1)));

        lista.add(new NuevaMembresiaDTO(TipoMembresiaDTO.BRONCE, 500.00, LocalDate.now().plusMonths(1)));

        return lista;
    }

    @Override
    public NuevaMembresiaDTO buscarPorTipo(TipoMembresiaDTO tipo) throws NegocioException {
        List<NuevaMembresiaDTO> membresias = obtenerTodas();

        for (NuevaMembresiaDTO membresia : membresias) {
            if (membresia.getTipoMembresia() == tipo) {
                return membresia;
            }
        }
        throw new NegocioException("No se encontró la membresía.");
    }

    
    
}
