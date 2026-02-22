import java.util.*;

public class CafeteriaSystem {

    private final Map<String, MenuItem> menu = new LinkedHashMap<>();

    private final PricingEngine pricing;
    private final TaxCalculator taxCalculator;
    private final DiscountCalculator discountCalculator;
    private final InvoicePrinter printer;
    private final FileStore store;

    private int invoiceSeq = 1000;

    public CafeteriaSystem(
        PricingEngine pricing,
        TaxCalculator taxCalculator,
        DiscountCalculator discountCalculator,
        InvoicePrinter printer,
        FileStore store
    ){
        this.pricing = pricing;
        this.taxCalculator = taxCalculator;
        this.discountCalculator = discountCalculator;
        this.printer = printer;
        this.store = store;
    }

    public void addToMenu(MenuItem i){
        menu.put(i.id, i);
    }

    public void checkout(String customerType, List<OrderLine> lines){

        String invId = "INV-" + (++invoiceSeq);

        double subtotal = pricing.subtotal(menu, lines);

        double taxPct = taxCalculator.taxPercent(customerType);
        double tax = subtotal * (taxPct / 100.0);

        double discount =
            discountCalculator.discount(customerType, subtotal, lines.size());

        double total = subtotal + tax - discount;

        String printable =
            printer.buildInvoice(
                invId,
                menu,
                lines,
                subtotal,
                taxPct,
                tax,
                discount,
                total
            );

        System.out.print(printable);

        store.save(invId, printable);

        System.out.println(
            "Saved invoice: " + invId +
            " (lines=" + store.countLines(invId) + ")"
        );
    }
}