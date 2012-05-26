package ihm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import datas.* ;

/**
 * Cette classe gère la fenêtre de modification d'un contact.
 */
public class WtDialogModifier extends JDialog implements ActionListener {

	/** Attribut graphique. */
	private JLabel labelTitre, labelNom, labelPrenom, labelNum, labelAdresse;
	/** Attribut graphique. */
	private JButton bouttonConfirmer, bouttonAnnuler ;
	/** Attribut graphique. */
	private JTextField nom, prenom, num, adresse ;

	/** Copie locale de Wintel. */
	private Wintel parent;

	/**
	 * Le constructeur permet également de mettre en place l'interface graphique.
	 */
	public WtDialogModifier(Wintel parent) {
		super( parent , "Modifier un contact" , false ) ;
		this.parent = parent;
		this.creerInterface();
		bouttonAnnuler.addActionListener( this ) ;
		bouttonConfirmer.addActionListener( parent.getEcouteurs() ) ;
		this.setSize( 400 , 400 ) ;
		this.setVisible( false ) ;
	}

	/**
	 * Dispose les attributs graphiques.
	 */
	private void creerInterface() {
		//Boutton en bas
		bouttonConfirmer = new JButton("Confirmer");
		bouttonAnnuler = new JButton("Annuler");
		JPanel panelBoutton = new JPanel(new GridLayout(1, 2));
		panelBoutton.add(bouttonConfirmer);
		panelBoutton.add(bouttonAnnuler);

		//Panel principal
		labelTitre = new JLabel("Contact à modifier (nom figé)");
		labelTitre.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitre.setForeground(Color.blue);

		labelNom = new JLabel("Nom : ");
		labelPrenom = new JLabel("Prénom : ");
		labelNum = new JLabel("Téléphone : ");
		labelAdresse = new JLabel("Adresse : ");

		nom = new JTextField();
		nom.setEditable( false ) ;
		nom.setBackground( Color.white ) ;
		prenom = new JTextField();
		num = new JTextField();
		adresse = new JTextField();

		BorderLayout gestionnairePlacement = new BorderLayout(10, 10);
		JPanel panelCentre = new JPanel(new GridLayout(10, 1, 0, 10));
		JPanel panelGauche = new JPanel();
		JPanel panelDroit = new JPanel();
		JPanel panelBas = new JPanel();
		this.setLayout(gestionnairePlacement);
		this.add(panelCentre, BorderLayout.CENTER);
		this.add(panelGauche, BorderLayout.WEST);
		this.add(panelDroit, BorderLayout.EAST);
		this.add(panelBas, BorderLayout.SOUTH);
		panelCentre.add(labelTitre);
		panelCentre.add(labelNom);
		panelCentre.add(nom);
		panelCentre.add(labelPrenom);
		panelCentre.add(prenom);
		panelCentre.add(labelNum);
		panelCentre.add(num);
		panelCentre.add(labelAdresse);
		panelCentre.add(adresse);
		panelCentre.add(panelBoutton);

	}

	/**
	 * Acesseur pour le bonton confirmer.
	 * @return Le bouton confirmer.
	 */
	public JButton getBoutonConfirmer() {
		return ( this.bouttonConfirmer ) ;
	}

	/**
	 * Acesseur pour le contenu des champs de texte.
	 * @return Un tableau de String. Organisation du tableau : 
	 * <code>{ [nom] , [prenom] , [num] , [adresse] }</code>
	 */
	public String[] getJTextField() {
		String[] tab = { nom.getText() , prenom.getText() , num.getText() , adresse.getText() } ;
		return ( tab ) ;
	}

	/**
	 * Gestion en local des évènements.
	 */
	public void actionPerformed( ActionEvent e ) {
		Object src = e.getSource() ;
		/*
		if ( src == bouttonConfirmer ) {
			try {
				// La ligne ci-dessous fonctionne avec le programme de base sans le champs adresse. 
				Fiche tmpFiche = new Fiche( nom.getText() , prenom.getText() , num.getText() ) ;
				
				// FicheAdresse tmpFiche = new FicheAdresse(nom.getText(), prenom.getText(), num.getText(), adresse.getText());
				// Si la supression s'est déroulée sans encombres on ajoute la personne.
				if ( parent.rmAbonne() ) { 
					parent.ajouterAbonne( tmpFiche ) ; 
					this.setVisible( false ) ;
				}
				else { JOptionPane.showMessageDialog( this , "L'abonné n'a pas pu être supprimé.", "Erreur" , JOptionPane.WARNING_MESSAGE ) ; }
			}
			catch ( IllegalArgumentException err ) { 
				JOptionPane.showMessageDialog( this , err.getMessage() , "Erreur" , JOptionPane.WARNING_MESSAGE );
			}
			catch ( Exception err ) { err.printStackTrace() ; }
		}
		*/
		if ( src == bouttonAnnuler ) { this.setVisible( false ) ; }
		else if ( parent.getListeGche().getSelectedValue() == null ) {	
			JOptionPane.showMessageDialog( parent , "Veuillez sélectionner un contact." , "Erreur" , JOptionPane.WARNING_MESSAGE ); 
		}
		else { 
			nom.setText( parent.getFieldNom().getText() ) ;
			prenom.setText( parent.getFieldPrenom().getText() ) ;
			num.setText( parent.getFieldNumero().getText() ) ;
			adresse.setText(parent.getFieldAdresse().getText());
			this.setVisible( true ) ; 
		}
	}
}
