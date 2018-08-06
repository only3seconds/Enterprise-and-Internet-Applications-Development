/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5192.assignment.controller;

import fit5042.tutex.repository.UserOperation;
import fit5042.tutex.repository.entities.SysUser;
import fit5192.assignment.navigation.Navigation;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author thinking
 */
@ManagedBean(name = "userController")
public class UserController implements Serializable {
    private int userId;
    private String lastName;
    private String firstName;
    private String phoneNumber;
    private String email;

    private List<SysUser> userList;
    
    @EJB
    private UserOperation userOperation;
    
    /**
     * Creates a new instance of ItemController
     */
    public UserController() {
        userList = new ArrayList<>();
    }
    
    //View
    public String displayAllUsers() {
        try {
            List<SysUser> userList = userOperation.getAllUsers();
            return Navigation.item.toString();     
        } catch (Exception ex) {
            ex.printStackTrace();
            return Navigation.user.toString();
        }       
    }
    
    //Search
    public String searchUser() {
        
        List<SysUser> userList = new ArrayList<>();
        if(userId > 0) {
            userList = this.searchUserById(userId);
        } else if(null != lastName && !lastName.isEmpty()) {
            userList = this.searchUserByLastName(lastName);
        } else if(null != firstName && !firstName.isEmpty()) {
            userList = this.searchUserByFirstName(firstName);
        } else if(null != phoneNumber && !phoneNumber.isEmpty()) {
            userList = this.searchUserByPhoneNumber(phoneNumber);
        } else if(null != email && !email.isEmpty()) {
            userList = this.searchUserByEmail(email);
        } else {
            System.out.println("Do nothing");
        }
        
        return Navigation.user.toString();
        
    }
    
    //Add
    public String addUser() {
        return Navigation.user.toString();
    }
    
    //Update
    public String updateUSer() {
        return Navigation.user.toString();
    }
    
    //Delete
    public String deleteUser() {
        return Navigation.user.toString();
    }
    
    private List<SysUser> searchUserById(int id) {
        try {
            return Arrays.asList(userOperation.searchUserById(id));
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ArrayList<>();
        }
    }

    
    private List<SysUser> searchUserByLastName(String lastName) {
        try {
            return userOperation.searchUserByLastName(lastName);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ArrayList<>();
        }
    }
    
    private List<SysUser> searchUserByFirstName(String firstName) {
        try {
            return userOperation.searchUserByFirstName(firstName);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ArrayList<>();
        }
        
    }
    
    private List<SysUser> searchUserByPhoneNumber(String phoneNumber) {
        try {
            return userOperation.searchUserByPhoneNumber(phoneNumber);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ArrayList<>();
        }
    }
    
    private List<SysUser> searchUserByEmail(String email) {
        try {
            return Arrays.asList(userOperation.searchUserByEmail(email));
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ArrayList<>();
        }
    }
    


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<SysUser> getUserList() {
        return userList;
    }

    public void setUserList(List<SysUser> userList) {
        this.userList = userList;
    }

    public UserOperation getUserOperation() {
        return userOperation;
    }

    public void setUserOperation(UserOperation userOperation) {
        this.userOperation = userOperation;
    }
    
    
    
}
