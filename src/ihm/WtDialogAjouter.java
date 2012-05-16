package ihm ;

import java.util.Hashtable ;
import java.util.Vector ;
import java.util.Enumeration ;
import datas.* ;
import java.awt.* ;
import java.awt.event.* ;
import javax.swing.* ;

/**
 *
 */
public class WtDialogAjouter extends JDialog implements ActionListener {

	private JLabel labelOrdre, labelNom, labelPrenom, labelNumero ;
	private JComboBox liste ;
	private JTextField txtNom, txtPrenom, txtNumero ;
	private JButton buttonConfirmer, buttonAnnuler ;
	private Hashtable<String, Fiche> table ;
	private Wintel theWin ;
	private boolean alternate ;

	/**
	 *
	 */
	public WtDialogAjouter( Wintel theWin ) {
		super( theWin, "Ajouter un nouveau contact", true ); // appel constructeur JDialog
		this.setVisible( false ); // invisible à la création
		this.theWin = theWin ;
		this.setLocationByPlatform( true ) ;
		try {
			this.table = TableFiches.lireTableFiches(); // lecture des fiches disponibles
			this.creerInterface(); // mise en place du décor (voir Figure 5)
			this.attacherReactions(); // écouteurs sur les boutons et JComboBox
			buttonAnnuler.addActionListener( this ) ;
		}
		catch ( NullPointerException e ) {
			/*
			 * Gère l'exception lancée par TableFiches si 'table.bin' n'est pas présent.
			 * Ouvertre d'une fenêtre pour indiquer à l'utilisateur
			 * que le fichier 'table.bin' n'a pas été trouvé.
			 */
			WtDialogAjouterTableBin erreurTableBin = new WtDialogAjouterTableBin() ;
			this.creeInterfaceAlternative() ;
			buttonAnnuler.addActionListener( this ) ;
			this.setVisible( false ) ;
		}

	}

	/**
	 *
	 */
	private void creerInterface() {
		this.setSize( 400, 400 );
		labelOrdre = new JLabel( "Veillez choisir un nouveau contact dans la liste" , SwingConstants.CENTER ) ;
		labelOrdre.setForeground( Color.blue ) ;
		labelOrdre.setFont( new Font( null, Font.PLAIN, 16 ) ) ;
		labelNom = new JLabel( "Nom" ) ;
		labelPrenom = new JLabel( "Prenom" ) ;
		labelNumero = new JLabel( "Numéro de téléphone" ) ;
		txtNom = new JTextField() ;
		txtNom.setForeground( Color.blue ) ;
		txtPrenom = new JTextField() ;
		txtPrenom.setForeground( Color.blue ) ;
		txtNumero = new JTextField() ;
		txtNumero.setForeground( Color.blue ) ;
		// création d'un Vector<String> pour JComboBox
		Vector<String> vect = new Vector<String>( table.size() ) ;
		Enumeration<String> enu = table.keys() ;
		while ( enu.hasMoreElements() ) {
			vect.add( enu.nextElement() ) ;
		}
		liste = new JComboBox( vect ) ;
		// panneau du bas
		JPanel bas = new JPanel() ;
		bas.setLayout( new GridLayout( 1 , 2 ) ) ;
		buttonAnnuler = new JButton( "Annuler" ) ;
		buttonConfirmer = new JButton( "Confirmer" ) ;
		bas.add( buttonConfirmer ) ;
		bas.add( buttonAnnuler ) ;
		// panneau central
		this.setLayout( new GridLayout( 9 , 1 , 10 , 10 ) ) ;
		this.add( labelOrdre ) ;
		this.add( liste ) ;
		this.add( labelNom ) ;
		this.add( txtNom ) ;
		this.add( labelPrenom ) ;
		this.add( txtPrenom ) ;
		this.add( labelNumero ) ;
		this.add( txtNumero ) ;
		this.add( bas ) ;

		this.fillFields() ;

		this.alternate = false ;
	}

	/**
	 *
	 */
	private void creeInterfaceAlternative() {
		labelOrdre = new JLabel( "L\'ajout est impossible en raison des erreurs précedentes." , SwingConstants.CENTER ) ;
		labelOrdre.setForeground( Color.blue ) ;
		buttonAnnuler = new JButton( "Retour" ) ;
		this.setLayout( new GridLayout( 2 , 1 ) ) ;
		this.add( labelOrdre ) ;
		this.add( buttonAnnuler ) ;
		this.setSize( 500, 200 );
		this.alternate = true ;
	}

	/**
	 *
	 */
	private void attacherReactions() {
		if ( this.alternate == false ) {
			buttonConfirmer.addActionListener( this ) ;
			liste.addActionListener( this ) ;
		}
	}

	/**
	 *
	 */
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource() ;
		if ( src == buttonAnnuler ) { this.setVisible( false ) ; }
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
		else { this.setVisible( true ) ; }
	}

	/**
	 *
	 */
	private void fillFields() {
		String cle = String.valueOf( liste.getSelectedItem() ) ;
		Fiche tmpFiche = table.get( cle ) ;
		txtNom.setText( tmpFiche.getNom() ) ;
		txtPrenom.setText( tmpFiche.getPrenom() ) ;
		txtNumero.setText( tmpFiche.getTelephone() ) ;	
	}
}
