package zLabo1;

import java.awt.*;
import javax.swing.*;

public class Exercise4 extends JFrame{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Exercise4 e = new Exercise4();
		e.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public Exercise4() {
		// TODO Auto-generated constructor stub
		super("Exercise4");
		setSize(200,300);
		setLocationRelativeTo(null);
		
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JTextField tb1 = new JTextField("ceci est un champ de texte");
		tb1.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		tb1.setFont(new Font("serif", Font.BOLD, 14));
		tb1.setForeground(Color.RED);
		tb1.setCursor(new Cursor(Cursor.WAIT_CURSOR));
		c.add(tb1);
		
		String strTexte = "Ceci est une zone de texte\n qui peut prendre plusieurs lignes";
		JTextArea lbl1 = new JTextArea(strTexte);
		lbl1.setBackground(Color.cyan);
		lbl1.setEditable(false);
		lbl1.setBorder(BorderFactory.createRaisedBevelBorder());
		lbl1.setToolTipText("Manger vos céréals");
		c.add(lbl1);
		
		JButton btn = new JButton("quitter");
		btn.setIcon(new ImageIcon("exit.gif"));
		btn.setRolloverIcon(new ImageIcon(""));
		c.add(btn);
		
		btn = new JButton("effacer");
		btn.setEnabled(false);
		c.add(btn);
		
		
		setResizable(false);
		setVisible(true);
	}
}