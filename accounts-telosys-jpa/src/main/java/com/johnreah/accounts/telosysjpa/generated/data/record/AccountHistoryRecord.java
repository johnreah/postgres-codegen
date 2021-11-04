/*
 * Created on 2021-11-04 ( Date ISO 2021-11-04 - Time 13:31:49 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.4.0
 */


package com.johnreah.accounts.telosysjpa.generated.data.record;

import java.io.Serializable;
import javax.validation.constraints.*;

import java.time.LocalDateTime;

/**
 * Java bean for entity "account_history" <br>
 * Contains only "wrapper types" (no primitive types) <br>
 * Can be used both as a "web form" and "persistence record" <br>
 * 
 * @author Telosys Tools Generator
 *
 */
public class AccountHistoryRecord implements Serializable
{
    private static final long serialVersionUID = 1L;

    @NotNull
    private Long id ; // Long // Id or Primary Key


    private Long accountId ;  // Long 

    private LocalDateTime timeStamp ;  // LocalDateTime 

    private Double account ;  // Double 

    private Double balance ;  // Double 
    @Size( max = 2147483647 )
    private String description ;  // String 

    /**
     * Default constructor
     */
    public AccountHistoryRecord() {
        super();
    }
    
    //----------------------------------------------------------------------
    // GETTER(S) & SETTER(S) FOR ID OR PRIMARY KEY 
    //----------------------------------------------------------------------
    /**
     * Set the "id" field value
     * This field is mapped on the database column "id" ( type "bigserial", NotNull : true ) 
     * @param id
     */
	public void setId( Long id ) {
        this.id = id ;
    }
    /**
     * Get the "id" field value
     * This field is mapped on the database column "id" ( type "bigserial", NotNull : true ) 
     * @return the field value
     */
	public Long getId() {
        return this.id;
    }

    //----------------------------------------------------------------------
    // GETTER(S) & SETTER(S) FOR OTHER DATA FIELDS 
    //----------------------------------------------------------------------

    /**
     * Set the "accountId" field value
     * This field is mapped on the database column "account_id" ( type "int8", NotNull : false ) 
     * @param accountId
     */
    public void setAccountId( Long accountId ) {
        this.accountId = accountId;
    }
    /**
     * Get the "accountId" field value
     * This field is mapped on the database column "account_id" ( type "int8", NotNull : false ) 
     * @return the field value
     */
    public Long getAccountId() {
        return this.accountId;
    }

    /**
     * Set the "timeStamp" field value
     * This field is mapped on the database column "time_stamp" ( type "timestamptz", NotNull : false ) 
     * @param timeStamp
     */
    public void setTimeStamp( LocalDateTime timeStamp ) {
        this.timeStamp = timeStamp;
    }
    /**
     * Get the "timeStamp" field value
     * This field is mapped on the database column "time_stamp" ( type "timestamptz", NotNull : false ) 
     * @return the field value
     */
    public LocalDateTime getTimeStamp() {
        return this.timeStamp;
    }

    /**
     * Set the "account" field value
     * This field is mapped on the database column "account" ( type "float8", NotNull : false ) 
     * @param account
     */
    public void setAccount( Double account ) {
        this.account = account;
    }
    /**
     * Get the "account" field value
     * This field is mapped on the database column "account" ( type "float8", NotNull : false ) 
     * @return the field value
     */
    public Double getAccount() {
        return this.account;
    }

    /**
     * Set the "balance" field value
     * This field is mapped on the database column "balance" ( type "float8", NotNull : false ) 
     * @param balance
     */
    public void setBalance( Double balance ) {
        this.balance = balance;
    }
    /**
     * Get the "balance" field value
     * This field is mapped on the database column "balance" ( type "float8", NotNull : false ) 
     * @return the field value
     */
    public Double getBalance() {
        return this.balance;
    }

    /**
     * Set the "description" field value
     * This field is mapped on the database column "description" ( type "text", NotNull : false ) 
     * @param description
     */
    public void setDescription( String description ) {
        this.description = description;
    }
    /**
     * Get the "description" field value
     * This field is mapped on the database column "description" ( type "text", NotNull : false ) 
     * @return the field value
     */
    public String getDescription() {
        return this.description;
    }

    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    @Override
    public String toString() { 
        StringBuilder sb = new StringBuilder(); 
        sb.append(id);
        sb.append("|");
        sb.append(accountId);
        sb.append("|");
        sb.append(timeStamp);
        sb.append("|");
        sb.append(account);
        sb.append("|");
        sb.append(balance);
        sb.append("|");
        sb.append(description);
        return sb.toString(); 
    } 



}