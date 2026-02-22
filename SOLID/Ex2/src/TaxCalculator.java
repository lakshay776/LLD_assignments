class TaxCalculator {
    double taxPercent(String customerType){
        return TaxRules.taxPercent(customerType);
    }
}