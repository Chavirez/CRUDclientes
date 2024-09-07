/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Presentacion;

/**
 *
 * @author santi
 */

import Persistencia.*;
import Entidades.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            ConexionBD a = new ConexionBD();
            
            ClientesDAO c = new ClientesDAO(a);
            
            clienteEntidad cl = new clienteEntidad(2, "Romina", "Meza", "Galindo", 1);
            
//            c.guardarCliente( cl);
//            c.editarCliente( cl);
            c.eliminarCliente( cl);
        } catch (PersistenciaException ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        
    }
    
}
