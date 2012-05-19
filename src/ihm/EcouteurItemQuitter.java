package ihm;

import javax.swing.*;
import java.awt.event.*;

/**
 *
 */
class EcouteurItemQuitter implements ActionListener {
	/**
	 *
	 */
	private Wintel theWintel;

	/**
	 *
	 */
	public EcouteurItemQuitter(Wintel unWintel) {
		this.theWintel = unWintel;
	}

	/**
	 *
	 */
	public void actionPerformed(ActionEvent e) {
		theWintel.dispose(); 
	}
}
