package Finalpr;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class editcategory extends JFrame implements ActionListener {
    JLabel l1,l2,l0;
    JTextField t1,t2;
    JButton b1,b2,b3;
    Connection c;
    Statement s;
    ResultSet rs;
    int id;
    editcategory()
    {      
        setLayout(null);
        l0=new JLabel("Edit category");
        l1=new JLabel("Enter id");
        l2=new JLabel("Name");
        t1=new JTextField("");
        t2=new JTextField("");
        b1=new JButton("Get Record");
        b2=new JButton("Save");
        b3=new JButton("Cancel");
        l0.setBounds(130,20,80,40);
        l1.setBounds(20,150,80,40);
        l2.setBounds(20,200,80,40);
        t1.setBounds(120,150,120,40);
        t2.setBounds(120,200,120,40);
        b1.setBounds(250,150,120,40);
        b2.setBounds(50,260,80,40);
        b3.setBounds(140,260,80,40);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        try
         {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            c=DriverManager.getConnection("jdbc:ucanaccess://E://DB.accdb");		
            s=c.createStatement();
         }
         catch(ClassNotFoundException | SQLException e)
         {
              System.out.println(e);
         }
        setContentPane(new JLabel(new ImageIcon("back.jpg")));
        add(l0);
        add(l1);
        add(l2);
        add(t1);
        add(t2);
        add(b1);
        add(b2);
        add(b3);
    }
    public  void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==b1)
        {
           try{
               id=Integer.parseInt(t1.getText());
               rs=s.executeQuery("select * from category where id="+id);
               rs.next();
               t2.setText(rs.getString(2));
           }
           catch(Exception se){ System.out.println(se); }
        }
        // save record
        if(ae.getSource()==b2)
        {
            try{
            String a=t2.getText();
            s.execute("update category set nname='"+a+"' where id="+id);
            JOptionPane.showMessageDialog(null,"Record updated");
        }
         catch(Exception se){ System.out.println(se); }
    }
    if(ae.getSource()==b3)
    {
         System.exit(0);
    }
}
 public static void main(String ar[])
{
  editcategory ob=new editcategory();
 ob.setSize(400,500);
 ob.setVisible(true);

  }
}
