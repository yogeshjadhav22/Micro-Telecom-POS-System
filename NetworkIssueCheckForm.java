import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

class NetworkIssueCheck implements ActionListener,ItemListener,KeyListener
{
	
	JButton b1,b2,b3,b4,b5;
	JLabel t1,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l,li,lr,erno1,erno2,erno3,l11,l12,l13,rnol;
	JFrame f;
	JTextField t3,t4;
	Font f1,f2,f3,f4,f5;
	JRadioButton r1,r2;
	JPanel p1,p2;
	JTextArea a;
	String rno,name;
	boolean flag=true ;
	 BufferedReader br ;
	ButtonGroup brg;
	
	 public NetworkIssueCheck()
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
		p1.setBounds(400,200,600,400);
		p1.setBackground(Color.white);
		p1.setLayout(null);
		fm.add(p1);
		try {
			br=new BufferedReader(new FileReader("NetworkIssue.dat"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		erno2=new JLabel("* Enter Name");
		erno2.setForeground(Color.RED);
		erno2.setVisible(false);
		erno2.setFont(f5);	
		erno2.setBounds(600,229,250,35);//350,230,250,35
		l1=new JLabel("Date");
		l1.setBounds(998,166,100,35);
		l1.setFont(f1);
		t1=new JLabel();
		t1.setBounds(1050,170,120,28);
		t1.setFont(f2);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calobj = Calendar.getInstance();
		t1.setText(df.format(calobj.getTime()));
		
		l3=new JLabel("Customer Name");
		l3.setBounds(50,290,160,30);
		l3.setFont(f1);
		
		t4=new JTextField();
		t4.setBounds(250,290,150,30);	
		t4.setFont(f2);
		b2=new JButton("Show");
		b2.setBounds(110,350,90,35);
		b2.addActionListener(this);
		b4=new JButton("Next");
		b4.setBounds(110,350,90,35);
		b4.addActionListener(this);
		b4.setVisible(false);
		b3=new JButton("Cancel");
		b3.setBounds(250,350,90,35);
		b3.addActionListener(this);
		b1=new JButton("Back");
		b1.setBounds(10,10,100,35);
		b1.addActionListener(this);
		header.add(b1);
		
		l4=new JLabel("Customer Name ::");
		l4.setBounds(100,100,150,30);
		l4.setFont(f1);
	
		l5=new JLabel("Number Of Customer ::");
		l5.setBounds(100,150,200,30);
		l5.setFont(f1);
	
		l6=new JLabel("Address ::");
		l6.setBounds(100,200,150,30);
		l6.setFont(f1);
	
		l7=new JLabel("Place Of Network Issue ::");
		l7.setBounds(100,250,250,30);
		l7.setFont(f1);
		
		l8=new JLabel("l8");
		l8.setBounds(360,100,150,30);
		l8.setFont(f1);
	
		l9=new JLabel("l9");
		l9.setBounds(360,150,200,30);
		l9.setFont(f1);
	
		l10=new JLabel("l10");
		l10.setBounds(360,200,150,30);
		l10.setFont(f1);
	
		l11=new JLabel("l11");
		l11.setBounds(360,250,250,30);
		l11.setFont(f1);
		
		l12=new JLabel("l12");
		l12.setBounds(360,300,250,30);
		l12.setFont(f1);
		
		l13=new JLabel("Complaint Date ::");
		l13.setBounds(100,300,250,30);
		l13.setFont(f1);
		
		rnol=new JLabel();
		rnol.setBounds(80,50,300,30);
		rnol.setFont(f1);
		
		p1.add(l4);
		p1.add(l5);
		p1.add(l6);
		p1.add(l7);
		p1.add(l8);
		p1.add(l9);
		p1.add(l10);
		p1.add(l11);
		p1.add(l13);
		p1.add(l12);
		p1.add(rnol);
		
		f.add(fm);
		fm.add(l1);
		fm.add(t1);
		p1.add(b4);
		
	
		
		fm.add(l3);
		fm.add(t4);
		fm.add(b2);
		fm.add(b3);
		f.addKeyListener(this);
		
		f.setVisible(true);		
	 }
	 boolean check()
	 {
		
		 
		 
		 if(name.length()==0)
		 {
			 JOptionPane.showMessageDialog(null, "Enter Valid Name","Invalid",JOptionPane.ERROR_MESSAGE);
			 flag=false;
		 }
		
		 if(name.length()>0)
	 		{
			 
	 			for(int i=0;i<name.length();i++)
	 			{
	 				if(Character.isDigit(name.charAt(i)))
	 				{
	 					flag=false;
	 					JOptionPane.showMessageDialog(null, "Enter Valid Name","Invalid",JOptionPane.ERROR_MESSAGE);
	 					break;
	 					
	 				}
	 			
	 			}
	 		
		 
	 		
	 }
		return flag;
	 }
	 public void actionPerformed(ActionEvent e)
	 {
		
		 name=t4.getText();
		 flag=true;
		 String line;
		 if(e.getSource()==b2)
		 {
			 if(check())
			 {
				try{
					 br=new BufferedReader(new FileReader("NetworkIssue.dat"));
					boolean cflag=true;
					line=br.readLine();
						while(line!=null)
						{
							
							if( line.toLowerCase().contains(name.toLowerCase()))
							{
								String []tok=line.split(":");
								
								if(tok.length==6)
								{
									if(tok[1].toLowerCase().contains(name.toLowerCase()))
									{
											rnol.setText("Reference Number Is "+tok[0]);
											l8.setText(tok[1]);
											l9.setText(tok[2]);
											l10.setText(tok[3]);
											l11.setText(tok[4]);
											l12.setText(tok[5]);
											cflag=false;
											System.out.println("1");
											b2.setVisible(false);
											b4.setVisible(true);
											break;
									}
								}		
							}
						 
							line=br.readLine();
						}
						if(cflag)
						{
							JOptionPane.showMessageDialog(null, "Enter Name Correct!!!","Not Found!!",JOptionPane.ERROR_MESSAGE);
						}
				
					
				 }
				 catch(Exception ee)
				 {
					 JOptionPane.showMessageDialog(null, "Enter Name Correct!!!"+rno,"Not Found!!",JOptionPane.ERROR_MESSAGE);
				 }
			 }
			 
		 }
		 if(e.getSource()==b1)
		 {
			 f.setVisible(false);
			 new MainForm();
			 try {
					br.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		 }
		 if(e.getSource()==b3)
		 {
			 rnol.setText("");
			 b4.setVisible(false);
				b2.setVisible(true);
			 l8.setText("");
				l9.setText("");
				l10.setText("");
				l11.setText("");
				l12.setText("");
			 t4.setText("");
			 try {
				br.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		 if(e.getSource()==b4)
		 {
			 try{
				
				boolean cflag=true;
					
						while((line=br.readLine())!=null)
						{
							
						
							String []tok=line.split(":");
							if( tok[1].toLowerCase().contains(name.toLowerCase()))
							{
							if(tok.length==6)
							{
										rnol.setText("Reference Number Is "+tok[0]);
										l8.setText(tok[1]);
										l9.setText(tok[2]);
										l10.setText(tok[3]);
										l11.setText(tok[4]);
										l12.setText(tok[5]);
										cflag=false;
										
										break;
							}		
						}
					 
					 
					
			
				
			 }
						if(cflag)
						 {
							 JOptionPane.showMessageDialog(null, "No More Customer Found!!!","Not Found!!",JOptionPane.ERROR_MESSAGE);
						 }
			 }
			 catch(Exception ee)
			 {
				 System.out.println(ee);
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


class NetworkIssueCheckForm
{
	public static void main(String arg[])
	{
		new NetworkIssueCheck();
	}
}//ERROR IS RELATED TO t2 CHECK IT