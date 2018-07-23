/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fit5042.tutex;

import fit5042.tutex.repository.PropertyRepository;
import fit5042.tutex.repository.PropertyRepositoryFactory;
import fit5042.tutex.repository.entities.Property;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Driver class
 * 
 * @author Eddie
 */
public class RealEstateAgency {
    
    private String name;
    private final PropertyRepository propertyRepository;

    public RealEstateAgency(String name) throws Exception {
        this.name = name;
        this.propertyRepository = PropertyRepositoryFactory.getInstance();
    }
    
    public void createProperties() {
        try {
            this.propertyRepository.addProperty(new Property(1, "24 Boston Ave, Malvern East VIC 3145, Australia", 2, 150, 420000));
            this.propertyRepository.addProperty(new Property(2, "11 Bettina St, Clayton VIC 3168, Australia", 3, 352, 360000));
            this.propertyRepository.addProperty(new Property(3, "3 Wattle Ave, Glen Huntly VIC 3163, Australia", 5, 800, 650000));
            this.propertyRepository.addProperty(new Property(4, "3 Hamilton St, Bentleigh VIC 3204, Australia", 2, 170, 435000));
            this.propertyRepository.addProperty(new Property(5, "82 Spring Rd, Hampton East VIC 3188, Australia", 1, 60, 820000));
            System.out.println("5 properties added successfully");
        } catch (Exception ex) {
            System.out.println("Failed to create properties: " + ex.getMessage());
        }
    }
    
    public void searchPropertyById() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the ID of the property you want to search: ");
        int id = scanner.nextInt();
        try {
            Property property = this.propertyRepository.searchPropertyById(id);
            if (property != null) {
                System.out.println(property.toString());
            } else {
                System.out.println("Property not found");
            }  
        } catch (Exception ex) {
            System.out.println("Failed to search property by ID: " + ex.getMessage());
        }
    }
    
    public void displayAllProperties() {
        try {
            for (Property property : this.propertyRepository.getAllProperties()) {
                System.out.println(property.toString());
            }
        } catch (Exception ex) {
            Logger.getLogger(RealEstateAgency.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void run() {
        this.createProperties();
        System.out.println("***********************************************************************************");
        this.displayAllProperties();
        System.out.println("***********************************************************************************");
        this.searchPropertyById();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public static void main(String[] args) {
        try {
            new RealEstateAgency("Monash Real Estate Agency").run();
        } catch (Exception ex) {
            System.out.println("Failed to run application: " + ex.getMessage());
        }
    }
    
}
