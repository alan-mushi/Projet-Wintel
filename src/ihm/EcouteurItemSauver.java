package ihm;

import javax.swing.*;
import java.awt.event.*;

/**
 *
 */
class EcouteurItemSauver implements ActionListener {
	/**
	 *
	 */
	private Wintel theWintel;

	/**
	 *
	 */
	public EcouteurItemSauver(Wintel unWintel) {
		this.theWintel = unWintel;
	}

	/**
	 *
	 */
	public void actionPerformed(ActionEvent e) {
		this.theWintel.getAnnuaire().sauver();
	}
}
