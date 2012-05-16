package ihm;

import javax.swing.*;
import java.awt.*;

public class WtDialogModifier extends JDialog {
	//Labels
	private JLabel labelTitre;
	private JLabel labelNom;
	private JLabel labelPrenom;
	private JLabel labelNum;
	
	//Bouttons
	private JButton bouttonConfirmer;
	private JButton bouttonAnnuler;
	
	//Zones de textes
	private JTextField nom;
	private JTextField prenom;
	private JTextField num;

	private Wintel parent;
	
	public WtDialogModifier(Wintel parent) {
		this.parent = parent;
		this.creerInterface();
	}
	
	private void creerInterface() {
		//Boutton en bas
		bouttonConfirmer = new JButton("Confirmer");
		bouttonAnnuler = new JButton("Annuler");
		JPanel panelBoutton = new JPanel(new GridLayout(1, 2));
		panelBoutton.add(bouttonConfirmer);
		panelBoutton.add(bouttonAnnuler);
		
		//Panel principal
		labelTitre = new JLabel("Contact à modifier (nom inchangé)");
		labelTitre.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitre.setForeground(Color.blue);
		
		labelNom = new JLabel("Nom : ");
		labelPrenom = new JLabel("Prénom : ");
		labelNum = new JLabel("Téléphone : ");
		
		nom = new JTextField();
		prenom = new JTextField();
		num = new JTextField();
		
		BorderLayout gestionnairePlacement = new BorderLayout(10, 10);
		JPanel panelCentre = new JPanel(new GridLayout(8, 1, 0, 10));
		JPanel panelGauche = new JPanel();
		JPanel panelDroit = new JPanel();
		JPanel panelBas = new JPanel();
		this.setLayout(gestionnairePlacement);
		this.add(panelCentre, BorderLayout.CENTER);
		this.add(panelGauche, BorderLayout.WEST);
		this.add(panelDroit, BorderLayout.EAST);
		this.add(panelBas, BorderLayout.SOUTH);
		panelCentre.add(labelTitre);
		panelCentre.add(labelNom);
		panelCentre.add(nom);
		panelCentre.add(labelPrenom);
		panelCentre.add(prenom);
		panelCentre.add(labelNum);
		panelCentre.add(num);
		panelCentre.add(panelBoutton);
	}
}
