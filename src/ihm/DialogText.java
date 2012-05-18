package ihm ;

import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;

/**
 * Cette classe affiche le menu d'aide de l'application Wintel.
 */
public class DialogText extends JDialog implements ActionListener {

	/** Attributs graphiques. */
	private JTextArea txtA ;
	/** Attributs graphiques. */
	private JButton bFermer ;
	/** Attributs graphiques. */
	private JPanel panG, panM, panD , panH ;

	/** Attributs utilisés localement. */
	private String texte ;
	/** Objet Wintel "privé". */
	private Wintel win ;

	/**
	 * Le constructeur initialise les éléments graphiques
	 * et lie l'action au bouton.
	 */
	public DialogText( Wintel tmpWin ) {
		this.win = tmpWin ;

		this.texte = "Hello.\n Ce message est l'aide.\n Ça ne vous a pas aidé ??\nlol" ;

		txtA = new JTextArea( this.texte ) ;
		txtA.setEditable( false ) ;	// Empêche l'édition de l'aide.
		bFermer = new JButton( "Fermer" ) ;
		bFermer.addActionListener( this ) ;
		panG = new JPanel() ;	// Tous ces paneaux servent à remplir la fenêtre
		panM = new JPanel() ;	// pour obtenir une marge sur le contour.
		panD = new JPanel() ;
		panH = new JPanel() ;
		panM.add( bFermer ) ;

		this.setSize( 600 , 600 ) ;
		this.setLocationByPlatform( true ) ;
		this.setLayout( new BorderLayout() ) ;
		this.add( txtA , BorderLayout.CENTER ) ;
		this.add( panG , BorderLayout.WEST ) ;
		this.add( panD , BorderLayout.EAST ) ;
		this.add( panM , BorderLayout.SOUTH ) ;
		this.add( panH , BorderLayout.NORTH ) ;
		this.setVisible( false ) ;
	}

	/**
	 * L'action de fermeture de la fenêtre ainsi que son ouverture
	 * sont gérés ici. Pour distinguer l'ouverture et la fermeture
	 * on distingue la source de l'action.
	 * @param e Origine de l'action.
	 */
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource() ;
		// Origine : menu - aide de Wintel
		if ( src == win.getItemAide() ) {
			this.setVisible( true ) ;
		}
		// Origine : bouton
		else if ( src == this.bFermer ) {
			this.setVisible( false ) ;
		}
	}
}
