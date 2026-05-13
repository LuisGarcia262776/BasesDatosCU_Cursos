
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
    private final IClientesDAO clientesDAO;

    public RenovarMembresiaBO(IPersistenciaFachada fachada) {
        this.clientesDAO = fachada.obtenerClienteDAO();
    }

    @Override
    public void renovarMembresia(RenovarMembresiaDTO dto) throws NegocioException {
        TipoMembresia tipo = DtosAEntidadesAdapter.adaptarTipoMembresia(dto.getTipoMembresia());
        try {
            clientesDAO.actualizarMembresia(dto.getIdCliente(), tipo);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al renovar la membresia.", ex);
        }
    }
    
    
}
