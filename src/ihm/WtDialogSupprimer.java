package ihm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import datas.*;

public class WtDialogSupprimer  extends JDialog implements ActionListener {
	private JLabel labelSupprimer;
	private JTextField aSupprimer;
	private JButton confirmer;
	private JButton annuler;
	private Wintel parent;
	
	public WtDialogSupprimer(Wintel parent) {
		super(parent, "Supprimer un contact", true); // appel constructeur JDialog
		this.parent = parent;
		this.creerInterface(); // mise en place du décor (voir Figure 5)
		this.attacherReactions(); // écouteurs sur les boutons et JComboBox
		this.setSize(300, 300);
		this.setVisible(false); // invisible à la création
	}
	
	public void creerInterface() {
		// Boutton en bas
		confirmer = new JButton("Confirmer");
		annuler = new JButton("Annuler");
		JPanel pannelBoutton = new JPanel(new GridLayout(1, 2));
		pannelBoutton.add(confirmer);
		pannelBoutton.add(annuler);
		
		// Panel principal
		labelSupprimer = new JLabel("Supprimer le contact ?");
		labelSupprimer.setHorizontalAlignment(SwingConstants.CENTER);
		labelSupprimer.setForeground(Color.blue);
		labelSupprimer.setFont(new Font(null, Font.PLAIN, 18));
		
		aSupprimer = new JTextField();
		aSupprimer.setForeground(Color.blue);
		aSupprimer.setFont(new Font(null, Font.PLAIN, 18));
		
		BorderLayout gestionnaireCentre = new BorderLayout(20, 20);
		JPanel panelCentre = new JPanel(new GridLayout(3, 1, 0, 20));
		JPanel panelGauche = new JPanel();
		JPanel panelDroit = new JPanel();
		JPanel panelBas = new JPanel();
		this.setLayout(gestionnaireCentre);
		this.add(panelCentre, BorderLayout.CENTER);
		this.add(panelGauche, BorderLayout.WEST);
		this.add(panelDroit, BorderLayout.EAST);
		this.add(panelBas, BorderLayout.SOUTH);
		
		panelCentre.add(labelSupprimer);
		panelCentre.add(aSupprimer);
		panelCentre.add(pannelBoutton);
	}
	
	public void attacherReactions() {
		annuler.addActionListener(new EcouteurAnnulerSupprimer(this));
		confirmer.addActionListener(new EcouteurConfirmerSuppression(this));
	}
	
	public void actionPerformed(ActionEvent e) {
		JList liste = parent.getListeGche();
		if(liste.getSelectedValue() != null) {
			String valeur = (String) liste.getSelectedValue();
			aSupprimer.setText(valeur);
		}
		this.setVisible(true);
	}
	
	public Wintel getParent() {
		return parent;
	}
}
