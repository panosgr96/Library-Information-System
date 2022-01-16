package java_universitylibrary_db;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class BooksUPD extends PopUpJpanel {

  
    public BooksUPD() {
        initComponents();
        this.TXTISBN.setEditable(false);        
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
        jLabel3 = new javax.swing.JLabel();
        TXTISBN = new javax.swing.JTextField();
        TXTTITLE = new javax.swing.JTextField();
        CanselButton = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        GridBooksAuthor = new javax.swing.JTable();
        ButInsert = new javax.swing.JButton();
        ButCheng = new javax.swing.JButton();
        DeleteButtom = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        GridCategory = new javax.swing.JTable();
        ButInsert_cat = new javax.swing.JButton();
        ButCheng_cat = new javax.swing.JButton();
        DeleteBut_cat = new javax.swing.JButton();

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

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("ISBN :");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Τίτλος Βιβλίου :");

        CanselButton.setText("Cancel");
        CanselButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CanselButtonActionPerformed(evt);
            }
        });

        GridBooksAuthor.setAutoCreateRowSorter(true);
        GridBooksAuthor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(GridBooksAuthor);

        ButInsert.setText("Εισαγωγή");
        ButInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButInsertActionPerformed(evt);
            }
        });

        ButCheng.setText("Διόρθωση");
        ButCheng.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButChengActionPerformed(evt);
            }
        });

        DeleteButtom.setText("Διαγραφή");
        DeleteButtom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtomActionPerformed(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Συγγραφέας ");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Κατηγορία");

        GridCategory.setAutoCreateRowSorter(true);
        GridCategory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(GridCategory);

        ButInsert_cat.setText("Εισαγωγή");
        ButInsert_cat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButInsert_catActionPerformed(evt);
            }
        });

        ButCheng_cat.setText("Διόρθωση");
        ButCheng_cat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButCheng_catActionPerformed(evt);
            }
        });

        DeleteBut_cat.setText("Διαγραφή");
        DeleteBut_cat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteBut_catActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(SaveButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CanselButton))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(TXTISBN, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(TXTTITLE, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(ButInsert_cat)
                                            .addComponent(DeleteBut_cat, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(ButCheng_cat, javax.swing.GroupLayout.Alignment.TRAILING)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(ButInsert)
                                            .addComponent(DeleteButtom, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(ButCheng, javax.swing.GroupLayout.Alignment.TRAILING))))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TXTISBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TXTTITLE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(ButInsert_cat)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ButCheng_cat)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DeleteBut_cat)))
                .addGap(5, 5, 5)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(ButInsert)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ButCheng)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DeleteButtom))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SaveButton)
                    .addComponent(CanselButton))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {TXTISBN, jLabel1});

    }// </editor-fold>//GEN-END:initComponents

    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed
       if (this.getAction() == PopUpJpanel.FormActionType.Insert)
       {
         ConnectDb con = new ConnectDb();
          String sql ="insert into BOOKS( TITLE) ";
                 sql+= "VALUES ('"+this.TXTTITLE.getText()+"')";
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
          String sql ="UPDATE BOOKS SET TITLE ='"+this.TXTTITLE.getText()+"' "; 
                 sql += "WHERE ISBN = "+this.TXTISBN.getText();
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
          String sql ="DELETE FROM BOOKS WHERE ISBN = "+this.TXTISBN.getText();
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
       this.TXTISBN.setText(this.getPKValue());
        GetBooks();
       
        FetchBooksCategory();
        FetchBooksAuthor();
        if (this.getAction() == PopUpJpanel.FormActionType.Insert)
        {
            this.ButInsert.setEnabled(false);
            this.ButCheng.setEnabled(false);
            this.DeleteButtom.setEnabled(false);
            this.ButInsert_cat.setEnabled(false);
            this.ButCheng_cat.setEnabled(false);
            this.DeleteBut_cat.setEnabled(false);            
        }
        if (this.getAction() == PopUpJpanel.FormActionType.Delete)
        {
           this.TXTTITLE.setEditable(false);
        } 

    }//GEN-LAST:event_formAncestorAdded

    private void ButInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButInsertActionPerformed
        BbooksAuthorUPD upd = new BbooksAuthorUPD();
        upd.setPKValue(this.getPKValue());
        upd.setAction(PopUpJpanel.FormActionType.Insert);
        PopUpMondalWindow ppp = new PopUpMondalWindow(this,"Προσθήκη Συγγραφέα ",upd);
        ppp.setSize(450, 350);
        FetchBooksAuthor();
    }//GEN-LAST:event_ButInsertActionPerformed

    private void ButChengActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButChengActionPerformed
        int row = this.GridBooksAuthor.getSelectedRow();
        if (row < 0 ){return;}
        DefaultTableModel model = (DefaultTableModel) this.GridBooksAuthor.getModel();
        BbooksAuthorUPD upd = new BbooksAuthorUPD();
        upd.setPKValue(this.getPKValue());
        upd.setAuthorID(Integer.parseInt( model.getValueAt(row,1).toString()));
        upd.setAction(PopUpJpanel.FormActionType.Update);
        PopUpMondalWindow ppp = new PopUpMondalWindow(this,"Προσθήκη Συγγραφέα",upd);
        ppp.setSize(450, 350);
        FetchBooksAuthor();
    }//GEN-LAST:event_ButChengActionPerformed

    private void DeleteButtomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtomActionPerformed

        int row = this.GridBooksAuthor.getSelectedRow();
        if (row < 0 ){return;}
        DefaultTableModel model = (DefaultTableModel) this.GridBooksAuthor.getModel();
        BbooksAuthorUPD upd = new BbooksAuthorUPD();
        upd.setPKValue(this.getPKValue());
        upd.setAuthorID(Integer.parseInt( model.getValueAt(row,1).toString()));
        upd.setAction(PopUpJpanel.FormActionType.Delete);
        PopUpMondalWindow ppp = new PopUpMondalWindow(this,"Διαγραφή Συγγραφέα ",upd);
        ppp.setSize(450, 350);
        FetchBooksAuthor();

        // TODO add your handling code here:
    }//GEN-LAST:event_DeleteButtomActionPerformed

    private void ButInsert_catActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButInsert_catActionPerformed
        BbooksCategoryUPD upd = new BbooksCategoryUPD();
        upd.setPKValue(this.getPKValue());
        upd.setAction(PopUpJpanel.FormActionType.Insert);
        PopUpMondalWindow ppp = new PopUpMondalWindow(this,"Προσθήκη Κατηγορίας",upd);
        ppp.setSize(450, 350);
        FetchBooksCategory();
    }//GEN-LAST:event_ButInsert_catActionPerformed

    private void ButCheng_catActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButCheng_catActionPerformed
         int row = this.GridBooksAuthor.getSelectedRow();
        if (row < 0 ){return;}
        DefaultTableModel model = (DefaultTableModel) this.GridCategory.getModel();
        BbooksCategoryUPD upd = new BbooksCategoryUPD();
        upd.setPKValue(this.getPKValue());
        upd.setCategoryID(Integer.parseInt( model.getValueAt(row,1).toString()));
        upd.setAction(PopUpJpanel.FormActionType.Update);
        PopUpMondalWindow ppp = new PopUpMondalWindow(this,"Διόρθωση Κατηγορίας",upd);
        ppp.setSize(450, 350);
        FetchBooksCategory();
    }//GEN-LAST:event_ButCheng_catActionPerformed

    private void DeleteBut_catActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteBut_catActionPerformed
         int row = this.GridBooksAuthor.getSelectedRow();
        if (row < 0 ){return;}
        DefaultTableModel model = (DefaultTableModel) this.GridCategory.getModel();
        BbooksCategoryUPD upd = new BbooksCategoryUPD();
        upd.setPKValue(this.getPKValue());
        upd.setCategoryID(Integer.parseInt( model.getValueAt(row,1).toString()));
        upd.setAction(PopUpJpanel.FormActionType.Delete);
        PopUpMondalWindow ppp = new PopUpMondalWindow(this,"Διαγραφή Κατηγορίας",upd);
        ppp.setSize(450, 350);
        FetchBooksCategory();
    }//GEN-LAST:event_DeleteBut_catActionPerformed

    private void FetchBooksAuthor(){
      
        String[] ColumnName = new String[]{"ISBN","AUTHORID", "Συγγραφέας "};
        String sql = "SELECT BA.ISBN,BA.AUTHORID, AUTHOR.NAME\n" +
                    "FROM BOOKS_AUTHOR BA \n" +
                    " INNER JOIN AUTHOR ON BA.AUTHORID = AUTHOR.AUTHORID\n" +
                    "WHERE BA.ISBN = ? ";
        String[] parameter = new String[1];
        parameter[0] = this.getPKValue();
        try{
            this.GridBooksAuthor.setModel(ConnectDb.DbDefaultTableModel(ColumnName, sql, parameter));
            this.GridBooksAuthor.setRowSelectionInterval(0,0);
            this.GridBooksAuthor.getColumnModel().getColumn(0).setMinWidth(60);
            this.GridBooksAuthor.getColumnModel().getColumn(0).setMaxWidth(60);
            this.GridBooksAuthor.getColumnModel().getColumn(0).setWidth(60);             
            this.GridBooksAuthor.getColumnModel().getColumn(1).setMinWidth(0);
            this.GridBooksAuthor.getColumnModel().getColumn(1).setMaxWidth(0);
            this.GridBooksAuthor.getColumnModel().getColumn(1).setWidth(0);           
        }
        catch(DataException  ex )
        {
            String mes = ex.getMessage()+"\n"+ex.getCause().getMessage(); 
            
            MsgBox.error(mes,ex.getMessage());
        }
    
    }
    private void GetBooks(){
         ConnectDb con = new ConnectDb();
        String sql = "SELECT ISBN, TITLE FROM books WHERE ISBN = ?";
        String[] parameter = new String[]{this.getPKValue()};
        try{
            ResultSet rs =  con.ExecuteQuery(sql,parameter);
            while(rs.next()){
                this.TXTTITLE.setText(rs.getString("TITLE"));
            }
            con.Close();
        }
        catch(DataException |SQLException  ex )
        {
            String mes = ex.getMessage()+"\n"+ex.getCause().getMessage(); 
            MsgBox.error(mes,ex.getMessage());
        }   
    }            
            
    private void FetchBooksCategory(){
      
        String[] ColumnName = new String[]{"ISBN","CATEGORYID", "Κατηγορία "};
        String sql = "SELECT BOOKS_CATEGORIES.ISBN,BOOKS_CATEGORIES.CATEGORYID,\n" +
                    " CATEGORIES.NAME \n" +
                    " FROM BOOKS_CATEGORIES \n" +
                    " INNER JOIN CATEGORIES ON CATEGORIES.CATEGORYID = BOOKS_CATEGORIES.CATEGORYID \n" +
                    "WHERE BOOKS_CATEGORIES.ISBN = ? ";
        String[] parameter = new String[1];
        parameter[0] = this.getPKValue();
        try{
            this.GridCategory.setModel(ConnectDb.DbDefaultTableModel(ColumnName, sql, parameter));
            this.GridCategory.setRowSelectionInterval(0,0);
            this.GridCategory.getColumnModel().getColumn(0).setMinWidth(60);
            this.GridCategory.getColumnModel().getColumn(0).setMaxWidth(60);
            this.GridCategory.getColumnModel().getColumn(0).setWidth(60);             
            this.GridCategory.getColumnModel().getColumn(1).setMinWidth(0);
            this.GridCategory.getColumnModel().getColumn(1).setMaxWidth(0);
            this.GridCategory.getColumnModel().getColumn(1).setWidth(0);           
        }
        catch(DataException ex )
        {
            String mes = ex.getMessage()+"\n"+ex.getCause().getMessage(); 
            
            MsgBox.error(mes,ex.getMessage());
        }
    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButCheng;
    private javax.swing.JButton ButCheng_cat;
    private javax.swing.JButton ButInsert;
    private javax.swing.JButton ButInsert_cat;
    private javax.swing.JToggleButton CanselButton;
    private javax.swing.JButton DeleteBut_cat;
    private javax.swing.JButton DeleteButtom;
    private javax.swing.JTable GridBooksAuthor;
    private javax.swing.JTable GridCategory;
    private javax.swing.JToggleButton SaveButton;
    private javax.swing.JTextField TXTISBN;
    private javax.swing.JTextField TXTTITLE;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
