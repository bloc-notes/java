package zLabo1;

import java.awt.*;
import javax.swing.*;

public class Test extends JFrame{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test t = new Test();
		t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public Test(){
		super("test");
		setSize(320,200);
		setLocationRelativeTo(null);
		setVisible(true);
		
		Container c = getContentPane();
		//c.setLayout(new FlowLayout());
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		
		JLabel lbl1 = new JLabel("Test Interface Graphique");
		lbl1.setAlignmentX(Component.CENTER_ALIGNMENT);
		c.add(lbl1);
		
		//Container d = getContentPane();
		JButton btn1 = new JButton("Quitter");
		btn1.setAlignmentX(Component.CENTER_ALIGNMENT);
		c.add(Box.createVerticalStrut(50));
		c.add(btn1);
	}
}