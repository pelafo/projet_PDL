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
 * Classe FenetreAfficherPersonne
 * D�finit et ouvre une fenetre qui :
 *    - Permet l'affichage de toutes les personnes dans la console
 * @author LA FONTA - BENGA
 * @version 1
 * */

public class FenetreAfficherPersonne extends JFrame implements ActionListener{
	
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
	 * Zone de d�filement pour la zone de texte
	 */
	JScrollPane zoneDefilement;
	
	/**
	 * Bouton retour
	 */
	private JButton boutonArriere;
	
	private JLabel labelTitre;

	/**
	 * instance de ArticleDAO permettant les acc�s � la base de donn�es
	 */
	private PersonneDAO maPersonneDAO;
	
	private FenetreGererPersonne fenetreGerer;
	
	/**
	 * Constructeur D�finit la fen�tre et ses composants - affiche la fen�tre
	 */
	public FenetreAfficherPersonne() {
		// on instancie la classe Article DAO
		this.maPersonneDAO = new PersonneDAO();
		// on fixe le titre de la fen�tre
		this.setTitle("Afficher les personnes");
		// initialisation de la taille de la fen�tre
		this.setSize(400, 400);
		Font police = new Font("Times New Roman", Font.BOLD, 20);
		
		// cr�ation du conteneur
		containerPanel = new JPanel();
		
		// choix du Layout pour ce conteneur il permet de g�rer la position des �l�ments,
		// il autorisera un retaillage de la fen�tre en conservant la pr�sentation
		// BoxLayout permet par exemple de positionner les �lements sur une colonne ( PAGE_AXIS )
		containerPanel.setLayout(new BoxLayout(containerPanel,BoxLayout.PAGE_AXIS));
		
		labelTitre = new JLabel("Affiche toutes les personnes");
		labelTitre.setFont(police);
		containerPanel.add(Box.createRigidArea(new Dimension(0, 5)));
		containerPanel.add(labelTitre);
		
		// choix de la couleur pour le conteneur
		containerPanel.setBackground(Color.GREEN);
		
		boutonArriere = new JButton("retour");
		
		zoneTextListPersonnes = new JTextArea(10, 20);
		zoneDefilement = new JScrollPane(zoneTextListPersonnes);
		zoneTextListPersonnes.setEditable(false);
		
		containerPanel.add(Box.createRigidArea(new Dimension(100, 50)));
		containerPanel.add(Box.createRigidArea(new Dimension(0, 5)));
		containerPanel.add(zoneDefilement);
		
		// ajouter une bordure vide de taille constante autour de l'ensemble des composants
		containerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		// ajout des �couteurs sur les boutons pour g�rer les �v�nements
		boutonArriere.addActionListener(this);
		
		// permet de quitter l'application si on ferme la fen�tre
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(containerPanel);
		
		containerPanel.add(Box.createRigidArea(new Dimension(0, 20)));
		containerPanel.add(boutonArriere);

		// affichage de la fen�tre
		this.setVisible(true);
		
		// on demande � la classe PersonneDAO d'ajouter le message dans la base de donn�es
		List<Personne> liste = maPersonneDAO.getListePersonne();
		// on efface l'ancien contenu de la zone de texte
		zoneTextListPersonnes.setText("");
		// on affiche dans la console du client les personne
		for (Personne p : liste) {
		zoneTextListPersonnes.append(p.toString());
		zoneTextListPersonnes.append("\n");
		}
			// Pour afficher dans la console :
			// System.out.println(a.toString());
	}
		
		/**
		 * G�re les actions r�alis�es sur les boutons
		 *
		 */
		public void actionPerformed(ActionEvent ae) {

			try {
				if(ae.getSource() == boutonArriere) {
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

}
