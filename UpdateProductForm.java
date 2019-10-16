import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

class UpdateProduct implements ActionListener,ItemListener,KeyListener
{
	
	JButton b1,b2,b3,b4,b5;
	JLabel t1,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l,li,lr,erno1,erno2,erno3,erno4,erno5,erno6,erno7,erno8,erno9,erno10;
	JFrame f;
	JTextField t2,t3,t4,t6;
	Font f1,f2,f3,f4,f5;
	JRadioButton r1,r2;
	JPanel p1,p2;
	JComboBox cb;
	String pname,ptype,pack,pri,val,det,date;
	JCheckBox cb1,cb2,cb3,cb4,cb5,cb6,cb7,cb8,cb9,cb10,cb11,cb12;
	JTextArea a;
	boolean flag=true,Cflag=false ,pflag=true;
	BufferedWriter bw;
	
	ButtonGroup brg;
	
	 public UpdateProduct() throws FileNotFoundException
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
		p1.setBounds(330,180,670,600);
		p1.setBackground(Color.white);
	
		p1.setLayout(null);
		fm.add(p1);
		
		p2=new JPanel();
		p2.setBounds(350,200,150,25);
		p2.setBackground(Color.white);
	
		p2.setLayout(null);
		p1.add(p2);
		
		
		
		erno1=new JLabel("* Invalid Name");
		erno1.setForeground(Color.RED);
		erno1.setVisible(false);
		erno1.setFont(f5);
		erno1.setBounds(500,100,150,30);
		p1.add(erno1);
		
		erno2=new JLabel("* Invalid Price");
		erno2.setForeground(Color.RED);
		erno2.setVisible(false);
		erno2.setFont(f5);	
		erno2.setBounds(500,250,150,30);//350,230,250,35
		p1.add(erno2);
		
		erno3=new JLabel("* Select One");
		erno3.setForeground(Color.RED);
		erno3.setVisible(false);
		erno3.setFont(f5);	
		erno3.setBounds(510,150,150,35);
		p1.add(erno3);
		
		erno4=new JLabel("* Select Pack");
		erno4.setForeground(Color.RED);
		erno4.setVisible(false);
		erno4.setFont(f5);	
		erno4.setBounds(535,200,150,25);
		p1.add(erno4);
		
		erno5=new JLabel("* Invalid");
		erno5.setForeground(Color.RED);
		erno5.setVisible(false);
		erno5.setFont(f5);	
		erno5.setBounds(500,300,250,30);
		p1.add(erno5);
		
		
		l1=new JLabel("Date");
		l1.setBounds(998,166,100,35);
		l1.setFont(f1);

		t1=new JLabel();
		t1.setBounds(1050,170,120,28);
		t1.setFont(f2);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calobj = Calendar.getInstance();
		t1.setText(df.format(calobj.getTime()));
		
		l2=new JLabel("Product Name");
		l2.setBounds(150,100,150,30);
		l2.setFont(f1);
	
		l3=new JLabel("Product Type");
		l3.setBounds(150,150,200,30);
		l3.setFont(f1);
	
		l4=new JLabel("Choose Pack");
		l4.setBounds(150,200,150,30);
		l4.setFont(f1);
		
	
		l5=new JLabel("Price");
		l5.setBounds(150,250,250,30);
		l5.setFont(f1);
		
		l6=new JLabel("Validity");
		l6.setBounds(150,300,250,30);
		l6.setFont(f1);
		
		l7=new JLabel("Details");
		l7.setBounds(150,350,250,30);
		l7.setFont(f1);
		
		
		t3=new JTextField(10);
		t3.setBounds(350,100,150,30);	
		t3.setFont(f2);
		t3.addKeyListener(this);
		
		t4=new JTextField();
		t4.setBounds(350,350,150,50);
		t4.setFont(f2);
		t4.addKeyListener(this);
		
		
		t2=new JTextField(10);
		t2.setBounds(350,300,150,30);
		t2.setFont(f2);
		t2.addKeyListener(this);
		
	
	
		t6=new JTextField(10);
		t6.setBounds(350,250,150,30);
		t6.setFont(f2);
		t6.addKeyListener(this);
		
