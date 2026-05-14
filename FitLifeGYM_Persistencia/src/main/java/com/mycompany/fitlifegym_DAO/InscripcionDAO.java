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
import com.mycompany.fitlifegym_persistencia.entidades.EstadoInscripcion;
import com.mycompany.fitlifegym_persistencia.entidades.Inscripcion;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author PC GAMER MASTER RACE
 */
public class InscripcionDAO implements IInscripcionDAO {
    private static final Logger LOGGER = Logger.getLogger(InscripcionDAO.class.getName());
    private static final String NOMBRE_COLECCION = "inscripciones";

    private MongoDatabase obtenerBaseDatos(MongoClient cliente) {
        MongoDatabase empresaBD = cliente.getDatabase(ManejadorConexiones.BASE_DATOS).withCodecRegistry(obtenerCodecs());
        return empresaBD;
    }

    private MongoCollection<Inscripcion> obtenerColeccion(MongoDatabase baseDatos) {
        MongoCollection<Inscripcion> coleccion = baseDatos.getCollection(NOMBRE_COLECCION, Inscripcion.class);
        return coleccion;
    }
    
    @Override
    public List<Inscripcion> obtenerTodas() throws PersistenciaException {
        try (MongoClient cliente = ManejadorConexiones.crearConexion()) {

            MongoDatabase empresaBD = this.obtenerBaseDatos(cliente);

            MongoCollection<Inscripcion> coleccion = this.obtenerColeccion(empresaBD);

            List<Inscripcion> inscripciones = new LinkedList<>();

            coleccion.find().into(inscripciones);

            return inscripciones;
        }catch (MongoException ex) {
            LOGGER.severe(ex.getMessage());
            throw new PersistenciaException("No se pudieron consultar las inscripciones");
        }
    }

    @Override
    public Inscripcion obtenerPorId(String idInscripcion) throws PersistenciaException {
        try (MongoClient cliente = ManejadorConexiones.crearConexion()) {

            MongoDatabase empresaBD = this.obtenerBaseDatos(cliente);

            MongoCollection<Inscripcion> coleccion = this.obtenerColeccion(empresaBD);

            Document filtro = new Document("_id", new ObjectId(idInscripcion));

            Inscripcion inscripcion = coleccion.find(filtro).first();

            return inscripcion;
        }catch (MongoException ex) {
            LOGGER.severe(ex.getMessage());
            throw new PersistenciaException("No se pudo consultar la inscripción: " + idInscripcion);
        }
    }

    @Override
    public Inscripcion guardar(Inscripcion inscripcion) throws PersistenciaException {
        try (MongoClient cliente = ManejadorConexiones.crearConexion()) {

            MongoDatabase empresaBD = this.obtenerBaseDatos(cliente);

            MongoCollection<Inscripcion> coleccion = this.obtenerColeccion(empresaBD);

            InsertOneResult resultado = coleccion.insertOne(inscripcion);
            if (!resultado.wasAcknowledged()) {
                throw new PersistenciaException("No se pudo guardar la inscripción");
            }

            return inscripcion;
        }catch (MongoException ex) {
            LOGGER.severe(ex.getMessage());
            throw new PersistenciaException("No se pudo guardar la inscripción");
        }
    }

    @Override
    public Inscripcion actualizar(Inscripcion inscripcion) throws PersistenciaException {
        try (MongoClient cliente = ManejadorConexiones.crearConexion()) {

            MongoDatabase empresaBD = this.obtenerBaseDatos(cliente);

            MongoCollection<Inscripcion> coleccion = this.obtenerColeccion(empresaBD);

            Document filtro = new Document("_id", new ObjectId(inscripcion.getIdInscripcion()));

            UpdateResult resultado = coleccion.replaceOne(filtro, inscripcion);

            if (resultado.getModifiedCount() == 0) {
                throw new PersistenciaException("No se pudo actualizar la inscripción");
            }

            return inscripcion;
        }catch (MongoException ex) {
            LOGGER.severe(ex.getMessage());
            throw new PersistenciaException("No se pudo actualizar la inscripción");
        }
    }

    @Override
    public Integer contarTotales() throws PersistenciaException {
        try (MongoClient cliente = ManejadorConexiones.crearConexion()) {

            MongoDatabase empresaBD = this.obtenerBaseDatos(cliente);

            MongoCollection<Inscripcion> coleccion = this.obtenerColeccion(empresaBD);

            return (int) coleccion.countDocuments();
        }catch (MongoException ex) {
            LOGGER.severe(ex.getMessage());
            throw new PersistenciaException("No se pudieron contar las inscripciones");
        }
    }

    @Override
    public Integer contarPorHorario(String idHorario) throws PersistenciaException {
        try (MongoClient cliente = ManejadorConexiones.crearConexion()) {

            MongoDatabase empresaBD = this.obtenerBaseDatos(cliente);

            MongoCollection<Inscripcion> coleccion = this.obtenerColeccion(empresaBD);

            Document filtro = new Document().append("idHorario", new ObjectId(idHorario)).append("estado", EstadoInscripcion.ACTIVA.name());

            return (int) coleccion.countDocuments(filtro);
        }catch (MongoException ex) {
            LOGGER.severe(ex.getMessage());
            throw new PersistenciaException("No se pudieron contar las inscripciones por horario");
        }
    }

    @Override
    public List<Inscripcion> obtenerActivasPorHorario(String idHorario) throws PersistenciaException {
        try (MongoClient cliente = ManejadorConexiones.crearConexion()) {

            MongoDatabase empresaBD = this.obtenerBaseDatos(cliente);

            MongoCollection<Inscripcion> coleccion = this.obtenerColeccion(empresaBD);

            Document filtro = new Document()
                    .append("idHorario", new ObjectId(idHorario))
                    .append("estado", EstadoInscripcion.ACTIVA.name());

            List<Inscripcion> inscripciones = new LinkedList<>();

            coleccion.find(filtro).into(inscripciones);

            return inscripciones;
        }catch (MongoException ex) {
            LOGGER.severe(ex.getMessage());
            throw new PersistenciaException("No se pudieron consultar las inscripciones activas");
        }
    }

    @Override
    public List<Inscripcion> obtenerPorCliente(String idCliente) throws PersistenciaException {
        try (MongoClient cliente = ManejadorConexiones.crearConexion()) {

            MongoDatabase empresaBD = this.obtenerBaseDatos(cliente);

            MongoCollection<Inscripcion> coleccion = this.obtenerColeccion(empresaBD);

            Document filtro = new Document("idCliente", new ObjectId(idCliente));

            List<Inscripcion> inscripciones = new LinkedList<>();

            coleccion.find(filtro).into(inscripciones);

            return inscripciones;
        }catch (MongoException ex) {
            LOGGER.severe(ex.getMessage());
            throw new PersistenciaException("No se pudieron consultar las inscripciones del cliente");
        }
    }
    
    
}
