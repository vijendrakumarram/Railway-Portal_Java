
package railway_portal;


import java.awt.*;
import java.awt.event.*;
class mainmenu extends Frame implements WindowListener,ActionListener
   {
    Button b1,b2,b3,b4,b5,b6,b7;
    TextField txt1,txt2;
    mainmenu()
   {
    //For color
    Color c1=new Color(20,170,90);
    setBackground(c1); 
       
       //label
       Label lbl2=new Label("");
       lbl2.setBounds(0,95,500,5);

       
       
      //title
       Label lbl3=new Label("INDIAN RAILWAY PORTAL");
       lbl3.setBounds(60,50,390,35);
 
       

       //title foregroung color
       Color c5=new Color(20,80,90);
       lbl3.setForeground(c5);
       Font font1=new Font("Arial",Font.BOLD,30);
       lbl3.setFont(font1);
       
    //button   
    b1=new Button("Book Train");    b1.setForeground(c5);
    b2=new Button("Trains");        b2.setForeground(c5);
    b3=new Button("Search Train");  b3.setForeground(c5);
    b4=new Button("Pnr Status");    b4.setForeground(c5);
    b5=new Button("Contact Us");    b5.setForeground(c5);
    b6=new Button("Back");          b6.setForeground(c5);
    b7=new Button("");              b7.setForeground(c5);
    
    
   //button position
    b1.setBounds(35,107,90,35);
    b2.setBounds(130,107,60,35);
    b3.setBounds(195,107,100,35);
    b4.setBounds(300,107,80,35);
    b5.setBounds(385,107,80,35);
    b6.setBounds(165,170,80,35);
    b7.setBounds(250,170,80,35);
    
     
    add(b1);add(b2);
    add(b3);add(b4);
    add(b5); add(b6);
    add(b7);
    add(lbl2);add(lbl3);
    //For frame
    setLayout(null);
    setSize(500,500);
    setVisible(true);
    setTitle("MAIN MENU PAGE");
   
 Font font2=new Font("Arial",Font.BOLD,14);
   b1.setFont(font2);
   b2.setFont(font2);
   b3.setFont(font2);
   b4.setFont(font2);
   b5.setFont(font2);
   b6.setFont(font2);
   b7.setFont(font2);
         
    Color c2=new Color(20,170,90); 
    b1.setBackground(c2);
    b2.setBackground(c2);
    b3.setBackground(c2);
    b4.setBackground(c2);
    b5.setBackground(c2);
    b6.setBackground(c2);
    b7.setBackground(c2);

   
//for button listener
b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
b4.addActionListener(this);
b5.addActionListener(this);
b6.addActionListener(this);
b7.addActionListener(this);
addWindowListener(this);
}
//For ActionListener
public void actionPerformed(ActionEvent e)
{
if(e.getSource()==b1)
{
Book_train bokt=new Book_train();
setVisible(false);
}
else if(e.getSource()==b6)
{
Railway_portal railport=new Railway_portal();
setVisible(false);
}
else if(e.getSource()==b7)
{
  Signup sgup=new Signup();
  setVisible(false); 
}
else if(e.getSource()==b2)
{
  new trains();
 setVisible(false);  
}
else if(e.getSource()==b4)
{
    new Pnr();
   setVisible(false);
}
else if(e.getSource()==b5)
{
    new Contact();
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
public static void main(String...f)
{
    new mainmenu();
}
}
