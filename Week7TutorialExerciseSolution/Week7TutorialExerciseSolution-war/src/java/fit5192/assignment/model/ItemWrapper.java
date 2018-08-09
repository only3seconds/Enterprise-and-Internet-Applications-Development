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
    private String imageURL;
    private int availableUnits;
    private int totalNumberInCirculation;
    private double price;
    private String type;
     
    public ItemWrapper() {
        
    }
    
    public ItemWrapper(ItemWrapper i) {
        this.itemId = i.itemId;
        this.title= i.title;
        this.imageURL = i.imageURL;
        this.availableUnits = i.availableUnits;
        this.totalNumberInCirculation = i.totalNumberInCirculation;
        this.price = i.price;
        this.type = i.type;
        
    }
    public ItemWrapper(int itemId, String title, String type, int availableUnits, double price) {
        this.itemId = itemId;
        this.title = title;
        this.type = type;
        this.availableUnits = availableUnits;
        this.price = price;
        
    }
    
    public ItemWrapper(int itemId, String title, String imageURL, int availableUnits, int totalNumberInCirculation, double price, String type) {
        this.itemId = itemId;
        this.title = title;
        this.imageURL= imageURL;
        this.availableUnits = availableUnits;
        this.totalNumberInCirculation = totalNumberInCirculation;
        this.price = price;
        this.type = type;    
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

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public int getTotalNumberInCirculation() {
        return totalNumberInCirculation;
    }

    public void setTotalNumberInCirculation(int totalNumberInCirculation) {
        this.totalNumberInCirculation = totalNumberInCirculation;
    }
    
    
    
}
