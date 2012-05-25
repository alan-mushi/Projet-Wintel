package datas;

public class TestFicheAdresse {
	public static void main(String[] args) {
		Fiche fiche = null;
		System.out.println( "--------------------------------------------------------------");
		System.out.println( "	Test du constructeur\n" ) ;
		try {
			System.out.print("[*] Test basé sur une chaine de caractères nulle ... ");
			fiche = new Fiche("nom" , "prenom" , "tel", null);
			System.out.println("ÉCHOUÉ !");
		}
		catch (IllegalArgumentException e) {
			System.out.println("RÉUSSI !");
		}
		try {
			System.out.print("[*] Test basé sur une chaine de caractères vide ... ");
			fiche = new Fiche("Nom", "prenom", "tel", "");
			System.out.println("ÉCHOUÉ !");
		}
		catch ( IllegalArgumentException e ) {
			System.out.println("RÉUSSI !");
		}
		
		try {
			System.out.print( "[*] Test basé sans erreurs ... " ) ;
			fiche = new Fiche("nom" , "prenom" , "tel", "adresse");
			System.out.println( "RÉUSSI !" ) ;
			System.out.println( "--------------------------------------------------------------" ) ;

			// Tests sur les getteurs.
			System.out.println( "	Test des getteurs\n" ) ;

			System.out.print( "[*] Test de getAdresse() ... " ) ;
			String tmp = fiche.getAdresse() ;
			if (tmp.equals("adresse")) { System.out.println( "RÉUSSI !" ); }
			else { System.out.println("ÉCHOUÉ !"); }

			// Test sur toString().
			System.out.println("[*] Test de toString() :\n" + fiche.toString());
			System.out.println("\n--------------------------------------------------------------");
		}

		catch ( IllegalArgumentException e ) {
			// Nouvelle instance de Fiche sans erreurs dans les paramètres.
			System.out.println( "ÉCHOUÉ !") ;
		}
	}
}
