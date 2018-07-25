/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fit5042.tutex.repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * The class is responsible for creating property repository
 * 
 * @author Eddie Leung
 */
public class PropertyRepositoryFactory {
    private static final PropertyRepository REPOSITORY_INSTANCE = createInstance();
    
    private static PropertyRepository createInstance()
    {
        try{
            
            Properties repositoryProperty = new Properties();
            repositoryProperty.loadFromXML(new FileInputStream(new File("repository-settings.properties")));
            return (PropertyRepository)Class.forName(repositoryProperty.getProperty("repository.implementation.use")).newInstance();         
        }
        catch (IOException | ClassNotFoundException | IllegalAccessException | InstantiationException ex)
        {
            System.out.println(ex.getMessage());
        }
        
        return null;
    }
    
    public static PropertyRepository getInstance() throws Exception
    {
        if (REPOSITORY_INSTANCE != null)
            return REPOSITORY_INSTANCE;
        throw new Exception("Failed to create repository");
    }
}
