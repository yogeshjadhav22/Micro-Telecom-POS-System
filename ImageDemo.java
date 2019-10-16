import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class ImageDemo extends JFrame
{
JButton b1;
JLabel l1;
	public ImageDemo()
	{
	setTitle("Background Color for JFrame");
	setSize(1366,768);
	setLocationRelativeTo(null);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	JLabel background=new JLabel(new ImageIcon("D:\\BackGround.jpg"));//("D:\\Aircel_Logo.svg.png"));
	add(background);
/*	l1=new JLabel("Here is a button");
	b1=new JButton("I am a button");
	l1.setBounds(500,500,100,20);
	b1.setBounds(650,500,100,20);
	background.add(l1);
	background.add(b1);*/

	setVisible(true);
	}
	public static void main(String args[])
	{
	new ImageDemo();
	}
}