/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Presentacion;

import DTOs.clienteDTO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import negocio.ClienteNegocio;
import utilerias.JButtonCellEditor;
import utilerias.JButtonRenderer;

/**
 *
 * @author PC
 */
public class FrmCrud extends javax.swing.JFrame {

    /**
     * Creates new form FrmCrud
     */
    public FrmCrud() {
        clienteNegocio = new ClienteNegocio();
        
        initComponents();
        setSize(1500, 600);
        configurarTabla();
        cargarDatosBD();

        //actualizarTimerBD();
    }
    
    public void cargarDatosBD() {
        try {
            List<clienteDTO> listaClientes = clienteNegocio.obtenerClientes();
            listaClientes.get(0).toString();
            for (clienteDTO cliente : listaClientes) {
                modeloTabla.addRow(new Object[]{
                    cliente.getId(),
                    cliente.getNombres(),
                    cliente.getaPaterno(),
                    cliente.getaMaterno(),
                    cliente.getEstatus() == 1 ? "Eliminado" : "Activo",
                    cliente.getFechaRegistro()
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar los datos: " + e.getMessage());
        }
    }
    
    public void cargarDatosBDFiltrado() {
        try {
            modeloTabla.setRowCount(0);
            List<clienteDTO> listaClientes = clienteNegocio.obtenerClientesFiltrados(fldFiltro.getText());
            if (listaClientes.isEmpty()){
            return;
            }
            else { 
            listaClientes.get(0).toString();
            for (clienteDTO cliente : listaClientes) {
                modeloTabla.addRow(new Object[]{
                    cliente.getId(),
                    cliente.getNombres(),
                    cliente.getaPaterno(),
                    cliente.getaMaterno(),
                    cliente.getEstatus() == 1 ? "Eliminado" : "Activo",
                    cliente.getFechaRegistro()
                });
            }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar los datos: " + e.getMessage());
        }
    }    

    public void configurarTabla() {
        
                fldFiltro.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                onTextChanged();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                onTextChanged();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                onTextChanged();
            }

            // Método que se llama cada vez que se escribe o elimina un carácter
            private void onTextChanged() {
                cargarDatosBDFiltrado();
            }
        });    
        
        // Configura el modelo de la tabla
        modeloTabla = (DefaultTableModel) tabClientes.getModel();
        
        ActionListener onEditarClickListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
              editarAP();
                
            }               
        };
            
        TableColumnModel modeloColumnas = this.tabClientes.getColumnModel();
        modeloColumnas.getColumn(6).setCellRenderer(new JButtonRenderer("Editar"));
        modeloColumnas.getColumn(6).setCellEditor(new JButtonCellEditor("Editar",onEditarClickListener));
        
        ActionListener onEliminarClickListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
              eliminarAP();
                
            }               
        };
            
        
        modeloColumnas.getColumn(7).setCellRenderer(new JButtonRenderer("Eliminar"));
        modeloColumnas.getColumn(7).setCellEditor(new JButtonCellEditor("Eliminar",onEliminarClickListener));        
        
    }

    public void actualizarTimerBD() {
        if (temporizador != null) {
            temporizador.stop();
        }

        temporizador = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    cargarDatosBD();
                } catch (Exception ex) {
                    System.out.println(ex);
                }

            }
        });

        temporizador.start();

    }

    public void editarAP(){
    
        FrmEditarCliente editarCliente = new FrmEditarCliente();
        editarCliente.setVisible(true);
        this.dispose();
        
    }
    
    public void eliminarAP(){
    
        FrmEliminarCliente eliminarCliente = new FrmEliminarCliente();
        eliminarCliente.setVisible(true);
        this.dispose();
        
    }
    

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tblRegistros = new javax.swing.JScrollPane();
        tabClientes = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        txtTituloVentana = new javax.swing.JLabel();
        fldFiltro = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Listado de Clietnes");
        setResizable(false);

        tabClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "ID", "Nombres", "Apellido Paterno", "Apellido Materno", "Estatus", "Fecha Registro", "Editar", "Eliminar"
            }
        ));
        tblRegistros.setViewportView(tabClientes);

        btnAgregar.setText("Agregar Cliente");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        txtTituloVentana.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtTituloVentana.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTituloVentana.setText("Tabla de Clientes");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(fldFiltro)
                    .addComponent(txtTituloVentana, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tblRegistros, javax.swing.GroupLayout.DEFAULT_SIZE, 972, Short.MAX_VALUE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(txtTituloVentana, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(fldFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tblRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAgregar)
                .addGap(13, 13, 13))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        frmACliente agregarCliente = new frmACliente();
        agregarCliente.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAgregarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmCrud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCrud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCrud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCrud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCrud().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JTextField fldFiltro;
    private javax.swing.JTable tabClientes;
    private javax.swing.JScrollPane tblRegistros;
    private javax.swing.JLabel txtTituloVentana;
    // End of variables declaration//GEN-END:variables
    private DefaultTableModel modeloTabla;
    private ClienteNegocio clienteNegocio;
    private Timer temporizador;
}
