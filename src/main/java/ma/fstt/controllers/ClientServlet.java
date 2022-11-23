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
import ma.fstt.dao.ClientDAO;
import ma.fstt.entities.Client;
import ma.fstt.services.ClientRepository;


/**
 * Servlet implementation class ProduitServlet
 */

@WebServlet("/Client")
public class ClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Client client;
	
       
	@Inject 
	public ClientRepository clientRepository =  ClientDAO.getClientDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientServlet() {
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
		
			case "ajouterClient":
				ajouterClient(request, response);
				break;
				
			case "modifierClient":
				modifierClient(request, response);
				break;
				
			case "editClient":
				editClient(request, response);
				break;
				
			case "supprimerClient":
				action  =	action!= null ? request.getParameter("action")  : "";
				supprimerClient(request, response);
				break;
		
			
			default:
				clients(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	
	
	private void ajouterClient(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String adresse = request.getParameter("adresse");
		String tel = request.getParameter("tel");
		String ville = request.getParameter("ville");
		
		client = new Client(nom, prenom, adresse, tel, ville);
		clientRepository.ajouterClient(client);
		
		request.getRequestDispatcher("Client?action=clients").forward(request, response);

	}
	
	private void modifierClient(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String adresse = request.getParameter("adresse");
		String tel = request.getParameter("tel");
		String ville = request.getParameter("ville");
		
		client = new Client(id,nom, prenom, adresse, tel, ville);
		clientRepository.modifierClient(client);
		
		request.getRequestDispatcher("Client?action=clients").forward(request, response);
	}
	
	
	private void editClient( HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		
		String[] req = request.getParameter("action").split("=");
		
		int id = Integer.parseInt(req[1]);
	
		Client cli = clientRepository.trouverById(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("AjouterClient.jsp");
		request.setAttribute("cli", cli);
		dispatcher.forward(request, response);

	}
	
	
	private void supprimerClient(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		
		String[] req = request.getParameter("action").split("=");
	
		int id = Integer.parseInt(req[1]);
		Client cli = clientRepository.trouverById(id);
		clientRepository.supprimerClient(cli);
		response.sendRedirect("Client?action=clients");

	}

	private void clients(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		
		List<Client> listeClients = clientRepository.toutClients();
		request.setAttribute("listeClients", listeClients);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ListeClients.jsp");
		dispatcher.forward(request, response);
		
	}

	

	

}
