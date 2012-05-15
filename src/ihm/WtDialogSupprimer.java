package ihm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import datas.*;

public class WtDialogSupprimer  extends JDialog implements ActionListener {
	private JLabel labelSupprimer;
	private JTextField aSupprimer;
	private JButton confirmer;
	private JButton Annuler;
	private Wintel parent;
	
	public WtDialogSupprimer(Wintel parent) {
		super(parent, "Supprimer un contact", true); // appel constructeur JDialog
		//this.table = TableFiches.lireTableFiches(); // lecture des fiches disponibles
		this.creerInterface(); // mise en place du décor (voir Figure 5)
		this.attacherReactions(); // écouteurs sur les boutons et JComboBox
		this.setSize(400, 400);
		this.setVisible(false); // invisible à la création
	}
	public void creerInterface() {
		GridLayout gestionnairePlacement = new GridLayout(3, 1);
		this.setLayout(gestionnairePlacement);
		
		labelSupprimer = new JLabel("Supprimer le contact ?");
		this.add(labelSupprimer);
		
		aSupprimer = new JTextField();
		this.add(aSupprimer);
	}
	public void attacherReactions() {
	
	}
	public void actionPerformed(ActionEvent e) {
		System.out.println("Je passe par ici.");
		this.setVisible(true);
	}
}