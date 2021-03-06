/*
 * Created on 2021-11-04 ( Date ISO 2021-11-04 - Time 13:31:50 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.4.0
 */
package com.johnreah.accounts.telosysjpa.generated.persistence.impl.jpa.record;
import java.io.Serializable;

import javax.persistence.*;

/**
 * Composite primary key for entity "LinkCustomerAccount" ( stored in table "link_customer_account" )
 *
 * @author Telosys
 *
 */
 @Embeddable
public class LinkCustomerAccountJpaRecordKey implements Serializable {
    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY KEY ATTRIBUTES 
    //----------------------------------------------------------------------
    @Column(name="customer_id", nullable=false)
    private Long       customerId   ;
    
    @Column(name="account_id", nullable=false)
    private Long       accountId    ;
    

    //----------------------------------------------------------------------
    // CONSTRUCTORS
    //----------------------------------------------------------------------
    public LinkCustomerAccountJpaRecordKey() {
        super();
    }

    public LinkCustomerAccountJpaRecordKey( Long customerId, Long accountId ) {
        super();
        this.customerId = customerId ;
        this.accountId = accountId ;
    }
    
    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR KEY FIELDS
    //----------------------------------------------------------------------
    public void setCustomerId( Long value ) {
        this.customerId = value;
    }
    public Long getCustomerId() {
        return this.customerId;
    }

    public void setAccountId( Long value ) {
        this.accountId = value;
    }
    public Long getAccountId() {
        return this.accountId;
    }


    //----------------------------------------------------------------------
    // equals METHOD
    //----------------------------------------------------------------------
	public boolean equals(Object obj) { 
		if ( this == obj ) return true ; 
		if ( obj == null ) return false ;
		if ( this.getClass() != obj.getClass() ) return false ; 
		LinkCustomerAccountJpaRecordKey other = (LinkCustomerAccountJpaRecordKey) obj; 
		//--- Attribute customerId
		if ( customerId == null ) { 
			if ( other.customerId != null ) 
				return false ; 
		} else if ( ! customerId.equals(other.customerId) ) 
			return false ; 
		//--- Attribute accountId
		if ( accountId == null ) { 
			if ( other.accountId != null ) 
				return false ; 
		} else if ( ! accountId.equals(other.accountId) ) 
			return false ; 
		return true; 
	} 


    //----------------------------------------------------------------------
    // hashCode METHOD
    //----------------------------------------------------------------------
	public int hashCode() { 
		final int prime = 31; 
		int result = 1; 
		
		//--- Attribute customerId
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode() ) ; 
		//--- Attribute accountId
		result = prime * result + ((accountId == null) ? 0 : accountId.hashCode() ) ; 
		
		return result; 
	} 


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() {
		StringBuffer sb = new StringBuffer(); 
		sb.append(customerId); 
		sb.append("|"); 
		sb.append(accountId); 
        return sb.toString();
    }
}
