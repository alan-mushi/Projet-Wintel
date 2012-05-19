package datas ;

import java.util.Hashtable ;

/**
 * Cette classe teste l'unique méthode de la classe TableFiche.
 */
public class TestTableFiches {

	public static void main( String[] args ) {

		// Extraction de la Hashtable depuis le fichier 'table.bin'
		Hashtable<String, Fiche> htable = TableFiches.lireTableFiches() ;

		if ( htable != null ) {
			// Aperçu du contenu en intégrité.
			System.out.println( htable.toString() );

			System.out.println( "\n\n===========================================================================" ) ;
			System.out.println( "\tCette méthode doit être lancée une deuxième fois\n\tdans un répertoire où le fichier 'table.bin' n'est pas présent." ) ;
			System.out.println( "===========================================================================\n" ) ;
		}
		else { System.out.println( "\n[+] Test sans le fichier 'table.bin' ... OK" ) ; }
	}
}
