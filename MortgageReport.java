import java.text.NumberFormat;

public class MortgageReport {

    private MortgageCalculator calculator;
    private NumberFormat currency;

    public MortgageReport(MortgageCalculator calculator) {
        this.calculator = calculator;
        currency = NumberFormat.getCurrencyInstance();
    }

    public void printMortgage() {

        double mortgage = calculator.calculateMortgage();

        String mortgageFormatted = currency.format(mortgage);
        System.out.println("\nMORTGAGE\n" + "________\n" + "Monthly Payments: " + mortgageFormatted);
    }

    public void printPaymentSchedule() {
        System.out.println("\nPAYMENT SCHEDULE\n");
        for (double balance : calculator.getRemainingBalance()) {
            String loanBalanceFormatted = currency.format(balance);
            System.out.println(loanBalanceFormatted);
        }

    }
}