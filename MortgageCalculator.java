public class MortgageCalculator {
    private int principal;
    private float annualInterest;
    private byte years;
    private final byte PERCENT = 100;
    private final byte MONTHS_IN_YEAR = 12;

    public MortgageCalculator(int principal, float annualInterest, byte years) {
        this.principal = principal;
        this.annualInterest = annualInterest;
        this.years = years;
    }

    public double calculateMortgage() {
        float monthlyInterest = getMonthlyInterest();
        int numberOfPayments = getNumberOfPayments();

        double mortgage = principal * ((monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments)))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        return mortgage;
    }

    public double calculateLoanBalance(int i) {
        float monthlyInterest = getMonthlyInterest();
        int numberOfPayments = getNumberOfPayments();

        double balance = principal
                * (Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, i))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        return balance;
    }

    private int getNumberOfPayments() {
        return years * MONTHS_IN_YEAR;
    }

    private float getMonthlyInterest() {
        return annualInterest / PERCENT / MONTHS_IN_YEAR;
    }

    public double[] getRemainingBalance() {
        var balances = new double[getNumberOfPayments()];
        for (byte month = 1; month <= balances.length; month++)
            balances[month - 1] = calculateLoanBalance(month);
        return balances;
    }
}
