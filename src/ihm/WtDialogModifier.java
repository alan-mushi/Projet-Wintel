package ihm;

import javax.swing.*;
import java.awt.*;

/**
 * Cette classe gère la fenêtre de modification d'un contact.
 */
public class WtDialogModifier extends JDialog {

	/** Attribut graphique. */
	private JLabel labelTitre, labelNom, labelPrenom, labelNum;
	/** Attribut graphique. */
	private JButton bouttonConfirmer, bouttonAnnuler;
	/** Attribut graphique. */
	private JTextField nom, prenom, num;

	/** Copie locale de Wintel. */
	private Wintel parent;

	/**
	 * Le constructeur permet également de mettre en place l'interface graphique.
	 */
	public WtDialogModifier(Wintel parent) {
		this.parent = parent;
		this.creerInterface();
	}

	/**
	 *
	 */
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
		nom.setEditable( false ) ;
		nom.setBackground( Color.white ) ;
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

		this.setVisible( true ) ;
	}
}
