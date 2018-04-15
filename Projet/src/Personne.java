/**
 * Classe Personne
 * @author LA FONTA-BENGA
 * @version 1
 * */
import java.util.Date;

public class Personne {
	
	/** 
	 * numero de la personne
	 */
	private int id;
	
	/** 
	 * nom de la personne
	 */
	private String nom;
	
	/** 
	 * prenom de la personne
	 */
	private String prenom;
	
	/** 
	 * date de naissance de la personne
	 */
	private String date;
	
	/** 
	 * fonction de la personne
	 */
	private String fonction;
	
	/**
	 * Constructeur
	 * @param nom nom de la personne
	 * @param prenom prenom de la personne
	 * @param date date de naissance
	 * @param fonction fonction de la personne
	 */
	public Personne( int id, String nom, String prenom, String date, String fonction) {
		this.id=id;
		this.nom=nom;
		this.prenom=prenom;
		this.date=date;
		this.fonction=fonction;
	}
	
	/**
	 * getter pour l'attribut id
	 * @return id de la personne
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * getter pour l'attribut nom
	 * @return nom de la personne
	 */
	public String getNom() {
		return nom;
	}
	
	/**
	 * setter  pour l'attribut nom
	 * @param nom : nouvelle valeur du nom de la personne
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	/**
	 * getter pour l'attribut prenom
	 * @return prenom
	 */
	public String getPrenom() {
		return prenom;
	}
	
	/**
	 * setter  pour l'attribut prenom
	 * @param prenom : nouvelle valeur du prenom de la personne
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	/**
	 * getter pour l'attribut date
	 * @return date de naissance
	 */
	public String getDate() {
		return date;
	}
	
	/**
	 * setter  pour l'attribut date
	 * @param date : nouvelle valeur de la date de naissance
	 */
	public void setDate(String date) {
		this.date = date;
	}
	
	/**
	 * getter pour l'attribut fonction
	 * @return fonction de la personne
	 */
	public String getFonction() {
		return fonction;
	}
	
	/**
	 * setter  pour l'attribut fonction
	 * @param fonction : nouvelle valeur de la fonction de la personne
	 */
	public void setFonction(String fonction) {
		this.fonction = fonction;
	}
	
	/**
	 * Redéfinition de la méthode toString permettant de définir la traduction de l'objet en String
	 * pour l'affichage par exemple
	 */
	public String toString() {
		return "La personne s'appelle : nom : "+nom+" - prenom : "+prenom+" né(e) le "+date+ " occupe la fonction de : "+fonction
				+ ". Il possede l'ID : "+id;
	}
}
