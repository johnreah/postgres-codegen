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
public class AccountTypeJpaController implements Serializable {

    public AccountTypeJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(AccountType accountType) {
        if (accountType.getAccountCollection() == null) {
            accountType.setAccountCollection(new ArrayList<Account>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Account> attachedAccountCollection = new ArrayList<Account>();
            for (Account accountCollectionAccountToAttach : accountType.getAccountCollection()) {
                accountCollectionAccountToAttach = em.getReference(accountCollectionAccountToAttach.getClass(), accountCollectionAccountToAttach.getId());
                attachedAccountCollection.add(accountCollectionAccountToAttach);
            }
            accountType.setAccountCollection(attachedAccountCollection);
            em.persist(accountType);
            for (Account accountCollectionAccount : accountType.getAccountCollection()) {
                AccountType oldAccountTypeIdOfAccountCollectionAccount = accountCollectionAccount.getAccountTypeId();
                accountCollectionAccount.setAccountTypeId(accountType);
                accountCollectionAccount = em.merge(accountCollectionAccount);
                if (oldAccountTypeIdOfAccountCollectionAccount != null) {
                    oldAccountTypeIdOfAccountCollectionAccount.getAccountCollection().remove(accountCollectionAccount);
                    oldAccountTypeIdOfAccountCollectionAccount = em.merge(oldAccountTypeIdOfAccountCollectionAccount);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(AccountType accountType) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            AccountType persistentAccountType = em.find(AccountType.class, accountType.getId());
            Collection<Account> accountCollectionOld = persistentAccountType.getAccountCollection();
            Collection<Account> accountCollectionNew = accountType.getAccountCollection();
            Collection<Account> attachedAccountCollectionNew = new ArrayList<Account>();
            for (Account accountCollectionNewAccountToAttach : accountCollectionNew) {
                accountCollectionNewAccountToAttach = em.getReference(accountCollectionNewAccountToAttach.getClass(), accountCollectionNewAccountToAttach.getId());
                attachedAccountCollectionNew.add(accountCollectionNewAccountToAttach);
            }
            accountCollectionNew = attachedAccountCollectionNew;
            accountType.setAccountCollection(accountCollectionNew);
            accountType = em.merge(accountType);
            for (Account accountCollectionOldAccount : accountCollectionOld) {
                if (!accountCollectionNew.contains(accountCollectionOldAccount)) {
                    accountCollectionOldAccount.setAccountTypeId(null);
                    accountCollectionOldAccount = em.merge(accountCollectionOldAccount);
                }
            }
            for (Account accountCollectionNewAccount : accountCollectionNew) {
                if (!accountCollectionOld.contains(accountCollectionNewAccount)) {
                    AccountType oldAccountTypeIdOfAccountCollectionNewAccount = accountCollectionNewAccount.getAccountTypeId();
                    accountCollectionNewAccount.setAccountTypeId(accountType);
                    accountCollectionNewAccount = em.merge(accountCollectionNewAccount);
                    if (oldAccountTypeIdOfAccountCollectionNewAccount != null && !oldAccountTypeIdOfAccountCollectionNewAccount.equals(accountType)) {
                        oldAccountTypeIdOfAccountCollectionNewAccount.getAccountCollection().remove(accountCollectionNewAccount);
                        oldAccountTypeIdOfAccountCollectionNewAccount = em.merge(oldAccountTypeIdOfAccountCollectionNewAccount);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = accountType.getId();
                if (findAccountType(id) == null) {
                    throw new NonexistentEntityException("The accountType with id " + id + " no longer exists.");
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
            AccountType accountType;
            try {
                accountType = em.getReference(AccountType.class, id);
                accountType.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The accountType with id " + id + " no longer exists.", enfe);
            }
            Collection<Account> accountCollection = accountType.getAccountCollection();
            for (Account accountCollectionAccount : accountCollection) {
                accountCollectionAccount.setAccountTypeId(null);
                accountCollectionAccount = em.merge(accountCollectionAccount);
            }
            em.remove(accountType);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<AccountType> findAccountTypeEntities() {
        return findAccountTypeEntities(true, -1, -1);
    }

    public List<AccountType> findAccountTypeEntities(int maxResults, int firstResult) {
        return findAccountTypeEntities(false, maxResults, firstResult);
    }

    private List<AccountType> findAccountTypeEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(AccountType.class));
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

    public AccountType findAccountType(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(AccountType.class, id);
        } finally {
            em.close();
        }
    }

    public int getAccountTypeCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<AccountType> rt = cq.from(AccountType.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
