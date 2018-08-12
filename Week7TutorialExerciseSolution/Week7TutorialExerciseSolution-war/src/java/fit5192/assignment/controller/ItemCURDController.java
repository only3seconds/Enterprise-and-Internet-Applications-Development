/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5192.assignment.controller;

import fit5042.tutex.repository.ItemRepository;
import fit5042.tutex.repository.UserOperation;
import fit5042.tutex.repository.entities.Item;
import fit5042.tutex.repository.entities.SysUser;
import fit5192.assignment.model.ItemWrapper;
import fit5192.assignment.navigation.Navigation;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author thinking
 */
@ManagedBean(name = "itemCURDController")
@SessionScoped
public class ItemCURDController implements Serializable {
    private int itemId;
    private String title;
    private String imageURL;
    private int avaliableUnits;
    private int totalNumberInCirculation;
    private double price;
    private String type;
    
    private List<ItemWrapper> itemWrapperList;
    
    
    @EJB
    private ItemRepository itemRepository;
    
    /**
     * Creates a new instance of ItemController
     */
    public ItemCURDController() {
        itemWrapperList = new ArrayList<>();
    }
    
    //View
    public String displayAllItems() {
        try {
            System.out.println("add");
            itemWrapperList.clear();
            List<Item> itemList = itemRepository.getAllItems();
            for(Item i : itemList) {
                ItemWrapper itemWrapper = new ItemWrapper(i.getItemId(), i.getTitle(), i.getImageURL(), i.getNumberInStore(), i.getTotalNumberInCirculation(), i.getPerPrice(), i.getLabels().toString());
                itemWrapperList.add(itemWrapper);          
            }
            return Navigation.itemCURD.toString();
            
        } catch (Exception ex) {
            ex.printStackTrace();
            return Navigation.itemCURD.toString();
        }       
    }

    
    //Add
      public String addItem() {
        try{
            Set<String> labels = new HashSet<>();
            String[] labelsArr = type.split(",");
            for(String label: labelsArr) {
                labels.add(label);
            }
            Item item = new Item(itemId, title, imageURL, itemId, totalNumberInCirculation, price, labels);
            itemRepository.addItem(item);
            return displayAllItems();
            //return Navigation.user.toString();
        } catch (Exception ex) {
            ex.printStackTrace();
            return Navigation.itemCURD.toString();
        }    
    }
    
    
    //Update
    public String updateItem() {
        try{
            Set<String> labels = new HashSet<>();
            String[] labelsArr = type.split(",");
            for(String label: labelsArr) {
                labels.add(label);
            }
            Item item = new Item(itemId, title, imageURL, itemId, totalNumberInCirculation, price, labels);
           
            itemRepository.updateItem(item);
            return displayAllItems();
            
        } catch (Exception ex) {
            ex.printStackTrace();
            return Navigation.itemCURD.toString();
        }             
    }
    
    //Delete
    public String deleteItem(int id) {
        try{
            itemRepository.deleteItem(id);
            return displayAllItems();
            
        } catch (Exception ex) {
            ex.printStackTrace();
            return Navigation.itemCURD.toString();
        }
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public int getAvaliableUnits() {
        return avaliableUnits;
    }

    public void setAvaliableUnits(int avaliableUnits) {
        this.avaliableUnits = avaliableUnits;
    }

    public int getTotalNumberInCirculation() {
        return totalNumberInCirculation;
    }

    public void setTotalNumberInCirculation(int totalNumberInCirculation) {
        this.totalNumberInCirculation = totalNumberInCirculation;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
    
    
    
}
