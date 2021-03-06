/*
 * Created on 2021-11-04 ( Date ISO 2021-11-04 - Time 13:31:50 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.4.0
 */

package com.johnreah.accounts.telosysjpa.generated.persistence.impl.jpa.record;

import java.io.Serializable;


import javax.persistence.*;

/**
 * Persistent class for "AccountType" entity stored in table "account_type" <br>
 * This class is a "record entity" without JPA links  <br>
 *
 * @author Telosys
 *
 */
@Entity
@Table(name="account_type", schema="public" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="AccountTypeJpaRecord.countAll",  query="SELECT COUNT(x) FROM AccountTypeJpaRecord x" ),
  @NamedQuery ( name="AccountTypeJpaRecord.countById", query="SELECT COUNT(x) FROM AccountTypeJpaRecord x WHERE x.id = ?1 " )
} )
public class AccountTypeJpaRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id", nullable=false)
    private Long       id           ; 

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="description", length=2147483647)
    private String     description  ; 

    @Column(name="reference", length=2147483647)
    private String     reference    ; 


    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public AccountTypeJpaRecord() {
		super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setId( Long id ) {
        this.id = id ;
    }
    public Long getId() {
        return this.id;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : description ( text ) 
    public void setDescription( String description ) {
        this.description = description;
    }
    public String getDescription() {
        return this.description;
    }

    //--- DATABASE MAPPING : reference ( text ) 
    public void setReference( String reference ) {
        this.reference = reference;
    }
    public String getReference() {
        return this.reference;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuilder sb = new StringBuilder(); 
        sb.append("["); 
        sb.append(id);
        sb.append("]:"); 
        sb.append(description);
        sb.append("|");
        sb.append(reference);
        return sb.toString(); 
    } 

}