		b3=new JButton("Submit");
		b3.setBounds(150,450,80,35);
		b3.addActionListener(this);
		
				
		b4=new JButton("Clear");
	    b4.setBounds(285,450,80,35);
		b4.addActionListener(this);
		
				
		b5=new JButton("Cancel");
		b5.setBounds(410,450,80,35);
		b5.addActionListener(this);
		
		
		cb=new JComboBox();
		cb.addItem("Data");	
		cb.addItem("SMS");	
		cb.addItem("Voice");	
		cb.addItem("TOPUP");
		cb.addItemListener(this);
		cb.setBounds(0,0,60,25);
		p2.add(cb);
		
		
		r1=new JRadioButton("Plain");
		r1.setFont(f1);
		r1.setBounds(350,150,70,35);
		r1.addItemListener(this);
		r2=new JRadioButton("Combo");
		r2.setFont(f1);
		r2.setBounds(420,150,90,35);
		r2.addItemListener(this);
		
		r1.setBackground(Color.white);
		r2.setBackground(Color.white);
		brg=new ButtonGroup();
		brg.add(r1);
		brg.add(r2);
		
		
		
		cb1=new JCheckBox("Data");
		cb1.setBackground(Color.white);
		cb1.setBounds(350,200,70,20);
		
		cb2=new JCheckBox("Voice");
		cb2.setBackground(Color.white);
		cb2.setBounds(420,200,70,20);
		
		cb3=new JCheckBox("SMS");
		cb3.setBackground(Color.white);
		cb3.setBounds(490,200,70,20);
		
		cb4=new JCheckBox("Full Talktime");
		cb4.setBackground(Color.white);
		cb4.setBounds(560,200,150,20);
		
		cb1.setVisible(false);
		cb2.setVisible(false);
		cb3.setVisible(false);
		cb4.setVisible(false);
		
		
		
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
		p1.add(t2);
		p1.add(t6);
		p1.add(b4);
		p1.add(b5);
		p1.add(l6);
		p1.add(t6);
		p1.add(l7);
		p1.add(r1);
		p1.add(r2);
		p1.add(cb1);
		p1.add(cb2);
		p1.add(cb3);
		p1.add(cb4);
		
		f.addKeyListener(this);
		
