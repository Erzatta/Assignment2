package it.unipd.tos.business;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import it.unipd.tos.model.ItemType;
////////////////////////////////////////////////////////////////////
//[GIUSEPPE] [ZATTA] [1143326]
////////////////////////////////////////////////////////////////////
import it.unipd.tos.model.MenuItem;

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
    public void setSconto50whithScontoTest() {
        for(int i=0; i<5; i++) {
            pd.insertItem(new MenuItem(ItemType.Panino, "Ciao", 0.6D));
        }
        Double conf = 0.3D+0.1D+0.3D+3.0D;
        Double ris = pd.getOurOrderPrice();
        assertEquals(conf, ris);
    }
    
    @Test
    public void getOrderPriceTest() {
        Double conf = 1.0D;
        Double ris = pd.getOurOrderPrice();
        assertEquals(conf, ris);
    }
}
