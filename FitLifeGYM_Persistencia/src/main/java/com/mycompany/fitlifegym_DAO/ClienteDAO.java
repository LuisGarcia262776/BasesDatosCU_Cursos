/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitlifegym_DAO;

import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;
import com.mycompany.fitlifegym_Manejador_Conexiones.ManejadorConexiones;
import static com.mycompany.fitlifegym_Manejador_Conexiones.ManejadorConexiones.obtenerCodecs;
import com.mycompany.fitlifegym_PersistenciaException.PersistenciaException;
import com.mycompany.fitlifegym_persistencia.entidades.Cliente;
import com.mycompany.fitlifegym_persistencia.entidades.Estado;
import com.mycompany.fitlifegym_persistencia.entidades.Membresia;
import com.mycompany.fitlifegym_persistencia.entidades.MembresiaComprada;
import com.mycompany.fitlifegym_persistencia.entidades.TipoMembresia;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 * Clase DAO encargada de gestionar
 * las operaciones de persistencia
 * relacionadas con los clientes.
 * 
 * Permite registrar, consultar
 * y actualizar clientes dentro
 * de la base de datos MongoDB.
 * 
 * @author PC GAMER MASTER RACE
 */
public class ClienteDAO implements IClientesDAO{
    
    /**
     * Logger utilizado para registrar
     * eventos y errores del DAO.
     */
    private static final Logger LOGGER = Logger.getLogger(ClienteDAO.class.getName());
    
    /**
     * Nombre de la colección
     * de clientes en MongoDB.
     */
    private static final String NOMBRE_COLECCION = "clientes";

    /**
     * Obtiene la base de datos configurada
     * para el sistema.
     * 
     * @param cliente Cliente de MongoDB.
     * @return Base de datos utilizada por el sistema.
     */
    private MongoDatabase obtenerBaseDatos(MongoClient cliente) {
        MongoDatabase empresaBD = cliente.getDatabase(ManejadorConexiones.BASE_DATOS).withCodecRegistry(obtenerCodecs());
        return empresaBD;
    }

    /**
     * Obtiene la colección de clientes.
     * 
     * @param baseDatos Base de datos utilizada.
     * @return Colección de clientes.
     */
    private MongoCollection<Cliente> obtenerColeccion(MongoDatabase baseDatos) {
        MongoCollection<Cliente> coleccion = baseDatos.getCollection(NOMBRE_COLECCION, Cliente.class);
        return coleccion;
    }

    /**
     * Registra un nuevo cliente
     * dentro de la base de datos.
     * 
     * @param cliente Cliente a registrar.
     * @return Cliente registrado.
     * @throws PersistenciaException Se lanza cuando ocurre
     * un error durante el registro.
     */
    @Override
    public Cliente registrarCliente(Cliente cliente) throws PersistenciaException {
        try (MongoClient mongo = ManejadorConexiones.crearConexion()) {

            MongoDatabase empresaBD = this.obtenerBaseDatos(mongo);

            MongoCollection<Cliente> coleccion = this.obtenerColeccion(empresaBD);

            InsertOneResult resultado = coleccion.insertOne(cliente);
            
            if (!resultado.wasAcknowledged()) {
                throw new PersistenciaException("No se pudo registrar el cliente");
            }

            return cliente;
            
        }catch (MongoException ex) {
            LOGGER.severe(ex.getMessage());
            throw new PersistenciaException("No se pudo registrar el cliente");
        }
    }

    /**
     * Consulta un cliente mediante su ID.
     * 
     * @param id ID del cliente.
     * @return Cliente encontrado o null
     * si no existe.
     * @throws PersistenciaException Se lanza cuando ocurre
     * un error durante la consulta.
     */
    @Override
    public Cliente consultarClientePorId(String id) throws PersistenciaException {
        try (MongoClient mongo = ManejadorConexiones.crearConexion()) {

            MongoDatabase empresaBD = this.obtenerBaseDatos(mongo);

            MongoCollection<Cliente> coleccion = this.obtenerColeccion(empresaBD);

            Document filtro = new Document("_id", new ObjectId(id));

            Cliente cliente = coleccion.find(filtro).first();

            return cliente;
            
        }catch (MongoException ex) {
            LOGGER.severe(ex.getMessage());
            throw new PersistenciaException("No se pudo consultar el cliente: " + id);
        }
    }

