import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("*****************************");
        System.out.println("    MORTGAGE CALCULATOR");
        System.out.println("*****************************");

        double principal = (int )readNumber(sc, "Principal: ",  1000,1_000_000 );
        double annualInterestRate = (float) readNumber(sc, "Annual Interest Rate: ",  0,30 );
        int periodOfYears = (int) readNumber(sc, "Period (Years): ",  1,30 );

        //Without using a Class
        //var mortgage = new Mortgage(principal, periodOfYearsInMonths, monthlyInterestRate);
        double mortgage = calculateMortgage(principal, annualInterestRate, periodOfYears);
        System.out.println("Your monthly mortgage will be: " + NumberFormat.getCurrencyInstance(Locale.US).format(mortgage));
    }

    public static double readNumber(Scanner sc, String prompt, double min, double max) {
        double value;
        while (true) {
            System.out.print(prompt);
            value = sc.nextFloat();
            if  (value >= min && value <= max)
                break;
            System.out.println("Enter a value between " +  min + " and " + max );
        }
        return value;
    }

    public static double calculateMortgage(double principal, double annualInterestRate, int periodOfYears) {
        final int NUMBER_OF_MONTHS = 12;
        final int PERCENT = 100;

        double monthlyInterestRate = annualInterestRate/ (NUMBER_OF_MONTHS * PERCENT);
        int periodOfYearsInMonths = periodOfYears * 12;

        return principal* (monthlyInterestRate * Math.pow(1+monthlyInterestRate,periodOfYearsInMonths))
                /(Math.pow(1+monthlyInterestRate,periodOfYearsInMonths) -1);

    }
}
