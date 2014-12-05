/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.SupAgile.jpa;

import com.supinfo.SupAgile.dao.DaoUtilisateur;
import com.supinfo.SupAgile.entity.Utilisateurs;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Frede
 */
@Stateless
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
        
        System.out.println("JJJJJJJJJJJEEEEEEEEEEEEE PASSSSSSSSSSSSSSSSSSSSSS "+username);
        System.out.println("JJJJJJJJJJJEEEEEEEEEEEEE PASSSSSSSSSSSSSSSSSSSSSSWORD "+password);

       TypedQuery<Utilisateurs> typedQuery = em.createQuery("SELECT u from Utilisateurs u WHERE u.password=:password AND u.email=:email ",Utilisateurs.class);
       typedQuery.setParameter("password",password);
       typedQuery.setParameter("email",username);

        Utilisateurs util = null;
        try{
             util = typedQuery.getSingleResult();
         } catch (Exception ex) {
            System.out.println("MEESSSSAGGGGGEEEE A NULLLL");
        }       
        return util;   
    }
}
