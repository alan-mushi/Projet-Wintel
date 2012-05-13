package datas ;

import java.util.Hashtable ;

/**
* Plutôt sommaire XD
* A compléter...
*/
public class TestTableFiches {

	public static void main( String[] args ) {

		// Extraction de la Hashtable depuis le fichier 'table.bin'
		Hashtable<String, Fiche> htable = TableFiches.lireTableFiches() ;

		// Premier appercu du contenu
		System.out.println( htable.toString() );
	}
}
