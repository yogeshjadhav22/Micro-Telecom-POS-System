import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

 class StockCheck implements ActionListener,ItemListener,KeyListener
{
	
	JButton b1,b2,b3,b7;
	JLabel t1,l1;
	JFrame f;
	Font f1,f2,f3,f4,f5;
	JPanel p,p1,p2;
	JScrollPane jsp1,jsp2,jsp3;
	ButtonGroup brg;
	DefaultTableModel dtm1,dtm2,dtm3;
	JTable tab1,tab2,tab3;
	String s[];
	public StockCheck()
	 {
	 
	 	

		f=new JFrame("POS - Stock In");
		f.setSize(1366,768);
		f.setResizable(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JLabel fm=new JLabel(new ImageIcon("D:\\Project\\Images\\BackGround.jpg"));
		fm.setBounds(0, 0,1366,760);
		JScrollPane jsp=new JScrollPane(fm);
		jsp.setBounds(0, 0,1366,760);
		
		b7=new JButton("Back");
		b7.setBounds(10,10,100,35);
		b7.addActionListener(this);
	
		JLabel header=new JLabel(new ImageIcon("D:\\Project\\Images\\headerVD.jpg"));
		header.setBounds(0,0,1455,161);
		header.add(b7);
		fm.add(header);
		
		f.setLayout(null);
		f1=new Font("Lucida Fax",Font.PLAIN,16);
		f2=new Font("Arial",Font.PLAIN,18);
		f3=new Font("Lucida Fax",Font.BOLD,20);
		f4=new Font("Arial",Font.BOLD,16);
		f5=new Font("Lucida Fax",Font.BOLD,15);
		
		tab1 = new JTable();
		jsp1=new JScrollPane(tab1);
		
		tab1.setFont(f1);
		
		dtm1=new DefaultTableModel();
		jsp1.setBounds(1,1,700,100);
		
		dtm1.addColumn("S I M");
		dtm1.addColumn("Voucher");
		dtm1.addColumn("E Balance");
		dtm1.addColumn("Stock In Date");
		jsp1.setBackground(Color.white);
		tab1.setBackground(Color.white);
		tab1.setModel(dtm1);
		


		tab2 = new JTable();
		jsp2=new JScrollPane(tab2);
		
		tab2.setFont(f1);
		
		dtm2=new DefaultTableModel();
		jsp2.setBounds(1,1,700,100);
		
		dtm2.addColumn("Data");
		dtm2.addColumn("SMS");
		dtm2.addColumn("Voice");
		dtm2.addColumn("TopUP");
		dtm2.addColumn("Stock In Date");
		jsp2.setBackground(Color.white);
		tab2.setBackground(Color.white);
		tab2.setModel(dtm2);
		
		
		tab3 = new JTable();
		jsp3=new JScrollPane(tab3);
		
		tab3.setFont(f1);
		
		dtm3=new DefaultTableModel();
		jsp3.setBounds(1,1,700,100);
		
		dtm3.addColumn("Prepaid SIM");
		dtm3.addColumn("Postpaid SIM");
		dtm3.addColumn("Total");
		dtm3.addColumn("Stock In Date");
		jsp3.setBackground(Color.white);
		tab3.setBackground(Color.white);
		tab3.setModel(dtm3);
		
		
		p=new JPanel();
	//	p.setSize(700,700);
		
		p.setVisible(false);
		p.setBackground(Color.white);
		p.setLayout(null);
		p.setBounds(400,300,700,100);
		p.add(jsp1);
		p1=new JPanel();
				
		p1.setVisible(false);
		p1.setBackground(Color.white);
		p1.setLayout(null);
		p1.setBounds(400,300,700,100);
		p1.add(jsp2);		
		p2=new JPanel();
			
		p2.setVisible(false);
		p2.setBackground(Color.white);
		p2.setLayout(null);
		p2.setBounds(400,300,700,100);
		p2.add(jsp3);		
				
		
		l1=new JLabel("Date");
		l1.setBounds(1000,166,200,35);
		l1.setFont(f1);
		l1.setForeground(Color.BLACK);		
		
		
		
		
		
		t1=new JLabel();
		t1.setBounds(1050,170,120,28);
		t1.setFont(f2);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calobj = Calendar.getInstance();
		t1.setText(df.format(calobj.getTime()));
	//	t1.setEditable(false);
		
		
		b1=new JButton("A L L");
		b1.setBounds(100,300,100,35);
		b1.addActionListener(this);
	
		b2=new JButton("Voucher");
		b2.setBounds(100,400,100,35);
		b2.addActionListener(this);
	
		b3=new JButton("S I M");
		b3.setBounds(100,500,100,35);
		b3.addActionListener(this);

		
		fm.add(b1);
		fm.add(b2);
		fm.add(b3);
		
		fm.add(l1);
		fm.add(t1);
		fm.add(p);
		fm.add(p1);
		fm.add(p2);
		
		
		f.add(jsp);
		//f.add(fm);
		f.setVisible(true);		
	 }

	
	public void keyPressed(KeyEvent e) 
	{
				
	}

	
	public void keyReleased(KeyEvent e)
	{
		
		
	}

	
	public void keyTyped(KeyEvent e) 
	{
	
		
	}

	public void itemStateChanged(ItemEvent e) 
	{
		
		
	}

	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
			try
			{	
				s=new String[7];
				p1.setVisible(false);
				p.setVisible(true);
				p2.setVisible(false);Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/micropos","root","");
				PreparedStatement stmt1=con.prepareStatement("select * From Stock");
				ResultSet rs=stmt1.executeQuery();
				while(rs.next())
				{
					int a=rs.getInt(1)+rs.getInt(2);
				
					s[0]="         "+a;
					s[1]="         "+rs.getInt(3);
					s[2]="         "+rs.getString(4);
					s[3]="    "+rs.getString(5);
					dtm1.addRow(s);
				}
			}
			catch(Exception ee)
			{
				System.out.println(ee);
				
			}
			
		}
		if(e.getSource()==b2)
		{
			try
			{	
				s=new String[7];
				p1.setVisible(true);
				p.setVisible(false);
				p2.setVisible(false);Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/micropos","root","");
				PreparedStatement stmt1=con.prepareStatement("select * From VoucherIn");
				ResultSet rs=stmt1.executeQuery();
				while(rs.next())
				{
					s[0]="         "+rs.getInt(1);
					s[1]="         "+rs.getInt(2);
					s[2]="         "+rs.getInt(3);
					s[3]="         "+rs.getString(4);
					s[4]="    "+rs.getString(5);
					dtm2.addRow(s);
				}
			}
			catch(Exception ee)
			{
				System.out.println(ee);
				
			}
			
		}
		if(e.getSource()==b3)
		{
			
			try
			{	
				s=new String[7];
				p1.setVisible(false);
				p.setVisible(false);
				p2.setVisible(true);
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/micropos","root","");
				PreparedStatement stmt1=con.prepareStatement("select * From SIM");
				ResultSet rs=stmt1.executeQuery();
				while(rs.next())
				{
					int a=rs.getInt(1);
					int b=rs.getInt(2);
					int q=a+b;
					s[0]="           "+a;
					s[1]="           "+b;
					s[2]="           "+q;
					s[3]="    "+rs.getString(3);
					dtm3.addRow(s);
				}
			}
			catch(Exception ee)
			{
				System.out.println(ee);
				
			}
		}
		
		
		
		if(e.getSource()==b7)
		{
			new MainForm();
			f.setVisible(false);
		}
	}
	 		 	
}


class StockCheckFrom
{
	public static void main(String arg[])
	{
		new StockCheck();
	}
}