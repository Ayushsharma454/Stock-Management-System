
package Finalpr;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class addseller extends JFrame implements ActionListener {
    JLabel l1,l2,l3,l4,l5;
    JTextField t3,t4;
    JComboBox t1,t2;
    JButton b1,b2;
    Connection c;
    Statement es;
    addseller()
    {
        setLayout(null);
        l1=new JLabel("Add Sales");
        l2=new JLabel("Supplier name");
        l3=new JLabel("Product name");
        l4=new JLabel("Product quantity");
        l5=new JLabel("Price");
        t1=new JComboBox();
        t2=new JComboBox();
        t3=new JTextField("");
        t4=new JTextField("");
        b1=new JButton("Save");
        b2=new JButton("Cancel");
        l1.setBounds(180,30,120,40);
        l2.setBounds(60,100,120,40);
        l3.setBounds(60,150,120,40);
        l4.setBounds(60,200,120,40);
        l5.setBounds(60,250,120,40);
        t1.setBounds(200,100,120,40);
        t2.setBounds(200,150,120,40);
        t3.setBounds(200,200,120,40);
        t4.setBounds(200,250,120,40);
        b1.setBounds(80,300,120,40);
        b2.setBounds(210,300,120,40);
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            c=DriverManager.getConnection("jdbc:ucanaccess://E://DB.accdb");		
            es=c.createStatement();
            ResultSet rs=es.executeQuery("select * from supplier");
            while(rs.next())
            {
                t1.addItem(rs.getString(2));
            }
            ResultSet rs1=es.executeQuery("select * from product");
            while(rs1.next())
            {
                t2.addItem(rs1.getString(3));
            }
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
        add(t1);
        add(t2);
        add(t3);
        add(t4);
        add(b1);
        add(b2);
    }
    public  void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==b1)
       {
           try{
            String a=t1.getSelectedItem().toString();
            String b=t2.getSelectedItem().toString();
            String c=t3.getText(); // Quantity
            int qty=Integer.parseInt(c);
            String d=t4.getText();
            es.execute("insert into sales(suppliername,pname,pquantity,price)values('"+a+"','"+b+"','"+c+"','"+d+"')");
            
            es.execute("update product set pquantity=pquantity-"+qty+" where pname='"+b+"'");
            JOptionPane.showMessageDialog(null,"Sales Added");
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
        addseller ob=new addseller();
        ob.setSize(400,400);
        ob.setVisible(true);
    }
}
    

