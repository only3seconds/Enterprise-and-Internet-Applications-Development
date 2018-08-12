package fit5042.tutex.repository;

import fit5042.tutex.repository.entities.Item;
import java.util.List;
import javax.ejb.Remote;

/**
 * @autor thinking
 */
@Remote
public interface ItemRepository {

    public Item searchItemByTitle(String title) throws Exception;
    
    public Item searchItemById(int itemId) throws Exception;
    
    public List<Item> searchItemByType(String type) throws Exception;
    
    public List<Item> searchItemByPrice(double price) throws Exception;

    public List<Item> getAllItems() throws Exception;
    
    public void addItem(Item item) throws Exception;
    
    public void updateItem(Item item) throws Exception;
    
    public void deleteItem(int userId) throws Exception;
    
    
}
