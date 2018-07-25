package fit5042.tutex.gui;

import fit5042.tutex.repository.entities.Property;
import java.util.List;
import javax.swing.JButton;

/**
 * It defines the structure that all the GUI of the RealEstateAgency 
 * 
 * @author Eddie
 */
public interface RealEstateAgencyGUI {

    /**
     * Clear all the TextField in the GUI
     */
    void clearTextFields();

    /**
     * Display a message in the pop up window
     *
     * @param message - the message to display
     */
    void displayPopUpMessage(String message);

    /**
     * Display the details of the properties
     *
     * @param property - the details of the property to display
     */
    void displayPropertyDetails(Property property);
    
    /**
     * Display the details of the properties
     *
     * @param properties - the details of the properties to display
     */
    void displayPropertyDetails(List<Property> properties);

    /**
     * Return the Add Property button
     *
     * @return the attribute addButton
     */
    JButton getAddButton();

    /**
     * Return the Close Window button
     *
     * @return the attribute closeButton
     */
    JButton getCloseButton();
    
    /**
     * Return the Search Property by ID button
     *
     * @return the attribute searchButton
     */
    JButton getSearchButton();

    /**
     * Return the Display All Properties button
     *
     * @return the attribute viewButton
     */
    JButton getViewButton(); 

    /**
     * Return the details of the properties to add to the repository
     *
     * @return a Property object that contains all the details
     */
    Property getPropertyDetails();

    /**
     * Return the id of the property to search the repository for
     *
     * @return the id of the property to search the repository for
     */
    int getPropertyId();
}
