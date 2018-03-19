package model;

//import java.util.Scanner;

/**
 *Store the details of a To Do Task,
 * such as the name, date, note.
 * 
 * @author Nemanja Ivkovic
 * 2018.03.11
 */

class Task{
    private String taskName;
    private String taskDate;
    private String taskNote;
    
    public Task(){
    this.taskName = "Some simple task.";
    this.taskDate = "2018.03.12";
    this.taskNote = "You printed out something you crazy bastard! Here's a cookie.";
    } 
    public String getName(){
        return taskName;
    }
    
    public String getDate(){
        return taskDate;
    }
  
    public String getNote(){
        return taskNote;
    }
} 
            

