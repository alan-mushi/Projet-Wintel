package datas ;

import java.util.Hashtable ;
import java.util.Enumeration ;
import java.util.NoSuchElementException ;
import java.io.FileInputStream ;
import java.io.FileOutputStream ;
import java.io.ObjectInputStream ;
import java.io.ObjectOutputStream ;
import java.io.IOException ;
import java.io.FileNotFoundException ;

/**
 * Cette classe sert d'annuaire pour la classe Fiche.
 * Elle regroupe dans une Hashtable de multiples Fiches.
 * @see datas.Fiche 
 */
public class Annuaire implements java.io.Serializable {

	/**
	 * Hashtable qui agrège les Fiches.
	 */
	private Hashtable<String , Fiche> tabFiches ;

	/**
	 * Le constructeur ne fait qu'initialiser la Hashtable.
	 */
	public Annuaire() {
		tabFiches = new Hashtable<String , Fiche>() ;
	}

	/**
	 * Ajoute une Fiche dans la Hashtable.
	 * On ne teste pas la validité intégrale des paramètres,
	 * juste si ils sont non <code>null</code>.
	 * @param cle Nom de la Fiche.
	 * @param personne Fiche à ajouter à l'annuaire.
	 * @throws IllegalArgumentException Un des paramètres n'est pas valide.
	 * @throws Exception La clé existe déjà dans la Hashtable.
	 */
	public void ajouter( String cle , Fiche personne ) throws IllegalArgumentException , Exception {
		if ( cle == null || personne == null || cle.isEmpty() ) { throw new IllegalArgumentException( "Un des paramètres n'est pas valide." ) ; }
		else if ( tabFiches.containsKey( cle ) ) { throw new Exception( "Clé déjà existante dans la Hashtable." ) ; }
		tabFiches.put( cle , personne ) ;
	}

	/**
	 * Supprime une Fiche de l'annuaire.
	 * @param cle Fiche associée à supprimer.
	 * @throws IllegalArgumentException La cle est <code>null</code> ou vide.
	 * @throws Exception La clé n'est pas présente dans la Hashtable.
	 */
	public void supprimer( String cle ) throws IllegalArgumentException , Exception {
		if ( cle == null || cle.isEmpty() ) { throw new IllegalArgumentException( "Le paramètre n'est pas valide." ) ; }
		else if ( ! tabFiches.containsKey( cle ) ) { throw new Exception( "Clé non existante dans la Hashtable." ) ; }
		tabFiches.remove( cle ) ;
	}

	/**
	 * Substitue une Fiche existante par une autre. La cle reste identique.<br />
	 * Aucune vérification d'intégrité n'est opérée sur les arguments.
	 * @param cle Existante à remplacer.
	 * @param personne Nouvelle Fiche qui vient remplacer l'ancienne.
	 */
	public void modifier( String cle , Fiche personne ) {
		tabFiches.remove( cle ) ;
		tabFiches.put( cle , personne ) ;
	}

	/**
	 * Retourne les clés présentes dans la Hashtable.
	 * @return Une liste des clés présentes dans la Hashtable.
	 */
	public Enumeration<String> cles() { return ( tabFiches.keys() ) ; }

	/**
	 * Retourne la taille de la Hashtable en int.
	 * @return Taille de la Hashtable.
	 */
	public int taille() { return ( tabFiches.size() ) ; }

	/**
	 * Détermine si la clé est présente dans la Hashtable.
	 * @return <code>true</code> si la clé est dans la Hashtable, <code>false</code> sinon.
	 */
	public boolean existe( String cle ) { return ( tabFiches.containsKey( cle ) ) ; }

	/**
	 * Cette méthode permet de consulter une Fiche présente dans la Hashtable.
	 * @param cle Cle correspondant à la Fiche voulue.
	 * @throws IllegalArgumentException La clé passée en argument n'est pas valide.
	 * @return Fiche correspondant à la clé, si la clé n'est pas présente dans la Hashtable
	 * la référence sur la Fiche sera <code>null</code>.
	 */
	public Fiche consulter( String cle ) throws IllegalArgumentException {
		if ( cle == null || cle.isEmpty() ) { throw new IllegalArgumentException( "Le paramètre n'est pas valide." ) ; }
		return ( tabFiches.get( cle ) ) ;
	}

	/**
	 * Restaure l'annuaire depuis le fichier <code>annuaire.out</code>.
	 * Ce fichier doit se trouver dans le répertoire d'exécution.<br />
	 * Aucune exception n'est lancée, tous les messages d'erreurs sont
	 * affichés.
	 */
	public static Annuaire charger() {
		FileInputStream in ;
		ObjectInputStream flux ;
		Annuaire res = null ;
		try {
			in = new FileInputStream( "annuaire.out" ) ;
			flux = new ObjectInputStream( in ) ;
			res = (Annuaire) flux.readObject() ;
			flux.close() ;
			in.close() ;
		}
		catch ( ClassNotFoundException e ) { System.out.println( e.getMessage() ) ; }
		catch ( java.io.NotSerializableException e ) { System.out.println( e.getMessage() ) ; }
		catch ( FileNotFoundException e ) { System.out.println( e.getMessage() ) ; }
		catch ( IOException e ) { System.out.println( e.getMessage() ) ; }
		return ( res ) ;
	}

	/**
	 * Permet d'enregistrer la Hashtable et les Fiches contenues dans 
	 * un fichier <code>annuaire.out</code>. Le fichier est enregistré
	 * dans le répertoire courant.<br />
	 * Aucune exception n'est lancée, tous les messages d'erreur sont
	 * affichés.
	 */
	public void sauver() {
		FileOutputStream out ;
		ObjectOutputStream flux ;
		try {
			out = new FileOutputStream( "annuaire.out" ) ;
			flux = new ObjectOutputStream( out ) ;
			flux.writeObject( this ) ;
			flux.close() ;
			out.close() ;
		}
		catch ( FileNotFoundException e ) { System.out.println( e.getMessage() ) ; }
		catch ( IOException e ) { System.out.println( e.getMessage() ) ; }
	}
}
