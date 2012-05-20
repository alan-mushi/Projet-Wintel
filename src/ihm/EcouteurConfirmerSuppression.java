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
		this.fenetreSupprimer.getParent().rmAbonne() ;
		fenetreSupprimer.setVisible(false);
	}
}
