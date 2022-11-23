package ma.fstt.entities;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Client{
	
	private int id;
	private String nom;
	private String prenom;
	private String adresse;
	private String tel;
	private String ville;
	
	
	
	
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	} 
	
	public Client(String nomCli, String prenomCli, String adresseCli, String telCli, String villeCli) {
		super();
		this.nom = nomCli;
		this.prenom = prenomCli;
		this.adresse = adresseCli;
		this.tel = telCli;
		this.ville = villeCli;
	}



	public Client(int idCli, String nomCli, String prenomCli, String adresseCli, String telCli, String villeCli) {
		super();
		this.id = idCli;
		this.nom = nomCli;
		this.prenom = prenomCli;
		this.adresse = adresseCli;
		this.tel = telCli;
		this.ville = villeCli;
	}


	public int getIdCli() {
		return id;
	}


	public void setIdCli(int idCli) {
		this.id = idCli;
	}


	public String getNomCli() {
		return nom;
	}


	public void setNomCli(String nomCli) {
		this.nom = nomCli;
	}


	public String getPrenomCli() {
		return prenom;
	}


	public void setPrenomCli(String prenomCli) {
		this.prenom = prenomCli;
	}


	public String getAdresseCli() {
		return adresse;
	}


	public void setAdresseCli(String adresseCli) {
		this.adresse = adresseCli;
	}


	public String getTelCli() {
		return tel;
	}


	public void setTelCli(String telCli) {
		this.tel = telCli;
	}


	public String getVilleCli() {
		return ville;
	}


	public void setVilleCli(String villeCli) {
		this.ville = villeCli;
	}
	
	
	
	
}