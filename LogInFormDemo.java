import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.applet.*;
import java.net.*;
class LogIn1 implements ActionListener,KeyListener
{
	
	JButton b1,b2;
	JLabel l1,l2,l3,wrong;
	JFrame f;
	JTextField t1;
	JPasswordField t2;
	Font f1,f2,f3;
	AudioClip sound1;
	
	 LogIn1()
	 {
	 	f=new JFrame("POS - Log In");
		f.setSize(1366,768);
		f.setResizable(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//f.setLayout(null);
		f1=new Font("Arial",Font.BOLD,16);
		f2=new Font("",Font.ITALIC,10);
		f3=new Font("Arial",Font.ITALIC,16);
		
		

	    wrong=new JLabel("You Entered Wrong Unseranme Or Password");
	 	wrong.setBounds(100,320,1000,30);
	 	wrong.setFont(f3);
		f.add(wrong);
		wrong.setForeground(Color.RED);
		wrong.setVisible(false);
			
		l1=new JLabel("Username");
		l1.setBounds(50,200,100,20);
		l1.setFont(f1);
		
		l2=new JLabel("Password");
		l2.setBounds(50,240,100,20);
		l2.setFont(f1);
		
		b1=new JButton("Log In");
	
		b1.setBounds(100,290,100,30);
		b1.addActionListener(this);
		b2=new JButton("Exit");
		b2.setBounds(260,290,100,30);
		b2.addActionListener(this);
	
		t1=new JTextField(10);
		t1.setBounds(190,200,200,30);
		
		t2=new JPasswordField(10);
		t2.setBounds(190,240,200,30);
		t2.setEchoChar('*');
		t2.addKeyListener(this);
		
		
		
		
		
		JLabel bg=new JLabel(new ImageIcon("D:\\Project\\Images\\BackGround.jpg"));
		bg.setBounds(0,0,1100,600);
		JScrollPane jsp=new JScrollPane(bg);
		f.add(jsp);
		
		
		bg.add(l1);
		bg.add(b1);
		bg.add(b2);
		bg.add(l2);
		bg.add(t1);
		bg.add(t2);
		f.addKeyListener(this);
		f.setVisible(true);
	 }
	 public void actionPerformed(ActionEvent e)
	 {
	 	String un=null,pw=null;
	 	
	 	
	 	if(e.getSource()==b1)
	 	{
	 		wrong.setVisible(false);
	 		int m=0;
	 		try
	 		{
	 			sound1=Applet.newAudioClip(new URL("file:Sound/Buzz.wav"));
	 			Class.forName("com.mysql.jdbc.Driver");//("sun.jdbc.odbc.JdbcOdbcDriver");
	 			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/MicroPOS","root","");//("Jdbc:Odbc:Micro-POS");
	 			Statement stmt=con.createStatement();
	 			String qry="select * from LogIn";
	 			ResultSet rs=stmt.executeQuery(qry);
	 				
	 			while(rs.next())
	 			{
	 				un=rs.getString(1);
	 				pw=rs.getString(2);
	 			//	JOptionPane.showMessageDialog(null,un,"\n"+pw,JOptionPane.PLAIN_MESSAGE);
	 				break;
	 			}
	 			con.close();
	 			if(t1.getText().equals(un) && t2.getText().equals(pw))
	 			{
	 				JOptionPane.showMessageDialog(null,"You Logged Successfully","Logged",JOptionPane.PLAIN_MESSAGE);
	 				new MainForm();
	 				f.setVisible(false);	 				
	 			}
	 			{
	 				
	 				sound1.play();
					wrong.setVisible(true);
	 			}
	 					 			
	 		}
	 		catch(Exception a)
	 		{
	 			System.out.println(a);
	 		}
	 		
	 	}
	 	if(e.getSource()==b2)
	 	{
	 		int n=JOptionPane.showConfirmDialog(null,"Are You Sure??","Exit",JOptionPane.YES_NO_OPTION);
	 		if(n==JOptionPane.YES_OPTION)
	 		{
	 			System.exit(0);
	 		}
	 	}
	 	
	 }
	
	public void keyPressed(KeyEvent e) {
		
		if ((e.getKeyCode() == KeyEvent.VK_X) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0))  //EXIT
		{
			int n=JOptionPane.showConfirmDialog(null,"Are You Sure??","Exit",JOptionPane.YES_NO_OPTION);
	 		if(n==JOptionPane.YES_OPTION)
	 		{
	 			System.exit(0);
	 		}
		}
		if((e.getKeyCode() == KeyEvent.VK_ENTER))
		{
			wrong.setVisible(false);
	 		int m=0;
	 		try
	 		{
	 			sound1=Applet.newAudioClip(new URL("file:Sound/Buzz.wav"));
	 			Class.forName("com.mysql.jdbc.Driver");//("sun.jdbc.odbc.JdbcOdbcDriver");
	 			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/MicroPOS","root","");//("Jdbc:Odbc:Micro-POS");
	 			Statement stmt=con.createStatement();
	 			String qry="select * from LogIn";
	 			ResultSet rs=stmt.executeQuery(qry);
	 				
	 			String un = null;
				String pw = null;
				while(rs.next())
	 			{
	 				un=rs.getString(1);
	 				pw=rs.getString(2);
	 			//	JOptionPane.showMessageDialog(null,un,"\n"+pw,JOptionPane.PLAIN_MESSAGE);
	 				break;
	 			}
	 			con.close();
	 			if(t1.getText().equals(un) && t2.getText().equals(pw))
	 			{
	 				JOptionPane.showMessageDialog(null,"You Logged Successfully","Logged",JOptionPane.PLAIN_MESSAGE);
	 				new MainForm();
	 				f.setVisible(false);	 				
	 			}
	 			else{
	 				sound1.play();
					wrong.setVisible(true);}
	 		}catch(Exception a)
	 		{
	 			System.out.println(a);
	 		}
	 		
		}
				
		
	}
	
	public void keyReleased(KeyEvent arg0) {
		
		
	}
	
	public void keyTyped(KeyEvent arg0) {
				
	}
	 
}

class LogInFormDemo
{
	public static void main(String arg[])
	{
		new LogIn1();
	}
}