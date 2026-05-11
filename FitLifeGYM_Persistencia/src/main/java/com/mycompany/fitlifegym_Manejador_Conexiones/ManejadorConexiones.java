/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitlifegym_Manejador_Conexiones;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.bson.codecs.configuration.CodecProvider;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

/**
 *
 * @author PC GAMER MASTER RACE
 */
public class ManejadorConexiones {
    public static final String CADENA_CONEXION = "mongodb://localhost:27017";
    public static final String BASE_DATOS = "fitlifegym";

    public static MongoClient crearConexion() {
        MongoClient client = MongoClients.create(CADENA_CONEXION);
        return client;
    }

    public static CodecRegistry obtenerCodecs() {
        // Esto nos genera un Proveedor de codecs
        CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
        // Generar un registro de codecs(default + pojo)
        CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));
        return pojoCodecRegistry;
    }
}
    
