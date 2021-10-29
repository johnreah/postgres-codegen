package com.johnreah.accounts.hibernate;

import com.johnreah.accounts.hibernate.generated.Customer;
import com.johnreah.accounts.hibernate.generated.CustomerHome;

import java.lang.reflect.Field;
import java.util.List;
import java.util.UUID;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * DAO wrapper for the Hibernate auto-generated CustomerHome class.
 * The CustomerHome class has limited functionality and expects an EntityManager to be
 * injected by the container. This DAO is constructed with an EntityManager and injects
 * it into the auto-generated version. It also adds any other DAO methods required
 * by the application.
 *
 * @author johnreah
 */
public class CustomerDAO {

    private EntityManager entityManager;
    private CustomerHome customerHome;

    public CustomerDAO(EntityManager entityManager) throws InstantiationException, IllegalAccessException, NoSuchFieldException {
        this.entityManager = entityManager;

        // Inject EntityManager into auto-generated class. TODO: this is a bit of a hack.
        this.customerHome = CustomerHome.class.newInstance();
        Field field = customerHome.getClass().getDeclaredField("entityManager");
        field.setAccessible(true);
        field.set(customerHome, this.entityManager);
    }

    public Customer createNewCustomer(String firstName, String lastName, String email) {
        Customer c = new Customer();
        c.setFirstName(firstName);
        c.setLastName(lastName);
        c.setEmail(email);
        c.setReference("C" + UUID.randomUUID().toString().replace("-", "").substring(0, 8));
        entityManager.getTransaction().begin();
        this.customerHome.persist(c);
        entityManager.getTransaction().commit();//TODO: why is @Id not populated??
        System.out.println("id " + c.getId());
        return c;
    }

    public int countCustomers() {
        CriteriaQuery cq = entityManager.getCriteriaBuilder().createQuery();
        Root<Customer> rt = cq.from(Customer.class);
        cq.select(entityManager.getCriteriaBuilder().count(rt));
        Query q = entityManager.createQuery(cq);
        Object o = q.getSingleResult();
        return ((Long) o).intValue();
    }

    public List<Customer> findAllCustomers() {
        return this.findCustomerEntities(true, -1, -1);
    }

    private List<Customer> findCustomerEntities(boolean all, int maxResults, int firstResult) {
        CriteriaQuery cq = entityManager.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Customer.class));
        Query q = entityManager.createQuery(cq);
        if (!all) {
            q.setMaxResults(maxResults);
            q.setFirstResult(firstResult);
        }
        return q.getResultList();
    }

}
