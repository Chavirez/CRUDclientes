/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

/**
 *
 * @author santi
 */
public class clienteDTO {
    
    int id;
    String nombres;
    String aPaterno;
    String aMaterno;
    int estatus;

    public clienteDTO() {
    }

    public clienteDTO(int id, String nombres, String aPaterno, String aMaterno, int eliminado) {
        this.id = id;
        this.nombres = nombres;
        this.aPaterno = aPaterno;
        this.aMaterno = aMaterno;
        this.estatus = eliminado;
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

    public void setNombres(String nombre) {
        this.nombres = nombre;
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
        return "clienteEntidad{" + "id=" + id + ", nombre=" + nombres + ", aPaterno=" + aPaterno + ", aMaterno=" + aMaterno + ", estatus=" + estatus + '}';
    }
        
    
}
