package java_universitylibrary_db;
import java.sql.ResultSet;
import java.sql.SQLException;
public class CategoryUPD extends PopUpJpanel {
    public CategoryUPD() {
        initComponents();
        this.TXTCATEGORYID.setEditable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SaveButton = new javax.swing.JToggleButton();
        CanselButton = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TXTCATEGORYID = new javax.swing.JTextField();
        TXTNAME = new javax.swing.JTextField();

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

        CanselButton.setText("Cansel");
        CanselButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CanselButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("A/A :");

        jLabel3.setText("Κατηγορία :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(SaveButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CanselButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(TXTCATEGORYID, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 158, Short.MAX_VALUE))
                            .addComponent(TXTNAME))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TXTCATEGORYID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TXTNAME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SaveButton)
                    .addComponent(CanselButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed
        if (this.getAction() == PopUpJpanel.FormActionType.Insert)
        {
            ConnectDb con = new ConnectDb();
            String sql ="insert into CATEGORIES ( NAME ) VALUES ('"+this.TXTNAME.getText()+"')";
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
            String sql ="UPDATE CATEGORIES SET NAME ='"+this.TXTNAME.getText()+"' WHERE CATEGORYID = "+this.TXTCATEGORYID.getText();
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
            String sql ="DELETE FROM CATEGORIES WHERE CATEGORYID = "+this.TXTCATEGORYID.getText();
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
        this.TXTCATEGORYID.setText(this.getPKValue());
        ConnectDb con = new ConnectDb();
        String sql = "SELECT CATEGORYID ,NAME FROM CATEGORIES WHERE CATEGORYID = ?";
        String[] parameter = new String[1];
        parameter[0] = this.getPKValue();
        try{
            ResultSet rs =  con.ExecuteQuery(sql,parameter);
            while(rs.next()){
              this.TXTNAME.setText(rs.getString("NAME"));
            }
            con.Close();
        }
        catch(DataException |SQLException  ex )
        {
            String mes = ex.getMessage()+"\n"+ex.getCause().getMessage(); 
            MsgBox.error(mes,ex.getMessage());
        }   
        this.TXTCATEGORYID.setEditable(false);
        if (this.getAction() == PopUpJpanel.FormActionType.Delete)
        {
           this.TXTNAME.setEditable(false);
        }
    }//GEN-LAST:event_formAncestorAdded


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton CanselButton;
    private javax.swing.JToggleButton SaveButton;
    private javax.swing.JTextField TXTCATEGORYID;
    private javax.swing.JTextField TXTNAME;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
