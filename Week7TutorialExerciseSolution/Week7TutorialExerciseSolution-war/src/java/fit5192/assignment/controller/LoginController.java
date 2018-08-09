/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5192.assignment.controller;

import fit5042.tutex.repository.entities.SysUser;
import fit5192.assignment.model.ActiveUser;
import fit5192.assignment.navigation.Navigation;
import fit5192.assignment.util.MD5;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import fit5042.tutex.repository.UserOperation;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author thinking
 */
@ManagedBean(name = "loginController")
public class LoginController {
    private String userEmail;
    private String password;
    
    @EJB
    private UserOperation userOperation;
    
    //登陆
    public String login() {
        try {
            ActiveUser activeUser = authenticate(userEmail, password);
            if(activeUser == null) {
                System.out.println("no found "+userEmail);
                return Navigation.error.toString();
//                return Navigation.error.toString();
            }
            System.out.println("userEmail: "+userEmail+"login success");
            
            // 创建session，将用户名和ActiveUser填进去
                HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            session.setAttribute("userEmail", userEmail);
            session.setAttribute("activeUser", activeUser);
            
            // 跳转到 item.xhml页面
            return Navigation.exchange.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return Navigation.error.toString();
        }
    }
    /**
     * 用户认证
     * @param userEmail
     * @param password
     * @return
     * @throws Exception 
     */
    public ActiveUser authenticate(String userEmail, String password) throws Exception {
        SysUser sysUser = userOperation.searchUserByEmail(userEmail);
        if(sysUser == null) {
            throw new Exception("User no exist!");
        }
        
        String passwordDb = sysUser.getPassword();
        String passwordInput = MD5.getMD5ofStr(password);
        
        if(!passwordInput.equalsIgnoreCase(passwordDb)) { 
            throw new Exception("User email or password is wrong!");
        }
        
        //get the userId
        int userId = sysUser.getUserId();
//        //根据用户id 查询菜单
//        List<SysPermission> menus = userOperation.findMenuListByUserId(userId);
//        //根据用户id 查询权限url
//        List<SysPermission> permissions = userOperation.findPermissionListByUserId(userId);
//        
        //认证通过，返回用户信息
        ActiveUser activeUser = new ActiveUser();
        activeUser.setUserId(sysUser.getUserId());
        activeUser.setUserEmial(sysUser.getEmail());
        
//        //放入权限范围的菜单和url
//        activeUser.setMenus(menus);
//        activeUser.setPermissions(permissions);
        
        return activeUser;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
