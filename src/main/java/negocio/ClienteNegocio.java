/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import DTOs.*;
import Entidades.clienteEntidad;
import Persistencia.ClientesDAO;
import Persistencia.ConexionBD;
import Persistencia.PersistenciaException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class ClienteNegocio{

    private ClientesDAO clientesDAO;

    /**
     * Constructor que inicializa un objeto clietnesDAO con la conexion a la
     * base de datos.
     */
    public ClienteNegocio() {
        clientesDAO = new ClientesDAO(new ConexionBD());
    }

    /**
     * Metodo realizado para obtener la lista de los clientes de la base de
     * datos.
     *
     * @return lista con los registros de la base de datos
     * @throws PersistenciaException excepcion de tipo Persistencia
     */
    
    public List<clienteDTO> obtenerClientes() throws NegocioException {
        
        try {
            List<clienteEntidad> lista = clientesDAO.buscarClientes();;
            System.out.println(lista.get(0).toString());
            List<clienteDTO> clientes = new ArrayList<>();
            AtomicInteger counter = new AtomicInteger(0);
            lista.forEach(row ->
            {
                try {
                    int index = counter.getAndIncrement();
                    System.out.println(lista.get(index).toString());
                    clientes.add(convertirAclienteDTO(lista.get(index)));
                } catch (PersistenciaException ex) {
                    Logger.getLogger(ClienteNegocio.class.getName()).log(Level.SEVERE, null, ex);
                 }

            });

            return clientes;
        } catch (PersistenciaException ex) {
            Logger.getLogger(ClienteNegocio.class.getName()).log(Level.SEVERE, null, ex);
            throw new NegocioException("Error al convertir la entidad de clientes a DTO");
        }
    }
    
    public List<clienteDTO> obtenerClientesFiltrados(String filtro) throws NegocioException {
        
        try {
            
            List<clienteEntidad> lista = clientesDAO.buscarClientesFiltrados(filtro);;
           
            List<clienteDTO> clientes = new ArrayList<>();
            AtomicInteger counter = new AtomicInteger(0);
            if (lista == null)  {
                 return clientes;}
            else { 
            lista.forEach(row ->
            {
                try {
                    int index = counter.getAndIncrement();
                    System.out.println(lista.get(index).toString());
                    clientes.add(convertirAclienteDTO(lista.get(index)));
                } catch (PersistenciaException ex) {
                    Logger.getLogger(ClienteNegocio.class.getName()).log(Level.SEVERE, null, ex);
                 }

            });

            return clientes;
            
          }  
        } catch (PersistenciaException ex) {
            Logger.getLogger(ClienteNegocio.class.getName()).log(Level.SEVERE, null, ex);
            throw new NegocioException("Error al convertir la entidad de clientes a DTO");
        }
    }    
    
    public void editarCliente(clienteDTO cliente) throws NegocioException{
    
        try {
            clientesDAO.editarCliente(convertirAeditarDTO(cliente));
            
        } catch (PersistenciaException ex) {
            Logger.getLogger(ClienteNegocio.class.getName()).log(Level.SEVERE, null, ex);
                        throw new NegocioException("Error al convertir la DTO de clientes a editarClientesDTO");
        }
    
    }
    
    public void eliminarCliente(clienteDTO cliente) throws NegocioException{
    
        try {
            clientesDAO.eliminarCliente(cliente);
            
        } catch (PersistenciaException ex) {
            Logger.getLogger(ClienteNegocio.class.getName()).log(Level.SEVERE, null, ex);
                        throw new NegocioException("Error eliminar clientes en negocio");
        }
    
    }
        
    
    
    public clienteDTO convertirAclienteDTO(clienteEntidad cliente) throws PersistenciaException {
        int idcliente = cliente.getId();
        String nombres = cliente.getNombres();
        String aPaterno = cliente.getaPaterno();
        String aMaterno = cliente.getaMaterno();
        int estatus = cliente.getEstatus();
        Timestamp fecha = cliente.getFechaRegistro();
        return new clienteDTO(idcliente, nombres, aPaterno, aMaterno, estatus, fecha);
    }
    
    public editarClienteDTO convertirAeditarDTO(clienteDTO cliente) throws PersistenciaException {
        int id = cliente.getId();
        String nombres = cliente.getNombres();
        String aPaterno = cliente.getaPaterno();
        String aMaterno = cliente.getaMaterno();
        return new editarClienteDTO(id, nombres, aPaterno, aMaterno);
    }    

    public guardarClienteDTO convertirAguardarDTO(clienteEntidad cliente) throws PersistenciaException {
        String nombres = cliente.getNombres();
        String aPaterno = cliente.getaPaterno();
        String aMaterno = cliente.getaMaterno();
        return new guardarClienteDTO(nombres, aPaterno, aMaterno);
    }        
}


