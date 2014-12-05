/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.SupAgile.jpa;

import com.supinfo.SupAgile.dao.DaoUtilisateur;
import com.supinfo.SupAgile.entity.Message;
import com.supinfo.SupAgile.entity.Utilisateurs;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Frede
 */
public class JpaDaoUtilisateur implements DaoUtilisateur{

    @PersistenceContext
    EntityManager em ;
  
    @Override
    public void AddUtilisateur(Utilisateurs utilisateur) {
        
    }

    @Override
    public Utilisateurs GetUtilisateurById(int id) {
        
        return null;
    }

    @Override
    public Utilisateurs checkUsers(String username, String password) {
        
       TypedQuery<Utilisateurs> typedQuery = em.createQuery("SELECT u from Utilisateurs u WHERE u.password=:password AND u.username=:username ",Utilisateurs.class);
       typedQuery.setParameter("password",password);
       typedQuery.setParameter("username",username);

        Utilisateurs util = null;
        try{
             util = typedQuery.getSingleResult();
         } catch (Exception ex) {
            System.out.println("MEESSSSAGGGGGEEEE A NULLLL");
        }       
        return util;   
    }
    
}
