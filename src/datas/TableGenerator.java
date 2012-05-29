package datas ;


/**
 * Génère le fichier table.bin pour correspondre au nouveau format
 * des Fiches (Avec le champ d'adresse). Il faut changer le nom du fichier
 * dans la classe Annuaire.
 */
public class TableGenerator {
	public static void main( String[] args ) {

		/* Création et init de l'annuaire */
		Annuaire annu = new Annuaire() ;
		try {
			annu.ajouter( "Baudont" , new Fiche( "Baudont" , "Pascal" , "02.97.55.73.98") ) ; 
			annu.ajouter( "Roirand" , new Fiche( "Roirand" , "Xavier" , "02.97.25.25.88") ) ; 
			annu.ajouter( "Adam" , new Fiche( "Adam" , "Michel" , "06.33.22.55.41") ) ; 
			annu.ajouter( "Morice" , new Fiche( "Morice" , "François" , "06.56.44.12.98") ) ; 
			annu.ajouter( "Lefèvre" , new Fiche( "Lefèvre" , "Sébastien" , "06.08.96.33.85") ) ; 
			annu.ajouter( "Mannevy" , new Fiche( "Mannevy" , "Murielle" , "02.97.60.25.12") ) ; 
			annu.ajouter( "Fleurquin" , new Fiche( "Fleurquin" , "Régis" , "02.97.88.00.12") ) ; 
			annu.ajouter( "Le Saux" , new Fiche( "Le Saux" , "Yane" , "09.52.47.33.88") ) ; 
			annu.ajouter( "Portejoie" , new Fiche( "Portejoie" , "Philippe" , "02.97.55.33.14") ) ; 
			annu.ajouter( "Bogdaniuk" , new Fiche( "Bogdaniuk" , "Didier" , "06.25.88.74.32") ) ; 
			annu.ajouter( "Gherbi" , new Fiche( "Gherbi" , "Tahar" , "02.97.12.82.90") ) ; 
			annu.ajouter( "Merciol" , new Fiche( "Merciol" , "François" , "09.55.37.73.11") ) ; 
			annu.ajouter( "Kamp" , new Fiche( "Kamp" , "Jean-François" , "02.97.15.64.32") ) ; 
			annu.ajouter( "Joucla" , new Fiche( "Joucla" , "Philippe" , "06.66.89.98.99") ) ; 
			annu.ajouter( "Miton" , new Fiche( "Miton" , "Florence" , "06.33.85.57.61") ) ; 
			annu.ajouter( "Théou" , new Fiche( "Théou" , "François" , "02.97.85.69.54") ) ; 
			annu.ajouter( "Pouit" , new Fiche( "Pouit" , "François" , "06.55.24.73.94") ) ;
			annu.sauver() ;
		}
		catch ( IllegalArgumentException e ) { System.out.println( e.getMessage() ) ; }
		catch ( Exception e ) { System.out.println( e.getMessage() ) ; }
	}
}
