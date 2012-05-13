package datas;

import java.util.Hashtable;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.IOException; 

public class TableFiches {

	/**
	 *
	 */
	public static Hashtable<String, Fiche> lireTableFiches() {
		FileInputStream fichier = null;
		ObjectInputStream in = null;
		Object resultat = null;
		Fiche uneFiche = null;
		Hashtable<String, Fiche> contenu = null;
		try {
			fichier = new FileInputStream("table.bin");
			in = new ObjectInputStream(fichier);
			contenu = new Hashtable<String, Fiche>();
			/*
			* Cette boucle sert à lire TOUS les éléments de 'table.bin'
			* La boucle do-while est utilisée car elle est effectuée au
			* moins une fois.
			*/
			do {
				resultat = in.readObject();
				if(resultat instanceof Fiche) {
					uneFiche = (Fiche) resultat;
					contenu.put(uneFiche.getNom(), uneFiche);
				}
				else { System.out.println("Impossible de lire l'objet contenu dans le fichier."); }
			} while ( resultat != null ) ;
		}
		catch ( FileNotFoundException e ) {
			System.out.println( e.getMessage() ) ;
			/*
			* Ouvrir une fenêtre contenant le mm txt.
			*/
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
		catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		finally {
			try {
				in.close();
				fichier.close();
			}
			catch(IOException e) {
				System.out.println(e.getMessage());
			}
		}

		return contenu;
	}
}
