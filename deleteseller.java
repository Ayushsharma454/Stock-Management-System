package Finalpr;

import java.awt.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class deleteseller extends JFrame implements ActionListener {
     JLabel l1,l2;
    JTextField t1;
    JButton b1,b2;
    Connection c;
    Statement s;
    deleteseller()
    {
        setLayout(null);
        l1=new JLabel("Delete seller");
        l2=new JLabel("Enter Id");
        t1=new JTextField("");
        b1=new JButton("Delete");
        b2=new JButton("Cancel");
        l1.setBounds(110,20,120,40);
        l2.setBounds(20,100,80,40);
        t1.setBounds(100,100,120,40);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b1.setBounds(30,200,120,40);
        b2.setBounds(150,200,120,40);
        
         try{
             Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            c=DriverManager.getConnection("jdbc:ucanaccess://E://DB.accdb");		
            s=c.createStatement();
        }
         catch(Exception is){ System.out.println(is); }
         
         setContentPane(new JLabel(new ImageIcon("back.jpg")));
         add(l1);
        add(l2);
        add(t1);
        add(b1);
        add(b2);
    }
        public void actionPerformed(ActionEvent ae)
        {
            if(ae.getSource()==b1)
            {
                try{
                    int id=Integer.parseInt(t1.getText());
                    s.execute("delete from sales where ID="+id);
                    JOptionPane.showMessageDialog(null,"Record Deleted");
                }
                catch(Exception s){ System.out.println(s); }
            }
            if(ae.getSource()==b2)
            {
                System.exit(0);
            }
        } 
        public static void main(String ar[])
        {
            deleteseller ob=new deleteseller();
            ob.setSize(330,400);
            ob.setVisible(true);
        }
}
    


    



