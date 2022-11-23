package ma.fstt.services;

import java.util.List;

import ma.fstt.entities.Commande;


public interface CommandeRepository {
	
	public Commande trouverById(int id);

	public void ajouterCommande(Commande commande);
	
	public void modifierCommande(Commande commande);

	public void supprimerCommande(Commande commande);
    
	public List<Commande> toutCommandes();
	
	public Commande derniereCommande();
	
}
