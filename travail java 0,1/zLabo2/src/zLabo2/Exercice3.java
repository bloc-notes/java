package zLabo2;
import java.awt.*;

import java.awt.event.*;

import javax.swing.*;
import javax.swing.text.StyledEditorKit.ItalicAction;

public class Exercice3 extends JFrame {
	
	JButton btnMajus = new JButton("Majuscule");
	JLabel lblTitre = new JLabel("Interface Graphique Java");
	JButton btnMinus = new JButton("Minuscule");
	JCheckBox CbGras = new JCheckBox("gras");
	JCheckBox CbIta = new JCheckBox("italique");
	
	JRadioButton BtnR = new JRadioButton("rouge");
	JRadioButton BtnV = new JRadioButton("vert");
	JRadioButton BtnB = new JRadioButton("bleu");
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Exercice3 q = new Exercice3();
		q.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public Exercice3(){
		super("Exercice 3");
		setSize(350,300);
		setLocationRelativeTo(null);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
			
		lblTitre.setFont(new Font("serif", Font.BOLD, 30));
		c.add(Box.createVerticalStrut(60));
		c.add(lblTitre);
		c.add(Box.createVerticalStrut(89));
		
		Container d = new JPanel();

		d.setLayout(new GridLayout(3,2));
		c.add(d);
			
		ButtonGroup BtnGp = new ButtonGroup();
		
		BtnGp.add(BtnR);
		BtnGp.add(BtnV); 
		BtnGp.add(BtnB);
	    
		Container e = new JPanel();
		e.setLayout(new FlowLayout());
		
		GestionBouton jb = new GestionBouton();
		GestionFont cb = new GestionFont();
		GestionCouleur gc = new GestionCouleur();

		
		btnMajus.setAlignmentX(Component.CENTER_ALIGNMENT);
		e.add(Box.createVerticalStrut(50));
		e.add(btnMajus);
		
		
		btnMinus.setAlignmentX(Component.CENTER_ALIGNMENT);
		e.add(btnMinus);
		
		btnMajus.addActionListener(jb);
		btnMinus.addActionListener(jb);
		
		CbGras.addItemListener(cb);
		CbIta.addItemListener(cb);
		
		BtnR.addItemListener(gc);
		BtnB.addItemListener(gc);
		BtnV.addItemListener(gc);
		
		d.add(BtnR);
		d.add(CbGras);
		d.add(BtnV);
		d.add(CbIta);
		d.add(BtnB);
			
		c.add(e);
		
		setResizable(false);
		setVisible(true);
	}
	
	private class GestionBouton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == btnMajus){
				lblTitre.setText(lblTitre.getText().toUpperCase());
				
			}
			else if (e.getSource() == btnMinus){
				lblTitre.setText(lblTitre.getText().toLowerCase());
			}
			
			validate();
		}	
	}
	
	private class GestionFont implements ItemListener{
		int intGras,intItalic = Font.PLAIN;
		
		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == CbGras){
				if(e.getStateChange() == ItemEvent.SELECTED){
					intGras = Font.BOLD;
				}
				else{
					intGras = Font.PLAIN;
				}
			}
			
			if(e.getSource() == CbIta){
				if(e.getStateChange() == ItemEvent.SELECTED){
					intItalic = Font.ITALIC;
				}
				else{
					intItalic = Font.PLAIN;
				}
			}
			
			lblTitre.setFont(lblTitre.getFont().deriveFont(intGras+intItalic));
		}		
	}
	
	private class GestionCouleur implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == BtnR) lblTitre.setForeground(Color.RED);
			
			else if(e.getSource() == BtnB) lblTitre.setForeground(Color.BLUE);
			
			else if(e.getSource() == BtnV) lblTitre.setForeground(Color.GREEN);
		}	
	}	
}