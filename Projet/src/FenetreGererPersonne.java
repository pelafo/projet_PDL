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
 * Classe FenetreAjoutPersonne
 * Définit et ouvre une fenetre qui :
 * 
 *    - Permet de gerer les personnes avec plusieurs choix : -Creer un personne
 *    														 -Modifier une personne
 *    														 -Supprimer une personne
 *    														 -Afficher toutes les personnes
 *    
 * @author LA FONTA - BENGA
 * @version 1
 * */

public class FenetreGererPersonne extends JFrame implements ActionListener{
	
	
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
	 * bouton pour céer une personne
	 */
	private JButton boutonCreer;
	
	/**
	 * bouton pour modifier une personne
	 */
	private JButton boutonModifier;
	
	/**
	 * bouton pour supprimer
	 */
	private JButton boutonSupprimer;
	
	/**
	 * bouton qui permet d'afficher toutes les personnes
	 */
	private JButton boutonAfficher;
	
	/**
	 * bouton pour revenir en arrière
	 */
	private JButton boutonArriere;
	
	private JLabel labelTitre;
	
	
	private FenetreAjoutPersonne fenetre;
	private FenetreAfficherPersonne fenetreAfficher;
	private FenetreMenu fenetreMenu;
	private FenetreModifierPersonne fenetreModifier;
	
	/**
	 * Constructeur Définit la fenêtre et ses composants - affiche la fenêtre
	 */
	public FenetreGererPersonne() {
		// on fixe le titre de la fenêtre
		this.setTitle("Gestion des personnes");
		// initialisation de la taille de la fenêtre
		this.setSize(400, 400);
		
		Font police = new Font("Times New Roman", Font.BOLD, 20);
		
		// création du conteneur
		containerPanel = new JPanel();
		
		// choix du Layout pour ce conteneur
		// il permet de gérer la position des éléments
		// il autorisera un retaillage de la fenêtre en conservant la présentation
		// BoxLayout permet par exemple de positionner les élements sur une colonne ( PAGE_AXIS )
		containerPanel.setLayout(new BoxLayout(containerPanel,BoxLayout.PAGE_AXIS));
		
		labelTitre = new JLabel("Gérer les personnes");
		labelTitre.setFont(police);
		containerPanel.add(Box.createRigidArea(new Dimension(100, 20)));
		containerPanel.add(labelTitre);

		// choix de la couleur pour le conteneur
		containerPanel.setBackground(Color.GREEN);
		
		// instantiation des composants graphiques
		boutonCreer = new JButton("Créer une personne");
		boutonModifier = new JButton("Modifier une personne");
		boutonSupprimer = new JButton("Supprimer une personne");
		boutonAfficher = new JButton("Afficher les personnes");
		boutonArriere = new JButton("retour");
		
		containerPanel.add(Box.createRigidArea(new Dimension(10, 25)));
		containerPanel.add(boutonCreer);
		containerPanel.add(Box.createRigidArea(new Dimension(0, 25)));
		containerPanel.add(boutonModifier);
		containerPanel.add(Box.createRigidArea(new Dimension(0, 25)));
		containerPanel.add(boutonSupprimer);
		containerPanel.add(Box.createRigidArea(new Dimension(0, 25)));
		containerPanel.add(boutonAfficher);
		
		containerPanel.add(Box.createRigidArea(new Dimension(0, 25)));
		containerPanel.add(boutonArriere);
		
		// ajouter une bordure vide de taille constante autour de l'ensemble des composants
		containerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 100, 100));	
			
		// ajout des écouteurs sur les boutons pour gérer les évènements
		boutonCreer.addActionListener(this);
		boutonModifier.addActionListener(this);
		boutonSupprimer.addActionListener(this);
		boutonAfficher.addActionListener(this);
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
			if (ae.getSource() == boutonCreer) {
				fenetre = new FenetreAjoutPersonne();
				this.setVisible(false);
				fenetre.setVisible(true);
			}else if(ae.getSource() == boutonModifier) {
				fenetreModifier = new FenetreModifierPersonne();
				this.setVisible(false);
				fenetreModifier.setVisible(true);
			}else if(ae.getSource() == boutonSupprimer) {
				
			}else if(ae.getSource() == boutonAfficher) {
				fenetreAfficher = new FenetreAfficherPersonne();
				this.setVisible(false);
				fenetreAfficher.setVisible(true);
				
			}else if(ae.getSource() == boutonArriere) {
				fenetreMenu = new FenetreMenu();
				this.setVisible(false);
				fenetreMenu.setVisible(true);
				
			}
			
		}catch (Exception e) {
			JOptionPane.showMessageDialog(this,
					"Veuillez contrôler vos saisies", "Erreur",
					JOptionPane.ERROR_MESSAGE);
			System.err.println("Veuillez contrôler vos saisies");
		}
	}
	
	public static void main(String[] args) {
		new FenetreGererPersonne();
	}
}
		
