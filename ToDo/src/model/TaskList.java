package model;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * ArrayList of <code>tasks</code>, from the Task class to be stored and manipulated
 * in this class
 * @author Nemanja
 */
public class TaskList {
    
    ArrayList<Task> tasks = new ArrayList<>();
    
    /**
     * Adds tasks to ArrayList of tasks.
     * @param task Single task 
     */
    public void addTask(Task task){
        tasks.add(new Task("","","",""));
    }
    
    /**
     * Gets tasks from ArrayList. 
     */
    public int getNumberOfTasks(){
        return tasks.size();
    }
    
    /**
     * This method filters tasks according to 
     */
    public void getDoneTasks(){
    	ArrayList<Task> result = (ArrayList<Task>) tasks.stream()         // convert list to stream
                .filter(task -> !true==(task.getIsDone()))                // we dont like mkyong
                .collect(Collectors.toList());                            // collect the output and convert streams to a List

        result.forEach(System.out::println);                              //output : spring, node
    }
    
   
    /**
     * Removes all members of the list.
     * @return 
     */
    public boolean removeCollection(){
        return tasks.removeAll(tasks);
    }
    
    /**
     * 
     * 
     */
    public void printTaskList(){
        for(Task task : tasks){
            System.out.println(task.getName() + " | " + task.getDate() + " | " +
                    task.getProject() + " | " + task.getNote() + " | " + task.getIsDone());
        }
    }
    
        
    /**
     * Adds hard coded number of tasks for testing purposes (to be deleted later).
     */
    public void addTestTasks(){
        
        tasks.add(new Task("Learn to code", 03;02;2019, "SDA3", "You will learn something"));
        tasks.add(new Task("Do the disshes.", "2018.02.30", "Home", "Wife is waching."));
        tasks.add(new Task("Learn OOD", "2018.03.10", "SDA3", "You will learn something."));
        tasks.add(new Task("Do To Do List", "2018.03.30", "SDA3", "Hope you will make it."));
        tasks.add(new Task("Take a walk", "2018.03.17", "Free Time", "Let these legs work."));
        tasks.add(new Task("Don't be stupid!!", "Always", "You", "You probably always will be."));
        tasks.add(new Task("Clean the house.", "2018.03.18", "Home", "You know you like that hoover."));
        tasks.add(new Task("Repair the bike.", "2044.14.20", "Free Time", "Winter is coming."));
        tasks.add(new Task("Learn Swedish.", "2017.00.20", "You", "You will learn something"));
        tasks.add(new Task("Call 911", "2018.03.30", "You", "Now you screwd up."));
    }
   
  
}
