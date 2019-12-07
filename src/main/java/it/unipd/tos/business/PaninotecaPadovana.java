////////////////////////////////////////////////////////////////////
// [GIUSEPPE] [ZATTA] [1143326]
////////////////////////////////////////////////////////////////////
package it.unipd.tos.business;
import java.util.ArrayList;
import java.util.List;
import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.exception.RestaurantBillException;
public class PaninotecaPadovana implements TakeAwayBill {
    private List<MenuItem> items;
    @Override
    public double getOrderPrice(List<MenuItem> itemsOrdered) throws RestaurantBillException, TakeAwayBillException {        // TODO Auto-generated method stub
        double actual = 0;
        for(int i=0; i<itemsOrdered.size(); i++) {
            MenuItem get = itemsOrdered.get(i);
            actual = (double) Math.round((actual + get.getPrezzo())*100)/100;
            }
        return actual;
    }    
    public PaninotecaPadovana() {
        items = new ArrayList<MenuItem>();
    }
    public void insertItem(MenuItem m) {
        items.add(m);
    }
    public double getOurOrderPrice() {
        return getOrderPrice(items);
    }
}
