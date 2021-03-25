package Finalpr;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class salesreport extends JFrame implements ActionListener {
    JLabel l1,l2;
    JComboBox t1;
    JButton b1,b2;
    Connection c;
    Statement es;
    salesreport()
    {
        setLayout(null);
        l1=new JLabel("Show Report");
        l2=new JLabel("Select Supplier");
        t1=new JComboBox();
        b1=new JButton("Show Report");
        b2=new JButton("Cancel");
        l1.setBounds(110,20,120,40);
        l2.setBounds(20,100,80,40);
        t1.setBounds(100,100,120,40);
        b1.setBounds(30,200,120,40);
        b2.setBounds(150,200,120,40);
        
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
         }
         catch(Exception e)
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
        public void actionPerformed(ActionEvent ae)
        {
            if(ae.getSource()==b1)
            {
                try{
                    String sn=t1.getSelectedItem().toString();
                    // code 
					salesreportdetails ob=new salesreportdetails(sn);
					ob.setSize(480,400);
					ob.setVisible(true);
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
            salesreport ob=new salesreport();
            ob.setSize(330,400);
            ob.setVisible(true);
        }

}
        

         

