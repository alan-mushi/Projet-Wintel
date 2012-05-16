package ihm ;

import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;

/**
 *
 */
public class WtDialogAjouterTableBin extends JDialog implements ActionListener {

	// attributs graphiques
	private JLabel txtError1, txtError2 ;
	private JButton retour ;

	/**
	 *
	 */
	public WtDialogAjouterTableBin() {
		txtError1 = new JLabel( "Le fichier 'table.bin' n'est pas présent dans votre répertoire." ,  SwingConstants.CENTER ) ;
		txtError2 = new JLabel( "Veuillez l'ajouter." ,  SwingConstants.CENTER ) ;
		txtError1.setForeground( Color.blue ) ;
		txtError2.setForeground( Color.blue ) ;
		retour = new JButton( "Retour" ) ;
		this.setSize( 500 , 200 ) ;
		this.setLayout( new GridLayout( 3 , 1 ) ) ;
		this.add( txtError1 ) ;
		this.add( txtError2 ) ;
		this.add( retour ) ;
		this.setLocationByPlatform( true ) ;
		this.setVisible( true ) ;
		retour.addActionListener( this ) ;
		this.setAlwaysOnTop( true ) ;
	}

	/**
	 *
	 */
	public void actionPerformed(ActionEvent e) {
		this.setVisible( false ) ;
	}
}
