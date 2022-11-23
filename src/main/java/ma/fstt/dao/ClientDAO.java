package ma.fstt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ma.fstt.entities.Client;
import ma.fstt.services.ClientRepository;

public class ClientDAO implements ClientRepository{
	
	public Connection connexion = ConnexionBDD.connect();
	public static final ClientDAO clientDAO = new ClientDAO();
    
	
	public Connection getConnexion() {
		return connexion;
	}

	public void setConnexion(Connection connexion) {
		this.connexion = connexion;
	}
	
	
	public static ClientDAO getClientDAO() {
		return	clientDAO;
	}
	
	

	@Override
	public Client trouverById(int id) {
		String request = "select * from client where id_cli = ?";
		Client client = new Client();
		try {
	
			PreparedStatement preparedStatement = connexion.prepareStatement(request);
			preparedStatement.setInt(1,id);
			ResultSet result = preparedStatement.executeQuery();
			
			 while(result.next()) {						
				 client = new Client(result.getInt(1), result.getString(2), result.getString(3), result.getString(4),result.getString(5),result.getString(6));
				}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	return client;
			
	}

	@Override
	public void ajouterClient(Client client) {
		String request = "insert into client(nom_cli, prenom_cli, adresse_cli, tel_cli, ville_cli) values (?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement preparedStatement = connexion.prepareStatement(request);
			preparedStatement.setString(1, client.getNomCli());
			preparedStatement.setString(2, client.getPrenomCli());
			preparedStatement.setString(3, client.getAdresseCli());
			preparedStatement.setString(4, client.getTelCli());
			preparedStatement.setString(5, client.getVilleCli());
			preparedStatement.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void modifierClient(Client client) {
		String request = "update client set nom_cli = ?, prenom_cli= ?, adresse_cli = ?, tel_cli = ?, ville_cli = ? where id_cli = ?";
		try {
			PreparedStatement preparedStatement = connexion.prepareStatement(request);
			preparedStatement.setString(1, client.getNomCli());
			preparedStatement.setString(2, client.getPrenomCli());
			preparedStatement.setString(3, client.getAdresseCli());
			preparedStatement.setString(4, client.getTelCli());
			preparedStatement.setString(5, client.getVilleCli());
			preparedStatement.setInt(6, client.getIdCli());
			preparedStatement.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void supprimerClient(Client client) {
		String request = "delete from client where id_cli = ?";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connexion.prepareStatement(request);
			preparedStatement.setInt(1, client.getIdCli());
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Client> toutClients() {
		
		String request ="select * from client";
		List<Client> listeClients = new ArrayList<Client>();
		try {
			Statement statement = connexion.createStatement();
			ResultSet result = statement.executeQuery(request);
			
			while(result.next()) {	
				listeClients.add(new Client(result.getInt(1) ,result.getString(2),result.getString(3),result.getString(4),result.getString(5),result.getString(6)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
				return listeClients;
	}
	
	
	
	
	
	
}
