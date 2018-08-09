/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5192.assignment.controller;

import fit5042.tutex.repository.ExchangeOperation;
import fit5042.tutex.repository.ItemRepository;
import fit5042.tutex.repository.UserOperation;
import fit5042.tutex.repository.entities.Exchange;
import fit5042.tutex.repository.entities.Item;
import fit5042.tutex.repository.entities.SubOrder;
import fit5042.tutex.repository.entities.SysUser;
import fit5192.assignment.model.ActiveUser;
import fit5192.assignment.model.ItemWrapper;
import fit5192.assignment.navigation.Navigation;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author thinking
 */
@ManagedBean(name = "exchangeController")
@SessionScoped
public class ExchangeController implements Serializable {
    private int exchangeId;
    private Date exchangeTime;
    private double netProceeds;
    private SysUser sysUser; //用来获取当前登录进去的用户activeUser
    
    private List<Exchange> exchangeList;
    
    
    private String title;
    private String type;
    private double price;
    
    
    private List<ItemWrapper> itemWrapperList;
    private static List<ItemWrapper> chartList;
    
    
    private Exchange exchange;
    private SubOrder subOrder;
    
    @EJB
    private ExchangeOperation exchangeOperation;
//    @EJB
//    private UserOperation userOperation;
    
    @EJB
    private ItemRepository itemRepository;
    

    public ExchangeController() {
        itemWrapperList = new ArrayList<>();
        chartList = new ArrayList<>();
    }
    
    public String addExchange(ItemWrapper cartItem) {
        try {
            HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            int userId = ((ActiveUser)session.getAttribute("activeUser")).getUserId();
            
            exchange = new Exchange(userId);
            exchangeId = exchange.getExchangeId();
            subOrder = new SubOrder(exchangeId, cartItem.getItemId());//创建一下构造函数
            
            exchangeOperation.addExchange(exchange);
            exchangeOperation.addSubOrder(subOrder);
            
            return Navigation.exchange.toString();
            
        } catch (Exception ex) {
            ex.printStackTrace();
            return Navigation.exchange.toString();
        }
    }
    
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
    
       //Search
    public String searchItem() {
        itemWrapperList.clear();
        List<Item> itemList = new ArrayList<>();
        if(null != title && !title.isEmpty()) {
            itemList = this.searchItemByTitle(title);
        } else if(null != type && !type.isEmpty()) {
            itemList = this.searchItemByType(type);
        } else if(price > 0) {
            itemList = this.searchItemByBudget(price);
        } else {
            System.out.println("Do nothing");
        }
        
        for(Item i : itemList) {
            ItemWrapper itemWrapper = new ItemWrapper(i.getItemId(), i.getTitle(), i.getImageURL(), i.getNumberInStore(), i.getTotalNumberInCirculation(), i.getPerPrice(), i.getLabels().toString());
            itemWrapperList.add(itemWrapper);          
        }
        return Navigation.exchange.toString();
        
    }
    
    private List<Item> searchItemByBudget(double budget) {
        try {
            return itemRepository.searchItemByPrice(budget);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ArrayList<>();
        }
    }

    
    private List<Item> searchItemByTitle(String title) {
        try {
            return Arrays.asList(itemRepository.searchItemByTitle(title));
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ArrayList<>();
        }
    }
    private List<Item> searchItemByType(String type) {
        try {
            return itemRepository.searchItemByType(type);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ArrayList<>();
        }
        
    }
    
    //Add to chart
    public String addToChart(ItemWrapper i) {
        System.out.println("Hello");
        chartList.add(i);
        System.out.println("size = " + chartList.size());
        return Navigation.exchange.toString();
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<ItemWrapper> getItemWrapperList() {
        return itemWrapperList;
    }

    public void setItemWrapperList(List<ItemWrapper> itemWrapperList) {
        this.itemWrapperList = itemWrapperList;
    }

    public ItemRepository getItemRepository() {
        return itemRepository;
    }

    public void setItemRepository(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<ItemWrapper> getChartList() {
        return chartList;
    }

    public void setChartList(List<ItemWrapper> chartList) {
        this.chartList = chartList;
    }

    public Exchange getExchange() {
        return exchange;
    }

    public void setExchange(Exchange exchange) {
        this.exchange = exchange;
    }

    public SubOrder getSubOrder() {
        return subOrder;
    }

    public void setSubOrder(SubOrder subOrder) {
        this.subOrder = subOrder;
    }
    
    
    
    
    
}
