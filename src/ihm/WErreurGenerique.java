package ihm ;

import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;

/**
 * Cette classe permet de créer des fenêtres avec des messages à
 * la volée. On passe un texte au constructeur et une fenêtre
 * d'erreur s'affiche avec le texte voulu ainsi qu'un bouton
 * retour. Cette classe est née de la structure identique de
 * plusieures fenêtres d'erreurs.
 */
public class WErreurGenerique extends JDialog implements ActionListener {

	/** Attribut graphique. */
	private JPanel panG , panD , panM , panI ;
	/** Attribut graphique. */
	private JButton back ;
	/** Attribut graphique. */
	private JLabel msg ;

	/**
	 * Constructeur et coordinateur de la fenêtre d'erreur.
	 * @param erreur Texte d'erreur à afficher.
	 */
	public WErreurGenerique( String erreur ) {
		this.creeInterface( erreur ) ;
		back.addActionListener( this ) ;
	}

	/**
	 * Dispose les éléments graphiques sur la fenêtre.
	 * La fenêtre est visible par défaut.
	 * @param messageErreur Erreur à afficher.
	 */
	private void creeInterface( String messageErreur ) {
		back = new JButton( "Retour" ) ;
		msg = new JLabel( messageErreur ) ;
		msg.setHorizontalAlignment( SwingConstants.CENTER ) ;
		msg.setForeground( Color.blue ) ;

		this.setLayout( new GridLayout( 2 , 1 ) ) ;
		this.add( msg ) ;
		this.add( back ) ;

		this.setSize( 400 , 200 ) ;
		this.setVisible( true ) ;
	}

	/**
	 * Ferme la fenêtre.
	 */
	public void actionPerformed( ActionEvent e ) {
		this.setVisible( false ) ;
	}
}
