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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author thinking
 */
@Entity
@Table(name = "TEST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Test.findAll", query = "SELECT t FROM Test t")
    , @NamedQuery(name = "Test.findByTest1", query = "SELECT t FROM Test t WHERE t.test1 = :test1")
    , @NamedQuery(name = "Test.findById", query = "SELECT t FROM Test t WHERE t.id = :id")})
public class Test implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "TEST1")
    @Temporal(TemporalType.TIMESTAMP)
    private Date test1;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;

    public Test() {
    }

    public Test(Integer id) {
        this.id = id;
    }

    public Date getTest1() {
        return test1;
    }

    public void setTest1(Date test1) {
        this.test1 = test1;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Test)) {
            return false;
        }
        Test other = (Test) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fit5042.tutex.repository.entities.Test[ id=" + id + " ]";
    }
    
}
