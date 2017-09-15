
package railway_portal;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;
import java.sql.*;
public class Pnr implements ActionListener,WindowListener{
 
    Button btn1,btn2,btn3;
    TextField txt1,txt2,txt3,txt4;
    Label lbl1,lbl2,lbl3,lbl4;
    Frame f;
    Pnr()
    {
       
      f=new Frame();       
     //label
     lbl1=new Label("Email");
     lbl2=new Label("Train Name");
     lbl3=new Label("Train No.");
     lbl4=new Label("Date");
    
        
     //textfield
     txt1=new TextField(20);
     txt2=new TextField(20);
     txt3=new TextField(20);
     txt4=new TextField(20);
     
     //button   
     btn1=new Button("Submit");
     btn2=new Button("Clear");
     btn3=new Button("Back");
     
     
      Color c1=new Color(100,100,150);
        f.setBackground(c1);
     
     //set bounds for label
     lbl1.setBounds(70,80,60,35);
     lbl2.setBounds(70,180,68,35);
     lbl3.setBounds(70,280,60,35);
     lbl4.setBounds(70,380,60,35);
     
     //set bounds for text field
     txt1.setBounds(200,80,200,25);
     txt2.setBounds(200,180,200,25);
     txt3.setBounds(200,280,200,25);
     txt4.setBounds(200,380,200,25);
     
     //set bounds for button
     btn1.setBounds(200,110,50,25);
     btn2.setBounds(255,110,50,25);
     btn3.setBounds(310,110,50,25);
     
     //label and textfield add to the frame
     f.add(lbl1);f.add(txt1);
     /*f.add(lbl2);f.add(txt2);
     f.add(lbl3);f.add(txt3);
     f.add(lbl4);f.add(txt4);*/
     
     //add button to the frame
     f.add(btn1);f.add(btn2);f.add(btn3);
     
     //to create frame
     f.setLayout(null);
     f.setSize(500,500);
     f.setTitle("PNR Status...");
     f.setVisible(true);
    
     //button action listener
     btn1.addActionListener(this);
     btn2.addActionListener(this);
     btn3.addActionListener(this);
     f.addWindowListener(this);    
    }
    
    public void actionPerformed(ActionEvent e)
    {
      
        if(e.getSource()==btn1)
        {
              

                    try 
                              {
  
   Class.forName("com.mysql.jdbc.Driver");
   Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/institute","root","root");
   System.out.println("Hello");
   PreparedStatement stmt=con.prepareStatement("select * from book_train where Email=?" );
   String email=txt1.getText();
   stmt.setString(1,email);
                
   ResultSet rs=stmt.executeQuery();
                 
    if(rs.next())
    {
                             
     f.add(lbl2);f.add(txt2);
     f.add(lbl3);f.add(txt3);
     f.add(lbl4);f.add(txt4);
                               
     txt2.setText(rs.getString(7));
     txt3.setText(rs.getString(8));
     txt4.setText(rs.getString(5));
     }
     else
                 {
                     JOptionPane.showMessageDialog(null,"Entry Is Not Found...");
                 }

                

                    con.close();
           }
 
         catch(Exception e1)
        {
       System.out.println(e1);
       e1.printStackTrace();
       }  
        }
        else if(e.getSource()==btn2)
        {
        txt1.setText(" "); 
        txt2.setText(" ");
        txt3.setText(" ");
        txt4.setText(" ");
        }
        else if(e.getSource()==btn3)
        {
          new mainmenu();
          f.setVisible(false);
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
