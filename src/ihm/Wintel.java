package ihm ;

import javax.swing.* ;
import java.awt.* ;

public class Wintel extends JFrame {

	private Annuaire monAnnuaire ;

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
		
