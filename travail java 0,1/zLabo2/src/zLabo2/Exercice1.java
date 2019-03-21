package zLabo2;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Exercice1 extends JFrame implements ActionListener{
 JButton btnQuitter = new JButton("Quitter");
 JButton btnAjouter = new JButton("Ajouter");
 JButton btnInitialiser = new JButton("Initialiser");
 int intCompteur = 1;
 
 JPanel PanneauCentre = new JPanel();
 JPanel PanneauHaut = new JPanel();
 JPanel PanneauBas = new JPanel();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		Exercice1 q = new Exercice1();
		q.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public Exercice1(){
		super("Exercise 1");
		setSize(400,400);
		setLocationRelativeTo(null);
		
		PanneauBas.setLayout(new GridLayout(1,3));
			
		JLabel lblTitre = new JLabel("associer des actions aux boutons");
		lblTitre.setFont(new Font("serif", Font.BOLD, 24 ));

		PanneauHaut.add(lblTitre);
		
		PanneauBas.add(btnQuitter);
		PanneauBas.add(btnAjouter);
		PanneauBas.add(btnInitialiser);
		
		add(PanneauHaut);
		add(PanneauBas,BorderLayout.SOUTH);
		
		btnQuitter.addActionListener(this);
		btnAjouter.addActionListener(this);
		btnInitialiser.addActionListener(this);
		
		setResizable(false);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub	
		JButton source = (JButton) e.getSource();
		
		if(source == btnQuitter){
			System.exit(0);
		}
		else if(source == btnAjouter) {
			JButton btnRajouter = new JButton("Bouton" + intCompteur);
			
			btnRajouter.addActionListener(this);
			
			PanneauCentre.add(btnRajouter);
			add(PanneauCentre,BorderLayout.CENTER);
			add(PanneauHaut,BorderLayout.NORTH);
			add(PanneauBas,BorderLayout.SOUTH);
			validate();
			intCompteur++;
		}
		else if (source == btnInitialiser){
			PanneauCentre.removeAll();
			repaint();
			intCompteur = 1;
		}
		else{
			PanneauCentre.remove(source);
			validate();
			repaint();
		}
	}
}