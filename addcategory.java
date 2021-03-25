package Finalpr;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class addcategory extends JFrame implements ActionListener {
    JLabel l1,l2;
    JTextField t1;
    JButton b1,b2;
    Connection c;
    Statement es;
    addcategory()
    {
        setLayout(null);
        l1=new JLabel("Add category");
        l2=new JLabel("Name");
        t1=new JTextField("");
        b1=new JButton("Save");
        b2=new JButton("Cancel");   
        l1.setBounds(180,70,120,40);
        l2.setBounds(100,150,90,40);
        t1.setBounds(200,150,120,40);
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
        add(b1);
        add(b2);
    }
    public  void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==b1)
        {
           try{
            String a=t1.getText();
            es.execute("insert into category(nname)values('"+a+"')");
            JOptionPane.showMessageDialog(null,"Category Added");
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
 
    addcategory ob=new addcategory();
 
  ob.setSize(400,400);
 ob.setLocation(300,300);
 ob.setVisible(true);

  }
}