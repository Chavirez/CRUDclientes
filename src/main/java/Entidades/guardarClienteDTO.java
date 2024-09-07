/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author santi
 */
public class guardarClienteDTO {
    
    String nombres;
    String aPaterno;
    String aMaterno;

    public guardarClienteDTO() {
    }

    public guardarClienteDTO(String nombres, String aPaterno, String aMaterno) {
        this.nombres = nombres;
        this.aPaterno = aPaterno;
        this.aMaterno = aMaterno;
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
        return "guardarClienteDTO{" + "nombres=" + nombres + ", aPaterno=" + aPaterno + ", aMaterno=" + aMaterno + '}';
    }
    
    
    
}
