/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vesprada
 */
public class tabla_articulos extends javax.swing.JDialog {

    ResultSet rs;

    String titulos[] = {"id", "nombre", "precio", "codigo", "grupo"};
    DefaultTableModel m = new DefaultTableModel(null, titulos);
    String[] articulos = new String[5];
    Connection conn;

    /**
     * Creates new form tabla_articulos
     *
     * @param parent
     * @param modal
     */
    public tabla_articulos(java.awt.Frame parent, boolean modal, ResultSet r, Connection c) {
        super(parent, modal);
        initComponents();
        this.rs = r;

        this.conn = c;
        cargar(rs, 0);
        redimensionar();
        jbfiltrar.setEnabled(false);
        lbinfofiltro.setText("Haz click en un campo para filtrar");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaarticulos = new javax.swing.JTable();
        jbfiltrar = new javax.swing.JToggleButton();
        lbinfofiltro = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tablaarticulos.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaarticulos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaarticulosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaarticulos);

        jbfiltrar.setText("Filtrar");
        jbfiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbfiltrarActionPerformed(evt);
            }
        });

        lbinfofiltro.setText("Filtrar por Columna :       Campo:                                                 ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 658, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jbfiltrar)
                .addGap(18, 18, 18)
                .addComponent(lbinfofiltro)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbfiltrar)
                    .addComponent(lbinfofiltro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbfiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbfiltrarActionPerformed

        if (jbfiltrar.isSelected()) {
            filtrar();
        } else {
            lbinfofiltro.setText("Haz click en un campo para filtrar");
            jbfiltrar.setEnabled(false);
            cargar(rs, 1);
        }

    }//GEN-LAST:event_jbfiltrarActionPerformed

    private void tablaarticulosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaarticulosMouseClicked
        jbfiltrar.setEnabled(true);
        lbinfofiltro.setText("Filtrar por Columna :" + tablaarticulos.getColumnName(tablaarticulos.getSelectedColumn()) + "      Campo:" + tablaarticulos.getValueAt(tablaarticulos.getSelectedRow(), tablaarticulos.getSelectedColumn()));
    }//GEN-LAST:event_tablaarticulosMouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jbfiltrar;
    private javax.swing.JLabel lbinfofiltro;
    private javax.swing.JTable tablaarticulos;
    // End of variables declaration//GEN-END:variables

    private void cargar(ResultSet resultado, int llena) {

        if (llena == 1) {
            limpiar();
        }

        try {
            resultado.beforeFirst();
            while (resultado.next()) {
                articulos[0] = resultado.getString(1);
                articulos[1] = resultado.getString(2);
                articulos[2] = String.valueOf(resultado.getString(3));
                articulos[3] = resultado.getString(4);
                articulos[4] = String.valueOf(resultado.getString(5));
                System.out.println(articulos[0] + articulos[1] + articulos[2] + articulos[3] + articulos[4]);
                m.addRow(articulos);
            }
            tablaarticulos.setModel(m);
        } catch (SQLException ex) {
            Logger.getLogger(tabla_articulos.class.getName()).log(Level.SEVERE, null, ex);
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

    private void filtrar() {
        try {
            String sql = "select * from articulos where " + tablaarticulos.getColumnName(tablaarticulos.getSelectedColumn()) + "='" + tablaarticulos.getValueAt(tablaarticulos.getSelectedRow(), tablaarticulos.getSelectedColumn()) + "'";
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet resultado = stmt.executeQuery(sql);
            System.out.println("va a cargar los datos");

            limpiar();
            cargar(resultado, 1);

            System.out.println("datos cargados");
        } catch (SQLException ex) {
            Logger.getLogger(tabla_articulos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void limpiar() {

        for (int i = 0; i < tablaarticulos.getRowCount(); i++) {
            m.removeRow(i);
            i -= 1;
        }

    }

}
