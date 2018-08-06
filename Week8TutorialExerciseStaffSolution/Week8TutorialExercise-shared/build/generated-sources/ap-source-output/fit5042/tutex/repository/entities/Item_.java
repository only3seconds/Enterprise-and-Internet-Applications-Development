package fit5042.tutex.repository.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-08-04T21:32:14")
@StaticMetamodel(Item.class)
public class Item_ { 

    public static volatile SingularAttribute<Item, Integer> itemId;
    public static volatile SingularAttribute<Item, Double> perPrice;
    public static volatile SingularAttribute<Item, String> imageURL;
    public static volatile SingularAttribute<Item, Integer> numberInStore;
    public static volatile SingularAttribute<Item, String> title;
    public static volatile SingularAttribute<Item, Integer> totalNumberInCirculation;
    public static volatile SetAttribute<Item, String> labels;

}