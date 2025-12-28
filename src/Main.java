import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int NUMBER_OF_MONTHS = 12;
        final int PERCENT = 100;
        int periodOfYears, periodOfYearsInMonths;
        double annualInterestRate, monthlyInterestRate;
        double principal;

        Scanner sc = new Scanner(System.in);
        System.out.println("*****************************");
        System.out.println("    MORTGAGE CALCULATOR");
        System.out.println("*****************************");

        while (true) {
            System.out.print("Enter principal amount: ");
            principal = sc.nextDouble();
            if (principal >= 1000 && principal <= 1_000_000) {
                break;
            }
            System.out.println("Enter a value between 1000 and 1_000_000");
        }

        while(true) {
            System.out.print("Enter annual interest rate: ");
            annualInterestRate = sc.nextDouble();
            if (annualInterestRate >=0  && annualInterestRate <= 30) {
                break;
            }
            System.out.println("Enter a value between 0 and 30");
        }
        monthlyInterestRate = (double)annualInterestRate/ (NUMBER_OF_MONTHS * PERCENT);

        while (true) {
            System.out.print("Enter period in years: ");
            periodOfYears = sc.nextInt();
            if  (periodOfYears >= 1 && periodOfYears <= 30) {
                break;
            }
            System.out.println("Enter a value between 1 and 30");
        }
        periodOfYearsInMonths = periodOfYears * 12;

        var mortgage = new Mortgage(principal, periodOfYearsInMonths, monthlyInterestRate);
        System.out.println("Your monthly mortgage will be: " + NumberFormat.getCurrencyInstance(Locale.US).format(mortgage.calculateMortgage()));
    }
}
