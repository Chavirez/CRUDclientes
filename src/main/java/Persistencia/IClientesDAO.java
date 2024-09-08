/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistencia;

import Entidades.clienteEntidad;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author santi
 */
public interface IClientesDAO {
    
    public void guardarCliente(clienteEntidad cliente) throws PersistenciaException;

    public void editarCliente(clienteEntidad cliente) throws PersistenciaException;
    
    public void eliminarCliente(clienteEntidad cliente) throws PersistenciaException;

    public List<clienteEntidad> buscarClientes() throws PersistenciaException;

    public clienteEntidad convertirAEntidad(ResultSet resultado) throws PersistenciaException;    
    
}
