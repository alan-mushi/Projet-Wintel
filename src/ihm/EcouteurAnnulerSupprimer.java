package ihm;

import javax.swing.*;
import java.awt.event.*;

/**
*
*/
class EcouteurAnnulerSupprimer implements ActionListener {
	/**
	*
	*/
	private WtDialogSupprimer fenetreSupprimer;
	
	/**
	*
	*/
	public EcouteurAnnulerSupprimer(WtDialogSupprimer parent) {
		this.fenetreSupprimer = parent;
	}
	
	/**
	*
	*/
	public void actionPerformed(ActionEvent e) {
		fenetreSupprimer.setVisible(false);
	}
}
