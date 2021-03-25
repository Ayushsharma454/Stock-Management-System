package Finalpr;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class addsupplier extends JFrame implements ActionListener {
    JLabel l1,l2,l3,l4,l5,l6;
    JTextField t1,t2,t3,t4,t5;
    JButton b1,b2;
    Connection c;
    Statement es;
    addsupplier()
    {
        setLayout(null);
        l1=new JLabel("Add supplier");
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
        b1=new JButton("Save");
        b2=new JButton("Cancel");
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
        b1.setBounds(80,350,120,40);
        b2.setBounds(210,350,120,40);
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
    }
    public  void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==b1)
       {
           try{
            String a=t1.getText();
            String b=t2.getText();
            String c=t3.getText();
            String d=t4.getText();
            String e=t5.getText();
            
            es.execute("insert into supplier(name,city,phoneno,email,address)values('"+a+"','"+b+"','"+c+"','"+d+"','"+e+"')");
            JOptionPane.showMessageDialog(null,"Supplier Added");
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
        addsupplier ob=new addsupplier();
        ob.setSize(400,450);
        ob.setVisible(true);
    }
}
    
