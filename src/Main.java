import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Console console = new Console();
        double principal = (int)Console.readNumber("Principal: ",Mortgage.MIN_PRINCIPAL, Mortgage.MAX_PRINCIPAL);
        double annualInterestRate = (float)Console.readNumber("Annual Interest Rate: ",Mortgage.MIN_ANNUAL_INTEREST_RATE, Mortgage.MAX_ANNUAL_INTEREST_RATE );
        int periodOfYears = (int)Console.readNumber("Period (Years): ", Mortgage.MIN_YEARS, Mortgage.MAX_YEARS);

        var mortgage = new Mortgage(principal, periodOfYears, annualInterestRate );
        mortgage.printMortgage();
        mortgage.printMortgageBalance();
    }

}
