/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import main.TaskList;
import main.Task;

public class MainClass{
    
    public static void main(String[] args) {
        // ToDo list logic
        //Task task1 = new Task("name", "date", "project", "note");
        
        //task1.printTask();
        
        TaskList testList = new TaskList();
        
        testList.addTestTasks();
        
        testList.printTaskList();
        
        //System.out.println(testList.getNumberOfTasks());
    }
} 




