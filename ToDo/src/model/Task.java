package model;

import java.util.Scanner;

/**
 *Store the details of a To Do Task,
 * such as the name, date, note.
 * 
 * @author Nemanja Ivkovic
 * 2018.03.11
 */

public class Task {
    
    
    private Scanner taskName;
    private Scanner taskDate;
    private Scanner taskNote;
    private boolean isDone;
     
    
    /**
     * Constructor for objects of class Task.
     * @param taskName 
     */
    public Task(Scanner taskName) {
        Scanner name = new Scanner(System.in);
        this.taskDate= null;
        taskNote = null;
        isDone = false;
    }

   
    /**
     * Return the taskName.
     * @return 
     */
    public Scanner getName(){        
        return taskName;
    }
    
    /**
     * Return taskDate.      
     * @return 
     */
    public Scanner getDate(){
        return taskDate;
    }
    
     /**
     * Return taskNote.      
     * @return 
     */
    public Scanner getNote(){
        return taskNote;
    }
   
            
}
