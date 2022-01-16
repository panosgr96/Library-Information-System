package java_universitylibrary_db;

public class DataException  extends Exception {
    public DataException() {
        super();
    }
    public DataException(String message){
        super(message);
    }
    public DataException(Throwable inerException){
        super(inerException);
    }
    public DataException(String message,Throwable inerException){
        super(message ,inerException);
    }

    DataException(String eror_, String mes) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
