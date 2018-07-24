package fit5042.tutex;

import fit5042.tutex.gui.MonthlyPaymentCalculatorGUI;
import fit5042.tutex.calculator.MonthlyPaymentCalculator;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.ejb.EJB;

/**
 * A desktop application that allows users to calculate the amount of monthly payment of a loan
 * 
 * @author Eddie Leung
 */
public class MonthlyPaymentCalculatorApp implements ActionListener {
 
    @EJB
    private static MonthlyPaymentCalculator calculator;
    
    private MonthlyPaymentCalculatorGUI gui;
    
    public MonthlyPaymentCalculatorApp()
    {       
        gui = new MonthlyPaymentCalculatorGUI("EX6 - Calculator Application Client", this);    
    }
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        try
        {
            if (ae.getSource() == gui.getCalculateButton())
            {
                Double principle = gui.getPrinciple();
                Double interestRate = gui.getInterestRate();
                int numberOfYears = gui.getNoOfYears();

                gui.updateResult(calculator.calculate(principle, numberOfYears, interestRate));

            }
        }
        catch (Exception ex)
        {
            gui.showMessage(ex.getMessage());
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new MonthlyPaymentCalculatorApp();
    }
    
}
