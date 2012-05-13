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
*
*/
public class Annuaire implements java.io.Serializable {

	/**
	*
	*/
	private Hashtable<String , Fiche> tabFiches ;

	/**
	*
	*/
	public Annuaire() {
		tabFiches = new Hashtable<String , Fiche>() ;
	}

	/**
	*
	*/
	public void ajouter( String cle , Fiche personne ) throws IllegalArgumentException , Exception {
		if ( cle == null || personne == null || cle.isEmpty() ) { throw new IllegalArgumentException( "Un des paramètres n'est pas valide." ) ; }
		else if ( tabFiches.containsKey( cle ) ) { throw new Exception( "Clé déjà existante dans la Hashtable." ) ; }
		tabFiches.put( cle , personne ) ;
	}

	/**
	*
	*/
	public void supprimer( String cle ) throws IllegalArgumentException , Exception {
		if ( cle == null || cle.isEmpty() ) { throw new IllegalArgumentException( "Le paramètre n'est pas valide." ) ; }
		else if ( ! tabFiches.containsKey( cle ) ) { throw new Exception( "Clé non existante dans la Hashtable." ) ; }
		tabFiches.remove( cle ) ;
	}

	/**
	*
	*/
	public void modifier( String cle , Fiche personne ) {
		tabFiches.remove( cle ) ;
		tabFiches.put( cle , personne ) ;
	}

	/**
	*
	*/
	public Enumeration<String> cles() { return ( tabFiches.keys() ) ; }

	/**
	*
	*/
	public int taille() { return ( tabFiches.size() ) ; }

	/**
	*
	*/
	public boolean existe( String cle ) { return ( tabFiches.containsKey( cle ) ) ; }

	/**
	*
	*/
	public Fiche consulter( String cle ) throws IllegalArgumentException {
		if ( cle == null || cle.isEmpty() ) { throw new IllegalArgumentException( "Le paramètre n'est pas valide." ) ; }
		return ( tabFiches.get( cle ) ) ;
	}

	/**
	*
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
	*
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
