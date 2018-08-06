package fit5042.tutex.repository.entities;

import fit5042.tutex.repository.entities.SysUser;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-08-04T21:32:14")
@StaticMetamodel(Exchange.class)
public class Exchange_ { 

    public static volatile SingularAttribute<Exchange, Integer> exchangeId;
    public static volatile SingularAttribute<Exchange, Double> netProceeds;
    public static volatile SingularAttribute<Exchange, Date> exchangeTime;
    public static volatile SingularAttribute<Exchange, SysUser> sysUser;

}