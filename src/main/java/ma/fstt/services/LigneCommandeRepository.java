package ma.fstt.services;

import java.util.List;

import ma.fstt.entities.LigneCommande;

public interface LigneCommandeRepository {
	
	public LigneCommande trouverById(int id);
	
	public void ajouterLignCommande(LigneCommande ligneCommande);
	
	public void modifierLigneCommande(LigneCommande ligneCommande) ;

	public void supprimerLigneCommande(LigneCommande ligneCommande);
    
	public List<LigneCommande> toutLigneCommandes() ;
	
	public List<LigneCommande> ligneCommandesDeCommande(int idCmd);
	
	

}
