/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex.repository;

import fit5042.tutex.repository.entities.Property;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author thinking
 */
public class JPAPropertyRepositoryImpl implements PropertyRepository {
    
    private static final String PERSISTENCE_UNIT = "RealEstateAgencyPU";
    
    private EntityManager entityManager;
    private EntityManagerFactory entityManagerFactory;

    public JPAPropertyRepositoryImpl() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        this.entityManager = this.entityManagerFactory.createEntityManager();
    }
    

    
    public void removeProperty(int propertyId) {
        EntityTransaction transaction = this.entityManager.getTransaction();
        
        try {
            transaction.begin();
            this.entityManager.remove(this.searchPropertyById(propertyId));
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
        }
    }
    
    // 新的 property 覆盖旧的 property
    public void editProperty(Property property) {
        EntityTransaction transaction = this.entityManager.getTransaction();
        
        try {
            transaction.begin();
            this.entityManager.merge(property);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
        }
    }
    
    public void close() {
        System.exit(0);
    }    
    

    //向数据库中添加一个 property
    @Override
    public void addProperty(Property property) throws Exception {
        EntityTransaction transaction = this.entityManager.getTransaction();
        
        try {
            transaction.begin();
            this.entityManager.persist(property);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
        }
    }

    @Override
    public Property searchPropertyById(int propertyId) throws Exception {
        Property property = this.entityManager.find(Property.class, propertyId);       
        return property;
    }

    @Override
    public List<Property> getAllProperties() throws Exception {
        return this.entityManager.createNamedQuery(Property.FIND_ALL).getResultList();
    }
    
}
