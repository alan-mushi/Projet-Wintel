package ihm;

import javax.swing.*;
import java.awt.event.*;
import datas.*;

/**
 *
 */
class EcouteurConfirmerSuppression implements ActionListener {
	/**
	 *
	 */
	private WtDialogSupprimer fenetreSupprimer;

	/**
	 *
	 */
	public EcouteurConfirmerSuppression(WtDialogSupprimer parent) {
		this.fenetreSupprimer = parent;
	}

	/**
	 *
	 */
	public void actionPerformed(ActionEvent e) {
		Wintel windowMain = fenetreSupprimer.getParent();
		Annuaire monAnnuaire = windowMain.getAnnuaire();

		JList liste = windowMain.getListeGche();

		String valeur = null;
		try {
			if(liste.getSelectedValue() != null && !liste.getSelectedValue().toString().isEmpty()) {
				valeur = (String) liste.getSelectedValue();

				if(monAnnuaire.existe(valeur)) {
					try {
						monAnnuaire.supprimer(valeur);
						DefaultListModel recupListe = windowMain.getListe();
						recupListe.removeElement(valeur);
						// Retire la cle des champs de droite 
						// sur la fenêtre principale de Wintel.
						windowMain.clearFields() ;
					}
					catch(IllegalArgumentException erreur) {
						System.out.println(erreur.getMessage());
					}
					catch(Exception erreur) {
						System.out.println(erreur.getMessage());
					}
				}
			}
		}
		catch(Exception erreur) {
			System.out.println( erreur.getMessage() ) ;
		}
		fenetreSupprimer.setVisible(false);
	}
}
