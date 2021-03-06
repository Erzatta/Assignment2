////////////////////////////////////////////////////////////////////
// [GIUSEPPE] [ZATTA] [1143326]
////////////////////////////////////////////////////////////////////
package it.unipd.tos.model;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.exception.RestaurantBillException;

public class MenuItemTest  {
    MenuItem testBase;
    
    @Before 
    public void prepareTest() {
        testBase = new MenuItem(ItemType.Bevanda, "Ciao", 0.1D); 
    }
    
    @Test    
    public void getNomeTest() {        
        String test = "Ciao";
        assertEquals(test, testBase.getNome());
    }
    
    @Test    
    public void getPrezzoTest() {        
        Double test = 0.1D;
        Double ris = testBase.getPrezzo();
        assertEquals(test, ris);
    }
    
    @Test    
    public void getTipoTest() {        
        ItemType test = ItemType.Bevanda;
        assertEquals(test, testBase.getTipo());
    }
    
    @Test(expected = RestaurantBillException.class)    
    public void constructExeptionZeroPriceTest() {        
        double test = 0.0;
        MenuItem a = new MenuItem(ItemType.Bevanda, "Ciao", test);
        
    }
    
    @Test(expected = RestaurantBillException.class)    
    public void constructExeptionSubzeroPriceTest() {        
        double test = -0.5;
        MenuItem a = new MenuItem(ItemType.Bevanda, "Ciao", test);
        
    }
    
    @Test(expected = RestaurantBillException.class)    
    public void constructExeptionNullStringTest() {        
        String test = null;
        MenuItem a = new MenuItem(ItemType.Bevanda, test, 0.1D);
        
    }
    
    @Test(expected = RestaurantBillException.class)    
    public void constructExeptionVoidStringTest() {        
        String test = "";
        MenuItem a = new MenuItem(ItemType.Bevanda, test, 0.1D);
    }
    
}

