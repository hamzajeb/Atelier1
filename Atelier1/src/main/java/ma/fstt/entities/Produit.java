package ma.fstt.entities;

public class Produit {
	private int id;
	private String codeProduit;
	private String nomProduit;
	private Double prix;
	public Produit() {
		// TODO Auto-generated constructor stub
	}
	public Produit(String codeProduit,String nomProduit,Double prix) {
		this.codeProduit=codeProduit;
		this.nomProduit=nomProduit;
		this.prix=prix;
	}	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCodeProduit() {
		return codeProduit;
	}
	public void setCodeProduit(String codeProduit) {
		this.codeProduit = codeProduit;
	}
	public String getNomProduit() {
		return nomProduit;
	}
	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}
	public Double getPrix() {
		return prix;
	}
	public void setPrix(Double prix) {
		this.prix = prix;
	}

}
