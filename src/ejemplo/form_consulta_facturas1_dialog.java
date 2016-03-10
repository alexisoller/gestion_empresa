/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo;

import datechooser.beans.DateChooserCombo;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author vesprada
 */
public class form_consulta_facturas1_dialog extends javax.swing.JDialog {

    /**
     * Creates new form form_consulta_facturas1_dialog
     */
    Statement stmt = null;
    ResultSet rs = null;
    Connection conn;
    Calendar c = GregorianCalendar.getInstance();
    Calendar c1 = GregorianCalendar.getInstance();

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    JTextArea consultasql = null;
    Date fechamin, fechamax;
    float desdetotal, hastatotal;
    PreparedStatement sqlprepared;
    String desdetot, hastatot;

    public form_consulta_facturas1_dialog(java.awt.Frame parent, boolean modal, Connection conn, JTextArea jtselect) {
        super(parent, modal);
        consultasql = jtselect;
        initComponents();
        redimensionar();
        this.conn = conn;
        cargarConexion();
        cargarcombos();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jpancriterios = new javax.swing.JPanel();
        lbdesdehastafactura = new javax.swing.JLabel();
        lbdesdehastafecha = new javax.swing.JLabel();
        lbdesdehastaclientes = new javax.swing.JLabel();
        lbdesdehastavendedor = new javax.swing.JLabel();
        lbdesdehastatotal = new javax.swing.JLabel();
        jcbfacmin = new javax.swing.JComboBox();
        jcbfacmax = new javax.swing.JComboBox();
        dtmin = new datechooser.beans.DateChooserCombo();
        dtmax = new datechooser.beans.DateChooserCombo();
        jcbclimin = new javax.swing.JComboBox();
        jcbclimax = new javax.swing.JComboBox();
        jcbvenmin = new javax.swing.JComboBox();
        jcbvenmax = new javax.swing.JComboBox();
        jftfdesdetotal = new javax.swing.JFormattedTextField();
        jftfhastatotal = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        cbformapago = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jbconsulta = new javax.swing.JButton();
        jbreinicio = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setBackground(new java.awt.Color(204, 204, 255));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Criterios de busqueda de Factura");
        jLabel1.setOpaque(true);

        lbdesdehastafactura.setText("Desde/Hasta Factura");

        lbdesdehastafecha.setText("Desde/Hasta Fecha");

        lbdesdehastaclientes.setText("Desde/Hasta Cliente");

        lbdesdehastavendedor.setText("Desde/Hasta Vendedor");

        lbdesdehastatotal.setText("Desde/Hasta Total");

        jftfdesdetotal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getCurrencyInstance())));

        jftfhastatotal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getCurrencyInstance())));

        jLabel2.setText("Forma de pago");

        cbformapago.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Contado", "tarjeta", "transferencia" }));

        jButton1.setText("Info: Formato");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpancriteriosLayout = new javax.swing.GroupLayout(jpancriterios);
        jpancriterios.setLayout(jpancriteriosLayout);
        jpancriteriosLayout.setHorizontalGroup(
            jpancriteriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpancriteriosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpancriteriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpancriteriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lbdesdehastatotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbdesdehastaclientes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbdesdehastafecha, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbdesdehastafactura, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbdesdehastavendedor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE))
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpancriteriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpancriteriosLayout.createSequentialGroup()
                        .addGroup(jpancriteriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cbformapago, javax.swing.GroupLayout.Alignment.LEADING, 0, 225, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpancriteriosLayout.createSequentialGroup()
                                .addGroup(jpancriteriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jftfdesdetotal)
                                    .addComponent(jcbvenmin, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jpancriteriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jftfhastatotal)
                                    .addComponent(jcbvenmax, 0, 175, Short.MAX_VALUE))))
                        .addGap(18, 18, 18)
                        .addComponent(jButton1))
                    .addGroup(jpancriteriosLayout.createSequentialGroup()
                        .addComponent(jcbfacmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jcbfacmax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpancriteriosLayout.createSequentialGroup()
                        .addComponent(dtmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(dtmax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpancriteriosLayout.createSequentialGroup()
                        .addComponent(jcbclimin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jcbclimax, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpancriteriosLayout.setVerticalGroup(
            jpancriteriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpancriteriosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpancriteriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbdesdehastafactura)
                    .addComponent(jcbfacmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbfacmax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpancriteriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpancriteriosLayout.createSequentialGroup()
                        .addGroup(jpancriteriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbdesdehastafecha)
                            .addComponent(dtmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jpancriteriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbdesdehastaclientes)
                            .addComponent(jcbclimin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbclimax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jpancriteriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbdesdehastavendedor)
                            .addComponent(jcbvenmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbvenmax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jpancriteriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbdesdehastatotal)
                            .addComponent(jftfdesdetotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jftfhastatotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1)))
                    .addComponent(dtmax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpancriteriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbformapago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jbconsulta.setText("Consultar");
        jbconsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbconsultaActionPerformed(evt);
            }
        });

        jbreinicio.setText("Reiniciar valores por defecto");
        jbreinicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbreinicioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpancriterios, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 567, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbconsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbreinicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jpancriterios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbconsulta)
                    .addComponent(jbreinicio))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbreinicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbreinicioActionPerformed
        valoresdef();
    }//GEN-LAST:event_jbreinicioActionPerformed

    private void jbconsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbconsultaActionPerformed
