package test;

import javax.swing.*;
import javax.swing.JComboBox;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class test1 extends JFrame{
	private String[] nomsImages = {"javalogo.gif","globe.gif","sourire.gif","triste.gif"};
	private Icon[] icones={new ImageIcon(nomsImages[0]),new ImageIcon(nomsImages[1]), new ImageIcon(nomsImages[2]),new ImageIcon(nomsImages[3])};
	private JComboBox<String> combo;
	private JLabel lblImage;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test1 w = new test1();
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public test1(){
		super("Exercice2");
		setSize(300,200);
		setLocationRelativeTo(null);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		combo = new JComboBox<String>(nomsImages);
		
		lblImage = new JLabel();
		
		combo.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				lblImage.setIcon(icones[combo.getSelectedIndex()]);
			}
		});
		
		c.add(combo);
		c.add(lblImage);
		
		setResizable(false);
		setVisible(true);
	}
}
