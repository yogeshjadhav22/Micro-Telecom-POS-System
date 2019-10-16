import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

 class StockInForm implements ActionListener,ItemListener,KeyListener
{
	
	JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13;
	JLabel t1,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,erno1,erno2,erno3,erno4,erno5,erno6,erno7,erno8,erno9,erno10,erno11,erno12,erno13,erno14,erno15;
	JFrame f;
	JTextField t2,t3,t4,t5,t6,t7,t8,t9,t10;
	Font f1,f2,f3,f4,f5;
	String snpr,snpo,bal,d,s,t,v,mno;
	boolean flag=true;
	JPanel p,p1,p2;
	JScrollPane jsp1;
	ButtonGroup brg;
	
	public StockInForm()
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
		f1=new Font("Arial",Font.BOLD,16);
		f2=new Font("Arial",Font.PLAIN,18);
		f3=new Font("Lucida Fax",Font.BOLD,20);
		f4=new Font("Arial",Font.BOLD,16);
		f5=new Font("Lucida Fax",Font.BOLD,15);
		
		
		
		
		p=new JPanel();
	//	p.setSize(700,700);
		
		p.setVisible(false);
		p.setBackground(Color.white);
		p.setLayout(null);
		p.setBounds(400,180,700,700);
		
		p1=new JPanel();
				
		p1.setVisible(false);
		p1.setBackground(Color.white);
		p1.setLayout(null);
		p1.setBounds(400,180,700,700);
				
		p2=new JPanel();
			
		p2.setVisible(false);
		p2.setBackground(Color.white);
		p2.setLayout(null);
		p2.setBounds(400,180,700,700);
				
				
		erno1=new JLabel("Enter Number Of Sim");//350,150,100,25
		erno1.setForeground(Color.RED);
		erno1.setVisible(false);
		erno1.setFont(f5);
		erno1.setBounds(450,110,200,100);
		
		erno2=new JLabel("Invalid Entry");
		erno2.setForeground(Color.RED);
		erno2.setVisible(false);
		erno2.setFont(f5);
		erno2.setBounds(450,110,150,100);
		
		erno3=new JLabel("Enter Number Of Sim");
		erno3.setForeground(Color.RED);
		erno3.setVisible(false);
		erno3.setFont(f5);
		erno3.setBounds(450,200,200,100);

		erno4=new JLabel("Invalid Entry");
		erno4.setForeground(Color.RED);
		erno4.setVisible(false);
		erno4.setFont(f5);
		erno4.setBounds(450,200,150,100);

		erno5=new JLabel("Enter Number Of Vouchers");
		erno5.setForeground(Color.RED);
		erno5.setVisible(false);
		erno5.setFont(f5);
		erno5.setBounds(460,130,250,25);

		erno6=new JLabel("Invalid Entry");
		erno6.setForeground(Color.RED);
		erno6.setVisible(false);
		erno6.setFont(f5);	
		erno6.setBounds(460,130,250,25);
		
		erno7=new JLabel("Enter Number Of Vouchers");
		erno7.setForeground(Color.RED);
		erno7.setVisible(false);
		erno7.setFont(f5);	
		erno7.setBounds(460,180,250,25);
		
		erno8=new JLabel("Invalid Entry");
		erno8.setForeground(Color.RED);
		erno8.setVisible(false);
		erno8.setFont(f5);	
		erno8.setBounds(460,180,250,25);		
		
		erno9=new JLabel("Enter Number Of Vouchers");
		erno9.setForeground(Color.RED);
		erno9.setVisible(false);
		erno9.setFont(f5);	
		erno9.setBounds(460,230,250,25);
		
		erno10=new JLabel("Invalid Entry");
		erno10.setForeground(Color.RED);
		erno10.setVisible(false);
		erno10.setFont(f5);	
		erno10.setBounds(460,230,250,25);		
		
