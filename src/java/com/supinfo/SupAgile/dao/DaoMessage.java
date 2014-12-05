/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.SupAgile.dao;

import com.supinfo.SupAgile.entity.Message;
import java.util.List;

/**
 *
 * @author Frede
 */
public interface DaoMessage {
  
   public void AddMessage(Message message);
   public List<Message> GetMessageById(long id);
    
}
