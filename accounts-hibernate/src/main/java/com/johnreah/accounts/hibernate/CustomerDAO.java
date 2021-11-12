package com.johnreah.accounts.hibernate;

import com.johnreah.accounts.hibernate.generated.Customer;
import com.johnreah.accounts.hibernate.generated.CustomerHome;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
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
 * The generated CustomerHome class doesn't do much, providing only the thinnest wrapper around 4 basic EntityManager
 * methods. For this reason we hang on to the EntityManager object to provide more DAO functionality. In fact we could
 * easily forget about the generated DAOs altogether.
 *
 * This layer hides the generated entities and DAOs. It exposes whatever methods we choose (including CRUD) and
 * uses POJOs rather than annotated entities to represent objects. CustomerMapper translates between them.
 */
public class CustomerDAO implements DAO<CustomerEntityPOJO> {

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

    @Override
    public void create(CustomerEntityPOJO customerEntityPOJO) {
        Customer customer = CustomerMapper.pojoToEntity(customerEntityPOJO);
        Customer newCustomer = this.customerHome.merge(customer);
        System.out.println("Merged: " + newCustomer.getId());
        customerEntityPOJO.setId(newCustomer.getId()); // TODO - is it ok to modify caller's object or should create return the new object?
    }

    @Override
    public void edit(CustomerEntityPOJO entity) {
    }

    @Override
    public void destroy(CustomerEntityPOJO customerEntityPOJO) {
        Customer customer = CustomerMapper.pojoToEntity(customerEntityPOJO);
        customerHome.remove(customerHome.findById(customerEntityPOJO.getId()));
    }

    @Override
    public List<CustomerEntityPOJO> findAll() {
        return this.find(true, -1, -1);
    }

    @Override
    public List<CustomerEntityPOJO> find(int maxResults, int firstResult) {
        return this.find(false, maxResults, firstResult);
    }

    private List<CustomerEntityPOJO> find(boolean all, int maxResults, int firstResult) {
        CriteriaQuery cq = entityManager.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Customer.class));
        Query q = entityManager.createQuery(cq);
        if (!all) {
            q.setMaxResults(maxResults);
            q.setFirstResult(firstResult);
        }
        List<CustomerEntityPOJO> customerEntityPOJOList = new ArrayList<>();
        q.getResultList().stream().forEach(c -> customerEntityPOJOList.add(CustomerMapper.entityToPOJO((Customer) c)));
        return customerEntityPOJOList;
    }

    @Override
    public CustomerEntityPOJO findById(Long id) {
        return null;
    }

    @Override
    public int count() {
        CriteriaQuery cq = entityManager.getCriteriaBuilder().createQuery();
        Root<Customer> rt = cq.from(Customer.class);
        cq.select(entityManager.getCriteriaBuilder().count(rt));
        Query q = entityManager.createQuery(cq);
        Object o = q.getSingleResult();
        return ((Long) o).intValue();
    }

}
