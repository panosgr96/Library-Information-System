package java_universitylibrary_db;

import java.awt.Component;
import javax.swing.JFrame;

public class PopUpJpanel extends javax.swing.JPanel {
    private PopUpMondalWindow _PopupWin = null;
    private FormActionType _FormActionType =FormActionType.Display;
    private String _PK_Value = "";
             
    public void setPopupWin(PopUpMondalWindow popupWin)
    {
       this._PopupWin =  popupWin;
    }
    public PopUpMondalWindow getPopupWin()
    {
      return  this._PopupWin;
    } 
    public void setAction(FormActionType Action)
    {
       this._FormActionType = Action;
    }
    public FormActionType getAction()
    {
       return this._FormActionType;
    }
    public enum FormActionType{
        Insert,
        Update,
        Display,
        Delete,
        Select
    }
    public void setPKValue(String Value)
    {
        this._PK_Value = Value;
    }
    public String getPKValue()
    {
      return  this._PK_Value;
    }  
    public JFrame GetFrame()
    {
        Component parent = this;
        JFrame topFrame = null;
        try 
        {
            topFrame = (JFrame)parent;
        }
        catch (Exception ex)
        {
            try
            {
               Component c = parent.getParent();
                while ( c.getParent() != null )
                {
                    c = c.getParent();
                }
                topFrame = ( JFrame )c;
            }
            catch (Exception ex1)
            {
                 topFrame = new JFrame();
            }
        }   
        finally {
            if (topFrame == null) topFrame = new JFrame();
        }
        return topFrame;
    }
}
