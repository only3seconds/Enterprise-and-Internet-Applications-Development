package fit5042.tutex.calculator;

import javax.ejb.Stateless;

/**
 * A simple monthly payment calculator implementation
 * 
 * @author Eddie Leung
 */
@Stateless
public class MonthlyPaymentCalculatorBean implements MonthlyPaymentCalculator {

    @Override
    public double calculate(double principle, int year, double interestRate) {
        double monthlyPayment = 0.0;
        int numberOfPayments = year * 12;
        monthlyPayment = principle * (interestRate * (Math.pow((1 + interestRate), numberOfPayments))) / ((Math.pow((1 + interestRate), numberOfPayments)) - 1);
        
        return monthlyPayment;
    }
}
