/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.epicearc.service;

import ch.hearc.ig.odi.epicearc.business.AbstractDate;
import ch.hearc.ig.odi.epicearc.business.ConiferType;
import ch.hearc.ig.odi.epicearc.business.Customer;
import ch.hearc.ig.odi.epicearc.business.DeliveryDate;
import ch.hearc.ig.odi.epicearc.business.Order;
import ch.hearc.ig.odi.epicearc.business.PickupDate;
import ch.hearc.ig.odi.epicearc.business.Product;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.ejb.embeddable.EJBContainer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sebastie.pomi
 */
public class ServicesTest {
    
    /**
     * Test of saveOrder method, of class Services.
     */
    @Test
    public void testSaveOrder() throws Exception {
        Services service = new Services();
        int size = service.orders.size();
        Order order = new Order(1000L, new Date(),12.00f , new DeliveryDate(), new PickupDate(), new Product(), new Customer());
        service.saveOrder(order);
        assertEquals(size+1, service.orders.size());
    }

    
}
