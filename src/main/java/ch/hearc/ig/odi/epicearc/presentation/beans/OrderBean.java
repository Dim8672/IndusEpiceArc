/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.epicearc.presentation.beans;

import ch.hearc.ig.odi.epicearc.business.Customer;
import ch.hearc.ig.odi.epicearc.business.DeliveryDate;
import ch.hearc.ig.odi.epicearc.business.Order;
import ch.hearc.ig.odi.epicearc.business.PickupDate;
import ch.hearc.ig.odi.epicearc.business.Product;
import ch.hearc.ig.odi.epicearc.exception.IncorrectStateException;
import ch.hearc.ig.odi.epicearc.service.Services;
import javax.inject.Named;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

/**
 *
 * @author dimitri.mella
 */
@Named(value = "orderBean")
@SessionScoped
public class OrderBean implements Serializable {

    /**
     * Injections
     */
    @Inject Services services;
    
    /**
     * Attributes
     */
    Customer customer;
    Product product;
    DeliveryDate deliveryDate;
    PickupDate pickupDate;
    Float deliveryCost;

    /**
     * Creates a new instance of CustomerBean
     */
    public OrderBean(){
        
    }
    
    public String saveOrder(){
        // Instanciate a new order object
        Order order = new Order();
        
        // Define order attributes
        order.setCustomer(customer);
        order.setDeliveryDate(deliveryDate);
        order.setPickupDate(pickupDate);
        order.setProduct(product);
        order.setAmount(product.getPrice() + deliveryCost);
        
        // Save the order
        try {
            services.saveOrder(order);
        } catch (IncorrectStateException ex) {
            Logger.getLogger(OrderBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Return the next page
        return "page-4.xhtml";
    }
    
    public String reOrder(){
        // Reset attributes for new order
        this.product = null;
        this.deliveryDate = null;
        this.pickupDate = null;
        
        // Return the index
        return "index.xhtml";
    }
    
    public String endOrder(){
        // Reset all attributes 
        this.product = null;
        this.deliveryDate = null;
        this.pickupDate = null;
        this.customer = null;
        
        // Return the index
        return "index.xhtml";
    }

    /**
     * Gets the customer.
     * 
     * @return Customer must an instance of the Customer class
     */
    public Customer getCustomer() {
        return customer;
    }
    
    /**
     * Sets the customer.
     * 
     * @param customer 
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    
    /**
     * Gets the product.
     * 
     * @return Product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Sets the product.
     * 
     * @param product must be an instance of the Product class
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * Gets the delivery date.
     * 
     * @return DeliveryDate
     */
    public DeliveryDate getDeliveryDate() {
        return deliveryDate;
    }

    /**
     * Sets the delivery date.
     * 
     * @param deliveryDate must be an instance of the DeliveryDate class
     */
    public void setDeliveryDate(DeliveryDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    /**
     * Gets the pick up date.
     * 
     * @return PickupDate
     */
    public PickupDate getPickupDate() {
        return pickupDate;
    }

    /**
     * Sets the pickup date.
     * 
     * @param pickupDate must be an instance of the PickupDate class
     */
    public void setPickupDate(PickupDate pickupDate) {
        this.pickupDate = pickupDate;
    }

    /**
     * Gets the delivery cost.
     * 
     * @return Float
     */
    public Float getDeliveryCost() {
        return deliveryCost;
    }

    /**
     * Sets the deliveryCost.
     * 
     * @param deliveryCost float
     */
    public void setDeliveryCost(Float deliveryCost) {
        this.deliveryCost = deliveryCost;
    }
    
   
}
