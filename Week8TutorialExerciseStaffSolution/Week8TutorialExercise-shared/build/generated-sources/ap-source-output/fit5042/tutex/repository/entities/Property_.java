package fit5042.tutex.repository.entities;

import fit5042.tutex.repository.entities.Address;
import fit5042.tutex.repository.entities.ContactPerson;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-08-04T21:32:14")
@StaticMetamodel(Property.class)
public class Property_ { 

    public static volatile SingularAttribute<Property, Address> address;
    public static volatile SingularAttribute<Property, Double> size;
    public static volatile SingularAttribute<Property, Double> price;
    public static volatile SingularAttribute<Property, ContactPerson> contactPerson;
    public static volatile SingularAttribute<Property, Integer> propertyId;
    public static volatile SingularAttribute<Property, Integer> numberOfBedrooms;
    public static volatile SetAttribute<Property, String> tags;

}