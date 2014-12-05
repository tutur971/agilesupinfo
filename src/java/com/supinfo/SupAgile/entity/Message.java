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
        return "com.supinfo.SupAgile.entity.Message[ id=" + id + " ]";
    }
    
}
