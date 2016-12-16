/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.epicearc.business;

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
public class CustomerTest {
    
    public CustomerTest() {
    }
    
    
    @Test
    public void newCustomer() {
        Customer cust = new Customer();
        cust.setId(1L);
        cust.setFirstName("Seb");
        cust.setLastName("Pomi");
        cust.setAddress("Rue Dufour 15");
        cust.setCity("Bienne");
        cust.setZip("2502");
        cust.setEmail("sebpomi@gmail.com");
        assertEquals("Meme id",new Long(1) , cust.getId());
        assertEquals("Meme prenom","Seb" , cust.getFirstName());
        assertEquals("Meme nom","Pomi", cust.getLastName());
        
    }
    
}
