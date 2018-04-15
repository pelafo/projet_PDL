import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.Font;

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
 * Classe FenetreModifierPersonne
 * Définit et ouvre une fenetre qui :
 *    - Permet de choisir et de modifier les données d'une personne
 * @author LA FONTA - BENGA
 * @version 1
 * */

public class FenetreModifierPersonne extends JFrame implements ActionListener{
	
	/**
	 * numero de version pour classe serialisable Permet d'eviter le warning
	 * "The serializable class ArticleFenetre does not declare a static final serialVersionUID field of type long"
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * conteneur : il accueille les differents composants graphiques de
	 * ArticleFenetre
	 */
	private JPanel containerPanel;
	
	/**
	 * Zone de texte pour afficher les personnes
	 */
	JTextArea zoneTextListPersonnes;
	
	/**
	 * Zone de défilement pour la zone de texte
	 */
	JScrollPane zoneDefilement;
	
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
	 * bouton d'ajout de la nouvelle personne
	 */
	private JButton boutonRechercher;
	
	/**
	 * Bouton retour
	 */
	private JButton boutonArriere;
	
	private JButton boutonModifier;
	
	/**
	 * instance de PersonneDAO permettant les accès à la base de données
	 */
	private PersonneDAO maPersonneDAO;
	
	private FenetreAjoutPersonne fenetreAjouter;
	private FenetreGererPersonne fenetreGerer;
	
	/**
	 * Constructeur Définit la fenêtre et ses composants - affiche la fenêtre
	 */
	public FenetreModifierPersonne() {
		// on instancie la classe Personne DAO
		this.maPersonneDAO = new PersonneDAO();

		// on fixe le titre de la fenêtre
		this.setTitle("Personne");
		// initialisation de la taille de la fenêtre
		this.setSize(400, 400);
		
		// création du conteneur
				containerPanel = new JPanel();
				
		// choix du Layout pour ce conteneur il permet de gérer la position des éléments
		// il autorisera un retaillage de la fenêtre en conservant la présentation
		// BoxLayout permet par exemple de positionner les élements sur une
		// colonne ( PAGE_AXIS )
		containerPanel.setLayout(new BoxLayout(containerPanel,BoxLayout.PAGE_AXIS));
				
		// choix de la couleur pour le conteneur
		containerPanel.setBackground(Color.GREEN);
		
		textFieldNom = new JTextField();
		boutonRechercher = new JButton("Rechercher");
		boutonArriere = new JButton("retour");
		boutonModifier = new JButton("Modifier");
		
		labelNom = new JLabel("Nom :");
		
		// ajout des composants sur le container
		containerPanel.add(labelNom);
		// introduire une espace constant entre le label et le champ texte
		containerPanel.add(Box.createRigidArea(new Dimension(0, 5)));
		containerPanel.add(textFieldNom);
		
		containerPanel.add(boutonRechercher);
		containerPanel.add(boutonModifier);
		containerPanel.add(boutonArriere);
		
		
		// ajouter une bordure vide de taille constante autour de l'ensemble des composants
		containerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		// ajout des écouteurs sur les boutons pour gérer les évènements
		boutonRechercher.addActionListener(this);
		boutonModifier.addActionListener(this);
		boutonArriere.addActionListener(this);
		
		// permet de quitter l'application si on ferme la fenêtre
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setContentPane(containerPanel);
						
		// affichage de la fenêtre
		this.setVisible(true);
		
	}
	/**
	 * Gère les actions réalisées sur les boutons
	 *
	 */
	public void actionPerformed(ActionEvent ae) {
		try {
			if (ae.getSource() == boutonModifier) {
				fenetreAjouter = new FenetreAjoutPersonne();
				this.setVisible(false);
				fenetreAjouter.setVisible(true);		
				
			}else if(ae.getSource() == boutonArriere) {
				fenetreGerer = new FenetreGererPersonne();
				this.setVisible(false);
				fenetreGerer.setVisible(true);
		}else if(ae.getSource() == boutonRechercher) {
			
		}
		
	}catch (Exception e) {
		JOptionPane.showMessageDialog(this,
				"Veuillez contrôler vos saisies", "Erreur",
				JOptionPane.ERROR_MESSAGE);
		System.err.println("Veuillez contrôler vos saisies");
	}
	
	}
	
	

}
