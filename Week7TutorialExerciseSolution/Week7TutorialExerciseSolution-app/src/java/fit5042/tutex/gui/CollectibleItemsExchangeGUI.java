package fit5042.tutex.gui;

import fit5042.tutex.repository.entities.Item;
import java.util.List;
import java.util.Set;
import javax.swing.JButton;
import javax.swing.JTable;

/**
 * It defines the structure that all the GUI of the CollectibleItemsExchangeGUI 
 * 
 * @author thinking
 */
public interface CollectibleItemsExchangeGUI {
    
    /**
     * Clear all the inputs in the GUI
     */
    void clearInput();

    /**
     * Clear all the text fields in the GUI
     */
    void clearTextFields();
    
    /**
     * Clear all records in the table
     */
    void clearItemTable();

    /**
     * Display a message in a dialog box
     *
     * @param message - the message to display
     */
    void displayMessageInDialog(String message);

    /**
     * Display the details of the item
     *
     * @param item - the details of the item to display
     */
    void displayItemDetails(Item item);

    
    /**
     * Display the details of the items
     *
     * @param items - the details of the properties to display
     */
    void displayItemDetails(List<Item> items);
    
    /**
     * Display the details of the properties
     *
     * @param items - the details of the items to display
     */
    void displayItemDetails(Set<Item> items);
   

    /**
     * Return the Close Window button
     *
     * @return the attribute closeButton
     */
    JButton getCloseButton();
    
    /**
     * Return the Search button
     *
     * @return the attribute searchButton
     */
    JButton getSearchButton();

    /**
     * Return the Display All Items button
     *
     * @return the attribute viewButton
     */
    JButton getViewButton();

    /**
     * Return the Item Details table
     *
     * @return the attribute itemTable
     */
    public JTable getItemTable();

    /**
     * Return the details of the properties to add to the repository
     *
     * @return a Property object that contains all the details
     */
    Item getItemDetails();

    /**
     * Return the id of the item to search the repository for
     *
     * @return the id of the item to search the repository for
     */
    int getItemId();
    
    /**
     * Return the maximum price of the item that the user wants to search the repository for
     *
     * @return the maximum price of the item to search the repository for
     */
    double getBudget();


}
