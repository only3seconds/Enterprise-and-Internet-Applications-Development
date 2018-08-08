/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex.repository;

import fit5042.tutex.repository.entities.Exchange;
import java.util.List;
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
        return entityManager.createNamedQuery(Exchange.FIND_BY_USERID).getResultList();
    }

    
}
