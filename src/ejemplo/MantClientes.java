package ejemplo;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MantClientes extends javax.swing.JFrame {

    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    ResultSet rstabla = null;
    DefaultTableModel m = null;
    boolean nuevoRegistro = false;
    long total = 1;
    long posicion = 0;
    inicio pantallainicial=null;
    /**
     * Creates new form MantClientes
     *
     * @param c
     */
    public MantClientes(Connection c,inicio padre) {
        initComponents();
        creaConexion(c);
        redimensionar();
        this.pantallainicial=padre;

    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnPrime = new javax.swing.JButton();
        btnAnt = new javax.swing.JButton();
        btnUltim = new javax.swing.JButton();
        btnSig = new javax.swing.JButton();
        lblTot = new javax.swing.JLabel();
        btnOk = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        lblReg = new javax.swing.JLabel();
        lbrgactual = new javax.swing.JLabel();
        lbtotal = new javax.swing.JLabel();
        jbtablaclientes = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        tfId = new javax.swing.JTextField();
        tfNombre = new javax.swing.JTextField();
        tfDireccion = new javax.swing.JTextField();
        jLabeNombre = new javax.swing.JLabel();
        jLabelDireccion = new javax.swing.JLabel();
        jLabelId = new javax.swing.JLabel();
        btnNuevo = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setTitle("Ficha Clientes");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnPrime.setText("|<");
        btnPrime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrimeActionPerformed(evt);
            }
        });

        btnAnt.setText("<<");
        btnAnt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAntActionPerformed(evt);
            }
        });

        btnUltim.setText(">|");
        btnUltim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUltimActionPerformed(evt);
            }
        });

        btnSig.setText(">>");
        btnSig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSigActionPerformed(evt);
            }
        });

        lblTot.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTot.setText("Tot. registros");
        lblTot.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btnOk.setText("ACEPTAR");
        btnOk.setEnabled(false);
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancelar");
        btnCancel.setEnabled(false);
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        lblReg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblReg.setText("Reg. actual");
        lblReg.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lbrgactual.setText("jLabel2");

        lbtotal.setText("jLabel2");

        jbtablaclientes.setText("Modo Tabla");
        jbtablaclientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtablaclientesActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                    .add(btnOk, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(btnPrime, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 80, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(18, 18, 18)
                        .add(btnAnt, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 80, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(lblTot, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                    .add(lblReg, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .add(18, 18, 18)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(lbrgactual)
                    .add(lbtotal))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 37, Short.MAX_VALUE)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(jbtablaclientes, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(btnSig, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 80, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(18, 18, 18)
                        .add(btnUltim, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 80, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(btnCancel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnPrime)
                    .add(btnAnt)
                    .add(btnUltim)
                    .add(btnSig)
                    .add(lblReg, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(lbrgactual))
                .add(25, 25, 25)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnOk, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(btnCancel)
                    .add(lblTot, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(lbtotal))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jbtablaclientes)
                .addContainerGap())
        );

        tfId.setEnabled(false);

        tfNombre.setEnabled(false);

        tfDireccion.setEnabled(false);
        tfDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfDireccionKeyReleased(evt);
            }
        });

        jLabeNombre.setText("Nombre");

        jLabelDireccion.setText("Dirección");

        jLabelId.setText("Identificador");
        jLabelId.setName("jLabel_id"); // NOI18N

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        btnEdit.setText("Editar");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel5Layout = new org.jdesktop.layout.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabeNombre, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jPanel5Layout.createSequentialGroup()
                        .add(jLabelDireccion, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 105, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(0, 0, Short.MAX_VALUE))
                    .add(jLabelId, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, tfNombre, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, tfId)
                    .add(tfDireccion))
                .add(16, 16, 16)
                .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(btnNuevo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 120, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(btnBorrar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 120, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(btnEdit, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 120, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel5Layout.createSequentialGroup()
                .add(19, 19, 19)
                .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(tfId, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 25, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(jLabelId, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 25, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(btnNuevo)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(tfNombre, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 25, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabeNombre, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 25, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(btnBorrar))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabelDireccion, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 25, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(tfDireccion, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 25, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(btnEdit)))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jPanel5, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setBackground(new java.awt.Color(204, 204, 255));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MANTENIMIENTO CLIENTES");
        jLabel1.setOpaque(true);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(layout.createSequentialGroup()
                        .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(18, 18, 18)
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            rs.close();
            stmt.close();
            this.setVisible(false);
            pantallainicial.setVisible(true);
        } catch (SQLException e) {
            mostrarError(e.getMessage());
        }
    }//GEN-LAST:event_formWindowClosing

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        try {
            if (hayRegistros()) {
                nuevoRegistro = false;
                botoneraEdicionActivada(false);
                botoneraNavegacionActivada(false);
                tfNombre.requestFocus();
                tfNombre.setEnabled(true);
                tfDireccion.setEnabled(true);
                botoneraAccionActivada(true);
            }
        } catch (SQLException ex) {
            mostrarError(ex.getMessage());
        }

    }//GEN-LAST:event_btnEditActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        try {
            if (hayRegistros()) {
                String[] buttons = {"Si", "No"};

                int rc = JOptionPane.showOptionDialog(null, "Realmente desea borrar el registro con ID = [" + rs.getLong(1) + "]?",
                        "Confirmation", JOptionPane.WARNING_MESSAGE, 0, null, buttons, buttons[1]);

                if (rc == 0) {
                    //borramos_el_Registro; 
                    System.out.println("reg actual a borrar" + rs.getRow());
                    rs.deleteRow();
                    if (rs.isBeforeFirst()) {
                        rs.first();
                    }
                    lbrgactual.setText(String.valueOf(rs.getRow()));
                    total = total - 1;
                    lbtotal.setText(String.valueOf(total));
                    //else rs.absolute(r);         
                    mostrarDatos(rs);
                }
            }
        } catch (SQLException e) {
            mostrarError(e.getMessage());
        }

    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        nuevoRegistro = true;
        try {
            rs.moveToInsertRow();

            tfNombre.setText("");
            tfDireccion.setText("");

            botoneraEdicionActivada(false);
            botoneraNavegacionActivada(false);
            tfNombre.requestFocus();
            tfNombre.setEnabled(true);
            tfDireccion.setEnabled(true);
            botoneraAccionActivada(true);

        } catch (SQLException e) {
            mostrarError(e.getMessage());
        }
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        try {
            rs.cancelRowUpdates(); //  cancelamos_las_modificaciones;

            tfNombre.setEnabled(false);
            tfDireccion.setEnabled(false);
            nuevoRegistro = false;
            lbrgactual.setText(String.valueOf(rs.getRow()));

            botoneraAccionActivada(false);
            botoneraNavegacionActivada(true);
            botoneraEdicionActivada(true);
            rs.first();
            mostrarDatos(rs);

        } catch (SQLException e) {
            mostrarError(e.getMessage());
        }

    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        try {
            // actualizamos_el_campo_nombre_con_el_valor_del_componente_jTextFieldNombre;
            rs.updateString(2, tfNombre.getText());
            // actualizamos_el_campo_direccion_con_el_valor_del_componente_jTextFieldDireccion;
            rs.updateString(3, tfDireccion.getText());
            if (nuevoRegistro) {
                // La accion viene por nuevo registro: insertamos_la_fila;
                rs.insertRow();
                // nos_movemos_al_ultimo_Registro;
                rs.last();
                total = rs.getRow();
                lbtotal.setText(String.valueOf(total));

                tfNombre.setEnabled(false);
                tfDireccion.setEnabled(false);
                btnBorrar.setEnabled(true);
                btnEdit.setEnabled(true);

            } else {
                //La accion viene por modificacion : actualizamos_el_registro;
                rs.updateRow();
                btnNuevo.setEnabled(true);
                btnBorrar.setEnabled(true);
            }
            nuevoRegistro = false;
            botoneraAccionActivada(false);
            botoneraNavegacionActivada(true);
            botoneraEdicionActivada(true);
            tfNombre.setEnabled(false);
            tfDireccion.setEnabled(false);

            mostrarDatos(rs);

        } catch (SQLException e) {
            mostrarError(e.getMessage());
        }
    }//GEN-LAST:event_btnOkActionPerformed

    private void btnSigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSigActionPerformed
        try {
            rs.next();
            mostrarDatos(rs);

            lbrgactual.setText(String.valueOf(rs.getRow()));
        } catch (SQLException e) {
            mostrarError(e.getMessage());
        }
    }//GEN-LAST:event_btnSigActionPerformed

    private void btnUltimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUltimActionPerformed
        try {
            rs.last();
            mostrarDatos(rs);
            lbrgactual.setText(String.valueOf(rs.getRow()));

        } catch (SQLException e) {
            mostrarError(e.getMessage());
        }
    }//GEN-LAST:event_btnUltimActionPerformed

    private void btnAntActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAntActionPerformed
        try {
            rs.previous();
            mostrarDatos(rs);
            lbrgactual.setText(String.valueOf(rs.getRow()));
        } catch (SQLException e) {
            mostrarError(e.getMessage());
        }
    }//GEN-LAST:event_btnAntActionPerformed

    private void btnPrimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrimeActionPerformed
        try {
            rs.first();
            mostrarDatos(rs);
            lbrgactual.setText(String.valueOf(rs.getRow()));
        } catch (SQLException e) {
            mostrarError(e.getMessage());
        }
    }//GEN-LAST:event_btnPrimeActionPerformed

    private void tfDireccionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfDireccionKeyReleased
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            btnOk.doClick();
        }
    }//GEN-LAST:event_tfDireccionKeyReleased

    private void jbtablaclientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtablaclientesActionPerformed
        try {

            String sql = "SELECT *,sum(lineas_factura.importe)as totalffac FROM facturas inner join lineas_factura on facturas.id=lineas_factura.factura where cliente='" + tfId.getText() + "' group by id";
            rstabla = stmt.executeQuery(sql);

            new tabla_clientes(this, true, rstabla).setVisible(true);
            sql = "select * from clientes";
            rs = stmt.executeQuery(sql);
            rs.first();
            mostrarDatos(rs);
            lbrgactual.setText(String.valueOf(rs.getRow()));
        } catch (SQLException ex) {
            Logger.getLogger(MantClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbtablaclientesActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnt;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnOk;
    private javax.swing.JButton btnPrime;
    private javax.swing.JButton btnSig;
    private javax.swing.JButton btnUltim;
    private javax.swing.JLabel jLabeNombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelDireccion;
    private javax.swing.JLabel jLabelId;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JButton jbtablaclientes;
    private javax.swing.JLabel lblReg;
    private javax.swing.JLabel lblTot;
    private javax.swing.JLabel lbrgactual;
    private javax.swing.JLabel lbtotal;
    private javax.swing.JTextField tfDireccion;
    private javax.swing.JTextField tfId;
    private javax.swing.JTextField tfNombre;
    // End of variables declaration//GEN-END:variables

    private void creaConexion(Connection c) {
        try {
            stmt = c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "select * from clientes";
            rs = stmt.executeQuery(sql);
            System.out.println(rs);
            if (rs.first()) {
                mostrarDatos(rs);
                rs.last();
                total = rs.getRow();
                lbtotal.setText(String.valueOf(total));
                rs.first();
                lbrgactual.setText(String.valueOf(rs.getRow()));
            }

        } catch (SQLException sqle) {
            mostrarError(sqle.getMessage());
        }
    }

    private void botoneraNavegacionActivada(boolean estado) {
        btnPrime.setEnabled(estado);
        btnAnt.setEnabled(estado);
        btnSig.setEnabled(estado);
        btnUltim.setEnabled(estado);
    }

    private void botoneraAccionActivada(boolean estado) {
        btnOk.setEnabled(estado);
        btnCancel.setEnabled(estado);
    }

    private void botoneraEdicionActivada(boolean estado) {
        btnNuevo.setEnabled(estado);
        btnBorrar.setEnabled(estado);
        btnEdit.setEnabled(estado);
    }

    private void mostrarDatos(ResultSet rs) throws SQLException {
        System.out.println("Mostrando..." + rs.getRow());
        if (rs.getRow() > 0) {
            tfId.setText(rs.getLong(1) + "");
            tfNombre.setText(rs.getString(2));
            tfDireccion.setText(rs.getString(3));
        } else {
            tfId.setText("");
            tfNombre.setText("");
            tfDireccion.setText("");
        }
        btnPrime.setEnabled(!rs.isFirst());
        btnAnt.setEnabled(!rs.isFirst());
        btnUltim.setEnabled(!rs.isLast());
        btnSig.setEnabled(!rs.isLast());

    }//end mostrarDatos()    

    private void mostrarError(String msg) {
        System.out.println(msg);
        JOptionPane.showMessageDialog(this, msg, "Error", JOptionPane.ERROR_MESSAGE);
    }

    private boolean hayRegistros() throws SQLException {
        int r = rs.getRow();
        if (!rs.first()) {
            System.out.println("Resultset vacío");
            return false;
        } else {
            System.out.println("Resultset con datos");
            rs.absolute(r);
            return true;
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
