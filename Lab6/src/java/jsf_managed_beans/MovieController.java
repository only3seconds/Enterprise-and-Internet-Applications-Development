
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf_managed_beans;

import javax.el.ELContext;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import model.Movie;

/**
 *
 * @author thinking
 */
@Named(value = "movieController")	
@RequestScoped	

public class MovieController {		
    private String pageTitle;		
    private int movieId;		
    private Movie movie;
    
    public MovieController() {		
    //Assign movie identifier via GET param		
    movieId = Integer.valueOf(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("movieID"));		
    //Assign movie based on the	id provided		
    movie = getMovie();		
    //Then we set the page title to have the movie title added
    pageTitle = movie.getTitle() + " | " + MovieApplication.APP_TITLE;
    }	
    
    public String getPageTitle() {		
        return	pageTitle;		
    }	
    
    public void setPageTitle(String pageTitle)	{		
        this.pageTitle = pageTitle;		
    }	
    
    public Movie getMovie() {		
        if(movie == null) {
        //Get application context bean MovieApplication
        ELContext context = FacesContext.getCurrentInstance().getELContext();
        MovieApplication app = (MovieApplication)FacesContext.getCurrentInstance().getApplication().getELResolver().getValue(context, null, "movieApplication");		
        //-1 to	movieId	since we +1 in JSF (to always have positive movie id!)
        return	app.getMovies().get(--movieId);
        }
        
        return movie;
    }		
}