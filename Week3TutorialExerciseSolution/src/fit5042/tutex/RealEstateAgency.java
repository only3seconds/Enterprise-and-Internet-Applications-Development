/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex;

import fit5042.tutex.gui.RealEstateAgencyGUI;
import fit5042.tutex.repository.PropertyRepository;
import fit5042.tutex.repository.PropertyRepositoryFactory;
import fit5042.tutex.repository.entities.Property;
import fit5042.tutex.gui.SimpleGUIImpl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.SwingUtilities;

/**
 *
 * @author Eddie
 */
public class RealEstateAgency implements ActionListener {

    private String name;

    private final PropertyRepository propertyRepository;
    private RealEstateAgencyGUI gui;

    public RealEstateAgency(String name) throws Exception {
        this.name = name;
        this.propertyRepository = PropertyRepositoryFactory.getInstance();
    }

    public void initView() {
        this.gui = new SimpleGUIImpl(this);
    }

    @Override
    public void actionPerformed(ActionEvent event) {

        if (event.getSource() == gui.getViewButton()) {
            this.displayAllProperties();
        } else if (event.getSource() == gui.getAddButton()) {
            this.addProperty();
        } else if (event.getSource() == gui.getSearchButton()) {
            this.searchPropertyById();
        }  else {
            System.exit(0);
        }
    }
    
    public void searchPropertyById() {
        
        int id = this.gui.getPropertyId();
        
        try {
            Property property = this.propertyRepository.searchPropertyById(id);
            if (property != null) {
                this.gui.displayPropertyDetails(property);
            } else {
                this.gui.displayPopUpMessage("Property not found");
            }  
        } catch (Exception ex) {
            this.gui.displayPopUpMessage("Failed to search property by ID: " + ex.getMessage());
        }
    }

    private void displayAllProperties() {
        try {
            List<Property> properties = this.propertyRepository.getAllProperties();
            
            if (properties != null && !properties.isEmpty()) {
                this.gui.displayPropertyDetails(properties);
            } else {
                gui.displayPopUpMessage("No properties in the system");
            }
            
        } catch (Exception ex) {
            gui.displayPopUpMessage("Failed to retrieve properties: " + ex.getMessage());
        }
    }

    private void addProperty() {
        Property property = gui.getPropertyDetails();

        try {
            this.propertyRepository.addProperty(property);
            this.displayAllProperties();
        } catch (Exception ex) {
            gui.displayPopUpMessage("Failed to add property: " + ex.getMessage());
        }
        gui.clearTextFields();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        try {
            final RealEstateAgency agency = new RealEstateAgency("Monash Real Estate Agency");
            //JDK 1.7
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    agency.initView();
                }
            });
            
//            //JDK 1.8
//            SwingUtilities.invokeLater(()-> {
//                agency.initView();
//            });
        } catch (Exception ex) {
            System.out.println("Failed to run application: " + ex.getMessage());
        }
    }

}
