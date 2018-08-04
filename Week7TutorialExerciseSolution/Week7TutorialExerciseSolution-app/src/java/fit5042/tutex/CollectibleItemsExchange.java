/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex;

import fit5042.tutex.gui.CollectibleItemsExchangeGUI;
import fit5042.tutex.gui.CollectibleItemsExchangeGUIImpl;
import fit5042.tutex.repository.ItemRepository;
import fit5042.tutex.repository.entities.Item;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.ejb.EJB;

/**
 *
 * @author Eddie
 */
public class CollectibleItemsExchange implements ActionListener, ListSelectionListener {
    
    @EJB
    private static ItemRepository itemRepository;

    private String name;
    private CollectibleItemsExchangeGUI gui;

    public CollectibleItemsExchange(String name) throws Exception {
        this.name = name;
    }

    public void initView() {
        this.gui = new CollectibleItemsExchangeGUIImpl(this, this);
        this.displayAllItems();
    }

    @Override
    public void actionPerformed(ActionEvent event) {

        if (event.getSource() == gui.getViewButton()) {
            this.displayAllItems();
        } else if (event.getSource() == gui.getSearchButton()) {
            this.searchItem();
        } else {
            System.exit(0);
        }
    }
    
    
    public void searchItem() {
        
        //TODO
        String title = this.gui.getItemTitle();
        String type = this.gui.getItemType();
        Double price = this.gui.getBudget();
        if(null != title && !title.isEmpty()) {
            this.searchItemByTitle(title);
        } else if(null != type && !type.isEmpty()) {
            this.searchItemByType(type);
        } else if(price > 0) {
            this.searchItemByBudget(price);
        } else {
            this.gui.displayMessageInDialog("We need parameter");
            this.gui.clearItemTable();
        }
    }
    
    
    public void searchItemByBudget(double budget) {
        
        try {
            
            List<Item> items = itemRepository.searchItemByPrice(budget);
            
            if (items != null && !items.isEmpty()) {
                this.gui.displayItemDetails(items);
            } else {
                this.gui.displayMessageInDialog("No matched properties found");
                this.gui.clearItemTable();
            }  
        } catch (Exception ex) {
            ex.printStackTrace();
            this.gui.displayMessageInDialog("Failed to search property by Budget: " + ex.getMessage());
            this.gui.clearItemTable();
        } finally {
            this.gui.clearInput();
        }
    }

    public void searchItemByTitle(String title) {
        
        try {
            
            Item item = itemRepository.searchItemByTitle(title);
            
            if (item != null) {
                this.gui.displayItemDetails(item);
            } else {
                this.gui.displayMessageInDialog("No matched properties found");
                this.gui.clearItemTable();
            }  
        } catch (Exception ex) {
            this.gui.displayMessageInDialog("Failed to search item by Title: " + ex.getMessage());
            this.gui.clearItemTable();
        } finally {
            this.gui.clearInput();
        }
    }
    
    
    public void searchItemByType(String type) {
        
        try {
            
            List<Item> itemList = itemRepository.searchItemByType(type);
            
            if (itemList != null) {
                this.gui.displayItemDetails(itemList);
            } else {
                this.gui.displayMessageInDialog("No matched properties found");
                this.gui.clearItemTable();
            }  
        } catch (Exception ex) {
            this.gui.displayMessageInDialog("Failed to search item by type: " + ex.getMessage());
            this.gui.clearItemTable();
        } finally {
            this.gui.clearInput();
        }
    }
    

    private void displayAllItems() {
        try {
            List<Item> itemList = itemRepository.getAllItems();
            
            if (itemList != null) {
                this.gui.displayItemDetails(itemList);
            }
            
        } catch (Exception ex) {
            this.gui.displayMessageInDialog("Failed to retrieve properties: " + ex.getMessage());
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    @Override
    public void valueChanged(ListSelectionEvent event) {
        if ((event.getSource() == this.gui.getItemTable().getSelectionModel())
            && (! event.getValueIsAdjusting()))
        {
            try
            { 
                //gui.displayMessageInDialog("Not necessary for value change");              
            }
            catch (Exception e)
            {
                gui.displayMessageInDialog(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        try {
            final CollectibleItemsExchange agency = new CollectibleItemsExchange("Collectible Items Exchange");
            //JDK 1.7
//            SwingUtilities.invokeLater(new Runnable() {
//                @Override
//                public void run() {
//                    agency.initView();
//                }
//            });
            agency.initView();
            
//            //JDK 1.8
//            SwingUtilities.invokeLater(()-> {
//                agency.initView();
//            });
        } catch (Exception ex) {
            System.out.println("Failed to run application: " + ex.getMessage());
        }
    }



}
