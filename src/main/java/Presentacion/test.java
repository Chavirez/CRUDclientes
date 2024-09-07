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
            
            guardarClienteDTO cl = new guardarClienteDTO("Romina", "Meza", "Galindo");
            
            c.guardarCliente( cl);
        } catch (PersistenciaException ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
