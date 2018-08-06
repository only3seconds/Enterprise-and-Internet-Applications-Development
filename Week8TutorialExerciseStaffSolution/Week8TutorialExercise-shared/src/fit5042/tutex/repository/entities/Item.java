/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex.repository.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author thinking
 */
@MappedSuperclass
@Table(catalog = "", schema = "FIT5192")
@XmlRootElement
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ITEM_ID", nullable = false)
    private Integer itemId;
    @Size(max = 255)
    @Column(name = "IMAGE_URL", length = 255)
    private String imageUrl;
    @Column(name = "NUMBER_IN_STORE")
    private Integer numberInStore;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PER_PRICE", precision = 52)
    private Double perPrice;
    @Size(max = 255)
    @Column(length = 255)
    private String title;
    @Column(name = "TOTAL_NUMBER_IN_CIRCULATION")
    private Integer totalNumberInCirculation;

    public Item() {
    }

    public Item(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getNumberInStore() {
        return numberInStore;
    }

    public void setNumberInStore(Integer numberInStore) {
        this.numberInStore = numberInStore;
    }

    public Double getPerPrice() {
        return perPrice;
    }

    public void setPerPrice(Double perPrice) {
        this.perPrice = perPrice;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getTotalNumberInCirculation() {
        return totalNumberInCirculation;
    }

    public void setTotalNumberInCirculation(Integer totalNumberInCirculation) {
        this.totalNumberInCirculation = totalNumberInCirculation;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemId != null ? itemId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Item)) {
            return false;
        }
        Item other = (Item) object;
        if ((this.itemId == null && other.itemId != null) || (this.itemId != null && !this.itemId.equals(other.itemId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fit5042.tutex.repository.entities.Item[ itemId=" + itemId + " ]";
    }
    
}
