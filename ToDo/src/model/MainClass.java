/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import model.TaskList;
import model.Task;

public class MainClass{
    
    public static void main(String[] args) {
        // ToDo list logic
        //Task task1 = new Task("name", "date", "project", "note");
        
        //task1.printTask();
        
        TaskList testList = new TaskList();
        
        testList.addTestTasks();
        
        testList.getNumberOfDoneTasks();
        
        //System.out.println(testList.getNumberOfTasks());
    }
} 




