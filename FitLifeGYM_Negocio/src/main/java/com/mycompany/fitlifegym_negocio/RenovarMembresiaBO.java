
package com.mycompany.fitlifegym_negocio;

import Adapter.DtosAEntidadesAdapter;
import com.mycompany.fitlifegym_DAO.IClientesDAO;
import com.mycompany.fitlifegym_PersistenciaException.PersistenciaException;
import com.mycompany.fitlifegym_dtos.RenovarMembresiaDTO;
import com.mycompany.fitlifegym_persistencia.entidades.TipoMembresia;
import com.mycompany.fitlifegym_persistencia_Fachada.IPersistenciaFachada;

/**
 *
 * @author PC GAMER MASTER RACE
 */
public class RenovarMembresiaBO implements IRenovarMembresiaBO {
    public RenovarMembresiaBO() {
    }

    @Override
    public void renovarMembresia(RenovarMembresiaDTO dto) throws NegocioException {
        if (dto == null) {
            throw new NegocioException("Los datos no pueden ser null.");
        }

        
    }
    
    
}
