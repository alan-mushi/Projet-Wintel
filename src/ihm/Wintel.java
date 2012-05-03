package ihm ;

import javax.swing.* ;
import java.awt.* ;

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
	private JButton boutonComposer;
	
	//Divers
	private JLabel titreCaracteristiques;
	private JLabel titreAbonnes;
	private JList listeContacts;
	private JMenuBar menu;

	private Annuaire monAnnuaire ;

	public static void main(String[] args) {
		Wintel lanceur = new Wintel();
	}
	
	public Wintel() {
		super("Wintel"); // Appel du constructeur de JFrame
		this.creerInterface(); // Mise en place de la fenêtre
		//this.attacherReactions(); // Ecouteurs des évènements utilisateurs
		//this.init(); // Création de l'annuaire (+ des 3 WtDialog)
		this.setSize(500, 500); // Taille de la fenêtre principale
		this.setVisible(true); // Rendre la fenêtre visible à l'écran
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
		
		titreAbonnes = new JLabel("Abonnés");
		panelNord.add(titreAbonnes);
		
		titreCaracteristiques = new JLabel("Caractéristiques");
		panelNord.add(titreCaracteristiques);
		
		//Elements de la partie "centre"
		JPanel panelCentre = new JPanel();
		this.add(panelCentre, BorderLayout.CENTER);
		
		panelCentre.setLayout(new GridLayout(1, 2, 40, 0));
		listeContacts = new JList();
		panelCentre.add(listeContacts);
		
		JPanel panelCaract = new JPanel();
		panelCaract.setLayout(new GridLayout(0, 1));
		
		labNom = new JLabel("Nom");
		nom = new JTextField();
		labPrenom = new JLabel("Prénom");
		prenom = new JTextField();
		labNumero = new JLabel("Numéro");
		numero = new JTextField();
		panelCaract.add(labNom);
		panelCaract.add(nom);
		panelCaract.add(labPrenom);
		panelCaract.add(prenom);
		panelCaract.add(labNumero);
		panelCaract.add(numero);
	}
	
	private void attacherReactions() {
	
	}
	
	public void ajouterAbonne( String nom , String prenom , String num ) {
		Fiche tmpFiche ;
		try {
			tmpFiche = new Fiche( nom , prenom , num ) ;
			monAnnuaire.ajouter( tmpFiche.getNom() , tmpFiche ) ;
			DefaultListMode liste = listeContacts.getModel() ;
			liste.addElement( tmpFiche.getNom() ) ;
			listeContacts.setModel( liste ) ;
		}
		catch ( IllegalArgumentException e ) {
			/* Déclencher l'ouverture d'une fenêtre ici */
		}
	}
}
