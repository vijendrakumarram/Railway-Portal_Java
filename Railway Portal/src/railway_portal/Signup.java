
package railway_portal;

import java.awt.*;
import java.awt.event.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class Signup extends Frame implements WindowListener,ActionListener
   {
    Button b1,b2,b3;
    TextField txt1,txt2,txt3;
    Signup()
   {
       //For color
    Color c1=new Color(20,170,90);
    setBackground(c1);
    Label lbl1=new Label("ENTER USER NAME");
    Label lbl2=new Label("ENTER PASSWORD");
    Label lbl3=new Label("ENTER MOBILE No.");
    Label lbl=new Label("PLEASE SIGN UP");
    
    Font font1=new Font("Arial",Font.BOLD,30);
    lbl.setFont(font1);
    
    Font font2=new Font("Arial",Font.BOLD,14);
    lbl1.setFont(font2);
    lbl2.setFont(font2);
    lbl3.setFont(font2);

    txt1=new TextField(20);
    txt2=new TextField(20);
    txt3=new TextField(20); 
      
    b1=new Button("Submit");
    b2=new Button("Cancel");
    b3=new Button("Back");

    lbl.setBounds(120,70,255,25);
    
    txt1.setBounds(200,160,200,25);
    lbl1.setBounds(50,160,150,25);
    
    txt2.setBounds(200,230,200,25);
    lbl2.setBounds(50,230,150,25);
  
    txt3.setBounds(200,300,200,25);
    lbl3.setBounds(50,300,150,25);

    b1.setBounds(200,350,55,35);
    b2.setBounds(258,350,58,35);
    b3.setBounds(320,350,58,35);
     add(lbl);
     add(lbl1);add(txt1);
     add(lbl2);add(txt2);
     add(lbl3);add(txt3);
     add(b1);add(b2);add(b3);
        
    //For frame
    setLayout(null);
    setSize(500,500);
    setVisible(true);
    setTitle("SIGN_UP PAGE");
   
   
    
    Color c2=new Color(20,170,90); 
    b1.setBackground(c2);
    b2.setBackground(c2);
    b2.setBackground(c2);
    

        
    Color c4=new Color(20,170,90); 
    b1.setBackground(c4);
    b2.setBackground(c4);
    b3.setBackground(c4);
    Color c5=new Color(20,80,90);
    b1.setForeground(c5);
    b2.setForeground(c5);
    b3.setForeground(c5);
    b1.setFont(font2);
    b2.setFont(font2);
    b3.setFont(font2);
    
    lbl.setForeground(c5);
    lbl1.setForeground(c5);
    lbl2.setForeground(c5);
    lbl3.setForeground(c5);
   
//for button listener
b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
addWindowListener(this);
}
//For ActionListener
public void actionPerformed(ActionEvent e)
{
if(e.getSource()==b1)
{
 try 
            {
  
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/institute","root","root");
        System.out.println("Hello");
        PreparedStatement stmt=con.prepareStatement("insert into Signup values(?,?,?)");
        
        String User=txt1.getText();
        stmt.setString(1,User);
        
        String Password=txt2.getText();
        stmt.setString(2,Password);
        
        String Phone=txt3.getText();
        stmt.setString(3,Phone);
        
        
        
        int i=stmt.executeUpdate();
        
         txt1.setText(" ");
         txt2.setText(" ");
         txt3.setText(" ");
         
         
         JOptionPane.showMessageDialog(null, "You Are Registered..."+User);
          
         con.close();
        }
 
        catch(Exception e1)
        {
       System.out.println(e1);
      e1.printStackTrace();
       }
    
    
    
}
else if(e.getSource()==b2)
{
System.out.println("YOU WANNA CLOSE THAT");
}
else if(e.getSource()==b3)
{
   mainmenu mamenu=new mainmenu();
   setVisible(false);
}
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
