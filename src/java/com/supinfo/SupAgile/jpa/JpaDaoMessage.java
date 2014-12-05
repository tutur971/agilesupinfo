/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.SupAgile.jpa;

import com.supinfo.SupAgile.dao.DaoMessage;
import com.supinfo.SupAgile.entity.Message;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Frede
 */
@Stateless
public class JpaDaoMessage implements DaoMessage {
  @PersistenceContext
    EntityManager em ;

    @Override
    public void AddMessage(Message message) {
    em.persist(message);
    }

    @Override
    public List<Message> GetMessageById(long id) {
                
       TypedQuery<Message> typedQuery = em.createQuery("SELECT m from Message m WHERE m.USER_ID_ID=:id",Message.class);
       typedQuery.setParameter("id",id);
        // récueprer un objet getsingle result
        List<Message> message = null;
        try{
             message = typedQuery.getResultList();
         } catch (Exception ex) {
            System.out.println("MEESSSSAGGGGGEEEE A NULLLL");
        }       
        return message;    
    }
    
  
  
}
