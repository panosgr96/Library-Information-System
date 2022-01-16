/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_universitylibrary_db;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class SelectCopiesBook extends PopUpJpanel {

    private String _returnValue ="";
    public String getSelectValue(){
        return _returnValue;
    }
    public SelectCopiesBook() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        GridCopies = new javax.swing.JTable();

        addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                formAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jButton1.setText("Επιλογή");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        GridCopies.setAutoCreateRowSorter(true);
        jScrollPane1.setViewportView(GridCopies);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int row = this.GridCopies.getSelectedRow();
        if (row < 0 ){return ;}      
        DefaultTableModel model = (DefaultTableModel) this.GridCopies.getModel();
        _returnValue = model.getValueAt(row,0).toString();
        this.getPopupWin().actionPerformed(evt);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_formAncestorAdded
        FetchAuthor();
    }//GEN-LAST:event_formAncestorAdded

       private void FetchAuthor(){
       try{
            String[] ColumnNames   = new String[]{ "α/α Αντιγράφου" ,"Διαθέσιμο"};
            String sql = "SELECT COPYID,case WHEN FREEFLAG =0 then 'Ναι' ELSE 'Οχι' end as FREE_FLAG FROM copies where ISBN = ? and FREEFLAG =0 ";
            String[] parameter = new String[] {this.getPKValue()};
            this.GridCopies.setModel(ConnectDb.DbDefaultTableModel(ColumnNames, sql, parameter));
            GridCopies.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
                @Override
                public void valueChanged(ListSelectionEvent event) {
                    if ( getAction()  ==  FormActionType.Select)
                    {
                        _returnValue = GridCopies.getValueAt(GridCopies.getSelectedRow(),0).toString();
                    }
                }
            });    
            this.GridCopies.setRowSelectionInterval(0,0);
            this.GridCopies.getColumnModel().getColumn(1).setMinWidth(80);
            this.GridCopies.getColumnModel().getColumn(1).setMaxWidth(80);
            this.GridCopies.getColumnModel().getColumn(1).setWidth(80);
         }
        catch(DataException ex )
        {
            String mes = ex.getMessage()+"\n"+ex.getCause().getMessage(); 
            MsgBox.error(mes,ex.getMessage());
        }
    }
 
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable GridCopies;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
