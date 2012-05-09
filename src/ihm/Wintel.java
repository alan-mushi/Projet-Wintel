package ihm;

import javax.swing.*;
import java.awt.*;
import datas.Annuaire;
import datas.Fiche;

public class Wintel extends JFrame {

	// Attributs des �l�ments graphiques
	//Labels
	private JLabel labNom;
	private JLabel labPrenom;
	private JLabel labNumero;
	
	//Zones de texte
	private JTextField nom;
	private JTextField prenom;
	private JTextField numero;
	
	//Boutons
	private JButton composer;
	
	//Menu
	private JMenuBar menu;
	private JMenu menuFichier;
	private JMenu menuAbonnes;
	private JMenu menuAide;
	
	//Item des menus
	private JMenuItem itemCharger;
	private JMenuItem itemSauver;
	private JMenuItem itemQuitter;
	private JMenuItem itemAjouter;
	private JMenuItem itemModifier;
	private JMenuItem itemSupprimer;
	private JMenuItem itemAide;
	
	//Divers
	private JLabel titreCaracteristiques;
	private JLabel titreAbonnes;
	private JList listeContacts;

	private Annuaire monAnnuaire ;

	public static void main(String[] args) {
		Wintel lanceur = new Wintel();
	}
	
	public Wintel() {
		super("Wintel"); // Appel du constructeur de JFrame
		this.creerInterface(); // Mise en place de la fen�tre
		//this.attacherReactions(); // Ecouteurs des �v�nements utilisateurs
		this.init(); // Cr�ation de l'annuaire (+ des 3 WtDialog)
		this.setSize(500, 500); // Taille de la fen�tre principale
		this.setVisible(true); // Rendre la fen�tre visible � l'�cran
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); // Clic sur la croix
	}
	
	private void creerInterface() {
		//Elements de la partie "nord"
		BorderLayout gestionnairePlacement = new BorderLayout();
		JPanel panelNord = new JPanel();
		this.setLayout(gestionnairePlacement);
		this.add(panelNord, BorderLayout.NORTH); //Placement de panelNord dans la partie "nord"
		GridLayout grilleNord = new GridLayout(1, 2);		
		panelNord.setLayout(grilleNord);
		
		titreAbonnes = new JLabel("Abonn�s");
		panelNord.add(titreAbonnes);
		
		titreCaracteristiques = new JLabel("Caract�ristiques");
		panelNord.add(titreCaracteristiques);
		
		//Elements de la partie "centre"
		JPanel panelCentre = new JPanel();
		this.add(panelCentre, BorderLayout.CENTER);
		
		//Centre gauche
		GridLayout grilleCentreGauche = new GridLayout(1, 2, 40, 0);
		panelCentre.setLayout(grilleCentreGauche);
		
		listeContacts = new JList();
		listeContacts.setModel(new DefaultListModel());
		panelCentre.add(listeContacts);
		
		//Centre droit
		JPanel panelCaract = new JPanel();
		GridLayout grilleCentreDroit = new GridLayout(0, 1, 0, 20);
		panelCaract.setLayout(grilleCentreDroit);
		panelCentre.add(panelCaract);
		
		labNom = new JLabel("Nom");
		nom = new JTextField();
		labPrenom = new JLabel("Pr�nom");
		prenom = new JTextField();
		labNumero = new JLabel("Num�ro");
		numero = new JTextField();
		composer = new JButton("Composer");
		panelCaract.add(labNom);
		panelCaract.add(nom);
		panelCaract.add(labPrenom);
		panelCaract.add(prenom);
		panelCaract.add(labNumero);
		panelCaract.add(numero);
		panelCaract.add(composer);
		//Cr�ation du menu
		menu = new JMenuBar();
		menuFichier = new JMenu("Fichier");
		menuAbonnes = new JMenu("Abonn�s");
		menuAide = new JMenu("Aide");
		
		//Ajout des menu � la barre de menu
		menu.add(menuFichier);
		menu.add(menuAbonnes);
		menu.add(menuAide);
		
		//Cr�ation et association des items aux menus correspondants
		itemCharger = new JMenuItem("Charger");
		menuFichier.add(itemCharger);
		itemSauver = new JMenuItem("Sauver");
		menuFichier.add(itemSauver);
		itemQuitter = new JMenuItem("Quitter");
		menuFichier.add(itemQuitter);
		
		itemAjouter = new JMenuItem("Ajouter");
		menuAbonnes.add(itemAjouter);
		itemModifier = new JMenuItem("Modifier");
		menuAbonnes.add(itemModifier);
		itemSupprimer = new JMenuItem("Supprimer");
		menuAbonnes.add(itemSupprimer);
		
		itemAide = new JMenuItem("Aide");
		menuAide.add(itemAide);
		
		setJMenuBar(menu);
	}
	
	private void init() {
		monAnnuaire = new Annuaire();
	}
	
	private void attacherReactions() {
	
	}
	
	public void ajouterAbonne(String nom , String prenom , String numTel) {
		Fiche tmpFiche;
		try {
			tmpFiche = new Fiche(nom, prenom, numTel);
			monAnnuaire.ajouter(tmpFiche.getNom(), tmpFiche);
			DefaultListModel liste = (DefaultListModel) listeContacts.getModel();
			System.out.println("Nom = " + tmpFiche.getNom());
			liste.addElement(tmpFiche.getNom());
		}
		catch(IllegalArgumentException e) {
			/* D�clencher l'ouverture d'une fen�tre ici */
			System.out.println(e.getMessage());
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
