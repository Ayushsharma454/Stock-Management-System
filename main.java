package Finalpr;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.*;
public class main extends JFrame implements ActionListener {
    public static void main(String[] s) {
        new main();
    }
    public main() {
        		
        super("Stock Management");

        // Name the JMenu & Add Items
        JMenu menu = new JMenu("Category Manager");
        JMenuItem m1=new JMenuItem("Add Category");
        m1.addActionListener(this);
        menu.add(m1);
        
        JMenuItem m2=new JMenuItem("Edit Category");
         m2.addActionListener(this);
        menu.add(m2);
        
        JMenuItem m3=new JMenuItem("Delete Category");
         m3.addActionListener(this);
        menu.add(m3);
        
        JMenu menu1=new JMenu("Supplier Manager");
         JMenuItem m4=new JMenuItem("Add Supplier");
         m4.addActionListener(this);
        menu1.add(m4);
        
         JMenuItem m5=new JMenuItem("Edit Supplier");
         m5.addActionListener(this);
        menu1.add(m5);
        
          JMenuItem m5a=new JMenuItem("Delete Supplier");
         m5a.addActionListener(this);
        menu1.add(m5a);
         
        
        JMenu menu2=new JMenu("Sales Manager");
        JMenuItem m6=new JMenuItem("Add Sales");
        m6.addActionListener(this);
        menu2.add(m6);
        
        JMenuItem m7=new JMenuItem("Edit Sales");
        m7.addActionListener(this);
        menu2.add(m7);
        
        JMenuItem m8=new JMenuItem("Delete Sales");
        m8.addActionListener(this);
        menu2.add(m8);
        
        JMenu menu3=new JMenu("Product");
        JMenuItem m9=new JMenuItem("Add Product");
        m9.addActionListener(this);
        menu3.add(m9);
        
        JMenuItem m10=new JMenuItem("Edit Product");
        m10.addActionListener(this);
        menu3.add(m10);
        
        JMenuItem m11=new JMenuItem("Delete Product");
        m11.addActionListener(this);
        menu3.add(m11);
        
        
        JMenu report=new JMenu("Report");
        JMenuItem mr=new JMenuItem("Sales Report");
        mr.addActionListener(this);
        report.add(mr);
        
        //Add JMenu bar
       JMenuBar menuBar = new JMenuBar();
        menuBar.add(menu);
        
        menuBar.add(menu1);
        menuBar.add(menu2);
        menuBar.add(menu3);
        menuBar.add(report);
        setContentPane(new JLabel(new ImageIcon("back.jpg")));
        setJMenuBar(menuBar);
        setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        setLocation(0,0);
        setVisible(true);
        
    }
 
    public void actionPerformed(ActionEvent e) {
 
        // Menu item actions
        String command = e.getActionCommand();
 
        if (command.equals("Quit")) {
            System.exit(0);
        } 
            else if (command.equals("Add Category")) {
            
                addcategory ob=new addcategory();
                ob.setSize(400,400);
                ob.setVisible(true);
                ob.setLocation(250, 200);
            }
            else if(command.equals("Edit Category"))
            {
                editcategory ob=new editcategory();
                ob.setSize(400,400);
                ob.setVisible(true);
                ob.setLocation(250, 200);
            }
            else if(command.equals("Delete Category"))
            {
                deletecategory ob=new deletecategory();
                ob.setSize(400,400);
                ob.setVisible(true);
                ob.setLocation(250, 200);
            }
        else if (command.equals("Add Supplier")) {
            
                addsupplier ob=new addsupplier();
                ob.setSize(400,450);
                ob.setVisible(true);
                ob.setLocation(250, 200);
            }
            else if(command.equals("Edit Supplier"))
            {
                editsupplier ob=new editsupplier();
                ob.setSize(500,500);
                ob.setVisible(true);
                ob.setLocation(250, 200);
            }
            else if(command.equals("Delete Supplier"))
            {
                deletesupplier ob=new deletesupplier();
                ob.setSize(400,400);
                ob.setVisible(true);
                ob.setLocation(250, 200);
            }
        
        
        else if (command.equals("Add Sales")) {
            
                addseller ob=new addseller();
                ob.setSize(400,400);
                ob.setVisible(true);
                ob.setLocation(250, 200);
            }
            else if(command.equals("Edit Sales"))
            {
                editseller ob=new editseller();
                ob.setSize(500,500);
                ob.setVisible(true);
                ob.setLocation(250, 200);
            }
            else if(command.equals("Delete Sales"))
            {
                deleteseller ob=new deleteseller();
                ob.setSize(400,400);
                ob.setVisible(true);
                ob.setLocation(250, 200);
            }
        else if (command.equals("Add Product")) {
            
                addproduct ob=new addproduct();
                ob.setSize(400,400);
                ob.setVisible(true);
                ob.setLocation(250, 200);
            }
            else if(command.equals("Edit Product"))
            {
                editproduct ob=new editproduct();
                ob.setSize(500,500);
                ob.setVisible(true);
                ob.setLocation(250, 200);
            }
            else if(command.equals("Delete Product"))
            {
                deleteproduct ob=new deleteproduct();
                ob.setSize(400,400);
                ob.setVisible(true);
                ob.setLocation(250, 200);
            }
        else if(command.equals("Sales Report"))
            {
                salesreport ob=new salesreport();
                ob.setSize(400,400);
                ob.setVisible(true);
                ob.setLocation(250, 200);
            }
            
    }
}