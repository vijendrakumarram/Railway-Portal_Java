
package railway_portal;
import java.awt.*;
import java.awt.event.*;
public class Contact extends Frame implements ActionListener,WindowListener{
    
    
    Button btn1,btn2,btn3;
    TextField txt1,txt2,txt3;
    Contact()
    {
     Color c1=new Color(20,150,90);
     setBackground(c1);
      
     Label lbl1=new Label("Enter City");
     Label lbl2=new Label("Enter Post");
     Label lbl3=new Label("Enter");
        
        
      //frame
        setTitle("Contacts...");
        setLayout(null);
        setSize(500,500);
        setVisible(true);
        
        addWindowListener(this);
        
    }
    
    public void actionPerformed(ActionEvent e)
    {
        
    }
    //For windowlistener
public void windowOpened(WindowEvent e)
{}
public void windowClosing(WindowEvent e)
{
System.exit(9);
}
public void windowClosed(WindowEvent e)
{
 System.exit(9);
}
public void windowIconified(WindowEvent e)
{}
public void windowDeiconified(WindowEvent e)
{}
public void windowActivated(WindowEvent e)
{}
public void windowDeactivated(WindowEvent e)
{}
}
