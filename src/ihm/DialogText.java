package ihm ;

import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;

/**
*
*/
public class DialogText extends JDialog implements ActionListener {
	
	// attributs graphiques
	private JTextArea txtA ;
	private JButton bFermer ;
	private JPanel panG, panM, panD ;

	//a= attributs privés
	private String texte ;
	private Wintel win ;

	public DialogText( Wintel tmpWin ) {
		this.win = tmpWin ;

		this.texte = "Hello.\n Ce message est l'aide.\n Ça ne vous a pas aidé ??\nlol" ;

		txtA = new JTextArea( this.texte ) ;
		txtA.setEditable( false ) ;
		bFermer = new JButton( "Fermer" ) ;
		bFermer.addActionListener( this ) ;
		panG = new JPanel() ;
		panD = new JPanel() ;
		panM = new JPanel() ;
		panM.add( bFermer ) ;

		this.setSize( 600 , 600 ) ;
		this.setLocationByPlatform( true ) ;
		this.setLayout( new BorderLayout() ) ;
		this.add( txtA , BorderLayout.CENTER ) ;
		this.add( panG , BorderLayout.WEST ) ;
		this.add( panD , BorderLayout.EAST ) ;
		this.add( panM , BorderLayout.SOUTH ) ;
		this.setVisible( false ) ;
	}

	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource() ;
		if ( src == win.getItemAide() ) {
			this.setVisible( true ) ;
		}
		else if ( src == this.bFermer ) {
			this.setVisible( false ) ;
		}
	}
}
