/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import Entidades.*;

/**
 *
 * @author santi
 */
public class editarClienteDTO {
    
    int id;
    String nombres;
    String aPaterno;
    String aMaterno;

    public editarClienteDTO() {
    }

    public editarClienteDTO(int id, String nombres, String aPaterno, String aMaterno) {
        this.id = id;
        this.nombres = nombres;
        this.aPaterno = aPaterno;
        this.aMaterno = aMaterno;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getaPaterno() {
        return aPaterno;
    }

    public void setaPaterno(String aPaterno) {
        this.aPaterno = aPaterno;
    }

    public String getaMaterno() {
        return aMaterno;
    }

    public void setaMaterno(String aMaterno) {
        this.aMaterno = aMaterno;
    }

    @Override
    public String toString() {
        return "editarClienteDTO{" + " nombres=" + nombres + ", aPaterno=" + aPaterno + ", aMaterno=" + aMaterno + '}';
    }    
    
}
