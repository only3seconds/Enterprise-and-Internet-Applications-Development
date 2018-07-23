package fit5042.tutex.repository;

import fit5042.tutex.repository.entities.Property;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple repository implementation that uses ArrayList as the data storage
 * 
 * @author Eddie Leung
 */
public class SimplePropertyRepositoryImpl implements PropertyRepository {
    
    private final List<Property> properties;

    protected SimplePropertyRepositoryImpl()
    {
        properties = new ArrayList<>();
    }
    
    @Override
    public void addProperty(Property property) throws Exception
    {
        if ((!properties.contains(property)) && (searchPropertyById(property.getPropertyId()) == null))
            properties.add(property);
    }
    
    @Override
    public Property searchPropertyById(int id) throws Exception
    {   
        for (Property property : this.properties) {
            if (property.getPropertyId() == id) {
                return property;
            }
        }
        
        return null;
    }
    
    @Override
    public List<Property> getAllProperties() throws Exception
    {
        List<Property> properties = new ArrayList<>(this.properties.size());
        for (Property property : this.properties) {
            properties.add(new Property(property));
        }
        return properties;
    }
}
