/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5192.assignment.controller;

import fit5042.tutex.repository.ItemRepository;
import fit5042.tutex.repository.entities.Item;
import fit5192.assignment.model.ItemWrapper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author thinking
 */
@Named(value = "itemController")
@SessionScoped
public class ItemController implements Serializable {


    @EJB
    private static ItemRepository itemRepository;
    
    /**
     * Creates a new instance of ItemController
     */
    public ItemController() {
        
    }
    
    //Search
    public List<ItemWrapper> searchItem() {
        
        
        
//        List<ItemWrapper> itemWrapperList = new ArrayList<>();
//            for(Item i : items) {
//                ItemWrapper itemWrapper = new ItemWrapper(i.getItemId(), i.getTitle(), i.getLabels().toString(), i.getNumberInStore(), i.getPerPrice());
//                itemWrapperList.add(itemWrapper);          
//            }
        return null;
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
    public List<ItemWrapper> displayAllItems() {
        try {
            List<Item> itemList = itemRepository.getAllItems();
            List<ItemWrapper> itemWrapperList = new ArrayList<>();
            for(Item i : itemList) {
                ItemWrapper itemWrapper = new ItemWrapper(i.getItemId(), i.getTitle(), i.getLabels().toString(), i.getNumberInStore(), i.getPerPrice());
                itemWrapperList.add(itemWrapper);          
            }
            
            return itemWrapperList;
            
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ArrayList<>();
        }       
    }
    
}
