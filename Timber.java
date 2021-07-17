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
@Table(name = "TIMBER", catalog = "", schema = "APP")
@NamedQueries({
    @NamedQuery(name = "Timber.findAll", query = "SELECT t FROM Timber t")
    , @NamedQuery(name = "Timber.findByType", query = "SELECT t FROM Timber t WHERE t.type = :type")
    , @NamedQuery(name = "Timber.findByQuantity", query = "SELECT t FROM Timber t WHERE t.quantity = :quantity")
    , @NamedQuery(name = "Timber.findBySrno", query = "SELECT t FROM Timber t WHERE t.srno = :srno")})
public class Timber implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Column(name = "TYPE")
    private String type;
    @Column(name = "QUANTITY")
    private Integer quantity;
    @Id
    @Basic(optional = false)
    @Column(name = "SRNO")
    private Integer srno;

    public Timber() {
    }

    public Timber(Integer srno) {
        this.srno = srno;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        String oldType = this.type;
        this.type = type;
        changeSupport.firePropertyChange("type", oldType, type);
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        Integer oldQuantity = this.quantity;
        this.quantity = quantity;
        changeSupport.firePropertyChange("quantity", oldQuantity, quantity);
    }

    public Integer getSrno() {
        return srno;
    }

    public void setSrno(Integer srno) {
        Integer oldSrno = this.srno;
        this.srno = srno;
        changeSupport.firePropertyChange("srno", oldSrno, srno);
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
        if (!(object instanceof Timber)) {
            return false;
        }
        Timber other = (Timber) object;
        if ((this.srno == null && other.srno != null) || (this.srno != null && !this.srno.equals(other.srno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Forest.Timber[ srno=" + srno + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