		erno11=new JLabel("Enter Number Of Vouchers");
		erno11.setForeground(Color.RED);
		erno11.setVisible(false);
		erno11.setFont(f5);	
		erno11.setBounds(460,280,250,25);		
		
		erno12=new JLabel("Invalid Entry");
		erno12.setForeground(Color.RED);
		erno12.setVisible(false);
		erno12.setFont(f5);	
		erno12.setBounds(460,280,250,25);		
		
		erno13=new JLabel("Invalid Entry");
		erno13.setForeground(Color.RED);
		erno13.setVisible(false);
		erno13.setFont(f5);	
		erno13.setBounds(460,150,200,25);		
		
		erno14=new JLabel("Enter The Balance");
		erno14.setForeground(Color.RED);
		erno14.setVisible(false);
		erno14.setFont(f5);	
		erno14.setBounds(460,240,200,25);		
		
		erno15=new JLabel("Invalid Entry");
		erno15.setForeground(Color.RED);
		erno15.setVisible(false);
		erno15.setFont(f5);	
		erno15.setBounds(460,240,200,25);		
		
		l1=new JLabel("Date");
		l1.setBounds(1000,166,200,35);
		l1.setFont(f1);
		l1.setForeground(Color.BLACK);		
		
		l2=new JLabel("Enter the Number Of Sim");
		l2.setBounds(200,50,320,35);
		l2.setFont(f3);
		//l2.setForeground(Color.RED);
		p.add(l2);
		
		l3=new JLabel("Prepaid");
		l3.setBounds(200,150,100,30);
		l3.setFont(f1);
		//l3.setForeground(Color.RED);
		p.add(l3);
		
		l4=new JLabel("Postpaid");
		l4.setBounds(200,240,100,30);
		l4.setFont(f1);
		//l4.setForeground(Color.RED);
		p.add(l4);
		
		l5=new JLabel("Enter the Number Of Vouchers");
		l5.setBounds(170,50,350,30);
		l5.setFont(f3);
		p1.add(l5);
		//l5.setForeground(Color.RED);
		
		l6=new JLabel("TOP-UP");
		l6.setBounds(190,130,100,35);
		l6.setFont(f1);
		p1.add(l6);
		//l6.setForeground(Color.RED);
		//l6.setVisible(false);
		
		l7=new JLabel("Voice Packs");
		l7.setBounds(190,180,100,35);
		l7.setFont(f1);
		p1.add(l7);
		//l7.setForeground(Color.RED);
		//l7.setVisible(false);
		
		l8=new JLabel("DATA Packs");
		l8.setBounds(190,230,100,35);
		l8.setFont(f1);
		p1.add(l8);
		//l8.setForeground(Color.RED);
		
		l9=new JLabel("SMS Packs");
		l9.setFont(f1);
		l9.setBounds(190,280,100,35);
		p1.add(l9);
		//l9.setForeground(Color.RED);		
		
		l10=new JLabel("Enter amount Of E-Balance");
		l10.setFont(f3);
		l10.setBounds(200,50,350,30);
		p2.add(l10);
		
		l11=new JLabel("Mobile Number");
		l11.setFont(f1);
		l11.setBounds(200,150,150,30);
		p2.add(l11);
		
		l12=new JLabel("Amount");
		l12.setFont(f1);
		l12.setBounds(200,240,100,30);
		p2.add(l12);
		
		t1=new JLabel();
		t1.setBounds(1050,170,120,28);
		t1.setFont(f2);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calobj = Calendar.getInstance();
		t1.setText(df.format(calobj.getTime()));
	//	t1.setEditable(false);
		
		t2=new JTextField(10);
		t2.setBounds(350,150,100,25);
		t2.setFont(f2);
		p.add(t2);
		//t2.setText("t2");
			
		t3=new JTextField(10);
		t3.setBounds(350,240,100,25);
		t3.setFont(f2);
		p.add(t3);
		//t3.setText("t3");
	
