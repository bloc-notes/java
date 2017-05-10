import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Exercice4 extends JFrame {
	private JButton btn;
	private JComboBox cBox;
	private JLabel label;
	private JRadioButton rbMetal = new JRadioButton("Métal", true);
	private JRadioButton rbMotif = new JRadioButton("Motif", false);
	private JRadioButton rbWindows = new JRadioButton("Windows", false);
	private JRadioButton rbWindowsClassic = new JRadioButton("Windows Cassic", false);
	private JRadioButton rbNimbus = new JRadioButton("Nimbus", false);
	private JRadioButton[] grpRB = { rbMetal, rbMotif, rbWindows, rbWindowsClassic, rbNimbus };
	private String[] chainesAspect = { "Métal", "Motif", "Windows", "Windows Cassic", "Nimbus" };
	private UIManager.LookAndFeelInfo[] aspects;
	private ButtonGroup btnGrp;
	private JPanel panelNord = new JPanel();
	private JPanel panelSud = new JPanel();

	public Exercice4() {
		setTitle("Démo des aspects et comportements");
		setLayout(new BorderLayout());

		aspects = UIManager.getInstalledLookAndFeels();
		cBox = new JComboBox();

		btn = new JButton("JButton");

		// Label
		label = new JLabel("Aspect et comportement Métal");
		label.setFont(new Font("calibri", Font.PLAIN, 22));
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setVerticalAlignment(JLabel.CENTER);

		btnGrp = new ButtonGroup();
		for (int i = 0; i < grpRB.length; i++) {
			btnGrp.add(grpRB[i]);
		}

		for (int i = 0; i < chainesAspect.length; i++) {
			cBox.addItem(chainesAspect[i]);
		}

		panelNord.setLayout(new GridLayout(3, 1));

		panelNord.add(label, BorderLayout.NORTH);
		panelNord.add(btn, BorderLayout.CENTER);
		panelNord.add(cBox, BorderLayout.SOUTH);

		for (int i = 0; i < grpRB.length; i++) {
			panelSud.add(grpRB[i]);
		}

		// Ajout des ItemListener
		GestionnaireOptions go = new GestionnaireOptions();
		for (int i = 0; i < grpRB.length; i++) {
			grpRB[i].addItemListener(go);
		}
		panelSud.setLayout(new GridLayout());

		add(panelNord, BorderLayout.NORTH);
		add(panelSud, BorderLayout.SOUTH);

		setSize(630, 200);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

			if (e.getSource() == grpRB[0]) {
				modifierAspectEtComp(0);
				cBox.setSelectedIndex(0);
			} else if (e.getSource() == grpRB[1]) {
				modifierAspectEtComp(2);
				cBox.setSelectedIndex(1);
			} else if (e.getSource() == grpRB[2]) {
				modifierAspectEtComp(3);
				cBox.setSelectedIndex(2);
			} else if (e.getSource() == grpRB[3]) {
				modifierAspectEtComp(4);
				cBox.setSelectedIndex(3);
			} else if (e.getSource() == grpRB[4]) {
				modifierAspectEtComp(1);
				cBox.setSelectedIndex(4);
			}
			label.setText("Aspect et comportement " + cBox.getSelectedItem().toString());
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Exercice4 exe = new Exercice4();
	}
}
