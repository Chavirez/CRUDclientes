/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

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
    int estatus;

    public editarClienteDTO() {
    }

    public editarClienteDTO(int id, String nombres, String aPaterno, String aMaterno, int estatus) {
        this.id = id;
        this.nombres = nombres;
        this.aPaterno = aPaterno;
        this.aMaterno = aMaterno;
        this.estatus = estatus;
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

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    @Override
    public String toString() {
        return "editarClienteDTO{" + "id=" + id + ", nombres=" + nombres + ", aPaterno=" + aPaterno + ", aMaterno=" + aMaterno + ", estatus=" + estatus + '}';
    }    
    
}
