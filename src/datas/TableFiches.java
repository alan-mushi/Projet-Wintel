package datas;

import java.util.Hashtable;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.IOException; 
import java.io.FileNotFoundException ;

/**
 * Cette classe possède une unique méthode qui extrait les
 * instances de Fiche depuis un fichier <code>table.bin</code>.
 */
public class TableFiches {

	/**
	 * Extrait les Fiches du fichier <code>table.bin</code>
	 * et les assemble dans une Hashtable.<br />
	 * <b>Toutes les exceptions sont affichées.</b>
	 * @return Key : Nom de la Fiche.<br />Value : instance de Fiche.
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
			in.close();
			fichier.close();
		}
		catch (FileNotFoundException e) {
			System.out.println( e.getMessage() ) ;
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
		catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}

		return contenu;
	}
}
