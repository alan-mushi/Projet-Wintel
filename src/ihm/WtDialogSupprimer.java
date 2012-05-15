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
		//this.table = TableFiches.lireTableFiches(); // lecture des fiches disponibles
		this.creerInterface(); // mise en place du décor (voir Figure 5)
		this.attacherReactions(); // écouteurs sur les boutons et JComboBox
		this.setSize(400, 400);
		this.setVisible(false); // invisible à la création
	}
	
	public void creerInterface() {
		GridLayout gestionnairePlacement = new GridLayout(3, 1, 20, 20);
		// JPanel pannelPrincipal = new JPanel();
		this.setLayout(gestionnairePlacement);
		// this.add(pannelPrincipal);
		
		labelSupprimer = new JLabel("Supprimer le contact ?");
		this.add(labelSupprimer);
		
		aSupprimer = new JTextField();
		this.add(aSupprimer);
		
		GridLayout gestionnaireBoutton = new GridLayout(1, 2);
		JPanel pannelBoutton = new JPanel();
		this.add(pannelBoutton);
		pannelBoutton.setLayout(gestionnaireBoutton);
		
		confirmer = new JButton("Confirmer");
		pannelBoutton.add(confirmer);
		annuler = new JButton("Annuler");
		pannelBoutton.add(annuler);
	}
	
	public void attacherReactions() {
	
	}
	
	public void actionPerformed(ActionEvent e) {
		this.setVisible(true);
	}
}
