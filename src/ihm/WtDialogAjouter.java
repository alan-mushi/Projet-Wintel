package ihm ;

import java.util.Hashtable ;
import java.util.Vector ;
import java.util.Enumeration ;
import datas.* ;
import java.awt.* ;
import java.awt.event.* ;
import javax.swing.* ;

/**
 * Cette classe permet l'ajout de contacts dans l'annuaire de Wintel
 * depuis le fichier <code>table.bin</code>.<br />
 * Un mécanisme de vérification et d'alerte à été mis en place pour
 * l'utilisateur. Ainsi, la fenêtre d'ajout des contacts 
 * va alerter l'utilisateur si le fichier <code>table.bin</code> 
 * n'est pas présent dans le répertoire courant.
 */
public class WtDialogAjouter extends JDialog implements ActionListener {

	/** Attribut graphique. */
	private JLabel labelOrdre, labelNom, labelPrenom, labelNumero, labelAdresse ;
	/** Attribut graphique. */
	private JComboBox liste ;
	/** Attribut graphique. */
	private JTextField txtNom, txtPrenom, txtNumero, txtAdresse ;
	/** Attribut graphique. */
	private JButton buttonConfirmer, buttonAnnuler ;
	/** Attribut graphique. */
	private JPanel panB, panG, panM, panD ;

	/** Attribut utilisé localement. */
	private Hashtable<String, Fiche> table ;
	/** Objet Wintel "privé". */
	private Wintel theWin ;
	/** Utilisé pour tester la présence du fichier <code>table.bin</code>. */
	private boolean alternate ;

	/**
	 * Ce constructeur permet de coordonner les diverses méthodes suivantes.
	 * @param theWin Objet Wintel, utilisé pour l'ajout du contact.
	 */
	public WtDialogAjouter( Wintel theWin ) {
		super( theWin, "Ajouter un nouveau contact", true ); // appel constructeur JDialog
		this.setVisible( false ); // invisible à la création
		this.theWin = theWin ;
		this.setLocationByPlatform( true ) ;
		try {
			this.table = TableFiches.lireTableFiches(); // lecture des fiches disponibles
			this.creerInterface(); // mise en place du décor (voir Figure 4)
			this.attacherReactions(); // écouteurs sur les boutons et JComboBox
		}
		catch ( NullPointerException e ) {
			/*
			 * Gère l'exception lancée par TableFiches si 'table.bin' n'est pas présent.
			 * Ouvertre d'une fenêtre pour indiquer à l'utilisateur
			 * que le fichier 'table.bin' n'a pas été trouvé.
			 */
			this.setVisible( false ) ;
			WErreurGenerique erreurW = new WErreurGenerique( "Le fichier 'table.bin' n'a pas été trouvé. Veuillez l'ajouter." ) ;
		}

	}

