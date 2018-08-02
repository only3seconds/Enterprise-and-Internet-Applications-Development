/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fit5042.tutex.gui;

import javax.swing.JButton;

/**
 *
 * @author Eddie
 */
public interface MonthlyPaymentCalculatorandRealEstateAgencyGUIInterface extends RealEstateAgencyGUI {
    
    /**
     * Return the calculate button
     *
     * @return the attribute calculateButton
     */
    public JButton getCalculateButton() ;
    
    /**
     * Return the principle the user has entered
     *
     * @return the principle the user has entered
     */
    public double getPrinciple() ;
    
    /**
     * Return the interest rate the user has entered
     *
     * @return the interest rate the user has entered
     */
    public double getInterestRate();
    /**
     * Return the number of years the user has entered
     *
     * @return the number of years the user has entered
     */
    public int getNoOfYears() ;
    /**
     * Display the result
     *
     * @param result the result to display
     */
    public void updateResult(double result);
   
}
