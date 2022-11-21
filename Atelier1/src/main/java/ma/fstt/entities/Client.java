package ma.fstt.entities;

import java.io.Serializable;
import java.util.List;

public class Client implements Serializable{
	private int id;
	private String nom;
	private String prenom;
	private String email;
	private String adresse;
	private String ville;
	private String telephone;
	
	private List<Commande> commandes;
	
	public Client() {
		// TODO Auto-generated constructor stub
	}
	
	public Client( String nom,String prenom,String email,String adresse,String ville,String telephone) {
		// TODO Auto-generated constructor stub
		this.setNom(nom);
		this.setPrenom(prenom);
		this.setEmail(email);
		this.setAdresse(adresse);
		this.setVille(ville);
		this.setTelephone(telephone);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public List<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}
	

}
