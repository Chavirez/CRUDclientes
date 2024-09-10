/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import java.sql.Date;
import java.sql.Timestamp;

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
    Timestamp fechaRegistro;

    public clienteDTO() {
    }

    public clienteDTO(int id, String nombres, String aPaterno, String aMaterno, int estatus, Timestamp fechaRegistro) {
        this.id = id;
        this.nombres = nombres;
        this.aPaterno = aPaterno;
        this.aMaterno = aMaterno;
        this.estatus = estatus;
        this.fechaRegistro = fechaRegistro;
    }

    public Timestamp getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Timestamp fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
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
