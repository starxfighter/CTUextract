/**
 * Course: IT351 - Advance Java Programming
 * Filename:ProductFacade.java
 * Module: Enterprise Java Bean Definition for Product 
 * Created: 09/06/2016
 * Modified:09/06/2016
 * 
 * Purpose: This EJB handles the product components for the environment. 
 * An EJB web container provides a runtime environment for web related software components, including computer security, Java servlet lifecycle management, 
 * Modification:
 * 
 */
package ejb;

import IT351Sales.Product;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author User
 */
@Stateless
public class ProductFacade extends AbstractFacade<Product> {
    @PersistenceContext(unitName = "IT351jsfPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductFacade() {
        super(Product.class);
    }
    
}
