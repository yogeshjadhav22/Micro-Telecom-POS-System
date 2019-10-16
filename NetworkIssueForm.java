import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

class NetworkIssue implements ActionListener,ItemListener,KeyListener
{
	
	JButton b1,b2,b3,b4,b5;
	JLabel t1,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l,li,lr,erno1,erno2,erno3,erno4,erno5,erno6,erno7,erno8,erno9,erno10;
	JFrame f;
	JTextField t2,t3,t4,t6;
	
	Font f1,f2,f3,f4,f5;
	JRadioButton r1,r2;
	JPanel p1,p2;
	JTextArea a;
	boolean flag=true ;
	int rno;
	String name,add,pl,mno;
	ButtonGroup brg;
	BufferedWriter bw;
	 public NetworkIssue()
	 {
	 
	 	f=new JFrame("POS - Complaints");
		f.setSize(1366,768);
		f.setResizable(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel fm=new JLabel(new ImageIcon("D:\\Project\\Images\\BackGround.jpg"));
		fm.setBounds(0,00,1366,768);
		JLabel header=new JLabel(new ImageIcon("D:\\Project\\Images\\headerComplaint.jpg"));
		header.setBounds(0,0,1455,161);
		fm.add(header);
		
		f.setLayout(null);
		f1=new Font("Lucida Fax",Font.PLAIN,16);
		f2=new Font("Lucida Fax",Font.BOLD,16);
		f3=new Font("Cooper Black",Font.PLAIN,25);
		f4=new Font("Lucida Fax",Font.BOLD,18);
		f5=new Font("Lucida Fax",Font.ITALIC,20);
		
		p1=new JPanel();
		p1.setBounds(330,180,600,600);
		p1.setBackground(Color.white);
	
		p1.setLayout(null);
		fm.add(p1);
		
		li=new JLabel("Information Of Customer");
		li.setFont(f3);
		li.setBounds(100,170,400,35);
		
		erno1=new JLabel("* Invalid Name");
		erno1.setForeground(Color.RED);
		erno1.setVisible(false);
		erno1.setFont(f5);
		erno1.setBounds(400,100,150,30);

		
		erno2=new JLabel("* Invalid Number");
		erno2.setForeground(Color.RED);
		erno2.setVisible(false);
		erno2.setFont(f5);	
		erno2.setBounds(400,150,250,35);//350,230,250,35
		
		erno3=new JLabel("* Enter Address");
		erno3.setForeground(Color.RED);
		erno3.setVisible(false);
		erno3.setFont(f5);	
		erno3.setBounds(400,200,250,35);
		
		erno4=new JLabel("* Enter Place");
		erno4.setForeground(Color.RED);
		erno4.setVisible(false);
		erno4.setFont(f5);	
		erno4.setBounds(400,250,250,35);
		p1.add(erno1);
		p1.add(erno2);
		p1.add(erno3);
		p1.add(erno4);
		
		
		
		
		l1=new JLabel("Date");
		l1.setBounds(998,166,100,35);
		l1.setFont(f1);

		t1=new JLabel();
		t1.setBounds(1050,170,120,28);
		t1.setFont(f2);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calobj = Calendar.getInstance();
		t1.setText(df.format(calobj.getTime()));
		
		l2=new JLabel("Customer Name");
		l2.setBounds(50,100,150,30);
		l2.setFont(f1);
	
		l3=new JLabel("Number Of Customer");
		l3.setBounds(50,150,200,30);
		l3.setFont(f1);
	
		l4=new JLabel("Address");
		l4.setBounds(50,200,150,30);
		l4.setFont(f1);
	
		l5=new JLabel("Place Of Network Issue");
		l5.setBounds(50,250,250,30);
		l5.setFont(f1);
		
		
		t3=new JTextField(10);
		t3.setBounds(250,100,150,30);	
		t3.setFont(f2);
		
		t4=new JTextField(10);
		t4.setBounds(250,150,150,30);
		t4.setFont(f2);
		
		
		t2=new JTextField(10);
		t2.setBounds(250,200,150,30);
		t2.setFont(f2);
		
	
		t6=new JTextField(10);
		t6.setBounds(250,250,150,30);//Address
		t6.setFont(f2);
			
		b3=new JButton("Submit");
		b3.setBounds(150,350,80,35);
		b3.addActionListener(this);
		
				
		b4=new JButton("Clear");
	    b4.setBounds(280,350,80,35);
		b4.addActionListener(this);
		
				
		b5=new JButton("Cancel");
		b5.setBounds(410,350,80,35);
		b5.addActionListener(this);
		f.add(fm);
		fm.add(l1);
		fm.add(t1);
		
		p1.add(b3);
		p1.add(l2);
		p1.add(l3);
		p1.add(l4);
		p1.add(l5);
		p1.add(t2);
		p1.add(t3);
		p1.add(t4);
		p1.add(t6);
		p1.add(b4);
		p1.add(b5);
		f.addKeyListener(this);
		
		f.setVisible(true);		
	 }
	 boolean check()
	 {
		 boolean Cflag=true;
		 if(name.length()<=0)
	 		{
			 	erno1.setVisible(true);
			 	flag=false;
	 		}
		 boolean cflag=true;
		 
		 
		 if(name.length()>0)
	 		{
			 
	 			for(int i=0;i<name.length();i++)
	 			{
	 				if(Character.isDigit(name.charAt(i)))
	 				{
	 					Cflag=false;
	 					erno1.setVisible(true);
	 					break;
	 					
	 				}
	 			
	 			}
	 		}
		  if(Cflag && name.length()<=5 && name.length()!=0)
		 {
			 if(JOptionPane.showConfirmDialog(null, "Are You Sure About Name","Confirm",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
				 erno1.setVisible(false);
			 else{
				erno1.setVisible(true);
				 flag=false;
			 }
		 }
		  
		  if(mno.length()>10 || mno.length()<10 || mno.length()==0 )
	 		{
				erno2.setVisible(true);
	 			flag=false;
	 			//JOptionPane.showMessageDialog(null,"Enter Valid Number","Invalid",JOptionPane.ERROR_MESSAGE);
	 		}
			if(mno.length()==10)
			{
					for(int i=0;i<mno.length();i++)
					{
						if(!Character.isDigit((mno.charAt(i))))
						{
							
							flag=false;
							erno2.setVisible(true);
							break;
						}
					}
					
			}
			if(add.length()<=0)
			{
				erno3.setVisible(true);
				flag=false;
			}
			if(pl.length()<=0)
			{
				erno4.setVisible(true);
				flag=false;
			}
		  
		  return flag;
		
	 }
		
	

	 public void actionPerformed(ActionEvent e)
	 {
		 name=t3.getText();
		 add=t2.getText();
		 pl=t6.getText();
		 mno=t4.getText();
		 flag=true;
		 erno1.setVisible(false);
		 erno2.setVisible(false);
		 erno3.setVisible(false);
		 erno4.setVisible(false);
		 if(e.getSource()==b3)
		 {
			 if(check())
			 {
				 try
				 {
					 FileOutputStream fos=new FileOutputStream("NetworkIssue.dat",true);
					  bw=new BufferedWriter(new OutputStreamWriter(fos));
					  Class.forName("com.mysql.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/micropos","root","");
						PreparedStatement pst=con.prepareStatement("select * from rno");
						
							
						ResultSet rs=pst.executeQuery();
						while(rs.next())
						{
						rno=1+rs.getInt(1);
						}
						rno=rno+1;
						
						PreparedStatement pst1=con.prepareStatement("insert into rno values(?)");
						pst1.setInt(1, rno);
						pst1.executeUpdate();
						con.close();
					 bw.newLine();
					 String line = rno+":"+name+":"+mno+":"+add+":"+pl+":"+t1.getText();
					 bw.newLine();
					 bw.write(line);
					 
					 bw.close();
					 JOptionPane.showMessageDialog(null, "Your Complaint Submitted Successfully\n Please Note Your Reference Number : "+rno,"Success",JOptionPane.PLAIN_MESSAGE);
					 t2.setText("");
					 t3.setText("");
					 t4.setText("");
					 t6.setText("");
					 
				 }
				 catch(Exception ee)
				 {
					 System.out.println(ee);
				 }
			 }
		 }
		 if(e.getSource()==b5)
		 {
			 new MainForm();
			 f.setVisible(false);
		 }
		 if(e.getSource()==b4)
		 {
			 try{t2.setText("");
			 t3.setText("");
			 t4.setText("");
			 t6.setText("");
			 erno1.setVisible(false);
			 erno2.setVisible(false);
			 erno3.setVisible(false);
			 erno4.setVisible(false);
			 }
			 catch(Exception ere)
			 {
				 
			 }
		 }
		 
	 }
	  public void itemStateChanged(ItemEvent e)
	 {
	  		
	 }
	 	public void keyPressed(KeyEvent e)
		{
	 		if((KeyEvent.CTRL_MASK) != 0 && e.getKeyCode()==KeyEvent.VK_BACK_SPACE)
			{
				new MainForm();
				f.setVisible(false);
			}
	 		
		}
	public void keyReleased(KeyEvent e)
	{}
	public void keyTyped(KeyEvent e)
	{}
	
	 	
}


class NetworkIssueForm
{
	public static void main(String arg[])
	{
		new NetworkIssue();
	}
}//ERROR IS RELATED TO t2 CHECK IT