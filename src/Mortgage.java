public class Mortgage {

    private final double principal;
    private final double monthlyInterestRate;
    private final int years;

    public Mortgage(double principal, int years, double monthlyInterestRate) {
        this.principal = principal;
        this.years = years;
        this.monthlyInterestRate = monthlyInterestRate;
    }

    public double calculateMortgage(){
        double mortgage = 0;

        double mortgageNumerator = principal* monthlyInterestRate * Math.pow(1+monthlyInterestRate,years) ;
        double mortgageDenominator = Math.pow(1+monthlyInterestRate,years) -1;
        mortgage =  (double)mortgageNumerator/mortgageDenominator;

        return mortgage;
    }





}
