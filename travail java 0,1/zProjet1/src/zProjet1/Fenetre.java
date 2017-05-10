package zProjet1;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

import javax.swing.*;


public class Fenetre extends JFrame{

	PanneauCarte  pCarte  = new PanneauCarte();
	
	Fenetre() {
		super("Solitaire Doyon");
		
		add(pCarte);

		setSize(1060,800);
		setVisible(true);
		
		//Barre de menu du haut
		
		JMenuBar barMenu = new JMenuBar();
		JMenu mPartie = new JMenu("Partie");
		JMenu mAide = new JMenu("Aide");
		JMenuItem imNouvellePartie = new JMenuItem("NouvellePartie");
		JMenuItem imQuitter = new JMenuItem("Couleur");
		JMenuItem imPropos = new JMenuItem("A propos");
		
		mPartie.add(imNouvellePartie);
		mPartie.add(imQuitter);
		mAide.add(imPropos);
		barMenu.add(mPartie);
		barMenu.add(mAide);
		
		setJMenuBar(barMenu);
		
		//
		
		//programmation de la bar menu
		
		imNouvellePartie.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				remove(pCarte);

				add(pCarte = new PanneauCarte());
						
				validate();
				repaint();
			}
		});
		
		
		
		this.setLocationRelativeTo(null);
		this.setResizable(false);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fenetre f = new Fenetre();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

	}

}
