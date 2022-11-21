package ma.fstt.service;

import java.util.List;

import ma.fstt.entities.Client;


public interface ClientRepository {
	Client getById(int id);

	void ajouterClient(Client c);

	void modifierClient(int id, Client c);

	void supprimerClient(int id);


	List<Client> listClients();
}
