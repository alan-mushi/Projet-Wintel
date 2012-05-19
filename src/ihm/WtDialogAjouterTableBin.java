package ihm ;

import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;

/**
 * Cette classe est appelée quand le fichier 'table.bin'
 * n'est pas présent dans le répertoire.<br />
 * Une fenêtre d'erreur s'affiche au dessus de la fenêtre principale de Wintel.
 */
public class WtDialogAjouterTableBin extends JDialog implements ActionListener {

	/** Attribut graphique. */
	private JLabel txtError1, txtError2 ;
	/** Attribut graphique. */
	private JButton retour ;

	/**
	 * Le constructeur se charge de disposer les éléments graphiques et
	 * de lier l'action au bouton.
	 */
	public WtDialogAjouterTableBin() {
		txtError1 = new JLabel( "Le fichier 'table.bin' n'est pas présent dans votre répertoire." ,  SwingConstants.CENTER ) ;
		txtError2 = new JLabel( "Veuillez l'ajouter." ,  SwingConstants.CENTER ) ;
		txtError1.setForeground( Color.blue ) ;
		txtError2.setForeground( Color.blue ) ;
		retour = new JButton( "Retour" ) ;
		this.setSize( 500 , 200 ) ;
		this.setLayout( new GridLayout( 3 , 1 , 10 , 10 ) ) ;
		this.add( txtError1 ) ;
		this.add( txtError2 ) ;
		this.add( retour ) ;
		this.setLocationByPlatform( true ) ;
		this.setVisible( true ) ;	// La fenêtre est visible par défaut car c'est un message d'erreur.
		retour.addActionListener( this ) ;
		this.setAlwaysOnTop( true ) ;	// Permet de disposer la fenêtre d'erreur au dessus des autres fenêtres.
	}

	/**
	 * Gère le clic sur le bouton pour fermer cette fenêtre.
	 */
	public void actionPerformed(ActionEvent e) {
		this.setVisible( false ) ;
	}
}
