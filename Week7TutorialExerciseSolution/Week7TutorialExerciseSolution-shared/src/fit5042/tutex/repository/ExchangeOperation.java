/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex.repository;

import fit5042.tutex.repository.entities.Exchange;
import fit5042.tutex.repository.entities.SubOrder;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author thinking
 */
@Remote
public interface ExchangeOperation {
    
    public List<Exchange> getAllExchangesByUserId(int userId) throws Exception;
    
    
    public void insertSubOrder(List<SubOrder> orderList);
    
    public int insertExchange(Exchange exchange);

}
