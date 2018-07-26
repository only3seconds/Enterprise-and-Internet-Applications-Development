package fit5042.tutex.repository.entities;

import java.io.Serializable;
import java.text.NumberFormat;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author thinking
 */
@Entity
@NamedQueries({@NamedQuery(name = Property.FIND_ALL, query = "SELECT p FROM Property p")})
public class Property implements Serializable {
    
    public static final String FIND_ALL =  "Property.getAllProperties";

    //A number that is used to uniquely identify a property
    private int propertyId;
    //The full address of a property
    private String address;
    //The number of bedrooms a property has
    private int numberOfBedrooms;
    //The size of the property
    private double size;
    //How much the property costs
    private double price;

    /**
     * Default constructor
     */
    public Property() {
        this.propertyId = 0;
        this.address = "Unknown";
        this.numberOfBedrooms = 0;
        this.size = 0;
        this.price = 0;
    }
    
    /**
     * Copy constructor
     */
    public Property(Property property) {
        this.propertyId = property.propertyId;
        this.address = property.address;
        this.numberOfBedrooms = property.numberOfBedrooms;
        this.size = property.size;
        this.price = property.price;
    }

    /**
     * Parameterized constructor
     *
     * @param propertyId - initialize the attribute propertyId to this value
     * @param address - initialize the attribute address to this value
     * @param numberOfBedrooms - initialize the attribute numberOfBedrooms to this value
     * @param size - initialize the attribute size to this value
     * @param price - initialize the attribute price to this value
     */
    public Property(int propertyId, String address, int numberOfBedrooms, double size, double price) {
        this.propertyId = propertyId;
        this.address = address;
        this.numberOfBedrooms = numberOfBedrooms;
        this.size = size;
        this.price = price;
    }

    /**
     * 与数据库表中的 PROPERTY_ID 相对应
     * @return the value of attribute propertyId
     */
    @Id
    @Column(name = "property_id")
    public int getPropertyId() {
        return propertyId;
    }

    /**
     * Change the value of attribute propertyId to a new value
     *
     * @param propertyId - the new value of attribute propertyId
     */
    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    /**
     * @return the value of attribute address
     */
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    /**
     * Change the value of attribute address to a new value
     *
     * @param address - the new value of attribute address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the value of attribute numberOfBedrooms
     */
    @Column(name = "bedrooms_number")
    public int getNumberOfBedrooms() {
        return numberOfBedrooms;
    }

    /**
     * Change the value of attribute numberOfBedrooms to a new value
     *
     * @param numberOfBedrooms - the new value of attribute numberOfBedrooms
     */
    public void setNumberOfBedrooms(int numberOfBedrooms) {
        this.numberOfBedrooms = numberOfBedrooms;
    }

    /**
     * @return the value of attribute size
     */
    @Column(name = "size")
    public double getSize() {
        return size;
    }

    /**
     * Change the value of attribute size to a new value
     *
     * @param size - the new value of attribute size
     */
    public void setSize(double size) {
        this.size = size;
    }

    /**
     * @return the value of attribute price
     */
    @Column(name = "education_level")
    public double getPrice() {
        return price;
    }

    /**
     * Change the value of attribute price to a new value
     *
     * @param price - the new value of attribute price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return a string representation of the property object
     */
    @Override
    public String toString() {
        //NumberFormat.getCurrencyInstance().format(price) 货币格式化输出
        return propertyId + " " + address + " " + numberOfBedrooms + "BR(s) " + size + "sqm " + NumberFormat.getCurrencyInstance().format(price);
    }
}
