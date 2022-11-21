package ma.fstt.service;

import java.util.List;

import ma.fstt.entities.Produit;

public interface ProduitRepository {
	Produit getById(int id);

	void ajouterProduit(Produit c);

	void modifierProduit(int id, Produit c);

	void supprimerProduit(int id);


	List<Produit> listProduits();
}
