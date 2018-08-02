/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * create a model for our Movie objects
 * @author thinking
 */
public	class	Movie	{	
    private String title;		
    private int year;		
    private String director;
    
    public Movie(String title, int year, String director) {		
        this.title =	title;		
        this.year =	year;		
        this.director =	director;		
    }		

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
    
    
}
