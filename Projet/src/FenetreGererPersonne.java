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
 * D�finit et ouvre une fenetre qui :
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
	 * bouton pour c�er une personne
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
	 * bouton pour revenir en arri�re
	 */
	private JButton boutonArriere;
	
	private JLabel labelTitre;
	
	
	private FenetreAjoutPersonne fenetre;
	private FenetreAfficherPersonne fenetreAfficher;
	private FenetreMenu fenetreMenu;
	private FenetreModifierPersonne fenetreModifier;
	
	/**
	 * Constructeur D�finit la fen�tre et ses composants - affiche la fen�tre
	 */
	public FenetreGererPersonne() {
		// on fixe le titre de la fen�tre
		this.setTitle("Gestion des personnes");
		// initialisation de la taille de la fen�tre
		this.setSize(400, 400);
		
		Font police = new Font("Times New Roman", Font.BOLD, 20);
		
		// cr�ation du conteneur
		containerPanel = new JPanel();
		
		// choix du Layout pour ce conteneur
		// il permet de g�rer la position des �l�ments
		// il autorisera un retaillage de la fen�tre en conservant la pr�sentation
		// BoxLayout permet par exemple de positionner les �lements sur une colonne ( PAGE_AXIS )
		containerPanel.setLayout(new BoxLayout(containerPanel,BoxLayout.PAGE_AXIS));
		
		labelTitre = new JLabel("G�rer les personnes");
		labelTitre.setFont(police);
		containerPanel.add(Box.createRigidArea(new Dimension(100, 20)));
		containerPanel.add(labelTitre);

		// choix de la couleur pour le conteneur
		containerPanel.setBackground(Color.GREEN);
		
		// instantiation des composants graphiques
		boutonCreer = new JButton("Cr�er une personne");
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
			
		// ajout des �couteurs sur les boutons pour g�rer les �v�nements
		boutonCreer.addActionListener(this);
		boutonModifier.addActionListener(this);
		boutonSupprimer.addActionListener(this);
		boutonAfficher.addActionListener(this);
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
					"Veuillez contr�ler vos saisies", "Erreur",
					JOptionPane.ERROR_MESSAGE);
			System.err.println("Veuillez contr�ler vos saisies");
		}
	}
	
	public static void main(String[] args) {
		new FenetreGererPersonne();
	}
}
		
