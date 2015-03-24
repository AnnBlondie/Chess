import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ChessGUI extends JFrame{
	JButton b1;
	JLabel l1;
	
	public ChessGUI()
	{
		setTitle("Background Color for JFrame");
		//setSize(400,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	
		
		setLayout(new BorderLayout());
		JLabel background=new JLabel(new ImageIcon("minimap.jpg"));
		add(background);
		background.setLayout(new FlowLayout());
		l1=new JLabel("Here is a button");
		b1=new JButton("I am a button");
		background.add(l1);
		background.add(b1);
		pack();
	}
	
}

/*
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

	
public class ChessGUI {
	private JFrame frame;
	//private Icon ic=new ImageIcon(getClass().getResource("S.png"));
	
	public ChessGUI(String s) throws IOException{
		initialize(s);
	}
	
	public void addField(String s){
		
	}
	
	public void setVisible(boolean b){
		frame.setVisible(b);
	}
	
	private void initialize(String ss) throws IOException{
		 String path = "minimap.jpg";
	     File file = new File(path);
	     BufferedImage image = ImageIO.read(file);
	    JLabel label = new JLabel(new ImageIcon(image));
	    JButton b = new JButton("but");
	   // b.setBounds(10, 10, 100, 100);
	    //    JFrame f = new JFrame();
	       
		frame = new JFrame();
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//JLabel t = new JLabel(ss);
		//frame.getContentPane().add(t,"minimap.jpg");
		 frame.getContentPane().add(b, );
		frame.getContentPane().add(label);
		
		frame.pack();
		frame.setVisible(false);
	}
}
*/