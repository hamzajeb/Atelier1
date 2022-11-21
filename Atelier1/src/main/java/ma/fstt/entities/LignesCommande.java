package ma.fstt.entities;

public class LignesCommande {
	private int id;
	private String numLigne;
	private int qteCommande;
	private int produitId;
	private int commandeId;
	public LignesCommande() {
		// TODO Auto-generated constructor stub
	}
	public LignesCommande(String numLigne,int qteCommande,int produitId,int commandeId) {
		this.numLigne=numLigne;
		this.qteCommande=qteCommande;
		this.produitId=produitId;	
		this.commandeId=commandeId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumLigne() {
		return numLigne;
	}
	public void setNumLigne(String numLigne) {
		this.numLigne = numLigne;
	}
	public int getQteCommande() {
		return qteCommande;
	}
	public void setQteCommande(int qteCommande) {
		this.qteCommande = qteCommande;
	}
	public int getProduitId() {
		return produitId;
	}
	public void setProduitId(int produitId) {
		this.produitId = produitId;
	}
	public int getCommandeId() {
		return commandeId;
	}
	public void setCommandeId(int commandeId) {
		this.commandeId = commandeId;
	}

}
