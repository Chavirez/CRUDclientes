/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Entidades.guardarClienteDTO;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author santi
 */
public class ClientesDAO {
    
    private IConexionBD conexionBD;

    public ClientesDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
        }    

    public void guardarCliente(guardarClienteDTO cliente) throws PersistenciaException, SQLException {
    
        Connection conexion = this.conexionBD.crearConexion();

        }
    
}
