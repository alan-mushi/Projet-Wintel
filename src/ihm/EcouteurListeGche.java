package ihm ;

import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;
import datas.* ;

class EcouteurListeGche extends MouseAdapter {

	/**
	 * La référence sur Wintel
	 */
	private Wintel theWin;

	/**
	 * Constructeur : lui donner la référence sur Wintel
	 * sinon l’accès aux méthodes de Wintel est impossible.
	 */
	public EcouteurListeGche ( Wintel monWin ) {
		this.theWin = monWin;
	}

	/**
	 * Méthode de REACTION au clic souris sur un élément de la JList
	 */
	public void mouseClicked ( MouseEvent e ) {
		String cle;
		// Accès à la JList
		JList maListe = theWin.getListeGche();
		// getListeGche accesseur de Wintel
		// Récupération de l’endroit (index) où l’utilisateur a cliqué
		int index = maListe.locationToIndex(e.getPoint());
		// Récupération du tableau qui mémorise les éléments de la JList
		DefaultListModel tab = (DefaultListModel)( maListe.getModel());

		/* 
		 * Ce test permet de ne pas afficher d'exceptions si l'utilisateur 
		 * clique à coté d'un item.
		 */
		if ( index >= 0 && index <= tab.capacity() )  {
			// L’index correspond précisément à la case du tableau contenant la donnée
			// sélectionnée par l’utilisateur avec la souris
			cle = (String)tab.get(index);
			// La clé (nom de la personne) permet de récupérer la fiche de la personne
			// dans l’annuaire
			Annuaire monA = theWin.getAnnuaire();
			// getAnnuaire accesseur de Wintel
			Fiche laFiche = monA.consulter(cle);
			// Affichage des informations de la fiche dans les 3 champs textuels
			// de droite
			JTextField nom = theWin.getFieldNom();
			// accesseur de Wintel
			nom.setText(laFiche.getNom());
			JTextField prenom = theWin.getFieldPrenom();
			// accesseur de Wintel
			prenom.setText(laFiche.getPrenom());
			JTextField num = theWin.getFieldNumero();
			// accesseur de Wintel
			num.setText(laFiche.getTelephone());
		}
	}
}

