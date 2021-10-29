/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.johnreah.accounts.netbeans.generated;

import com.johnreah.accounts.netbeans.generated.exceptions.NonexistentEntityException;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author johnreah
 */
public class AccountJpaController implements Serializable {

    public AccountJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Account account) {
        if (account.getCustomerCollection() == null) {
            account.setCustomerCollection(new ArrayList<Customer>());
        }
        if (account.getAccountHistoryCollection() == null) {
            account.setAccountHistoryCollection(new ArrayList<AccountHistory>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            AccountType accountTypeId = account.getAccountTypeId();
            if (accountTypeId != null) {
                accountTypeId = em.getReference(accountTypeId.getClass(), accountTypeId.getId());
                account.setAccountTypeId(accountTypeId);
            }
            Collection<Customer> attachedCustomerCollection = new ArrayList<Customer>();
            for (Customer customerCollectionCustomerToAttach : account.getCustomerCollection()) {
                customerCollectionCustomerToAttach = em.getReference(customerCollectionCustomerToAttach.getClass(), customerCollectionCustomerToAttach.getId());
                attachedCustomerCollection.add(customerCollectionCustomerToAttach);
            }
            account.setCustomerCollection(attachedCustomerCollection);
            Collection<AccountHistory> attachedAccountHistoryCollection = new ArrayList<AccountHistory>();
            for (AccountHistory accountHistoryCollectionAccountHistoryToAttach : account.getAccountHistoryCollection()) {
                accountHistoryCollectionAccountHistoryToAttach = em.getReference(accountHistoryCollectionAccountHistoryToAttach.getClass(), accountHistoryCollectionAccountHistoryToAttach.getId());
                attachedAccountHistoryCollection.add(accountHistoryCollectionAccountHistoryToAttach);
            }
            account.setAccountHistoryCollection(attachedAccountHistoryCollection);
            em.persist(account);
            if (accountTypeId != null) {
                accountTypeId.getAccountCollection().add(account);
                accountTypeId = em.merge(accountTypeId);
            }
            for (Customer customerCollectionCustomer : account.getCustomerCollection()) {
                customerCollectionCustomer.getAccountCollection().add(account);
                customerCollectionCustomer = em.merge(customerCollectionCustomer);
            }
            for (AccountHistory accountHistoryCollectionAccountHistory : account.getAccountHistoryCollection()) {
                Account oldAccountIdOfAccountHistoryCollectionAccountHistory = accountHistoryCollectionAccountHistory.getAccountId();
                accountHistoryCollectionAccountHistory.setAccountId(account);
                accountHistoryCollectionAccountHistory = em.merge(accountHistoryCollectionAccountHistory);
                if (oldAccountIdOfAccountHistoryCollectionAccountHistory != null) {
                    oldAccountIdOfAccountHistoryCollectionAccountHistory.getAccountHistoryCollection().remove(accountHistoryCollectionAccountHistory);
                    oldAccountIdOfAccountHistoryCollectionAccountHistory = em.merge(oldAccountIdOfAccountHistoryCollectionAccountHistory);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Account account) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Account persistentAccount = em.find(Account.class, account.getId());
            AccountType accountTypeIdOld = persistentAccount.getAccountTypeId();
            AccountType accountTypeIdNew = account.getAccountTypeId();
            Collection<Customer> customerCollectionOld = persistentAccount.getCustomerCollection();
            Collection<Customer> customerCollectionNew = account.getCustomerCollection();
            Collection<AccountHistory> accountHistoryCollectionOld = persistentAccount.getAccountHistoryCollection();
            Collection<AccountHistory> accountHistoryCollectionNew = account.getAccountHistoryCollection();
            if (accountTypeIdNew != null) {
                accountTypeIdNew = em.getReference(accountTypeIdNew.getClass(), accountTypeIdNew.getId());
                account.setAccountTypeId(accountTypeIdNew);
            }
            Collection<Customer> attachedCustomerCollectionNew = new ArrayList<Customer>();
            for (Customer customerCollectionNewCustomerToAttach : customerCollectionNew) {
                customerCollectionNewCustomerToAttach = em.getReference(customerCollectionNewCustomerToAttach.getClass(), customerCollectionNewCustomerToAttach.getId());
                attachedCustomerCollectionNew.add(customerCollectionNewCustomerToAttach);
            }
            customerCollectionNew = attachedCustomerCollectionNew;
            account.setCustomerCollection(customerCollectionNew);
            Collection<AccountHistory> attachedAccountHistoryCollectionNew = new ArrayList<AccountHistory>();
            for (AccountHistory accountHistoryCollectionNewAccountHistoryToAttach : accountHistoryCollectionNew) {
                accountHistoryCollectionNewAccountHistoryToAttach = em.getReference(accountHistoryCollectionNewAccountHistoryToAttach.getClass(), accountHistoryCollectionNewAccountHistoryToAttach.getId());
                attachedAccountHistoryCollectionNew.add(accountHistoryCollectionNewAccountHistoryToAttach);
            }
            accountHistoryCollectionNew = attachedAccountHistoryCollectionNew;
            account.setAccountHistoryCollection(accountHistoryCollectionNew);
            account = em.merge(account);
            if (accountTypeIdOld != null && !accountTypeIdOld.equals(accountTypeIdNew)) {
                accountTypeIdOld.getAccountCollection().remove(account);
                accountTypeIdOld = em.merge(accountTypeIdOld);
            }
            if (accountTypeIdNew != null && !accountTypeIdNew.equals(accountTypeIdOld)) {
                accountTypeIdNew.getAccountCollection().add(account);
                accountTypeIdNew = em.merge(accountTypeIdNew);
            }
            for (Customer customerCollectionOldCustomer : customerCollectionOld) {
                if (!customerCollectionNew.contains(customerCollectionOldCustomer)) {
                    customerCollectionOldCustomer.getAccountCollection().remove(account);
                    customerCollectionOldCustomer = em.merge(customerCollectionOldCustomer);
                }
            }
            for (Customer customerCollectionNewCustomer : customerCollectionNew) {
                if (!customerCollectionOld.contains(customerCollectionNewCustomer)) {
                    customerCollectionNewCustomer.getAccountCollection().add(account);
                    customerCollectionNewCustomer = em.merge(customerCollectionNewCustomer);
                }
            }
            for (AccountHistory accountHistoryCollectionOldAccountHistory : accountHistoryCollectionOld) {
                if (!accountHistoryCollectionNew.contains(accountHistoryCollectionOldAccountHistory)) {
                    accountHistoryCollectionOldAccountHistory.setAccountId(null);
                    accountHistoryCollectionOldAccountHistory = em.merge(accountHistoryCollectionOldAccountHistory);
                }
            }
            for (AccountHistory accountHistoryCollectionNewAccountHistory : accountHistoryCollectionNew) {
                if (!accountHistoryCollectionOld.contains(accountHistoryCollectionNewAccountHistory)) {
                    Account oldAccountIdOfAccountHistoryCollectionNewAccountHistory = accountHistoryCollectionNewAccountHistory.getAccountId();
                    accountHistoryCollectionNewAccountHistory.setAccountId(account);
                    accountHistoryCollectionNewAccountHistory = em.merge(accountHistoryCollectionNewAccountHistory);
                    if (oldAccountIdOfAccountHistoryCollectionNewAccountHistory != null && !oldAccountIdOfAccountHistoryCollectionNewAccountHistory.equals(account)) {
                        oldAccountIdOfAccountHistoryCollectionNewAccountHistory.getAccountHistoryCollection().remove(accountHistoryCollectionNewAccountHistory);
                        oldAccountIdOfAccountHistoryCollectionNewAccountHistory = em.merge(oldAccountIdOfAccountHistoryCollectionNewAccountHistory);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = account.getId();
                if (findAccount(id) == null) {
                    throw new NonexistentEntityException("The account with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Account account;
            try {
                account = em.getReference(Account.class, id);
                account.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The account with id " + id + " no longer exists.", enfe);
            }
            AccountType accountTypeId = account.getAccountTypeId();
            if (accountTypeId != null) {
                accountTypeId.getAccountCollection().remove(account);
                accountTypeId = em.merge(accountTypeId);
            }
            Collection<Customer> customerCollection = account.getCustomerCollection();
            for (Customer customerCollectionCustomer : customerCollection) {
                customerCollectionCustomer.getAccountCollection().remove(account);
                customerCollectionCustomer = em.merge(customerCollectionCustomer);
            }
            Collection<AccountHistory> accountHistoryCollection = account.getAccountHistoryCollection();
            for (AccountHistory accountHistoryCollectionAccountHistory : accountHistoryCollection) {
                accountHistoryCollectionAccountHistory.setAccountId(null);
                accountHistoryCollectionAccountHistory = em.merge(accountHistoryCollectionAccountHistory);
            }
            em.remove(account);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Account> findAccountEntities() {
        return findAccountEntities(true, -1, -1);
    }

    public List<Account> findAccountEntities(int maxResults, int firstResult) {
        return findAccountEntities(false, maxResults, firstResult);
    }

    private List<Account> findAccountEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Account.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Account findAccount(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Account.class, id);
        } finally {
            em.close();
        }
    }

    public int getAccountCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Account> rt = cq.from(Account.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
