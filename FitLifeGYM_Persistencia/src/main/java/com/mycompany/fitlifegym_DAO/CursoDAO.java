/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitlifegym_DAO;

import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;
import com.mycompany.fitlifegym_Manejador_Conexiones.ManejadorConexiones;
import static com.mycompany.fitlifegym_Manejador_Conexiones.ManejadorConexiones.obtenerCodecs;
import com.mycompany.fitlifegym_PersistenciaException.PersistenciaException;
import com.mycompany.fitlifegym_persistencia.entidades.Curso;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author PC GAMER MASTER RACE
 */
public class CursoDAO implements ICursoDAO {
    private static final Logger LOGGER = Logger.getLogger(CursoDAO.class.getName());
    private static final String NOMBRE_COLECCION = "cursos";
    
    private MongoDatabase obtenerBaseDatos(MongoClient cliente) {
        MongoDatabase empresaBD = cliente.getDatabase(ManejadorConexiones.BASE_DATOS).withCodecRegistry(obtenerCodecs());    
        return empresaBD;
    }

    private MongoCollection<Curso> obtenerColeccion(MongoDatabase baseDatos) {
        MongoCollection<Curso> coleccionTrabajadores = baseDatos.getCollection(NOMBRE_COLECCION, Curso.class);
        return coleccionTrabajadores;
    }

    @Override
    public List<Curso> obtenerTodos() throws PersistenciaException {
        try (MongoClient cliente = ManejadorConexiones.crearConexion()) {

            MongoDatabase empresaBD = this.obtenerBaseDatos(cliente);

            MongoCollection<Curso> coleccion = this.obtenerColeccion(empresaBD);

            List<Curso> cursos = new LinkedList<>();

            coleccion.find().into(cursos);

            return cursos;

        } catch (MongoException ex) {
            LOGGER.severe(ex.getMessage());
            throw new PersistenciaException("No se pudieron consultar los cursos");
        }
        
    }

    @Override
    public Curso obtenerPorId(String idCurso) throws PersistenciaException {
        try (MongoClient cliente = ManejadorConexiones.crearConexion()) {

            MongoDatabase empresaBD = this.obtenerBaseDatos(cliente);

            MongoCollection<Curso> coleccion = this.obtenerColeccion(empresaBD);

            Document filtro = new Document("_id", new ObjectId(idCurso));

            Curso curso = coleccion.find(filtro).first();

            return curso;
        } catch (MongoException ex) {
            LOGGER.severe(ex.getMessage());
            throw new PersistenciaException("No se pudo consultar el curso: " + idCurso);
        }
    }

    @Override
    public Curso guardar(Curso curso) throws PersistenciaException {
        try (MongoClient cliente = ManejadorConexiones.crearConexion()) {
            
            MongoDatabase empresaBD = this.obtenerBaseDatos(cliente);
            
            MongoCollection<Curso> coleccion = this.obtenerColeccion(empresaBD);
            
            InsertOneResult resultado = coleccion.insertOne(curso);
            if (!resultado.wasAcknowledged()) {
                throw new PersistenciaException("No se pudo guardar el curso");
            }
            
            return curso;
        } catch (MongoException ex) {
            LOGGER.severe(ex.getMessage());
            throw new PersistenciaException("No se pudo guardar el curso");
        }

    }

    @Override
    public Curso actualizar(Curso curso) throws PersistenciaException {
        try (MongoClient cliente = ManejadorConexiones.crearConexion()) {

            MongoDatabase empresaBD = this.obtenerBaseDatos(cliente);

            MongoCollection<Curso> coleccion = this.obtenerColeccion(empresaBD);

            Document filtro = new Document("_id", new ObjectId(curso.getIdCurso()));

            UpdateResult resultado = coleccion.replaceOne(filtro, curso);

            if (resultado.getModifiedCount() == 0) {
                throw new PersistenciaException("No se pudo actualizar el curso");
            }

            return curso;

        } catch(MongoException ex) {
            LOGGER.severe(ex.getMessage());
            throw new PersistenciaException("No se pudo actualizar el curso");
        }
    }

    @Override
    public boolean eliminar(String idCurso) throws PersistenciaException {
        try (MongoClient cliente = ManejadorConexiones.crearConexion()) {

            MongoDatabase empresaBD = this.obtenerBaseDatos(cliente);

            MongoCollection<Curso> coleccion = this.obtenerColeccion(empresaBD);

            Document filtro = new Document("_id",new ObjectId(idCurso));

            DeleteResult resultado = coleccion.deleteOne(filtro);

            return resultado.getDeletedCount() > 0;

        } catch (MongoException ex) {
            LOGGER.severe(ex.getMessage());
            throw new PersistenciaException("No se pudo eliminar el curso");
        }
    }
    
}
