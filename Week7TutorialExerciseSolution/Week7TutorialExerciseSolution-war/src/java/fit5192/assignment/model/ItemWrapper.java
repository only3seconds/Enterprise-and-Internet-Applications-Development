/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5192.assignment.model;

/**
 *
 * @author thinking
 */
public class ItemWrapper {
    private int itemId;
    private String title;
    private String type;
    private int availableUnits;
    private double price;
    
    public ItemWrapper() {
        
    }
    
    public ItemWrapper(int itemId, String title, String type, int availableUnits, double price) {
        this.itemId = itemId;
        this.title = title;
        this.type = type;
        this.availableUnits = availableUnits;
        this.price = price;
        
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAvailableUnits() {
        return availableUnits;
    }

    public void setAvailableUnits(int availableUnits) {
        this.availableUnits = availableUnits;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    
    
}
