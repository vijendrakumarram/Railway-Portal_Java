
package railway_portal;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.JOptionPane;
public class Book_train  implements ActionListener,WindowListener{
 
    Button b1,b2;
    TextField txt2,txt3,txt4,txt5,txt6,txt7,txt8,txt9;
    Frame f;
    Book_train()
    {
          f=new Frame();
         
      //background color 
      Color c1=new Color(20,170,90);
       f.setBackground(c1);

       
       
      // title of page
      Label  lbl1=new Label("FILL ALL BLANKS");
      lbl1.setBounds(110,50,260,35);
      Font font1=new Font("Arial",Font.BOLD,30);
      lbl1.setFont(font1);

      
      //form label
      Label  lbl2=new Label("Enter Your Name");
      Label  lbl3=new Label("Enter Your Email");
      Label  lbl4=new Label("Enter Your Phone No.");
      Label  lbl5=new Label("Enetr Your Address");
      Label  lbl6=new Label("Enter Date");
      Label  lbl7=new Label("How Many Seat You Want To Book");
      Label  lbl8=new Label("Enter Train Name");
      Label  lbl9=new Label("Enter Train No..");
      
       Color c2=new Color(20,80,90);
       lbl1.setForeground(c2);lbl2.setForeground(c2);lbl3.setForeground(c2);lbl4.setForeground(c2);
       lbl5.setForeground(c2);lbl6.setForeground(c2);lbl7.setForeground(c2);lbl8.setForeground(c2);
       lbl9.setForeground(c2);

       
       
      //set the lable Bounds
      lbl2.setBounds(50,110,100,35);
      lbl3.setBounds(50,149,100,35);
      lbl4.setBounds(50,189,150,35);
      lbl5.setBounds(50,229,120,35);
      lbl6.setBounds(50,269,100,35);
      lbl7.setBounds(50,309,190,35);
      lbl8.setBounds(50,349,100,35);
      lbl9.setBounds(50,389,100,35);
      
      
      //TextField start to txt2
      txt2=new TextField(20);
      txt3=new TextField(20);
      txt4=new TextField(20);
      txt5=new TextField(20);
      txt6=new TextField(20);
      txt7=new TextField(20);
      txt8=new TextField(20);
      txt9=new TextField(20);
      
      //set the text Bounds
      txt2.setBounds(270,115,150,25);
      txt3.setBounds(270,154,150,25);
      txt4.setBounds(270,194,150,25);
      txt5.setBounds(270,234,150,25);
      txt6.setBounds(270,274,150,25);
      txt7.setBounds(270,314,150,25);
      txt8.setBounds(270,354,150,25);
      txt9.setBounds(270,394,150,25);
      

      
      //button
      b1=new Button("Submit");
      b2=new Button("Back");
      
      //button position
      b1.setBounds(270,430,73,35);
      b2.setBounds(347,430,74,35);
      
       b1.setBackground(c1);
       b2.setBackground(c1);
       b1.setForeground(c2);
       b2.setForeground(c2);
      
      
      //add to the frame
      f.add(lbl1);
      f.add(lbl2);f.add(txt2);
      f.add(lbl3);f.add(txt3);
      f.add(lbl4);f.add(txt4);
      f.add(lbl5);f.add(txt5);
      f.add(lbl6);f.add(txt6);
      f.add(lbl7);f.add(txt7);
      f.add(lbl8);f.add(txt8);
      f.add(lbl9);f.add(txt9);
      f.add(b1);f.add(b2);
      //create frame
     
      f.setTitle("BOOK TRAIN");
      f.setLayout(null);
      f.setSize(500,500);
      f.setVisible(true);
      
      //button and action listener
      b1.addActionListener(this);
      b2.addActionListener(this);
      f.addWindowListener(this); 
    }
   

    
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==b1)
       {
                   try 
            {
  
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/institute","root","root");
        System.out.println("Hello");
        PreparedStatement stmt=con.prepareStatement("insert into book_train values(?,?,?,?,?,?,?,?)");
        
        String Name=txt2.getText();
        stmt.setString(1,Name);
        
        String Email=txt3.getText();
        stmt.setString(2,Email);
        
        String Phone=txt4.getText();
        stmt.setString(3,Phone);
        
        String Address=txt5.getText();
        stmt.setString(4,Address); 
               
        String Date=txt5.getText();
        stmt.setString(5,Date);
        
                String Seat=txt6.getText();
        stmt.setString(6,Seat);
        
                String Train_name=txt7.getText();
        stmt.setString(7,Train_name);
        
                     String Train_no=txt8.getText();
        stmt.setString(8,Train_no);
        
        
        int i=stmt.executeUpdate();
        
         
         txt2.setText(" ");
         txt3.setText(" ");
         txt4.setText(" ");
         txt5.setText(" ");
         txt6.setText(" ");
         txt7.setText(" ");
         txt8.setText(" ");
         txt9.setText(" ");
         
         JOptionPane.showMessageDialog(null, "You Are Registered...");
          
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
public static void main(String...s)
{
    new Book_train();
}
}
