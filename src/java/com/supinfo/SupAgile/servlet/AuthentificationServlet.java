/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.SupAgile.servlet;

import com.supinfo.SupAgile.entity.Utilisateurs;
import com.supinfo.SupAgile.jpa.JpaDaoUtilisateur;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Gaetan
 */
@WebServlet(name = "AuthentificationServlet", urlPatterns = {"/AuthentificationS"})
public class AuthentificationServlet extends HttpServlet {

    @EJB
    JpaDaoUtilisateur jpaUtil;
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String password = request.getParameter("password");
        String username = request.getParameter("username");
        
        String messageConnexion="";
        
        // requete SQL qui vérifie si  l'utilisateur existe dans la table contact.
        //quel type c'est UTILISATEUR ou ADMIN
       // User user =null
        Utilisateurs users = jpaUtil.checkUsers(username,password);
        
        
        if(users != null ){
            
	session.setAttribute("sessionUtilistaeur", username);
	System.out.println("Login USERSSSSSSSSSSSSSSSSSSSSSSSSSS");
        messageConnexion = "Connexion Sucess";

        }else{
          messageConnexion = "Une erreur est survenu lors de la connexion";
        }
        
            request.setAttribute("messageConnexion", messageConnexion);
            RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
		
            try {
		rd.forward(request, response);

		} catch (ServletException e) {
			e.printStackTrace();
			System.out.println("Probleme forward dans doPost de LoginServlet");
		}
               
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
