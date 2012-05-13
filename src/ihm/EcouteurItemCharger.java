package ihm;

import javax.swing.*;
import java.awt.event.*;

/**
 *
 */
class EcouteurItemCharger implements ActionListener {
	/**
	 *
	 */
	private Wintel theWintel;

	/**
	 *
	 */
	public EcouteurItemCharger(Wintel unWintel) {
		this.theWintel = unWintel;
	}

	/**
	 *
	 */
	public void actionPerformed(ActionEvent e) {
		theWintel.chargerEtAfficherAnnuaire();
	}
}
