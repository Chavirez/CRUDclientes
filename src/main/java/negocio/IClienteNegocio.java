/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio;

/**
 *
 * @author PC
 */
public interface IClienteNegocio {

    // Falta agregar la lista de tipo ClienteTablaDTO, ya que aun no contamos con los DTO.
    void guardar(ClienteGuardarDTO cliente) throws NegocioException;

    void modificar(ClienteModificarDTO cliente) throws NegocioException;
}
