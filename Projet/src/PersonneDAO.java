import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;


/**
 * Classe d'accès aux données contenues dans la table personne
 * 
 * @author LA FONTA - BENGA
 * @version 1
 * */
public class PersonneDAO {
	
	/**
	 * Paramètres de connexion à la base de données oracle URL, LOGIN et PASS
	 * sont des constantes
	 */
	final static String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	final static String LOGIN = "pelafo";  //exemple BDD1
	final static String PASS = "pe895623";   //exemple BDD1
	
	/**
	 * Constructeur de la classe
	 * 
	 */
	public PersonneDAO() {
		// chargement du pilote de bases de données
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.err
					.println("Impossible de charger le pilote de BDD, ne pas oublier d'importer le fichier .jar dans le projet");
		}

	}
	
	/**
	 * Permet d'ajouter une personne dans la table personne Le mode est auto-commit
	 * par défaut : chaque insertion est validée
	 * 
	 * @param personne
	 *            la personne à ajouter
	 * @return retourne le nombre de lignes ajoutées dans la table
	 */
	public int ajouter(Personne personne) {
		Connection con = null;
		PreparedStatement ps = null;
		int retour = 0;
		
		// connexion à la base de données
				try {

					// tentative de connexion
					con = DriverManager.getConnection(URL, LOGIN, PASS);
					// préparation de l'instruction SQL, chaque ? représente une valeur
					// à communiquer dans l'insertion
					// les getters permettent de récupérer les valeurs des attributs
					// souhaités
					ps = con.prepareStatement("INSERT INTO PERSONNE ( id,nom, prenom, date_naissance, fonction) VALUES (?, ?, ?, ?, ?)");
					ps.setInt(1, personne.getId());
					ps.setString(2, personne.getNom());
					ps.setString(3, personne.getPrenom());
					ps.setString(4, personne.getDate());
					ps.setString(5, personne.getFonction());

					// Exécution de la requête
					retour = ps.executeUpdate();

				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					// fermeture du preparedStatement et de la connexion
					try {
						if (ps != null)
							ps.close();
					} catch (Exception ignore) {
					}
					try {
						if (con != null)
							con.close();
					} catch (Exception ignore) {
					}
				}
				return retour;

			}
	
	
	/**
	 * Permet de récupérer une peronne à partir de son nom
	 * 
	 * @param nom
	 *            le nom de la personne à récupérer
	 * @return 	le nom trouvé;
	 * 			null si aucun nom ne correspond à ce nom
	 */
	
	public Personne getPersonne(String nom) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Personne retour = null;

		// connexion à la base de données
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM PERSONNE WHERE nom = ?");
			ps.setString( 1, nom);

			// on exécute la requête
			// rs contient un pointeur situé juste avant la première ligne
			// retournée
			rs = ps.executeQuery();
			// passe à la première (et unique) ligne retournée
			if (rs.next())
				retour = new Personne(rs.getInt("id"),rs.getString("nom"),
						rs.getString("prenom"),
						rs.getString("date_naissance"), rs.getString("fonction"));

		} catch (Exception ee) {
			ee.printStackTrace();
		} finally {
			// fermeture du ResultSet, du PreparedStatement et de la Connexion
			try {
				if (rs != null)
					rs.close();
			} catch (Exception ignore) {
			}
			try {
				if (ps != null)
					ps.close();
			} catch (Exception ignore) {
			}
			try {
				if (con != null)
					con.close();
			} catch (Exception ignore) {
			}
		}
		return retour;

	}
	
	/**
	 * Permet de récupérer tous les personnes stockés dans la table personne
	 * 
	 * @return une ArrayList de personne
	 */
	
	public List<Personne> getListePersonne() {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Personne> retour = new ArrayList<Personne>();

		// connexion à la base de données
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM PERSONNE");

			// on exécute la requête
			rs = ps.executeQuery();
			// on parcourt les lignes du résultat
			while (rs.next())
				retour.add(new Personne(rs.getInt("id"),rs.getString("nom"), rs
						.getString("prenom"), rs
						.getString("date_naissance"), rs.getString("fonction")));

		} catch (Exception ee) {
			ee.printStackTrace();
		} finally {
			// fermeture du rs, du preparedStatement et de la connexion
			try {
				if (rs != null)
					rs.close();
			} catch (Exception ignore) {
			}
			try {
				if (ps != null)
					ps.close();
			} catch (Exception ignore) {
			}
			try {
				if (con != null)
					con.close();
			} catch (Exception ignore) {
			}
		}
		return retour;

	}

	// main permettant de tester la classe
		public static void main(String[] args) throws SQLException {

			PersonneDAO personneDAO = new PersonneDAO();
			// test de la méthode ajouter
			Personne p1 = new Personne(1,"LA Fonta","Paul-Edouard","10 mars 1997", "eleve");
			int retour = personneDAO.ajouter(p1);

			System.out.println(retour + " lignes ajoutées");

			// test de la méthode getArticle
			Personne p2 = personneDAO.getPersonne("nom");
			System.out.println(p2);

			// test de la méthode getListeArticles
			List<Personne> liste = personneDAO.getListePersonne();
			// affichage des articles
			for (Personne perso : liste) {
				System.out.println(perso.toString());
			}

		}
}

