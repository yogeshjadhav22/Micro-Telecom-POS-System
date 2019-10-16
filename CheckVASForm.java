import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

class CheckVAS implements ActionListener,ItemListener,KeyListener
{
	
	JButton b1,b2,b3,b4,b5,b6;
	JLabel t1,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l,li,lr,esname1,esname2,esname3,l11;
	JFrame f;
	JTextField t2,t3,t4,t6;
	Font f1,f2,f3,f4,f5;
	JRadioButton r1,r2;
	JPanel p1,p2;
	JTextArea a;
	String sname,s[];
	boolean flag=true ;
	boolean cflag=true;
	BufferedReader br;
	ButtonGroup brg;
	
	 public CheckVAS()
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
		l1=new JLabel("Date");
		l1.setBounds(998,166,100,35);
		l1.setFont(f1);
		t1=new JLabel();
		t1.setBounds(1050,170,120,28);
		t1.setFont(f2);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calobj = Calendar.getInstance();
		t1.setText(df.format(calobj.getTime()));
		l2=new JLabel("Enter Service name");
		l2.setBounds(50,230,160,30);
		l2.setFont(f1);
		t3=new JTextField();
		t3.setBounds(250,230,150,30);	
		t3.setFont(f2);
		b2=new JButton("Show");
		b2.setBounds(110,290,90,35);
		b2.addActionListener(this);
		b3=new JButton("Cancel");
		b3.setBounds(250,290,90,35);
		b3.addActionListener(this);
		b1=new JButton("Back");
		b1.setBounds(10,10,100,35);
		b1.addActionListener(this);
		header.add(b1);
		b4=new JButton("Show All");
		b4.setBounds(110,350,90,35);
		b4.addActionListener(this);
		b5=new JButton("Next");
		b5.setBounds(110,350,90,35);
		b5.addActionListener(this);
		b5.setVisible(false);
		b6=new JButton("Next");
		b6.setBounds(110,350,90,35);
		b6.addActionListener(this);
		b6.setVisible(false);
		try {
			br=new BufferedReader(new FileReader("VAS.dat"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		l4=new JLabel("Service name ::");
		l4.setBounds(100,100,150,30);
		l4.setFont(f1);
	
		l5=new JLabel("Price ::");
		l5.setBounds(100,150,200,30);
		l5.setFont(f1);
	
		l6=new JLabel("Validity ::");
		l6.setBounds(100,200,150,30);
		l6.setFont(f1);
	
		l7=new JLabel("Details ::");
		l7.setBounds(100,250,250,30);
		l7.setFont(f1);
		l8=new JLabel();
		l8.setBounds(360,100,150,30);
		l8.setFont(f1);
	
		l9=new JLabel();
		l9.setBounds(360,150,200,30);
		l9.setFont(f1);
	
		l10=new JLabel();
		l10.setBounds(360,200,150,30);
		l10.setFont(f1);
	
		l11=new JLabel();
		l11.setBounds(360,250,250,30);
		l11.setFont(f1);
		
		p1.add(l4);
		p1.add(l5);
		p1.add(l6);
		p1.add(l7);
		p1.add(l8);
		p1.add(l9);
		p1.add(l10);
		p1.add(l11);
		p1.add(b4);
		p1.add(b5);
		p1.add(b6);
		
		
		f.add(fm);
		fm.add(l1);
		fm.add(t1);
		
		
		fm.add(l2);
		fm.add(t3);
		
		
		fm.add(b2);
		fm.add(b3);
		fm.addKeyListener(this);
		
		f.setVisible(true);		
	 }
	 boolean check()
	 {
		 if(sname.length()<=0)
	 		{
			 	JOptionPane.showMessageDialog(null, "Enter Service name","Invalid",JOptionPane.ERROR_MESSAGE);
			 	flag=false;
	 		}
			
	 		
		return flag;
		 
		
	 }
	 public void actionPerformed(ActionEvent e)
	 {
		 sname=t3.getText();
		 flag=true;
		 
		 String line;
		 s=new String[6];
		 if(e.getSource()==b2)
		 {try{
			 if(check())
			 {
				while((line=br.readLine())!=null)
				{
					 s=line.split(":");
					 if(s.length==5 && s[0].toLowerCase().contains(sname.toLowerCase()))
					 {
						 l8.setText(s[0]);
						 l9.setText(s[1]);
						 l10.setText(s[2]);
						 l11.setText(s[3]);
						 b2.setVisible(false);
						 b4.setVisible(false);
						 b6.setVisible(true);
						 b5.setVisible(false);
						 cflag=false;
						 break;
						 
					 }
				}
				
			 }
		 }
		 catch(Exception ee)
		 {}
			 
		 }
		 if(e.getSource()==b1)
		 {
			 
			 try {
				br.close();
				new MainForm();
				f.setVisible(false);

			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		 }
		 if(e.getSource()==b3)
		 {
			 b4.setVisible(true);
			 b5.setVisible(false);
			 t3.setText("");
			 l8.setText("");
			 l9.setText("");
			 l10.setText("");
			 l11.setText("");
			 b6.setVisible(false);
			 b2.setVisible(true);
			 try {
				br.close();
				br=new BufferedReader(new FileReader("VAS.dat"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			 
		 }
		 if(e.getSource()==b4)
		 {
			 b4.setVisible(false);
			 b5.setVisible(true);
			 try{
				
					if((line=br.readLine())!=null)
					{
						 s=line.split(":");
						 if(s.length==5)
						 {
							 l8.setText(s[0]);
							 l9.setText(s[1]);
							 l10.setText(s[2]);
							 l11.setText(s[3]);
							 
						 }
					}
					else
					{
						JOptionPane.showMessageDialog(null, "No More VAS Found","Not Found",JOptionPane.ERROR_MESSAGE);
					}
				 }
			 
			 catch(Exception ee)
			 {}
			 
			
		 }
		 if(e.getSource()==b5)
		 {
			 
			 try{
				
					if((line=br.readLine())!=null)
					{
						 s=line.split(":");
						 if(s.length==5)
						 {
							 l8.setText(s[0]);
							 l9.setText(s[1]);
							 l10.setText(s[2]);
							 l11.setText(s[3]);
							 
						 }
					}
					else
					{
						JOptionPane.showMessageDialog(null, "No More VAS Found","Not Found",JOptionPane.ERROR_MESSAGE);
					}
				
			 }
			 catch(Exception ee)
			 {}
			 
			 
				 
			 }
		
		 if(e.getSource()==b6)
		 {
			 try{
					
					while((line=br.readLine())!=null )
					{
						 s=line.split(":");
						 if(s.length==5 && s[0].toLowerCase().contains(sname.toLowerCase()))
						 {
							 l8.setText(s[0]);
							 l9.setText(s[1]);
							 l10.setText(s[2]);
							 l11.setText(s[3]);
							 break;
						 }
					}
					if(line==null)
					{
						JOptionPane.showMessageDialog(null, "No More VAS Found","Not Found",JOptionPane.ERROR_MESSAGE);
					}
				
			 }
			 catch(Exception ee)
			 {}
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


class CheckVASForm
{
	public static void main(String arg[])
	{
		new CheckVAS();
	}
}

