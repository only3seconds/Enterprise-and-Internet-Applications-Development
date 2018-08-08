package fit5042.tutex.repository.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Eddie
 */
@Entity
@Table(name = "SYS_USER")
@NamedQueries({
    @NamedQuery(name = SysUser.GET_ALL_QUERY_NAME, query = "SELECT s FROM SysUser s"),
    @NamedQuery(name = SysUser.FIND_BY_ID, query = "SELECT s FROM SysUser s where s.userId = :userId"),
    @NamedQuery(name = SysUser.FIND_BY_LASTNAME, query = "SELECT s FROM SysUser s where s.lastName = :lastName"),
    @NamedQuery(name = SysUser.FIND_BY_FIRSTNAME, query = "SELECT s FROM SysUser s where s.firstName = :firstName"),
    @NamedQuery(name = SysUser.FIND_BY_PHONENUMBER, query = "SELECT s FROM SysUser s where s.phoneNumber = :phoneNumber"),
    @NamedQuery(name = SysUser.FIND_BY_EMAIL, query = "SELECT s FROM SysUser s where s.email = :email")})
public class SysUser implements Serializable {
    
    public static final String GET_ALL_QUERY_NAME = "SysUser.getAll";
    public static final String FIND_BY_ID = "SysUser.findById";
    public static final String FIND_BY_LASTNAME = "SysUser.findByLastName";
    public static final String FIND_BY_FIRSTNAME = "SysUser.findByFirstName";
    public static final String FIND_BY_PHONENUMBER = "SysUser.findByPhoneNumber";
    public static final String FIND_BY_EMAIL = "User.findByEmail";
    
    
    private int userId;
    private String email;
    private String password;
    private String membershipLevel;
    private String lastName;
    private String firstName;
    private String phoneNumber;
    private double availableCredits;
    
    private Address address;

    public SysUser() {
    }
    
    public SysUser(int userId, String email) {
        this.userId = userId;
        this.email = email;
    }

    public SysUser(int userId, String email, String password, String membershiLevel, String lastName, String firstName, String phoneNumber, double availableCredits) {
        this.userId = userId;
        this.email = email;
        this.password = password;
        this.membershipLevel = membershiLevel;
        this.lastName = lastName;
        this.firstName = firstName;
        this.phoneNumber = phoneNumber;
        this.availableCredits = availableCredits;
    }
    
    public SysUser(int userId, String email, String password, String membershiLevel, String lastName, String firstName, Address address, String phoneNumber, double availableCredits) {
        this.userId = userId;
        this.email = email;
        this.password = password;
        this.membershipLevel = membershiLevel;
        this.lastName = lastName;
        this.firstName = firstName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.availableCredits = availableCredits;
    }

    @Id
    @GeneratedValue
    @Column(name = "sys_user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    @Column(name = "membership_level")
    public String getMembershipLevel() {
        return membershipLevel;
    }

    public void setMembershipLevel(String membershipLevel) {
        this.membershipLevel = membershipLevel;
    }

    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Embedded
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    
    @Column(name = "phone_number")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Column(name = "available_credits")
    public double getAvailableCredits() {
        return availableCredits;
    }

    public void setAvailableCredits(double availableCredits) {
        this.availableCredits = availableCredits;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.userId;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SysUser other = (SysUser) obj;
        if (this.userId != other.userId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.userId + " - " + email + " - " + membershipLevel;
    }
}
