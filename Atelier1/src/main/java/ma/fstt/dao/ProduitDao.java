package ma.fstt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import ma.fstt.entities.Client;
import ma.fstt.entities.Produit;
import ma.fstt.service.ClientRepository;
import ma.fstt.service.ProduitRepository;

@ApplicationScoped
public class ProduitDao implements ProduitRepository{

	@Override
	public Produit getById(int id) {
		Produit produit= new Produit();
		try {
			Connection cnx=SingletonConnection.getConnexion();
			PreparedStatement ps;
			try {
				ps = cnx.prepareStatement("SELECT * FROM `produit` WHERE id = ?");
				ps.setInt(1, id);
				ResultSet rs=ps.executeQuery();
				if(rs.next()){
					produit.setId(rs.getInt("id"));
					produit.setCodeProduit(rs.getString("codeProduit"));
					produit.setNomProduit(rs.getString("nomProduit"));
					produit.setPrix(rs.getDouble("prix"));
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return produit;
	}

	@Override
	public void ajouterProduit(Produit c) {
		// TODO Auto-generated method stub
		try {
			Connection cnx=SingletonConnection.getConnexion();
			PreparedStatement ps;
			try {
				ps = cnx.prepareStatement("INSERT INTO produit (codeProduit,nomProduit,prix) VALUES (?, ?, ?)");
				ps.setString(1,c.getCodeProduit() );
				ps.setString(2,c.getNomProduit() );
				ps.setDouble(3,c.getPrix() );
				if(ps.executeUpdate()>0) {
					System.out.println("Produit enregistre");
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
	public void modifierProduit(int id, Produit c) {
		try {
			Connection cnx=SingletonConnection.getConnexion();
			PreparedStatement ps;
			try {
				ps = cnx.prepareStatement("UPDATE produit SET codeProduit = ?, nomProduit = ?, prix= ? WHERE id = ?");
				ps.setString(1,c.getCodeProduit() );
				ps.setString(2,c.getNomProduit() );
				ps.setDouble(3,c.getPrix() );
				ps.setInt(4, id);
				if(ps.executeUpdate()>0) {
					System.out.println("Produit modifie");
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
	public void supprimerProduit(int id) {
		try {
			Connection cnx=SingletonConnection.getConnexion();
			PreparedStatement ps;
			try {
				ps = cnx.prepareStatement("DELETE FROM produit where id = ?");
				ps.setInt(1, id);
				if(ps.executeUpdate()>0) {
					System.out.println("produit supprime");
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				System.out.println("imp");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Produit> listProduits() {
		List<Produit> produits= new ArrayList<Produit>();
		try {
			Connection cnx=SingletonConnection.getConnexion();
			PreparedStatement ps;
			try {
				ps = cnx.prepareStatement("SELECT * FROM `produit` ");
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					Produit produit=new Produit();
					produit.setId(rs.getInt("id"));
					produit.setCodeProduit(rs.getString("codeProduit"));
					produit.setNomProduit(rs.getString("nomProduit"));
					produit.setPrix(rs.getDouble("prix"));
					produits.add(produit);
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return produits;
	}

}
