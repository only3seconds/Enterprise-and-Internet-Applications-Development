/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5192.assignment.controller;

import fit5042.tutex.repository.ExchangeOperation;
import fit5042.tutex.repository.entities.Exchange;
import fit5192.assignment.navigation.Navigation;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author thinking
 */
@ManagedBean(name = "exchangeController")
public class ExchangeController implements Serializable {
    private int userId;
    
    private List<Exchange> exchangeList;
    
    
    
    @EJB
    private ExchangeOperation exchangeOperation;
    
    
    
    
    public String displayAllExchangesByuserId() {
        try {
            exchangeList = exchangeOperation.getAllExchangesByUserId(userId);
            
            return Navigation.exchange.toString();
            
        } catch (Exception ex) {
            ex.printStackTrace();
            return Navigation.exchange.toString();
        }       
    }
    
}
