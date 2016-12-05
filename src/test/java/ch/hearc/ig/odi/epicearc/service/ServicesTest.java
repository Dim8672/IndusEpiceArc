/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.epicearc.service;

import ch.hearc.ig.odi.epicearc.business.AbstractDate;
import ch.hearc.ig.odi.epicearc.business.ConiferType;
import ch.hearc.ig.odi.epicearc.business.DeliveryDate;
import ch.hearc.ig.odi.epicearc.business.Order;
import ch.hearc.ig.odi.epicearc.business.PickupDate;
import ch.hearc.ig.odi.epicearc.business.Product;
import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dimitri
 */
public class ServicesTest {
    
    public ServicesTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getConiferTypes method, of class Services.
     */
    @org.junit.Test
    public void testGetConiferTypes() throws Exception {
        System.out.println("getConiferTypes");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        Services instance = (Services)container.getContext().lookup("java:global/classes/Services");
        List<ConiferType> expResult = null;
        List<ConiferType> result = instance.getConiferTypes();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProductsForConiferType method, of class Services.
     */
    @org.junit.Test
    public void testGetProductsForConiferType() throws Exception {
        System.out.println("getProductsForConiferType");
        ConiferType coniferType = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        Services instance = (Services)container.getContext().lookup("java:global/classes/Services");
        List<Product> expResult = null;
        List<Product> result = instance.getProductsForConiferType(coniferType);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDeliveryDatesForProduct method, of class Services.
     */
    @org.junit.Test
    public void testGetDeliveryDatesForProduct() throws Exception {
        System.out.println("getDeliveryDatesForProduct");
        Product product = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        Services instance = (Services)container.getContext().lookup("java:global/classes/Services");
        List<DeliveryDate> expResult = null;
        List<DeliveryDate> result = instance.getDeliveryDatesForProduct(product);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPickupDatesForProduct method, of class Services.
     */
    @org.junit.Test
    public void testGetPickupDatesForProduct() throws Exception {
        System.out.println("getPickupDatesForProduct");
        Product product = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        Services instance = (Services)container.getContext().lookup("java:global/classes/Services");
        List<PickupDate> expResult = null;
        List<PickupDate> result = instance.getPickupDatesForProduct(product);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveOrder method, of class Services.
     */
    @org.junit.Test
    public void testSaveOrder() throws Exception {
        System.out.println("saveOrder");
        Order order = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        Services instance = (Services)container.getContext().lookup("java:global/classes/Services");
        instance.saveOrder(order);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTransportCosts method, of class Services.
     */
    @org.junit.Test
    public void testGetTransportCosts() throws Exception {
        System.out.println("getTransportCosts");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        Services instance = (Services)container.getContext().lookup("java:global/classes/Services");
        Float expResult = null;
        Float result = instance.getTransportCosts();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAbstractDateWithId method, of class Services.
     */
    @org.junit.Test
    public void testGetAbstractDateWithId() throws Exception {
        System.out.println("getAbstractDateWithId");
        Long id = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        Services instance = (Services)container.getContext().lookup("java:global/classes/Services");
        AbstractDate expResult = null;
        AbstractDate result = instance.getAbstractDateWithId(id);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
