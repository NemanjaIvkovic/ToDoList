package model;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ArrayList of <code>tasks</code>, from the Task class to be stored and manipulated
 * in this class
 *
 * @author Nemanja
 */
public class TaskList {

    private ArrayList<Task> tasks;

    public TaskList() {
        tasks = new ArrayList<>();

    }

    /**
     * Adds <code>tasks</code> to ArrayList of tasks.
     *
     * @param
     */
    public void addTask(TaskDTO taskDTO) throws ParseException {
        Task task = new Task(taskDTO);
        tasks.add(task);
    }

    /**
     * Gets number of tasks from ArrayList.
     */
/*
    public int getNumberOfTasks() {

        return tasks.size();
    }
*/

    /**
     * This method prints out done tasks.
     */
    public void getDoneTasks() {
        tasks.stream()
                .filter(task -> true == task.getIsDone())
                .forEach(System.out::println);

    }

    /**
     * This method prints out tasks that are not done.
     */
    public void getUndoneTasks() {
        tasks.stream()
                .filter(task -> false == task.getIsDone())
                .forEach(System.out::println);
    }

    /**
     * Sorts tasks by date and prints out.
     */
    public void sortTasksByDate() {
        Collections.sort(this.tasks);
        System.out.println("________________________________");
        printTaskList();
    }


    /**
     * Prints out task for wanted project.
     */

    public void getTasksByProject(String project) {
        List<Task> filteredList = new ArrayList<>();
        filteredList = tasks.stream()
                .filter(task -> project.equals(task.getProject()))
                .collect(Collectors.toList());
        if (filteredList.isEmpty()) {
            System.out.println("...");
        } else {
            printTaskList();
        }
    }
/*
    public boolean editTask(taskIndex){
        Task taskToEdit = tasks.get(taskIndex - 1);

        taskToEdit.editTask();
    }
*/
    /**
     * Removes all members of the list.
     *
     * @return Returnes true if the removal was successful.
     */
    public boolean removeCollection() {
        return tasks.removeAll(tasks);
    }

    /**
     *
     */
    public void printTaskList() {
        int i = 0;
        for (Task task : tasks) {
            System.out.println("Task number: " + i + "\nTask Name is: " + task.getName() + "\nTask Due Date is: " + task.dateFormat.format(task.getDate())
                    + "\nTask belongs to the project: " + task.getProject() + "\nTask Note: " + task.getNote() + "\nStatus: " + task.getStatus());
            System.out.println();
            i++;
        }
    }

    public int index(){
        int index = tasks.indexOf(tasks)+1;
        return index;
    }

    /**
     * System.out.println();
     * Adds hard coded number of tasks for testing purposes (to be deleted later).
     */
/*
    public void addTestTasks() throws ParseException {
        TaskDTO dto = new TaskDTO("Learn to code", "26/03/2018", "SDA3", "You will learn something");
        tasks.add(new Task(dto));
        TaskDTO dto1 = new TaskDTO("Do the dishes.", "30/02/2017", "Home", "Wife is watching.");
        tasks.add(new Task(dto1));
    }
*/

}
