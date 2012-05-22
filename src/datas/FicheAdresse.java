package datas;

public class FicheAdresse extends Fiche {
	private String adresse;
	
	public FicheAdresse(String leNom , String lePrenom , String leTel, String ladresse) {
		super(leNom, lePrenom, leTel);
		if(ladresse == null || ladresse.isEmpty()) {
			throw new IllegalArgumentException( "L'adresse n'est pas valide.");
		}
		this.adresse = ladresse;
	}
	
	public String getAdresse() {
		return this.adresse;
	}
	
	public String toString() {
		String resultat = "";
		resultat += super.toString();
		resultat += "Adresse : " + this.adresse + "\n";
		
		return resultat;
	}
}