package Finalpr;

import java.awt.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class editsupplier extends JFrame implements ActionListener {
     JLabel l1,l2,l3,l4,l5,l6;
    JTextField t1,t2,t3,t4,t5;
    JButton b1,b2,b3;
    Connection c;
    Statement s;
    ResultSet rs;
    int id;
    editsupplier()
    {
        setLayout(null);
        l1=new JLabel("Edit supplier");
        l2=new JLabel("Name");
        l3=new JLabel("City");
        l4=new JLabel("Phone no.");
        l5=new JLabel("E-mail");
        l6=new JLabel("Address");
        t1=new JTextField("");
        t2=new JTextField("");
        t3=new JTextField("");
        t4=new JTextField("");
        t5=new JTextField("");
        b1=new JButton("Get Record");
        b2=new JButton("Save");
        b3=new JButton("Cancel");
        l1.setBounds(180,30,120,40);
        l2.setBounds(60,100,120,40);
        l3.setBounds(60,150,120,40);
        l4.setBounds(60,200,120,40);
        l5.setBounds(60,250,120,40);
        l6.setBounds(60,300,120,40);
        t1.setBounds(200,100,120,40);
        t2.setBounds(200,150,120,40);
        t3.setBounds(200,200,120,40);
        t4.setBounds(200,250,120,40);
        t5.setBounds(200,300,120,40);
        b1.setBounds(350,100,120,40);
        b2.setBounds(100,360,80,40);
        b3.setBounds(220,360,80,40);
        
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
        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(l5);
        add(l6);
        add(t1);
        add(t2);
        add(t3);
        add(t4);
        add(t5);
        add(b1);
        add(b2);
        add(b3);
    }
    public  void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==b1)
        {
           try{
               id=Integer.parseInt(t1.getText());
               rs=s.executeQuery("select * from supplier where ID="+id);
               rs.next();
               t2.setText(rs.getString(3));
               t3.setText(rs.getString(4));
               t4.setText(rs.getString(5));
               t5.setText(rs.getString(6));
           }
           catch(Exception se){ System.out.println(se); }
        }
        // save record
        if(ae.getSource()==b2)
        {
            try{
            String a=t2.getText();
            String b=t3.getText();
            String c=t4.getText();
            String d=t5.getText();
            s.execute("update supplier set city='"+a+"',phoneno='"+b+"',email='"+c+"',address='"+d+"' where ID="+id);
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
        editsupplier ob=new editsupplier();
        ob.setSize(500,500);
        ob.setVisible(true);
    }
}
    

    


    

