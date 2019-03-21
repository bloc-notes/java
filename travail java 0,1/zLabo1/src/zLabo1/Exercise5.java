package zLabo1;
import java.awt.*;

import javax.swing.*;

public class Exercise5 extends JFrame{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Exercise5 q = new Exercise5();
		q.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public Exercise5(){
		super("Exercise 5");
		setSize(350,300);
		setLocationRelativeTo(null);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JLabel lblTitre = new JLabel("Interface Graphique Java");	
		lblTitre.setFont(new Font("serif", Font.BOLD, 30));
		c.add(Box.createVerticalStrut(60));
		c.add(lblTitre);
		c.add(Box.createVerticalStrut(89));
		//setmaxisize(getpreferesize())
		Container d = new JPanel();

		d.setLayout(new GridLayout(3,2));
		c.add(d);
			
		ButtonGroup BtnGp = new ButtonGroup();
		JRadioButton BtnR = new JRadioButton("rouge");
		BtnGp.add(BtnR);
		
	    
	    JRadioButton BtnV = new JRadioButton("vert");
		BtnGp.add(BtnV);
	    
	    JRadioButton BtnB = new JRadioButton("bleu");
		BtnGp.add(BtnB);
	    
	    JCheckBox Cb1 = new JCheckBox("gras");
		

	    JCheckBox Cb2 = new JCheckBox("italique");
		
		Container e = new JPanel();
		e.setLayout(new FlowLayout());

		JButton btnMajus = new JButton("Majuscule");
		btnMajus.setAlignmentX(Component.CENTER_ALIGNMENT);
		e.add(Box.createVerticalStrut(50));
		e.add(btnMajus);
		
		JButton btnMinus = new JButton("Minuscule");
		btnMinus.setAlignmentX(Component.CENTER_ALIGNMENT);
		e.add(btnMinus);
				
		d.add(BtnR);
		d.add(Cb1);
		d.add(BtnV);
		d.add(Cb2);
		d.add(BtnB);
			
		c.add(e);
		
		setResizable(false);
		setVisible(true);
	}
}