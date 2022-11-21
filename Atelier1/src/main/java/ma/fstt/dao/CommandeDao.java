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
import ma.fstt.service.CommandeRepository;


@ApplicationScoped
public class CommandeDao implements CommandeRepository{

	@Override
	public Commande getById(int id) {
		Commande cmd= new Commande();
		try {
			Connection cnx=SingletonConnection.getConnexion();
			PreparedStatement ps;
			try {
				ps = cnx.prepareStatement("SELECT * FROM `commande` WHERE id = ?");
				ps.setInt(1, id);
				ResultSet rs=ps.executeQuery();
				if(rs.next()){
					cmd.setId(rs.getInt("id"));
					cmd.setCodeCmd(rs.getString("codeCmd"));
					cmd.setDateCmd(rs.getString("dateCmd"));
					cmd.setClientId(rs.getInt("client_id"));
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cmd;
	}

	@Override
	public void ajouterCommande(Commande c) {
		try {
			Connection cnx=SingletonConnection.getConnexion();
			PreparedStatement ps;
			try {
				ps = cnx.prepareStatement("INSERT INTO commande (codeCmd, dateCmd, client_id) VALUES (?, ?, ?)");
				ps.setString(1,c.getCodeCmd() );
				ps.setString(2,c.getDateCmd() );
				ps.setInt(3,c.getClientId());

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
	public void modifierCommande(int id, Commande c) {
		try {
			Connection cnx=SingletonConnection.getConnexion();
			PreparedStatement ps;
			try {
				ps = cnx.prepareStatement("UPDATE commande SET codeCmd = ?, dateCmd = ? WHERE id = ?");
				ps.setString(1, c.getCodeCmd());
				ps.setString(2, c.getDateCmd());
				ps.setInt(3, id);

				if(ps.executeUpdate()>0) {
					System.out.println("Commande modifie");
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
	public void supprimerCommande(int id) {
		try {
			Connection cnx=SingletonConnection.getConnexion();
			PreparedStatement ps;
			try {
				ps = cnx.prepareStatement("DELETE FROM commande where id = ?");
				ps.setInt(1, id);
				if(ps.executeUpdate()>0) {
					System.out.println("Commande supprime");
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
	public List<Commande> listCommandes(int id) {
		List<Commande> commandes= new ArrayList<Commande>();
		try {
			Connection cnx=SingletonConnection.getConnexion();
			PreparedStatement ps;
			try {
				ps = cnx.prepareStatement("SELECT * FROM `commande` where client_id = ?");
				ps.setInt(1, id);
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					Commande c=new Commande();
					c.setId(rs.getInt("id"));
					
					c.setCodeCmd(rs.getString("codeCmd"));
					c.setDateCmd(rs.getString("dateCmd"));
					commandes.add(c);
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return commandes;
	}

}
