package zLabo3;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;


public class Exercice2 extends JFrame{
	
	Container c = getContentPane();
	JMenuBar barMenu = new JMenuBar();
	JMenu mFichier = new JMenu("Fichier");
	JMenu mEdition = new JMenu("Édition");
	JMenu mFormat = new JMenu("Format");
	
	JMenuItem imCouleur = new JMenuItem("Couleur");
	JMenuItem imPolice = new JMenuItem("Police");
	
	JRadioButtonMenuItem imNoir = new JRadioButtonMenuItem("noir");
	JRadioButtonMenuItem imRouge = new JRadioButtonMenuItem("Rouge");
	JRadioButtonMenuItem imVert = new JRadioButtonMenuItem("vert");
	JRadioButtonMenuItem imBleu = new JRadioButtonMenuItem("bleu");
	
	String strContenueCopier = "";
	
	private JTextArea affichage;
	private Color valeurCouleur[]={Color.black,Color.red,Color.GREEN,Color.BLUE};
	private String nomPolice [] ={"serif","courier","SansSerif"};
	private JRadioButtonMenuItem optionsCouleur[], polices[];
	private JCheckBoxMenuItem optionsStyle[];
	private ButtonGroup groupeCouleurs,groupePolices;
	private JMenuItem imCopier, imColler, imCouper;
	private int style;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Exercice2 m = new Exercice2();
		m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public Exercice2(){
		super("Utilisation des menus");
		setSize(400, 300);
		setLocationRelativeTo(null);
		
		setJMenuBar(barMenu);
		
		JMenuItem imPropos = new JMenuItem("À propos de...");
		JMenuItem imQuitter = new JMenuItem("Quitter");
		
		barMenu.add(mFichier);
		mFichier.add(imPropos);
		mFichier.add(imQuitter);
		
		barMenu.add(mEdition);
		
		GestionEdition ge=new GestionEdition();
				
		imCopier = new JMenuItem("Copier");
		imColler = new JMenuItem("Coller");
		imCouper = new JMenuItem("Couper");
		
		imCopier.addActionListener(ge);
		imColler.addActionListener(ge);
		imCouper.addActionListener(ge);

		
		mEdition.add(imCopier);
		mEdition.add(imColler);
		mEdition.add(imCouper);
		
		//couleur
		
		optionsCouleur = new JRadioButtonMenuItem[4];
		
		optionsCouleur[0] = imNoir;
		optionsCouleur[1] = imRouge;
		optionsCouleur[2] = imVert;
		optionsCouleur[3] = imBleu;
		
		groupeCouleurs = new ButtonGroup();
		
		groupeCouleurs.add(imNoir);
		groupeCouleurs.add(imRouge);
		groupeCouleurs.add(imVert);
		groupeCouleurs.add(imBleu);
			
		GestionFormat gf= new GestionFormat();
		
		imNoir.addActionListener(gf);
		imRouge.addActionListener(gf);
		imVert.addActionListener(gf);
		imBleu.addActionListener(gf);
		
		
		JMenu mCouleur = new JMenu("Couleurs");
		
		barMenu.add(mFormat);
		mFormat.add(mCouleur);
			
		imRouge.setSelected(true);
		for(int i= 0;i<4;i++){
			mCouleur.add(optionsCouleur[i]);
		}
		
		//police
		JRadioButtonMenuItem imSerif = new JRadioButtonMenuItem("Serif");
		JRadioButtonMenuItem imCourrier = new JRadioButtonMenuItem("Courrier");
		JRadioButtonMenuItem imSansSerif = new JRadioButtonMenuItem("SansSerif");
		
		imSerif.addActionListener(gf);
		imCourrier.addActionListener(gf);
		imSansSerif.addActionListener(gf);
		
		polices = new JRadioButtonMenuItem[3];
		
		polices[0] = imSerif;
		polices[1] = imCourrier;
		polices[2] = imSansSerif;
		
		groupePolices = new ButtonGroup();
		
		groupePolices.add(imSerif);
		groupePolices.add(imCourrier);
		groupePolices.add(imSansSerif);
		
	
		JMenu mPolice = new JMenu("Police");
		
		mFormat.addSeparator();
		mFormat.add(mPolice);
		
		imSerif.setSelected(true);
		
		for(int i= 0;i<3;i++){
			mPolice.add(polices[i]);
		}
		
		JCheckBoxMenuItem imGras = new JCheckBoxMenuItem("Gras");
		JCheckBoxMenuItem imItalic = new JCheckBoxMenuItem("Italic");
		
		
		
		optionsStyle = new JCheckBoxMenuItem[2];
		
		optionsStyle[0] = imGras;
		optionsStyle[1] = imItalic;
		
		imGras.setSelected(true);
		
		GestionStyle gStyle = new GestionStyle();
		
		imGras.addItemListener(gStyle);
		imItalic.addItemListener(gStyle);
		
		mPolice.addSeparator();
		mPolice.add(imGras);
		mPolice.add(imItalic);
		
		//texte
		
		affichage = new JTextArea();
		affichage.setBackground(Color.LIGHT_GRAY);
		affichage.setForeground(valeurCouleur[1]);
		affichage.setFont(new Font("serif", Font.BOLD,24));
		add(affichage);
		
		//écouteur
		
		imPropos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//JOptionPane message = new JOptionPane();
				JOptionPane.showMessageDialog(null, "Ceci est un exemple d'utilisation des menus", "Message",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		imQuitter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
		validate();
		setResizable(false);
		setVisible(true);
	}
	
	private class GestionEdition implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == imCopier){
				affichage.copy();
			}
			if (e.getSource() == imColler){
				affichage.paste();
			}
			if(e.getSource() == imCouper) affichage.cut();
		}
		
	}
	
	private class GestionStyle implements ItemListener{
		
		int intItalic = Font.PLAIN;
		int intGras = Font.BOLD;
		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == optionsStyle[0]){
				if(e.getStateChange() == ItemEvent.SELECTED){
					intGras = Font.BOLD;
				}
				else{
					intGras = Font.PLAIN;
				}
			}
			
			if(e.getSource() == optionsStyle[1]){
				if(e.getStateChange() == ItemEvent.SELECTED){
					intItalic = Font.ITALIC;
				}
				else{
					intItalic = Font.PLAIN;
				}
			}
			style = intGras + intItalic;
			
			affichage.setFont(affichage.getFont().deriveFont(style));
		}
		
	}
	
	private class GestionFormat implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			for(int i=0;i<4;i++){
				if(e.getSource() == optionsCouleur[i]) affichage.setForeground(valeurCouleur[i]);
			}
			
			
			for(int s=0;s<3;s++){
				if(e.getSource() == polices[s]) affichage.setFont(new Font(nomPolice[s],affichage.getFont().getStyle(),affichage.getFont().getSize()));
			}
			
		}
		
	}
}