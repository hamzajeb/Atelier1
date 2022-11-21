package ma.fstt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ma.fstt.entities.Commande;
import ma.fstt.entities.LignesCommande;
import ma.fstt.service.LignesCommandeRepositpry;

public class LignesCommandeDao implements LignesCommandeRepositpry{

	@Override
	public LignesCommande getById(int id) {
		LignesCommande ligneCmd= new LignesCommande();
		try {
			Connection cnx=SingletonConnection.getConnexion();
			PreparedStatement ps;
			try {
				ps = cnx.prepareStatement("SELECT * FROM `lignecommande` WHERE id = ?");
				ps.setInt(1, id);
				ResultSet rs=ps.executeQuery();
				if(rs.next()){
					ligneCmd.setId(rs.getInt("id"));
					ligneCmd.setNumLigne(rs.getString("numLigne"));
					ligneCmd.setQteCommande(rs.getInt("qteCommande"));
					ligneCmd.setCommandeId(rs.getInt("commande_id"));
					ligneCmd.setProduitId(rs.getInt("produit_id"));
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ligneCmd;
	}

	@Override
	public void ajouterLigne(LignesCommande ligne) {
		try {
			Connection cnx=SingletonConnection.getConnexion();
			PreparedStatement ps;
			try {
				ps = cnx.prepareStatement("INSERT INTO lignecommande (numLigne, qteCommande, commande_id ,produit_id) VALUES (?, ?, ?, ?)");
				ps.setString(1,ligne.getNumLigne());
				ps.setInt(2,ligne.getQteCommande());
				ps.setInt(3,ligne.getCommandeId());
				ps.setInt(4,ligne.getProduitId());

				if(ps.executeUpdate()>0) {
					System.out.println("Ligne Enregistre");
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
	public void modifierLigne(int id, LignesCommande ligne) {
		try {
			Connection cnx=SingletonConnection.getConnexion();
			PreparedStatement ps;
			try {
				ps = cnx.prepareStatement("UPDATE lignecommande SET numLigne = ?,qteCommande = ?,commande_id = ?,produit_id = ? WHERE id = ?");
				ps.setString(1,ligne.getNumLigne());
				ps.setInt(2,ligne.getQteCommande());
				ps.setInt(3,ligne.getCommandeId());
				ps.setInt(4,ligne.getProduitId());
				ps.setInt(5, id);

				if(ps.executeUpdate()>0) {
					System.out.println("Ligne modifie");
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
	public void supprimerLigne(int id) {
		try {
			Connection cnx=SingletonConnection.getConnexion();
			PreparedStatement ps;
			try {
				ps = cnx.prepareStatement("DELETE FROM lignecommande where id = ?");
				ps.setInt(1, id);
				if(ps.executeUpdate()>0) {
					System.out.println("ligne supprime");
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
	public List<LignesCommande> listDesLignes(int id) {
		List<LignesCommande> lignes= new ArrayList<LignesCommande>();
		try {
			Connection cnx=SingletonConnection.getConnexion();
			PreparedStatement ps;
			try {
				ps = cnx.prepareStatement("SELECT * FROM `lignecommande` where commande_id = ?");
				ps.setInt(1, id);
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					LignesCommande ligne=new LignesCommande();
					ligne.setId(rs.getInt("id"));
					ligne.setNumLigne(rs.getString("numLigne"));
					ligne.setQteCommande(rs.getInt("qteCommande"));
					ligne.setProduitId(rs.getInt("produit_id"));
					ligne.setCommandeId(rs.getInt("commande_id"));
					lignes.add(ligne);
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lignes;
	}

}
