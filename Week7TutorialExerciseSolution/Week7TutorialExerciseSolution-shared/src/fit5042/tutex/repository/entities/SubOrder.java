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
import javax.persistence.GeneratedValue;
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
    
    private int exchangeId;
    private int itemId;

    public SubOrder() {
    }

    public SubOrder(Integer orderId, int exchangeId, int itemId, Integer itemsCount) {
        this.orderId = orderId;
        this.exchangeId = exchangeId;
        this.itemId = itemId;
        this.itemsCount = itemsCount;
    }

    @Id
    @Basic(optional = false)
    @GeneratedValue
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

    @Column(name = "EXCHANGE_EXCHANGE_ID")
    public int getExchangeId() {
        return exchangeId;
    }

    public void setExchangeId(int exchangeId) {
        this.exchangeId = exchangeId;
    }

    @Column(name = "ITEM_ITEM_ID")
    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    @Override
    public String toString() {
        return "SubOrder{" + "orderId=" + orderId + ", itemsCount=" + itemsCount + ", purchaseOrSale=" + purchaseOrSale + ", exchangeId=" + exchangeId + ", itemId=" + itemId + '}';
    }
    
    
}
