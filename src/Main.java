import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int NUMBER_OF_MONTHS = 12;
        final int PERCENT = 100;

        Scanner sc = new Scanner(System.in);
        System.out.println("*****************************");
        System.out.println("    MORTGAGE CALCULATOR");
        System.out.println("*****************************");

        System.out.print("Enter principal amount: ");
        double principal = sc.nextDouble();

        System.out.print ("Enter annual interest rate: ");
        double annualInterestRate = sc.nextDouble();
        double monthlyInterestRate = (double)annualInterestRate/ (NUMBER_OF_MONTHS * PERCENT);

        System.out.print("Enter period in years: ");
        int periodOfYears = sc.nextInt();
        int periodOfYearsInMonths = periodOfYears*12;

        var mortgage = new Mortgage(principal, periodOfYearsInMonths, monthlyInterestRate);
        System.out.println("Your monthly mortgage will be: " + NumberFormat.getCurrencyInstance(Locale.US).format(mortgage.calculateMortgage()));
    }
}
