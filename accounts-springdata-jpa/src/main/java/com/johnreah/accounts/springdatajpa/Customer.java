package com.johnreah.accounts.springdatajpa;
// Generated 12 Nov 2021, 17:33:23 by Hibernate Tools 6.0.0.Alpha5

// JR

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

/**
 *             Javadoc for the auto-generated Customer class
 *             inserted by the hibernate.reveng.xml config file
 *         
 */
@Entity
@Table(name="customer"
    ,schema="public"
    , uniqueConstraints = @UniqueConstraint(columnNames={"last_name", "first_name", "email"}) 
)
//JR
public class Customer  implements java.io.Serializable {


      @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    private Long id;
 
    
    @Column(name="last_name")
    private String lastName;
 
    
    @Column(name="first_name")
    private String firstName;
 
    
    @Column(name="email")
    private String email;
 
    
    @Column(name="reference")
    private String reference;
 
@OneToMany(fetch=FetchType.LAZY, mappedBy="customer")
    private Set<LinkCustomerAccount> linkCustomerAccounts = new HashSet<LinkCustomerAccount>(0);

    public Customer() {
    }

    public Customer(String lastName, String firstName, String email, String reference, Set<LinkCustomerAccount> linkCustomerAccounts) {
       this.lastName = lastName;
       this.firstName = firstName;
       this.email = email;
       this.reference = reference;
       this.linkCustomerAccounts = linkCustomerAccounts;
    }
   
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getReference() {
        return this.reference;
    }
    
    public void setReference(String reference) {
        this.reference = reference;
    }
    public Set<LinkCustomerAccount> getLinkCustomerAccounts() {
        return this.linkCustomerAccounts;
    }
    
    public void setLinkCustomerAccounts(Set<LinkCustomerAccount> linkCustomerAccounts) {
        this.linkCustomerAccounts = linkCustomerAccounts;
    }




}


