/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitlifegym_DAO;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mycompany.fitlifegym_Manejador_Conexiones.ManejadorConexiones;
import static com.mycompany.fitlifegym_Manejador_Conexiones.ManejadorConexiones.obtenerCodecs;
import com.mycompany.fitlifegym_PersistenciaException.PersistenciaException;
import com.mycompany.fitlifegym_persistencia.entidades.Administrador;
import java.util.logging.Logger;
import org.bson.Document;

/**
 *
 * @author PC GAMER MASTER RACE
 */
public class AdministradorDAO implements IAdministradorDAO {
    private static final Logger LOGGER = Logger.getLogger(AdministradorDAO.class.getName());
    private static final String NOMBRE_COLECCION = "administradores";

    private MongoDatabase obtenerBaseDatos(MongoClient cliente) {
        MongoDatabase empresaBD = cliente.getDatabase(ManejadorConexiones.BASE_DATOS).withCodecRegistry(obtenerCodecs());
        return empresaBD;
    }

    private MongoCollection<Administrador> obtenerColeccion(MongoDatabase baseDatos) {
        MongoCollection<Administrador> coleccion = baseDatos.getCollection(NOMBRE_COLECCION, Administrador.class);
        return coleccion;
    }

    @Override
    public Administrador buscarPorPinYContrasenia(String pin, String contrasenia) throws PersistenciaException {
        try(MongoClient cliente = ManejadorConexiones.crearConexion()){
            MongoDatabase empresaDB = this.obtenerBaseDatos(cliente);
            
            MongoCollection<Administrador> coleccion = this.obtenerColeccion(empresaDB);
            
            Document filtro = new Document("pin",pin).append("contrasenia", contrasenia);
            
            Administrador admin = coleccion.find(filtro).first();
            return admin;
        }
    }
        
    
}
