package fit5042.tutex.repository.entities;

import fit5042.tutex.repository.entities.Address;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-08-04T21:32:14")
@StaticMetamodel(SysUser.class)
public class SysUser_ { 

    public static volatile SingularAttribute<SysUser, String> lastName;
    public static volatile SingularAttribute<SysUser, String> firstName;
    public static volatile SingularAttribute<SysUser, String> password;
    public static volatile SingularAttribute<SysUser, Double> availableCredits;
    public static volatile SingularAttribute<SysUser, Address> address;
    public static volatile SingularAttribute<SysUser, String> phoneNumber;
    public static volatile SingularAttribute<SysUser, String> membershipLevel;
    public static volatile SingularAttribute<SysUser, Integer> userId;
    public static volatile SingularAttribute<SysUser, String> email;

}