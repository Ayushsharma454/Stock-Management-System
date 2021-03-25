package Finalpr;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class login extends JFrame implements ActionListener {
    JLabel l1,l2,l3;
    JTextField t1;
    JPasswordField t2;
    JButton b1,b2;
    Connection c;
    Statement es;
    login()
    {
        setLayout(null);
        l1=new JLabel("Login");
        l2=new JLabel("Username");
        t1=new JTextField("");
        l3=new JLabel("Password");
        t2=new JPasswordField("");
         b1=new JButton("SignIn");
        b2=new JButton("Cancel");   
        l1.setBounds(180,20,120,40);
        l2.setBounds(100,100,90,40);
        t1.setBounds(200,100,120,40);
        l3.setBounds(100,150,90,40);
        t2.setBounds(200,150,120,40);
        b1.setBounds(100,250,120,40);
        b2.setBounds(250,250,120,40);
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        try
         {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            c=DriverManager.getConnection("jdbc:ucanaccess://E://DB.accdb");		
            es=c.createStatement();
         }
         catch(ClassNotFoundException | SQLException e)
         {
              System.out.println(e);
         }
        setContentPane(new JLabel(new ImageIcon("back.jpg")));
        add(l1);
        add(l2);
        add(t1);
        add(l3);
        add(t2);
        add(b1);
        add(b2);
    }
    public  void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==b1)
        {
           try{
            String user=t1.getText();
            String pass=t2.getText();
            if(user.equals("ayush") && pass.equals("ayush")){
                JOptionPane.showMessageDialog(null,"Login Successfull");
                this.setVisible(false);
                main ob=new main();
                ob.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
		ob.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null,"Login Failed");
            }
        }
         catch(Exception se){ System.out.println(se); }
    }
    if(ae.getSource()==b2)
    {
         System.exit(0);
    }
}
 public static void main(String ar[])
{
 
    login ob=new login();
 
  ob.setSize(400,400);
 ob.setLocation(300,300);
 ob.setVisible(true);

  }
}