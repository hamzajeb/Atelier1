package ma.fstt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;

import ma.fstt.entities.Client;
import ma.fstt.entities.Commande;
import ma.fstt.service.ClientRepository;

@ApplicationScoped
public class ClientDao implements ClientRepository{
	@Override
	public Client getById(int id) {
		Client client= new Client();
		try {
			Connection cnx=SingletonConnection.getConnexion();
			PreparedStatement ps;
			try {
				ps = cnx.prepareStatement("SELECT * FROM `client` WHERE id = ?");
				ps.setInt(1, id);
				ResultSet rs=ps.executeQuery();
				if(rs.next()){
					client.setId(rs.getInt("id"));
					client.setAdresse(rs.getString("adresse"));
					client.setNom(rs.getString("nom"));
					client.setPrenom(rs.getString("prenom"));
					client.setTelephone(rs.getString("telephone"));
					client.setVille(rs.getString("ville"));
					client.setEmail(rs.getString("email"));
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return client;
	}

	@Override
	public void ajouterClient(Client client) {
		try {
			Connection cnx=SingletonConnection.getConnexion();
			PreparedStatement ps;
			try {
				ps = cnx.prepareStatement("INSERT INTO client (nom, prenom, adresse,email,telephone,ville) VALUES (?, ?, ?, ?, ?, ?)");
				ps.setString(1,client.getNom() );
				ps.setString(2,client.getPrenom() );
				ps.setString(3,client.getAdresse() );
				ps.setString(4,client.getEmail() );
				ps.setString(5,client.getTelephone() );
				ps.setString(6, client.getVille());
				if(ps.executeUpdate()>0) {
					System.out.println("Client enregistre");
				}
			
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void modifierClient(int id, Client c) {
		try {
			Connection cnx=SingletonConnection.getConnexion();
			PreparedStatement ps;
			try {
				ps = cnx.prepareStatement("UPDATE client SET nom = ?, prenom = ?, adresse = ?,telephone = ?,ville= ?,email= ? WHERE id = ?");
				ps.setString(1, c.getNom());
				ps.setString(2, c.getPrenom());
				ps.setString(3, c.getAdresse());
				ps.setString(4, c.getTelephone());
				ps.setString(5, c.getVille());
				ps.setString(6, c.getEmail());
				ps.setInt(7, id);
				if(ps.executeUpdate()>0) {
					System.out.println("Client modifie");
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	@Override
	public void supprimerClient(int id) {
		try {
			Connection cnx=SingletonConnection.getConnexion();
			PreparedStatement ps;
			try {
				ps = cnx.prepareStatement("DELETE FROM client where id = ?");
				ps.setInt(1, id);
				if(ps.executeUpdate()>0) {
					System.out.println("Client supprime");
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				System.out.println("supprimer tout d'abord les commandes de ce client");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Client> listClients() {
		List<Client> clients= new ArrayList<Client>();
		try {
			Connection cnx=SingletonConnection.getConnexion();
			PreparedStatement ps;
			try {
				ps = cnx.prepareStatement("SELECT * FROM `client` ");
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					Client c=new Client();
					c.setId(rs.getInt("id"));
					c.setAdresse(rs.getString("adresse"));
					c.setNom(rs.getString("nom"));
					c.setPrenom(rs.getString("prenom"));
					c.setTelephone(rs.getString("telephone"));
					c.setVille(rs.getString("ville"));
					c.setEmail(rs.getString("email"));
					clients.add(c);
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clients;
	}



}