	/**
	 * Cette méthode dispose les éléments graphiques
	 * uniquement si la lecture du fichier <code>table.bin</code> a réussi.
	 */
	private void creerInterface() {
		this.setSize( 400, 400 );
		labelOrdre = new JLabel( "Veillez choisir un nouveau contact dans la liste" , SwingConstants.CENTER ) ;
		labelOrdre.setForeground( Color.blue ) ;
		labelOrdre.setFont( new Font( null, Font.PLAIN, 16 ) ) ;
		labelNom = new JLabel( "Nom" ) ;
		labelPrenom = new JLabel( "Prenom" ) ;
		labelNumero = new JLabel( "Numéro de téléphone" ) ;
		labelAdresse = new JLabel("Adresse : ");
		txtNom = new JTextField() ;
		txtNom.setForeground( Color.blue ) ;
		txtNom.setEditable( false ) ;
		txtNom.setBackground( Color.white ) ;
		txtPrenom = new JTextField() ;
		txtPrenom.setForeground( Color.blue ) ;
		txtPrenom.setEditable( false ) ;
		txtPrenom.setBackground( Color.white ) ;
		txtNumero = new JTextField() ;
		txtNumero.setForeground( Color.blue ) ;
		txtNumero.setEditable( false ) ;
		txtNumero.setBackground( Color.white ) ;
		txtAdresse = new JTextField();
		txtAdresse.setForeground(Color.blue);
		txtAdresse.setEditable(false);
		txtAdresse.setBackground(Color.white);
		// création d'un Vector<String> pour JComboBox
		Vector<String> vect = new Vector<String>( table.size() ) ;
		Enumeration<String> enu = table.keys() ;
		while ( enu.hasMoreElements() ) {
			vect.add( enu.nextElement() ) ;
		}
		liste = new JComboBox( vect ) ;
		// panneau du bas
		panB = new JPanel() ;
		panB.setLayout( new GridLayout( 1 , 2 ) ) ;
		buttonAnnuler = new JButton( "Annuler" ) ;
		buttonConfirmer = new JButton( "Confirmer" ) ;
		panB.add( buttonConfirmer ) ;
		panB.add( buttonAnnuler ) ;
		// panneau central
		panG = new JPanel() ;
		panM = new JPanel() ;
		panD = new JPanel() ;

		panM.setLayout( new GridLayout( 11 , 1 , 10 , 10 ) ) ;
		panM.add( labelOrdre ) ;
		panM.add( liste ) ;
		panM.add( labelNom ) ;
		panM.add( txtNom ) ;
		panM.add( labelPrenom ) ;
		panM.add( txtPrenom ) ;
		panM.add( labelNumero ) ;
		panM.add( txtNumero ) ;
		panM.add(labelAdresse);
		panM.add(txtAdresse);
		panM.add( panB ) ;
		this.setLayout( new BorderLayout() ) ;
		this.add( panG , BorderLayout.WEST ) ;
		this.add( panM , BorderLayout.CENTER ) ;
		this.add( panD , BorderLayout.EAST ) ;

		this.fillFields() ;	// remplit les champs avec le contact sélectionné.

		this.alternate = false ;
	}

	/**
	 * Cette méthode est utilisée si le fichier <code>table.bin</code>
	 * est dans le répertoire courant.
	 */
	private void attacherReactions() {
		if ( this.alternate == false ) {
			buttonAnnuler.addActionListener( this ) ;
			buttonConfirmer.addActionListener( this ) ;
			liste.addActionListener( this ) ;
		}
	}

	/**
	 * Cette méthode gère les actions sur les boutons.
	 * Principalement les actions d'ouverture et de fermerture de la fenêtre.
	 */
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource() ;
		if ( src == buttonAnnuler ) { this.setVisible( false ) ; }
		// ajoute l'abonné dans l'annuaire de Wintel.
		else if ( src == buttonConfirmer ) {
			String tmpNom, tmpPrenom, tmpNum ;
			tmpNom = txtNom.getText() ;
			tmpPrenom = txtPrenom.getText() ;
			tmpNum = txtNumero.getText() ;
			theWin.ajouterAbonne( tmpNom, tmpPrenom, tmpNum ) ;
			theWin.getAnnuaire().sauver() ;
			this.setVisible( false ) ;
		}
		else if ( src == liste ) {
			this.fillFields() ;
		}
		else if ( alternate ) {
			this.setVisible( false ) ;
			WErreurGenerique erreurW = new WErreurGenerique( "Le fichier 'table.bin' n'a pas été trouvé. Veuillez l'ajouter." ) ;
		}
		else { this.setVisible( true ) ; }
	}

	/**
	 * Cette méthode remplit les divers champs correspondant
	 * au contact sélectionné.
	 */
	private void fillFields() {
		String cle = String.valueOf( liste.getSelectedItem() ) ;
		Fiche tmpFiche = table.get( cle ) ;
		txtNom.setText( tmpFiche.getNom() ) ;
		txtPrenom.setText( tmpFiche.getPrenom() ) ;
		txtNumero.setText( tmpFiche.getTelephone() ) ;	
	}
}
