
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.Box;

import java.util.List;

/**
 * Classe FenetreAjoutPersonne
 * D�finit et ouvre une fenetre qui :
 * 
 *    - Permet l'insertion d'une nouvelle personne
 *    
 * @author LA FONTA - BENGA
 * @version 1
 * */

public class FenetreAjoutPersonne extends JFrame implements ActionListener{
	
	/**
	 * numero de version pour classe serialisable Permet d'eviter le warning
	 * "The serializable class ArticleFenetre does not declare a static final serialVersionUID field of type long"
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * conteneur : il accueille les differents composants graphiques de
	 * FenetreAjoutPersonne
	 */
	private JPanel containerPanel;

	/**
	 * zone de texte pour le champ ID
	 */
	private JTextField textFieldId;

	/**
	 * zone de texte pour le champ nom
	 */
	private JTextField textFieldNom;

	/**
	 * zone de texte pour le prenom
	 * 
	 */
	private JTextField textFieldPrenom;
	
	/**
	 * zone de texte pour la date de naissance
	 */
	private JTextField textFieldDate;
	
	/**
	 * zone de texte pour la fonction
	 */
	private JTextField textFieldFonction;
	
	/**
	 * label id
	 */
	private JLabel labelId;

	/**
	 * label nom
	 */
	private JLabel labelNom;

	/**
	 * label prenom
	 */
	private JLabel labelPrenom;

	/**
	 * label date
	 */
	private JLabel labelDate;
	
	/**
	 * label fonction
	 */
	private JLabel labelFonction;
	
	/**
	 * bouton d'ajout de la personne
	 */
	private JButton boutonAjouter;
	
	/**
	 * bouton pour revenir en arri�re
	 */
	private JButton boutonArriere;
	
	/**
	 * instance de PersonneDAO permettant les acc�s � la base de donn�es
	 */
	private PersonneDAO maPersonneDAO;
	
	private FenetreGererPersonne fenetreGerer;
	
	/**
	 * Constructeur D�finit la fen�tre et ses composants - affiche la fen�tre
	 */
	public FenetreAjoutPersonne() {
		// on instancie la classe Personne DAO
		this.maPersonneDAO = new PersonneDAO();

		// on fixe le titre de la fen�tre
		this.setTitle("Personne");
		// initialisation de la taille de la fen�tre
		this.setSize(400, 400);
		
		// cr�ation du conteneur
		containerPanel = new JPanel();
		
		// choix du Layout pour ce conteneur
		// il permet de g�rer la position des �l�ments
		// il autorisera un retaillage de la fen�tre en conservant la pr�sentation
		// BoxLayout permet par exemple de positionner les �lements sur une
		// colonne ( PAGE_AXIS )
		containerPanel.setLayout(new BoxLayout(containerPanel,BoxLayout.PAGE_AXIS));
		
		// choix de la couleur pour le conteneur
		containerPanel.setBackground(Color.GREEN);
		
		// instantiation des composants graphiques
		textFieldId = new JTextField();
		textFieldNom = new JTextField();
		textFieldPrenom = new JTextField();
		textFieldDate = new JTextField();
		textFieldFonction = new JTextField();
		boutonAjouter = new JButton("ajouter");
		boutonArriere = new JButton("retour");
				
		labelId = new JLabel("ID :");
		labelNom = new JLabel("Nom :");
		labelPrenom = new JLabel("Prenom :");
		labelDate = new JLabel("Date de naissance :");
		labelFonction = new JLabel("Fonction :");

		// ajout des composants sur le container
		containerPanel.add(labelId);
		// introduire une espace constant entre le label et le champ texte
		containerPanel.add(Box.createRigidArea(new Dimension(0, 5)));
		containerPanel.add(textFieldId);
				
		// introduire une espace constant entre le champ texte et le composant suivant
		containerPanel.add(Box.createRigidArea(new Dimension(0, 10)));

		containerPanel.add(labelNom);
		containerPanel.add(Box.createRigidArea(new Dimension(0, 5)));
		containerPanel.add(textFieldNom);
		containerPanel.add(Box.createRigidArea(new Dimension(0, 10)));

		containerPanel.add(labelPrenom);
		containerPanel.add(Box.createRigidArea(new Dimension(0, 5)));
		containerPanel.add(textFieldPrenom);
		containerPanel.add(Box.createRigidArea(new Dimension(0, 10)));

		containerPanel.add(labelDate);
		containerPanel.add(Box.createRigidArea(new Dimension(0, 5)));
		containerPanel.add(textFieldDate);
		containerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
				
		containerPanel.add(labelFonction);
		containerPanel.add(Box.createRigidArea(new Dimension(0, 5)));
		containerPanel.add(textFieldFonction);
		containerPanel.add(Box.createRigidArea(new Dimension(0, 10)));

		containerPanel.add(boutonAjouter);

		containerPanel.add(Box.createRigidArea(new Dimension(0, 20)));
		containerPanel.add(boutonArriere);
				
		// ajouter une bordure vide de taille constante autour de l'ensemble des composants
		containerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
				
		// ajout des �couteurs sur les boutons pour g�rer les �v�nements
		boutonAjouter.addActionListener(this);
		boutonArriere.addActionListener(this);
				
		// permet de quitter l'application si on ferme la fen�tre
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setContentPane(containerPanel);
				
		// affichage de la fen�tre
		this.setVisible(true);
		
	}
	/**
	 * G�re les actions r�alis�es sur les boutons
	 *
	 */
	public void actionPerformed(ActionEvent ae) {
		
		int retour; // code de retour de la classe PersonneDAO

		try {
			if (ae.getSource() == boutonAjouter) {
				// on cr�e l'objet message
				Personne p = new Personne(
				Integer.parseInt(this.textFieldId.getText()),
				this.textFieldNom.getText(),
				this.textFieldPrenom.getText(),
				this.textFieldDate.getText(),
				this.textFieldFonction.getText());
			// on demande � la classe de communication d'envoyer l'article
			// dans la table article
			retour = maPersonneDAO.ajouter(p);
			// affichage du nombre de lignes ajout�es
			// dans la bdd pour v�rification
			System.out.println("" + retour + " ligne ajout�e ");
			if (retour == 1)
				JOptionPane.showMessageDialog(this, "personne ajout�e !");
			else
				JOptionPane.showMessageDialog(this, "erreur ajout personne",
						"Erreur", JOptionPane.ERROR_MESSAGE);
	
		}else if(ae.getSource() == boutonArriere) {
			fenetreGerer = new FenetreGererPersonne();
			this.setVisible(false);
			fenetreGerer.setVisible(true);
			
		}
	
	}catch (Exception e) {
		JOptionPane.showMessageDialog(this,
				"Veuillez contr�ler vos saisies", "Erreur",
				JOptionPane.ERROR_MESSAGE);
		System.err.println("Veuillez contr�ler vos saisies");
	}
	}
	public static void main(String[] args) {
		new FenetreAjoutPersonne();
	}
}
