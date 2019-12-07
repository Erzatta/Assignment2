////////////////////////////////////////////////////////////////////
// [GIUSEPPE] [ZATTA] [1143326]
////////////////////////////////////////////////////////////////////
package it.unipd.tos.business;
import java.util.List;
import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.exception.RestaurantBillException;

public interface TakeAwayBill {
    abstract double getOrderPrice(List<MenuItem> itemsOrdered) throws RestaurantBillException, TakeAwayBillException;
}
