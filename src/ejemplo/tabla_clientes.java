/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alexis
 */
public class tabla_clientes extends javax.swing.JDialog {  
    
    
    public tabla_clientes(java.awt.Frame parent, boolean modal) throws SQLException {
        super(parent, modal);
        initComponents();
    }

    public tabla_clientes(java.awt.Frame parent, boolean modal, ResultSet g) throws SQLException {
        super(parent, modal);
        initComponents();
        cargadatos(g);
        tablaclientes.setEnabled(false); 
        redimensionar();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaclientes = new javax.swing.JTable();
        lbtotal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tablaclientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablaclientes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 940, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbtotal, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbtotal;
    private javax.swing.JTable tablaclientes;
    // End of variables declaration//GEN-END:variables

    private void cargadatos(ResultSet g) {
        try {
            String titulos[] = {"id", "fecha", "cliente", "vendedor", "formapago", "linea", "factura", "articulo", "cantidad", "importe", "totalfac"};
            DefaultTableModel m = new DefaultTableModel(null, titulos);
            String[] fila = new String[11];
            g.beforeFirst();
            double total = 0;
            while (g.next()) {

                fila[0] = g.getString("id");
                fila[1] = g.getString("fecha");
                fila[2] = g.getString("cliente");
                fila[3] = g.getString("vendedor");
                fila[4] = g.getString("formapago");
                fila[5] = g.getString("linea");
                fila[6] = g.getString("factura");
                fila[7] = g.getString("articulo");
                fila[8] = g.getString("cantidad");
                fila[9] = g.getString("importe");
                fila[10] = g.getString(9);
                total = total + Integer.parseInt(fila[10]);//calculando el total de todas las facturas
                m.addRow(fila);
            }
            lbtotal.setText("TOTAL: " + String.valueOf(total)+"€");
            this.tablaclientes.setModel(m);//poniendo los datos en la vista de la tabla
        } catch (SQLException ex) {
            Logger.getLogger(tabla_clientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   private void redimensionar() {
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int ancho = 2 * d.width / 3;
        int alto = d.height / 2;
        this.setLocationRelativeTo(this);
        d = Toolkit.getDefaultToolkit().getScreenSize();
        ancho = 2 * d.width / 6;
        alto = d.height / 4;
        this.setMaximumSize(new Dimension(ancho, alto));
        this.setMinimumSize(new Dimension(ancho, alto));
        this.pack();
    }
}
