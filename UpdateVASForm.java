import javax.swing.*;
import javax.swing.text.DefaultCaret;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

class UpdateVAS implements ActionListener,ItemListener,KeyListener
{
	
	JButton b1,b2,b3,b4,b5;
	JLabel t1,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l,li,lr,erno1,erno2,erno3,erno4,erno5,erno6,erno7,erno8,erno9,erno10;
	JFrame f;
	JTextField t2,t3,t4;
	JTextArea t6;
	Font f1,f2,f3,f4,f5;
	JRadioButton r1,r2;
	JPanel p1,p2;
	JTextArea a;
	boolean flag ;
	String name,pri,det,val;
	ButtonGroup brg;
	BufferedWriter bw;
	 public UpdateVAS()
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
		p1.setBounds(330,180,700,600);
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
		l1=new JLabel("Date");
		l1.setBounds(998,166,100,35);
		l1.setFont(f1);

		t1=new JLabel();
		t1.setBounds(1050,170,120,28);
		t1.setFont(f2);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calobj = Calendar.getInstance();
		t1.setText(df.format(calobj.getTime()));
		
		erno1=new JLabel("* Invalid Name");
		erno1.setForeground(Color.RED);
		erno1.setVisible(false);
		erno1.setFont(f5);
		erno1.setBounds(500,100,150,30);

		
		erno2=new JLabel("* Invalid Price");
		erno2.setForeground(Color.RED);
		erno2.setVisible(false);
		erno2.setFont(f5);	
		erno2.setBounds(500,150,250,35);//350,230,250,35
		
		erno3=new JLabel("* Enter Validity");
		erno3.setForeground(Color.RED);
		erno3.setVisible(false);
		erno3.setFont(f5);	
		erno3.setBounds(500,200,250,35);
		
		erno4=new JLabel("* Enter Details");
		erno4.setForeground(Color.RED);
		erno4.setVisible(false);
		erno4.setFont(f5);	
		erno4.setBounds(500,250,250,35);
		p1.add(erno1);
		p1.add(erno2);
		p1.add(erno3);
		p1.add(erno4);
		
		
		l2=new JLabel("Service Name");
		l2.setBounds(150,100,150,30);
		l2.setFont(f1);
	
		l3=new JLabel("Price");
		l3.setBounds(150,150,200,30);
		l3.setFont(f1);
	
		l4=new JLabel("Validity");
		l4.setBounds(150,200,150,30);
		l4.setFont(f1);
	
		l5=new JLabel("Details");
		l5.setBounds(150,250,250,30);
		l5.setFont(f1);
		
		
		t3=new JTextField(10);
		t3.setBounds(350,100,150,30);	
		t3.setFont(f2);
		
		t4=new JTextField(10);
		t4.setBounds(350,150,150,30);
		t4.setFont(f2);
		
		
		t2=new JTextField(10);
		t2.setBounds(350,200,150,30);
		t2.setFont(f2);
		
	
		t6=new JTextArea(50,50);
		t6.setBounds(350,250,150,75);//Address
		t6.setFont(f2);
		t6.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(1.0f),Color.gray));
		t6.setLineWrap(true);
		JScrollPane jp=new JScrollPane(t6);
		jp.setBounds(350,250,150,75);
		jp.setViewportView(t6);
		
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
		p1.add(jp);
		p1.add(erno1);
		p1.add(erno2);
		p1.add(erno3);
		p1.add(erno4);
		p1.add(b4);
		p1.add(b5);;
		f.addKeyListener(this);
		
		f.setVisible(true);		
	 }
	 
	 public void actionPerformed(ActionEvent e)
	 {
		 if(e.getSource()==b3)
		 {
			 try{
				 String line;
				 name=t3.getText();
				  pri=t4.getText();
				 val=t2.getText();
				 det=t6.getText();
				 flag=true;
				 erno1.setVisible(false);
				 erno2.setVisible(false);
				 erno3.setVisible(false);
				 erno4.setVisible(false);
				 	
				
				 if(pri.length()==0)
				 {
					 erno2.setVisible(true);
					 flag=false;
				 }
				
				 if(pri.length()>0)
			 		{
			 			for(int i=0;i<pri.length();i++)
			 			{
			 				if(!Character.isDigit(pri.charAt(i)))
			 				{
			 					flag=false;
			 					erno2.setVisible(true);
			 				
			 					break;
			 				}
			 			
			 			}
			 		}
				 
				 if(val.length()<=0)//|| Integer.parseInt(val)<=0)
			 		{
					 	erno3.setVisible(true);
			 			flag=false;
			 		}
				 if(det.length()<=0)//|| Integer.parseInt(val)<=0)
			 		{
					 	erno4.setVisible(true);
			 			flag=false;
			 		}
				 if(name.length()<=0)
			 		{
					 	erno1.setVisible(true);
			 			flag=false;
			 		}
				 
				  
				  if(flag)
				  {
					 try
					 {
						 FileOutputStream fos=new FileOutputStream("VAS.dat",true);
						  bw=new BufferedWriter(new OutputStreamWriter(fos));
						
						 
						 line=name+":"+pri+":"+val+":"+det+":"+t1.getText();
						 
						 bw.write(line);
						 bw.newLine();
						 bw.close();
						 JOptionPane.showMessageDialog(null, "Submitted Successfully","Success",JOptionPane.PLAIN_MESSAGE);
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
			 catch(Exception eeee){}
				 
			 }
		 
		 if(e.getSource()==b5)
		 {
			 new MainForm();
			 f.setVisible(false);
		 }
		 if(e.getSource()==b4)
		 {
			 t2.setText("");
			 t3.setText("");
			 t4.setText("");
			 t6.setText("");
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


class UpdateVASForm
{
	public static void main(String arg[])
	{
		new UpdateVAS();
	}
}//ERROR IS RELATED TO t2 CHECK IT