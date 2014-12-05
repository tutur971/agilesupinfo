/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.SupAgile.servlet;

import com.supinfo.SupAgile.dao.DaoUtilisateur;
import com.supinfo.SupAgile.entity.Utilisateurs;
import com.supinfo.SupAgile.jpa.JpaDaoUtilisateur;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "AuthentificationServlet", urlPatterns = {"/authentification"})
public class AuthentificationServlet extends HttpServlet {

    @EJB
    private DaoUtilisateur daoUtilisateur;
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
        System.out.println(" DDDDDDOOOOOOOGGGGGGGEEEEEETTTTTTT");
    }
    
    private void redirection(String messageConnexion, HttpServletRequest request, HttpServletResponse response,String root ){
            
            request.setAttribute("messageConnexion", messageConnexion);
            RequestDispatcher rd = request.getRequestDispatcher(root);

            try {
                rd.forward(request, response);
            } catch (ServletException ex) {
                Logger.getLogger(AuthentificationServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(AuthentificationServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
        HttpSession session = request.getSession();
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String messageConnexion="";
       
        // requete SQL qui vérifie si  l'utilisateur existe dans la table contact.
        //quel type c'est UTILISATEUR ou ADMIN
        System.out.println("JPAAAA DAOOO TROUVEEERRRR");

        Utilisateurs users = getDaoUtilisateur().checkUsers(email, password);
        
        if(users != null ){
            
            session.setAttribute("sessionUtilistaeur", email);
            System.out.println("Login USERSSSSSSSSSSSSSSSSSSSSSSSSSS");
            messageConnexion = "Connexion Sucess";
            redirection(messageConnexion,request,response,"/authUser/Profil");
        
        } else {
            System.out.println("REDIRECTION  redirection");
            messageConnexion = "Une erreur est survenu lors de la connexion";
            redirection(messageConnexion,request,response,"/index.jsp");           
        } 
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

    /**
     * @return the daoUtilisateur
     */
    public DaoUtilisateur getDaoUtilisateur() {
        return daoUtilisateur;
    }

}
