/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex.repository.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author thinking
 */
@Entity
@Table(name = "sub_order")
@NamedQueries({
    @NamedQuery(name = "SubOrder.findAll", query = "SELECT sub FROM SubOrder sub")})
public class SubOrder implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer orderId;
    private Integer itemsCount;
    private int purchaseOrSale;
    
    private Exchange exchange;
    private Item item;

    public SubOrder() {
    }

    
    public SubOrder(Integer orderId, Exchange exchange, Item item, Integer itemsCount) {
        this.orderId = orderId;
        this.exchange = exchange;
        this.item = item;
        this.itemsCount = itemsCount;
    }

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "order_id")
    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    @Column(name = "items_count")
    public Integer getItemsCount() {
        return itemsCount;
    }

    public void setItemsCount(Integer itemsCount) {
        this.itemsCount = itemsCount;
    }

    @Column(name = "purchase_sale")
    public int getPurchaseOrSale() {
        return purchaseOrSale;
    }

    public void setPurchaseOrSale(int purchaseOrSale) {
        this.purchaseOrSale = purchaseOrSale;
    }

    
    @ManyToOne
    public Exchange getExchange() {
        return exchange;
    }

    public void setExchange(Exchange exchange) {
        this.exchange = exchange;
    }

    @ManyToOne
    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderId != null ? orderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubOrder)) {
            return false;
        }
        SubOrder other = (SubOrder) object;
        if ((this.orderId == null && other.orderId != null) || (this.orderId != null && !this.orderId.equals(other.orderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "exchangeId= " + orderId + ", itemId=" + item.getItemId() + ", exchangeId= " + exchange.getExchangeId();
    }
    
}
