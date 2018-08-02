/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex.repository.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author thinking
 */
@Entity
@NamedQueries({@NamedQuery(name = Visitor.FIND_ALL, query = "SELECT v FROM Visitor v")})
public class Visitor {
    public static final String FIND_ALL =  "Visitor.getAllItems";

    private int userId;
    private String email;
    private String password;
    private String membershipLevel;
    
    
    public Visitor() {
        this.userId = 0;
        this.email = "Unknown";
        this.membershipLevel = "Visitor";
    }
    
    
    public void getAllItems() {
        
    }

    @Id
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "membership_level")
    public String getMembershipLevel() {
        return membershipLevel;
    }

    public void setMembershipLevel(String membershipLevel) {
        this.membershipLevel = membershipLevel;
    }
    
    
    
    
}
