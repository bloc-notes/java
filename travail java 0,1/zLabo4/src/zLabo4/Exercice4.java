package zLabo4;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.naming.event.ObjectChangeListener;
import javax.swing.*;

public class Exercice4 extends JFrame {
	private String[] chainesAspect={" Métal", "Nimbus", "Motif", "Windows", "Windows Classic"};
	private UIManager.LookAndFeelInfo[] aspects; 
	
	JLabel objetlbl = new JLabel("aspect et comportement Métal.");	
	JComboBox<String> ObjListe = new JComboBox<String>(chainesAspect);
	
	JRadioButton rbMetal = new JRadioButton("Métal");
	JRadioButton rbMotif = new JRadioButton("Motif");
	JRadioButton rbWindows = new JRadioButton("Windows");
	JRadioButton rbWinClassic = new JRadioButton("Windows Classic");
	JRadioButton rbNimbus = new JRadioButton("Nimbus");
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Exercice4 exeq =  new Exercice4();
	}
	
	public Exercice4 (){
		super("Aspect et comportement");
		setSize(630,200);
		setLocationRelativeTo(null);
				
		JPanel PanneauGrindN = new JPanel();
		
		PanneauGrindN.setLayout(new GridLayout(3,1));		
		add(PanneauGrindN,BorderLayout.NORTH);
				
		objetlbl.setHorizontalAlignment(objetlbl.CENTER);
		PanneauGrindN.add(objetlbl);
		
		JButton objBouton = new JButton("Bouton");
		PanneauGrindN.add(objBouton);
			
		PanneauGrindN.add(ObjListe);
		
		//Sud
		JPanel PanneauGridS = new JPanel();
		
		PanneauGridS.setLayout(new GridLayout(1,5));
		add(PanneauGridS,BorderLayout.SOUTH);
			
		ButtonGroup gb = new ButtonGroup();
		
		gb.add(rbMetal);
		gb.add(rbMotif);
		gb.add(rbWindows);
		gb.add(rbWinClassic);
		gb.add(rbWinClassic);
		gb.add(rbNimbus);
		
		rbMetal.setSelected(true);
		
		PanneauGridS.add(rbMetal);
		PanneauGridS.add(rbMotif);
		PanneauGridS.add(rbWindows);
		PanneauGridS.add(rbWinClassic);
		PanneauGridS.add(rbNimbus);	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}
	
	private void modifierAspectEtComp(int valeur) {
		// changer l'aspect et le comportement
		try {
			UIManager.setLookAndFeel(aspects[valeur].getClassName());
			SwingUtilities.updateComponentTreeUI(this);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage() + "Erreur Exception");
		}
	}
	
	private class GestionnaireOptions implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub

			if (e.getSource() == rbMetal) {
				modifierAspectEtComp(0);
				ObjListe.setSelectedIndex(0);
			} 
			else if (e.getSource() == rbMotif) {
				modifierAspectEtComp(2);
				ObjListe.setSelectedIndex(1);
			} 
			else if (e.getSource() == rbWindows) {
				modifierAspectEtComp(3);
				ObjListe.setSelectedIndex(2);
			} 
			else if (e.getSource() == rbWinClassic) {
				modifierAspectEtComp(4);
				ObjListe.setSelectedIndex(3);
			} 
			else if (e.getSource() == rbNimbus) {
				modifierAspectEtComp(1);
				ObjListe.setSelectedIndex(4);
			}
			objetlbl.setText("Aspect et comportement " + ObjListe.getSelectedItem().toString());
		}
	}
}
