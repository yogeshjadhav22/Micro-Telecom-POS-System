import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

 class SaleReportDateForm
{
	
	JButton b1,b2,b3,b4;
	JLabel l1,t1;
	JFrame f;
	JTextField t2,t3,t4,t5,t6,t7,t8,t9,t10;
	Font f1,f2,f3,f4,f5;
	JPanel p;
	JComboBox cb1,cb2,cb3;
	JScrollPane jsp1;
	ButtonGroup brg,brg1;
	JRadioButton r1,r2,r3,r4,r5;
	int curdate;
	Connection con;
	JTable tab;
	DefaultTableModel dtm;
	public SaleReportDateForm(String str, String str2) 
	 {
		f=new JFrame("Sale Report");
		f.setSize(1366,768);
		f.setResizable(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JLabel fm=new JLabel(new ImageIcon("D:\\Project\\Images\\BackGround.jpg"));
		fm.setBounds(0, 0,1366,760);
		JScrollPane jsp=new JScrollPane(fm);
		jsp.setBounds(0, 0,1366,760);
		JLabel header=new JLabel(new ImageIcon("D:\\Project\\Images\\headerVD.jpg"));
		header.setBounds(0,0,1455,161);
		fm.add(header);
		
		f.setLayout(null);
		f1=new Font("Baskerville Old Face",Font.BOLD,22);
		f2=new Font("Baskerville Old Face",Font.PLAIN,18);
		f3=new Font("Baskerville Old Face",Font.BOLD,20);
		f4=new Font("Baskerville Old Face",Font.BOLD,15);
		f5=new Font("Baskerville Old Face",Font.BOLD,21);
		
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																				
		l1=new JLabel("Date");
		l1.setBounds(1000,166,200,35);
		l1.setFont(f1);
		l1.setForeground(Color.BLACK);		
		fm.add(l1);
		
		t1=new JLabel();
		t1.setBounds(1065,170,120,28);
		t1.setFont(f2);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calobj = Calendar.getInstance();
		t1.setText(df.format(calobj.getTime()));
		t1.setEnabled(true);
		fm.add(t1);
		tab=new JTable();
		jsp1=new JScrollPane(tab);
		tab.setFont(f1);
		
		dtm=new DefaultTableModel();
	
		jsp1.setBounds(100,200,1150,300);
		f.add(jsp);
		fm.add(jsp1);
		f.setVisible(true);		
	 }

	
	

	 		 	
}


class SaleReportDate
{
	public static void main(String arg[])
	{
		new SaleReportDateForm("2016","type");
	}
}