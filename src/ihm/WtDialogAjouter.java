package ihm ;

import java.util.Hashtable ;
import java.util.Vector ;
import java.util.Enumeration ;
import datas.* ;
import java.awt.* ;
import javax.swing.* ;

/**
*
*/
public class WtDialogAjouter extends JDialog {

	private JLabel labelOrdre, labelNom, labelPrenom, labelNumero ;
	private JComboBox liste ;
	private JTextField txtNom, txtPrenom, txtNumero ;
	private JButton buttonConfirmer, buttonAnnuler ;
	private Hashtable<String, Fiche> table ;

	/**
	*
	*/
	public WtDialogAjouter( Wintel theWin ) {
		super( theWin, "Ajouter un nouveau contact", true ); // appel constructeur JDialog
		this.table = TableFiches.lireTableFiches(); // lecture des fiches disponibles
		this.creerInterface(); // mise en place du décor (voir Figure 5)
		this.attacherReactions(); // écouteurs sur les boutons et JComboBox
		this.setSize( 400, 400 );
		this.setVisible( false ); // invisible à la création
	}

	/**
	*
	*/
	private void creerInterface() {
		labelOrdre = new JLabel( "Veillez choisir un nouveau contact dans la liste" ) ;
		labelNom = new JLabel( "Nom" ) ;
		labelPrenom = new JLabel( "Prenom" ) ;
		labelNumero = new JLabel( "Numéro de téléphone" ) ;
		txtNom = new JTextField() ;
		txtPrenom = new JTextField() ;
		txtNumero = new JTextField() ;
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
		bas.add( buttonAnnuler ) ;
		bas.add( buttonConfirmer ) ;
		// panneau central
		JPanel main = new JPanel() ;
		main.setLayout( new GridLayout( 9 , 1 ) ) ;
		main.add( labelOrdre ) ;
		main.add( liste ) ;
		main.add( labelNom ) ;
		main.add( txtNom ) ;
		main.add( labelPrenom ) ;
		main.add( txtPrenom ) ;
		main.add( labelNumero ) ;
		main.add( txtNumero ) ;
		main.add( bas ) ;
		this.add( main ) ;
	}

	/**
	*
	*/
	private void attacherReactions() {

	}
}
