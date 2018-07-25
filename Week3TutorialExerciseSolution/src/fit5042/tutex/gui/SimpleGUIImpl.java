/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex.gui;

import fit5042.tutex.repository.entities.Property;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class SimpleGUIImpl extends JFrame implements RealEstateAgencyGUI {

    private final JButton closeButton;
    private final JButton addButton;
    private final JButton viewButton;
    private final JButton searchButton;
    private final JPanel inputPanel;
    private final JPanel buttonPanel;

    private final JLabel propertyIdLabel;
    private final JLabel addressLabel;
    private final JLabel numberOfBedroomLabel;
    private final JLabel sizeLabel;
    private final JLabel priceLabel;

    private final JTextField propertyIdTextField;
    private final JTextField addressTextField;
    private final JTextField numberOfBedroomTextField;
    private final JTextField sizeTextField;
    private final JTextField priceTextField;

    private final JTextArea informationTextArea;

    public SimpleGUIImpl(ActionListener actionListener) {
        //call the Parameterized constructor of JFrame
        super("Monash Real Estate Agency");

        // create buttons
        this.closeButton = new JButton("Close");
        this.viewButton = new JButton("View");
        this.searchButton = new JButton("Search");
        this.addButton = new JButton("Add");

        // create container
        Container container = this.getContentPane();

        // create labels
        this.propertyIdLabel = new JLabel("Property ID:");
        this.addressLabel = new JLabel("Address:");
        this.numberOfBedroomLabel = new JLabel("No. Of Bedroom:");
        this.sizeLabel = new JLabel("Size:");
        this.priceLabel = new JLabel("Price:");

        // create text fields
        this.propertyIdTextField = new JTextField();
        this.addressTextField = new JTextField();
        this.numberOfBedroomTextField = new JTextField();
        this.sizeTextField = new JTextField();
        this.priceTextField = new JTextField();

        // create text area
        this.informationTextArea = new JTextArea();
        this.informationTextArea.setEditable(false);

        // create panels
        this.inputPanel = new JPanel();
        this.buttonPanel = new JPanel();

        // set layout manager
        container.setLayout(new BorderLayout());
        this.inputPanel.setLayout(new GridLayout(5, 2));
        this.buttonPanel.setLayout(new GridLayout(1, 4));

        // add action listeners
        this.closeButton.addActionListener(actionListener);
        this.addButton.addActionListener(actionListener);
        this.viewButton.addActionListener(actionListener);
        this.searchButton.addActionListener(actionListener);

        // add components
        this.inputPanel.add(propertyIdLabel);
        this.inputPanel.add(propertyIdTextField);
        this.inputPanel.add(addressLabel);
        this.inputPanel.add(addressTextField);
        this.inputPanel.add(numberOfBedroomLabel);
        this.inputPanel.add(numberOfBedroomTextField);
        this.inputPanel.add(sizeLabel);
        this.inputPanel.add(sizeTextField);
        this.inputPanel.add(priceLabel);
        this.inputPanel.add(priceTextField);

        // add buttons to panel
        this.buttonPanel.add(addButton);
        this.buttonPanel.add(searchButton);
        this.buttonPanel.add(viewButton);
        this.buttonPanel.add(closeButton);

        // add panels to content pane
        container.add(inputPanel, BorderLayout.NORTH);
        container.add(new JScrollPane(this.informationTextArea), BorderLayout.CENTER);
        container.add(buttonPanel, BorderLayout.SOUTH);

        // change the default behaviour of the close button
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setSize(650, 570);
        this.setVisible(true);
    }

    @Override
    public int getPropertyId() {
        String id = this.propertyIdTextField.getText();
        return id == null || id.isEmpty() ? 0 : Integer.parseInt(id);
    }

    @Override
    public Property getPropertyDetails() {
        return new Property(Integer.parseInt(propertyIdTextField.getText()), addressTextField.getText(), Integer.parseInt(numberOfBedroomTextField.getText()), Double.parseDouble(sizeTextField.getText()), Double.parseDouble(priceTextField.getText()));
    }

    @Override
    public void displayPopUpMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    @Override
    public void displayPropertyDetails(Property property) {
        this.informationTextArea.setText(property.toString());
    }

    @Override
    public void displayPropertyDetails(List<Property> properties) {

        StringBuilder output = new StringBuilder();

        for (Property property : properties) {
            output.append(property.toString()).append("\n");
        }

        this.informationTextArea.setText(output.toString());
    }

    @Override
    public void clearTextFields() {
        propertyIdTextField.setText("");
        addressTextField.setText("");
        numberOfBedroomTextField.setText("");
        sizeTextField.setText("");
        priceTextField.setText("");
    }

    @Override
    public JButton getViewButton() {
        return viewButton;
    }

    @Override
    public JButton getAddButton() {
        return addButton;
    }

    @Override
    public JButton getSearchButton() {
        return searchButton;
    }

    @Override
    public JButton getCloseButton() {
        return closeButton;
    }
}
