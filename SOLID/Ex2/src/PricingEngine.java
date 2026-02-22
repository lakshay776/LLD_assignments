import java.util.*;
public class PricingEngine {

    double subtotal(Map<String,MenuItem> menu,List<OrderLine> lines){
    double subtotal = 0.0;
        for (OrderLine l : lines) {
            MenuItem item = menu.get(l.itemId);
            double lineTotal = item.price * l.qty;
            subtotal += lineTotal;
        }
        return subtotal;
}
}
