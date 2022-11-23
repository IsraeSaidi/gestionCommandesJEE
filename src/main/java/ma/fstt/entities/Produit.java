package ma.fstt.entities;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Produit {
	
	private int id;
	private String nom;
	private double prix;
	private int qte;
	
	
	public Produit(int idProd, String nomProd, double prixUnitaire, int qteStock) {
		super();
		this.id = idProd;
		this.nom = nomProd;
		this.prix = prixUnitaire;
		this.qte = qteStock;
	}
	
	public Produit( String nomProd, double prixUnitaire, int qteStock) {
		super();
		this.nom = nomProd;
		this.prix = prixUnitaire;
		this.qte = qteStock;
	}


	

	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}



	public int getIdProd() {
		return id;
	}


	public void setIdProd(int idProd) {
		this.id = idProd;
	}


	public String getNomProd() {
		return nom;
	}


	public void setNomProd(String nomProd) {
		this.nom = nomProd;
	}


	public double getPrixUnitaire() {
		return prix;
	}


	public void setPrixUnitaire(double prixUnitaire) {
		this.prix = prixUnitaire;
	}


	public int getQteStock() {
		return qte;
	}


	public void setQteStock(int qteStock) {
		this.qte = qteStock;
	}
	
	
	
	
	
	

}
