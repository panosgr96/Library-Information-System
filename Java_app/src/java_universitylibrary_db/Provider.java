package java_universitylibrary_db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
public abstract class Provider {
    
    protected String JdbcUrl = null;
    protected String UserName = null;
    protected String Password = null;
    
    protected Connection getConnection() throws DataException{
        if (this.JdbcUrl == null){
            LoadSetings();
        }
        Connection con = null;
        try{
           con = DriverManager.getConnection(JdbcUrl, UserName, Password);
        } catch(SQLException sqle ){
            throw new DataException("Error in getting a DB Connection",sqle);
        }
        return con;
    } 
    
    private void LoadSetings() throws DataException {
        Properties prop = new Properties();
        InputStream input = null;
        try{
            input = new FileInputStream("DataBaseconfig.properties");
            prop.load(input);
            this.JdbcUrl=  prop.getProperty("JdbcUrl");
            this.UserName =  prop.getProperty("UserName");
            this.Password=  prop.getProperty("Password");
            input.close();
        } catch (IOException ioe) {
            if (input!= null){
                 try {
                        input.close();
		} catch (IOException e) {
                    throw new DataException(e.getMessage(),ioe);
		}                
            }
            throw new DataException("Error is loading File settings"+ioe.getMessage() ,ioe);
        }
        
    }
    
    
}