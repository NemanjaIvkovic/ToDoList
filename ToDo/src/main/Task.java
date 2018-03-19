/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 * This is a single task which is created by the TaskList class.
 * @author Nemanja
 */
public class Task {
    
    private String taskName;
    private String taskDate;    //Should be object of Date or DueDate.
    private String project;
    private String taskNote;
    private boolean isDone;
    
    /**
     * Constructor of the task takes Name, Date, Project, Note 
     * and sets state of the note to not done. 
     * @param taskName Name of the Task user is currently making. 
     * @param taskDate Due Date of the Task.
     * @param project Project to whom particular task is assigned.
     * @param taskNote Note to go with the task.
     */
    public Task(String taskName, String taskDate, String project, String taskNote){
        this.taskName = taskName;
        this.taskDate = taskDate;
        this.project = project;    
        this.taskNote = taskNote;
        this.isDone = false;
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
    
    public String getProject(){
        return project;
    }
    
    public boolean getIsDone(){
        return isDone;
    }
    
    //public boolean isDone(){
    //    if (){
            
    //    }
    //}
    
    /**
     * Prints out every field from the task mainly as a self check.
     */
    public void printTask(){
        System.out.println("Method start.");
        System.out.println(taskName);
        System.out.println(taskDate);
        System.out.println(project);
        System.out.println(taskNote);
        System.out.println(isDone);
        System.err.println("Method end.");
    }
    
}
