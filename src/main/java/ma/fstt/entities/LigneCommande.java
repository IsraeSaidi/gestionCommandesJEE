package ma.fstt.entities;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LigneCommande {
	
	private int id ;
	private int qte;
	private Commande commande;
	private Produit produit;
	
	
	
	public LigneCommande(int idLigneCmd, int qteProd, Commande commande, Produit produit) {
		super();
		this.id = idLigneCmd;
		this.qte = qteProd;
		this.commande = commande;
		this.produit = produit;
	}
	
	public LigneCommande( int qteProd, Commande commande, Produit produit) {
		super();

		this.qte = qteProd;
		this.commande = commande;
		this.produit = produit;
	}

	public LigneCommande() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getIdLigneCmd() {
		return id;
	}

	public void setIdLigneCmd(int idLigneCmd) {
		this.id = idLigneCmd;
	}

	public int getQteProd() {
		return qte;
	}

	public void setQteProd(int qteProd) {
		this.qte = qteProd;
	}

	public Commande getCommande() {
		return commande;
	}
	
	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	
	
	
	

}
