package Finalpr;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.*;
public class salesreportdetails extends JFrame{
	String s;
	DefaultTableModel dm;
	JLabel l;
	JTable jTable1;
	String header[]=new String[]{"ID","Supplier Name","Product Name","Quantity","Price","Total"};
    public salesreportdetails(String sn)
    {
        dm=new DefaultTableModel(0,0);
        l=new JLabel("Sales Report");
        l.setFont(new Font("Arial",Font.PLAIN,20));
        s=sn;
	setLayout(new FlowLayout());	
        
	jTable1=new JTable(){	
            public boolean isCellEditable(int row,int column){
		return false;
            }
	};
	dm.setColumnIdentifiers(header);	
        
        try{ 
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection c=DriverManager.getConnection("jdbc:ucanaccess://E://DB.accdb");		
            Statement es=c.createStatement();
            ResultSet rs=es.executeQuery("select * from sales where suppliername='"+s+"'");
            int sum=0;
            while(rs.next()){	
                int qty=Integer.parseInt(rs.getString(4));
                int price=Integer.parseInt(rs.getString(5));
                int total=qty*price;
                sum=sum+total;
		dm.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),String.valueOf(total)});		
            }
            dm.addRow(new Object[]{"","","","","Grand Total = ",String.valueOf(sum)});		
        }
        catch(Exception e) { System.out.println(e); }
        jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTable1.setModel(dm);	 
        add(l);
        add(new JScrollPane(jTable1));    
    }    
    public static void main(String ar[])
    {
    }
}


        

         

