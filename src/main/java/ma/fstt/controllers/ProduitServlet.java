package ma.fstt.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ma.fstt.dao.ProduitDAO;
import ma.fstt.entities.Produit;
import ma.fstt.services.ProduitRepository;

/**
 * Servlet implementation class ProduitServlet
 */


@WebServlet("/Produit")
public class ProduitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Produit produit;
	
       
	@Inject 
	public ProduitRepository produitRepository=  ProduitDAO.getProduitDAO() ;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProduitServlet() {
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
		
			case "ajouterProduit":
				ajouterProduit(request, response);
				break;
				
			case "modifierProduit":
				modifierProduit(request, response);
				break;
				
			case "editProduit":
				editProduit(request, response);
				break;
				
			case "supprimerProduit":
				action  =	action!= null ? request.getParameter("action")  : "";
				supprimerProduit(request, response);
				break;
			
			
			default:
				produits(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	
	
	private void ajouterProduit(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		
		String nom = request.getParameter("nom");
		double prix = Double.parseDouble(request.getParameter("prix"));
		int qte = Integer.parseInt(request.getParameter("qte"));
		
		produit = new Produit(nom, prix, qte) ;
		produitRepository.ajouterProduit(produit);
		
		request.getRequestDispatcher("Produit?action=produits").forward(request, response);

	}
	
	private void modifierProduit(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		String nom = request.getParameter("nom");
		double prix = Double.parseDouble(request.getParameter("prix"));
		int qte = Integer.parseInt(request.getParameter("qte"));
		
		produit = new Produit(id, nom, prix, qte) ;
		produitRepository.modifierProduit(produit);
		response.sendRedirect("Produit?action=produits");
	}
	
	
	private void editProduit( HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		
		String[] req = request.getParameter("action").split("=");
		
		int id = Integer.parseInt(req[1]);
	
		Produit prod = produitRepository.trouverById(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("AjouterProduit.jsp");
		request.setAttribute("prod", prod);
		dispatcher.forward(request, response);

	}
	
	
	private void supprimerProduit(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		
		String[] req = request.getParameter("action").split("=");
	
		int id = Integer.parseInt(req[1]);
		Produit prod = produitRepository.trouverById(id);
		produitRepository.supprimerProduit(prod);
		response.sendRedirect("Produit?action=produits");

	}

	private void produits(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		
		List<Produit> listeProduits = produitRepository.toutProduits();
		request.setAttribute("listeProduits", listeProduits);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ListeProduits.jsp");
		dispatcher.forward(request, response);
		
	}

	

	

}
