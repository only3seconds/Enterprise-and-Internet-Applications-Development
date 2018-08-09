/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex.repository;

import fit5042.tutex.repository.entities.Exchange;
import fit5042.tutex.repository.entities.Item;
import fit5042.tutex.repository.entities.SubOrder;
import fit5042.tutex.repository.entities.SysUser;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author thinking
 */
@Stateless
public class JPAExchangeOperationImpl implements ExchangeOperation {
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Exchange> getAllExchangesByUserId(int userId) throws Exception {

        List<Exchange> exchanges =  entityManager.createNamedQuery(Exchange.FIND_BY_USERID, Exchange.class).setParameter("userId", userId).getResultList();
        System.out.println(exchanges);
        return exchanges;
    }
    
    @Override
    public void insertSubOrder(List<SubOrder> orderList){
        for(SubOrder order: orderList) {
            entityManager.persist(order);
        }
    }
    
    /**
     * 返回交易Id,也就是: exchangeId
     * @param exchange
     * @return 
     */
    @Override
    public int insertExchange(Exchange exchange) {
        entityManager.persist(exchange);
        List<Exchange> exchanges =  entityManager.createNamedQuery(Exchange.FIND_BY_USERID, Exchange.class).setParameter("userId", exchange.getSysuserSysUserId()).getResultList();
        int exchangeId = -1;
        for(Exchange exchange1 : exchanges) {
            exchangeId = Integer.max(exchange1.getExchangeId(), exchangeId);
        }
        return exchangeId;
    }
}
