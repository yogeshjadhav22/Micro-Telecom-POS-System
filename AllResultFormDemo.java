import javax.swing.*;
import java.sql.*;
import java.awt.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

class AllResultForm  implements ActionListener,MouseListener
{
	
	JButton b,p;
	JFrame f,k;
	JTable tab;
	JScrollPane jsp;
	DefaultTableModel dtm;
	String cn;
	Font f1;
	JLabel fm;
	
	 public AllResultForm(String cn,JFrame j)
	 {
		 
		 k=j;
	 	f=new JFrame("POS - Edit(All Show)");
		f.setSize(1366,768);
		f.setResizable(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fm=new JLabel(new ImageIcon("D:\\Project\\Images\\BackGround.jpg"));
		fm.setBounds(0,00,1366,768);
		JLabel header=new JLabel(new ImageIcon("D:\\Project\\Images\\headernew.jpg"));
		header.setBounds(0,0,1455,161);
		fm.add(header);
		f.setLayout(null);
		
		f1=new Font("Verdana",Font.PLAIN,13);
		
		b=new JButton("Back");
		header.add(b);
		b.setBounds(10,10,80,35);
		b.addActionListener(this);
		
		
		p=new JButton("Print");
		p.setBounds(745,600,95,35);
		p.addActionListener(this);
		fm.add(p);
		
		
		tab=new JTable();
		jsp=new JScrollPane(tab);
		fm.add(jsp);
		tab.setFont(f1);
		
		tab.setRowSelectionAllowed(true);
		tab.setColumnSelectionAllowed(false);
		//tab.addAncestorListener(this);
		dtm=new DefaultTableModel();
		jsp.setBounds(100,200,1150,300);
		
		dtm.addColumn("Customer Name");
		dtm.addColumn("Contact Number");
		dtm.addColumn("Gender");
		dtm.addColumn("Address");
		dtm.addColumn("New Number");
		dtm.addColumn("POI");
		dtm.addColumn("POI Number");
		dtm.addColumn("FRC");
		dtm.addColumn("Proof Of Address");
		dtm.addColumn("Date");
	
		
		tab.setModel(dtm);
		String s[]=new String[13];
		
		try
		{
			/*Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con=DriverManager.getConnection("Jdbc:Odbc:Micro-POS");*/
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/micropos","root","");
			PreparedStatement pst=con.prepareStatement("select * from Activation where Cname=?");
			pst.setString(1,cn);
				
			ResultSet rs=pst.executeQuery();
			
			while(rs.next())
			{
				s[0]=rs.getString(1);	
				s[1]=rs.getString(2);	
				s[2]=rs.getString(3);	
				s[3]=rs.getString(4);	
				s[4]=rs.getString(5);	
				s[5]=rs.getString(6);	
				s[6]=rs.getString(7);	
				s[7]=""+rs.getInt(8);	
				s[8]=rs.getString(9);	
				s[9]=rs.getString(10);	
				
				dtm.addRow(s);
				
			}
			con.close();
			
				
			
			
		}
		catch(Exception ee)
		{
			System.out.println(ee);	
		}
		
		
		
		f.add(fm);
		
		f.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
			if(e.getSource()==b)
			{
				//new EditActivation();	
				k.setVisible(true);
				f.setVisible(false);
			}
			if(e.getSource()==p)
			{
			// PrintableDocument.printComponent(jsp);	
				
			}
		
	
		}
	public void mouseClicked(MouseEvent e)
	{
		
	}
	public void mouseEntered(MouseEvent e)
	{
		
	}
	public void mouseReleased(MouseEvent e)
	{
		
	}
	public void mouseExited(MouseEvent e)
	{
		
	}
	public void mousePressed(MouseEvent e)
	{
		
	}
	

}


/*class AllResultFormDemo
{
	public static void main(String args[])
	{
		JFrame g = null;
		new AllResultForm("Suraj Nanasaheb Raktate",g);	
	}
}*/