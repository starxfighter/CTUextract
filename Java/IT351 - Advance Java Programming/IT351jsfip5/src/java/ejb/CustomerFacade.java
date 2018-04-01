/**
 * Course: IT351 - Advance Java Programming
 * Filename:ProductFacade.java
 * Module: Enterprise Java Bean Definition for Customer 
 * Created: 09/06/2016
 * Modified:09/06/2016
 * 
 * Purpose: This EJB handles the customer components for the environment. 
 * An EJB web container provides a runtime environment for web related software components, including computer security, Java servlet lifecycle management, 
 * Modification:
 * 
 */
package ejb;

import IT351Sales.Customer;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author User
 */
@Stateless
public class CustomerFacade extends AbstractFacade<Customer> {
    @PersistenceContext(unitName = "IT351jsfPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CustomerFacade() {
        super(Customer.class);
    }
    
}
