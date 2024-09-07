/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Entidades.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
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

    public void guardarCliente(clienteEntidad cliente) throws PersistenciaException{
        try{
                        
            Connection conexion = this.conexionBD.crearConexion();
            
            String codigoSQL = "INSERT INTO clientes (nombres, apellidoPaterno, apellidoMaterno) \n" +
                                "VALUES\n" +
                                "(?,?,?)";
            PreparedStatement preparedStatement = conexion.prepareStatement(codigoSQL);
            preparedStatement.setString(1, cliente.getNombres());
            preparedStatement.setString(2, cliente.getaPaterno());
            preparedStatement.setString(3, cliente.getaMaterno());
            preparedStatement.execute();
            conexion.close();
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new PersistenciaException("Ocurrió un error al Insertar la base de datos, inténtelo de nuevo y si el error persiste comuníquese con el encargado del sistema."); 
        };}
    
    public void editarCliente(clienteEntidad cliente) throws PersistenciaException{
        try{
                        
            Connection conexion = this.conexionBD.crearConexion();
            
            String codigoSQL = "UPDATE clientes \n" +
                            "SET\n" +
                            "nombres = ?,\n" +
                            "apellidoPaterno = ?,\n" +
                            "apellidoMaterno = ?,\n" +
                            "estaEliminado = ?\n" +
                            "WHERE idcliente = ?;";
            PreparedStatement preparedStatement = conexion.prepareStatement(codigoSQL);
            preparedStatement.setString(1, cliente.getNombres());
            preparedStatement.setString(2, cliente.getaPaterno());
            preparedStatement.setString(3, cliente.getaMaterno());
            preparedStatement.setInt(4, cliente.getEstatus());
            preparedStatement.setInt(5, cliente.getId());
            preparedStatement.execute();
            conexion.close();
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new PersistenciaException("Ocurrió un error al editar la base de datos, inténtelo de nuevo y si el error persiste comuníquese con el encargado del sistema."); 
        };}
    
    public void eliminarCliente(clienteEntidad cliente) throws PersistenciaException{
        try{
                        
            Connection conexion = this.conexionBD.crearConexion();
            
            String codigoSQL = "UPDATE clientes \n" +
                            "SET\n" +
                            "estaEliminado = 1\n" +
                            "WHERE idcliente = ?;";
            PreparedStatement preparedStatement = conexion.prepareStatement(codigoSQL);
            preparedStatement.setInt(1, cliente.getId());
            preparedStatement.execute();
            conexion.close();
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new PersistenciaException("Ocurrió un error al eliminar el cliente en la base de datos, inténtelo de nuevo y si el error persiste comuníquese con el encargado del sistema."); 
        };}    

    
}
