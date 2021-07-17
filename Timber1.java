/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forest;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "TIMBER1", catalog = "", schema = "APP")
@NamedQueries({
    @NamedQuery(name = "Timber1.findAll", query = "SELECT t FROM Timber1 t")
    , @NamedQuery(name = "Timber1.findBySrno", query = "SELECT t FROM Timber1 t WHERE t.srno = :srno")
    , @NamedQuery(name = "Timber1.findByType", query = "SELECT t FROM Timber1 t WHERE t.type = :type")
    , @NamedQuery(name = "Timber1.findByQauntity", query = "SELECT t FROM Timber1 t WHERE t.qauntity = :qauntity")
    , @NamedQuery(name = "Timber1.findByCost", query = "SELECT t FROM Timber1 t WHERE t.cost = :cost")})
public class Timber1 implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "SRNO")
    private Integer srno;
    @Column(name = "TYPE")
    private String type;
    @Column(name = "QAUNTITY")
    private Integer qauntity;
    @Column(name = "COST")
    private Integer cost;

    public Timber1() {
    }

    public Timber1(Integer srno) {
        this.srno = srno;
    }

    public Integer getSrno() {
        return srno;
    }

    public void setSrno(Integer srno) {
        Integer oldSrno = this.srno;
        this.srno = srno;
        changeSupport.firePropertyChange("srno", oldSrno, srno);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        String oldType = this.type;
        this.type = type;
        changeSupport.firePropertyChange("type", oldType, type);
    }

    public Integer getQauntity() {
        return qauntity;
    }

    public void setQauntity(Integer qauntity) {
        Integer oldQauntity = this.qauntity;
        this.qauntity = qauntity;
        changeSupport.firePropertyChange("qauntity", oldQauntity, qauntity);
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        Integer oldCost = this.cost;
        this.cost = cost;
        changeSupport.firePropertyChange("cost", oldCost, cost);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (srno != null ? srno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Timber1)) {
            return false;
        }
        Timber1 other = (Timber1) object;
        if ((this.srno == null && other.srno != null) || (this.srno != null && !this.srno.equals(other.srno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Forest.Timber1[ srno=" + srno + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
