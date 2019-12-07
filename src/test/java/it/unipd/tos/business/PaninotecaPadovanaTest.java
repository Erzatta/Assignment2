////////////////////////////////////////////////////////////////////
//[GIUSEPPE] [ZATTA] [1143326]
////////////////////////////////////////////////////////////////////
package it.unipd.tos.business;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import it.unipd.tos.model.ItemType;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.business.exception.TakeAwayBillException;

public class PaninotecaPadovanaTest {
    PaninotecaPadovana pd;
    
    @Before
    public void initialize() {
        pd = new PaninotecaPadovana();
        pd.insertItem(new MenuItem(ItemType.Bevanda, "Ciao", 0.1D));
        pd.insertItem(new MenuItem(ItemType.Panino, "Ciao", 0.6D));
        pd.insertItem(new MenuItem(ItemType.Fritto, "Ciao", 0.3D));
    }

    @Test
    public void getOrderPriceTest() {
        Double conf = 1.5D;
        Double ris = pd.getOurOrderPrice();
        assertEquals(conf, ris);
    }
    
    @Test
    public void getOrderPriceTestwithSconto50() {
        for(int i=0; i<5; i++) {
            pd.insertItem(new MenuItem(ItemType.Panino, "Ciao", 0.6D));
        }
        Double conf = 0.3D+0.1D+0.3D+3.0D+0.5D;
        Double ris = pd.getOurOrderPrice();
        assertEquals(conf, ris);
    }
    
    @Test
    public void getOrderPriceTestwithSconto10() {
        for(int i=0; i<5; i++) {
            pd.insertItem(new MenuItem(ItemType.Bevanda, "Ciao", 10.0D));
        }
        Double conf = (51.0D) - (5.1D) ;
        conf = (double) Math.round(conf*100) /100 ;
        Double ris = pd.getOurOrderPrice();
        assertEquals(conf, ris);
    }
    
    @Test(expected = TakeAwayBillException.class) 
    public void getOrderPriceover30elementsTest() {
        for(int i=0; i<28; i++) {
            pd.insertItem(new MenuItem(ItemType.Bevanda, "Ciao", 10.0D));
        }
    }
}
