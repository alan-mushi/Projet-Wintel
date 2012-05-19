package ihm;

import javax.swing.*;
import java.awt.*;
import datas.*;
import java.util.Enumeration;

/**
 * Classe principale de l'application.<br />
 * Contient les attrbuts graphiques, les accesseurs et les
 * méthodes nécessaires à l'initialisation.
 */
public class Wintel extends JFrame {

	// Attributs graphiques.

	/** Label. */
	private JLabel labNom, labPrenom, labNumero, titreCaracteristiques, titreAbonnes;

	/** Zone de texte. */
	private JTextField nom, prenom, numero;

	/** Bouton. */
	private JButton composer;

	/** Barre des menus. */
	private JMenuBar menu;
	/** Menu. */
	private JMenu menuFichier, menuAbonnes, menuAide;

	/** Item du menu. */
	private JMenuItem itemCharger, itemSauver, itemQuitter, itemAjouter, itemModifier, itemSupprimer, itemAide;

	/** Liste des contacts. */
	private JList listeContacts;
	/** Associé à la liste des contacts. */
	private	DefaultListModel liste;

	/** Fenêtre de dialogue. */
	private WtDialogSupprimer supprimerContact;
	/** Fenêtre de dialogue. */
	private WtDialogAjouter ajouterContact ;
	/** Fenêtre de dialogue. */
	private DialogText aideApp ;
	/** Annuaire local. */
	private Annuaire monAnnuaire ;
	/** Fenêtre de dialogue. */
	private WtDialogModifier modifierContact ;

	/**
	 * Lanceur de Wintel, cette méthode se contente de créer un nouvel objet Wintel.
	 * @param args Ignoré.
	 */
	public static void main(String[] args) {
		Wintel lanceur = new Wintel();
	}

	/**
	 * Coordonne les différentes méthodes de cette classe. <code>creerInterface(), init(),
	 * attacherReactions()</code> et rendre la fenêtre visible principalement.
	 */
	public Wintel() {
		super("Wintel"); // Appel du constructeur de JFrame
		this.creerInterface(); // Mise en place de la fenêtre
		this.init(); // Création de l'annuaire (+ des 3 WtDialog)
		this.attacherReactions(); // Ecouteurs des évènements utilisateurs
		this.setSize(500, 500); // Taille de la fenêtre principale
		this.chargerEtAfficherAnnuaire() ; // Pour obtenir la liste des contacts au démarrage.
		this.setVisible(true); // Rendre la fenêtre visible à l'écran
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); // Clic sur la croix
	}

	/**
	 * Dispose tous les éléments graphiques sur la JFrame.
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
		nom.setForeground( Color.blue ) ;
		nom.setBackground( Color.white ) ;
		nom.setEditable( false ) ;
		labPrenom = new JLabel("Prénom");
		prenom = new JTextField();
		prenom.setForeground( Color.blue ) ;
		prenom.setBackground( Color.white ) ;
		prenom.setEditable( false ) ;
		labNumero = new JLabel("Numéro");
		numero = new JTextField();
		numero.setForeground( Color.blue ) ;
		numero.setBackground( Color.white ) ;
		numero.setEditable( false ) ;
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
	 * Initialise les différentes fenêtres et l'objet Annuaire local.
	 */
	private void init() {
		monAnnuaire = new Annuaire();
		supprimerContact = new WtDialogSupprimer(this);
		ajouterContact = new WtDialogAjouter( this ) ;
		aideApp = new DialogText( this ) ;
		modifierContact = new WtDialogModifier( this ) ;
	}

	/**
	 * Attache les réactions aux éléments graphiques. Utilisé pour le bouton et
	 * les divers menus.
	 */
	private void attacherReactions() {
		itemSauver.addActionListener(new EcouteurItemSauver(this));
		itemCharger.addActionListener(new EcouteurItemCharger(this));
		itemQuitter.addActionListener(new EcouteurItemQuitter(this));
		listeContacts.addMouseListener(new EcouteurListeGche(this));
		itemSupprimer.addActionListener(supprimerContact);
		itemAjouter.addActionListener( ajouterContact ) ;
		itemAide.addActionListener( aideApp ) ;
		itemModifier.addActionListener( modifierContact ) ;
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
	public DefaultListModel getListe() {
		return this.liste;
	}

	/**
	 *
	 */
	public JMenuItem getItemAide() {
		return ( this.itemAide ) ;
	}

	/**
	 * Efface le contenu des JTextField.
	 */
	public void clearFields() {
		nom.setText( "" ) ;
		prenom.setText( "" ) ;
		numero.setText( "" ) ;
	}

	/**
	 * Ajoute une Fiche à l'annuaire local et à la JList.<br />
	 * Les exceptions liées à Fiche sont affichées.
	 * @see datas.Annuaire
	 * @see datas.Fiche
	 */
	public void ajouterAbonne(String nom , String prenom , String numTel) {
		Fiche tmpFiche;
		try {
			tmpFiche = new Fiche(nom, prenom, numTel);
			monAnnuaire.ajouter(tmpFiche.getNom(), tmpFiche);
			liste = (DefaultListModel) listeContacts.getModel();
			liste.addElement(tmpFiche.getNom());
		}
		catch(IllegalArgumentException e) {
			/*
			 * Ouverture d'une fenêtre ?
			 * Utile si on laisse le choix à l'utilisateur de 
			 * remplir/modifier les champs de contacts.
			 */
			System.out.println(e.getMessage());
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Chrage le fichier <code>annuaire.out</code> situé dans le 
	 * répertoire courant. Utilise la méthode ajouterAbonne() pour
	 * ajouter les nouvelles instances de Fiche dans l'annuaire local.
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
