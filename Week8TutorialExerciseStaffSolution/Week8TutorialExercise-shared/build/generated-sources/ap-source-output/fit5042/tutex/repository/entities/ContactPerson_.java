package fit5042.tutex.repository.entities;

import fit5042.tutex.repository.entities.Property;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-08-04T21:32:14")
@StaticMetamodel(ContactPerson.class)
public class ContactPerson_ { 

    public static volatile SingularAttribute<ContactPerson, String> phoneNumber;
    public static volatile SingularAttribute<ContactPerson, String> name;
    public static volatile SetAttribute<ContactPerson, Property> properties;
    public static volatile SingularAttribute<ContactPerson, Integer> conactPersonId;

}