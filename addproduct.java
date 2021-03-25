
package Finalpr;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class addproduct extends JFrame implements ActionListener {
     JLabel l1,l2,l3,l4,l5;
     JTextField t2,t3,t4;
     JButton b1,b2;
     JComboBox t1;
     Connection c;
     Statement es;
     addproduct()
     {
       setLayout(null);
       l1=new JLabel("Add product");
       l2=new JLabel("Select Category");
       l3=new JLabel("Product name");
       l4=new JLabel("Product quantity");
       l5=new JLabel("Price");
       t1=new JComboBox();
       t2=new JTextField("");
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
            ResultSet rs=es.executeQuery("select * from category");
            while(rs.next())
            {
                t1.addItem(rs.getString(2));
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
            String b=t2.getText();
            String c=t3.getText();
            String d=t4.getText();
            es.execute("insert into product(categoryid,pname,pquantity,supplier)values('"+a+"','"+b+"','"+c+"','"+d+"')");
            JOptionPane.showMessageDialog(null,"Product Added");
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
       addproduct ob=new addproduct();
       ob.setSize(400,400);
       ob.setLocation(300,300);
       ob.setVisible(true);
    }
}
    

