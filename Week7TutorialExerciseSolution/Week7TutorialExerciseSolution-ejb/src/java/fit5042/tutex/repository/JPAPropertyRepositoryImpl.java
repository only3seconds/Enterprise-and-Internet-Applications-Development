package fit5042.tutex.repository;

import fit5042.tutex.repository.entities.ContactPerson;
import fit5042.tutex.repository.entities.Property;
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
 * @author Eddie Leung
 */
@Stateless
public class JPAPropertyRepositoryImpl implements PropertyRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addProperty(Property property) throws Exception { 
        entityManager.persist(property);
    }

    @Override
    public Property searchPropertyById(int id) throws Exception {    
        Property property = entityManager.find(Property.class, id);
        property.getTags().size();
        return property;
    }

    @Override
    public List<Property> getAllProperties() throws Exception {        
        return entityManager.createNamedQuery(Property.GET_ALL_QUERY_NAME).getResultList();
    }
    
    @Override
    public Set<Property> searchPropertyByContactPerson(ContactPerson contactPerson) throws Exception {
        contactPerson = entityManager.find(ContactPerson.class, contactPerson.getConactPersonId());
        contactPerson.getProperties().size();
        entityManager.refresh(contactPerson);

        return contactPerson.getProperties();
    }
    
    @Override
    public List<ContactPerson> getAllContactPeople() throws Exception {    
        return entityManager.createNamedQuery(ContactPerson.GET_ALL_QUERY_NAME).getResultList();
    }

    @Override
    public void removeProperty(int propertyId) throws Exception {          
        Property property = this.searchPropertyById(propertyId);
      
        if (property != null) {
            entityManager.remove(property);
        }
    }

    @Override
    public void editProperty(Property property) throws Exception {      
        entityManager.merge(property);
    }  
    
    @Override
    public List<Property> searchPropertyByBudget(double budget) throws Exception {      
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(Property.class);
        Root<Property> p = query.from(Property.class);
        query.select(p).where(builder.lessThanOrEqualTo(p.get("price").as(Double.class), budget));
        
        return entityManager.createQuery(query).getResultList();
    }
}
