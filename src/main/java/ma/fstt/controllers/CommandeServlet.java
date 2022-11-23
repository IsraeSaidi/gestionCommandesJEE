package ma.fstt.controllers;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ma.fstt.dao.ClientDAO;
import ma.fstt.dao.CommandeDAO;
import ma.fstt.dao.LigneCommandeDAO;
import ma.fstt.dao.ProduitDAO;
import ma.fstt.entities.Client;
import ma.fstt.entities.Commande;
import ma.fstt.entities.LigneCommande;
import ma.fstt.entities.Produit;
import ma.fstt.services.ClientRepository;
import ma.fstt.services.CommandeRepository;
import ma.fstt.services.LigneCommandeRepository;
import ma.fstt.services.ProduitRepository;


@WebServlet("/Commande")
public class CommandeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Commande commande;
	
       
	@Inject 
	public CommandeRepository commandeRepository =  CommandeDAO.getCommandeDAO();
	@Inject 
	public ClientRepository clientRepository =  ClientDAO.getClientDAO();
	@Inject 
	public LigneCommandeRepository ligneCommandeRepository =  LigneCommandeDAO.getLignecommandeDAO();
	@Inject 
	public ProduitRepository produitRepository =  ProduitDAO.getProduitDAO();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommandeServlet() {
    	
        super();
        
       
        // TODO Auto-generated constructor stub
    }

    
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
		String action = request.getParameter("action");
		action  =	action!= null ? request.getParameter("action")  : "";
		
		if(action!= null) {
			action = action.split("\\?", 2)[0];
			
		}
		
		System.out.println(action);
		
		

		try {
			switch (action) {
		
			case "nouvelleCommande":
				lesClients(request, response);
			case "ajouterCommande":
				ajouterCommande(request, response);
				break;
				
			case "modifierCommande":
				modifierCommande(request, response);
				break;
				
			case "editCommande":
				editCommande(request, response);
				break;
				
			case "supprimerCommande":
				
				supprimerCommande(request, response);
				break;
			
			case "ligneCommandes":
				
				ligneCommandes(request, response);
				break;
				
			case "editLigneCom":
				
				editLigneCommande(request, response);
				break;
			
			case "modifierLigneCommande":
				
				modifierLigneCommande(request, response);
				break;
			case "supprimerLigneCommande":
				
				supprimerLigneCommande(request, response);
				break;	
				
				
			case "ajouterLigneCommande":
				
				ajouterLigneCommande(request, response);
				break;
				
			case "nouvelleLigneCommande":
				lesProds(request, response);
			default:
				commandes(request, response);
				
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	
	
	private void ajouterCommande(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		
		Commande commande;
		long millis=System.currentTimeMillis();  
		Date date = new Date(millis);
		if(request.getParameter("idClient")!=null) {
		int idClient = Integer.parseInt(request.getParameter("idClient"));
		
		System.out.println("Bonjour"+idClient);
		Client client = clientRepository.trouverById(idClient);
		
		commande = new Commande(date,client);
		commandeRepository.ajouterCommande(commande);
		Commande cmd = commandeRepository.derniereCommande();
		int idCmd = cmd.getIdCmd();
		System.out.println("heey"+cmd.getIdCmd());
		LigneCommande ligneCommande;
		String[] qte = request.getParameterValues("qte[]");
		List<String> quantites = new ArrayList<String>();
		
		for (int i = 0; i < qte.length; i++) {
			if (qte[i] != "")
				quantites.add(qte[i]);
		}
		
		String[] idProduit = request.getParameterValues("idProduit[]");

		for (int i = 0; i < idProduit.length; i++) {
		Produit prod = produitRepository.trouverById(Integer.parseInt(idProduit[i]));
		
	
		ligneCommande = new LigneCommande(Integer.parseInt(qte[i]), cmd, prod);
		ligneCommandeRepository.ajouterLignCommande(ligneCommande);
		}
		
		

		request.getRequestDispatcher("Commande?action=commandes").forward(request, response);
		}
	}
	
	private void modifierCommande(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException{
		
		int id = Integer.parseInt(request.getParameter("id"));
		int idClient = Integer.parseInt(request.getParameter("idClient"));
		Client client = clientRepository.trouverById(idClient);
		
		
		Date date = Date.valueOf(request.getParameter("date"));
		
		
	
		System.out.println(date);
		
		Commande commande = new Commande(id,date,client);
		commandeRepository.modifierCommande(commande);
		
		
		request.getRequestDispatcher("Commande?action=commandes").forward(request, response);
		
		
		
	}
	
	
	private void editCommande( HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		
		
String[] req = request.getParameter("action").split("=");
		

List<Client> listeClients = new ArrayList<Client>();
listeClients = clientRepository.toutClients();
request.setAttribute("listeClients", listeClients);
System.out.println(listeClients);


		int id = Integer.parseInt(req[1]);
	
		Commande com = commandeRepository.trouverById(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ModifierCommande.jsp");
		request.setAttribute("commande", com);
		dispatcher.forward(request, response);

	}
	
	
	private void supprimerCommande(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		
		String[] req = request.getParameter("action").split("=");
		
		int id = Integer.parseInt(req[1]);
		Commande com = commandeRepository.trouverById(id);
		commandeRepository.supprimerCommande(com);
		response.sendRedirect("Commande?action=commandes");

	}

	private void commandes(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		
		
	    
	     List<Commande> listeCommandes = new ArrayList<Commande>();
	     listeCommandes = commandeRepository.toutCommandes();
	     request.setAttribute("listeCommandes", listeCommandes);
	    
		 RequestDispatcher dispatcher = request.getRequestDispatcher("ListeCommandes.jsp");
		 dispatcher.forward(request, response);
		 
		
		 
		 
		
	}
	
	private void lesClients(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		
		List<Client> listeClients = new ArrayList<Client>();
	    listeClients = clientRepository.toutClients();
	    request.setAttribute("listeClients", listeClients);
	    System.out.println(listeClients);
	    List<Produit> listeProduits = new ArrayList<Produit>();
	    listeProduits = produitRepository.toutProduits();
	    request.setAttribute("listeProduits", listeProduits);
	   
	     RequestDispatcher dispatcher = request.getRequestDispatcher("AjouterCommande.jsp");
	    dispatcher.forward(request, response);
	    
	}
	
	private void ligneCommandes(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		
		String[] req = request.getParameter("action").split("=");
		
		int id = Integer.parseInt(req[1]);

		 List<LigneCommande> ligneCommandes = new ArrayList<LigneCommande>();
		 
		ligneCommandes = ligneCommandeRepository.ligneCommandesDeCommande(id);
	 
		
			 request.setAttribute("ligneCommandes", ligneCommandes);
			 
			 System.out.println(id);
			 RequestDispatcher dispatcher = request.getRequestDispatcher("LigneCommandes.jsp");
			
				dispatcher.forward(request, response);

			
		 }
	
	
	private void editLigneCommande( HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		
		
		String[] req = request.getParameter("action").split("=");
		

		List<Produit> listeProduits = new ArrayList<Produit>();
		listeProduits = produitRepository.toutProduits();
		request.setAttribute("listeProduits", listeProduits);

		int id = Integer.parseInt(req[1]);
	
		LigneCommande ligneCom = ligneCommandeRepository.trouverById(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ModifierLigneCommande.jsp");
		request.setAttribute("ligneCommande", ligneCom);
		dispatcher.forward(request, response);

	}
	
	
private void modifierLigneCommande(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException{
		
		int id = Integer.parseInt(request.getParameter("id"));
		int qte = Integer.parseInt(request.getParameter("qte"));
		
		int idCmd = Integer.parseInt(request.getParameter("idCmd"));
		Commande com = commandeRepository.trouverById(idCmd);
		
		int idProd  = Integer.parseInt(request.getParameter("idProd"));
		Produit prod = produitRepository.trouverById(idProd);
		
		
		
		LigneCommande ligneCommande = new LigneCommande(id,qte,com,prod);
		ligneCommandeRepository.modifierLigneCommande(ligneCommande);
		
		
		request.getRequestDispatcher("Commande?action=ligneCommandes?id="+idCmd).forward(request, response);
		

	}


private void supprimerLigneCommande(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
	
	String[] req = request.getParameter("action").split("=");
	
	int id = Integer.parseInt(req[1]);
	
	
	LigneCommande com = ligneCommandeRepository.trouverById(id);
	ligneCommandeRepository.supprimerLigneCommande(com);
	String referer = request.getHeader("Referer");
	response.sendRedirect(referer);

}


private void lesProds(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
	


	String referer = request.getHeader("Referer");
	String[] req = referer.split("=");
	
	int idCmd = Integer.parseInt(req[2]);
	System.out.print("commande" +idCmd);
	Commande cmd = commandeRepository.trouverById(idCmd);
	   request.setAttribute("commande", cmd);
    List<Produit> listeProduits = new ArrayList<Produit>();
    listeProduits = produitRepository.toutProduits();
    request.setAttribute("listeProduits", listeProduits);
   
     RequestDispatcher dispatcher = request.getRequestDispatcher("AjouterLigneCommande.jsp");
    dispatcher.forward(request, response);
    
}



private void ajouterLigneCommande(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
	

	LigneCommande ligneCommande;
	int qte = Integer.parseInt(request.getParameter("qte"));
	
	int idProduit = Integer.parseInt(request.getParameter("idProduit"));

	Produit prod = produitRepository.trouverById(idProduit);
	
	int idCmd = Integer.parseInt(request.getParameter("idCmd"));
	Commande cmd = commandeRepository.trouverById(idCmd);

	ligneCommande = new LigneCommande(qte, cmd, prod);
	ligneCommandeRepository.ajouterLignCommande(ligneCommande);

	response.sendRedirect("Commande?action=ligneCommandes?id="+idCmd);
	}
}




	
	
	
	
	

	

	


