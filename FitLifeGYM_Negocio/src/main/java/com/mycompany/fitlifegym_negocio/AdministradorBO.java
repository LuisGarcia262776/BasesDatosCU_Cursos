/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitlifegym_negocio;

import com.mycompany.fitlifegym_DAO.IAdministradorDAO;
import com.mycompany.fitlifegym_PersistenciaException.PersistenciaException;
import com.mycompany.fitlifegym_dtos.AdministradorLogueadoDTO;
import com.mycompany.fitlifegym_persistencia.entidades.Administrador;
import com.mycompany.fitlifegym_persistencia_Fachada.IPersistenciaFachada;
import com.mycompany.fitlifegym_persistencia_Fachada.PersistenciaFachada;

/**
 *
 * @author PC GAMER MASTER RACE
 */
public class AdministradorBO implements IAdministradorBO{
    
    private final IPersistenciaFachada fachada;

    public AdministradorBO() {
        this.fachada = new PersistenciaFachada();
    }


    @Override
    public AdministradorLogueadoDTO iniciarSesion(String pin, String contrasenia) throws NegocioException {
        try{
            Administrador admin = fachada.obtenerAdministradorDAO().buscarPorPinYContrasenia(pin, contrasenia);
            if(admin == null){
                throw new NegocioException("El Administrador no Puede ser Nulo");
            }
            return new AdministradorLogueadoDTO(admin.getPin(), admin.getPin());
        }catch(PersistenciaException ex){
            throw new NegocioException("Pin o contraseña incorrectos", ex);
        }
        
        
    }
    
}
