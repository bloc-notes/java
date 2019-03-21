package zLabo3;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Exercice1 extends JFrame {
	
	String[] tabCouleur = {"noir","bleu","cyan","rouge","gris","vert","orange","jaune","blanc"};
	JList<String> listeGauche = new JList<>(tabCouleur);
	JList<String> listeDroite = new JList<>();
	JButton btnCopier = new JButton("Copier >>>");
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Exercice1 a = new Exercice1();
		a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public Exercice1 (){
		super("Liste a sélection multiple");
		setSize(350, 140);
		setLocationRelativeTo(null);
		
		Container ctn = getContentPane();
		ctn.setLayout(new FlowLayout());
		
		listeGauche.setVisibleRowCount(5);
		listeGauche.setFixedCellHeight(15);
		listeGauche.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
			
		add(listeGauche);		
		add(new JScrollPane(listeGauche));
		
		listeDroite.setVisibleRowCount(5);
		listeDroite.setFixedCellHeight(15);
		listeDroite.setFixedCellWidth(100);
		listeDroite.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		ctn.add(btnCopier);
		//ctn.add(listeDroite);
		ctn.add(new JScrollPane(listeDroite));
		
		btnCopier.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				java.util.List<String> liste = listeGauche.getSelectedValuesList();
				String[] maListe =liste.toArray(new String[liste.size()]);
				listeDroite.setListData(maListe);

			}
		});
		
		setResizable(true);
		setVisible(true);
	}
}
