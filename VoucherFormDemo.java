import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

 class VoucherForm implements ActionListener,ItemListener,KeyListener
{
	
	JButton b1,b2,b3;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l,li,lr,erno1,erno2,erno3,erno4,erno5,erno6,erno7,erno8;
	JFrame f;
	JLabel t1;
	JTextField t2,t3,t4,t5,t6,h,g;
	Font f1,f2,f3,f4,f5;
	JComboBox cb1,cb3,cbd,cbs,cbv,cbt;
	String mno,ptype,vtype,amt,qua,bname,cno,date,tamt,quastr="1";
	boolean flag=false;
	
	ButtonGroup brg;
	
	public VoucherForm()
	 {
	 
	 	f=new JFrame("POS - Recharge");
		f.setSize(1366,768);
		f.setResizable(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel fm=new JLabel(new ImageIcon("D:\\Project\\Images\\BackGround.jpg"));
		fm.setBounds(0,00,1366,768);
		JLabel header=new JLabel(new ImageIcon("D:\\Project\\Images\\headerVD.jpg"));
		header.setBounds(0,0,1455,161);
		fm.add(header);
		
		f.setLayout(null);
		f1=new Font("Arial",Font.BOLD,20);
		f2=new Font("Arial",Font.PLAIN,18);
		f3=new Font("Cooper Black",Font.BOLD,25);
		f4=new Font("Arial",Font.BOLD,16);
		f5=new Font("Arial",Font.BOLD,20);
		
		
		
		l=new JLabel("Voucher");
		l.setBounds(650,170,200,35);
		l.setFont(f3);
		l.setForeground(Color.BLUE);
		l.setVisible(true);
		
		
		li=new JLabel("");
		li.setFont(f3);
		li.setBounds(300,170,400,35);
		li.setForeground(Color.BLUE);
		
		erno1=new JLabel("Invalid Number");
		erno1.setForeground(Color.RED);
		erno1.setVisible(false);
		erno1.setFont(f5);
		erno1.setBounds(950,250,250,35);
		
		erno2=new JLabel("Empty Field Not Allowed");
		erno2.setForeground(Color.RED);
		erno2.setVisible(false);
		erno2.setFont(f5);
		erno2.setBounds(950,250,250,35);
		
		erno3=new JLabel("Quantity Must Greater Than Zero");
		erno3.setForeground(Color.RED);
		erno3.setVisible(false);
		erno3.setFont(f5);
		erno3.setBounds(790,390,400,30);

		erno4=new JLabel("Enter Payment Method");
		erno4.setForeground(Color.RED);
		erno4.setVisible(false);
		erno4.setFont(f5);
		erno4.setBounds(800,495,250,35);

		erno5=new JLabel("Enter Bank Name");
		erno5.setForeground(Color.RED);
		erno5.setVisible(false);
		erno5.setFont(f5);
		erno5.setBounds(850,540,200,30);

		erno6=new JLabel("Enter Cheque Number");
		erno6.setForeground(Color.RED);
		erno6.setVisible(false);
		erno6.setFont(f5);	
		erno6.setBounds(850,580,250,30);
		
		erno7=new JLabel("Enter quantity");
		erno7.setForeground(Color.RED);
		erno7.setVisible(false);
		erno7.setFont(f5);	
		erno7.setBounds(790,390,400,30);
		
		erno8=new JLabel("Not Allowed");
		erno8.setForeground(Color.RED);
		erno8.setVisible(false);
		erno8.setFont(f5);	
		erno8.setBounds(790,390,400,30);		
		
		l1=new JLabel("Date");
		l1.setBounds(1000,170,100,35);
		l1.setFont(f1);
		l1.setForeground(Color.BLUE);		
		
		l2=new JLabel("Customer Number");
		l2.setBounds(400,250,250,35);
		l2.setFont(f1);
		l2.setForeground(Color.RED);
		
		l3=new JLabel("Voucher Type");
		l3.setBounds(400,300,250,35);
		l3.setFont(f1);
		l3.setForeground(Color.RED);
		
		l4=new JLabel("Prise");
		l4.setBounds(400,349,250,35);
		l4.setFont(f1);
		l4.setForeground(Color.RED);
		
		l5=new JLabel("Quantity");
		l5.setBounds(400,390,250,35);
		l5.setFont(f1);
		l5.setForeground(Color.RED);
		
		l8=new JLabel("Total Amount");
		l8.setBounds(400,440,250,35);
		l8.setFont(f1);
		l8.setForeground(Color.RED);
		
		l9=new JLabel("Payment mode");
		l9.setFont(f1);
		l9.setBounds(400,495,250,25);		
		l9.setForeground(Color.RED);		
		
		l6=new JLabel("Bank Name");
		l6.setBounds(400,540,250,35);
		l6.setFont(f1);
		l6.setForeground(Color.RED);
		l6.setVisible(false);
		
		l7=new JLabel("Cheque Number");
		l7.setBounds(400,580,250,35);
		l7.setFont(f1);
		l7.setForeground(Color.RED);
		l7.setVisible(false);
				
		t1=new JLabel();
		t1.setBounds(1050,170,120,28);
		t1.setFont(f2);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calobj = Calendar.getInstance();
		t1.setText(df.format(calobj.getTime()));
		
		t2=new JTextField(10);
		t2.setBounds(700,250,250,35);
		t2.setFont(f2);
	//	t2.setText("t2");
			
		t3=new JTextField(10);
		t3.setBounds(700,390,50,35);
		t3.setFont(f2);
		t3.setText("1");
	//	t3.setVisible(false);
		
		


		t4=new JTextField(10);
		t4.setBounds(700,440,150,35);
		t4.setFont(f2);
		t4.setEditable(false);
		t4.setText("14");
		//t4.setVisible(false);
		
		t5=new JTextField(10);
		t5.setBounds(700,540,150,30);
		t5.setFont(f2);
//		t5.setText("t5");
		
		t5.setVisible(false);
		
		t6=new JTextField(10);
		t6.setBounds(700,580,150,30);
		t6.setFont(f2);
//		t6.setText("t6");
		
		
		t6.setVisible(false);
		
		h=new JTextField(10);
		h.setText("");
		h.setBounds(1000,300,120,35);
		h.setVisible(false);
		
		g=new JTextField(10);
		g.setText("");
		g.setBounds(1000,400,120,35);
		
		cb1=new JComboBox();
		cb1.addItem("Data Voucher");	
		cb1.addItem("SMS Voucher");	
		cb1.addItem("Voice Voucher");	
		cb1.addItem("TOPUP Voucher");
	//	cb1.addItem("Special Voucher");
		cb1.addItemListener(this);	
		cb1.setBounds(700,300,120,35);
		cb1.addItemListener(this);
		
		//cb1.setSelectedItem("Data Recharge");
			
		cbd=new JComboBox();
		cbd.addItem("14");
	 	cbd.addItem("29");
	 	cbd.addItem("49");
	 	cbd.addItem("98");
	 	cbd.addItem("198");
	 	cbd.addItem("500");
		cbd.setBounds(700,345,90,35);
		
		//cbd.setSelectedItem("14");
		
	
		cbd.addItemListener(this);
		
		cbs=new JComboBox();
		cbs.addItem("9");
	 	cbs.addItem("13");
	 	cbs.addItem("15");
	 	cbs.addItem("19");
	 	cbs.addItem("34");
	 	cbs.addItem("56");
		cbs.setBounds(700,345,90,35);
		cbs.setVisible(false);
		
		//cbs.setSelectedItem("9");
		cbs.addItemListener(this);
		
		cbv=new JComboBox();
		cbv.addItem("18");
	 	cbv.addItem("55");
	 	cbv.addItem("155");
	 	cbv.addItem("249");
	 	cbv.addItem("298");
	 	cbv.addItem("349");
		cbv.setBounds(700,345,90,35);
		cbv.setVisible(false);
		
		//cbv.setSelectedItem("18");
		
		cbv.addItemListener(this);
		
		cbt=new JComboBox();
		cbt.addItem("50");
	 	cbt.addItem("100");
	 	cbt.addItem("150");
	 	cbt.addItem("200");
	 	cbt.addItem("250");
	 	cbt.addItem("300");
	 	cbt.setBounds(700,345,90,35);
		cbt.setVisible(false);
		
		cbt.setSelectedItem("50");
		
		cbt.addItemListener(this);
		
			
		cb3=new JComboBox();
		cb3.addItem("-");
		cb3.addItem("Cash");	
		cb3.addItem("NEFT");	
		cb3.addItem("Cheque");
		
		cb3.setSelectedItem("-");
			
		
		cb3.setBounds(700,495,100,35);
		cb3.addItemListener(this);
				
		b1=new JButton("Submit");
		b1.setBounds(410,630,80,35);
		b1.addActionListener(this);
	
		b2=new JButton("Clear");
		b2.setBounds(580,630,80,35);
		b2.addActionListener(this);
	
		b3=new JButton("Back");
		b3.setBounds(745,630,80,35);
		b3.addActionListener(this);

		fm.add(b1);
		fm.add(b2);
		fm.add(b3);
		fm.add(l);
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
		fm.add(h);
		
		fm.add(cb1);
		fm.add(cb3);
	
		fm.add(cbd);
		fm.add(cbs);
		fm.add(cbv);
		fm.add(cbt);
		
		t3.addKeyListener(this);
		fm.add(erno1);
		fm.add(erno2);
		fm.add(erno3);
		fm.add(erno4);
		fm.add(erno5);
		fm.add(erno6);
		fm.add(erno7);
		fm.add(erno8);
		cbd.setVisible(true);
		
		f.add(fm);
		f.setVisible(true);		
	 }
	 public void actionPerformed(ActionEvent e)
	 {
	 	erno1.setVisible(false);
	 	erno2.setVisible(false);
	 	erno3.setVisible(false);
	 	erno4.setVisible(false);
	 	erno5.setVisible(false);
	 	erno6.setVisible(false);
	 	erno7.setVisible(false);
	 	erno8.setVisible(false);
	 	boolean ch=true;
	 	flag=true;
	 	mno=t2.getText();
	 	date=t1.getText();
	 	qua=t3.getText();//mno,ptype,vtype,amt,qua,bname,cno,date,tamt
	 	ptype=(String)cb3.getSelectedItem();
	 	vtype=(String)cb1.getSelectedItem();
	 	bname=t5.getText();
	 	cno=t6.getText();
	 	tamt=t4.getText();
	 	if(e.getSource()==b1)
	 	{
	 		//Checking Mobile Number Valid Or Not
	 	
	 		if(mno.length()>10 || mno.length()<10  || mno.length()==0 )
	 		{
	 			if(mno.length()>0)
	 			{
	 				if(mno.length()>10 || mno.length()<10 || mno.length()!=0)
	 				{
	 					erno1.setVisible(true);
	 					erno2.setVisible(false);
	 				}
	 			}
	 			if(mno.length()==0)
	 			{
	 				erno2.setVisible(true);	
	 				erno1.setVisible(false);
	 			}
				flag=false;
	 				//JOptionPane.showMessageDialog(null,"Enter Valid Number","Invalid",JOptionPane.ERROR_MESSAGE);
	 		}
	 	
	 	
	 			//Checking  Quantity Is greate Than Zero or Entered.
	 			if(qua.length()==0)
	 			{
	 				erno8.setVisible(true);
	 				erno3.setVisible(false);
	 				flag=false;
	 				for(int i=0;i<qua.length();i++)
	 				{
	 					if(Character.isLetter(qua.charAt(i)))//Checking Is There Any Alphabet
	 					{
	 						erno7.setVisible(true);
	 						erno8.setVisible(false);
	 							ch=false;
	 						break;
	 					}
	 				}
	 			}
	 			try
	 			{
	 				if(qua.length()>0 && ch==true)
	 				{
	 					
	 					int quaint=Integer.parseInt(qua);
	 					if(quaint<=0)
	 					{
	 						erno8.setVisible(false);
	 						erno3.setVisible(true);
	 						flag=false;
	 					}
	 				}
	 			}
	 			catch(Exception ee)
	 			{
	 				erno8.setVisible(true);
	 				erno3.setVisible(false);
	 				erno7.setVisible(false);
	 				flag=false;
	 			}
	 		
	 			if(ptype.equals("-")) //PayMent Mode 
	 			{
	 				erno4.setVisible(true);
	 				flag=false;
	 			}
	 			if(ptype.equals("Cheque"))//by condition if Cheque
	 			{
	 				if(bname.length()==0)
	 				{
	 					erno5.setVisible(true);
	 					flag=false;
	 				}
	 		
	 				if(cno.length()==0)
	 				{
	 					erno6.setVisible(true);
	 					flag=false;
	 				}	
	 			}
	 			//Connecting to DataBase 
	 			if(flag==true)
	 			{
	 				if(bname.length()==0)
	 				{
	 					bname="-";
	 				}
	 		
	 				if(cno.length()==0)
	 				{
	 					cno="-";
	 				}	
	 				tamt=t4.getText();
	 				try
	 				{
	 					/*Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	 					Connection con=DriverManager.getConnection("Jdbc:Odbc:Micro-POS");*/
	 					Class.forName("com.mysql.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/micropos","root","");
		 				
	 					String qry="insert into Voucher values(?,?,?,?,?,?,?,?,?)";
	 					PreparedStatement stmt=con.prepareStatement(qry);
	 					stmt.setString(1,mno);
	 					stmt.setString(2,vtype);
	 					stmt.setString(3,amt);
	 					stmt.setString(4,qua);
	 					stmt.setString(5,tamt);
	 					stmt.setString(6,ptype);
	 					stmt.setString(7,bname);
	 					stmt.setString(8,cno);
						stmt.setString(9,date);
	 					
	 					stmt.executeUpdate();
	 					JOptionPane.showMessageDialog(null,"Saved Successfully!!!!!","Success",JOptionPane.PLAIN_MESSAGE);
	 					con.close();
	 			}
	 			catch(Exception a)
	 			{
	 				System.out.println(a);	
	 			}
	 				
	 			}
	 	}
	 		
	 		if(e.getSource()==b2)
	 		{
	 			cb1.setSelectedItem("Data Recharge");
	 			amt=(String)cbd.getSelectedItem();	
	 			t2.setText("");
	 			t3.setText("1");
	 			t4.setText(amt);
	 			t5.setText("");
	 			t6.setText("");
	 			h.setText("");
	 			cbd.setSelectedItem("14");
				//cb1.setSelectedItem("Data Recharge");
		
	 			erno1.setVisible(false);
	 			erno2.setVisible(false);
	 			erno3.setVisible(false);
	 			erno4.setVisible(false);
			 	erno5.setVisible(false);
	 			erno6.setVisible(false);
	 			erno7.setVisible(false);
	 			erno8.setVisible(false);
	 		}
	 		if(e.getSource()==b3)
	 		{
	 			
	 			new MainForm();
	 			f.setVisible(false);
	 		}
	 }	 
	 public void itemStateChanged(ItemEvent e)
	 {
	 	//
	 	ptype=(String)cb3.getSelectedItem();
	 	if(ptype.equals("Cheque"))
	 	{
	 		t5.setVisible(true);
	 		t6.setVisible(true);
	 		l6.setVisible(true);
	 		l7.setVisible(true);
	 		erno4.setVisible(false);
	 	}
	 	if(ptype.equals("Cash"))
	 	{
	 		t5.setVisible(false);
	 		t6.setVisible(false);
	 		l6.setVisible(false);
	 		l7.setVisible(false);
	 		erno4.setVisible(false);
	 	}
	 	if(ptype.equals("NEFT"))
	 	{
	 		t5.setVisible(false);
	 		t6.setVisible(false);
	 		l6.setVisible(false);
	 		l7.setVisible(false);
	 		erno4.setVisible(false);
	 	}
	 	//Selecting CheckBox By Vtype
	 	vtype=(String)cb1.getSelectedItem();
	 	if(vtype.equals("Data Voucher"))
	 	{
	 		cbt.setVisible(false);
	 		cbs.setVisible(false);
	 		cbv.setVisible(false);
	 		cbd.setVisible(true);
	 		amt=(String)cbd.getSelectedItem();	
	 		
	 	}
	 	if(vtype.equals("SMS Voucher"))
	 	{
	 		cbt.setVisible(false);
	 		cbd.setVisible(false);
	 		cbv.setVisible(false);
	 		cbs.setVisible(true);
	 		amt=(String)cbs.getSelectedItem();	
	 				
	 	}
	 	if(vtype.equals("Voice Voucher"))
	 	{
	 		cbt.setVisible(false);
	 		cbs.setVisible(false);
	 		cbd.setVisible(false);
	 		cbv.setVisible(true);	
	 		amt=(String)cbv.getSelectedItem();
	 		
	 	}
	 	if(vtype.equals("TOPUP Voucher"))
	 	{
	 		cbd.setVisible(false);
	 		cbs.setVisible(false);
	 		cbv.setVisible(false);
	 		cbt.setVisible(true);	
	 		amt=(String)cbt.getSelectedItem();
	 		
	 	}
	 	if(t3.getText().length()>0)
	 	{
	 		qua=t3.getText();
	 		int amtint=Integer.parseInt(amt);
	 		int quaint=Integer.parseInt(qua);
	 		int sum=amtint*quaint;
	 		t4.setText(""+sum);
	 	}
	 }
	 public void keyPressed(KeyEvent e)
	 {
	 	
	 }
	 
	 public void keyReleased(KeyEvent e)
	 {}
	 	
	 //Calculating Total Amount
	 public void keyTyped(KeyEvent e)
	 {
	 	boolean flag1=true;
	 	boolean ch=true;
	 	char selected;
	 	t4.setText("");
	 	
	 	if((selected=e.getKeyChar())!=KeyEvent.VK_BACK_SPACE)
	 	{
	 		
	 		h.setText(h.getText()+selected);
	 		
	 	}
	 	if(e.getKeyChar()==KeyEvent.VK_BACK_SPACE)
	 	{
	 		g.setText("");
	 		if((quastr=h.getText()).length()>=2)
	 		{
	 			for(int i=0;i<quastr.length()-1;i++)
	 			{
	 				g.setText(g.getText()+quastr.charAt(i));
	 			}
	 			h.setText(g.getText());
	 		}
	 		if(quastr.length()==1)
	 		{
	 			h.setText("");
	 			t4.setText("0");
	 		}
	 	}
	 	
	 	
	 	vtype=(String)cb1.getSelectedItem();
	  	if(vtype.equals("Data Voucher"))
	 	{
	 		amt=(String)cbd.getSelectedItem();	
	 	}
	 	if(vtype.equals("SMS Voucher"))
	 	{
	  		amt=(String)cbs.getSelectedItem();	
	 	}
	 	if(vtype.equals("Voice Voucher"))
	 	{
	 		amt=(String)cbv.getSelectedItem();
	 	}
	 	if(vtype.equals("TOPUP Voucher"))
	 	{
	 		amt=(String)cbt.getSelectedItem();
	 	}
	 	try
	 	{		
	 			quastr=h.getText();
	 			int quaint=Integer.parseInt(quastr);
	 			int tempamt=Integer.parseInt(amt);
	 			int to=quaint*tempamt;
	 			t4.setText(""+to);
	 	}
	 	catch(Exception ee)
	 	{}
	 	
	 	System.out.println(quastr);
	 }
		 	
}


class VoucherFormsDemo
{
	public static void main(String arg[])
	{
		new VoucherForm();
	}
}