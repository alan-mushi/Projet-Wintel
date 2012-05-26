package ihm ;

import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;

/**
 * Cette classe affiche le menu d'aide de l'application Wintel.
 */
public class DialogText extends JDialog implements ActionListener {

	/** Attribut graphique. */
	private JTextArea txtA ;
	/** Attribut graphique. */
	private JButton bFermer ;
	/** Attribut graphique. */
	private JPanel panG, panM, panD , panH ;
	/** Attribut graphique. */
	private JScrollPane scroll ;

	/** Attribut utilisé localement. */
	private String texte ;
	/** Objet Wintel "privé". */
	private Wintel win ;

	/**
	 * Le constructeur initialise les éléments graphiques
	 * et lie l'action au bouton.
	 */
	public DialogText( Wintel tmpWin ) {
		super( tmpWin , "Aide de Wintel" , false ) ;
		this.win = tmpWin ;

		this.texte = "============================\n" +
			"Aide de l'application Wintel\n" + 
			"============================\n\n\tSommaire\n\n" +
			"0x01 - CGU, © et autres joyeusetés\n" +
			"0x02 - Fenêtre principale\n" +
			"0x03 - Menus\n" +
			"0x04 - Auteurs\n\n\n" +
			"0x01 - CGU, © et autres joyeusetés\n" +
			"----------------------------------\n" +
			"Il n'y a pas le licences ni de droits sur cette application pour la simple et bonne raison qu'il n'y en a pas besoin.\n" +
			"Nous ne nous attendons pas à ce que les professeurs utilisent cette magnifique application pour leurs contacts\n" +
			"Nous ne nous attendons pas non plus à une redistribution massive de ce projet Wintel.\n" +
			"\nPour générer correctement la documentation et les classes il faut se placer dans le répertoire datas/\n" +
			"La génération des classes s'effectue pas la commande : \njavac -d ../class ../src/ihm/* ../src/datas/*\n" +
			"La génération de la javadoc s'effectue avec la commande : \njavadoc -docencoding utf8 -private -d ../doc/ ../src/datas/* ../src/ihm/*\n\n\n" +
			"0x02 - Fenêtre principale\n" +
			"-------------------------\n\n" +
			"La fenêtre principale est constituée de trois zones : \n" +
			" * Les menus (détaillés dans le prochain paragraphe\n" +
			" * La liste des contacts\n" + 
			" * Les caractéristiques des contacts\n\n" +
			"Pour voir les caractéristiques des contacts chargés par défaut, cliquez sur le contact.\n" +
			"Les champs de caractéristiques ne sont pas modifiables, il faut passer par la fenêtre de modification.\n\n\n" +
			"0x03 - Menus\n" +
			"------------\n\n" +
			"Le menu est décomposé en trois parties :\n" +
			" * Fichier\n * Abonnés\n * Aide\n\n" +
			"Vous êtes en train d'admirer la fenêtre d'aie actuellement.\n" +
			"Le menu 'Fichier' vous permet de charger, sauvegarder des contacts et quitter l'application.\n" +
			"Le menu 'Abonné' vous offre la possibilité d'ajouter, modifier et supprimer un contact de l'application?.\n\n\n" +
			"0x04 - Auteurs\n" +
			"--------------\n\n" +
			"Guillaume CLAUDIC et Thibault GUITTET." ;

		txtA = new JTextArea( this.texte ) ;
		txtA.setEditable( false ) ;	// Empêche l'édition de l'aide.
		txtA.setFont( new Font( Font.MONOSPACED , Font.PLAIN , 13 ) ) ;
		JScrollPane scroll = new JScrollPane( txtA ) ;
		bFermer = new JButton( "Fermer" ) ;
		bFermer.addActionListener( this ) ;
		panG = new JPanel() ;	// Tous ces paneaux servent à remplir la fenêtre
		panM = new JPanel() ;	// pour obtenir une marge sur le contour.
		panD = new JPanel() ;
		panH = new JPanel() ;
		panM.add( bFermer ) ;

		this.setSize( 1000 , 600 ) ;
		this.setLocationByPlatform( true ) ;
		this.setLayout( new BorderLayout() ) ;
		this.add( scroll , BorderLayout.CENTER ) ;
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
	public void actionPerformed( ActionEvent e ) {
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
