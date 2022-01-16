/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_universitylibrary_db;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Panagiotis
 */

public class CustomerUPD extends PopUpJpanel {

    /**
     * Creates new form CustomerUPD
     */
  
    public CustomerUPD() {
        initComponents();
        AddToDropDown();
        this.TXTCUSTOMERSID.setEditable(false);        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SaveButton = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TXTCUSTOMERSID = new javax.swing.JTextField();
        TXTNAME = new javax.swing.JTextField();
        CanselButton = new javax.swing.JToggleButton();
        DRBrands = new javax.swing.JComboBox();
        CategoryButton = new javax.swing.JToggleButton();

        addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                formAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        SaveButton.setText("Save");
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("A/A :");

        jLabel2.setText("Κατηγορία :");

        jLabel3.setText("Ονοματεπώνυμο :");

        CanselButton.setText("Cansel");
        CanselButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CanselButtonActionPerformed(evt);
            }
        });

        CategoryButton.setText("Κατηγορίες");
        CategoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CategoryButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TXTCUSTOMERSID, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DRBrands, 0, 271, Short.MAX_VALUE)
                            .addComponent(TXTNAME))
                        .addContainerGap(20, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(CategoryButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(SaveButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CanselButton)
                        .addGap(20, 20, 20))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TXTCUSTOMERSID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TXTNAME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DRBrands, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SaveButton)
                    .addComponent(CanselButton)
                    .addComponent(CategoryButton))
                .addContainerGap(23, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed
       CoboBoxItem itm =(CoboBoxItem)this.DRBrands.getSelectedItem();
       if (this.getAction() == PopUpJpanel.FormActionType.Insert)
       {
         ConnectDb con = new ConnectDb();
          String sql ="insert into CUSTOMERS (NAME, BRANDSID) ";
                 sql+= "VALUES ('"+this.TXTNAME.getText()+"',"+itm.getValue().trim()+")";
            try{
                con.UpdateQuery(sql);
                con.Close();
            }
            catch(DataException ex )
            {
                String mes = ex.getMessage()+"\n"+ex.getCause().getMessage(); 
                MsgBox.error(mes,ex.getMessage());
            }                 
        }
       if (this.getAction() == PopUpJpanel.FormActionType.Update)
       {
         ConnectDb con = new ConnectDb();
          String sql ="UPDATE CUSTOMERS SET NAME ='"+this.TXTNAME.getText()+"',"; 
                 sql += "BRANDSID = "+ itm.getValue().trim()+ " WHERE CUSTOMERSID = "+this.TXTCUSTOMERSID.getText();
            try{
                con.UpdateQuery(sql);
                con.Close();
            }
            catch(DataException ex )
            {
                String mes = ex.getMessage()+"\n"+ex.getCause().getMessage(); 
                MsgBox.error(mes,ex.getMessage());
            }                 
        }
       if (this.getAction() == PopUpJpanel.FormActionType.Delete)
       {
         ConnectDb con = new ConnectDb();
          String sql ="DELETE FROM CUSTOMERS WHERE CUSTOMERSID = "+this.TXTCUSTOMERSID.getText();
            try{
                con.UpdateQuery(sql);
                con.Close();
            }
            catch(DataException ex )
            {
                String mes = ex.getMessage()+"\n"+ex.getCause().getMessage(); 
                MsgBox.error(mes,ex.getMessage());
            }                 
        }
        this.getPopupWin().actionPerformed(evt);
    }//GEN-LAST:event_SaveButtonActionPerformed

    private void CanselButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CanselButtonActionPerformed
        this.getPopupWin().actionPerformed(evt);
    }//GEN-LAST:event_CanselButtonActionPerformed

    private void formAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_formAncestorAdded
        this.TXTCUSTOMERSID.setText(this.getPKValue());
             ConnectDb con = new ConnectDb();
        String sql = "SELECT CUSTOMERSID, NAME, BRANDSID FROM customers WHERE CUSTOMERSID = ?";
        String[] parameter = new String[1];
        parameter[0] = this.getPKValue();
        try{
            ResultSet rs =  con.ExecuteQuery(sql,parameter);
            while(rs.next()){
              this.TXTNAME.setText(rs.getString("NAME"));
              for (int i=0;i <this.DRBrands.getItemCount(); i++)
              {
                 if (Integer.parseInt(((CoboBoxItem)this.DRBrands.getItemAt(i)).getValue()) == Integer.parseInt(rs.getString("BRANDSID").toString()))
                 {
                    this.DRBrands.setSelectedIndex(i);
                     break;
                 }
              }
            }
            con.Close();
        }
        catch(DataException |SQLException  ex )
        {
            String mes = ex.getMessage()+"\n"+ex.getCause().getMessage(); 
            MsgBox.error(mes,ex.getMessage());
        }   
        if (this.getAction() == PopUpJpanel.FormActionType.Delete)
       {
          this.TXTNAME.setEditable(false);
          this.DRBrands.setEditable(false);
       }
    }//GEN-LAST:event_formAncestorAdded

    private void CategoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CategoryButtonActionPerformed
        Brands cat = new Brands();
        cat.setAction(PopUpJpanel.FormActionType.Display);
        PopUpMondalWindow ppp = new PopUpMondalWindow(this,"Κατηγορία",cat);
        ppp.setSize(250, 200);
        AddToDropDown();
        
    }//GEN-LAST:event_CategoryButtonActionPerformed

    private void AddToDropDown(){
        ConnectDb con = new ConnectDb();
        String sql = "SELECT * FROM BRANDS";
        try{
            ResultSet rs =  con.ExecuteQuery(sql);
            this.DRBrands.removeAllItems();
            while(rs.next()){
                this.DRBrands.addItem(new CoboBoxItem(rs.getString("BRANDSID"), rs.getString("NAME")));
            }
            con.Close();
        }
        catch(DataException |SQLException  ex )
        {
            String mes = ex.getMessage()+"\n"+ex.getCause().getMessage(); 
            
            MsgBox.error(mes,ex.getMessage());
        }
    }
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton CanselButton;
    private javax.swing.JToggleButton CategoryButton;
    private javax.swing.JComboBox DRBrands;
    private javax.swing.JToggleButton SaveButton;
    private javax.swing.JTextField TXTCUSTOMERSID;
    private javax.swing.JTextField TXTNAME;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
