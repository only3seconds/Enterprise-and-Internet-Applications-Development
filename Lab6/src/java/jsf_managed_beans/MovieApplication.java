package jsf_managed_beans;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import model.Movie;

/**
 *managed bean: application bean
 * @author thinking
 */
@Named(value = "movieApplication")	
@ApplicationScoped		
public class MovieApplication {		
    public static final	String APP_TITLE = "Movie Browser";	
    private ArrayList<Movie> movies;
    
    public MovieApplication()	{		
    //Add some movie data to our app	
    
    movies = new ArrayList<Movie>();		
    movies.add(new Movie("The Lord of the Rings: The Fellowship of the Ring", 2001, "Peter Jackson"));		
    movies.add(new Movie("Inception", 2010, "Christopher Nolan"));		
    movies.add(new Movie("The Hunger Games", 2012, "Gary Ross"));		
    movies.add(new Movie("Elysium", 2013, "NeillsBlomkamp"));		
    movies.add(new Movie("Pacific Rim",	2013, "Guillermo del Toro"));
    }	
    
    public ArrayList<Movie>	getMovies()	{		
        return movies;		
    }	
    
}
