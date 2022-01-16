
package java_universitylibrary_db;

import java.awt.BorderLayout;
import javax.swing.JDialog;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.Dialog;
import java.awt.Component;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class PopUpJInternalFrame extends JDialog implements ActionListener 
{
//    public PopUpMondalWindow(JInternalFrame parent ,String title,  PopUpJpanel PopupPanel ) 
//    public PopUpJInternalFrame(Component parent ,String title,  javax.swing.JInternalFrame PopupPanel ) 
    public PopUpJInternalFrame(JFrame parent ,String title,  javax.swing.JInternalFrame PopupPanel ) 
    {
        super(parent, title, true);
        this.setModalityType(Dialog.ModalityType.DOCUMENT_MODAL);
        setSize(500,400);
        setLocationRelativeTo(null);
        getContentPane().add(PopupPanel,BorderLayout.SOUTH);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack(); 
        setVisible(true);   
    }
     
    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false); 
        dispose(); 
      }
    

   
    public static JFrame GetFrame(Component parent)
    {
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
    
    
    public static PopUpJInternalFrame getPopUpJInternalF(Component parent)
    {
        PopUpJInternalFrame popupf = null;
        try{
            Component c = parent.getParent();
            while ( c.getParent() != null )
            {
                c = c.getParent();
                if (c.getClass().toGenericString().indexOf("PopUpJInternalFrame")>0)
                {
                    break;
                }
            }
            popupf = ( PopUpJInternalFrame )c;
            return popupf;
        }
        catch (Exception ex){ 
           return null;
        }
    }
    
}
