package java_universitylibrary_db;

import java.lang.StringBuilder;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public final class MsgBox
{
    public static void info(String message) {
        info(message, theNameOfTheMethodThatCalledMe());
    }
    public static void info(String message, String caller) {
        show(message, caller, JOptionPane.INFORMATION_MESSAGE);
    }
    static void error(String message) {
        error(message, theNameOfTheMethodThatCalledMe());
    }
    public static void error(String message, String caller) {
        show(message, caller, JOptionPane.ERROR_MESSAGE);
    }
    public static void error(Exception exception, String caller) {
        StringBuilder sb = new StringBuilder("Error: ");
        sb.append(exception.getMessage());
        sb.append("\n");
        sb.append(exception.getCause().getMessage());
       
        show(sb.toString(), caller, JOptionPane.ERROR_MESSAGE);
    }
    public static void show(String message, String title, int iconId) {
        setClipboard(title+":"+NEW_LINE+message);
        StringBuilder sb = new StringBuilder(message);
        JTextArea jta = new JTextArea(sb.toString());
        JScrollPane jsp = new JScrollPane(jta){
                @Override
                public Dimension getPreferredSize() {
                    return new Dimension(480, 320);
                }
            };
//        JOptionPane.showMessageDialog(null, message, title, iconId);
        JOptionPane.showMessageDialog(null, jsp, title, iconId);
    }
    private static final String NEW_LINE = System.lineSeparator();
    public static String theNameOfTheMethodThatCalledMe() {
        return Thread.currentThread().getStackTrace()[3].getMethodName();
    }
    public static void setClipboard(String message) {
        CLIPBOARD.setContents(new StringSelection(message), null);
    }
    private static final Toolkit AWT_TOOLKIT = Toolkit.getDefaultToolkit();
    private static final Clipboard CLIPBOARD = AWT_TOOLKIT.getSystemClipboard();
}
