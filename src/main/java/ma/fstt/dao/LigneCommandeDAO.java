package ma.fstt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ma.fstt.entities.Commande;
import ma.fstt.entities.LigneCommande;
import ma.fstt.entities.Produit;
import ma.fstt.services.CommandeRepository;
import ma.fstt.services.LigneCommandeRepository;
import ma.fstt.services.ProduitRepository;

public class LigneCommandeDAO implements LigneCommandeRepository {

public Connection connexion = ConnexionBDD.connect();
public static CommandeRepository commandeRepository = new CommandeDAO();
public static ProduitRepository produitRepository = new ProduitDAO();

public static final LigneCommandeDAO ligneCommandeDAO = new LigneCommandeDAO();
	
	public Connection getConnexion() {
		return connexion;
	}

	public void setConnexion(Connection connexion) {
		this.connexion = connexion;
	}
	
	
	public static LigneCommandeDAO getLignecommandeDAO() {
		return ligneCommandeDAO;
	}

	@Override
	public LigneCommande trouverById(int id) {
		String request = "select * from ligne_commande where id_lignecmd = ?";
		LigneCommande ligneCommande = new LigneCommande();
		try {
	
			PreparedStatement preparedStatement = connexion.prepareStatement(request);
			preparedStatement.setInt(1,id);
			ResultSet result = preparedStatement.executeQuery();
			
			 while(result.next()) {						
				 ligneCommande = new LigneCommande(result.getInt(1), result.getInt(2), commandeRepository.trouverById(result.getInt(3)),produitRepository.trouverById(result.getInt(4)));
			 }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	return ligneCommande;
	}

	@Override
	public void ajouterLignCommande(LigneCommande ligneCommande) {
		String request = "insert into ligne_commande (qte_produit, id_cmd, id_prod) values (?, ?, ?)";
		
		try {
			PreparedStatement preparedStatement = connexion.prepareStatement(request);
			preparedStatement.setInt(1,ligneCommande.getQteProd());
			preparedStatement.setInt(2, ligneCommande.getCommande().getIdCmd());
			preparedStatement.setInt(3, ligneCommande.getProduit().getIdProd());
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void modifierLigneCommande(LigneCommande ligneCommande) {
		String request = "update ligne_commande set qte_produit = ?, id_cmd = ?, id_prod = ? where id_lignecmd = ?";
		
		try {
			PreparedStatement preparedStatement = connexion.prepareStatement(request);
			preparedStatement.setInt(1,ligneCommande.getQteProd());
			preparedStatement.setInt(2, ligneCommande.getCommande().getIdCmd());
			preparedStatement.setInt(3, ligneCommande.getProduit().getIdProd());
			preparedStatement.setInt(4, ligneCommande.getIdLigneCmd());
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void supprimerLigneCommande(LigneCommande ligneCommande) {
		
		String request = "delete from ligne_commande where id_lignecmd = ?";
		try {
			PreparedStatement preparedStatement = connexion.prepareStatement(request);
			preparedStatement.setInt(1, ligneCommande.getIdLigneCmd());
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<LigneCommande> toutLigneCommandes() {
		String request ="select * from ligne_commande";
		List<LigneCommande> listeLigneCommandes = new ArrayList<LigneCommande>();
		try {
			Statement statement = connexion.createStatement();
			ResultSet result = statement.executeQuery(request);
			
			while(result.next()) {	
				listeLigneCommandes.add(new LigneCommande(result.getInt(1) ,result.getInt(2), commandeRepository.trouverById(result.getInt(3)),produitRepository.trouverById(result.getInt(4))));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
				return listeLigneCommandes;
	}

	@Override
	public List<LigneCommande> ligneCommandesDeCommande(int idCmd) {
		String request ="select * from ligne_commande where id_cmd = ?";
		List<LigneCommande> list = new ArrayList<LigneCommande>() ;
		
		try {	
			PreparedStatement preparedStatement = connexion.prepareStatement(request);
			preparedStatement.setInt(1,idCmd);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			Commande commande = commandeRepository.trouverById(idCmd);
		
			while(resultSet.next()) {
				Produit produit  = produitRepository.trouverById(resultSet.getInt(4));			
				list.add(new LigneCommande(resultSet.getInt(1), resultSet.getInt(2), commande, produit));
				}	
			
			resultSet.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
