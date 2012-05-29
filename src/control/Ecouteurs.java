package control ;

import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;
import datas.* ;
import ihm.* ;

/**
* Classe gérant les évènements de l'application celon le modèle MVC.
*/
public class Ecouteurs extends MouseAdapter implements ActionListener {

	/** Référence locale de Wintel. */
	private Wintel win ;

	/**
	 * Le constructeur prend en paramètre un objet de type Wintel.
	 * @param theWin Objet Wintel.
	 */
	public Ecouteurs( Wintel theWin ) {
		this.win = theWin ;
	}

	/**
	 * Méthode de réaction au clic souris sur un élément de la JList.
	 */
	public void mouseClicked ( MouseEvent e ) {
		String cle;
		// Accès à la JList
		JList maListe = this.win.getListeGche();
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
			Annuaire monA = this.win.getAnnuaire();
			// getAnnuaire accesseur de Wintel
			Fiche laFiche = monA.consulter(cle);
			// Affichage des informations de la fiche dans les 3 champs textuels
			// de droite
			JTextField nom = this.win.getFieldNom();
			// accesseur de Wintel
			nom.setText(laFiche.getNom());
			JTextField prenom = this.win.getFieldPrenom();
			// accesseur de Wintel
			prenom.setText(laFiche.getPrenom());
			JTextField num = this.win.getFieldNumero();
			// accesseur de Wintel
			num.setText(laFiche.getTelephone());
			// accesseur de Wintel
			JTextField adresse = this.win.getFieldAdresse();
			adresse.setText(laFiche.getAdresse());
		}
	}

	/**
	 * Méthode de réaction aux évènements pour Wintel et ses fenêtres satellites.
	 */
	public void actionPerformed( ActionEvent e ) {
		Object src = e.getSource() ;
		/*
		 * Action pour l'item 'sauver' du menu 'Fichier'.
		 */
		if ( src == this.win.getItemSauver() ) {
			this.win.getAnnuaire().sauver() ;
		}
		/*
		 * Action pour l'item 'charger' du menu 'Fichier'.
		 */
		else if ( src == this.win.getItemCharger() ) {
			this.win.chargerEtAfficherAnnuaire() ;
		}
		/*
		 * Action pour le bouton 'confirmer' de la fenêtre WtDialogSupprimer.
		 */
		else if ( src == this.win.getWtDialogSupprimer().getJButtonConfirmer() ) {
			this.win.rmAbonne() ;
			this.win.getWtDialogSupprimer().setVisible( false ) ;
		}
		/*
		 * Action du bouton 'confirmer' de la fenêtre WtDialogModifier.
		 */
		else if ( src == this.win.getWtDialogModifier().getBoutonConfirmer() ) {
			try {
				String[] tab = this.win.getWtDialogModifier().getJTextField() ;
				Fiche tmpFiche = new Fiche(tab[0], tab[1], tab[2], tab[3]);

				/* Si la supression s'est déroulée sans encombres on ajoute la personne. */
				if ( this.win.rmAbonne() ) {
					this.win.ajouterAbonne(tab[0], tab[1], tab[2], tab[3]) ;
					this.win.getWtDialogModifier().setVisible( false ) ;
				}
				else { 
					JOptionPane.showMessageDialog( this.win.getWtDialogModifier(), "L'abonné n'a pas pu être supprimé.", "Erreur" , JOptionPane.ERROR_MESSAGE ) ;
				}
			}
			catch ( IllegalArgumentException err ) {
				JOptionPane.showMessageDialog( this.win.getWtDialogModifier(), err.getMessage() , "Erreur" , JOptionPane.WARNING_MESSAGE );
			}
			catch ( Exception err ) { 
				JOptionPane.showMessageDialog( this.win.getWtDialogModifier(), err.getMessage() , "Erreur" , JOptionPane.WARNING_MESSAGE );
			}
		}
		/*
		 * Action du bouton 'confirmer' de la fenêtre WtDialogAjouter.
		 */
		else if ( src == this.win.getWtDialogAjouter().getBoutonConfirmer() ) {
			String[] tab = this.win.getWtDialogAjouter().getJTextField() ;
			if ( this.win.ajouterAbonne(tab[0], tab[1], tab[2], tab[3])) {
				this.win.getWtDialogAjouter().setVisible( false ) ;
			}
		}
	}
}

