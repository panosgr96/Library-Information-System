/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_universitylibrary_db;

import javax.swing.table.DefaultTableModel;

public class CopiesBook extends PopUpJpanel {

    /**
     * Creates new form Category
     */
    
    public CopiesBook() {
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

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        GridCopies = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        DeleteButtom = new javax.swing.JButton();

        addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                formAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jButton1.setText("Exit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        GridCopies.setAutoCreateRowSorter(true);
        jScrollPane1.setViewportView(GridCopies);

        jButton3.setText("Εισαγωγή");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        DeleteButtom.setText("Διαγραφή");
        DeleteButtom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtomActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DeleteButtom)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DeleteButtom)
                    .addComponent(jButton1)
                    .addComponent(jButton3))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       this.getPopupWin().actionPerformed(evt);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_formAncestorAdded
        FetchAuthor();
    }//GEN-LAST:event_formAncestorAdded

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String sql ="insert into copies (ISBN,FREEFLAG) VALUES ("+this.getPKValue()+",0)";
        try{
            ConnectDb con = new ConnectDb();
            con.UpdateQuery(sql);
            con.Close();
            FetchAuthor();
        }
        catch(DataException ex )
        {
            String mes = ex.getMessage()+"\n"+ex.getCause().getMessage();
            MsgBox.error(mes,ex.getMessage());
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void DeleteButtomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtomActionPerformed
        int row = this.GridCopies.getSelectedRow();
        if (row < 0 ) {return;}
        DefaultTableModel model = (DefaultTableModel) this.GridCopies.getModel();
        String sql ="DELETE FROM copies WHERE ISBN = "+this.getPKValue() +" and COPYID = "+model.getValueAt(row,0).toString();
        try{
            ConnectDb con = new ConnectDb();
            con.UpdateQuery(sql);
            con.Close();
            FetchAuthor();
        }
        catch(DataException ex )
        {
            String mes = ex.getMessage()+"\n"+ex.getCause().getMessage();
            MsgBox.error(mes,ex.getMessage());
        }      
    }//GEN-LAST:event_DeleteButtomActionPerformed

       private void FetchAuthor(){
       try{
            String[] ColumnNames   = new String[]{ "α/α Αντιγράφου" ,"Διαθέσιμο"};
            String sql = "SELECT COPYID,case WHEN FREEFLAG =0 then 'Ναι' ELSE 'Οχι' end as FREE_FLAG FROM copies where ISBN = ? ";
            String[] parameter = new String[] {this.getPKValue()};
            this.GridCopies.setModel(ConnectDb.DbDefaultTableModel(ColumnNames, sql, parameter));
            this.GridCopies.setRowSelectionInterval(0,0);
            this.GridCopies.getColumnModel().getColumn(1).setMinWidth(80);
            this.GridCopies.getColumnModel().getColumn(1).setMaxWidth(60);
            this.GridCopies.getColumnModel().getColumn(1).setWidth(60);
         }
        catch(DataException ex )
        {
            String mes = ex.getMessage()+"\n"+ex.getCause().getMessage(); 
            MsgBox.error(mes,ex.getMessage());
        }
    }
 
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DeleteButtom;
    private javax.swing.JTable GridCopies;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}