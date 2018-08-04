package fit5042.tutex.repository.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author thinking
 */
@Entity
@NamedQueries({@NamedQuery(name = Exchange.GET_ALL_QUERY_NAME, query = "SELECT e FROM Exchange e")})
public class Exchange implements Serializable {
    
    public static final String GET_ALL_QUERY_NAME = "Exchange.getAll";
    
    private int exchangeId;
    private SysUser sysUser;
    private Date exchangeTime;
    private double netProceeds;


    public Exchange() {
 
    }

    public Exchange(int exchangeId, SysUser sysUser, Date exchangeTime, double netProceeds) {
        this.exchangeId = exchangeId;
        this.sysUser = sysUser;
        this.exchangeTime = exchangeTime;
        this.netProceeds = netProceeds;
    }

    @Id
    @Column(name = "exchange_id")
    public int getExchangeId() {
        return exchangeId;
    }

    public void setExchangeId(int exchangeId) {
        this.exchangeId = exchangeId;
    }

    @ManyToOne
    public SysUser getSysUser() {
        return sysUser;
    }

    public void setSysUser(SysUser sysUser) {
        this.sysUser = sysUser;
    }

    @Column(name = "exchange_time")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getExchangeTime() {
        return exchangeTime;
    }

    public void setExchangeTime(Date exchangeTime) {
        this.exchangeTime = exchangeTime;
    }

    @Column(name = "net_proceeds")
    public double getNetProceeds() {
        return netProceeds;
    }
    
    public void setNetProceeds(double netProceeds) {
        this.netProceeds = netProceeds;
    }
}