package datas;

import java.util.Hashtable;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.IOException; 

public class TableFiches {
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
			
			resultat = in.readObject();
			if(resultat instanceof Fiche) {
				uneFiche = (Fiche) resultat;
				contenu.put(uneFiche.getNom(), uneFiche);
			}
			else
				System.out.println("Impossible de lire l'objet contenu dans le fichier.");
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