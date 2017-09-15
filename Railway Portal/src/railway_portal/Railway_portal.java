
package railway_portal;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
class Railway_portal implements WindowListener,ActionListener
   {
    Frame f;
    Button btn1,btn2,btn3;
    TextField txt1,txt2;
    Railway_portal()
         
    {
       
   f=new Frame();
   
    Color c1=new Color(20,170,90);
    f.setBackground(c1);
   
    Label lbl=new Label("INDIAN RAILWAY PORTAL");
    Label lbl1=new Label("Email Id");
    Label lbl2=new Label("Password");
 
    txt1=new TextField(20);
    txt2=new TextField(20);

    btn1=new Button("Log In");
    btn2=new Button("Clear");
    btn3=new Button("Sign Up");

    lbl.setBounds(50,65,390,25);
    txt1.setBounds(180,160,200,25);
    lbl1.setBounds(95,160,70,25);
    
    txt2.setBounds(180,230,200,25);
    lbl2.setBounds(95,230,70,25);
    
    btn1.setBounds(180,275,68,35);
    btn2.setBounds(248,275,69,35);
    btn3.setBounds(317,275,64,35);
     f.add(lbl);
     f.add(lbl1);f.add(txt1);
     f.add(lbl2);f.add(txt2);
     f.add(btn1);f.add(btn2);
     f.add(btn3);
     //add(new JScrollPane(),BorderLayout.CENTER);
        

//For frame
 //f.add(new JScrollPane());
    f.setLayout(null);
    f.setSize(500,500);
    f.setVisible(true);
    f.setTitle("LOGIN PAGE");
    
    
    
   


//for button listener
btn1.addActionListener(this);
btn2.addActionListener(this);
btn3.addActionListener(this);
f.addWindowListener(this);



        

//for color and font size
Font font1=new Font("Arial",Font.BOLD,30);
lbl.setFont(font1);
Color c3=new Color(20,80,90);
lbl.setForeground(c3);

btn1.setBackground(c1);
btn2.setBackground(c1);
btn3.setBackground(c1);

btn1.setForeground(c3);
btn2.setForeground(c3);
btn3.setForeground(c3);

lbl1.setForeground(c3);
lbl2.setForeground(c3);



Font font2=new Font("Arial",Font.BOLD,14);
lbl1.setFont(font2);
lbl2.setFont(font2);

        
    }
    
    public void actionPerformed(ActionEvent e)
    {
     if(e.getSource()==btn1)
     {
      try
      {
        Class.forName("com.mysql.jdbc.Driver"); 
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/institute","root","root");
        System.out.println("Hello");
        PreparedStatement stmt=con.prepareStatement("select * from Signup where User=? and Password=?");
        String user=txt1.getText();
        stmt.setString(1,user);
        int pass=Integer.parseInt(txt2.getText());
        stmt.setInt(2,pass);
        ResultSet rs=stmt.executeQuery();
        if(rs.next())
        {
           System.out.println("Hello");
          mainmenu mnu=new mainmenu();
          f.setVisible(false);
        }
        else{
          JOptionPane.showMessageDialog(null,"Your Entry is Wrong"); 
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
     }
     else if(e.getSource()==btn3)
     {
      Signup sgu=new Signup(); 
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
public static void main(String...s)
{
    new Railway_portal();
}

 }