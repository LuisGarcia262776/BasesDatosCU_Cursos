/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.fitlifegym_presentacion;

/**
 * Clase principal
 * encargada de iniciar
 * la aplicación FitLifeGYM.
 * 
 * @author Diego
 */
public class FitLifeGYM_Presentacion {

    /**
    * Método principal
    * que inicia
    * la ejecución
    * del sistema.
    * 
    * @param args Argumentos
    * de línea de comandos.
    */
    public static void main(String[] args) {
        ControlNavegacion control = new ControlNavegacion();
        
        control.navegarMenuPrincipal();
    }
}
