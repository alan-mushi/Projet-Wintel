package datas ;

import java.util.Enumeration ;

/**
* Teste toutes les méthodes de la classe Annuaire.<br />
* Un ensemble de tests basés sur des erreurs ou valides sont réalisés.
*/
public class TestAnnuaire {
	public static void main( String[] args ) {
		/* Création de Fiches */
		Fiche f1 = null ;
		Fiche f2 = null ;
		Fiche f3 = null ;
		Fiche f4 = null ;
		Fiche f5 = null ;

		try {
			f1 = new Fiche( "nom1" , "prenom1" , "tel1" ) ;
			f2 = new Fiche( "nom2" , "prenom2" , "tel2" ) ;
			f3 = new Fiche( "nom3" , "prenom3" , "tel3" ) ;
			f4 = new Fiche( "nom4" , "prenom4" , "tel4" ) ;
			f5 = new Fiche( "nom5" , "prenom5" , "tel5" ) ;
		}
		catch ( IllegalArgumentException e ) { System.out.println( e.getMessage() ) ; }


		/* Création et init de l'annuaire */
		Annuaire annu = new Annuaire() ;
		try {
			annu.ajouter( "1" , f1 ) ;
			annu.ajouter( "2" , f2 ) ;
			annu.ajouter( "3" , f3 ) ;
			annu.ajouter( "4" , f4 ) ;
			annu.ajouter( "5" , f5 ) ;
		}
		catch ( Exception e ) { System.out.println( e.getMessage() ) ; }

		/* Test de la taille */
		int tannu = annu.taille() ;
		if ( tannu != 5 ) { System.out.println( "[-] Taille de la Hashtable INVALIDE suite à l'initialisation." ) ; }
		else { System.out.println( "\n[+] Taille de la Hashtable VALIDE suite à l'initialisation." ) ; }

		/* Test suppression d'une fiche */
		try {
			annu.supprimer( "3" ) ;
			tannu = annu.taille() ;
			if ( tannu != 4 ) { System.out.println( "[-] Taille de la Hashtable INVALIDE suite à la suppression." ) ; }
			else { System.out.println( "\n[+] Taille de la Hashtable VALIDE suite à la suppression." ) ; }
		}
		catch ( IllegalArgumentException e ) { System.out.println( e.getMessage() ) ; }
		catch ( Exception e ) { System.out.println( e.getMessage() ) ; }

		/* Test modification d'une fiche, énumération et existe des clés de la Hashtable */
		try {
			Fiche f6 = new Fiche( "nom6" , "prenom6" , "tel6" ) ;
			annu.modifier( "4" , f6 ) ;
			Enumeration enu = annu.cles() ;
			System.out.println( "\n[+] clés de la Hashtable :\n---------------------" ) ;
			while( enu.hasMoreElements() ) { System.out.println( enu.nextElement() ); }
			System.out.println( "---------------------" ) ;

			boolean tmpExist = annu.existe( "3" ) ;
			if ( tmpExist ) { System.out.println( "[-] Test existe() - base invalide ... ERREUR" ) ; }
			else { System.out.println( "\n[+] Test existe() - base invalide ... OK" ) ; }

			tmpExist = annu.existe( "4" ) ;
			if ( tmpExist ) { 
				System.out.println( "\n[+] Test existe() - base valide ... OK" ) ;
				Fiche tmpConsulte = annu.consulter( "4" ) ;
				System.out.println( "Fiche correspondant à la clé \'4\' :\n" + tmpConsulte.toString() ) ;
			}
			else { System.out.println( "[-] Test existe() - base valide ... ERREUR" ) ; }

		}
		catch ( IllegalArgumentException e ) { System.out.println( e.getMessage() + " QUITTE." ) ; }
		catch ( Exception e ) { System.out.println( e.getMessage() + " QUITTE." ) ; }

		/* Test Sauvegarde */
		annu.sauver() ;
		java.io.File saveFile = new java.io.File( "annuaire.out" ) ;
		if ( saveFile.exists() ) { System.out.println( "\n[+] Fichier \'annuaire.out\' crée, sauvegarde réussie ... OK " ) ; }
		else { System.out.println( "[-] Test sauver() - base valide ... ERREUR" ) ; }

		/* Cleaning up ... */
		annu = null ;
		saveFile = null ;
		f1 = null ;
		f2 = null ;
		f3 = null ;
		f4 = null ;
		f5 = null ;
		System.out.println( "\n[*] Toutes les variables anisi que l'objet Annuaire courant ont été mises à null.\n" ) ;

		/* Test charger */
		annu = Annuaire.charger() ;
		if ( annu.taille() != tannu ) { System.out.println( "[-] La taille de la Hashtable ne correspond pas à l'objet enregistré !" ) ; }
		else { System.out.println( "[+] taille() de la Hashtable chargé identique à la taille enregistrée ... OK" ) ; }
	}
}
