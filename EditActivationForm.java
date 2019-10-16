import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

class EditActivation implements ActionListener,KeyListener
{
	
	
	Connection con;
	boolean check=true;
	String cnn,cnoc,addc,genc,cnno,poic,poinoc,frcc, pac,datec;
	Font f1;
	JButton b1,b2,b3,b4,b5,b6,b7;
	JFrame f;
	JTextField t7;
	JLabel cn;
	JTable tab;
	JScrollPane jsp;
	DefaultTableModel dtm;
	ResultSet rs=null;
	int count=0;
	String s[]=new String[4];
	 public EditActivation()
	 {
	 
	 	f=new JFrame("POS - Edit");
		f.setSize(1366,768);
		f.setResizable(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel fm=new JLabel(new ImageIcon("D:\\Project\\Images\\BackGround.jpg"));
		fm.setBounds(0,00,1366,768);
		JLabel header=new JLabel(new ImageIcon("D:\\Project\\Images\\headernew.jpg"));
		header.setBounds(0,0,1455,161);
		fm.add(header);
		
		f.setLayout(null);
		f1=new Font("Arial",Font.BOLD,16);
		
		tab=new JTable();
		jsp=new JScrollPane(tab);
		fm.add(jsp);
		tab.setFont(f1);
		
		//tab.setRowSelectionAllowed(true);
		//tab.setColumnSelectionAllowed(false);
		//tab.addAncestorListener(this);
		dtm=new DefaultTableModel();
		jsp.setBounds(350,200,900,300);
		
		dtm.addColumn("Customer Name");
		dtm.addColumn("New Number");
		dtm.addColumn("Date");
		jsp.setBackground(Color.white);
		tab.setBackground(Color.white);
		tab.setModel(dtm);
		tab.setRowSelectionAllowed(true);
		dtm.addTableModelListener(tab);
		
		cn=new JLabel("Enter Customer Name ");
		cn.setFont(f1);
		cn.setBounds(35,250,250,35);
	
		
		t7=new JTextField(10);
		t7.setBounds(35,300,250,35);
		t7.setFont(f1);
		
		
		
	/*b1=new JButton("Previous");
		b1.setBounds(455,600,95,35);
		b1.addActionListener(this);*/
	
	
		b2=new JButton("Next");
		b2.setBounds(745,600,108,35);
		b2.addActionListener(this);
		b2.addKeyListener(this);
		b2.setVisible(false);
		
		b3=new JButton("Back");
		b3.setBounds(10,10,108,35);
		b3.addActionListener(this);
		
	
		b4=new JButton("Search");
		b4.setBounds(55,355,95,35);
		b4.addActionListener(this);
	
		b5=new JButton("Show All");
		b5.setBounds(160,355,95,35);
		b5.addActionListener(this);
			
		
		b6=new JButton("Show Details");
		b6.addActionListener(this);
		b6.setBounds(745,600,108,35);

		b7=new JButton("Edit");
		b7.addActionListener(this);
		b7.setBounds(600,600,108,35);
		
		
	
		
		
		header.add(b3);
		
		
		
	//	f.add(fm);
		fm.add(jsp);
		fm.add(cn);
		fm.add(t7);
		//fm.add(b1);
		fm.add(b2);
		fm.add(b3);
		fm.add(b4);
		fm.add(b5);
		fm.add(b6);
		fm.add(b7);
		
		f.add(fm);
		
		f.setVisible(true);		
	 }
	 public void actionPerformed(ActionEvent e)
	 {
	 	 
		 if(e.getSource()==b4)
		 {
			
			 cnn=t7.getText();
			 
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/micropos","root","");
				PreparedStatement pst=con.prepareStatement("select * from Activation where Cname=?");
				pst.setString(1,cnn);
				ResultSet rs=pst.executeQuery();
				while(rs.next())
				{
					s[0]=rs.getString(1);
					s[1]=rs.getString(5);
					s[3]=rs.getString(10);
					
					dtm.addRow(s);
				}
				
			}
			catch(Exception ee)
			{
				System.out.println(s);
			}
		 }			
			
		 
		 
		 
		 if(e.getSource()==b3)
	 	 {
	 		 
	 		 new MainForm();
	 		f.setVisible(false);
	 	 }
		 if(e.getSource()==b5)
	 	 {
	 		  
	 		new AllResultForm(cnn,f);
	 		f.setVisible(false);
	 	 }
		 if(e.getSource()==b7)
		 {

		      int rowIndex = tab.getSelectedRow();
		      int colIndex = tab.getSelectedColumn();
		     
		      System.out.println(rowIndex+"  " +colIndex);
		      Object o=dtm.getValueAt(rowIndex,1);
		      System.out.println(o);
		 }
	 	
	 
	 }	
	 public void keyPressed(KeyEvent e)
	 {
		
		
	}
	public void keyReleased(KeyEvent e)
	{}
	public void keyTyped(KeyEvent e)
	{}
	
}


class EditActivationForm
{
	public static void main(String arg[])
	{
		new EditActivation();
	}
}