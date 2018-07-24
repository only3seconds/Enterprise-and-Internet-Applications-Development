/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fit5042.tutex.gui;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Eddie
 */
public class MonthlyPaymentCalculatorGUI extends JFrame {
    private final JTextField principleTextField, interestRateTextField, noOfYearsTextField;
    private final JLabel resultLabel;
    private final JButton calculateButton;
    
    public MonthlyPaymentCalculatorGUI(String title, ActionListener actionListener)
    {
        super(title);

        principleTextField = new JTextField();
        interestRateTextField = new JTextField();
        noOfYearsTextField = new JTextField();
        
        resultLabel = new JLabel();
        
        calculateButton = new JButton("Calculate");
        this.calculateButton.addActionListener(actionListener);           
        
        principleTextField.setHorizontalAlignment(JTextField.CENTER);
        interestRateTextField.setHorizontalAlignment(JTextField.CENTER);
        noOfYearsTextField.setHorizontalAlignment(JTextField.CENTER);
        resultLabel.setHorizontalAlignment(JLabel.CENTER);
        
        JPanel panel = new JPanel(new GridLayout(5, 2));
        panel.add(new JLabel("Principle:"));
        panel.add(principleTextField);
        panel.add(new JLabel("Interest Rate:"));
        panel.add(interestRateTextField);
        panel.add(new JLabel("No. of Years:"));
        panel.add(noOfYearsTextField);      
        panel.add(new JLabel("Result:"));
        panel.add(resultLabel);
        panel.add(new JLabel(""));
        panel.add(calculateButton);
        
        getContentPane().add(panel);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setSize(300, 200);
        setVisible(true);
    }
    
    /**
     * Display a message in a dialog box
     *
     * @param message to display
     */
    public void showMessage(String message)
    {
        JOptionPane.showMessageDialog(this, message);
    }

    /**
     * Return the calculate button
     *
     * @return the attribute calculateButton
     */
    public JButton getCalculateButton() {
        return calculateButton;
    }
    
    /**
     * Return the principle the user has entered
     *
     * @return the principle the user has entered
     */
    public double getPrinciple() {
        return Double.parseDouble(this.principleTextField.getText());
    }
    
    /**
     * Return the interest rate the user has entered
     *
     * @return the interest rate the user has entered
     */
    public double getInterestRate() {
        return Double.parseDouble(this.interestRateTextField.getText());
    }
    
    /**
     * Return the number of years the user has entered
     *
     * @return the number of years the user has entered
     */
    public int getNoOfYears() {
        return Integer.parseInt(this.noOfYearsTextField.getText());
    }
    
    /**
     * Display the result
     *
     * @param the result to display
     */
    public void updateResult(double result) {
        this.resultLabel.setText(NumberFormat.getCurrencyInstance().format(result));
    }
}
