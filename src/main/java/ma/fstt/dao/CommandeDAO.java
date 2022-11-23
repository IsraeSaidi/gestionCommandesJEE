package ma.fstt.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import ma.fstt.entities.Commande;
import ma.fstt.services.ClientRepository;
import ma.fstt.services.CommandeRepository;

public class CommandeDAO implements CommandeRepository {

	public Connection connexion = ConnexionBDD.connect();
	public static final CommandeDAO commandeDAO = new CommandeDAO();
	
	public static ClientRepository clientRepository = new ClientDAO();
	
	

	public Connection getConnexion() {
		return connexion;
	}

	public void setConnexion(Connection connexion) {
		this.connexion = connexion;
	}
	
	
	public static CommandeDAO getCommandeDAO() {
		return commandeDAO;
	}

	@Override
	public Commande trouverById(int id) {
		String request = "select * from commande where id_cmd = ?";
		Commande commande = new Commande();
		try {
			PreparedStatement preparedStatement = connexion.prepareStatement(request);
			preparedStatement.setInt(1, id);
			ResultSet result = preparedStatement.executeQuery();
			
			 while(result.next()) {						
				 commande = new Commande(result.getInt(1), result.getDate(2),clientRepository.trouverById(result.getInt(3)));
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return commande;
	}

	@Override
	public void ajouterCommande(Commande commande) {
		String request = "insert into commande (date_cmd, id_cli) values (?, ?)";
		
		try {
			PreparedStatement preparedStatement = connexion.prepareStatement(request);
			preparedStatement.setDate(1, (Date) commande.getDateCmd());
			preparedStatement.setInt(2, commande.getClient().getIdCli());
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void modifierCommande(Commande commande) {
		String request = "update commande set date_cmd = ?, id_cli = ? where id_cmd = ?";
		
		try {
			PreparedStatement preparedStatement = connexion.prepareStatement(request);
			preparedStatement.setDate(1, (Date) commande.getDateCmd());
			preparedStatement.setInt(2, commande.getClient().getIdCli());
			preparedStatement.setInt(3, commande.getIdCmd());
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void supprimerCommande(Commande commande) {
		String request = "delete from commande where id_cmd = ?";
		try {
			PreparedStatement preparedStatement = connexion.prepareStatement(request);
			preparedStatement.setInt(1, commande.getIdCmd());
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Commande> toutCommandes() {
		String request ="select * from Commande";
		List<Commande> listeCommandes = new ArrayList<Commande>();
		try {
			Statement statement = connexion.createStatement();
			ResultSet result = statement.executeQuery(request);
			
			while(result.next()) {	
				listeCommandes.add(new Commande(result.getInt(1) ,result.getDate(2), clientRepository.trouverById(result.getInt(3))));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
				return listeCommandes;
	}

	@Override
	public Commande derniereCommande() {
		String request = "select * from commande order by id_cmd desc limit 1";
		
		Commande cmd = new Commande();
					try {
						Statement statement = connexion.createStatement();	
						PreparedStatement preparedStatement = connexion.prepareStatement(request);
						ResultSet result = statement.executeQuery(request);									 
						result.next();	
							 cmd = new Commande(result.getInt(1), result.getDate(2) ,clientRepository.trouverById(result.getInt(3)));
									 
						 
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}				
			return cmd;
		
	}

}
