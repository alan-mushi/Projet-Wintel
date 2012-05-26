package control ;

import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;
import datas.* ;
import ihm.* ;

public class Ecouteurs extends MouseAdapter implements ActionListener {

	private Wintel win ;

	public Ecouteurs( Wintel theWin ) {
		this.win = theWin ;
	}

	/**
	 * Méthode de réaction au clic souris sur un élément de la JList.
	 */
	public void mouseClicked ( MouseEvent e ) {
		String cle;
		// Accès à la JList
		JList maListe = win.getListeGche();
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
			Annuaire monA = win.getAnnuaire();
			// getAnnuaire accesseur de Wintel
			Fiche laFiche = monA.consulter(cle);
			// Affichage des informations de la fiche dans les 3 champs textuels
			// de droite
			JTextField nom = win.getFieldNom();
			// accesseur de Wintel
			nom.setText(laFiche.getNom());
			JTextField prenom = win.getFieldPrenom();
			// accesseur de Wintel
			prenom.setText(laFiche.getPrenom());
			JTextField num = win.getFieldNumero();
			// accesseur de Wintel
			num.setText(laFiche.getTelephone());
		}
	}

	/**
	 * Méthode de réaction aux évènements pour Wintel et ses fenêtres satellites.
	 */
	public void actionPerformed( ActionEvent e ) {
		Object src = e.getSource() ;
		if ( src == win.getItemSauver() ) {
			win.getAnnuaire().sauver() ;
		}
		else if ( src == win.getItemCharger() ) {
			win.chargerEtAfficherAnnuaire() ;
		}
		else if ( src == win.getWtDialogSupprimer().getJButtonConfirmer() ) {
			win.rmAbonne() ;
			win.getWtDialogSupprimer().setVisible( false ) ;
		}
		else if ( src == win.getWtDialogModifier().getBouttonConfirmer() ) {
			try {
				String[] tab = win.getWtDialogModifier().getJTextField() ;
				/* La ligne ci-dessous fonctionne avec le programme de base sans le champs adresse. */
				Fiche tmpFiche = new Fiche( tab[0] , tab[1] , tab[2] ) ;

				// FicheAdresse tmpFiche = new FicheAdresse(nom.getText(), prenom.getText(), num.getText(), adresse.getText());
				/* Si la supression s'est déroulée sans encombres on ajoute la personne. */
				if ( win.rmAbonne() ) {
					win.ajouterAbonne( tmpFiche ) ;
					win.getWtDialogModifier().setVisible( false ) ;
				}
				else { 
					JOptionPane.showMessageDialog( win.getWtDialogModifier(), "L'abonné n'a pas pu être supprimé.", "Erreur" , JOptionPane.ERROR_MESSAGE ) ;
				}
			}
			catch ( IllegalArgumentException err ) {
				JOptionPane.showMessageDialog( win.getWtDialogModifier(), err.getMessage() , "Erreur" , JOptionPane.WARNING_MESSAGE );
			}
			catch ( Exception err ) { 
				JOptionPane.showMessageDialog( win.getWtDialogModifier(), err.getMessage() , "Erreur" , JOptionPane.WARNING_MESSAGE );
			}
		}
	}
}

