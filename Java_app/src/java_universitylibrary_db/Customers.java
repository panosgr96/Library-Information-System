/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_universitylibrary_db;

import java.awt.Component;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JFrame;
import javax.swing.JDialog;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Customers extends javax.swing.JInternalFrame {

    private boolean _selectrow = false;
    private String _returnValue ="";
    public void setSelectedButton(boolean Select)
    {
      this.Btselect.setEnabled(Select);
      this.Btselect.setVisible(Select); 
      this._selectrow = Select;
    }
    
    public String getSelectValue(){
        return _returnValue;
    }
    
    public Customers() {
        initComponents();
        this.Btselect.setEnabled(false);
        this.Btselect.setVisible(false);
        FetchCustomerToTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        TxtName = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCustomers = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButCheng = new javax.swing.JButton();
        DeleteButtom = new javax.swing.JButton();
        Btselect = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Δικαιούμενοι δανεισμού βιβλίων");
        setToolTipText("Δικαιούμενοι δανεισμού βιβλίων");

        jLabel1.setText("Όνομα :");

        jButton2.setText("Αναζήτηση");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTableCustomers.setAutoCreateRowSorter(true);
        jScrollPane1.setViewportView(jTableCustomers);

        jButton3.setText("Εισαγωγή");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButCheng.setText("Διόρθωση");
        jButCheng.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButChengActionPerformed(evt);
            }
        });

        DeleteButtom.setText("Διαγραφή");
        DeleteButtom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtomActionPerformed(evt);
            }
        });

        Btselect.setText("Επιλογή");
        Btselect.setEnabled(false);
        Btselect.setMargin(new java.awt.Insets(2, 5, 2, 5));
        Btselect.setMaximumSize(new java.awt.Dimension(70, 50));
        Btselect.setMinimumSize(new java.awt.Dimension(70, 50));
        Btselect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtselectActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtName, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButCheng)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DeleteButtom)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addComponent(Btselect, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Btselect, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(TxtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2)
                        .addComponent(jButton3)
                        .addComponent(jButCheng)
                        .addComponent(DeleteButtom)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {Btselect, DeleteButtom});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DeleteButtomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtomActionPerformed

        int row = this.jTableCustomers.getSelectedRow();
         if (row <0) {return;}
        DefaultTableModel model = (DefaultTableModel) this.jTableCustomers.getModel();
        CustomerUPD upd = new CustomerUPD();
        upd.setPKValue( model.getValueAt(row,0).toString());
        upd.setAction(PopUpJpanel.FormActionType.Delete);
        PopUpMondalWindow ppp = new PopUpMondalWindow(this,"Προσθήκη Δικαιούμενου δανεισμού",upd);
        ppp.setSize(250, 200);
        FetchCustomerToTable();

        // TODO add your handling code here:
    }//GEN-LAST:event_DeleteButtomActionPerformed

    private void jButChengActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButChengActionPerformed
        int row = this.jTableCustomers.getSelectedRow();
        if (row <0) {return;}
        DefaultTableModel model = (DefaultTableModel) this.jTableCustomers.getModel();
        CustomerUPD upd = new CustomerUPD();
        upd.setPKValue( model.getValueAt(row,0).toString());
        upd.setAction(PopUpJpanel.FormActionType.Update);
        PopUpMondalWindow ppp = new PopUpMondalWindow(this,"Προσθήκη Δικαιούμενου δανεισμού",upd);
        ppp.setSize(250, 200);
        FetchCustomerToTable();
    }//GEN-LAST:event_jButChengActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        CustomerUPD upd = new CustomerUPD();
        upd.setAction(PopUpJpanel.FormActionType.Insert);
        PopUpMondalWindow ppp = new PopUpMondalWindow(this,"Προσθήκη Δικαιούμενου δανεισμού",upd);
        ppp.setSize(250, 200);
        FetchCustomerToTable();

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        FetchCustomerToTable();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void BtselectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtselectActionPerformed
      try{
        PopUpJInternalFrame.getPopUpJInternalF(this).actionPerformed(evt);
     }
     catch(Exception ex ){
     }
    }//GEN-LAST:event_BtselectActionPerformed

    
    
    private void FetchCustomerToTable(){
       try{
            String[] ColumnNames   = new String[]{ "α/α", "Ονσματεπωνυμο","Κατηγορια"};

            String sql = "SELECT CUSTOMERS.CUSTOMERSID, CUSTOMERS.NAME, BRANDS.NAME AS BRAND\n" +
                        "FROM CUSTOMERS INNER JOIN \n" +
                        "	BRANDS ON BRANDS.BRANDSID = CUSTOMERS.BRANDSID\n" +
                        "where UPPER(CUSTOMERS.NAME) like ? ";
            
            String[] parameter = new String[] {"%"+this.TxtName.getText().toUpperCase().trim()+ "%" };
            
            this.jTableCustomers.setModel(ConnectDb.DbDefaultTableModel(ColumnNames, sql, parameter));
            this.jTableCustomers.setRowSelectionInterval(0,0);
            jTableCustomers.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
                @Override
                public void valueChanged(ListSelectionEvent event) {
                    if (_selectrow && jTableCustomers.getSelectedRow()>=0)
                    {
                        _returnValue = jTableCustomers.getValueAt(jTableCustomers.getSelectedRow(),0).toString();
                    }
                }
            });
            
            
         }
        catch(DataException ex )
        {
            String mes = ex.getMessage()+"\n"+ex.getCause().getMessage(); 
            MsgBox.error(mes,ex.getMessage());
        }
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btselect;
    private javax.swing.JButton DeleteButtom;
    private javax.swing.JTextField TxtName;
    private javax.swing.JButton jButCheng;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableCustomers;
    // End of variables declaration//GEN-END:variables
}
