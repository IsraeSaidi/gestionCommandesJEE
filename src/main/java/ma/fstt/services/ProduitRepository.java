package ma.fstt.services;

import java.util.List;

import ma.fstt.entities.Produit;

public interface ProduitRepository {
	
	public Produit trouverById(int id);
	
	public void ajouterProduit(Produit produit);
	
	public void modifierProduit(Produit produit);
	
	public void supprimerProduit(Produit produit);

	public List<Produit> toutProduits();


}


