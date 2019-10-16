import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

class SIMReplace implements ActionListener,ItemListener,KeyListener
{
	
	JButton b1,b2,b3;
	JLabel t1,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l,li,lr,erno1,erno2,erno3,erno4,erno5,erno6,erno7,erno8,erno9,erno10;
	JFrame f;
	JCheckBox cb1,cb2,cb3,cb4,cb5,cb6,cb7,cb8,cb9,cb10,cb11,cb12;
	JTextField t2,t3,t4,t6;
	Font f1,f2,f3,f4,f5;
	JRadioButton r1,r2;
	String mno,name,newno,ano,st;
	String reason="",doc="";
	int ch=25;
	JPanel p,p1,p2;
	boolean flag ;
	
	ButtonGroup brg;
	
	 public SIMReplace()
	 {
	 
	 	f=new JFrame("POS - Activations");
		f.setSize(1366,768);
		f.setResizable(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel fm=new JLabel(new ImageIcon("D:\\Project\\Images\\BackGround.jpg"));
		fm.setBounds(0,00,1366,768);
		JLabel header=new JLabel(new ImageIcon("D:\\Project\\Images\\headernew.jpg"));
		header.setBounds(0,0,1455,161);
		fm.add(header);
		
		f.setLayout(null);
		f1=new Font("Arial",Font.BOLD,20);
		f2=new Font("Lucida Fax",Font.BOLD,16);
		f3=new Font("Cooper Black",Font.PLAIN,25);
		f4=new Font("Lucida Fax",Font.BOLD,18);
		f5=new Font("Lucida Fax",Font.ITALIC,20);
		
		p=new JPanel();
		p.setBounds(810,230,670,270);
		p.setBackground(Color.white);
		p.setLayout(null);
		p1=new JPanel();
		p1.setBounds(100,430,250,35);
		p1.setBackground(Color.white);
		p1.setVisible(false);
		
		p2=new JPanel();
		p2.setBounds(600,280,240,35);
		p2.setBackground(Color.white);
		p2.setVisible(false);
		p2.setLayout(null);
		l=new JLabel("Activation Details");
		l.setBounds(500,50,300,50);
		l.setFont(f2);
		l.setForeground(Color.BLUE);
		
		li=new JLabel("Information Of Customer");
		li.setFont(f3);
		li.setBounds(100,170,400,35);
		
		erno1=new JLabel("* Invalid Name");
		erno1.setForeground(Color.RED);
		erno1.setVisible(false);
		erno1.setFont(f5);
		erno1.setBounds(600,230,250,35);

		
		erno2=new JLabel("* Enter Name");
		erno2.setForeground(Color.RED);
		erno2.setVisible(false);
		erno2.setFont(f5);	
		erno2.setBounds(600,229,250,35);//350,230,250,35
		
		erno3=new JLabel("* Invalid Number");
		erno3.setForeground(Color.RED);
		erno3.setVisible(false);
		erno3.setFont(f5);	
		erno3.setBounds(600,280,250,35);

		erno4=new JLabel("* Select Reason");
		erno4.setForeground(Color.RED);
		erno4.setVisible(false);
		erno4.setFont(f4);	
		erno4.setBounds(230,10,200,20);

		erno5=new JLabel("* Select Document Recieved");
		erno5.setForeground(Color.RED);
		erno5.setVisible(false);
		erno5.setFont(f4);	
		erno5.setBounds(320,170,300,20);

		erno6=new JLabel("* Enter valid Number");
		erno6.setForeground(Color.RED);
		erno6.setFont(f5);	
		erno6.setBounds(1,1,240,35);
		
		erno7=new JLabel("* Invalid Number");
		erno7.setForeground(Color.RED);
		erno7.setFont(f5);	
		erno7.setVisible(false);
		erno7.setBounds(600,330,250,35);
		
		erno8=new JLabel("* Enter valid Number");
		erno8.setForeground(Color.RED);
		erno8.setFont(f5);	
		erno8.setVisible(false);
		erno8.setBounds(597,330,250,35);
		
		erno9=new JLabel("* Invalid Number");
		erno9.setForeground(Color.RED);
		erno9.setFont(f5);	
		erno9.setVisible(false);
		erno9.setBounds(600,430,250,35);
		
		erno10=new JLabel("* Enter valid Number");
		erno10.setForeground(Color.RED);
		erno10.setFont(f5);	
		erno10.setVisible(false);
		erno10.setBounds(600,430,250,35);
		
		l1=new JLabel("Date");
		l1.setBounds(998,166,100,35);
		l1.setFont(f1);
		
		
		l2=new JLabel("A/C Number");
		l2.setBounds(100,430,250,35);
		l2.setFont(f1);
		l2.setVisible(false);
		
		
		l3=new JLabel("Customer Name");
		l3.setBounds(100,230,250,35);
		l3.setFont(f1);
	
		l4=new JLabel("Number Of Replace SIM");
		l4.setBounds(100,280,250,35);
		l4.setFont(f1);
	
		l5=new JLabel("SIM Type");
		l5.setBounds(100,380,250,35);
		l5.setFont(f1);
	
		l6=new JLabel("Reason For SIM Change");
		l6.setBounds(10,10,200,20);
		l6.setFont(f2);
		p.add(l6);
		
		l7=new JLabel("SIM Replace Charge");
		l7.setBounds(10,100,200,20);
		l7.setFont(f2);
		p.add(l7);
		
		l8=new JLabel("Mandatory Document recieved");
		l8.setBounds(10,170,300,20);
		l8.setFont(f2);
		p.add(l8);
		
		l9=new JLabel("Alternate Number");
		l9.setBounds(100,330,250,35);
		l9.setFont(f1);
		
		l10=new JLabel("/+ 25");
		l10.setBounds(160,130,55,20);
		l10.setFont(f2);
		
		
		t1=new JLabel();
		t1.setBounds(1050,170,120,28);
		t1.setFont(f2);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calobj = Calendar.getInstance();
		t1.setText(df.format(calobj.getTime()));
		
		
		t3=new JTextField(10);
		t3.setBounds(350,230,250,35);	
		t3.setFont(f2);
		
		t4=new JTextField(10);
		t4.setBounds(350,280,250,35);
		t4.setFont(f2);
		
		
		t2=new JTextField(10);
		t2.setBounds(350,430,250,35);
		t2.setFont(f2);
		
	
		t6=new JTextField(10);
		t6.setBounds(350,330,250,35);//Address
		t6.setFont(f2);
		
		r1=new JRadioButton("Prepaid");
		r1.setFont(f2);
		r1.setBounds(350,380,90,35);
		r1.setBackground(Color.white);
		r1.addItemListener(this);
		
		r2=new JRadioButton("Postpaid");
		r2.setFont(f2);
		r2.setBounds(440,380,100,35);
		r2.setBackground(Color.white);
		r2.addItemListener(this);
		
		brg=new ButtonGroup();
		brg.add(r2);
		brg.add(r1);
		
		
		r1.setSelected(true);

		b1=new JButton("Submit");
		b1.setBounds(410,600,80,35);
		b1.addActionListener(this);
	
		b2=new JButton("Clear");
		b2.setBounds(580,600,80,35);
		b2.addActionListener(this);
		b2.addKeyListener(this);
		b3=new JButton("Back");
		b3.setBounds(745,600,80,35);
		b3.addActionListener(this);
	
		cb1=new JCheckBox("SIM Block");
		cb1.setBackground(Color.white);
		cb1.setBounds(20,50,90,20);
		
		cb2=new JCheckBox("SIM Fault");
		cb2.setBackground(Color.white);
		cb2.setBounds(110,50,90,20);
		
		cb3=new JCheckBox("Lost");
		cb3.setBackground(Color.white);
		cb3.setBounds(200,50,50,20);
		
		cb4=new JCheckBox("Airtel Money Bank");
		cb4.setBackground(Color.white);
		cb4.setBounds(255,50,129,20);
		
		cb5=new JCheckBox("Micro");
		cb5.setBackground(Color.white);
		cb5.setBounds(390,50,70,20);
		
		cb6=new JCheckBox("Nano");
		cb6.setBackground(Color.white);
		cb6.setBounds(460,50,55,20);
		
		cb7=new JCheckBox("OCB");
		cb7.setBackground(Color.white);
		cb7.setBounds(30,130,55,20);
		
		cb8=new JCheckBox("FOC");
		cb8.setBackground(Color.white);
		cb8.setBounds(100,130,55,20);
		p.add(l10);
		
		cb9=new JCheckBox("Address Proof");
		cb9.setBackground(Color.white);
		cb9.setBounds(30,200,130,20);
		cb10=new JCheckBox("ID Proof");
		cb10.setBackground(Color.white);
		cb10.setBounds(162,200,80,20);
		
		cb11=new JCheckBox("Photograph");
		cb11.setBackground(Color.white);
		cb11.setBounds(245,200,95,20);
		
		cb12=new JCheckBox("NOC");
		cb12.setBackground(Color.white);
		cb12.setBounds(350,200,95,20);
		
		p.add(cb1);
		p.add(cb2);
		p.add(cb3);
		p.add(cb4);
		p.add(cb5);
		p.add(cb6);
		p.add(cb7);
		p.add(cb8);
		p.add(cb9);
		p.add(cb10);
		p.add(cb11);
		
		
		
		
		
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
		fm.add(p2);
		fm.add(l9);
		fm.add(t1);
		fm.add(t2);
		fm.add(t3);
		fm.add(t4);
		
		fm.add(t6);
		fm.add(p);
		fm.add(p1);
		fm.add(r1);
		fm.add(r2);
		fm.add(erno1);
		fm.add(erno2);
		fm.add(erno3);
		fm.add(erno7);
		fm.add(erno8);
		fm.add(erno9);
		fm.add(erno10);
		p.add(erno4);
		p.add(erno5);
		p2.add(erno6);
		
	
		
		f.addKeyListener(this);
		f.add(fm);
		f.setVisible(true);		
	 }
	 public void actionPerformed(ActionEvent e)
	 {
		 if(e.getSource()==b1)
		 {
			 reason="";
			 doc="";
			 name="";
			 newno="";
			 mno="";
			 reason="";
			 doc="";
			 ch=25;
			 name=t3.getText();
			 newno=t4.getText();
			 mno=t6.getText();
			 erno4.setVisible(false);
			 erno5.setVisible(false);
			 erno2.setVisible(false);
			 erno1.setVisible(false);
			 erno7.setVisible(false);
			 erno8.setVisible(false);
			 p2.setVisible(false);	
			 erno3.setVisible(false);
			 flag=true;
			 if(!cb1.isSelected() && !cb6.isSelected() && !cb5.isSelected() && !cb4.isSelected() && !cb3.isSelected() && !cb2.isSelected())
		 	 {
		 	 	erno4.setVisible(true);
		 	 	flag=false;
		 	 }
		 	 if(!cb7.isSelected() && !cb8.isSelected() && !cb9.isSelected() && !cb10.isSelected() && !cb11.isSelected())
		 	 {
		 		erno5.setVisible(true);
		 		flag=false;
		 	 }
		 	 
		 	if(name.length()==0 || name.length()==1 )
	 		{
	 			flag=false;
	 			erno2.setVisible(true);
	 			erno1.setVisible(false);
	 		}
		 	boolean namec=true;
	 		if(name.length()>0)
	 		{
	 			for(int i=0;i<name.length();i++)
	 			{
	 				if(Character.isDigit(name.charAt(i)))
	 				{
	 					flag=false;
	 					namec=false;
	 					erno1.setVisible(true);
	 					erno2.setVisible(false);
	 					break;
	 				}
	 			
	 			}
	 		}
	 		if(namec)
	 		{
	 			if(name.length()<4 && name.length()!=0)
		 		{
	 				erno1.setVisible(false);
 					erno2.setVisible(false);
 					
		 			int c=JOptionPane.showConfirmDialog(null, "Are You Sure about Name???","Confirmation",JOptionPane.YES_NO_OPTION);
		 			if(c!=JOptionPane.YES_OPTION)
		 			{
		 				flag=false;
		 				erno1.setVisible(true);
	 					erno2.setVisible(false);
	 					
		 			}
		 			
		 		}
	 		}
	 		if(newno.length()<=0)
 			{
 				if(newno.length()==0)
 				{
 					p2.setVisible(true);	
 					erno3.setVisible(false);
 					flag=false;
 				}
 			}
 			if(newno.length()>10 || newno.length()<10)
 			{
 				if(newno.length()!=0)
 				{
 					flag=false;
 					erno3.setVisible(true);	
 					p2.setVisible(false);
 				}

 			}
 			if(newno.length()==10)
 			{
 				for(int i=0;i<newno.length();i++)
	 			{
	 				if(!Character.isDigit(newno.charAt(i)))
	 				{
	 					flag=false;
	 					erno3.setVisible(true);	
	 					p2.setVisible(false);
	 					break;
	 				}
	 			
	 			}
 			}
		 	 
 			if(mno.length()<=0)
 			{
 				if(mno.length()==0)
 				{
 					erno8.setVisible(true);	
 					erno7.setVisible(false);
 					flag=false;
 				}
 			}
 			if(mno.length()>10 || mno.length()<10)
 			{
 				if(mno.length()!=0)
 				{
 					flag=false;
 					erno7.setVisible(true);	
 					erno8.setVisible(false);
 				}

 			}
 			if(mno.length()==10)
 			{
 				for(int i=0;i<mno.length();i++)
	 			{
	 				if(!Character.isDigit(mno.charAt(i)))
	 				{
	 					flag=false;
	 					erno7.setVisible(true);	
	 					erno8.setVisible(false);
	 					break;
	 				}
	 			
	 			}
 			}
 			if(r1.isSelected())
 			{
 				st="Prepaid";
 			}
 			if(r2.isSelected())
 			{
 				st="postpaid";
 				ano=t2.getText();
 				if(ano.length()<=0)
 	 			{
 	 				if(ano.length()==0)
 	 				{
 	 					erno10.setVisible(true);	
 	 					erno9.setVisible(false);
 	 					flag=false;
 	 				}
 	 			}
 	 			if(ano.length()>10 || ano.length()<10)
 	 			{
 	 				if(ano.length()!=0)
 	 				{
 	 					flag=false;
 	 					erno9.setVisible(true);	
 	 					erno10.setVisible(false);
 	 				}

 	 			}
 	 			if(ano.length()==10)
 	 			{
 	 				for(int i=0;i<ano.length();i++)
 		 			{
 		 				if(!Character.isDigit(ano.charAt(i)))
 		 				{
 		 					flag=false;
 		 					erno9.setVisible(true);	
 		 					erno10.setVisible(false);
 		 					break;
 		 				}
 		 			
 		 			}
 	 			}
 			}
 			
		 	 
		 	 
		 	if(cb1.isSelected())
		 	 {
		 		 reason=reason+"SIM Block";
		 	 }
		 	if(cb2.isSelected())
		 	 {
		 		if(cb1.isSelected())
		 		{
		 			reason=reason+",SIM Fault";
		 		}
		 		else
		 		 reason=reason+"SIM Fault";
		 	 }
		 	if(cb3.isSelected())
		 	 {
		 		if(cb2.isSelected())
		 		{
		 			reason=reason+",SIM Lost";
		 		}
		 		else
		 		 reason=reason+"SIM Lost";
		 	 }
		 	if(cb4.isSelected())
		 	 {
		 		if(cb3.isSelected())
		 		{
		 			reason=reason+",AMB";
		 		}
		 		else
		 		 reason=reason+"SIM AMB";
		 	 }
		 	if(cb5.isSelected())
		 	 {
		 		if(cb4.isSelected())
		 		{
		 			reason=reason+",Micro";
		 		}
		 		else
		 		 reason=reason+"Micro";
		 	 }
		 	if(cb6.isSelected())
		 	 {
		 		if(cb5.isSelected())
		 		{
		 			reason=reason+",Nano";
		 		}
		 		else
		 		 reason=reason+"Nano";
		 	 }
		 	if(cb7.isSelected())
		 	 {
		 		 ch=ch+25;
		 	 }
		 	if(cb8.isSelected())
		 	 {
		 		 ch=ch+50;
		 	 }
		 	if(cb9.isSelected())
		 	 {
		 		 doc=doc+"A.P.";
		 	 }
		 	if(cb10.isSelected())
		 	 {
		 		if(cb9.isSelected())
			 	 {
		 			doc=doc+",ID Proof";
			 	 }
		 		if(!cb9.isSelected())
			 	 {
		 			doc=doc+"ID Proof";
			 	 }		 		 
		 	 }
		 	if(cb11.isSelected())
		 	 {
		 		if(cb10.isSelected())
			 	 {
		 			doc=doc+",Photograph";
			 	 }
		 		if(!cb10.isSelected())
			 	 {
		 			doc=doc+"Photograph";
			 	 }
		 	}
		 	if(flag)
		 	{
		 		try
	 			{
		 			int c=0;
	 				/*Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	 				Connection con=DriverManager.getConnection("Jdbc:Odbc:Micro-POS");*/
	 				Class.forName("com.mysql.jdbc.Driver");
	 				Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/micropos","root","");
	 				String qry1="select * from SIMR";
	 				PreparedStatement stmt1=con1.prepareStatement(qry1);
	 				ResultSet rs=stmt1.executeQuery();
	 				while(rs.next())
	 				{
	 					c=rs.getInt(1);
	 				}
	 				
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/micropos","root","");
	 				String qry="insert into SIMR values(?,?,?,?,?,?,?,?,?,?)";
	 				PreparedStatement stmt=con.prepareStatement(qry);
	 				stmt.setInt(1,c+1);
	 				stmt.setString(2,name);
	 				stmt.setString(3,newno);
	 				stmt.setString(4,mno);
	 				stmt.setString(5,ano);
	 				stmt.setString(6,ano);
	 				stmt.setString(7,reason);
	 				stmt.setInt(8,ch);
	 				stmt.setString(9,doc);
	 				stmt.setString(10,t1.getText());
	 				stmt.executeUpdate();
	 				JOptionPane.showMessageDialog(null,"Saved Successfully!!!!!","Success",JOptionPane.PLAIN_MESSAGE);
	 				con.close();
	 				
	 				t3.setText("");
	 		 		t4.setText("");
	 		 		t2.setText("");
	 		 		t6.setText("");
	 		 		cb1.setSelected(false);
	 		 		cb2.setSelected(false);
	 		 		cb3.setSelected(false);
	 		 		cb4.setSelected(false);
	 		 		cb5.setSelected(false);
	 		 		cb6.setSelected(false);
	 		 		cb7.setSelected(false);
	 		 		cb8.setSelected(false);
	 		 		cb9.setSelected(false);
	 		 		cb10.setSelected(false);
	 		 		cb11.setSelected(false);
	 	
	 			}
	 			catch(Exception a)
	 			{
	 				System.out.println(a);	
	 			}
		 	}
		 }
		 if(e.getSource()==b2)
	 	 {
	 		
	 		t3.setText("");
	 		t4.setText("");
	 		t2.setText("");
	 		t6.setText("");
	 		cb1.setSelected(false);
	 		cb2.setSelected(false);
	 		cb3.setSelected(false);
	 		cb4.setSelected(false);
	 		cb5.setSelected(false);
	 		cb6.setSelected(false);
	 		cb7.setSelected(false);
	 		cb8.setSelected(false);
	 		cb9.setSelected(false);
	 		cb10.setSelected(false);
	 		cb11.setSelected(false);
	 		erno4.setVisible(false);
			 erno5.setVisible(false);
			 erno2.setVisible(false);
			 erno1.setVisible(false);
			 erno7.setVisible(false);
			 erno8.setVisible(false);
			 p2.setVisible(false);	
			 erno3.setVisible(false);
			 erno10.setVisible(false);
	 		
	 	 }
	 	if(e.getSource()==b3)
	 	{
	 		
	 		t3.setText("");
	 		t4.setText("");
	 		t6.setText("");
	 		new MainForm();
	 		f.setVisible(false);
	 	}
	 		
	 	
	 		
	 	 
	 	
	 }
	 
	 public void itemStateChanged(ItemEvent e)
	 {
	 	
	 		if(r1.isSelected())
	 		{
	 			t2.setVisible(false);
	 			l2.setVisible(false);
	 			p1.setVisible(false);
	 			erno10.setVisible(false);
	 		}
	 		if(r2.isSelected())
	 		{
	 			t2.setVisible(true);
	 			l2.setVisible(true);
	 			p1.setVisible(true);
	 		}
	 		
	 		/*if(!cb1.isSelected() && !cb6.isSelected() && !cb5.isSelected() && !cb4.isSelected() && !cb3.isSelected() && !cb2.isSelected())
		 	 {
		 	 	erno4.setVisible(true);
		 	 }
		 	 /*if(!cb7.isSelected() && !cb8.isSelected() && !cb9.isSelected() && !cb10.isSelected() && !cb11.isSelected())
		 	 {
		 		erno5.setVisible(true);
		 	 }	*/
	 }
	 	public void keyPressed(KeyEvent e)
		{
	 		if((KeyEvent.CTRL_MASK) != 0 && e.getKeyCode()==KeyEvent.VK_BACK_SPACE)
			{
				new MainForm();
				f.setVisible(false);
			}
	 		System.out.println("Pressed");
			
		
		}
	public void keyReleased(KeyEvent e)
	{}
	public void keyTyped(KeyEvent e)
	{}
	
	 	
}


class SIMReplaceForm
{
	public static void main(String arg[])
	{
		new SIMReplace();
	}
}//ERROR IS RELATED TO t2 CHECK IT