package ma.fstt.service;

import java.util.List;

import ma.fstt.entities.LignesCommande;

public interface LignesCommandeRepositpry {
	LignesCommande getById(int id);

	void ajouterLigne(LignesCommande ligne);

	void modifierLigne(int id, LignesCommande ligne);

	void supprimerLigne(int id);


	List<LignesCommande> listDesLignes(int id);
}
