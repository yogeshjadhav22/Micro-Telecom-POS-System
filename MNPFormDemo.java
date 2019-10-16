import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

class MNPForms implements ActionListener,ItemListener,KeyListener
{
	
	JButton b1,b2,b3;
	JLabel t1,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l,li,lr,erno1,erno2,erno3,erno4,erno5,erno6;
	JFrame f;
	JTextField t2,t3,t4,t5,t6,t7;
	Font f1,f2,f3,f4,f5;
	JComboBox cb1,cb3;
	JRadioButton r1,r2;
	String gen,poi,pa="-";
	int frc;
	ButtonGroup brg;
	
	 public MNPForms()
	 {
	 
	 	f=new JFrame("POS - MNP Activatoin");
		f.setSize(1366,768);
		f.setResizable(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.addKeyListener(this);
		JLabel fm=new JLabel(new ImageIcon("D:\\Project\\Images\\BackGround.jpg"));
		fm.setBounds(0,00,1366,768);
		JLabel header=new JLabel(new ImageIcon("D:\\Project\\Images\\headerMNP.jpg"));
		header.setBounds(0,0,1455,161);
		fm.add(header);
		
		f.setLayout(null);
		f1=new Font("Arial",Font.BOLD,20);
		f2=new Font("Arial",Font.PLAIN,18);
		f3=new Font("Cooper Black",Font.BOLD,25);
		f4=new Font("Arial",Font.BOLD,16);
		f5=new Font("Arial",Font.ITALIC,20);
		
		
		l=new JLabel("Activation Details");
		l.setBounds(500,50,300,50);
		l.setFont(f2);
		l.setForeground(Color.BLUE);
		
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
		
		erno3=new JLabel("Invalid");
		erno3.setForeground(Color.RED);
		erno3.setVisible(false);
		erno3.setFont(f5);	
		erno3.setBounds(600,230,250,35);

		erno4=new JLabel("Empty Field Not Allowed");
		erno4.setForeground(Color.RED);
		erno4.setVisible(false);
		erno4.setFont(f5);	
		erno4.setBounds(600,230,250,35);

		erno5=new JLabel("Empty Field Not Allowed");
		erno5.setForeground(Color.RED);
		erno5.setVisible(false);
		erno5.setFont(f5);	
		erno5.setBounds(1100,305,250,35);

		erno6=new JLabel("Empty Field Not Allowed");
		erno6.setForeground(Color.RED);
		erno6.setVisible(false);
		erno6.setFont(f5);	
		erno6.setBounds(600,285,250,35);
		
		l1=new JLabel("Date");
		l1.setBounds(1000,170,100,35);
		l1.setFont(f1);
		
		
		l2=new JLabel("Number To Port");
		l2.setBounds(700,300,250,35);
		l2.setFont(f1);
		
		l3=new JLabel("Customer Name");
		l3.setBounds(100,230,250,35);
		l3.setFont(f1);
	
		l4=new JLabel("Alternate Number");
		l4.setBounds(100,280,250,35);
		l4.setFont(f1);
	
		l5=new JLabel("Address");
		l5.setBounds(100,380,250,35);
		l5.setFont(f1);
	
		l6=new JLabel("UPC");
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
		
		t1=new JLabel();
		t1.setBounds(1050,170,120,28);
		t1.setFont(f2);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calobj = Calendar.getInstance();
		t1.setText(df.format(calobj.getTime()));
		
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
	
		t7=new JTextField(10);	
		t7.setBounds(850,340,90,30);
		t7.setFont(f2);

		cb1=new JComboBox();
		cb1.addItem("Adhar Card");	
		cb1.addItem("Voting Card");	
		cb1.addItem("PAN Card");	
		
		cb1.setBounds(850,440,90,30);
		
	
		
		
		cb3=new JComboBox();
		cb3.addItem("Bank Passbook");
		cb3.addItem("Rashan Card");
		cb3.addItem("Driving Licenes");
		
		cb3.setBounds(850,490,90,35);
		cb3.setVisible(false);
		cb1.addItemListener(this);
		
		r1=new JRadioButton("Male");
		r1.setFont(f4);
		r1.setBounds(350,330,60,35);
		
		r2=new JRadioButton("Female");
		r2.setFont(f4);
		r2.setBounds(410,330,80,35);
		
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
	
		b3=new JButton("Back");
		b3.setBounds(745,600,80,35);
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
		fm.add(t7);
		fm.add(cb1);
		fm.add(cb3);
		fm.add(r1);
		fm.add(r2);
		fm.add(erno1);
		fm.add(erno2);
		fm.add(erno3);
		fm.add(erno4);
		fm.add(erno5);
		fm.add(erno6);
		fm.add(l10);
		
		
		f.add(fm);
		
		//f.addKeyListener(this);
		f.setVisible(true);		
	 }
	 public void actionPerformed(ActionEvent e)
	 {
	 	 String mno,name,newno,date,adr,poino,upc;
	 	 Boolean flag=true;
	 	
	 	 erno1.setVisible(false);
	 	 erno2.setVisible(false);
	 	 erno3.setVisible(false);
	 	 erno4.setVisible(false);
	 	 erno5.setVisible(false);
	 	 erno6.setVisible(false);
	 	if(e.getSource()==b1)
	 	{
	 		
	 		date=t1.getText();
	 		newno=t2.getText();
	 		name=t3.getText();
	 		mno=t4.getText();
	 		poino=t5.getText();
	 		adr=t6.getText();
	 		upc=t7.getText();
	 		poi=(String)cb1.getSelectedItem();
	 		
	 	
	 		
	 		if(r1.isSelected())
	 		{
	 			gen="Male";
	 		}
	 		if(r2.isSelected())
	 		{
	 			gen="Female";
	 		}
	 		/* Taking Value From Check Boxes*/
	 	
	 			
	 
	 		if(name.length()<=0)
	 		{
	 			flag=false;
	 			erno4.setVisible(true);
	 			
	 		}
	 		if(name.length()>0)
	 		{
	 			for(int i=0;i<name.length();i++)
	 			{
	 				if(Character.isDigit(name.charAt(i)))
	 				{
	 					flag=false;
	 					erno3.setVisible(true);
	 					break;
	 				}
	 			
	 			}
	 		}
	 		
	 
	 
	 	//	JOptionPane.showMessageDialog(null,mno,"Logged",JOptionPane.PLAIN_MESSAGE);
	 	
	 		/*Checking Custpmer Number And New Number is Valid Or Not */
	 		if(mno.length()>10 || mno.length()<10  || newno.length()>10 || newno.length()<10 || newno.length()==0 || mno.length()==0 )
	 		{
	 			if(mno.length()>0)
	 			{
	 				if(mno.length()>10 || mno.length()<10)
	 				{
	 					erno2.setVisible(true);
	 				}
	 			}
	 		
	 		
	 			if(newno.length()<=0)
	 			{
	 				if(newno.length()==0)
	 				{
	 					erno5.setVisible(true);	
	 				}
	 			}
	 			if(newno.length()>10 || newno.length()<10)
	 			{
	 				if(newno.length()!=0)
	 				{
	 					erno1.setVisible(true);	 					
	 				}
	
	 			}
	 			if(mno.length()==0)
	 			{
	 				erno6.setVisible(true);	
	 			}
	 			
	 		
	 			flag=false;
	 			//JOptionPane.showMessageDialog(null,"Enter Valid Number","Invalid",JOptionPane.ERROR_MESSAGE);
	 		}
	 		
	 	
	 		/*Adding Entries into Table*/
	 		
	 		if(flag==true)
	 		{
	 			try
	 			{
	 				/*Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	 				Connection con=DriverManager.getConnection("Jdbc:Odbc:Micro-POS");*/
	 				Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/micropos","root","");
	 				String qry="insert into MNP values(?,?,?,?,?,?,?,?,?,?)";
	 				PreparedStatement stmt=con.prepareStatement(qry);
	 				stmt.setString(1,name);
	 				stmt.setString(2,mno);
	 				stmt.setString(3,gen);
	 				stmt.setString(4,adr);
	 				stmt.setString(5,newno);
	 				stmt.setString(6,poi);
	 				stmt.setString(7,poino);
	 				stmt.setString(8,upc);
	 				stmt.setString(9,pa);
	 				stmt.setString(10,date);
	 				stmt.executeUpdate();
	 				JOptionPane.showMessageDialog(null,"Saved Successfully!!!!!","Success",JOptionPane.PLAIN_MESSAGE);
	 				con.close();
	 				t2.setText("");
	 				t3.setText("");
	 				t4.setText("");
	 				t5.setText("");
	 				t6.setText("");
	 				t7.setText("");
	 	
	 			}
	 			catch(Exception a)
	 			{
	 				System.out.println(a);	
	 			}
	 		}
	 		if(flag==false)
	 		{
	 			//JOptionPane.showMessageDialog(null,"There Is Problem To Save!!!!!","Invalid",JOptionPane.ERROR_MESSAGE);
	 		}
	 		
	 	}
	 	if(e.getSource()==b2)
	 	{
	 		t2.setText("");
	 		t3.setText("");
	 		t4.setText("");
	 		t5.setText("");
	 		t6.setText("");
	 		t7.setText("");
	 	}
	 	if(e.getSource()==b3)
	 	{
	 		t2.setText("");
	 		t3.setText("");
	 		t4.setText("");
	 		t5.setText("");
	 		t6.setText("");
	 		new MainForm();
	 		f.setVisible(false);
	 	}
	 	
	 }
	 
	 public void itemStateChanged(ItemEvent e)
	 {
	 		poi=(String)cb1.getSelectedItem();
	 		pa="-";
	 	//	JOptionPane.showMessageDialog(null,poi,"Logged",JOptionPane.PLAIN_MESSAGE);
	 		if(poi.equals("PAN Card"))
	 		{
	 			cb3.setVisible(true);
	 			l10.setVisible(true);
	 			pa=(String)cb3.getSelectedItem();
			}
	 		if(poi=="Adhar Card")
	 		{
	 			cb3.setVisible(false);
	 			l10.setVisible(false);
	 		}
	 		if(poi=="Voting Card")
	 		{
	 			cb3.setVisible(false);
	 			l10.setVisible(false);
	 		}
	 }
	
	public void keyPressed(KeyEvent e) 
	{
		
		if((KeyEvent.CTRL_MASK) != 0 )//&& e.getKeyCode()==KeyEvent.VK_BACK_SPACE)
		{
			new LogIn1();
			f.setVisible(false);
		}
	}
	
	public void keyReleased(KeyEvent e) {
		
		
	}
	
	public void keyTyped(KeyEvent e) {
		
		
	}
	
	 	
}


class MNPFormFormsDemo
{
	public static void main(String arg[])
	{
		new MNPForms();
	}
}