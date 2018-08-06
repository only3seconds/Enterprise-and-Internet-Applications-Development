/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5192.assignment.model;

import fit5042.tutex.repository.entities.SysPermission;
import java.io.Serializable;
import java.util.List;

/**
 * 用户的身份信息，存入session
 * @author thinking
 */
public class ActiveUser implements Serializable {
    private int userId;
    private String userEmial;
    
    private List<SysPermission> menus; //菜单
    private List<SysPermission> permissions; //权限
    
    public ActiveUser() {
        
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserEmial() {
        return userEmial;
    }

    public void setUserEmial(String userEmial) {
        this.userEmial = userEmial;
    }

    public List<SysPermission> getMenus() {
        return menus;
    }

    public void setMenus(List<SysPermission> menus) {
        this.menus = menus;
    }

    public List<SysPermission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<SysPermission> permissions) {
        this.permissions = permissions;
    }
    
    
    
}
