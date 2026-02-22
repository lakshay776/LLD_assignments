public class DiscountCalculator {

    public double discount(String customerType,double subtotal,int lineCount){
        return DiscountRules.discountAmount(customerType,subtotal,lineCount);
    }
}