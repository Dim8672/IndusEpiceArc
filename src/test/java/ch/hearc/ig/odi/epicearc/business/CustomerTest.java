/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.epicearc.business;

import static org.junit.Assert.assertEquals;
import org.junit.Test;


/**
 *
 * @author sebastie.pomi
 */
public class CustomerTest {
    
    /**
     * Test of getLastName method, of class Customer.
     */
    @Test
    public void newCustomer() {
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setFirstName("Sebastien");
        customer.setLastName("Pomi");
        customer.setAddress("Rue Dufour 154");
        customer.setCity("Bienne");
        customer.setZip("2502");
        customer.setEmail("sebpomi@gmail.com");
        customer.setPhone("0789220232");
        
        assertEquals("Meme id", customer.getId(), new Long(1));
        assertEquals("Meme prenom", customer.getFirstName(), "Sebastien");
        assertEquals("Meme Nom", customer.getLastName(), "Pomi");
        assertEquals("Meme Adresse", customer.getAddress(), "Rue Dufour 154");
        assertEquals("Meme Ville", customer.getCity(), "Bienne");
        assertEquals("Meme NPA", customer.getZip(), "2502");
        assertEquals("Meme email", customer.getEmail(), "sebpomi@gmail.com");
        assertEquals("Meme telephone", customer.getPhone(), "0789220232");
        
        
        
    }    
}
