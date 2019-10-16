import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
class MainForm implements ActionListener,KeyListener
{
	JFrame f;
	JMenuBar mb;
	JMenu m1,m2,m3,m4,m5,m6,sub1,sub2,sub3;
	JMenuItem m11,m12,m21,m22,m31,m32,m33,cvas,uvas,m35,m41,m42,m43,m51,m61,m62,m63,m64,ea,emnp,eetopup,evoch,ep,esr,evas,epuk,eni,nia,nic,up,cp;
	public MainForm()
	{
		f=new JFrame("POS-Main");
		f.setSize(1366,768);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//f.setResizable(false);
		f.setLayout(new FlowLayout());
		//JScrollPane jf=new JScrollPane();
		mb=new JMenuBar();
		mb.setBackground(Color.BLUE);
		m1=new JMenu("Activation");
		m11=new JMenuItem("New Activation");
		m12=new JMenuItem("MNP");
		sub1=new JMenu("Edit");
		ea=new JMenuItem("Activation");
		emnp=new JMenuItem("MNP");
		
		sub1.add(ea);
		sub1.add(emnp);

		ea.addActionListener(this);
		emnp.addActionListener(this);
		
		m1.add(m11);
		m1.add(m12);
		m1.addSeparator();
		m1.add(sub1);
		
		m2=new JMenu("Recharge");
		m21=new JMenuItem("ETopUp");
		m22=new JMenuItem("Voucher");
		
		sub2=new JMenu("Edit");		
		eetopup=new JMenuItem("ETopUp");
		evoch=new JMenuItem("Voucher");
		
		sub2.add(eetopup);
		sub2.add(evoch);
		
		
		m2.add(m21);
		m2.add(m22);
		m2.addSeparator();
		m2.add(sub2);
		
		m3=new JMenu("Complaint & Enquiry");
		m31=new JMenu("Product Enquiry");
		up=new JMenuItem("Update Product");
		cp=new JMenuItem("Check Product");
		up.addActionListener(this);
		cp.addActionListener(this);
		m31.add(up);
		m31.add(cp);
		m32=new JMenuItem("SIM Replacement");
		m33=new JMenu("VAS");
		uvas=new JMenuItem("Update VAS");
		cvas=new JMenuItem("Check VAS");
		m33.add(uvas);
		m33.add(cvas);
		uvas.addActionListener(this);
		cvas.addActionListener(this);
		
		m35=new JMenu("Network Issue");
		nia=new JMenuItem("Add Complaint");
		nia.addActionListener(this);
		nic=new JMenuItem("Check Complaint");
		nic.addActionListener(this);
		m35.add(nia);
		m35.add(nic);
		
		sub3=new JMenu("Edit");
		esr=new JMenuItem("SIM Replacement");
		evas=new JMenuItem("VAS");
		epuk=new JMenuItem("PUK Enquiry");
		eni=new JMenuItem("Network Issue");
		
		sub3.add(esr);
		sub3.add(evas);
		sub3.add(epuk);
		sub3.add(eni);
		
		
		m3.add(m31);
		m3.add(m32);
		m3.add(m33);
	
		m3.add(m35);
		m3.addSeparator();
		m3.add(sub3);
		
		m4=new JMenu("Report");
		m41=new JMenuItem("Sale Reports");
		m42=new JMenuItem("Customer Reports");
		m43=new JMenuItem("Complains Reports");
		
		
		m4.add(m41);
		m4.add(m42);
		m4.add(m43);
		
		m6=new JMenu("Stock");
		m61=new JMenuItem("Update");
		m62=new JMenuItem("Check");
		m6.add(m61);
		m6.add(m62);
		
		m5=new JMenu("Exit");
		m51=new JMenuItem("Exit");
		
		m5.add(m51);
		//m51.addKeyListener(this);
			
		JLabel bg=new JLabel(new ImageIcon("D:\\Project\\Images\\AircelBar.png"));
		mb.add(m1);
		mb.add(m2);
		mb.add(m3);
		mb.add(m4);
		mb.add(m6);
		mb.add(m5);
		f.setJMenuBar(mb);
		
		
		m11.addActionListener(this);
		m12.addActionListener(this);
		m21.addActionListener(this);
		m22.addActionListener(this);
		m31.addActionListener(this);
		m32.addActionListener(this);
		m33.addActionListener(this);
		
		m35.addActionListener(this);
		m41.addActionListener(this);
		m42.addActionListener(this);
		m43.addActionListener(this);
		m51.addActionListener(this);
		m61.addActionListener(this);
		m62.addActionListener(this);
		f.addKeyListener(this);
		//m63.addActionListener(this);
		//m64.addActionListener(this);
		f.add(bg);
		//f.add(jf);
		f.setVisible(true);
		
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==m51)
		{
			int n=JOptionPane.showConfirmDialog(null,"Are You Sure??","Exit",JOptionPane.YES_NO_OPTION);
	 		if(n==JOptionPane.YES_OPTION)
	 		{
	 			System.exit(0);//MNPFormDemo
	 		}	
		}
		if(e.getSource()==m61)
		{
			new StockInForm();
			f.setVisible(false);
		}
		if(e.getSource()==m11)
		{
			 new ActivationForms();	
			 	
			 	/*for(int i=0;i<6090;i++)
			 		for(int j=0;j<6090;j++)
			 		{
			 		}*/
			 f.setVisible(false);
		}
		if(e.getSource()==m12)
		{
			new MNPForms();
			f.setVisible(false);
		}
		if(e.getSource()==m21)
		{
			new ETOPUPForms();
			
			f.setVisible(false);
		}
		if(e.getSource()==ea)
		{
			f.setVisible(false);
			new EditActivation();	
		}
		if(e.getSource()==m22)
		{
			f.setVisible(false);
			new VoucherForm();	
		}
		if(e.getSource()==up)
		{
			try {
				new UpdateProduct();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			f.setVisible(false);
		}		
		if(e.getSource()==m31)
		{
			
		}
		if(e.getSource()==m32)
		{
			new SIMReplace();
			f.setVisible(false);
		}
		if(e.getSource()==m33)
		{
			
		}
		if(e.getSource()==cp)
		{
			try {
				new CheckProduct();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			f.setVisible(false);
		}
		if(e.getSource()==m35)
		{
			
		}
		
		if(e.getSource()==m41)
		{
			f.setVisible(false);
			new SaleReport();
		}
		if(e.getSource()==m42)
		{
			
		}
		if(e.getSource()==m43)
		{
			
		}
		if(e.getSource()==m61)
		{
			
		}
		if(e.getSource()==m62)
		{
			f.setVisible(false);
			new StockCheck();
		}
		if(e.getSource()==nia)
		{
			f.setVisible(false);
			new NetworkIssue();
		}
		if(e.getSource()==nic)
		{
			f.setVisible(false);
			new NetworkIssueCheck();
		}
		if(e.getSource()==uvas)
		{
			f.setVisible(false);
			new UpdateVAS();
		}
		if(e.getSource()==cvas)
		{
			f.setVisible(false);
			new CheckVAS();
		}
		
	}
	public void keyPressed(KeyEvent e)
	{
		if((e.getKeyCode() == KeyEvent.VK_N) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0))
		{
			new ActivationForms();	
		 	
		 	/*for(int i=0;i<6090;i++)
		 		for(int j=0;j<6090;j++)
		 		{
		 		}*/
		 f.setVisible(false);
	
		}	
		if((e.getKeyCode() == KeyEvent.VK_M) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0))
		{
			new MNPForms();
			f.setVisible(false);
		}
		if((e.getKeyCode() == KeyEvent.VK_B) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0))
		{
			new ETOPUPForms();
			
			f.setVisible(false);
		}
		if((e.getKeyCode() == KeyEvent.VK_E) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0))
		{
			f.setVisible(false);
			new EditActivation();	
		}
		if((e.getKeyCode() == KeyEvent.VK_V) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0))
		{
			new VoucherForm();
			f.setVisible(false);
		}
		if ((e.getKeyCode() == KeyEvent.VK_X) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0))  //renew
		{
		 	
		 	System.exit(0);
		}
		if((KeyEvent.CTRL_MASK) != 0 && e.getKeyCode()==KeyEvent.VK_BACK_SPACE)
		{
			new LogIn1();
			f.setVisible(false);
		}
		
		
	}
	public void keyReleased(KeyEvent e)
	{}
	public void keyTyped(KeyEvent e)
	{}
}

class MainFormDemo
{
	public static void main(String arg[])
	{
		new MainForm();
	}
}