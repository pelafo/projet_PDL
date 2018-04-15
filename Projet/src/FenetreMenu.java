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
 * Classe FenetreMenu
 * Définit et ouvre une fenetre qui :
 * 
 *    - Permet d'afficher le menu principale de notre programme
 *    - Permet de choisir entre 4 possibilitées :	-Gérer les personnes
 *    												-Gérer les cartes
 *    												-Gérer les lieux
 *    												-Gérer les accès							
 * @author LA FONTA - BENGA
 * @version 1
 * */

public class FenetreMenu extends JFrame implements ActionListener{
	
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
	 * bouton pour gérer les personnes
	 */
	private JButton boutonPersonne;
	
	/**
	 * bouton pour gérer les cartes
	 */
	private JButton boutonCarte;
	
	/**
	 * bouton pour gérer les lieux
	 */
	private JButton boutonLieu;
	
	private JLabel labelTitre;
	
	/**
	 * bouton pour gérer les accès
	 */
	private JButton boutonAcce;
	
	
	private FenetreGererPersonne fenetre;
	
	/**
	 * Constructeur Définit la fenêtre et ses composants - affiche la fenêtre
	 */
	public FenetreMenu() {
		// on fixe le titre de la fenêtre
		this.setTitle("Gestion des accès aux batiments de l'ESIGELEC");
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
		
		labelTitre = new JLabel("Menu");
		labelTitre.setFont(police);
		containerPanel.add(Box.createRigidArea(new Dimension(0, 5)));
		containerPanel.add(labelTitre);
		
		// choix de la couleur pour le conteneur
		containerPanel.setBackground(Color.GREEN);
		
		// instantiation des composants graphiques
		boutonPersonne = new JButton("Gérer les personnes");
		boutonCarte = new JButton("Gérer les cartes");
		boutonLieu = new JButton("Gérer les lieux");
		boutonAcce = new JButton("Gérer les accès");
		
		containerPanel.add(Box.createRigidArea(new Dimension(10, 25)));
		containerPanel.add(boutonPersonne);
		containerPanel.add(Box.createRigidArea(new Dimension(100, 30)));
		containerPanel.add(boutonCarte);
		containerPanel.add(Box.createRigidArea(new Dimension(100, 30)));
		containerPanel.add(boutonLieu);
		containerPanel.add(Box.createRigidArea(new Dimension(100, 30)));
		containerPanel.add(boutonAcce);
		
		// ajouter une bordure vide de taille constante autour de l'ensemble des composants
		containerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));	
					
		// ajout des écouteurs sur les boutons pour gérer les évènements
		boutonPersonne.addActionListener(this);
		boutonCarte.addActionListener(this);
		boutonLieu.addActionListener(this);
		boutonAcce.addActionListener(this);
		
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
			if (ae.getSource() == boutonPersonne) {
				fenetre = new FenetreGererPersonne();
				this.setVisible(false);
				fenetre.setVisible(true);
			}else if(ae.getSource() == boutonCarte) {
				
			}else if(ae.getSource() == boutonLieu) {
				
			}else if(ae.getSource() == boutonAcce) {
				
			}
			
		}catch (Exception e) {
			JOptionPane.showMessageDialog(this,
					"Veuillez contrôler vos saisies", "Erreur",
					JOptionPane.ERROR_MESSAGE);
			System.err.println("Veuillez contrôler vos saisies");
		}
	}
	

}
