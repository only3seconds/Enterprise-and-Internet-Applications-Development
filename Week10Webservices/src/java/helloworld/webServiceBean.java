package helloworld;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
/**
*
* @author thinking
*/
@Named(value = "webServiceBean")
@SessionScoped
public class webServiceBean implements Serializable { 
    private String name;
    
    /**
    * Get the value of name
    *
    * @return the value of name
    */
    public String getName() {
        return name;
    }
    
    /**
    * Set the value of name
    *
    * @param name new value of name
    */
    public void setName(String name) {
        this.name = name;
    }
    
    
    /**
    * Creates a new instance of webServiceBean
    */
    public webServiceBean() {
    }
    
    setNameWebService myWS;
    public void setNameWebservice(){

        myWS= new setNameWebService();
        myWS.setPostName2(getName());
    }
 
    static class setNameWebService {
        private WebTarget webTarget;
        private Client client;
        private static final String BASE_URI = "http://localhost:8080/Week10Webservices/webresources";
        
        public setNameWebService() {
            client = javax.ws.rs.client.ClientBuilder.newClient();
            webTarget = client.target(BASE_URI).path("greeting");
        }
        
        public void setPostName() throws ClientErrorException {
            webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_FORM_URLENCODED).post(null);
        }
        
        public void setPostName2(String name) throws ClientErrorException {
        //create a form and add to this form information of a user
            Form form = new Form();
            form.param("name", name);
            webTarget.request(MediaType.APPLICATION_FORM_URLENCODED_TYPE).post(Entity.entity(form,MediaType.APPLICATION_FORM_URLENCODED_TYPE));
            //webTarget.queryParam("name",name).request(javax.ws.rs.core.MediaType.APPLICATION_FORM_URLENCODED).post(null);
            } 
        
        
        public String getHtml() throws ClientErrorException {
            WebTarget resource = webTarget;
            return resource.request(javax.ws.rs.core.MediaType.TEXT_HTML).get(String.class);
        }
        
        public void putHtml(Object requestEntity) throws ClientErrorException {

            webTarget.request(javax.ws.rs.core.MediaType.TEXT_HTML).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.TEXT_HTML));
        }
        
         public void close() {
             client.close();
        }
    } 
 
 
}