package ihm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import datas.*;
import control.* ;
import java.util.Enumeration;

/**
 * Classe principale de l'application.<br />
 * Contient les attrbuts graphiques, les accesseurs et les
 * méthodes nécessaires à l'initialisation.
 */
public class Wintel extends JFrame implements ActionListener {

	// Attributs graphiques.

	/** Label. */
	private JLabel labNom, labPrenom, labNumero, titreCaracteristiques, titreAbonnes, labAdresse;

	/** Zone de texte. */
	private JTextField nom, prenom, numero, adresse;

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
		labAdresse = new JLabel("Adresse");
		adresse = new JTextField();
		adresse.setForeground(Color.blue);
		adresse.setBackground(Color.white);
		adresse.setEditable(false);
		composer = new JButton("Composer");
		panelCaract.add(labNom);
		panelCaract.add(nom);
		panelCaract.add(labPrenom);
		panelCaract.add(prenom);
		panelCaract.add(labNumero);
		panelCaract.add(numero);
		panelCaract.add(labAdresse);
		panelCaract.add(adresse);
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
		itemSauver.addActionListener( this );
		itemCharger.addActionListener( this );
		itemQuitter.addActionListener( this );
		listeContacts.addMouseListener(new EcouteurListeGche(this));
		itemSupprimer.addActionListener(supprimerContact);
		itemAjouter.addActionListener( ajouterContact ) ;
		itemAide.addActionListener( aideApp ) ;
		itemModifier.addActionListener( modifierContact ) ;
	}

	/**
	 * Permet de récupérer l'annuaire.
	 * @return L'annuaire actuel.
	 */
	public Annuaire getAnnuaire() {
		return this.monAnnuaire;
	}

	/**
	 * Permet de récupérer la JList de l'interface principale.
	 * @return Retourne la liste de gauche présente dans la fenêtre principale.
	 */
	public JList getListeGche() {
		return ( this.listeContacts ) ;
	}

	/**
	 * Récupère le champ contenant le nom du contact.
	 * @return Retourne le champ contenant le nom.
	 */
	public JTextField getFieldNom() { 
		return ( this.nom ) ;
	}

	/**
	 * Récupère le champ contenant le prénom du contact.
	 * @return Retourne le champ contenant le prénom.
	 */
	public JTextField getFieldPrenom() {
		return ( this.prenom ) ;
	}

	/**
	 * Récupère le champ contenant l'adresse du contact.
	 * @return Retourne le champ contenant l'adresse. 
	 */
	public JTextField getFieldAdresse() {
		return ( this.adresse ) ;
	}

	/**
	 * Renvoie le champ contenant le numéro de téléphone du contact.
	 * @return Le champ contenant le numéro du contact.
	 */
	public JTextField getFieldNumero() {
		return ( this.numero ) ;
	}

	/**
	 * Retourne la liste des contacts contenu dans la JList de la fenêtre principale.
	 * @return La liste des contacts affiché dans la JList.
	 */
	public DefaultListModel getListe() {
		return this.liste;
	}

	/**
	 * Retourne le JMenuItem du menu de la fenêtre principale.
	 * @return Le JMenuItem permettant d'accèder à la fenêtre de l'aide.
	 */
	public JMenuItem getItemAide() {
		return ( this.itemAide ) ;
	}

	/**
	 * Retourne le JMenuItem du menu de la fenêtre principale.
	 * @return Le JMenuItem permettant le chargement.
	 */
	public JMenuItem getItemCharger() {
		return ( this.itemCharger ) ;
	}

	/**
	 * Retourne le JMenuItem du menu de la fenêtre principale.
	 * @return Le JMenuItem permettant de sauver l'annuaire.
	 */
	public JMenuItem getItemSauver() {
		return ( this.itemSauver ) ;
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
			 * Ouverture d'une fenêtre pour champs invalides.
			 * On récupère le message pour remplir la fenêtre d'erreur.
			 */
			WErreurGenerique erreurW = new WErreurGenerique( e.getMessage()) ;
		}
		catch(Exception e) {
			/*
			 * Ouverture d'une fenêtre pour clé déjà présente.
			 */
			WErreurGenerique erreurW = new WErreurGenerique( e.getMessage() ) ;
		}
	}

	/**
	 * Ajoute un abonné avec une fiche. Les exceptions sont traitées en local.
	 */
	public void ajouterAbonne( Fiche newAb ) {
		try {
			monAnnuaire.ajouter( newAb.getNom() , newAb ) ;
			liste = (DefaultListModel) listeContacts.getModel() ;
			liste.addElement( newAb.getNom() ) ;
		}
		catch ( IllegalArgumentException e ) { 
			WErreurGenerique erreurW = new WErreurGenerique( e.getMessage() ) ;
		}
		catch ( Exception e ) { 
			WErreurGenerique erreurW = new WErreurGenerique( e.getMessage() ) ;
		}
	}

	/**
	 * Charge le fichier <code>annuaire.out</code> situé dans le 
	 * répertoire courant. Utilise la méthode ajouterAbonne() pour
	 * ajouter les nouvelles instances de Fiche dans l'annuaire local.
	 */
	public void chargerEtAfficherAnnuaire() {
		Annuaire unAnnuaire = Annuaire.charger();
		Enumeration<String> cles = unAnnuaire.cles();
		/* 
		* Ajoute chaque cle tiré de l'Enumeration
		* par le biais de la méthode ajouterAbonne().
		*/
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
				WErreurGenerique erreurW = new WErreurGenerique(erreur.getMessage());
			}
		}
	}

	/**
	 * Supprime le contact sélectionné de la liste et de l'annuaire.
	 * @return <code>true</code> si l'opération s'est déroulée correctement, 
	 * <code>false</code> sinon.
	 */
	public boolean rmAbonne() {
		boolean res = false ;
		try {
			if ( listeContacts.getSelectedValue() != null ) {
				String valeur = (String) listeContacts.getSelectedValue() ;
				monAnnuaire.supprimer( valeur ) ;
				this.liste.removeElement( valeur ) ;
				this.clearFields() ;
				res = true ;
			}
		}
		catch ( IllegalArgumentException e ) { 
			WErreurGenerique erreurW = new WErreurGenerique( e.getMessage() ) ;
		}
		catch ( Exception e ) { 
			WErreurGenerique erreurW = new WErreurGenerique( e.getMessage() ) ;
		}

		return ( res ) ;
	}

	/**
	 *
	 */
	public void actionPerformed( ActionEvent e ) {
		Object src = e.getSource() ;
		if ( src == itemSauver ) {
			monAnnuaire.sauver() ;
		}
		else if ( src == itemCharger ) {
			this.chargerEtAfficherAnnuaire() ;
		}
		else if ( src == itemQuitter ) {
			this.dispose() ;
		}
		else { System.out.println("Oo boy ! " + src ) ; }
	}
}
