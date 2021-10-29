/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.johnreah.accounts.netbeans.generated;

import com.johnreah.accounts.netbeans.generated.exceptions.NonexistentEntityException;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author johnreah
 */
public class AccountHistoryJpaController implements Serializable {

    public AccountHistoryJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(AccountHistory accountHistory) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Account accountId = accountHistory.getAccountId();
            if (accountId != null) {
                accountId = em.getReference(accountId.getClass(), accountId.getId());
                accountHistory.setAccountId(accountId);
            }
            em.persist(accountHistory);
            if (accountId != null) {
                accountId.getAccountHistoryCollection().add(accountHistory);
                accountId = em.merge(accountId);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(AccountHistory accountHistory) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            AccountHistory persistentAccountHistory = em.find(AccountHistory.class, accountHistory.getId());
            Account accountIdOld = persistentAccountHistory.getAccountId();
            Account accountIdNew = accountHistory.getAccountId();
            if (accountIdNew != null) {
                accountIdNew = em.getReference(accountIdNew.getClass(), accountIdNew.getId());
                accountHistory.setAccountId(accountIdNew);
            }
            accountHistory = em.merge(accountHistory);
            if (accountIdOld != null && !accountIdOld.equals(accountIdNew)) {
                accountIdOld.getAccountHistoryCollection().remove(accountHistory);
                accountIdOld = em.merge(accountIdOld);
            }
            if (accountIdNew != null && !accountIdNew.equals(accountIdOld)) {
                accountIdNew.getAccountHistoryCollection().add(accountHistory);
                accountIdNew = em.merge(accountIdNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = accountHistory.getId();
                if (findAccountHistory(id) == null) {
                    throw new NonexistentEntityException("The accountHistory with id " + id + " no longer exists.");
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
            AccountHistory accountHistory;
            try {
                accountHistory = em.getReference(AccountHistory.class, id);
                accountHistory.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The accountHistory with id " + id + " no longer exists.", enfe);
            }
            Account accountId = accountHistory.getAccountId();
            if (accountId != null) {
                accountId.getAccountHistoryCollection().remove(accountHistory);
                accountId = em.merge(accountId);
            }
            em.remove(accountHistory);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<AccountHistory> findAccountHistoryEntities() {
        return findAccountHistoryEntities(true, -1, -1);
    }

    public List<AccountHistory> findAccountHistoryEntities(int maxResults, int firstResult) {
        return findAccountHistoryEntities(false, maxResults, firstResult);
    }

    private List<AccountHistory> findAccountHistoryEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(AccountHistory.class));
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

    public AccountHistory findAccountHistory(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(AccountHistory.class, id);
        } finally {
            em.close();
        }
    }

    public int getAccountHistoryCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<AccountHistory> rt = cq.from(AccountHistory.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
