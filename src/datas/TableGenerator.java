package datas ;

import java.io.FileNotFoundException ;
import java.io.FileOutputStream ;
import java.io.ObjectOutputStream ;
import java.io.IOException ;

/**
 * Génère le fichier table.bin pour correspondre au nouveau format
 * des Fiches (Avec le champ d'adresse).
 */
public class TableGenerator {
	public static void main( String[] args ) {

		/* Création et init de l'annuaire */
		try {
			FileOutputStream out = new FileOutputStream( "table.bin" ) ;
			ObjectOutputStream flux = new ObjectOutputStream( out ) ;
			Fiche f1 = new Fiche( "Baudont" , "Pascal" , "02.97.55.73.98" , "Non renseignée." ) ; 
			Fiche f2 = new Fiche( "Roirand" , "Xavier" , "02.97.25.25.88" , "Non renseignée." ) ; 
			Fiche f3 = new Fiche( "Adam" , "Michel" , "06.33.22.55.41" , "Non renseignée." ) ; 
			Fiche f4 = new Fiche( "Morice" , "François" , "06.56.44.12.98" , "Non renseignée." ) ; 
			Fiche f5 = new Fiche( "Lefèvre" , "Sébastien" , "06.08.96.33.85" , "Non renseignée." ) ; 
			Fiche f6 = new Fiche( "Mannevy" , "Murielle" , "02.97.60.25.12" , "Non renseignée." ) ; 
			Fiche f7 = new Fiche( "Fleurquin" , "Régis" , "02.97.88.00.12" , "Non renseignée." ) ; 
			Fiche f8 = new Fiche( "Le Saux" , "Yane" , "09.52.47.33.88" , "Non renseignée." ) ; 
			Fiche f9 = new Fiche( "Portejoie" , "Philippe" , "02.97.55.33.14" , "Non renseignée." ) ; 
			Fiche f10 = new Fiche( "Bogdaniuk" , "Didier" , "06.25.88.74.32" , "Non renseignée." ) ; 
			Fiche f11 = new Fiche( "Gherbi" , "Tahar" , "02.97.12.82.90" , "Non renseignée." ) ; 
			Fiche f12 = new Fiche( "Merciol" , "François" , "09.55.37.73.11" , "Non renseignée." ) ; 
			Fiche f13 = new Fiche( "Kamp" , "Jean-François" , "02.97.15.64.32" , "Non renseignée." ) ; 
			Fiche f14 = new Fiche( "Joucla" , "Philippe" , "06.66.89.98.99" , "Non renseignée." ) ; 
			Fiche f15 = new Fiche( "Miton" , "Florence" , "06.33.85.57.61" , "Non renseignée." ) ; 
			Fiche f16 = new Fiche( "Théou" , "François" , "02.97.85.69.54" , "Non renseignée." ) ; 
			Fiche f17 = new Fiche( "Pouit" , "François" , "06.55.24.73.94" , "Non renseignée.") ;
			
			flux.writeObject( f1 ) ;
			flux.writeObject( f2 ) ;
			flux.writeObject( f3 ) ;
			flux.writeObject( f4 ) ;
			flux.writeObject( f5 ) ;
			flux.writeObject( f6 ) ;
			flux.writeObject( f7 ) ;
			flux.writeObject( f8 ) ;
			flux.writeObject( f9 ) ;
			flux.writeObject( f10 ) ;
			flux.writeObject( f11 ) ;
			flux.writeObject( f12 ) ;
			flux.writeObject( f13 ) ;
			flux.writeObject( f14 ) ;
			flux.writeObject( f15 ) ;
			flux.writeObject( f16 ) ;
			flux.writeObject( f17 ) ;
			
			flux.close() ;
			out.close() ;
		}
		catch ( IllegalArgumentException e ) { System.out.println( e.getMessage() ) ; }
		catch ( FileNotFoundException e ) { System.out.println( e.getMessage() ) ; }
		catch ( IOException e ) { System.out.println( e.getMessage() ) ; }
		catch ( Exception e ) { System.out.println( e.getMessage() ) ; }
	}
}
