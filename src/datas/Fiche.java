package datas ;

/**
 * Cette classe gère une somme d'informations sur une personne à savoir
 * son nom, prenom et numéro de téléphone.
 */
public class Fiche implements java.io.Serializable {

	/** Attributs d'une Fiche. */
	private String nom , prenom , telephone ;

	/**
	 * Ce constructeur gère différents cas de non validité
	 * des arguments sui lui sont passé en paramètre.
	 * @param leNom Nom à affecter à la Fiche.
	 * @param lePrenom Prenom à affecter à la Fiche.
	 * @param leTel Numéro de téléphone à affecter à la Fiche, le fait que le numéro
	 * ne soit pas composé de chiffres n'est pas vérifié ici.
	 * @throws IllegalArgumentException Un des paramètres n'est pas valide, le message d'exception
	 * contient le paramètre fautif.
	 */
	public Fiche( String leNom , String lePrenom , String leTel ) throws IllegalArgumentException {
		if ( leNom == null || leNom.isEmpty() ) { throw new IllegalArgumentException( "Le Nom n'est pas valide ") ; }
		else if ( lePrenom == null || lePrenom.isEmpty() ) { throw new IllegalArgumentException( "Le Prenom n'est pas valide ") ; }
		else if ( leTel == null || leTel.isEmpty() ) { throw new IllegalArgumentException( "Le Tel n'est pas valide ") ; }
		this.nom = leNom ;
		this.prenom = lePrenom ;
		this.telephone = leTel ;
	}

	/**
	 * Accesseur pour le nom.
	 * @return Le nom de la Fiche.
	 */
	public String getNom() { return ( this.nom ) ; }

	/**
	 * Accesseur pour le prenom.
	 * @return Le prenom de la Fiche.
	 */
	public String getPrenom() { return ( this.prenom ) ; }

	/**
	 * Accesseur pour le numéro de téléphone.
	 * @return Le numéro de la Fiche.
	 */
	public String getTelephone() { return ( this.telephone ) ; }

	/**
	 * Toutes les informations sur la Fiche en une String.
	 * @return Les paramètres de la Fiche.
	 */
	public String toString() {
		String res = "---------------------\nNom : " + this.nom ;
		res += "\nPrenom : " + this.prenom ;
		res += "\nTelephone : " + this.telephone + "\n---------------------" ;
		return ( res ) ;
	}
}
