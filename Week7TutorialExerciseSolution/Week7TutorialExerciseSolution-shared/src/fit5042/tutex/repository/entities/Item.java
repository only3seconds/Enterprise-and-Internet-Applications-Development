package fit5042.tutex.repository.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Eddie
 */
@Entity
@NamedQueries({
    @NamedQuery(name = Item.GET_ALL_QUERY_NAME, query = "SELECT DISTINCT i FROM Item i left join fetch i.labels"),
    @NamedQuery(name = Item.FIND_BY_TITLE, query = "SELECT DISTINCT i FROM Item i where i.title = :title"),
    @NamedQuery(name = Item.SEARCH_BY_LABEL, query = "SELECT DISTINCT i FROM Item i LEFT JOIN FETCH i.labels where i.labels = :labels")
})
public class Item implements Serializable {
    
    public static final String GET_ALL_QUERY_NAME = "Item.getAll";
    public static final String FIND_BY_TITLE = "Item.findByTitle";
    public static final String SEARCH_BY_LABEL = "Item.searchByLabel";
    
    private int itemId; 
    private String title;
    private String imageURL;
    private int numberInStore;
    private int totalNumberInCirculation;
    private double perPrice;

    private Set<String> labels;

    public Item() {
        this.labels = new HashSet<>();
    }
    
    public Item(int itemId, String title, int numberInStore, double perPrice, Set<String> labels) {
        this.itemId = itemId;
        this.title = title;
        this.numberInStore = numberInStore;
        this.perPrice = perPrice;
        this.labels = labels;
    }

    public Item(int itemId, String title, String imageURL, int numberInStore, int totalNumberInCirculation, double perPrice, Set<String> labels) {
        this.itemId = itemId;
        this.title = title;
        this.imageURL = imageURL;
        this.numberInStore = numberInStore;
        this.totalNumberInCirculation = totalNumberInCirculation;
        this.perPrice = perPrice;
        this.labels = labels;
    }

    @Id
    @Column(name = "item_id")
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

    @Column(name = "image_url")
    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @Column(name = "number_in_store")
    public int getNumberInStore() {
        return numberInStore;
    }

    public void setNumberInStore(int numberInStore) {
        this.numberInStore = numberInStore;
    }

    @Column(name = "total_number_in_circulation")
    public int getTotalNumberInCirculation() {
        return totalNumberInCirculation;
    }

    public void setTotalNumberInCirculation(int totalNumberInCirculation) {
        this.totalNumberInCirculation = totalNumberInCirculation;
    }

    @Column(name = "per_price")
    public double getPerPrice() {
        return perPrice;
    }

    public void setPerPrice(double perPrice) {
        this.perPrice = perPrice;
    }

    @ElementCollection
    @CollectionTable(name = "labels")
    @Column(name = "labels_value")
    public Set<String> getLabels() {
        return labels;
    }

    public void setLabels(Set<String> labels) {
        this.labels = labels;
    }

    @Override
    public String toString() {
        return "Item{" + "itemId=" + itemId + ", title=" + title + ", imageURL=" + imageURL + ", numberInStore=" + numberInStore + ", totalNumberInCirculation=" + totalNumberInCirculation + ", perPrice=" + perPrice + ", labels=" + labels + '}';
    }
}
