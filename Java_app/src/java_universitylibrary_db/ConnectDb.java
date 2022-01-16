package java_universitylibrary_db;

import java.sql.*;
//import java.sql.PreparedStatement;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;


public class ConnectDb extends Provider{
    private Connection con;
    private Statement st;
    public ConnectDb(){
      this.con = null;
      this.st = null;
    }
    public ResultSet  ExecuteQuery(String sqlStr) throws DataException{
        try{
            if (this.con == null)
            {
                con = this.getConnection();
            }
            if (this.st == null)
            {
                this.st = con.createStatement();
            }
            ResultSet rs = this.st.executeQuery(sqlStr);
            return rs;
        } catch(SQLException sqle ){
            throw new DataException("Eror ExecuteQuery " ,sqle);
        }
            
        
    }
    
    public ResultSet  ExecuteQuery(String sqlStr,String[]Parameters ) throws DataException{
        try{
            if (this.con == null)
            {
                con = this.getConnection();
            }
            PreparedStatement  prst =  con.prepareStatement(sqlStr, Parameters);
            for(int i =0; i < Parameters.length; i++)
            {
                 prst.setString((i+1), Parameters[i].toString());
            }
            return prst.executeQuery();
        } catch(SQLException sqle ){
            throw new DataException("Eror ExecuteQuery ",sqle);
        }
    }

  
    public void UpdateQuery(String sqlStr) throws DataException{
        try{
            if (this.con == null)
            {
                con = this.getConnection();
            }
            if (this.st == null || st.isClosed())
            {
                this.st = con.createStatement();
            }
            this.st.executeUpdate(sqlStr);
        } catch(SQLException sqle ){
            throw new DataException("Eror ExecuteQuery ",sqle);
        }
    
    }
    
    
    public void Close()throws DataException
    {
        try{
            if (this.st != null)
            {
                this.st.close();
            }
            if (this.con != null)
            {
                con.close();
            }
        } catch(SQLException sqle ){
            throw new DataException("connection close", sqle);
        }
    }
    
    
    
    public static DefaultTableModel DbDefaultTableModel(String[] ColumnNames ,String sql,String[] Parameters )throws DataException{
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        ConnectDb con = new ConnectDb();
        int cols = 0;
        try{
            ResultSet rs;
            if (Parameters != null && Parameters.length > 0)
            {
                rs =  con.ExecuteQuery(sql,Parameters);
            }
            else
            {
                rs =  con.ExecuteQuery(sql);
            }
            boolean findrow = false;
            
            DefaultTableModel md = new DefaultTableModel()
            {@Override
            public boolean isCellEditable(int row , int column){return false;}};
            ResultSetMetaData meta  = rs.getMetaData();
            if (ColumnNames != null && ColumnNames.length >0)
            {
                cols = ColumnNames.length;
                for(int i=0; i< ColumnNames.length ; i++)
                {
                    md.addColumn(ColumnNames[i]);
                   
                }
            }  
            else
            {
                cols =  meta.getColumnCount();
                for(int i=0; i< cols ; i++)
                {
                    md.addColumn(meta.getColumnLabel(i+1));
                }
            }
            while(rs.next()){
              Vector row = new Vector(cols);
              for (int i = 0; i < cols ;i++)
              {
                 switch(meta.getColumnTypeName(i+1).toUpperCase())
                 {
                     case "DATE":
                     {
                        if (rs.getDate(i+1)!= null) {
                            row.addElement(dateFormat.format(rs.getDate(i+1)));
                        }
                        else{
                                row.addElement("");
                        }
                //         row.addElement(rs.getDate(i+1));
                         break;
                     }                  
                     
                     case "INT":
                     {
                         if (rs.getString(i+1) != null ){
                            row.addElement(rs.getInt(i+1));
                         }
                         else{
                             row.addElement("");
                         }                             
                         break;
                     }   
                     default:
                         {
                           row.addElement(rs.getString(i+1));
                           break;
                         }
                 }
              }
              md.addRow(row);
              findrow = true;
            }
            if (!findrow)
            {
              Vector row = new Vector(cols);
               for (int i = 0; i < cols ;i++){
                 row.addElement(" ");  
              }
              md.addRow(row);
            }
            con.Close();
            return md;
        }
        catch(DataException |SQLException  ex )
        {
          throw new DataException(ex.getMessage() ,ex.getCause());

        }
    }

}
