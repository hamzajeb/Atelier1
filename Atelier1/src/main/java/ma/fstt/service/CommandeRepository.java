package ma.fstt.service;

import java.util.List;

import ma.fstt.entities.Commande;

public interface CommandeRepository {
	Commande getById(int id);

	void ajouterCommande(Commande c);

	void modifierCommande(int id, Commande c);

	void supprimerCommande(int id);


	List<Commande> listCommandes(int id);
}
