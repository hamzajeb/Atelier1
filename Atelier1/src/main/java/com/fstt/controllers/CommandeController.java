package com.fstt.controllers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ma.fstt.entities.Client;
import ma.fstt.entities.Commande;
import ma.fstt.entities.LignesCommande;
import ma.fstt.entities.Produit;
import ma.fstt.service.ClientRepository;
import ma.fstt.service.CommandeRepository;
import ma.fstt.service.LignesCommandeRepositpry;
import ma.fstt.service.ProduitRepository;

/**
 * Servlet implementation class CommandeController
 */
@WebServlet("/CommandeController")
public class CommandeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	@Inject
	private CommandeRepository CommandeRepo;
	
	@Inject
	private ClientRepository clientRepo;
	
	@Inject
	private ProduitRepository produitRepo;
	
	@Inject
	private LignesCommandeRepositpry lignesRepo;
	
    public CommandeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		System.out.println(action);	
		
		switch (action) {
		case "/":
    		request.setAttribute("listeClients", clientRepo.listClients());
    		request.getRequestDispatcher("listeClients.jsp").forward(request, response);
            break;
        case "/client/new":
        	request.getRequestDispatcher("nouveauClient.jsp").forward(request, response);
            break;
        case "/client/insert":
        	String nom=request.getParameter("nom");
        	String prenom=request.getParameter("prenom");
        	String email=request.getParameter("email");
        	String telephone=request.getParameter("telephone");
        	String adresse=request.getParameter("adresse");
        	String ville=request.getParameter("ville");
        	Client c= new Client(nom,prenom,email,adresse,ville,telephone);
        	clientRepo.ajouterClient(c);
        	response.sendRedirect("/Atelier1");
            break;
        case "/client/delete":
        	int id = Integer.parseInt(request.getParameter("id"));
        	clientRepo.supprimerClient(id);
        	response.sendRedirect("/Atelier1");
            break;
        case "/client/edit":
        	int id2 = Integer.parseInt(request.getParameter("id"));
        	Client cl=clientRepo.getById(id2);
        	request.setAttribute("client", cl);
        	request.getRequestDispatcher("nouveauClient.jsp").forward(request, response);
            break;
        case "/client/update":
        	int id1=Integer.parseInt(request.getParameter("id"));
        	String nom1=request.getParameter("nom");
        	String prenom1=request.getParameter("prenom");
        	String email1=request.getParameter("email");
        	String telephone1=request.getParameter("telephone");
        	String adresse1=request.getParameter("adresse");
        	String ville1=request.getParameter("ville");
        	Client c2= new Client(nom1,prenom1,email1,adresse1,ville1,telephone1);
        	clientRepo.modifierClient(id1, c2);
        	response.sendRedirect("/Atelier1");
            break;
        case "/Commande/liste":
        	int clientId=0;
        	if(request.getParameter("clientId")!=null) {
        	clientId = Integer.parseInt(request.getParameter("clientId"));
        	}else {
        		HttpSession session1 = request.getSession(true);
        		clientId=(int) session1.getAttribute("clientId");
        	}
        	HttpSession session = request.getSession(true);
        	session.setAttribute("clientId",clientId);
        	Client clt=clientRepo.getById(clientId);
        	session.setAttribute("nom",clt.getNom());
        	session.setAttribute("prenom",clt.getPrenom());
        	request.setAttribute("listeCommandes",CommandeRepo.listCommandes(clientId));
    		request.getRequestDispatcher("listeCommandes.jsp").forward(request, response);
            break;
        case "/Commande/new":
        	request.getRequestDispatcher("nouveauCommande.jsp").forward(request, response);
            break;
        case "/Commande/insert":
        	String codeCmd=request.getParameter("codeCmd");
        	 String dateCmd = request.getParameter("dateCmd");
 
        	HttpSession session1 = request.getSession(true);
        	int clientId2=(int) session1.getAttribute("clientId");
        	System.out.println(session1.getAttribute("clientId"));
        	Commande cmd= new Commande(codeCmd,dateCmd,clientId2);
        	CommandeRepo.ajouterCommande(cmd);
        	response.sendRedirect("/Atelier1/Commande/liste");
            break;
        case "/Commande/delete":
        	int idCmd = Integer.parseInt(request.getParameter("id"));
        	CommandeRepo.supprimerCommande(idCmd);
        	response.sendRedirect("/Atelier1/Commande/liste");
            break;
        case "/Commande/edit":
        	int idCmd1 = Integer.parseInt(request.getParameter("id"));
        	Commande commande=CommandeRepo.getById(idCmd1);

        	request.setAttribute("commande", commande);
        	request.getRequestDispatcher("nouveauCommande.jsp").forward(request, response);
            break;
        case "/Commande/update":
        	int cmdId=Integer.parseInt(request.getParameter("id"));
        	String codeCmd1=request.getParameter("codeCmd");
        	String dateCmd1=request.getParameter("dateCmd");
        	int clientId1=Integer.parseInt(request.getParameter("clientId"));
        	Commande cmd1= new Commande(codeCmd1,dateCmd1,clientId1);
        	CommandeRepo.modifierCommande(cmdId, cmd1);
        	response.sendRedirect("/Atelier1/Commande/liste");
            break;
		case "/produit/list":
    		request.setAttribute("listeProduits", produitRepo.listProduits());
    		request.getRequestDispatcher("listeProduits.jsp").forward(request, response);
            break;
        case "/produit/delete":
        	int idPr = Integer.parseInt(request.getParameter("id"));
        	produitRepo.supprimerProduit(idPr);
        	response.sendRedirect("/Atelier1/produit/list");
            break;
        case "/produit/insert":
        	String nomPr=request.getParameter("nomProduit");
        	String codePr=request.getParameter("codeProduit");
        	Double prix=Double.parseDouble(request.getParameter("prix"));
        	Produit pr= new Produit(nomPr,codePr,prix);
        	produitRepo.ajouterProduit(pr);
        	response.sendRedirect("/Atelier1/produit/list");
            break;
        case "/produit/new":
        	request.getRequestDispatcher("nouveauProduit.jsp").forward(request, response);
            break; 
        case "/produit/edit":
        	int idProduit = Integer.parseInt(request.getParameter("id"));
        	Produit pr1=produitRepo.getById(idProduit);
        	request.setAttribute("produit", pr1);
        	request.getRequestDispatcher("nouveauProduit.jsp").forward(request, response);
            break;
        case "/produit/update":
        	int produitdId=Integer.parseInt(request.getParameter("id"));
        	String nomPr3=request.getParameter("nomProduit");
        	String codePr3=request.getParameter("codeProduit");
        	Double prix3=Double.parseDouble(request.getParameter("prix"));
        	Produit pr3= new Produit(nomPr3,codePr3,prix3);
        	produitRepo.modifierProduit(produitdId, pr3);
        	response.sendRedirect("/Atelier1/produit/list");
            break;
        case "/LigneCommande/liste":
        	int commandeId=0;
        	if(request.getParameter("commandeId")!=null) {
        		commandeId = Integer.parseInt(request.getParameter("commandeId"));
        	}else {
        		HttpSession session2 = request.getSession(true);
        		commandeId=(int) session2.getAttribute("commandeId");
        	}
        	HttpSession session2 = request.getSession(true);
        	session2.setAttribute("commandeId",commandeId);
        	Commande command=CommandeRepo.getById(commandeId);
        	session2.setAttribute("codeCmd",command.getCodeCmd());
        	
        	session2.setAttribute("listeProduits", produitRepo.listProduits());
        	request.setAttribute("listeLignes",lignesRepo.listDesLignes(commandeId));
    		request.getRequestDispatcher("listeDesLignes.jsp").forward(request, response);
            break;
        case "/LigneCommande/new":
        	request.getRequestDispatcher("nouveauLigne.jsp").forward(request, response);
            break;
        case "/LigneCommande/insert":
        	String numLigne=request.getParameter("numLigne");
       	 	int qteProduit =Integer.parseInt(request.getParameter("qteCommande"));
       	 	int produitid =Integer.parseInt(request.getParameter("produitId"));
       	 	int commandeid =Integer.parseInt(request.getParameter("commandeId"));
	       	LignesCommande ligne= new LignesCommande(numLigne,qteProduit,produitid,commandeid);
	       	lignesRepo.ajouterLigne(ligne);
	       	response.sendRedirect("/Atelier1/LigneCommande/liste");
           break;
        case "/LigneCommande/delete":
        	int idligne = Integer.parseInt(request.getParameter("id"));
        	lignesRepo.supprimerLigne(idligne);
        	response.sendRedirect("/Atelier1/LigneCommande/liste");
            break; 
        case "/LigneCommande/edit":
        	int idln = Integer.parseInt(request.getParameter("id"));
        	LignesCommande ligne1=lignesRepo.getById(idln);

        	request.setAttribute("ligne", ligne1);
        	request.getRequestDispatcher("nouveauLigne.jsp").forward(request, response);
            break;
        case "/LigneCommande/update":
        	int ligneId=Integer.parseInt(request.getParameter("id"));
        	String numLigne1=request.getParameter("numLigne");
       	 	int qteProduit1 =Integer.parseInt(request.getParameter("qteCommande"));
       	 	int produitid1 =Integer.parseInt(request.getParameter("produitId"));
       	 	int commandeid1 =Integer.parseInt(request.getParameter("commandeId"));
	       	LignesCommande ligne2= new LignesCommande(numLigne1,qteProduit1,produitid1,commandeid1);
        	lignesRepo.modifierLigne(ligneId, ligne2);
        	response.sendRedirect("/Atelier1/LigneCommande/liste");
            break;
        default:

            break;
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
