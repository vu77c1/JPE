public class TaxCollector {
    public static void main(String[] args) {

        double grossIncome = Double.parseDouble(args[0]);
        BasicRateTax taxCalculator = new BasicRateTax();
        double tax = taxCalculator.calcTax(grossIncome);

        System.out.println("Tax due is " + tax);
    }
}

