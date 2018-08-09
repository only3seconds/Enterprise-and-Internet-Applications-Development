/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5192.assignment.controller;

import fit5042.tutex.repository.ItemRepository;
import fit5042.tutex.repository.entities.Item;
import fit5192.assignment.model.ItemWrapper;
import fit5192.assignment.navigation.Navigation;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author thinking
 */
@ManagedBean(name = "itemController")
@SessionScoped
public class ItemController implements Serializable {
    
    private String title;
    private String type;
    private double price;

    private List<ItemWrapper> itemWrapperList;
    private Item item;
    private String labels;
    
    @EJB
    private ItemRepository itemRepository;
    
    /**
     * Creates a new instance of ItemController
     */
    public ItemController() {
        itemWrapperList = new ArrayList<>();
        item = new Item();
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
            ItemWrapper itemWrapper = new ItemWrapper(i.getItemId(), i.getTitle(), i.getLabels().toString(), i.getNumberInStore(), i.getPerPrice());
            itemWrapperList.add(itemWrapper);          
        }
        return Navigation.item.toString();
        
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
    
    //View
    public String displayAllItems() {
        try {
            itemWrapperList.clear();
            List<Item> itemList = itemRepository.getAllItems();
            for(Item i : itemList) {
                ItemWrapper itemWrapper = new ItemWrapper(i.getItemId(), i.getTitle(), i.getLabels().toString(), i.getNumberInStore(), i.getPerPrice());
                itemWrapperList.add(itemWrapper);          
            }
            return Navigation.item.toString();
            
        } catch (Exception ex) {
            ex.printStackTrace();
            return Navigation.item.toString();
        }       
    }

    //View Detail
    public String viewDetail(ItemWrapper itemWrapper) {
        try {
            item =  itemRepository.searchItemById(itemWrapper.getItemId());
            labels = item.getLabels().toString();
            System.out.println("total = " + item.getTotalNumberInCirculation());
            return Navigation.item.toString();
        } catch (Exception ex) {
            ex.printStackTrace();
            return Navigation.item.toString();
        }
        
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

    public void setItemWrapperList(List<ItemWrapper> itemList) {
        this.itemWrapperList = itemList;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    
    public ItemRepository getItemRepository() {
        return itemRepository;
    }

    public void setItemRepository(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public String getLabels() {
        return labels;
    }

    public void setLabels(String labels) {
        this.labels = labels;
    }
    
    
}
