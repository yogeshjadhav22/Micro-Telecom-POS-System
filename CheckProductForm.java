import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

class CheckProduct implements ActionListener,ItemListener,KeyListener
{
	
	JButton b1,b2,b3,b4,b5;
	JLabel t1,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l,li,lr,erno1,erno2,erno3,erno4,erno5,erno6,erno7,erno8,erno9,erno10;
	JFrame f;
	JTextField t2,t3,t4,t6;
	Font f1,f2,f3,f4,f5;
	JRadioButton r1,r2,r3,r4,r5,r6,r7;
	JPanel p1,p2;
	JComboBox cb;
	String pname,ptype,pack,pri,val,det,date;
	JCheckBox cb1,cb2,cb3,cb4,cb5,cb6,cb7,cb8,cb9,cb10,cb11,cb12;
	JTextArea a;
	DefaultTableModel dtm;
	JTable tab ;
	JScrollPane jsp;
	boolean flag=true,Cflag=false ,pflag=true;
	BufferedReader br;
	ButtonGroup brg,brg1;
	String []tok;
	int j=1,i,count=0;
	String line,check[];
	 public CheckProduct() throws FileNotFoundException
	 {
	 
	 	f=new JFrame("POS - Complaints");
		f.setSize(1366,768);
		f.setResizable(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel fm=new JLabel(new ImageIcon("D:\\Project\\Images\\BackGround.jpg"));
		fm.setBounds(0,00,1366,768);
		JLabel header=new JLabel(new ImageIcon("D:\\Project\\Images\\ProductCheck.jpg"));
		header.setBounds(0,0,1455,161);
		fm.add(header);
		
		b1=new JButton("Back");
		b1.setBounds(10,10,100,35);
		b1.addActionListener(this);
		header.add(b1);
		
		f.setLayout(null);
		f1=new Font("Lucida Fax",Font.PLAIN,16);
		f2=new Font("Lucida Fax",Font.ITALIC,20);
		f3=new Font("Cooper Black",Font.PLAIN,25);
		f4=new Font("Lucida Fax",Font.BOLD,18);
		
		l1=new JLabel("Date");
		l1.setBounds(998,166,100,35);
		l1.setFont(f1);
		t1=new JLabel();
		t1.setBounds(1050,170,120,28);
		t1.setFont(f2);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calobj = Calendar.getInstance();
		t1.setText(df.format(calobj.getTime()));
		
		 tab = new JTable();
		 jsp = new JScrollPane(tab);
		fm.add(jsp);
		tab.setFont(f1);
		
		tab.setRowSelectionAllowed(true);
		tab.setColumnSelectionAllowed(false);
		//tab.addAncestorListener(this);
		dtm = new DefaultTableModel();
		
		
		dtm.addColumn("Product Name");
		dtm.addColumn("Product Type");
		dtm.addColumn("Choose Pack");
		dtm.addColumn("Price");
		dtm.addColumn("Validity");
		dtm.addColumn("    Details    ");
		dtm.addColumn("   In Date   ");
		
		jsp.setBounds(50,150,800,450);
		tab.setModel(dtm);
		
		p1=new JPanel();
		p1.setBounds(270,180,900,600);
		p1.setBackground(Color.white);
		p1.setLayout(null);
		
		l2=new JLabel("Select Product Type");
		l2.setBounds(150,50,200,30);
		l2.setFont(f1);
	

		r1=new JRadioButton("Plain");
		r1.setFont(f1);
		r1.setBounds(350,50,70,35);
		r1.addItemListener(this);
		r2=new JRadioButton("Combo");
		r2.setFont(f1);
		r2.setBounds(420,50,90,35);
		r2.addItemListener(this);
		
		r1.setBackground(Color.white);
		r2.setBackground(Color.white);
		brg=new ButtonGroup();
		brg.add(r1);
		brg.add(r2);
		
		r3=new JRadioButton("Data");
		r3.setFont(f1);
		r3.setBounds(180,100,70,35);
		r3.addItemListener(this);
		r4=new JRadioButton("Voice");
		r4.setFont(f1);
		r4.setBounds(250,100,90,35);
		r4.addItemListener(this);
		r5=new JRadioButton("SMS");
		r5.setFont(f1);
		r5.setBounds(340,100,70,35);
		r5.addItemListener(this);
		r6=new JRadioButton("TOPUP");
		r6.setFont(f1);
		r6.setBounds(410,100,150,35);
		r6.addItemListener(this);
		r5.setBackground(Color.white);
		r6.setBackground(Color.white);
		r3.setBackground(Color.white);
		r4.setBackground(Color.white);
		r7=new JRadioButton("All Combo");
		r7.setFont(f1);
		r7.setBounds(410,100,150,35);
		r7.addItemListener(this);
		r7.setBackground(Color.white);
		r7.setVisible(false);
		r5.setBackground(Color.white);
		r6.setBackground(Color.white);
		brg1=new ButtonGroup();
		brg1.add(r3);
		brg1.add(r4);
		brg1.add(r5);
		brg1.add(r6);
		
		
		check=new String[30];
		for(i=0;i<30;i++)
		{
			check[i]=null;
		}
		
		r3.setVisible(false);
		r4.setVisible(false);
		r5.setVisible(false);
		r6.setVisible(false);
		
		p1.add(r1);
		p1.add(r2);
		p1.add(r3);
		p1.add(r4);
		p1.add(r5);
		p1.add(r6);
		p1.add(r7);
		p1.add(jsp);
		p1.add(l2);
		fm.add(p1);
		f.addKeyListener(this);
		f.add(fm);
		f.setVisible(true);		
	 }
	 public void actionPerformed(ActionEvent e)
	 {
		 new MainForm();
		 f.setVisible(false);
	 }
	  public void itemStateChanged(ItemEvent e)
	 {
	  		
		 
		  	if(r2.isSelected())
	  		{
	  			r3.setVisible(false);
	  			r4.setVisible(false);
	  			r5.setVisible(false);
	  			r6.setVisible(false);
	  			r7.setVisible(true);
	  			if(r7.isSelected())
	  			{
	  				try
					 {
						  br=new BufferedReader(new FileReader("Products.dat"));//new File("C://Users//Yogesh//workspace//Micro-POS//Products.dat)")));
						
						
						  dtm.setRowCount(0);
						while((line=br.readLine())!=null)
						{
							
							if(line.toLowerCase().contains("Combo".toLowerCase()))
							{
								String []tok=line.split(":");
								count++;
								dtm.addRow(tok);
							}
						 
						 
						}
						br.close();
					 }
					 catch(Exception ee)
					 {
						 System.out.println(ee);
					 }
	  			}
	  			
	  		}
		  	if(r1.isSelected())
	  		{
		  		r3.setVisible(true);
	  			r4.setVisible(true);
	  			r5.setVisible(true);
	  			r6.setVisible(true);
	  			r7.setVisible(false);
	  			tok=new String[100];
	  			dtm.setRowCount(0);
	  			for(i=0;i<30;i++)
	  			{
	  				check[i]=null;
	  			}
	  			if(r1.isSelected())
	  			{
	  				if(r3.isSelected())
	  				{
	  					ptype="Data";
	  				}
	  				if(r4.isSelected())
	  				{
	  					ptype="Voice";
	  				}
	  				if(r5.isSelected())
	  				{
	  					ptype="SMS";
	  				}
	  				if(r6.isSelected())
	  				{
	  					ptype="TOPUP";
	  				}
		  			if(r3.isSelected()||r4.isSelected()||r5.isSelected()||r6.isSelected())
		  			{
		  				try
						 {
							  br=new BufferedReader(new FileReader("Products.dat"));//new File("C://Users//Yogesh//workspace//Micro-POS//Products.dat)")));
							  dtm.setRowCount(0);
							  
							while((line=br.readLine())!=null)
							{
								
								
									
									
								String []tok=line.split(":");
								
								if(tok[4].toLowerCase().contains(ptype.toLowerCase()))
								{
									
									dtm.addRow(tok);
								}
							 
							 
							}
							
							br.close();
						 }
						 catch(Exception ee)
						 {
							 System.out.println(ee);
						 }
		  			}
	  			}
	  		}
		  	
		  	
	 }
	 	public void keyPressed(KeyEvent e)
		{
	 		
		}
	public void keyReleased(KeyEvent e)
	{}
	public void keyTyped(KeyEvent e)
	{}
	
	
	 	
}


class CheckProductForm
{
	public static void main(String arg[]) throws FileNotFoundException
	{
		new CheckProduct();
		
	}
}//ERROR IS RELATED TO t2 CHECK IT