/**
 * Course: IT351 - Advance Java Programming
 * Filename:Customer.java
 * Module: Entity Class Definition for the customer table 
 * Created: 09/06/2016
 * Modified:09/06/2016
 * 
 * Purpose: This class definition provides the methods used to directly interact with the customer table. This is used by the EJBand the JSF to make it a seamless interaction.
 * Modification:
 * 
 */
package IT351Sales;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Duane Osburn
 */
@Entity
@Table(name = "customer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c"),
    @NamedQuery(name = "Customer.findByCID", query = "SELECT c FROM Customer c WHERE c.cID = :cID"),
    @NamedQuery(name = "Customer.findByCZipCode", query = "SELECT c FROM Customer c WHERE c.cZipCode = :cZipCode")})
public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cID")
    private Integer cID;
    @Lob
    @Size(max = 65535)
    @Column(name = "cFirstName")
    private String cFirstName;
    @Lob
    @Size(max = 65535)
    @Column(name = "cLastName")
    private String cLastName;
    @Lob
    @Size(max = 65535)
    @Column(name = "cAddress")
    private String cAddress;
    @Lob
    @Size(max = 65535)
    @Column(name = "cCity")
    private String cCity;
    @Lob
    @Size(max = 65535)
    @Column(name = "cState")
    private String cState;
    @Column(name = "cZipCode")
    private Integer cZipCode;
    @Lob
    @Size(max = 65535)
    @Column(name = "cPhone")
    private String cPhone;

    public Customer() {
    }

    public Customer(Integer cID) {
        this.cID = cID;
    }

    public Integer getCID() {
        return cID;
    }

    public void setCID(Integer cID) {
        this.cID = cID;
    }

    public String getCFirstName() {
        return cFirstName;
    }

    public void setCFirstName(String cFirstName) {
        this.cFirstName = cFirstName;
    }

    public String getCLastName() {
        return cLastName;
    }

    public void setCLastName(String cLastName) {
        this.cLastName = cLastName;
    }

    public String getCAddress() {
        return cAddress;
    }

    public void setCAddress(String cAddress) {
        this.cAddress = cAddress;
    }

    public String getCCity() {
        return cCity;
    }

    public void setCCity(String cCity) {
        this.cCity = cCity;
    }

    public String getCState() {
        return cState;
    }

    public void setCState(String cState) {
        this.cState = cState;
    }

    public Integer getCZipCode() {
        return cZipCode;
    }

    public void setCZipCode(Integer cZipCode) {
        this.cZipCode = cZipCode;
    }

    public String getCPhone() {
        return cPhone;
    }

    public void setCPhone(String cPhone) {
        this.cPhone = cPhone;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cID != null ? cID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.cID == null && other.cID != null) || (this.cID != null && !this.cID.equals(other.cID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "IT351Sales.Customer[ cID=" + cID + " ]";
    }
    
}
