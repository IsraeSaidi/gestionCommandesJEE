package ma.fstt.entities;

import java.util.Date;

import javax.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class Commande {
	
	private int id;
	private Date date;
	private Client client;
	
	
	public Commande(int idCmd, Date dateCmd, Client client) {
		super();
		this.id = idCmd;
		this.date = dateCmd;
		this.client = client;
	}
	
	public Commande( Date dateCmd, Client client) {
		super();
		this.date = dateCmd;
		this.client = client;
	}
	
	
	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getIdCmd() {
		return id;
	}
	
	public void setIdCmd(int idCmd) {
		this.id = idCmd;
	}
	
	public Date getDateCmd() {
		return date;
	}
	
	public void setDateCmd(Date dateCmd) {
		this.date = dateCmd;
	}
	
	public Client getClient() {
		return client;
	}
	
	public void setClient(Client client) {
		this.client = client;
	}
	
	
}
