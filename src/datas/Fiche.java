package datas ;

public class Fiche implements java.io.Serializable {
	
	private String nom , prenom , telephone ;

	public Fiche( String leNom , String lePrenom , String leTel ) throws IllegalArgumentException {
		if ( leNom == null || leNom.isEmpty() ) { throw new IllegalArgumentException( "Le Nom n'est pas valide ") ; }
		if ( lePrenom == null || lePrenom.isEmpty() ) { throw new IllegalArgumentException( "Le Prenom n'est pas valide ") ; }
		if ( leTel == null || leTel.isEmpty() ) { throw new IllegalArgumentException( "Le Tel n'est pas valide ") ; }
		this.nom = leNom ;
		this.prenom = lePrenom ;
		this.telephone = leTel ;
	}

	public String getNom() { return ( this.nom ) ; }

	public String getPrenom() { return ( this.prenom ) ; }

	public String getTelephone() { return ( this.telephone ) ; }

	public String toString() {
		String res = "---------------------\nNom : " + this.nom ;
		res += "\nPrenom : " + this.prenom ;
		res += "\nTelephone : " + this.telephone + "\n---------------------" ;
		return ( res ) ;
	}
}
