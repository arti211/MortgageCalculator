import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    final static int NUMBER_OF_MONTHS = 12;
    final static int PERCENT = 100;

    public static void main(String[] args) {
        double principal = (int )readNumber("Principal: ",  1000,1_000_000 );
        double annualInterestRate = (float) readNumber("Annual Interest Rate: ",  0,30 );
        int periodOfYears = (int) readNumber("Period (Years): ",  1,30 );

        //Without using a Class
        //var mortgage = new Mortgage(principal, periodOfYearsInMonths, monthlyInterestRate);
        printMortgage(principal, annualInterestRate, periodOfYears);
        printMortgageBalance(principal, annualInterestRate, periodOfYears);
    }

    private static void printMortgage(double principal, double annualInterestRate, int periodOfYears) {
        System.out.println("\nMORTGAGE");
        System.out.println("--------");
        double mortgage = calculateMortgage(principal, annualInterestRate, periodOfYears);
        System.out.println("Your monthly mortgage will be: " + NumberFormat.getCurrencyInstance(Locale.US).format(mortgage));
    }

    public static double readNumber(String prompt, double min, double max) {
        double value;
        Scanner sc = new Scanner(System.in);
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
        double monthlyInterestRate = annualInterestRate/ (NUMBER_OF_MONTHS * PERCENT);
        int periodOfYearsInMonths = periodOfYears * 12;

        return principal* (monthlyInterestRate * Math.pow(1+monthlyInterestRate,periodOfYearsInMonths))
                /(Math.pow(1+monthlyInterestRate,periodOfYearsInMonths) -1);

    }

    public static double calculatePaymentSchedule(double principal, double annualInterestRate, int periodOfYears, int monthsPaid){
        double monthlyInterestRate = annualInterestRate/ (NUMBER_OF_MONTHS * PERCENT);
        int periodOfYearsInMonths = periodOfYears * 12;

        return principal *(Math.pow(1+monthlyInterestRate,periodOfYearsInMonths)-
                Math.pow(1+monthlyInterestRate, monthsPaid))/
                (Math.pow(1+monthlyInterestRate,periodOfYearsInMonths)-1);
    }

    private static void printMortgageBalance(double principal, double annualInterestRate, int periodOfYears) {
        int numberOfMonthsPaid = 0;
        System.out.println("\nPAYMENT SCHEDULE");
        System.out.println("----------------");

        for (int i = 0; i <= periodOfYears * NUMBER_OF_MONTHS ; i++) {
            System.out.println(NumberFormat.getCurrencyInstance(Locale.US).format
                    (calculatePaymentSchedule(principal, annualInterestRate, periodOfYears, numberOfMonthsPaid)));
            numberOfMonthsPaid++;
        }
    }
}
