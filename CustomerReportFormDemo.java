import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

class CustomerReportForm
{
	
	JButton b1,b2,b3;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,li,lr,erno1,erno2;
	JFrame f;
	JTextField t1,t2,t3,t4,t5,t6;
	Font f1,f2,f3,f4,f5;
	JComboBox cb1,cb2,cb3;
	JRadioButton r1,r2;
	
	
	 public CustomerReportForm()
	 {
	 
	 	f=new JFrame("POS - Reports");
		f.setSize(1366,768);
		f.setResizable(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel fm=new JLabel(new ImageIcon("D:\\Project\\Images\\BackGround.jpg"));
		fm.setBounds(0,00,1366,768);
		JLabel header=new JLabel(new ImageIcon("D:\\Project\\Images\\headerReport.jpg"));
		header.setBounds(0,0,1455,161);
		fm.add(header);
		
		f.setLayout(null);
		f1=new Font("Arial",Font.BOLD,20);
		f2=new Font("Arial",Font.BOLD,18);
		f3=new Font("Cooper Black",Font.BOLD,25);
		f4=new Font("Arial",Font.BOLD,16);
		f5=new Font("Arial",Font.ITALIC,20);
		
		
		
		li=new JLabel("Information Of Customer");
		li.setFont(f3);
		li.setBounds(100,170,400,35);
		
		erno1=new JLabel("Invalid");
		erno1.setForeground(Color.RED);
		erno1.setVisible(false);
		erno1.setFont(f5);

		erno1.setBounds(1100,305,250,35);

		
		erno2=new JLabel("Invalid");
		erno2.setForeground(Color.RED);
		erno2.setVisible(false);
		erno2.setFont(f5);	
		erno2.setBounds(600,285,250,35);//350,230,250,35
		
			
		l1=new JLabel("Date");
		l1.setBounds(1000,170,100,35);
		l1.setFont(f1);
		
		
		l2=new JLabel("Genrate Report");
		l2.setBounds(700,300,250,35);
		l2.setFont(f1);
		
		l3=new JLabel("Search Customer");
		l3.setBounds(100,230,250,35);
		l3.setFont(f1);
	
		l4=new JLabel("Alternate Number");
		l4.setBounds(100,280,250,35);
		l4.setFont(f1);
	
		l5=new JLabel("Address");
		l5.setBounds(100,380,250,35);
		l5.setFont(f1);
	
		l6=new JLabel("FRC");
		l6.setBounds(700,340,250,35);
		l6.setFont(f1);
	
		l7=new JLabel("POI Number");
		l7.setBounds(700,390,250,35);
		l7.setFont(f1);
		
		l8=new JLabel("POI");
		l8.setBounds(700,440,250,35);
		l8.setFont(f1);
		
		l9=new JLabel("Gender");
		l9.setBounds(100,330,250,35);
		l9.setFont(f1);
		
		l10=new JLabel("Address Proof");
		l10.setBounds(700,490,250,35);
		l10.setFont(f1);
		l10.setVisible(false);
		
		t1=new JTextField(10);
		t1.setBounds(1050,170,120,28);
		t1.setFont(f2);
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Calendar calobj = Calendar.getInstance();
		t1.setText(df.format(calobj.getTime()));
		t1.setEditable(false);
		
		t2=new JTextField(10);
		t2.setBounds(850,300,250,35);
		t2.setFont(f2);
	
		t3=new JTextField(10);
		t3.setBounds(350,230,250,35);	
		t3.setFont(f2);
	
		t4=new JTextField(10);
		t4.setBounds(350,280,250,35);
		t4.setFont(f2);
	
		t5=new JTextField(10);
		t5.setBounds(850,390,250,35);//POI NUMBER
		t5.setFont(f2);
	
		t6=new JTextField(10);
		t6.setBounds(350,380,250,35);//Address
		t6.setFont(f2);

		cb1=new JComboBox();
		cb1.addItem("Adhar Card");	
		cb1.addItem("Voting Card");	
		cb1.addItem("PAN Card");	
		
		cb1.setBounds(850,440,90,30);
		
		cb2=new JComboBox();
		cb2.addItem("34");	
		cb2.addItem("51");	
		cb2.addItem("65");	
		cb2.addItem("101");	
		cb2.addItem("179");	
	
		
		cb2.setBounds(850,340,90,30);
		
		cb3=new JComboBox();
		cb3.addItem("Bank Passbook");
		cb3.addItem("Rashan Card");
		
		cb3.setBounds(850,490,90,35);
		cb3.setVisible(false);
		
		r1=new JRadioButton("Male");
		r1.setFont(f4);
		r1.setBounds(350,330,60,35);
		
		r2=new JRadioButton("Female");
		r2.setFont(f4);
		r2.setBounds(410,330,80,35);
		

		b1=new JButton("Submit");
		b1.setBounds(410,600,80,35);
		
		b2=new JButton("Clear");
		b2.setBounds(580,600,80,35);
			
		b3=new JButton("Back");
		b3.setBounds(745,600,80,35);
			
		
	
		
		fm.add(b1);
		fm.add(b2);
		fm.add(b3);
	
		
		fm.add(li);
		fm.add(l1);
		fm.add(l2);
		fm.add(l3);
		fm.add(l4);
		fm.add(l5);
		fm.add(l6);
		fm.add(l7);
		fm.add(l8);
		fm.add(l9);
		fm.add(t1);
		fm.add(t2);
		fm.add(t3);
		fm.add(t4);
		fm.add(t5);
		fm.add(t6);
		fm.add(cb1);
		fm.add(cb2);
		fm.add(cb3);
		fm.add(r1);
		fm.add(r2);
		fm.add(erno1);
		fm.add(erno2);
		fm.add(l10);
		
		
		f.add(fm);
		f.setVisible(true);		
	 }

	 	
}


class CustomerReportFormDemo
{
	public static void main(String arg[])
	{
		new CustomerReportForm();
	}
}