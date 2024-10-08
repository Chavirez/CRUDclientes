/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import DTOs.clienteDTO;
import DTOs.editarClienteDTO;
import DTOs.guardarClienteDTO;
import Entidades.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author santi
 */
public class ClientesDAO implements IClientesDAO {

    private IConexionBD conexionBD;

    /**
     * Constructor por omision
     */
    // utilce este constructor para llamar esta clase en ClienteNegocio del paquete negocio - Sebas
    public ClientesDAO() {

    }

    public ClientesDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    @Override
    public void guardarCliente(guardarClienteDTO cliente) throws PersistenciaException {
        try {
            Connection conexion = this.conexionBD.crearConexion();

            String codigoSQL = "INSERT INTO clientes (nombres, apellidoPaterno, apellidoMaterno) \n"
                    + "VALUES\n"
                    + "(?,?,?)";
            PreparedStatement preparedStatement = conexion.prepareStatement(codigoSQL);
            preparedStatement.setString(1, cliente.getNombres());
            preparedStatement.setString(2, cliente.getaPaterno());
            preparedStatement.setString(3, cliente.getaMaterno());
            preparedStatement.execute();
            conexion.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new PersistenciaException("Ocurrió un error al Insertar la base de datos, inténtelo de nuevo y si el error persiste comuníquese con el encargado del sistema.");
        };
    }

    @Override
    public void editarCliente(editarClienteDTO cliente) throws PersistenciaException {
        try {

            Connection conexion = this.conexionBD.crearConexion();

            String codigoSQL = """
                               UPDATE clientes
                               SET
                                nombres = ?,
                                apellidoPaterno = ?,
                                apellidoMaterno = ?
                               WHERE idcliente = ?;
                               """;
            PreparedStatement preparedStatement = conexion.prepareStatement(codigoSQL);
            preparedStatement.setString(1, cliente.getNombres());
            preparedStatement.setString(2, cliente.getaPaterno());
            preparedStatement.setString(3, cliente.getaMaterno());
            preparedStatement.setInt(4, cliente.getId());
            preparedStatement.execute();
            conexion.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new PersistenciaException("Ocurrió un error al editar la base de datos, inténtelo de nuevo y si el error persiste comuníquese con el encargado del sistema.");
        };
    }

    @Override
    public void eliminarCliente(clienteDTO cliente) throws PersistenciaException {
        try {

            Connection conexion = this.conexionBD.crearConexion();

            String codigoSQL = "UPDATE clientes \n"
                    + "SET\n"
                    + "estaEliminado = 1\n"
                    + "WHERE idcliente = ?;";
            PreparedStatement preparedStatement = conexion.prepareStatement(codigoSQL);
            preparedStatement.setInt(1, cliente.getId());
            preparedStatement.execute();
            conexion.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new PersistenciaException("Ocurrió un error al eliminar el cliente en la base de datos, inténtelo de nuevo y si el error persiste comuníquese con el encargado del sistema.");
        };
    }

    public List<clienteEntidad> buscarClientes() throws PersistenciaException {

        try {

            List<clienteEntidad> clienteLista = null;

            Connection conexion = this.conexionBD.crearConexion();

            String codigoSQL = "select idcliente, nombres, apellidoPaterno, apellidoMaterno, estaEliminado, fechaHoraRegistro from clientes;";
            PreparedStatement preparedStatement = conexion.prepareStatement(codigoSQL);
            ResultSet resultado = preparedStatement.executeQuery();

            while (resultado.next()) {
                if (clienteLista == null) {
                    clienteLista = new ArrayList<>();
                }
                clienteEntidad cliente = this.convertirAEntidad(resultado);
                clienteLista.add(cliente);
            }
            conexion.close();
            return clienteLista;

        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Ocurrió un error al leer la base de datos, inténtelo de nuevo y si el error persiste comuníquese con el encargado del sistema.");
        }

    }

    @Override
    public List<clienteEntidad> buscarClientesFiltrados(String filtro) throws PersistenciaException {

        try {

            List<clienteEntidad> clienteLista = null;

            filtro = filtro + "%";
            
            Connection conexion = this.conexionBD.crearConexion();

            String codigoSQL = "select idcliente, nombres, apellidoPaterno, apellidoMaterno, estaEliminado, fechaHoraRegistro from clientes"
                    + " where nombres like ? or apellidoPaterno like ?  or apellidoMaterno like ?  ";

            PreparedStatement preparedStatement = conexion.prepareStatement(codigoSQL);
            preparedStatement.setString(1, filtro);
            preparedStatement.setString(2, filtro);
            preparedStatement.setString(3, filtro);
            ResultSet resultado = preparedStatement.executeQuery();

            while (resultado.next()) {
                if (clienteLista == null) {
                    clienteLista = new ArrayList<>();
                }
                clienteEntidad cliente = this.convertirAEntidad(resultado);
                clienteLista.add(cliente);
            }
            conexion.close();
            return clienteLista;

        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Ocurrió un error al leer la base de datos, inténtelo de nuevo y si el error persiste comuníquese con el encargado del sistema.");
        }

    }

    @Override
    public clienteEntidad convertirAEntidad(ResultSet resultado) throws PersistenciaException {
        try {
            int idcliente = resultado.getInt("idcliente");
            String nombres = resultado.getString("nombres");
            String aPaterno = resultado.getString("apellidoPaterno");
            String aMaterno = resultado.getString("apellidoMaterno");
            int estatus = resultado.getInt("estaEliminado");
            Timestamp fecha = resultado.getTimestamp("fechaHoraRegistro");
            return new clienteEntidad(idcliente, nombres, aPaterno, aMaterno, estatus, fecha);
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Error al convertir los resultados a entidad");
        }
    }

}
