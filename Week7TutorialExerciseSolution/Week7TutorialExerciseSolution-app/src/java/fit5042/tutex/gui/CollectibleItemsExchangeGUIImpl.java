/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fit5042.tutex.gui;

import fit5042.tutex.repository.entities.Item;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashSet;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableColumnModel;

public class CollectibleItemsExchangeGUIImpl extends JFrame implements CollectibleItemsExchangeGUI {
    
    private static final String[] TABLE_COLUMNS = {"ID", "Title", "Type", "AvailableUnits", "Price"};
    private static final String LABEL_SEPARATOR = ",";
    
    
    private final JButton closeButton;
    private final JButton viewButton;
    private final JButton searchButton;
    
    private final JPanel inputPanel;
    private final JPanel buttonPanel;

    private final JLabel itemIdLabel;
    private final JLabel titleLabel;
    private final JLabel typeLabel;
    private final JLabel availableUnitsLabel;
    private final JLabel priceLabel;
    
    
  

    private final JTextField itemIdTextField;
    private final JTextField titleTextField;
    private final JTextField typeTextField;
    private final JTextField availableUnitsTextField;
    private final JTextField priceTextField;
    
    
    private final JTable itemTable;

    Item item;

    public CollectibleItemsExchangeGUIImpl(ActionListener actionListener, ListSelectionListener listSelectionListener) {
        super("Collectible Items Exchange");

        // create buttons
        this.closeButton = new JButton("Close");
        this.viewButton = new JButton("View");
        this.searchButton = new JButton("Search");

        // create container
        Container container = this.getContentPane();

        // create labels
        this.itemIdLabel = new JLabel("Item ID:");
        this.titleLabel = new JLabel("Title:");
        this.typeLabel = new JLabel("Type:");
        this.availableUnitsLabel = new JLabel("Available Units:");
        this.priceLabel = new JLabel("Price:");

        // create text fields
        this.itemIdTextField = new JTextField();
        this.titleTextField = new JTextField();
        this.typeTextField = new JTextField();
        this.availableUnitsTextField = new JTextField();
        this.priceTextField = new JTextField();
        
        // create table
        this.itemTable = new JTable(new DefaultTableModel(TABLE_COLUMNS, 0));
        this.itemTable.getSelectionModel().addListSelectionListener(listSelectionListener);       
        this.itemTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
        TableColumnModel itemTableColumnModel = this.itemTable.getColumnModel();
        itemTableColumnModel.getColumn(0).setPreferredWidth(50);
        itemTableColumnModel.getColumn(1).setPreferredWidth(300);
        itemTableColumnModel.getColumn(2).setPreferredWidth(100);
        itemTableColumnModel.getColumn(3).setPreferredWidth(100);
        itemTableColumnModel.getColumn(4).setPreferredWidth(100);
        
        // create panels
        this.inputPanel = new JPanel();
        this.buttonPanel = new JPanel();

        // set layout manager
        container.setLayout(new BorderLayout());
        this.inputPanel.setLayout(new GridLayout(11,2));
        this.buttonPanel.setLayout(new GridLayout(1,4));

        // add action listeners
        this.closeButton.addActionListener(actionListener);
        this.viewButton.addActionListener(actionListener);
        this.searchButton.addActionListener(actionListener);

        // add components
        this.inputPanel.add(itemIdLabel);
        this.inputPanel.add(itemIdTextField);

        
        this.inputPanel.add(titleLabel);
        this.inputPanel.add(titleTextField);
        
        this.inputPanel.add(typeLabel);
        this.inputPanel.add(typeTextField);
        
        this.inputPanel.add(availableUnitsLabel);
        this.inputPanel.add(availableUnitsTextField);
        
        this.inputPanel.add(priceLabel);
        this.inputPanel.add(priceTextField);

        // add buttons to panel
        this.buttonPanel.add(this.searchButton);
        this.buttonPanel.add(this.viewButton);
        this.buttonPanel.add(this.closeButton);
        
        // add panels to content pane
        container.add(inputPanel,BorderLayout.NORTH);
        container.add(new JScrollPane(this.itemTable), BorderLayout.CENTER);
        container.add(buttonPanel,BorderLayout.SOUTH);
       
        // change the default behaviour of the close button
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.setSize(750, 570);       
        this.setVisible(true);
    }

    
    @Override
    public double getBudget() {
        String price = this.priceTextField.getText();
        return price == null || price.isEmpty() ? 0 : Double.parseDouble(price);
    }
   
    
    @Override
    public void displayMessageInDialog(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
    
    private Set<String> getItemLabels() {
        StringTokenizer tokenizer = new StringTokenizer(this.typeTextField.getText(), LABEL_SEPARATOR);
        Set<String> labels = new HashSet<>();
       
        while (tokenizer.hasMoreTokens()) {
            String label = tokenizer.nextToken();
            labels.add(label.trim());
        }
        
        return labels;
    }
    
    private String getLabelsString(Set<String> labels) {
        if (labels != null && !labels.isEmpty()) {
           StringBuilder labelsBuilder = new StringBuilder();
           int index = 0;
           for (String tag : labels) {
               if (index != 0) {
                   labelsBuilder.append(LABEL_SEPARATOR).append(" ");
               }
               
               labelsBuilder.append(tag.trim());
               index ++;
           }
           
           return labelsBuilder.toString();
        }
        
        return "";
    }
    
    @Override
    public void clearInput() {
        this.clearTextFields();
    }

    @Override
    public void clearTextFields() {
        this.itemIdTextField.setText("");
        this.titleTextField.setText("");
        this.typeTextField.setText("");
        this.availableUnitsTextField.setText("");
        this.priceTextField.setText("");
    }


    @Override
    public JButton getViewButton() {
        return viewButton;
    }
    
    @Override
    public JButton getSearchButton() {
        return searchButton;
    }

    @Override
    public JButton getCloseButton() {
        return closeButton;
    }

    @Override
    public void clearItemTable() {
        int numberOfRow = this.itemTable.getModel().getRowCount();
        
        if (numberOfRow > 0) {
            DefaultTableModel tableModel = (DefaultTableModel) this.itemTable.getModel();
            for (int index = (numberOfRow - 1); index >= 0; index --) {
                tableModel.removeRow(index);
            }            
        }
    }

    @Override
    public void displayItemDetails(Item itemEntry) {
        this.clearItemTable();
        this.clearInput();
        
        ((DefaultTableModel)this.itemTable.getModel()).addRow(new Object[]{itemEntry.getItemId(), 
                                                                               itemEntry.getTitle(), 
                                                                               itemEntry.getLabels(),
                                                                               itemEntry.getNumberInStore(),
                                                                               itemEntry.getPerPrice()});
    }

    @Override
    public void displayItemDetails(List<Item> items) {
        this.clearItemTable();
        this.clearInput();
        
        for (Item itemEntry : items) {
            ((DefaultTableModel)this.itemTable.getModel()).addRow(new Object[]{itemEntry.getItemId(), 
                                                                               itemEntry.getTitle(), 
                                                                               itemEntry.getLabels(),
                                                                               itemEntry.getNumberInStore(),
                                                                               itemEntry.getPerPrice()});
        }
    }

    @Override
    public void displayItemDetails(Set<Item> items) {
       this.clearItemTable();
        this.clearInput();
        
        for (Item itemEntry : items) {
            ((DefaultTableModel)this.itemTable.getModel()).addRow(new Object[]{itemEntry.getItemId(), 
                                                                               itemEntry.getTitle(), 
                                                                               itemEntry.getLabels(),
                                                                               itemEntry.getNumberInStore(),
                                                                               itemEntry.getPerPrice()});
        }
    }

    @Override
    public JTable getItemTable() {
        return itemTable;
    }

    @Override
    public Item getItemDetails() {
        return new Item(Integer.parseInt(itemIdTextField.getText()),
                            titleTextField.getText(),
                            Integer.parseInt(availableUnitsTextField.getText()), 
                            Double.parseDouble(priceTextField.getText()),
                            this.getItemLabels());                        
    }

    @Override
    public int getItemId() {
        String id = this.itemIdTextField.getText();
        return id == null || id.isEmpty() ? 0 : Integer.parseInt(id);
    }

}

