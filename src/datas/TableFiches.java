package datas ;

import java.io.* ;
import java.util.Hashtable ;

public class TableFiches {

	/**
	 *
	 */
	public static Hashtable<String, Fiche> lireTableFiche()  {
		String file = "table.bin" ;
		FileInputStream in ;
		ObjectInputStream flux ;
		Hashtable<String, Fiches> res = new Hashtable<String, Fiches>() ;
		try {
		}
		catch ( ClassNotFoundException e ) { System.out.println( e.getMessage() ) ; }
		catch ( java.io.NotSerializableException e ) { System.out.println( e.getMessage() ) ; }
		catch ( FileNotFoundException e ) { System.out.println( e.getMessage() ) ; }
		catch ( IOException e ) { System.out.println( e.getMessage() ) ; }
		return ( res ) ;
	}
}
