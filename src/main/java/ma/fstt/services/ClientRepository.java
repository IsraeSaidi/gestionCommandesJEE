package ma.fstt.services;

import java.util.List;

import ma.fstt.entities.Client;

public interface ClientRepository {
	
	public Client trouverById(int id);
	
	public void ajouterClient(Client client);
	
	public void modifierClient(Client client);

	public void supprimerClient(Client client);
    
	public List<Client> toutClients();

}
