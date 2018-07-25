package fit5042.tutex.repository;

import fit5042.tutex.repository.entities.Property;
import java.util.List;

/**
 * @autor Eddie Leung
 */
public interface PropertyRepository {

    /**
     * Add the property being passed as parameter into the database
     *
     * @param property - the property to add
     */
    public void addProperty(Property property) throws Exception;

    /**
     * Search for a property by its property ID
     *
     * @param id - the propertyId of the property to search for
     * @return the property found
     */
    public Property searchPropertyById(int id) throws Exception;

    /**
     * Return all the properties in the database
     *
     * @return all the properties in the database
     */
    public List<Property> getAllProperties() throws Exception;
}
