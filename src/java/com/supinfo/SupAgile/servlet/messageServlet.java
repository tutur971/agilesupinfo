/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.SupAgile.servlet;

import com.supinfo.SupAgile.dao.DaoMessage;
import com.supinfo.SupAgile.entity.Message;
import com.supinfo.SupAgile.entity.Utilisateurs;
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
@WebServlet(name = "messageServlet", urlPatterns = {"/authUser/message"})
public class messageServlet extends HttpServlet {
    
       @EJB
       private DaoMessage daoMessage;
       
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
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        Utilisateurs users = (Utilisateurs)session.getAttribute("sessionUserObject");

        String messageString = request.getParameter("message");
        Message message = new Message();
        message.setMessage(messageString);
        message.setUser_id(users);
        
            daoMessage.AddMessage(message);
        
            RequestDispatcher rd = request.getRequestDispatcher("/authUser/Profil");

            try {
                rd.forward(request, response);
            } catch (ServletException ex) {
                Logger.getLogger(AuthentificationServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(AuthentificationServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
