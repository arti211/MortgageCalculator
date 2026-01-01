import java.text.NumberFormat;
import java.util.Locale;

public class Mortgage {
    final static int NUMBER_OF_MONTHS = 12;
    final static int PERCENT = 100;
    final static int MIN_PRINCIPAL = 1000;
    final static int MAX_PRINCIPAL = 1_000_000;
    final static int MIN_ANNUAL_INTEREST_RATE = 0;
    final static int MAX_ANNUAL_INTEREST_RATE = 30;
    final static int MIN_YEARS = 1;
    final static int MAX_YEARS = 30;

    private final double principal;
    private final double monthlyInterestRate;
    private final int periodInMonths;

    public Mortgage(double principal, int years, double annualInterestRate) {
        this.principal = principal;
        this.periodInMonths = calculatePeriodOfYearsInMonths(years) ;
        this.monthlyInterestRate = calculateMonthlyInterestRate(annualInterestRate);
    }

    private int calculatePeriodOfYearsInMonths(int years) {
        return years * NUMBER_OF_MONTHS;
    }
    private double calculateMonthlyInterestRate(double annualInterestRate) {
        return annualInterestRate / (NUMBER_OF_MONTHS * PERCENT);
    }

    public void printMortgage() {
        System.out.println("\nMORTGAGE");
        System.out.println("--------");
        double mortgage = calculateMortgage();
        System.out.println("Your monthly mortgage will be: " + NumberFormat.getCurrencyInstance(Locale.US).format(mortgage));
    }

    private double calculateMortgage() {
        return principal * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, periodInMonths)/
                ( Math.pow(1 + monthlyInterestRate, periodInMonths) - 1);
    }

    public void printMortgageBalance() {
        int numberOfMonthsPaid = 0;
        System.out.println("\nPAYMENT SCHEDULE");
        System.out.println("----------------");

        for (int i = 0; i <= periodInMonths; i++) {
            System.out.println(NumberFormat.getCurrencyInstance(Locale.US).format
                    (calculatePaymentSchedule(numberOfMonthsPaid)));
            numberOfMonthsPaid++;
        }
    }

    private double calculatePaymentSchedule(int numberOfMonthsPaid) {

        return principal * (Math.pow(1 + monthlyInterestRate, periodInMonths) -
                Math.pow(1 + monthlyInterestRate, numberOfMonthsPaid)) /
                (Math.pow(1 + monthlyInterestRate, periodInMonths) - 1);
    }
}
