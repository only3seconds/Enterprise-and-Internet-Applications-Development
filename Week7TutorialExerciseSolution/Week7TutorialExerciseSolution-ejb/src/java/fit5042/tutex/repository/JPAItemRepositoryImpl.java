/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex.repository;

import fit5042.tutex.repository.entities.Item;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author thinking
 */
@Stateless
public class JPAItemRepositoryImpl implements ItemRepository{

    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public Item searchItemByTitle(String title) throws Exception {
        Item item = entityManager.createNamedQuery(Item.FIND_BY_TITLE, Item.class)
                .setParameter("title", title).getSingleResult();
        System.out.println("searchItem:" +item);
        return item;
    }

    @Override
    public List<Item> searchItemByType(String type) throws Exception {
        Set<String> labelList = new HashSet<>();
        labelList.add(type);
        List<Item> itemList = entityManager.createNamedQuery(Item.SEARCH_BY_LABEL, Item.class)
                .setParameter("label", labelList).getResultList();
        
        return itemList;
    }

    @Override
    public List<Item> searchItemByPrice(double price) throws Exception {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(Item.class);
        Root<Item> p = query.from(Item.class);
        query.select(p).where(builder.lessThanOrEqualTo(p.get("perPrice").as(Double.class), price));
        
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<Item> getAllItems() throws Exception {
        return entityManager.createNamedQuery(Item.GET_ALL_QUERY_NAME).getResultList();
    }
    
}
