package ihm;

import javax.swing.*;
import java.awt.*;
import datas.*;
import java.util.Enumeration;

/**
*
*/
public class Wintel extends JFrame {

	// Attributs des éléments graphiques
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
	
	//Fenêtres
	private WtDialogSupprimer supprimerContact;
	private WtDialogAjouter ajouterContact ;
	private Annuaire monAnnuaire ;

	/**
	*
	*/
	public static void main(String[] args) {
		Wintel lanceur = new Wintel();
		// lanceur.ajouterAbonne("test", "test", "02586685241");
	}

	/**
	*
	*/
	public Wintel() {
		super("Wintel"); // Appel du constructeur de JFrame
		this.creerInterface(); // Mise en place de la fenêtre
		this.init(); // Création de l'annuaire (+ des 3 WtDialog)
		this.attacherReactions(); // Ecouteurs des évènements utilisateurs
		this.setSize(500, 500); // Taille de la fenêtre principale
		this.setVisible(true); // Rendre la fenêtre visible à l'écran
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); // Clic sur la croix
	}

	/**
	*
	*/
	private void creerInterface() {
		//Elements de la partie "nord"
		BorderLayout gestionnairePlacement = new BorderLayout();
		JPanel panelNord = new JPanel();
		this.setLayout(gestionnairePlacement);
		this.add(panelNord, BorderLayout.NORTH); //Placement de panelNord dans la partie "nord"
		GridLayout grilleNord = new GridLayout(1, 2);		
		panelNord.setLayout(grilleNord);

		titreAbonnes = new JLabel("Abonnés");
		panelNord.add(titreAbonnes);

		titreCaracteristiques = new JLabel("Caractéristiques");
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
		labPrenom = new JLabel("Prénom");
		prenom = new JTextField();
		labNumero = new JLabel("Numéro");
		numero = new JTextField();
		composer = new JButton("Composer");
		panelCaract.add(labNom);
		panelCaract.add(nom);
		panelCaract.add(labPrenom);
		panelCaract.add(prenom);
		panelCaract.add(labNumero);
		panelCaract.add(numero);
		panelCaract.add(composer);
		//Création du menu
		menu = new JMenuBar();
		menuFichier = new JMenu("Fichier");
		menuAbonnes = new JMenu("Abonnés");
		menuAide = new JMenu("Aide");

		//Ajout des menu à la barre de menu
		menu.add(menuFichier);
		menu.add(menuAbonnes);
		menu.add(menuAide);

		//Création et association des items aux menus correspondants
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
	
		this.setLocationByPlatform( true ) ;
	}

	/**
	*
	*/
	private void init() {
		monAnnuaire = new Annuaire();
		supprimerContact = new WtDialogSupprimer(this);
		ajouterContact = new WtDialogAjouter( this ) ;
	}

	/**
	*
	*/
	private void attacherReactions() {
		itemSauver.addActionListener(new EcouteurItemSauver(this));
		itemCharger.addActionListener(new EcouteurItemCharger(this));
		itemQuitter.addActionListener(new EcouteurItemQuitter(this));
		listeContacts.addMouseListener(new EcouteurListeGche(this));
		itemSupprimer.addActionListener(supprimerContact);
		itemAjouter.addActionListener( ajouterContact ) ;
	}
	
	/**
	*
	*/
	public Annuaire getAnnuaire() {
		return this.monAnnuaire;
	}

	/**
	*
	*/
	public JList getListeGche() {
		return (this.listeContacts) ;
	}

	/**
	*
	*/
	public JTextField getFieldNom() { 
		return (this.nom) ;
	}

	/**
	*
	*/
	public JTextField getFieldPrenom() {
		return (this.prenom) ;
	}

	/**
	*
	*/
	public JTextField getFieldNumero() {
		return (this.numero) ;
	}

	/**
	*
	*/
	public void ajouterAbonne(String nom , String prenom , String numTel) {
		Fiche tmpFiche;
		try {
			tmpFiche = new Fiche(nom, prenom, numTel);
			monAnnuaire.ajouter(tmpFiche.getNom(), tmpFiche);
			DefaultListModel liste = (DefaultListModel) listeContacts.getModel();
			liste.addElement(tmpFiche.getNom());
		}
		catch(IllegalArgumentException e) {
			/* Déclencher l'ouverture d'une fenêtre ici */
			System.out.println(e.getMessage());
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	*
	*/
	public void chargerEtAfficherAnnuaire() {
		Annuaire unAnnuaire = Annuaire.charger();
		Enumeration<String> cles = unAnnuaire.cles();
		while(cles.hasMoreElements()) {
			String id = cles.nextElement();
			try {
				Fiche fichePersonne = unAnnuaire.consulter(id);
				String nom = fichePersonne.getNom() ;
				String prenom = fichePersonne.getPrenom();
				String num = fichePersonne.getTelephone();
				this.ajouterAbonne(nom, prenom, num);
			}
			catch(IllegalArgumentException erreur) {
				System.out.println(erreur.getMessage());
			}
		}
	}
}
