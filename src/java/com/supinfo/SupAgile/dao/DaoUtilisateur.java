/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.SupAgile.dao;

import com.supinfo.SupAgile.entity.Utilisateurs;

/**
 *
 * @author Frede
 */
public interface DaoUtilisateur {
    
    public void AddUtilisateur(Utilisateurs utilisateur);
    public Utilisateurs GetUtilisateurById(int id );
    
}
