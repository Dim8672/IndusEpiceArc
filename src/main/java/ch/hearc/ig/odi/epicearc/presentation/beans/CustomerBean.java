/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.epicearc.presentation.beans;

import ch.hearc.ig.odi.epicearc.business.Customer;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author dimitri.mella
 */
@Named(value = "customerBean")
@RequestScoped
public class CustomerBean  {
    
    /**
     * Injections
     */
    @Inject OrderBean order;
    
    /**
     * Attributes
     */
    private Customer customer;
    
    /**
     * Don't recreate the customer if already exists.
     */
    @PostConstruct
     public void init() {
        if (order.getCustomer() != null) {
            customer = order.getCustomer();
        } else {
            customer = new Customer();
        }
    }

    /**
     * Create a new user while instanciating.
     */
    public CustomerBean() {
        customer = new Customer();
    }
    
    /**
     * Adds the customer to the OrderBean
     * 
     * @return String
     */
    public String addCustomer(){
        order.setCustomer(this.customer);
        return "page-3.xhtml";
    }

    /**
     * Gets the customer.
     * 
     * @return Customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Sets the customer.
     * 
     * @param customer must be an instance of the Customer class
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }    
}
