/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex;

import fit5042.tutex.calculator.MonthlyPaymentCalculator;
import fit5042.tutex.gui.MonthlyPaymentCalculatorandRealEstateAgencyGUIInterface;
import fit5042.tutex.gui.RealEstateAgencyGUI;
import fit5042.tutex.repository.entities.Property;
import fit5042.tutex.gui.TableGUIImpl;
import fit5042.tutex.repository.PropertyRepository;
import fit5042.tutex.repository.entities.ContactPerson;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Set;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.ejb.EJB;
import javax.swing.SwingUtilities;

/**
 *
 * @author Eddie
 */
public class RealEstateAgency implements ActionListener, ListSelectionListener {
    
    @EJB
    private static PropertyRepository propertyRepository;
    
    @EJB
    private static MonthlyPaymentCalculator calculator;

    private String name;
    private MonthlyPaymentCalculatorandRealEstateAgencyGUIInterface gui;

    public RealEstateAgency(String name) throws Exception {
        this.name = name;
    }

    public void initView() {
        this.gui = new TableGUIImpl(this, this);
        this.displayAllProperties();
        this.displayAllContactPeople();
    }

    @Override
    public void actionPerformed(ActionEvent event) {

        if (event.getSource() == gui.getViewButton()) {
            this.displayAllProperties();
        } else if (event.getSource() == gui.getAddButton()) {
            this.addProperty();
            this.displayAllProperties();
        } else if (event.getSource() == gui.getSearchButton()) {
            this.searchProperty();
        } else if (event.getSource() == gui.getUpdateButton()) {
            this.updateProperty();
        } else if (event.getSource() == gui.getDeleteButton()) {
            this.deleteProperty();
        } else if (event.getSource() == gui.getCalculateButton()) {
            Double principle = gui.getPrinciple();
                Double interestRate = gui.getInterestRate();
                int numberOfYears = gui.getNoOfYears();

                gui.updateResult(calculator.calculate(principle, numberOfYears, interestRate));           
        } else {
            System.exit(0);
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent event) {
        if ((event.getSource() == this.gui.getPropertyTable().getSelectionModel())
            && (! event.getValueIsAdjusting()))
        {
            try
            {
                if (this.gui.isPropertySelected()) {
                    int propertyId = this.gui.getSelectedPropertyId();
                
                    Property property = this.propertyRepository.searchPropertyById(propertyId);
                    this.gui.displaySelectedPropertyDetails(property);
                }               
            }
            catch (Exception e)
            {
                gui.displayMessageInDialog(e.getMessage());
            }
        }
    }
    
    public void updateProperty() {
        try {
            Property property = this.gui.getPropertyDetails();
            propertyRepository.editProperty(property);
            this.displayAllProperties();
            this.gui.clearInput();
        } catch (Exception ex) {
            this.gui.displayMessageInDialog("Failed to update property: " + ex.getMessage());
        }
    }

    public void deleteProperty() {
        try {
            int propertyId = this.gui.getPropertyId();
            propertyRepository.removeProperty(propertyId);
            this.displayAllProperties();
            //this.displayAllContactPeople();
        } catch (Exception ex) {
            this.gui.displayMessageInDialog("Failed to update property: " + ex.getMessage());
        }  finally {
            this.gui.clearInput();
        }
    }
    
    public void searchProperty() {
        
        int id = this.gui.getPropertyId();
        
        if (id > 0) {
            this.searchPropertyById(id);
        } else {
            double budget = this.gui.getBudget();
            
            if (budget > 0) {
                this.searchPropertyByBudget(budget);
            } else {               
                ContactPerson contactPerson = this.gui.getSelectedContactPerson();
                this.searchPropertyByContactPerson(contactPerson);
            }
        }
    }
    
    public void searchPropertyByContactPerson(ContactPerson contactPerson) {
        
        try {
            if (contactPerson != null) {
                Set<Property> properties = propertyRepository.searchPropertyByContactPerson(contactPerson);
            
                if (properties != null && !properties.isEmpty()) {
                    this.gui.displayPropertyDetails(properties);
                } else {
                    this.gui.displayMessageInDialog("No matched properties found");
                    this.gui.clearPropertyTable();
                }
            } else {
                this.gui.displayMessageInDialog("Details of the contact person not found");
                this.gui.clearPropertyTable();
            }      
        } catch (Exception ex) {
            this.gui.displayMessageInDialog("Failed to search property by contact person: " + ex.getMessage());
            this.gui.clearPropertyTable();
        } finally {
            this.gui.clearInput();
        }
    }
    
    public void searchPropertyByBudget(double budget) {
        
        try {
            
            List<Property> properties = propertyRepository.searchPropertyByBudget(budget);
            
            if (properties != null && !properties.isEmpty()) {
                this.gui.displayPropertyDetails(properties);
            } else {
                this.gui.displayMessageInDialog("No matched properties found");
                this.gui.clearPropertyTable();
            }  
        } catch (Exception ex) {
            this.gui.displayMessageInDialog("Failed to search property by ID: " + ex.getMessage());
            this.gui.clearPropertyTable();
        } finally {
            this.gui.clearInput();
        }
    }

    public void searchPropertyById(int id) {
        
        try {
            
            Property property = propertyRepository.searchPropertyById(id);
            
            if (property != null) {
                this.gui.displayPropertyDetails(property);
            } else {
                this.gui.displayMessageInDialog("No matched properties found");
                this.gui.clearPropertyTable();
            }  
        } catch (Exception ex) {
            this.gui.displayMessageInDialog("Failed to search property by ID: " + ex.getMessage());
            this.gui.clearPropertyTable();
        } finally {
            this.gui.clearInput();
        }
    }
    
    private void displayAllContactPeople() {
        try {
            List<ContactPerson> contactPeople = propertyRepository.getAllContactPeople();
            
            if (contactPeople != null) {
                this.gui.displayContactPeople(contactPeople);
            }
            
        } catch (Exception ex) {
            this.gui.displayMessageInDialog("Failed to retrieve contact people: " + ex.getMessage());
        }
    }

    private void displayAllProperties() {
        try {
            List<Property> properties = propertyRepository.getAllProperties();
            
            if (properties != null) {
                this.gui.displayPropertyDetails(properties);
            }
            
        } catch (Exception ex) {
            this.gui.displayMessageInDialog("Failed to retrieve properties: " + ex.getMessage());
        }
    }

    private void addProperty() {
        Property property = gui.getPropertyDetails();

        try {
            propertyRepository.addProperty(property);
            this.displayAllProperties();
            this.gui.clearInput();
        } catch (Exception ex) {
            this.gui.displayMessageInDialog("Failed to add property: " + ex.getMessage());
        } finally {
            this.gui.clearInput();
        }
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
           // agency.initView();
//            //JDK 1.8
//            SwingUtilities.invokeLater(()-> {
//                agency.initView();
//            });
            
        } catch (Exception ex) {
            System.out.println("Failed to run application: " + ex.getMessage());
        }
    }

}
