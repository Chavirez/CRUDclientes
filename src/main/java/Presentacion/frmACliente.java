/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Presentacion;

import DTOs.guardarClienteDTO;
import Persistencia.ClientesDAO;
import Persistencia.ConexionBD;
import javax.swing.JOptionPane;

/**
 *
 * @author santi
 */
public class frmACliente extends javax.swing.JFrame {

    /**
     * Creates new form frmACliente
     */
    public frmACliente() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTituloVentana = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        lblNombres = new javax.swing.JLabel();
        txtAPaterno = new javax.swing.JTextField();
        lblAPaterno = new javax.swing.JLabel();
        txtAMaterno = new javax.swing.JTextField();
        lblAMaterno = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        lblTituloVentana.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTituloVentana.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTituloVentana.setText("Agregar Cliente");

        lblNombres.setText("Nombre(s)");

        lblAPaterno.setText("Apellido Paterno");

        lblAMaterno.setText("Apellido Materno");

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 216, Short.MAX_VALUE)
                        .addComponent(btnAceptar))
                    .addComponent(lblTituloVentana, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblAMaterno, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAPaterno, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombres, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAPaterno, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAMaterno, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombres, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblTituloVentana, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNombres)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblAPaterno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblAMaterno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar))
                .addGap(20, 20, 20))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.txtNombres.setText("");
        this.txtAPaterno.setText("");
        this.txtAMaterno.setText("");
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed

        String nombres = txtNombres.getText();
        String apellidoPaterno = txtAPaterno.getText();
        String apellidoMaterno = txtAMaterno.getText();

        try {
            //guardarClienteDTO cliente = new guardarClienteDTO(nombres, apellidoPaterno, apellidoMaterno);
            guardarClienteDTO cliente = new guardarClienteDTO();
            cliente.setNombres(nombres);
            cliente.setaPaterno(apellidoPaterno);
            cliente.setaMaterno(apellidoMaterno);

            
            ConexionBD conexion = new ConexionBD();
            ClientesDAO clientesBD = new ClientesDAO(conexion);
            clientesBD.guardarCliente(cliente);

            JOptionPane.showMessageDialog(this, "El cliente " + nombres + " "
                    + apellidoPaterno + " " + apellidoMaterno
                    + " Se ha agregado correctamente.", "Success",
                    JOptionPane.INFORMATION_MESSAGE);
            this.dispose();

        } catch (Exception e) {
            System.out.println(" ERROR ERROR ERROR " + e + " ERROR ERROR ERROR");
            JOptionPane.showMessageDialog(this,
                    "Ocurrio un error al agregar el cliente",
                    "ERROR de logica", JOptionPane.ERROR_MESSAGE);
            this.dispose();
        }
    }//GEN-LAST:event_btnAceptarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel lblAMaterno;
    private javax.swing.JLabel lblAPaterno;
    private javax.swing.JLabel lblNombres;
    private javax.swing.JLabel lblTituloVentana;
    private javax.swing.JTextField txtAMaterno;
    private javax.swing.JTextField txtAPaterno;
    private javax.swing.JTextField txtNombres;
    // End of variables declaration//GEN-END:variables
}
