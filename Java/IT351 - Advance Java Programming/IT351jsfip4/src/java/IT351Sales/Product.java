/**
 * Course: IT351 - Advance Java Programming
 * Filename:Product.java
 * Module: Entity Class Definition for the product table 
 * Created: 09/06/2016
 * Modified:09/06/2016
 * 
 * Purpose: This class definition provides the methods used to directly interact with the product table. This is used by the EJBand the JSF to make it a seamless interaction.
 * Modification:
 * 
 */
package IT351Sales;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
    @NamedQuery(name = "Product.findByPID", query = "SELECT p FROM Product p WHERE p.pID = :pID"),
    @NamedQuery(name = "Product.findByPPrice", query = "SELECT p FROM Product p WHERE p.pPrice = :pPrice")})
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "pID")
    private Integer pID;
    @Lob
    @Size(max = 65535)
    @Column(name = "pName")
    private String pName;
    @Lob
    @Size(max = 65535)
    @Column(name = "pDescription")
    private String pDescription;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "pPrice")
    private BigDecimal pPrice;

    public Product() {
    }

    public Product(Integer pID) {
        this.pID = pID;
    }

    public Integer getPID() {
        return pID;
    }

    public void setPID(Integer pID) {
        this.pID = pID;
    }

    public String getPName() {
        return pName;
    }

    public void setPName(String pName) {
        this.pName = pName;
    }

    public String getPDescription() {
        return pDescription;
    }

    public void setPDescription(String pDescription) {
        this.pDescription = pDescription;
    }

    public BigDecimal getPPrice() {
        return pPrice;
    }

    public void setPPrice(BigDecimal pPrice) {
        this.pPrice = pPrice;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pID != null ? pID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.pID == null && other.pID != null) || (this.pID != null && !this.pID.equals(other.pID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "IT351Sales.Product[ pID=" + pID + " ]";
    }
    
}
