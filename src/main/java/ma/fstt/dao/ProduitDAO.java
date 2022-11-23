package ma.fstt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import ma.fstt.entities.Produit;
import ma.fstt.services.ProduitRepository;

public class ProduitDAO implements ProduitRepository {
	
public Connection connexion = ConnexionBDD.connect();
public static final ProduitDAO produitDAO = new ProduitDAO();

    
	
	public Connection getConnexion() {
		return connexion;
	}

	public void setConnexion(Connection connexion) {
		this.connexion = connexion;
	}
	
	public static ProduitDAO getProduitDAO() {
		return	produitDAO;
	}
	

	@Override
	public Produit trouverById(int id) {
		String request = "select * from produit where id_prod = ?";
		Produit produit = new Produit();
		try {
	
			PreparedStatement preparedStatement = connexion.prepareStatement(request);
			preparedStatement.setInt(1,id);
			ResultSet result = preparedStatement.executeQuery();
			
			 while(result.next()) {						
				 produit = new Produit(result.getInt(1), result.getString(2), result.getDouble(3), result.getInt(4));
			 }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	return produit;
			
	}

	@Override
	public void ajouterProduit(Produit produit) {
		String request = "insert into produit(nom_prod, prix_unitaire, qte_stock) values (?, ?, ?)";
		
		try {
			PreparedStatement preparedStatement = connexion.prepareStatement(request);
			preparedStatement.setString(1, produit.getNomProd());
			preparedStatement.setDouble(2, produit.getPrixUnitaire());
			preparedStatement.setInt(3, produit.getQteStock());
			preparedStatement.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void modifierProduit(Produit produit) {
		String request = "update produit set nom_prod = ?, prix_unitaire = ?, qte_stock = ?  where id_prod = ?";
		try {
			PreparedStatement preparedStatement = connexion.prepareStatement(request);
			preparedStatement.setString(1, produit.getNomProd());
			preparedStatement.setDouble(2, produit.getPrixUnitaire());
			preparedStatement.setInt(3, produit.getQteStock());
			preparedStatement.setInt(4, produit.getIdProd());
			
			preparedStatement.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void supprimerProduit(Produit produit) {
		String request = "delete from produit where id_prod = ?";

		try {
			PreparedStatement preparedStatement = connexion.prepareStatement(request);
			preparedStatement.setInt(1, produit.getIdProd());
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Produit> toutProduits() {
		
		String request ="select * from produit";
		List<Produit> listeProduits = new ArrayList<Produit>();
		try {
			Statement statement = connexion.createStatement();
			ResultSet result = statement.executeQuery(request);
			
			while(result.next()) {	
				listeProduits.add(new Produit(result.getInt(1) ,result.getString(2),result.getDouble(3),result.getInt(4)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
				return listeProduits;
	}
	
	
	
	
	
	

}
