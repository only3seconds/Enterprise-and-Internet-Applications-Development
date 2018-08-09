/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex.repository.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author thinking
 */
@Entity
@Table(name = "EXCHANGE")
@NamedQueries({
    @NamedQuery(name = Exchange.GET_ALL_QUERY_NAME, query = "SELECT e FROM Exchange e"),
    @NamedQuery(name = Exchange.FIND_BY_USERID, query = "SELECT e FROM Exchange e where e.sysuserSysUserId = :userId")})
public class Exchange implements Serializable {

    private static final long serialVersionUID = 1L;
    public static final String GET_ALL_QUERY_NAME = "Exchange.findAll";
    public static final String FIND_BY_USERID = "Exchange.findByUserId";
    
    
    private Integer exchangeId;
    private Date exchangeTime;
    private Double netProceeds;
    private int sysuserSysUerId;

    public Exchange() {
    }

    public Exchange(int sysuserSysUerId) {
        this.sysuserSysUerId = sysuserSysUerId;
    }
    public Exchange(Integer exchangeId, Date exchangeTime, int sysuserSysUerId) {
        this.exchangeId = exchangeId;
        this.exchangeTime = exchangeTime;
        this.sysuserSysUerId =sysuserSysUerId;
    }

    @Id
    @Basic(optional = false)
    @GeneratedValue
    @NotNull
    @Column(name = "EXCHANGE_ID")
    public Integer getExchangeId() {
        return exchangeId;
    }

    public void setExchangeId(Integer exchangeId) {
        this.exchangeId = exchangeId;
    }

    @Column(name = "EXCHANGE_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getExchangeTime() {
        return exchangeTime;
    }

    public void setExchangeTime(Date exchangeTime) {
        this.exchangeTime = exchangeTime;
    }

    @Column(name = "NET_PROCEEDS")
    public Double getNetProceeds() {
        return netProceeds;
    }

    public void setNetProceeds(Double netProceeds) {
        this.netProceeds = netProceeds;
    }
    
    @Column(name = "SYSUSER_SYS_USER_ID")
    public int getSysuserSysUserId() {
        return sysuserSysUerId;
    }
    
    public void setSysuserSysUserId(int userId) {
        this.sysuserSysUerId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (exchangeId != null ? exchangeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Exchange)) {
            return false;
        }
        Exchange other = (Exchange) object;
        if ((this.exchangeId == null && other.exchangeId != null) || (this.exchangeId != null && !this.exchangeId.equals(other.exchangeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Exchange{" + "exchangeId=" + exchangeId + ", exchangeTime=" + exchangeTime + ", netProceeds=" + netProceeds + ", sysuserSysUerId=" + sysuserSysUerId + '}';
    }
}