		f.setVisible(true);		
	 }
	 public void actionPerformed(ActionEvent e)
	 {
		 erno1.setVisible(false);
		 erno2.setVisible(false);
		 erno3.setVisible(false);
		 erno4.setVisible(false);
		 erno5.setVisible(false);
		 flag=true;
		 pname="";
		  pri="";
		 val="";
		 det="";
		 pack="";
		 ptype="";
		 
		 if(e.getSource()==b3)
		 {
			 try{
			 String line;
			 pname=t3.getText();
			  pri=t6.getText();
			 val=t2.getText();
			 det=t4.getText();
			 if(r1.isSelected())
			 {
				 pack=""+cb.getSelectedItem();
			 }
			 if(!r1.isSelected()&& !r2.isSelected())
			 {
				 erno3.setVisible(true);
				 
			 }
			 if(r2.isSelected())
			 {
				 if(!cb1.isSelected()&& !cb3.isSelected() && !cb2.isSelected())
				 {
					 erno4.setVisible(true);
					 flag=false;
				 }
			 }
			 if(r1.isSelected())
			 {
				 ptype="Plain";
				 
			 }
			 if(r2.isSelected())
			 {
				 ptype="Combo";
				 if(cb1.isSelected())
			 	 {
			 		 pack=pack+"Data";
			 	 }
			 	if(cb2.isSelected())
			 	 {
			 		if(cb1.isSelected())
			 		{
			 			pack=pack+",Voice";
			 		}
			 		else
			 		 pack=pack+"Voice";
			 	 }
			 	if(cb3.isSelected())
			 	 {
			 		if(cb2.isSelected()|| cb1.isSelected())
			 		{
			 			pack=pack+",SMS";
			 		}
			 		else
			 		 pack=pack+"SMS";
			 	 }
			 	
			 }
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
		 					pflag=false;
		 					break;
		 				}
		 			
		 			}
		 		}
			 if(pflag)
	 			{
	 				if(Integer.parseInt(pri)==0)
	 				 {
	 					 erno2.setVisible(true);
	 					 flag=false;
	 				 }
	 			}
			 if(val.length()<=0)//|| Integer.parseInt(val)<=0)
		 		{
				 	erno5.setVisible(true);
		 			flag=false;
		 		}
			 if(pname.length()<=0)
		 		{
				 	erno1.setVisible(true);
		 			flag=false;
		 		}
			 if(pname.length()>0)
		 		{
				 Cflag=true;
		 			for(int i=0;i<pname.length();i++)
		 			{
		 				if(Character.isDigit(pname.charAt(i)))
		 				{
		 					flag=false;
		 					erno1.setVisible(true);
		 					Cflag=false;
		 					break;
		 					
		 				}
		 			
		 			}
		 			if(Cflag)
		 			{
		 				if(Integer.parseInt(pri)<=9)
		 				 {
		 					 int p=JOptionPane.showConfirmDialog(null, "Are You Sure About Validity","Confirmation",JOptionPane.YES_NO_OPTION);
		 					 if(p==JOptionPane.NO_OPTION)
		 					 {
		 						 flag=false;
		 						 erno2.setVisible(true);
		 					 }
		 				 }
		 			}
		 			
		 		}
			  
			  if(flag)
			  {
				 try
				 {
					 FileOutputStream fos=new FileOutputStream("Products.dat",true);
					  bw=new BufferedWriter(new OutputStreamWriter(fos));
					
					 
					 line=pname+":"+pri+":"+ptype+":"+val+":"+pack+":"+det+":"+t1.getText();
					 bw.newLine();
					 bw.write(line);
					 
					 bw.close();
					 JOptionPane.showMessageDialog(null, "Submitted Successfully","Success",JOptionPane.PLAIN_MESSAGE);
					 t2.setText("");
					 t3.setText("");
					 t4.setText("");
					 t6.setText("");
					 r1.setSelected(true);
					 r2.setSelected(false);
					 cb1.setSelected(false);
					 cb2.setSelected(false);
					 cb3.setSelected(false);
					 cb4.setSelected(false);
					 cb.setSelectedItem("Data");
				 }
				 catch(Exception ee)
				 {
					 System.out.println(ee);
				 }
			  }

		 }
		 catch(Exception eeee){}
			 
		 }
	 //B3 END WITH SUBMIT		 
		 if(e.getSource()==b4)
		 {
			 t2.setText("");
			 t3.setText("");
			 t4.setText("");
			 t6.setText("");
			 r1.setSelected(true);
			 r2.setSelected(false);
			 cb1.setSelected(false);
			 cb2.setSelected(false);
			 cb3.setSelected(false);
			 cb4.setSelected(false);
			 cb.setSelectedItem("Data");
			
		 }//B$ ENDS WITH CLEAR
		 if(e.getSource()==b5)
		 {
			 t2.setText("");
			 t3.setText("");
			 t4.setText("");
			 t6.setText("");
			 r1.setSelected(false);
			 r2.setSelected(false);
			 cb1.setSelected(false);
			 cb2.setSelected(false);
			 cb3.setSelected(false);
			 cb4.setSelected(false);
			 
			 f.setVisible(false);
			 new MainForm();
		 }
		 
	 }
	  public void itemStateChanged(ItemEvent e)
	 {
	  		
		 
		  	if(r2.isSelected())
	  		{
	  			cb1.setVisible(true);
	  			cb2.setVisible(true);
	  			cb3.setVisible(true);
	  			p2.setVisible(false);
	  		}
		  	if(r1.isSelected())
	  		{
	  			cb1.setVisible(false);
	  			cb2.setVisible(false);
	  			cb3.setVisible(false);
	  			p2.setVisible(true);
	  		}
		  	
	 }
	 	public void keyPressed(KeyEvent e)
		{
	 		/*if((KeyEvent.CTRL_MASK) != 0 && e.getKeyCode()==KeyEvent.VK_BACK_SPACE)
			{
				new MainForm();
				f.setVisible(false);
			}*/
	 		if(e.getKeyCode()==KeyEvent.VK_ENTER)
	 		{
	 		 erno1.setVisible(false);
			 erno2.setVisible(false);
			 erno3.setVisible(false);
			 erno4.setVisible(false);
			 erno5.setVisible(false);
			 flag=true;
			 pname="";
			  pri="";
			 val="";
			 det="";
			 pack="";
			 ptype="";
			 
			
				 try{
				 String line;
				 pname=t3.getText();
				  pri=t6.getText();
				 val=t2.getText();
				 det=t4.getText();
				 if(r1.isSelected())
				 {
					 pack=""+cb.getSelectedItem();
				 }
				 if(!r1.isSelected()&& !r2.isSelected())
				 {
					 erno3.setVisible(true);
					 
				 }
				 if(r2.isSelected())
				 {
					 if(!cb1.isSelected()&& !cb3.isSelected() && !cb2.isSelected())
					 {
						 erno4.setVisible(true);
						 flag=false;
					 }
				 }
				 if(r1.isSelected())
				 {
					 ptype="Plain";
					 
				 }
				 if(r2.isSelected())
				 {
					 ptype="Combo";
					 if(cb1.isSelected())
				 	 {
				 		 pack=pack+"Data";
				 	 }
				 	if(cb2.isSelected())
				 	 {
				 		if(cb1.isSelected())
				 		{
				 			pack=pack+",Voice";
				 		}
				 		else
				 		 pack=pack+"Voice";
				 	 }
				 	if(cb3.isSelected())
				 	 {
				 		if(cb2.isSelected()|| cb1.isSelected())
				 		{
				 			pack=pack+",SMS";
				 		}
				 		else
				 		 pack=pack+"SMS";
				 	 }
				 	
				 }
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
			 					pflag=false;
			 					break;
			 				}
			 			
			 			}
			 		}
				 if(pflag)
		 			{
		 				if(Integer.parseInt(pri)==0)
		 				 {
		 					 erno2.setVisible(true);
		 					 flag=false;
		 				 }
		 			}
				 if(val.length()<=0)//|| Integer.parseInt(val)<=0)
			 		{
					 	erno5.setVisible(true);
			 			flag=false;
			 		}
				 if(pname.length()<=0)
			 		{
					 	erno1.setVisible(true);
			 			flag=false;
			 		}
				 if(pname.length()>0)
			 		{
					 Cflag=true;
			 			for(int i=0;i<pname.length();i++)
			 			{
			 				if(Character.isDigit(pname.charAt(i)))
			 				{
			 					flag=false;
			 					erno1.setVisible(true);
			 					Cflag=false;
			 					break;
			 					
			 				}
			 			
			 			}
			 			if(Cflag)
			 			{
			 				if(Integer.parseInt(pri)<=9)
			 				 {
			 					 int p=JOptionPane.showConfirmDialog(null, "Are You Sure About Validity","Confirmation",JOptionPane.YES_NO_OPTION);
			 					 if(p==JOptionPane.NO_OPTION)
			 					 {
			 						 flag=false;
			 						 erno2.setVisible(true);
			 					 }
			 				 }
			 			}
			 			
			 		}
				  
				  if(flag)
				  {
					 try
					 {
						 FileOutputStream fos=new FileOutputStream("C://Users//Yogesh//workspace//Micro-POS//Product.dat",true);
						  bw=new BufferedWriter(new OutputStreamWriter(fos));
						
						 
						 line=pname+"."+pri+"."+ptype+"."+val+"."+pack+"."+det+"."+t1.getText();
						 bw.newLine();
						 bw.write(line);
						 
						 bw.close();
						 JOptionPane.showMessageDialog(null, "Submitted Successfully","Success",JOptionPane.PLAIN_MESSAGE);
					 }
					 catch(Exception ee)
					 {
						 System.out.println(ee);
					 }
				  }

			 }
			 catch(Exception eeee){}
				 
	 		}
		}
	public void keyReleased(KeyEvent e)
	{}
	public void keyTyped(KeyEvent e)
	{}
	
	
	 	
}


class UpdateProductForm
{
	public static void main(String arg[]) throws FileNotFoundException
	{
		new UpdateProduct();
	}
}//ERROR IS RELATED TO t2 CHECK IT