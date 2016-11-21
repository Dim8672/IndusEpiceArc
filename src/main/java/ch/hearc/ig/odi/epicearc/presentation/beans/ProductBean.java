/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.epicearc.presentation.beans;

import ch.hearc.ig.odi.epicearc.business.ConiferType;
import ch.hearc.ig.odi.epicearc.business.DeliveryDate;
import ch.hearc.ig.odi.epicearc.business.PickupDate;
import ch.hearc.ig.odi.epicearc.business.Product;
import ch.hearc.ig.odi.epicearc.service.Services;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.inject.Inject;

/**
 *
 * @author benjamin.boldt
 */
@Named(value = "productBean")
@SessionScoped
public class ProductBean implements Serializable {
    
    /**
     * Injections
     */
    @Inject OrderBean order;
    @Inject Services services;
    
    /**
     * Attributes
     */
    private List<Product> products;
    private List<DeliveryDate> deliveryDates;
    private List<PickupDate> pickupDates;
    
    private Product product;
    private ConiferType coniferType;
    private DeliveryDate deliveryDate;
    private PickupDate pickupDate;

    /**
     * Creates a new instance of ProductBean
     */
    public ProductBean() {
        
    }
    
    /**
     * Saves the product with/to the OrderBean
     * 
     * @return page-2.xhtml Go to page 2
     */
    
    public String addProduct() { 
        
        // Define the order with class attributes
        product.setConiferType(this.coniferType);
        order.setProduct(this.product);
        order.setDeliveryDate((DeliveryDate)services.getAbstractDateWithId(this.deliveryDate.getId()));
        order.setPickupDate((PickupDate)services.getAbstractDateWithId(this.pickupDate.getId()));
        order.setDeliveryCost(services.getTransportCosts());
        
        // Reset the attributes
        this.deliveryDate = null;
        this.pickupDate = null;
        this.product = null;
        this.coniferType = null;
        
        // Return the next page
        return "page-2.xhtml";
    }
    
    /**
     * Gets the list of available conifer types.
     * 
     * @return List of ConiferType
     */
    public List<ConiferType> getConiferTypes() {
        return services.getConiferTypes();
    }
    
    
    /**
     * Populate the products list with the available products for 
     * the conifer type that is given.
     * 
     */
    public void selectProductsForConiferType() {
        
        // Reset dates if already set.
        this.deliveryDates = null;
        this.pickupDates = null;
        
        // Get products based on the conifer type.
        products = services.getProductsForConiferType(this.coniferType);
        
    }
    
    /**
     * Populate the Delivery and Pickups dates based on the
     * product given.
     */
    public void selectDeliveryAndPickupDatesForProduct() {
        deliveryDates = services.getDeliveryDatesForProduct(this.product);
        pickupDates = services.getPickupDatesForProduct(this.product);
    }

    /**
     * Gets the conifer type.
     * 
     * @return ConiferType
     */
    public ConiferType getConiferType() {
        return coniferType;
    }

    /**
     * Sets the conifer type.
     * 
     * @param coniferType must be an instance of ConiferType class
     */
    public void setConiferType(ConiferType coniferType) {
        this.coniferType = coniferType;
    }

    /**
     * Gets the product.
     * 
     * @return Products
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Sets the product.
     * 
     * @param product must be an instance of Product class
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * Gets the list of products.
     * 
     * @return List of Product 
     */
    public List<Product> getProducts() {
        return products;
    }

    /**
     * Sets the list of products.
     * 
     * @param products must be a list of instances of Product class
     */
    public void setProducts(List<Product> products) {
        this.products = products;
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
     * @param deliveryDate must be an instance of DeliveryDate class
     */
    public void setDeliveryDate(DeliveryDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    /**
     * Gets the list of available delivery dates.
     * 
     * @return List of DeliveryDate
     */
    public List<DeliveryDate> getDeliveryDates() {
        return deliveryDates;
    }

    /**
     * Sets the list of available delivery dates.
     * 
     * @param deliveryDates must be a list of instances of DeliveryDate class
     */
    public void setDeliveryDates(List<DeliveryDate> deliveryDates) {
        this.deliveryDates = deliveryDates;
    }

    /**
     * Gets the list of available pickup dates.
     * 
     * @return List of PickupDate
     */
    public List<PickupDate> getPickupDates() {
        return pickupDates;
    }

    /**
     * Sets the list of available pickup dates.
     * 
     * @param pickupDates must be a list of instances of PickupDate class
     */
    public void setPickupDates(List<PickupDate> pickupDates) {
        this.pickupDates = pickupDates;
    }

    /**
     * Gets the pickup date.
     * 
     * @return PickupDate
     */
    public PickupDate getPickupDate() {
        return pickupDate;
    }

    /**
     * Sets the pickup date.
     * 
     * @param pickupDate must be an instance of PickupDate class 
     */
    public void setPickupDate(PickupDate pickupDate) {
        this.pickupDate = pickupDate;
    }
    
    
    
}
