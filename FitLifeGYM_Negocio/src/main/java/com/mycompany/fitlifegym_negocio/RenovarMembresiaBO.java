
package com.mycompany.fitlifegym_negocio;

import com.mycompany.fitlifegym_dtos.RenovarMembresiaDTO;


/**
 * Clase de negocio encargada de gestionar
 * la renovación de membresías de clientes.
 * 
 * Permite validar la información necesaria
 * para realizar una renovación de membresía.
 * 
 * @author PC GAMER MASTER RACE
 */
public class RenovarMembresiaBO implements IRenovarMembresiaBO {
    /**
     * Constructor vacío de la clase RenovarMembresiaBO.
     */
    public RenovarMembresiaBO() {
    }

    /**
     * Realiza la validación de los datos necesarios
     * para renovar una membresía.
     * 
     * @param dto DTO con la información de renovación.
     * @throws NegocioException Se lanza cuando
     * los datos son inválidos.
     */
    @Override
    public void renovarMembresia(RenovarMembresiaDTO dto) throws NegocioException {
        if (dto == null) {
            throw new NegocioException("Los datos no pueden ser null.");
        }

        if (dto.getIdCliente() == null || dto.getIdCliente().isBlank()) {
            throw new NegocioException("El idCliente es obligatorio.");
        }

        if (dto.getTipoMembresia() == null) {
            throw new NegocioException("Debe seleccionar una membresía.");
        }
    }
    
}