		t4=new JTextField(10);
		t4.setBounds(350,130,100,25);
		t4.setFont(f2);
		p1.add(t4);
		///t4.setText("t4");
		
		t5=new JTextField(10);
		t5.setBounds(350,180,100,25);
		p1.add(t5);
		t5.setFont(f2);
		//t5.setText("t5");
				
		t6=new JTextField(10);
		t6.setBounds(350,230,100,25);
		p1.add(t6);
		t6.setFont(f2);
		//t6.setText("t6");
		
		t7=new JTextField(10);
		//t7.setText("t7");
		t7.setFont(f2);
		t7.setBounds(350,280,100,25);
		p1.add(t7);
		
		t8=new JTextField(10);
		//t8.setText("t8");
		t8.setFont(f2);
		t8.setBounds(350,150,100,25);
		p2.add(t8);
		
		t9=new JTextField(10);
		//t9.setText("t9");
		t9.setFont(f2);
		t9.setBounds(350,240,100,25);
		p2.add(t9);
						
		b1=new JButton("SIM");
		b1.setBounds(100,300,100,35);
		b1.addActionListener(this);
	
		b2=new JButton("Voucher");
		b2.setBounds(100,400,100,35);
		b2.addActionListener(this);
	
		b3=new JButton("E-Balance");
		b3.setBounds(100,500,100,35);
		b3.addActionListener(this);

		b4=new JButton("Submit");
		b4.setBounds(150,350,80,35);
		b4.addActionListener(this);
		p1.add(b4);
				
		b5=new JButton("Clear");
		b5.setBounds(280,350,80,35);
		b5.addActionListener(this);
		p1.add(b5);
				
		b6=new JButton("Cancel");
		b6.setBounds(410,350,80,35);
		b6.addActionListener(this);
		p1.add(b6);
				
		b8=new JButton("Submit");
		b8.setBounds(150,350,80,35);
		b8.addActionListener(this);
		p2.add(b8);
		
		b9=new JButton("Clear");
		b9.setBounds(280,350,80,35);
		b9.addActionListener(this);
		p2.add(b9);
		
		b10=new JButton("Cancel");
		b10.setBounds(410,350,80,35);
		b10.addActionListener(this);
		p2.add(b10);
		
		b11=new JButton("Submit");
		b11.setBounds(150,350,80,35);
		b11.addActionListener(this);
		p.add(b11);
				
		b12=new JButton("Clear");
		b12.setBounds(280,350,80,35);
		b12.addActionListener(this);
		p.add(b12);
		
		b13=new JButton("Cancel");
		b13.setBounds(410,350,80,35);
		b13.addActionListener(this);
		p.add(b13);
				
		
		
		fm.add(b1);
		fm.add(b2);
		fm.add(b3);
		
