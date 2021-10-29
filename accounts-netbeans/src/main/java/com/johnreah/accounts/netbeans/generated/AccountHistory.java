/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.johnreah.accounts.netbeans.generated;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author johnreah
 */
@Entity
@Table(name = "account_history")
@NamedQueries({
    @NamedQuery(name = "AccountHistory.findAll", query = "SELECT a FROM AccountHistory a"),
    @NamedQuery(name = "AccountHistory.findById", query = "SELECT a FROM AccountHistory a WHERE a.id = :id"),
    @NamedQuery(name = "AccountHistory.findByTimeStamp", query = "SELECT a FROM AccountHistory a WHERE a.timeStamp = :timeStamp"),
    @NamedQuery(name = "AccountHistory.findByAccount", query = "SELECT a FROM AccountHistory a WHERE a.account = :account"),
    @NamedQuery(name = "AccountHistory.findByBalance", query = "SELECT a FROM AccountHistory a WHERE a.balance = :balance"),
    @NamedQuery(name = "AccountHistory.findByDescription", query = "SELECT a FROM AccountHistory a WHERE a.description = :description")})
public class AccountHistory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "time_stamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeStamp;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "account")
    private Double account;
    @Column(name = "balance")
    private Double balance;
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    @ManyToOne
    private Account accountId;

    public AccountHistory() {
    }

    public AccountHistory(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Double getAccount() {
        return account;
    }

    public void setAccount(Double account) {
        this.account = account;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Account getAccountId() {
        return accountId;
    }

    public void setAccountId(Account accountId) {
        this.accountId = accountId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccountHistory)) {
            return false;
        }
        AccountHistory other = (AccountHistory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.johnreah.accounts.netbeans.generated.AccountHistory[ id=" + id + " ]";
    }
    
}
