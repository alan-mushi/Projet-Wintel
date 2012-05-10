package ihm;

import javax.swing.*;
import java.awt.event.*;
import datas.*;
import java.util.Enumeration;

class EcouteurItemCharger implements ActionListener {
	private Wintel theWintel;
	
	public EcouteurItemCharger(Wintel unWintel) {
		this.theWintel = unWintel;
	}
	
	public void actionPerformed(ActionEvent e) {
		Annuaire unAnnuaire = Annuaire.charger();
		Enumeration cles = unAnnuaire.cles();
		while(cles.hasMoreElements()) {
			String nom = (String) cles.nextElement();
			Annuaire monAnnuaire = theWintel.getAnnuaire();
			try {
				String prenom = monAnnuaire.consulter(nom).getPrenom();
				String num = monAnnuaire.consulter(nom).getTelephone();
				theWintel.ajouterAbonne(nom, prenom, num);
			}
			catch(IllegalArgumentException erreur) {
				System.out.println(erreur.getMessage());
			}
		}
	}
}