    /**
     * Consulta todos los clientes registrados.
     * 
     * @return Lista de clientes.
     * @throws PersistenciaException Se lanza cuando ocurre
     * un error durante la consulta.
     */
    @Override
    public List<Cliente> consultarClientes() throws PersistenciaException {
        try (MongoClient mongo = ManejadorConexiones.crearConexion()) {

            MongoDatabase empresaBD = this.obtenerBaseDatos(mongo);

            MongoCollection<Cliente> coleccion = this.obtenerColeccion(empresaBD);

            List<Cliente> clientes = new LinkedList<>();

            coleccion.find().into(clientes);

            return clientes;
            
        }catch (MongoException ex) {
            LOGGER.severe(ex.getMessage());
            throw new PersistenciaException("No se pudieron consultar los clientes");
        }
    }

    /**
     * Busca un cliente mediante su PIN.
     * 
     * @param pin PIN del cliente.
     * @return Cliente encontrado o null
     * si no existe.
     * @throws PersistenciaException Se lanza cuando ocurre
     * un error durante la consulta.
     */
    @Override
    public Cliente buscarPorPin(String pin) throws PersistenciaException {
        try (MongoClient mongo = ManejadorConexiones.crearConexion()) {

            MongoDatabase empresaBD = this.obtenerBaseDatos(mongo);

            MongoCollection<Cliente> coleccion = this.obtenerColeccion(empresaBD);

            Document filtro = new Document("pin", pin);

            Cliente cliente = coleccion.find(filtro).first();

            return cliente;
            
        }catch (MongoException ex) {
            LOGGER.severe(ex.getMessage());
            throw new PersistenciaException("No se pudo consultar el cliente por PIN");
        }
    }

    /**
     * Actualiza la membresía de un cliente.
     * 
     * @param idCliente ID del cliente.
     * @param nuevaMembresia Nueva membresía del cliente.
     * @return Cliente actualizado.
     * @throws PersistenciaException Se lanza cuando ocurre
     * un error durante la actualización.
     */
    @Override
    public Cliente actualizarMembresia(String idCliente, TipoMembresia nuevaMembresia) throws PersistenciaException {
        try (MongoClient mongo = ManejadorConexiones.crearConexion()) {

            MongoDatabase empresaBD = this.obtenerBaseDatos(mongo);

            MongoCollection<Cliente> coleccion = this.obtenerColeccion(empresaBD);

            double precio;
            
            if (nuevaMembresia == TipoMembresia.ORO) {
                precio = 750.0;
            } else if (nuevaMembresia == TipoMembresia.PLATA) {
                precio = 500.0;
            } else {
                precio = 300.0;
            }

            MembresiaComprada nuevaCompra = new MembresiaComprada(new Membresia(nuevaMembresia, precio), LocalDate.now(), LocalDate.now().plusMonths(1), precio, Estado.ACTIVO);

            Document filtro = new Document("_id", new ObjectId(idCliente));

            Cliente clienteExistente = coleccion.find(filtro).first();
            
            if (clienteExistente == null) {
                throw new PersistenciaException("No se encontró el cliente con ID " + idCliente);
            }

            clienteExistente.setMembresiaComprada(nuevaCompra);

            UpdateResult resultado = coleccion.replaceOne(filtro, clienteExistente);

            if (resultado.getModifiedCount() == 0) {
                throw new PersistenciaException("No se pudo actualizar la membresía");
            }
            
            return clienteExistente;

        }catch (MongoException ex) {
            LOGGER.severe(ex.getMessage());
            throw new PersistenciaException("No se pudo actualizar la membresía");
        }
    }
    
    
}

    
    
