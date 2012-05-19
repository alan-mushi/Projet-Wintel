package datas ;

/**
* Cette classe teste la classe Fiche.
*/
public class TestFiche {

	public static void main( String[] args ) {
		Fiche fiche ;
		System.out.println( "--------------------------------------------------------------" ) ;
		System.out.println( "	Test du constructeur\n" ) ;
		// Test Constructeur Fiche avec et sans erreurs.
		try {
			System.out.print( "[*] Test basé sur une chaine de caractères nulle ... " ) ;
			fiche = new Fiche( null , "prenom" , "tel" ) ;
			System.out.println( "ÉCHOUÉ !") ;
		}
		catch ( IllegalArgumentException e ) {
			System.out.println( "RÉUSSI !" ) ;
		}
		try {
			System.out.print( "[*] Test basé sur une chaine de caractères vide ... " ) ;
			fiche = new Fiche( "" , "prenom" , "tel" ) ;
			System.out.println( "ÉCHOUÉ !") ;
		}
		catch ( IllegalArgumentException e ) {
			System.out.println( "RÉUSSI !" ) ;
		}
		try {
			System.out.print( "[*] Test basé sans erreurs ... " ) ;
			fiche = new Fiche( "nom" , "prenom" , "tel" ) ;
			System.out.println( "RÉUSSI !" ) ;
			System.out.println( "--------------------------------------------------------------" ) ;

			// Tests sur les getteurs.
			System.out.println( "	Test des getteurs\n" ) ;

			System.out.print( "[*] Test de getNom() ... " ) ;
			String tmp = fiche.getNom() ;
			if ( tmp.equals( "nom" ) ) { System.out.println( "RÉUSSI !" ) ; }
			else { System.out.println( "ÉCHOUÉ !") ; }

			System.out.print( "[*] Test de getPrenom() ... " ) ;
			tmp = fiche.getPrenom() ;
			if ( tmp.equals( "prenom" ) ) { System.out.println( "RÉUSSI !" ) ; }
			else { System.out.println( "ÉCHOUÉ !") ; }

			System.out.print( "[*] Test de getTelephone() ... " ) ;
			tmp = fiche.getTelephone() ;
			if ( tmp.equals( "tel" ) ) { System.out.println( "RÉUSSI !" ) ; }
			else { System.out.println( "ÉCHOUÉ !") ; }

			// Test sur toString().
			System.out.println( "[*] Test de toString() :\n" + fiche.toString() ) ;
			System.out.println( "\n--------------------------------------------------------------" ) ;
		}

		catch ( IllegalArgumentException e ) {
			// Nouvelle instance de Fiche sans erreurs dans les paramètres.
			System.out.println( "ÉCHOUÉ !") ;
		}
	}
}
