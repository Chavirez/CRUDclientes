/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistencia;

import DTOs.clienteDTO;
import DTOs.editarClienteDTO;
import DTOs.guardarClienteDTO;
import Entidades.clienteEntidad;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author santi
 */
public interface IClientesDAO {
    
    public void guardarCliente(guardarClienteDTO cliente) throws PersistenciaException;

    public void editarCliente(editarClienteDTO cliente) throws PersistenciaException;
    
    public void eliminarCliente(clienteDTO cliente) throws PersistenciaException;

    public List<clienteEntidad> buscarClientes() throws PersistenciaException;

    public clienteEntidad convertirAEntidad(ResultSet resultado) throws PersistenciaException;    
    
}
