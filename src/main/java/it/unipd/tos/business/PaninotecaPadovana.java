////////////////////////////////////////////////////////////////////
// [GIUSEPPE] [ZATTA] [1143326]
////////////////////////////////////////////////////////////////////
package it.unipd.tos.business;
import java.util.ArrayList;
import java.util.List;
import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.ItemType;
import it.unipd.tos.model.exception.RestaurantBillException;
public class PaninotecaPadovana implements TakeAwayBill {
    private List<MenuItem> items;
    
    public PaninotecaPadovana() {
        items = new ArrayList<MenuItem>();
    }
    
    @Override
    public double getOrderPrice(List<MenuItem> itemsOrdered) throws RestaurantBillException, TakeAwayBillException {        // TODO Auto-generated method stub
        double actual = 0;
        setSconto50(itemsOrdered);
        for(int i=0; i<itemsOrdered.size(); i++) {
            MenuItem get = itemsOrdered.get(i);
            actual = (double) Math.round((actual + get.getPrezzo())*100)/100;
            }
        return actual;
    }
 
    public void insertItem(MenuItem m) {
        items.add(m);
    }
    public double getOurOrderPrice() {
        return getOrderPrice(items);
    }
    private void setSconto50(List<MenuItem> items) {
        int ris=0, pos=0;
        double prezzo= Double.MAX_VALUE;
        for (int i=0; i<items.size(); i++) {
            MenuItem getted = items.get(i);
            if(getted.getTipo() == ItemType.Panino) {
                ris++;
                if (getted.getPrezzo() < prezzo) {
                    prezzo = getted.getPrezzo();
                    pos = i;
                }
            }
        }
        if (ris > 5) {
            items.get(ris).sconta(50);
        }
    }
}
