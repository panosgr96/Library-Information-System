package java_universitylibrary_db;

public class CoboBoxItem {
    private String value;
    private String text;

    public CoboBoxItem(String value, String text) {
        this.value = value;
        this.text = text;
    }
    
    public String getValue()
    {
       return  this.value;
    }
    
    @Override
    public String toString() {
        return text;
    }
}
