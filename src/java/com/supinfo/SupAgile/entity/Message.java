/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.SupAgile.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Gaetan
 */
@Entity
public class Message implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String message;
    @ManyToOne
    @JoinColumn
    private Utilisateurs user_id;
    
    @Override
    public String toString() {
        return "com.supinfo.SupAgile.entity.Message[ id=" + getId() + " ]";
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the user_id
     */
    public Utilisateurs getUser_id() {
        return user_id;
    }

    /**
     * @param user_id the user_id to set
     */
    public void setUser_id(Utilisateurs user_id) {
        this.user_id = user_id;
    }
    
}
