/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5192.assignment.controller;

import fit5042.tutex.repository.ExchangeOperation;
import fit5042.tutex.repository.UserOperation;
import fit5042.tutex.repository.entities.Exchange;
import fit5042.tutex.repository.entities.SysUser;
import fit5192.assignment.model.ActiveUser;
import fit5192.assignment.navigation.Navigation;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author thinking
 */
@ManagedBean(name = "exchangeController")
public class ExchangeController implements Serializable {
    private int exchangeId;
    private Date exchangeTime;
    private double netProceeds;
    private SysUser sysUser; //用来获取当前登录进去的用户activeUser
    
    private List<Exchange> exchangeList;
    
    @EJB
    private ExchangeOperation exchangeOperation;
    @EJB
    private UserOperation userOperation;
    
    public String displayAllExchangesByUserId() {
        try {
            HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            int userId = ((ActiveUser)session.getAttribute("activeUser")).getUserId();
            System.out.println("thinking"+userId);
            exchangeList = exchangeOperation.getAllExchangesByUserId(userId);
            
            return Navigation.exchange.toString();
            
        } catch (Exception ex) {
            ex.printStackTrace();
            return Navigation.exchange.toString();
        }
    }
    
    public String addSubOrder() {
        try {
            //sysUser = 登录进去的activeUser
            HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            sysUser = (SysUser) session.getAttribute("activeUser");
            exchangeList = exchangeOperation.getAllExchangesByUserId(sysUser.getUserId());
            
            return Navigation.exchange.toString();
            
        } catch (Exception ex) {
            ex.printStackTrace();
            return Navigation.exchange.toString();
        }
    }

    public int getExchangeId() {
        return exchangeId;
    }

    public void setExchangeId(int exchangeId) {
        this.exchangeId = exchangeId;
    }

    public Date getExchangeTime() {
        return exchangeTime;
    }

    public void setExchangeTime(Date exchangeTime) {
        this.exchangeTime = exchangeTime;
    }

    public double getNetProceeds() {
        return netProceeds;
    }

    public void setNetProceeds(double netProceeds) {
        this.netProceeds = netProceeds;
    }

    public SysUser getSysUser() {
        return sysUser;
    }

    public void setSysUser(SysUser sysUser) {
        this.sysUser = sysUser;
    }

    public List<Exchange> getExchangeList() {
        return exchangeList;
    }

    public void setExchangeList(List<Exchange> exchangeList) {
        this.exchangeList = exchangeList;
    }

    public ExchangeOperation getExchangeOperation() {
        return exchangeOperation;
    }

    public void setExchangeOperation(ExchangeOperation exchangeOperation) {
        this.exchangeOperation = exchangeOperation;
    }
}
