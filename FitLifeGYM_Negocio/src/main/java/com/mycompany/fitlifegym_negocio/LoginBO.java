/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitlifegym_negocio;

import Adapter.DtosAEntidadesAdapter;
import com.mycompany.fitlifegym_PersistenciaException.PersistenciaException;
import com.mycompany.fitlifegym_dtos.ClienteLogueadoDTO;
import com.mycompany.fitlifegym_dtos.LoginDTO;
import com.mycompany.fitlifegym_persistencia.entidades.Cliente;
import com.mycompany.fitlifegym_persistencia_Fachada.IPersistenciaFachada;
import com.mycompany.fitlifegym_persistencia_Fachada.PersistenciaFachada;
import java.util.List;


/**
 *
 * @author PC GAMER MASTER RACE
 */
public class LoginBO implements ILoginBO {
    private final IPersistenciaFachada fachada;

    public LoginBO() {
        this.fachada = new PersistenciaFachada();
    }

    @Override
    public ClienteLogueadoDTO iniciarSesion(LoginDTO login) throws NegocioException {
        try {
            List<Cliente> clientes = fachada.obtenerClienteDAO().consultarClientes();

            for (Cliente cliente : clientes) {
                boolean pinCorrecto = cliente.getPin().equals(login.getPin());

                boolean contraseniaCorrecta = cliente.getContrasenia().equals(login.getContrasenia());

                if (pinCorrecto && contraseniaCorrecta) {
                    return DtosAEntidadesAdapter.adaptarClienteLogueado(cliente);
                }
            }
            
            throw new NegocioException("PIN o contraseña incorrectos.");
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al iniciar sesión.", ex );
        }
    }
        
}
        

    

