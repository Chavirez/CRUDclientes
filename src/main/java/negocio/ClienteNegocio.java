/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import Entidades.clienteEntidad;
import Persistencia.ClientesDAO;
import Persistencia.ConexionBD;
import Persistencia.PersistenciaException;
import java.util.List;

/**
 *
 * @author PC
 */
public class ClienteNegocio {

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
    public List<clienteEntidad> obtenerClientes() throws PersistenciaException {
        return clientesDAO.buscarClientes();
    }
}
