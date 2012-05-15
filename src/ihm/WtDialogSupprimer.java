package ihm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import datas.*;

public class WtDialogSupprimer  extends JDialog implements ActionListener {
	private JLabel labelSupprimer;
	private JTextField aSupprimer;
	private JButton confirmer;
	private JButton annuler;
	private Wintel parent;
	
	public WtDialogSupprimer(Wintel parent) {
		super(parent, "Supprimer un contact", true); // appel constructeur JDialog
		this.parent = parent;
		this.creerInterface(); // mise en place du décor (voir Figure 5)
		this.attacherReactions(); // écouteurs sur les boutons et JComboBox
		this.setSize(300, 300);
		this.setVisible(false); // invisible à la création
	}
	
	public void creerInterface() {
		// Boutton en bas
		confirmer = new JButton("Confirmer");
		annuler = new JButton("Annuler");
		JPanel pannelBoutton = new JPanel(new GridLayout(1, 2));
		pannelBoutton.add(confirmer);
		pannelBoutton.add(annuler);
		
		// Panel principal
		labelSupprimer = new JLabel("Supprimer le contact ?");
		labelSupprimer.setHorizontalAlignment(SwingConstants.CENTER);
		labelSupprimer.setForeground(Color.blue);
		labelSupprimer.setFont(new Font(null, Font.PLAIN, 18));
		
		aSupprimer = new JTextField();
		aSupprimer.setForeground(Color.blue);
		aSupprimer.setFont(new Font(null, Font.PLAIN, 18));
		
		JPanel pannelPrincipal = new JPanel(new GridLayout(3, 1, 40, 40));
		pannelPrincipal.add(labelSupprimer);
		pannelPrincipal.add(aSupprimer);
		pannelPrincipal.add(pannelBoutton);
		
		this.add(pannelPrincipal);
	}
	
	public void attacherReactions() {
		annuler.addActionListener(new EcouteurAnnulerSupprimer(this));
	}
	
	public void actionPerformed(ActionEvent e) {
		JList liste = parent.getListeGche();
		if(liste.getSelectedValue() != null) {
			String valeur = (String) liste.getSelectedValue();
			aSupprimer.setText(valeur);
		}
		this.setVisible(true);
	}
}
