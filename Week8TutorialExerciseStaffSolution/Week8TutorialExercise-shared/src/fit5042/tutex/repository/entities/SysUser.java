/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex.repository.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author thinking
 */
@Entity
@Table(name = "SYS_USER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SysUser.findAll", query = "SELECT s FROM SysUser s")
    , @NamedQuery(name = "SysUser.findBySysUserId", query = "SELECT s FROM SysUser s WHERE s.sysUserId = :sysUserId")
    , @NamedQuery(name = "SysUser.findByAvailableCredits", query = "SELECT s FROM SysUser s WHERE s.availableCredits = :availableCredits")
    , @NamedQuery(name = "SysUser.findByEmail", query = "SELECT s FROM SysUser s WHERE s.email = :email")
    , @NamedQuery(name = "SysUser.findByFirstName", query = "SELECT s FROM SysUser s WHERE s.firstName = :firstName")
    , @NamedQuery(name = "SysUser.findByLastName", query = "SELECT s FROM SysUser s WHERE s.lastName = :lastName")
    , @NamedQuery(name = "SysUser.findByMembershipLevel", query = "SELECT s FROM SysUser s WHERE s.membershipLevel = :membershipLevel")
    , @NamedQuery(name = "SysUser.findByPassword", query = "SELECT s FROM SysUser s WHERE s.password = :password")
    , @NamedQuery(name = "SysUser.findByPhoneNumber", query = "SELECT s FROM SysUser s WHERE s.phoneNumber = :phoneNumber")
    , @NamedQuery(name = "SysUser.findByPostcode", query = "SELECT s FROM SysUser s WHERE s.postcode = :postcode")
    , @NamedQuery(name = "SysUser.findByState", query = "SELECT s FROM SysUser s WHERE s.state = :state")
    , @NamedQuery(name = "SysUser.findByStreetAddress", query = "SELECT s FROM SysUser s WHERE s.streetAddress = :streetAddress")
    , @NamedQuery(name = "SysUser.findByStreetNumber", query = "SELECT s FROM SysUser s WHERE s.streetNumber = :streetNumber")
    , @NamedQuery(name = "SysUser.findBySuburb", query = "SELECT s FROM SysUser s WHERE s.suburb = :suburb")})
public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SYS_USER_ID")
    private Integer sysUserId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "AVAILABLE_CREDITS")
    private Double availableCredits;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="电子邮件无效")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "EMAIL")
    private String email;
    @Size(max = 255)
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Size(max = 255)
    @Column(name = "LAST_NAME")
    private String lastName;
    @Size(max = 255)
    @Column(name = "MEMBERSHIP_LEVEL")
    private String membershipLevel;
    @Size(max = 255)
    @Column(name = "PASSWORD")
    private String password;
    @Size(max = 255)
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;
    @Size(max = 255)
    @Column(name = "POSTCODE")
    private String postcode;
    @Size(max = 255)
    @Column(name = "STATE")
    private String state;
    @Size(max = 255)
    @Column(name = "STREET_ADDRESS")
    private String streetAddress;
    @Size(max = 255)
    @Column(name = "STREET_NUMBER")
    private String streetNumber;
    @Size(max = 255)
    @Column(name = "SUBURB")
    private String suburb;

    public SysUser() {
    }

    public SysUser(Integer sysUserId) {
        this.sysUserId = sysUserId;
    }

    public Integer getSysUserId() {
        return sysUserId;
    }

    public void setSysUserId(Integer sysUserId) {
        this.sysUserId = sysUserId;
    }

    public Double getAvailableCredits() {
        return availableCredits;
    }

    public void setAvailableCredits(Double availableCredits) {
        this.availableCredits = availableCredits;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMembershipLevel() {
        return membershipLevel;
    }

    public void setMembershipLevel(String membershipLevel) {
        this.membershipLevel = membershipLevel;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sysUserId != null ? sysUserId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SysUser)) {
            return false;
        }
        SysUser other = (SysUser) object;
        if ((this.sysUserId == null && other.sysUserId != null) || (this.sysUserId != null && !this.sysUserId.equals(other.sysUserId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fit5042.tutex.repository.entities.SysUser[ sysUserId=" + sysUserId + " ]";
    }
    
}