//
        if (comprobardatos()) {

            ponerdatossql();
            String s = sqlprepared.toString();
            String[] separado = s.split(" ");
            s = "";
            for (int i = 1; i < separado.length; i++) {

                s = s + " " + separado[i];
            }

            consultasql.setText(s);
            dispose();

        } else {
            JOptionPane.showMessageDialog(this, "DATOS ERRONEOS EN LOS CAMPOS DE FECHA O EN LOS CAMPOS DE TOTAL\n"
                    + "Fecha min =" + fechamin + "\nFecha max =" + fechamax
                    + "\nTotal min =" + desdetotal + "\nTotal max =" + hastatotal, "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jbconsultaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JOptionPane.showMessageDialog(this, "El Formato del campo necesita un entero,dos decimales y el simbolo del euro \n" + "Ejemplo: '1.000,65 \u20AC'");
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    private void cargarcombos() {
        try {
            cargarfecha();
            String sql;

            sql = "select id FROM facturas Order by id";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String gr = String.valueOf(rs.getLong(1));
                jcbfacmin.addItem(gr);
                jcbfacmax.addItem(gr);
            }

            sql = "select id,nombre from clientes";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String gr = rs.getLong(1) + "-" + rs.getString(2);
                jcbclimin.addItem(gr);
                jcbclimax.addItem(gr);
            }

            sql = "select id,nombre from vendedores";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String gr = rs.getLong(1) + "-" + rs.getString(2);
                jcbvenmin.addItem(gr);
                jcbvenmax.addItem(gr);
            }

            sql = "select SUM(importe) from lineas_factura group by factura order by SUM(importe)";
            rs = stmt.executeQuery(sql);
            rs.absolute(1);
            //jttotalmin.setText(String.valueOf(rs.getFloat(1)) + "?");
            jftfdesdetotal.setText(String.valueOf(rs.getFloat(1)));
            jftfdesdetotal.setValue(rs.getFloat(1));
            desdetotal = rs.getFloat(1);
            rs.last();
            //jttotalmax.setText(String.valueOf(rs.getFloat(1)) + "?");
            jftfhastatotal.setText(String.valueOf(rs.getFloat(1)));
            jftfhastatotal.setValue(rs.getFloat(1));

            hastatotal = rs.getFloat(1);
            valoresdef();

        } catch (SQLException ex) {

        }

    }

    private void cargarfecha() throws SQLException {
        String sql = "select fecha FROM facturas Order by fecha";
        rs = stmt.executeQuery(sql);
        rs.absolute(1);
        String fmin = rs.getString(1);
        rs.last();
        String fmax = rs.getString(1);
        Date fecha = null;

        try {
            fecha = sdf.parse(fmin);
            fechamin = sdf.parse(fmin);
            c.setTime(fecha);
            dtmin.setSelectedDate(c);

            fecha = sdf.parse(fmax);
            fechamax = sdf.parse(fmax);
            c1.setTime(fecha);

        } catch (ParseException ex) {
            System.out.println("Formato erróneo de fecha");
        }

    }

    private void cargarConexion() {
        try {

            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            sqlprepared = conn.prepareStatement(""
                    + "select facturas.id,facturas.fecha,facturas.cliente,clientes.nombre,facturas.vendedor,vendedores.nombre,sum(lineas_factura.importe) as total,facturas.formapago "
                    + "from facturas "
                    + "inner join clientes on facturas.cliente=clientes.id "
                    + "inner join vendedores on facturas.vendedor=vendedores.id "
                    + "inner join lineas_factura on facturas.id=lineas_factura.factura "
                    + "where (facturas.id between ? and ?) and "
                    + "(facturas.fecha between ? and ?) and "
                    + "(facturas.cliente between ? and ?) and "
                    + "(facturas.vendedor between ? and ?) and (facturas.formapago like ?) "
                    + "group by facturas.id "
                    + "HAVING (total between ? and ?)");
        } catch (SQLException ex) {

        }

    }

    public void valoresdef() {

        jcbfacmin.setSelectedIndex(0);
        jcbfacmax.setSelectedIndex(jcbfacmax.getItemCount() - 1);

        jcbclimin.setSelectedIndex(0);
        jcbclimax.setSelectedIndex(jcbclimax.getItemCount() - 1);

        jcbvenmin.setSelectedIndex(0);
        jcbvenmax.setSelectedIndex(jcbvenmax.getItemCount() - 1);

        c.setTime(fechamin);
        dtmin.setSelectedDate(c);
        c1.setTime(fechamax);
        dtmax.setSelectedDate(c1);

        jftfdesdetotal.setText(String.valueOf(desdetotal));
        jftfdesdetotal.setValue(desdetotal);
        jftfhastatotal.setText(String.valueOf(hastatotal));
        jftfhastatotal.setValue(hastatotal);

        cbformapago.setSelectedIndex(0);

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbformapago;
    private datechooser.beans.DateChooserCombo dtmax;
    private datechooser.beans.DateChooserCombo dtmin;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton jbconsulta;
    private javax.swing.JButton jbreinicio;
    private javax.swing.JComboBox jcbclimax;
    private javax.swing.JComboBox jcbclimin;
    private javax.swing.JComboBox jcbfacmax;
    private javax.swing.JComboBox jcbfacmin;
    private javax.swing.JComboBox jcbvenmax;
    private javax.swing.JComboBox jcbvenmin;
    private javax.swing.JFormattedTextField jftfdesdetotal;
    private javax.swing.JFormattedTextField jftfhastatotal;
    private javax.swing.JPanel jpancriterios;
    private javax.swing.JLabel lbdesdehastaclientes;
    private javax.swing.JLabel lbdesdehastafactura;
    private javax.swing.JLabel lbdesdehastafecha;
    private javax.swing.JLabel lbdesdehastatotal;
    private javax.swing.JLabel lbdesdehastavendedor;
    // End of variables declaration//GEN-END:variables

    private boolean comprobardatos() {
        c = dtmin.getCurrent();
        c1 = dtmax.getCurrent();
        int compfecha1 = c.getTime().compareTo(fechamin), compfecha2 = c1.getTime().compareTo(fechamax);
        boolean fmi = false, fma = false;
        
        desdetot = remplazar(jftfdesdetotal);
        hastatot = remplazar(jftfhastatotal);
        if (compfecha1 >= 0) {
            fmi = true;
        }
        if (compfecha2 <= 0) {
            fma = true;
        }
       
        if ((Float.parseFloat(desdetot) >= desdetotal)
                && (Float.parseFloat(hastatot) <= hastatotal)
                && fma == true
                && fmi == true) {

            return true;//falta las fechas

        } else {

            return false;
        }

    }

    private void redimensionar() {
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int ancho = 2 * d.width / 3;
        int alto = d.height / 2;
        this.setLocationRelativeTo(this);
        d = Toolkit.getDefaultToolkit().getScreenSize();
        ancho = 2 * d.width / 4;
        alto = d.height / 4;
        this.setMaximumSize(new Dimension(ancho, alto));
        this.setMinimumSize(new Dimension(ancho, alto));
        this.pack();
    }

    private String remplazar(JFormattedTextField jFo) {
        String caracteres = jFo.getText();
        caracteres = caracteres.replace(".", "");
        caracteres = caracteres.replace(",", ".");
        caracteres = caracteres.replace("\u20AC", "");
        return caracteres;
    }

    private void ponerdatossql() {
        try {

            sqlprepared.setInt(1, Integer.parseInt(String.valueOf(jcbfacmin.getSelectedItem())));
            sqlprepared.setInt(2, Integer.parseInt(String.valueOf(jcbfacmax.getSelectedItem())));

            sqlprepared.setString(3, formatear(dtmin));
            sqlprepared.setString(4, formatear(dtmax));

            sqlprepared.setInt(5, retornaridcb(String.valueOf(jcbclimin.getSelectedItem())));
            sqlprepared.setInt(6, retornaridcb(String.valueOf(jcbclimax.getSelectedItem())));

            sqlprepared.setInt(7, retornaridcb(String.valueOf(jcbvenmin.getSelectedItem())));
            sqlprepared.setInt(8, retornaridcb(String.valueOf(jcbvenmax.getSelectedItem())));

            sqlprepared.setFloat(10, Float.parseFloat(desdetot));
            sqlprepared.setFloat(11, Float.parseFloat(hastatot));

            sqlprepared.setString(9, (String) cbformapago.getSelectedItem());

        } catch (SQLException ex) {
            Logger.getLogger(form_consulta_facturas1_dialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Integer retornaridcb(String separar) {
        String[] iddesc = null;

        iddesc = separar.split("-");

        return Integer.parseInt(iddesc[0]);

    }

    private Date formatearfecha(DateChooserCombo dcc) {
        Date f = dcc.getCurrent().getTime();
        try {
            f = sdf.parse(sdf.format(f));
        } catch (ParseException ex) {
            Logger.getLogger(form_consulta_facturas1_dialog.class.getName()).log(Level.SEVERE, null, ex);
        }
        return f;
    }

    private String formatear(DateChooserCombo dcc) {
        Date f = dcc.getCurrent().getTime();

        return sdf.format(f);
    }
}
