/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

//import model.Task;
public class MainClass{
    
    public static void main(String[] args) {
        // ToDo list logic
        Task task1 = new Task();
        
        System.out.println(task1.getName());
        task1.printTask();
        
        Task task2 = new Task();
    }
}

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
    
    public void printTask(){
        System.out.println("Method start.");
        System.out.println(taskName);
        System.out.println(taskDate);
        System.out.println(taskNote);
    }
}