		fm.add(l1);
		fm.add(t1);
		fm.add(p);
		fm.add(p1);
		fm.add(p2);
		p.add(erno1);
		p.add(erno2);
		p.add(erno3);
		p.add(erno4);
		p1.add(erno5);
		p1.add(erno6);
		p1.add(erno7);
		p1.add(erno8);
		p1.add(erno9);
		p1.add(erno10);
		p1.add(erno11);
		p1.add(erno12);
		p2.add(erno13);
		p2.add(erno14);
		p2.add(erno15);
		
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
			p.setVisible(true);
			p1.setVisible(false);
			p2.setVisible(false);
			erno1.setVisible(false);
			erno2.setVisible(false);
			erno3.setVisible(false);
			erno4.setVisible(false);
			erno5.setVisible(false);
			erno6.setVisible(false);
			erno7.setVisible(false);
			erno8.setVisible(false);
			erno10.setVisible(false);
			erno11.setVisible(false);
			erno12.setVisible(false);
			erno14.setVisible(false);
			erno15.setVisible(false);
			erno13.setVisible(false);
			erno9.setVisible(false);
			
		}
		if(e.getSource()==b2)
		{
			p1.setVisible(true);
			p.setVisible(false);
			p2.setVisible(false);
			erno1.setVisible(false);
			erno2.setVisible(false);
			erno3.setVisible(false);
			erno4.setVisible(false);
			erno5.setVisible(false);
			erno6.setVisible(false);
			erno7.setVisible(false);
			erno8.setVisible(false);
			erno10.setVisible(false);
			erno11.setVisible(false);
			erno12.setVisible(false);
			erno14.setVisible(false);
			erno13.setVisible(false);
			erno15.setVisible(false);
			erno9.setVisible(false);
			
		}
		if(e.getSource()==b3)
		{
			p2.setVisible(true);
			p1.setVisible(false);
			p.setVisible(false);
			erno1.setVisible(false);
			erno2.setVisible(false);
			erno3.setVisible(false);
			erno4.setVisible(false);
			erno5.setVisible(false);
			erno6.setVisible(false);
			erno7.setVisible(false);
			erno8.setVisible(false);
			erno10.setVisible(false);
			erno11.setVisible(false);
			erno12.setVisible(false);
			erno14.setVisible(false);
			erno13.setVisible(false);
			erno15.setVisible(false);
			erno9.setVisible(false);
			
		}
		if(e.getSource()==b4)
		{
			t=t4.getText();
			s=t7.getText();
			v=t5.getText();
			d=t6.getText();
			flag=true;
			boolean flag1=true,flag2=true,flag3=true,flag4=true;
			
			if(t.length()!=0)
			{
				for(int i=0;i<t.length();i++)
				{
					if(!Character.isDigit((t.charAt(i))))
					{
						flag1=false;
						flag=false;
						erno5.setVisible(false);
						erno6.setVisible(true);
						break;
					}
				}
			}
			if(t.length()==0)
			{
				erno6.setVisible(false);
				erno5.setVisible(true);
				flag=false;
			}
			if(t.length()!=0 &&  flag1)
			{
				erno5.setVisible(false);
				erno6.setVisible(false);
				
			}
			if(v.length()!=0)
			{
				for(int i=0;i<v.length();i++)
				{
					if(!Character.isDigit((v.charAt(i))))
					{
						flag2=false;
						flag=false;
						erno7.setVisible(false);
						erno8.setVisible(true);
						break;
					}
				}
			}
			if(v.length()==0)
			{
				erno8.setVisible(false);
				erno7.setVisible(true);
				flag=false;
			}
			if(v.length()!=0 && flag2)
			{
				erno8.setVisible(false);
				erno7.setVisible(false);
				
			}
			
			if(d.length()!=0)
			{
				for(int i=0;i<d.length();i++)
				{
					if(!Character.isDigit((d.charAt(i))))
					{
						flag3=false;
						flag=false;
						erno9.setVisible(false);
						erno10.setVisible(true);
						break;
					}
				}
			}
			if(d.length()==0)
			{
				erno10.setVisible(false);
				erno9.setVisible(true);
				flag=false;
			}
			if(d.length()!=0 &&flag3)
			{
				erno10.setVisible(false);
				erno9.setVisible(false);
				
			}
			
			if(s.length()!=0)
			{
				for(int i=0;i<s.length();i++)
				{
					if(!Character.isDigit((s.charAt(i))))
					{
						flag4=false;
						flag=false;
						erno11.setVisible(false);
						erno12.setVisible(true);
						break;
					}
				}
			}
			if(s.length()==0)
			{
				erno12.setVisible(false);
				erno11.setVisible(true);
				flag=false;
			}
			if(s.length()!=0 &&flag4)
			{
				erno12.setVisible(false);
				erno11.setVisible(false);
				erno1.setVisible(false);
				erno2.setVisible(false);
				erno3.setVisible(false);
				erno4.setVisible(false);
				erno5.setVisible(false);
				erno6.setVisible(false);
				erno7.setVisible(false);
				erno8.setVisible(false);
				erno9.setVisible(false);
				erno10.setVisible(false);
				erno11.setVisible(false);
				erno12.setVisible(false);
				erno14.setVisible(false);
				erno13.setVisible(false);
				erno15.setVisible(false);
				erno9.setVisible(false);
				
			}
			
			if(flag)
			{
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/micropos","root","");
					PreparedStatement stmt1=con.prepareStatement("select * From VoucherIn");
					ResultSet rs=stmt1.executeQuery();
					rs.next();
					
					int DV=rs.getInt(1);
					int SV=rs.getInt(2);
					int VV=rs.getInt(3);
					int TV=rs.getInt(4);
					
					DV=DV+Integer.parseInt(d);
					SV=SV+Integer.parseInt(s);
					VV=VV+Integer.parseInt(v);
					TV=TV+Integer.parseInt(t);
					
					int T=DV+SV+VV+TV;
					PreparedStatement stmt2=con.prepareStatement("update Stock set Voucher=?");
					stmt2.setInt(1,T);
					PreparedStatement stmt=con.prepareStatement("update VoucherIn set Data=?,Sms=?,Voice=?,Top=?");
					stmt.setInt(1, DV);
					stmt.setInt(2, SV);
					stmt.setInt(3, VV);
					stmt.setInt(4, TV);
					int p=JOptionPane.showConfirmDialog(null,"Are You Sure???","Confirmation",JOptionPane.YES_NO_OPTION);
					if(p==JOptionPane.YES_OPTION)
					{
						stmt.executeUpdate();
						stmt2.executeUpdate();
						JOptionPane.showMessageDialog(null,"Successfully Update","Success",JOptionPane.PLAIN_MESSAGE);
						con.close();
					}
					
					
				}
				catch(Exception ee)
				{
					System.out.println(ee);
					
				}
			}
		}
		if(e.getSource()==b5)
		{
			//clear
			t4.setText("");
			t5.setText("");
			t7.setText("");
			t6.setText("");
			erno1.setVisible(false);
			erno2.setVisible(false);
			erno3.setVisible(false);
			erno4.setVisible(false);
			erno5.setVisible(false);
			erno6.setVisible(false);
			erno7.setVisible(false);
			erno8.setVisible(false);
			erno10.setVisible(false);
			erno11.setVisible(false);
			erno12.setVisible(false);
			erno14.setVisible(false);
			erno13.setVisible(false);
			erno15.setVisible(false);
			erno9.setVisible(false);
			
		}
		if(e.getSource()==b6)
		{
			p.setVisible(false);
			p1.setVisible(false);
			p2.setVisible(false);
			erno1.setVisible(false);
			erno2.setVisible(false);
			erno3.setVisible(false);
			erno4.setVisible(false);
			erno5.setVisible(false);
			erno6.setVisible(false);
			erno7.setVisible(false);
			erno8.setVisible(false);
			erno10.setVisible(false);
			erno11.setVisible(false);
			erno12.setVisible(false);
			erno14.setVisible(false);
			erno13.setVisible(false);
			erno15.setVisible(false);
			erno9.setVisible(false);
			
		}
		if(e.getSource()==b8)
		{
			mno=t8.getText();
			bal=t9.getText();
			flag=true;
			boolean flag1=true,flag2=true;
			if(bal.length()!=0)
			{
				for(int i=0;i<bal.length();i++)
				{
					if(!Character.isDigit((bal.charAt(i))))
					{
						flag1=false;
						flag=false;
						erno14.setVisible(false);
						erno15.setVisible(true);
						break;
					}
				}
			}
			if(bal.length()==0)
			{
				erno15.setVisible(false);
				erno14.setVisible(true);
				flag=false;
			}
			if(bal.length()!=0 && flag1)
			{
				erno14.setVisible(false);
				erno15.setVisible(false);
				
			}
			if(mno.length()>10 || mno.length()<10 || mno.length()==0 )
	 		{
				erno13.setVisible(true);
	 			flag=false;
	 			//JOptionPane.showMessageDialog(null,"Enter Valid Number","Invalid",JOptionPane.ERROR_MESSAGE);
	 		}
			if(mno.length()==10)
			{
					for(int i=0;i<mno.length();i++)
					{
						if(!Character.isDigit((mno.charAt(i))))
						{
							flag1=false;
							flag=false;
							erno13.setVisible(true);
							break;
						}
					}
					if(flag1)
					{
						erno13.setVisible(false);
					}
			}
			
			if(flag)
			{
				erno1.setVisible(false);
				erno2.setVisible(false);
				erno4.setVisible(false);
				erno3.setVisible(false);
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/micropos","root","");
					PreparedStatement stmt1=con.prepareStatement("select * from Stock");
					ResultSet rs=stmt1.executeQuery();
					rs.next();
					int b=rs.getInt(4);
					b=b+Integer.parseInt(bal);
					PreparedStatement stmt2=con.prepareStatement("update Mob set no=?,Ebal=?");
					long lno=Long.parseLong(mno);
					stmt2.setLong(1,lno);
					stmt2.setInt(2, b);
					
					PreparedStatement stmt=con.prepareStatement("update Stock set Ebal=?,Cdat=?");
					stmt.setInt(1, b);
					stmt.setString(2,t1.getText());
					
					int p=JOptionPane.showConfirmDialog(null,"Are You Sure???","Confirmation",JOptionPane.YES_NO_OPTION);
					if(p==JOptionPane.YES_OPTION)
					{
						stmt.executeUpdate();
						stmt2.executeUpdate();
						JOptionPane.showMessageDialog(null,"Successfully Update","Success",JOptionPane.PLAIN_MESSAGE);
						con.close();
					}
				}
				catch(Exception ee)
				{
					System.out.println(ee);
					
				}
				
			}
		}
		if(e.getSource()==b9)
		{
			t8.setText("");
			t9.setText("");
			erno1.setVisible(false);
			erno2.setVisible(false);
			erno3.setVisible(false);
			erno4.setVisible(false);
			erno5.setVisible(false);
			erno6.setVisible(false);
			erno7.setVisible(false);
			erno8.setVisible(false);
			erno10.setVisible(false);
			erno11.setVisible(false);
			erno12.setVisible(false);
			erno14.setVisible(false);
			erno13.setVisible(false);
			erno15.setVisible(false);
			erno9.setVisible(false);
			
		}
		if(e.getSource()==b10)
		{
			p.setVisible(false);
			p1.setVisible(false);
			p2.setVisible(false);
			erno1.setVisible(false);
			erno2.setVisible(false);
			erno3.setVisible(false);
			erno4.setVisible(false);
			erno5.setVisible(false);
			erno6.setVisible(false);
			erno7.setVisible(false);
			erno8.setVisible(false);
			erno10.setVisible(false);
			erno11.setVisible(false);
			erno12.setVisible(false);
			erno14.setVisible(false);
			erno13.setVisible(false);
			erno15.setVisible(false);
			erno9.setVisible(false);
			
		}
		if(e.getSource()==b11)
		{
			snpr=t2.getText();
			snpo=t3.getText();
			flag=true;
			boolean flag1=true,flag2=true;
			if(snpr.length()!=0)
			{
				for(int i=0;i<snpr.length();i++)
				{
					if(!Character.isDigit((snpr.charAt(i))))
					{
						flag1=false;
						flag=false;
						erno1.setVisible(false);
						erno2.setVisible(true);
						break;
					}
				}
			}
			if(snpr.length()==0)
			{
				erno2.setVisible(false);
				erno1.setVisible(true);
				flag=false;
			}
			if(snpr.length()!=0 && flag1)
			{
				erno1.setVisible(false);
				erno2.setVisible(false);
				erno1.setVisible(false);
				erno2.setVisible(false);
				erno3.setVisible(false);
				erno4.setVisible(false);
				erno5.setVisible(false);
				erno6.setVisible(false);
				erno7.setVisible(false);
				erno8.setVisible(false);
				erno10.setVisible(false);
				erno11.setVisible(false);
				erno12.setVisible(false);
				erno14.setVisible(false);
				erno13.setVisible(false);
				erno15.setVisible(false);
				erno9.setVisible(false);
				
			}
			if(snpo.length()!=0)
			{
				for(int i=0;i<snpo.length();i++)
				{
					if(!Character.isDigit((snpo.charAt(i))))
					{
						flag2=false;
						flag=false;
						erno3.setVisible(false);
						erno4.setVisible(true);
						break;
					}
				}
			}
			if(snpo.length()==0)
			{
				erno4.setVisible(false);
				erno3.setVisible(true);
				flag=false;
			}
			if(snpo.length()!=0 &&  flag2)
			{
				erno4.setVisible(false);
				erno3.setVisible(false);
				
			}
			
			if(flag)
			{
				erno1.setVisible(false);
				erno2.setVisible(false);
				erno4.setVisible(false);
				erno3.setVisible(false);
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/micropos","root","");
					PreparedStatement stmt1=con.prepareStatement("select * from Stock");
					ResultSet rs=stmt1.executeQuery();
					rs.next();
					PreparedStatement stmt2=con.prepareStatement("update SIM set Pre=?,Post=?,Cdat=?");
					
					int SP=rs.getInt("SimP");
					int SPO=rs.getInt("SimPost");
					SP=SP+Integer.parseInt(snpr);
					SPO=SPO+Integer.parseInt(snpo);
					stmt2.setInt(1,SP);
					stmt2.setInt(2,SPO);
					stmt2.setString(3,t1.getText());
					stmt2.executeUpdate();
					PreparedStatement stmt=con.prepareStatement("update Stock set SimP=?,SimPost=?,Cdat=?");
					
					stmt.setInt(1, SP);
					stmt.setInt(2, SPO);
					stmt.setString(3,t1.getText());
					int p=JOptionPane.showConfirmDialog(null,"Are You Sure???","Confirmation",JOptionPane.YES_NO_OPTION);
					if(p==JOptionPane.YES_OPTION)
					{
						stmt.executeUpdate();
						JOptionPane.showMessageDialog(null,"Successfully Update","Success",JOptionPane.PLAIN_MESSAGE);
						con.close();
					}
					
					
				}
				catch(Exception ee)
				{
					System.out.println(ee);
					
				}
				
			}
		}
		if(e.getSource()==b12)
		{
			t2.setText("");
			t3.setText("");
			erno1.setVisible(false);
			erno2.setVisible(false);
			erno3.setVisible(false);
			erno4.setVisible(false);
			erno5.setVisible(false);
			erno6.setVisible(false);
			erno7.setVisible(false);
			erno8.setVisible(false);
			erno10.setVisible(false);
			erno11.setVisible(false);
			erno12.setVisible(false);
			erno14.setVisible(false);
			erno13.setVisible(false);erno15.setVisible(false);
			erno9.setVisible(false);
			
		}
		if(e.getSource()==b13)
		{
			p.setVisible(false);
			p1.setVisible(false);
			p2.setVisible(false);
			erno1.setVisible(false);
			erno2.setVisible(false);
			erno3.setVisible(false);
			erno4.setVisible(false);
			erno5.setVisible(false);
			erno6.setVisible(false);
			erno7.setVisible(false);
			erno8.setVisible(false);
			erno10.setVisible(false);
			erno11.setVisible(false);
			erno12.setVisible(false);
			erno14.setVisible(false);
			erno13.setVisible(false);
			erno15.setVisible(false);
			erno9.setVisible(false);
			
		}
		if(e.getSource()==b7)
		{
			new MainForm();
			f.setVisible(false);
		}
	}
	 		 	
}


class StockIn
{
	public static void main(String arg[])
	{
		new StockInForm();
	}
}