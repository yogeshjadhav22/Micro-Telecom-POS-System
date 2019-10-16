import javax.swing.*;
import javax.swing.border.Border;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

 class SaleReport implements ActionListener,ItemListener,KeyListener
{
	
	JButton b1,b2,b3,b4;
	JLabel t1,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,erno1,erno2,erno3,erno4;
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
	public SaleReport() 
	 {
		f=new JFrame("POS - Stock In");
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
		
		p=new JPanel();
		p.setBackground(Color.white);
		p.setLayout(null);
		p.setBounds(420,260,600,400);
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																				
		l1=new JLabel("Date");
		l1.setBounds(1000,166,200,35);
		l1.setFont(f1);
		l1.setForeground(Color.BLACK);		
		fm.add(l1);
		
		t1=new JLabel();
		t1.setBounds(1050,170,120,28);
		t1.setFont(f2);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calobj = Calendar.getInstance();
		t1.setText(df.format(calobj.getTime()));
		fm.add(t1);
				
		t2=new JTextField(10);
		t2.setBounds(130,99,100,27);
		p.add(t2);
		//t2.setText("yyyy-MM-dd");
		t2.setFont(f4);
		t3=new JTextField(10);
		t3.setBounds(330,99,100,27);
		//t3.setText("yyyy-MM-dd");
		t3.setFont(f4);
		t3.setVisible(false);
		t2.setVisible(false);
		p.add(t3);
		
		t2.addKeyListener(this);
		t3.addKeyListener(this);
		p.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(3.0f),Color.blue));
		l2=new JLabel("Select Type");
		l2.setFont(f5);
		l2.setBounds(130,30,200,30);
		l2.setForeground(Color.getColor(null, 1000));
		p.add(l2);
		
		r1=new JRadioButton("Daily");
		r1.setFont(f4);
		r1.setBounds(250,30,80,30);
		p.add(r1);
		r1.setBackground(Color.white);
		r1.setForeground(Color.RED);
		r1.addItemListener(this);
		r2=new JRadioButton("Date");
		r2.setFont(f4);
		r2.setBounds(328,30,80,30);
		r2.setBackground(Color.white);
		r2.setForeground(Color.RED);
		p.add(r2);
		r2.addItemListener(this);
		
		brg=new ButtonGroup();
		brg.add(r2);
		brg.add(r1);
		
		r3=new JRadioButton("SIM");
		r3.setFont(f4);
		r3.setBounds(200,150,80,30);
		r3.setBackground(Color.white);
		r3.setForeground(Color.RED);
		p.add(r3);
		r3.setVisible(false);
		r4=new JRadioButton("Voucher");
		r4.setFont(f4);
		r4.setBounds(200,180,100,30);
		r4.setBackground(Color.white);
		r4.setForeground(Color.RED);
		p.add(r4);
		r4.setVisible(false);
				
		r5=new JRadioButton("E-Balance");
		r5.setFont(f4);
		r5.setBounds(200,205,100,30);
		r5.setBackground(Color.white);
		r5.setForeground(Color.RED);
		p.add(r5);
		r5.setVisible(false);
		
		brg1=new ButtonGroup();
		brg1.add(r3);
		brg1.add(r4);
		brg1.add(r5);
		
		l3=new JLabel("Enter Date");
		l3.setBounds(130,99,200,30);
		l3.setFont(f1);
		p.add(l3);
		l3.setVisible(false);
		l3.setForeground(Color.getColor(null,1000));
		cb1=new JComboBox();
		
		
		cb1.setBounds(250,100,40,25);
		cb1.addItem("1");
		cb1.addItem("2");
		cb1.addItem("3");
		cb1.addItem("4");
		cb1.addItem("5");
		cb1.addItem("6");
		cb1.addItem("7");
		cb1.addItem("8");
		cb1.addItem("9");
		cb1.addItem("10");
		cb1.addItem("11");
		cb1.addItem("12");
		cb1.addItem("13");
		cb1.addItem("14");
		cb1.addItem("15");
		cb1.addItem("16");
		cb1.addItem("17");
		cb1.addItem("18");
		cb1.addItem("19");
		cb1.addItem("20");
		cb1.addItem("21");
		cb1.addItem("22");
		cb1.addItem("23");
		cb1.addItem("24");
		cb1.addItem("25");
		cb1.addItem("26");
		cb1.addItem("27");
		cb1.addItem("28");
		cb1.addItem("29");
		cb1.addItem("30");
		cb1.addItem("31");
		p.add(cb1);
		
		cb2=new JComboBox();
		cb2.addItem("1");
		cb2.addItem("2");
		cb2.addItem("3");
		cb2.addItem("4");
		cb2.addItem("5");
		cb2.addItem("6");
		cb2.addItem("7");
		cb2.addItem("8");
		cb2.addItem("9");
		cb2.addItem("10");
		cb2.addItem("11");
		cb2.addItem("12");
		cb2.addItemListener(this);
		cb2.setBounds(310,100,40,25);
		
		//cb2.setBackground(Color.white);
		p.add(cb2);
		
		
		cb3=new JComboBox();
		cb3.addItem("2015");
		cb3.addItem("2016");
		cb3.addItem("2017");
		cb3.addItemListener(this);
		cb3.setBounds(370,100,70,25);
		
		DateFormat df1 = new SimpleDateFormat("yyyy");
		Calendar calobj1 = Calendar.getInstance();
		String da=df1.format(calobj1.getTime());
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
		
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/micropos","root","");
			PreparedStatement pst=con.prepareStatement("select * from ch");
			ResultSet rs=pst.executeQuery();
			rs.next();
		curdate=rs.getInt(1);	
		if(Integer.parseInt(da)>curdate)
		{
			
			curdate++;
			for(int i=curdate;i<=Integer.parseInt(da);i++)
			{
				cb3.addItem(""+i);	
			}
			
			PreparedStatement pst1;
			
			
				pst1 = con.prepareStatement("update ch set date=?");
				pst1.setInt(1,Integer.parseInt(da));
			
		}
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		
		
		b1=new JButton("View");
		b1.setBounds(170,300,80,30);
		b1.addActionListener(this);
		b1.setVisible(false);
		b2=new JButton("Cancel");
		b2.setBounds(370,300,80,30);
		b2.addActionListener(this);
		b2.setVisible(false);
		p.add(b1);
		p.add(b2);
		b1.setBackground(Color.white);
		b2.setBackground(Color.white);
		
		p.add(cb3);
		cb3.setVisible(false);
		cb1.setVisible(false);
		cb2.setVisible(false);
		
		f.add(jsp);
		fm.add(p);
		f.setVisible(true);		
	 }

	
	public void keyPressed(KeyEvent e) 
	{
		if(Character.isAlphabetic(e.getKeyChar()))
		{
			JOptionPane.showMessageDialog(null, "Character Not Allowed","Error",JOptionPane.ERROR_MESSAGE);
		}
		if(Character.isDigit(e.getKeyChar()))
		{
			String da=t2.getText();
			String da1=t3.getText();
			if(da.length()==4)
			{
				t2.setText(da+"-");
			}
			if(da.length()==7)
			{
				t2.setText(da+"-");
			}
			if(da1.length()==4)
			{
				t3.setText(da1+"-");
			}
			if(da1.length()==7)
			{
				t3.setText(da1+"-");
			}
			if(t2.getText().length()>10 ||t3.getText().length()>9 )
			{
				
				JOptionPane.showMessageDialog(null, "Invalid Date \n Enter Date YYYY-DD-MM Format","Error",JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}

	
	public void keyReleased(KeyEvent arg0) {
		
		
	}

	
	public void keyTyped(KeyEvent arg0) {
		
		
	}

	
	public void itemStateChanged(ItemEvent e) 
	{
		if(r1.isSelected())
		{
			
			b1.setVisible(true);
			b2.setVisible(true);
			cb3.setVisible(true);
			cb1.setVisible(true);
			cb2.setVisible(true);
			r3.setVisible(true);
			r5.setVisible(true);
			t2.setVisible(false);
			t3.setVisible(false);
			r4.setVisible(true);
			l3.setVisible(true);
			
			if(cb2.getSelectedItem()=="2" && Integer.parseInt((String) cb3.getSelectedItem())%4==0)
			{
				String i=(String)cb1.getSelectedItem();
				cb1.removeAllItems();
				cb1.addItem("1");
				cb1.addItem("2");
				cb1.addItem("3");
				cb1.addItem("4");
				cb1.addItem("5");
				cb1.addItem("6");
				cb1.addItem("7");
				cb1.addItem("8");
				cb1.addItem("9");
				cb1.addItem("10");
				cb1.addItem("11");
				cb1.addItem("12");
				cb1.addItem("13");
				cb1.addItem("14");
				cb1.addItem("15");
				cb1.addItem("16");
				cb1.addItem("17");
				cb1.addItem("18");
				cb1.addItem("19");
				cb1.addItem("20");
				cb1.addItem("21");
				cb1.addItem("22");
				cb1.addItem("23");
				cb1.addItem("24");
				cb1.addItem("25");
				cb1.addItem("26");
				cb1.addItem("27");
				cb1.addItem("28");
				cb1.addItem("29");
				if(!i.equals("31") &&!i.equals("30"))
				{
					cb1.setSelectedItem(i);
				}
			}
			if(cb2.getSelectedItem()=="2" && Integer.parseInt((String) cb3.getSelectedItem())%4!=0)
			{
				String i=(String)cb1.getSelectedItem();
				cb1.removeAllItems();
				cb1.addItem("1");
				cb1.addItem("2");
				cb1.addItem("3");
				cb1.addItem("4");
				cb1.addItem("5");
				cb1.addItem("6");
				cb1.addItem("7");
				cb1.addItem("8");
				cb1.addItem("9");
				cb1.addItem("10");
				cb1.addItem("11");
				cb1.addItem("12");
				cb1.addItem("13");
				cb1.addItem("14");
				cb1.addItem("15");
				cb1.addItem("16");
				cb1.addItem("17");
				cb1.addItem("18");
				cb1.addItem("19");
				cb1.addItem("20");
				cb1.addItem("21");
				cb1.addItem("22");
				cb1.addItem("23");
				cb1.addItem("24");
				cb1.addItem("25");
				cb1.addItem("26");
				cb1.addItem("27");
				cb1.addItem("28");
				if(!i.equals("31") &&!i.equals("30")&&!i.equals("29"))
				{
					cb1.setSelectedItem(i);
				}
			}
			if(cb2.getSelectedItem()=="5"|| cb2.getSelectedItem()=="7"|| cb2.getSelectedItem()=="3"|| cb2.getSelectedItem()=="1"|| cb2.getSelectedItem()=="8"||cb2.getSelectedItem()=="10"|| cb2.getSelectedItem()=="12")
			{
				
				String i=(String)cb1.getSelectedItem();
				cb1.removeAllItems();
				cb1.addItem("1");
				cb1.addItem("2");
				cb1.addItem("3");
				cb1.addItem("4");
				cb1.addItem("5");
				cb1.addItem("6");
				cb1.addItem("7");
				cb1.addItem("8");
				cb1.addItem("9");
				cb1.addItem("10");
				cb1.addItem("11");
				cb1.addItem("12");
				cb1.addItem("13");
				cb1.addItem("14");
				cb1.addItem("15");
				cb1.addItem("16");
				cb1.addItem("17");
				cb1.addItem("18");
				cb1.addItem("19");
				cb1.addItem("20");
				cb1.addItem("21");
				cb1.addItem("22");
				cb1.addItem("23");
				cb1.addItem("24");
				cb1.addItem("25");
				cb1.addItem("26");
				cb1.addItem("27");
				cb1.addItem("28");
				cb1.addItem("29");
				cb1.addItem("30");
				cb1.addItem("31");
				cb1.setSelectedItem(i);
			}
			if(cb2.getSelectedItem()=="4"|| cb2.getSelectedItem()=="6"|| cb2.getSelectedItem()=="9"|| cb2.getSelectedItem()=="11")
			{
				String i=(String)cb1.getSelectedItem();
				cb1.removeAllItems();
				cb1.addItem("1");
				cb1.addItem("2");
				cb1.addItem("3");
				cb1.addItem("4");
				cb1.addItem("5");
				cb1.addItem("6");
				cb1.addItem("7");
				cb1.addItem("8");
				cb1.addItem("9");
				cb1.addItem("10");
				cb1.addItem("11");
				cb1.addItem("12");
				cb1.addItem("13");
				cb1.addItem("14");
				cb1.addItem("15");
				cb1.addItem("16");
				cb1.addItem("17");
				cb1.addItem("18");
				cb1.addItem("19");
				cb1.addItem("20");
				cb1.addItem("21");
				cb1.addItem("22");
				cb1.addItem("23");
				cb1.addItem("24");
				cb1.addItem("25");
				cb1.addItem("26");
				cb1.addItem("27");
				cb1.addItem("28");
				cb1.addItem("29");
				cb1.addItem("30");
				if(!i.equals("31"))
				{
					cb1.setSelectedItem(i);
				}
			}
		}
		if(r2.isSelected())
		{
			cb3.setVisible(false);
			cb1.setVisible(false);
			cb2.setVisible(false);
			r3.setVisible(false);
			r4.setVisible(false);
			r5.setVisible(false);
			l3.setVisible(false);
			t2.setVisible(true);
			t3.setVisible(true);
			
		}
		
	}

	
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==b1)
		{
			if(r1.isSelected()==true)
			{
				String cd=cb3.getSelectedItem()+"-"+cb2.getSelectedItem()+"-"+cb1.getSelectedItem();
				String type="";
				
				if(r3.isSelected())
				{
					type="SIM";
				}
				if(r4.isSelected())
				{
					type="Voucher";
				}
				if(r5.isSelected())
				{
					type="EBal";
				}
				
				if(r3.isSelected()||r4.isSelected()||r5.isSelected())
				{
					new SaleReportDateForm(cd,type);
				}
			}
			if(r2.isSelected()==true)
			{
				new SaleReportDailyForm("","","");
			}
		}
		if(e.getSource()==b2)
		{
			new MainForm();
			f.setVisible(false);
		}
		
	}
}


class SaleReportForm
{
	public static void main(String arg[])
	{
		new SaleReport();
	}
}