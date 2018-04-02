package model;

import dbhandler.DbHandler;

import java.io.IOException;
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
     * @param taskDTO Task DTO contains all data for the task.
     */
    public void addTask(TaskDTO taskDTO){
        Task task = new Task(taskDTO);
        tasks.add(task);
    }

    /**
     * Filters and prints out done tasks.
     */
    public void getDoneTasks() {
        tasks.stream()
                .filter(task -> true == task.getIsDone())
                .forEach(x -> System.out.println("Task Name is: " + x.getName() + "\nTask Due Date is: " + x.dateFormat.format(x.getDate())
                        + "\nTask belongs to the project: " + x.getProject() + "\nTask Note: " + x.getNote() + "\nStatus: " + x.getStatus()));

    }

    /**
     * Prints out tasks that are not done.
     */
    public void getUndoneTasks() {
        tasks.stream()
                .filter(task -> false == task.getIsDone())
                .forEach(x -> System.out.println("Task Name is: " + x.getName() + "\nTask Due Date is: " + x.dateFormat.format(x.getDate())
                        + "\nTask belongs to the project: " + x.getProject() + "\nTask Note: " + x.getNote() + "\nStatus: " + x.getStatus()));
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
     * Asks for project, than filters list and pints out tasks for wanted project. If entered non existing project
     * informs user about that.
     * @param project project for which user wants tasks.
     */

    public void getTasksByProject(String project) {
        List<Task> filteredList = tasks.stream()
                .filter(task -> project.equals(task.getProject()))
                .collect(Collectors.toList());
        if (filteredList.isEmpty()) {
            System.out.println("There is no such project.");
        } else {
            int i = 1;
            for (Task task : filteredList) {
                System.out.println("Task number: " + i + "\nTask Name is: " + task.getName() + "\nTask Due Date is: " + task.dateFormat.format(task.getDate())
                        + "\nTask belongs to the project: " + task.getProject() + "\nTask Note: " + task.getNote() + "\nStatus: " + task.getStatus());
                System.out.println();
                i++;
            }
        }
    }

    /**
     * Takes index of the task use wants to edit and calls method for editing task.
     * @param taskIndex Index of the task user wants to edit.
     */
    public void editTask(int taskIndex){

        Task taskToEdit = tasks.get(taskIndex);
        taskToEdit.editTask();
    }

    public void deleteTask(int taskIndex){
        tasks.remove(taskIndex);
    }

    /**
     * Removes all members of the list.
     *
     * @return Returnes true if the removal was successful.
     */
    public boolean removeCollection() {
        return tasks.removeAll(tasks);
    }

    /**
     * Formats and prints out the whole task list and adds counter to print out the number of task.
     */
    public void printTaskList() {
        int i = 1;
        for (Task task : tasks) {
            System.out.println("Task number: " + i + "\nTask Name is: " + task.getName() + "\nTask Due Date is: " + task.dateFormat.format(task.getDate())
                    + "\nTask belongs to the project: " + task.getProject() + "\nTask Note: " + task.getNote() + "\nStatus: " + task.getStatus());
            System.out.println();
            i++;
        }
    }

    /**
     * Makes new <code>bdHandler</code> object gets DTOs of task, puts it in a list and adds to the new list.
     */
    public void loadFromFile(){
        DbHandler dbHandler = new DbHandler();
        ArrayList<TaskDTO> taskDTOS = dbHandler.loadFromFile();

        for (TaskDTO taskDTOS1 : taskDTOS){
            addTask(taskDTOS1);
        }

    }

    /**
     * Writes tasks from taskList to the file.
     */
    public void writeToFile(){
        ArrayList<Task> tasks = this.tasks;

        DbHandler dbHandler = new DbHandler();
        try {
            dbHandler.writeToFile(tasks);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Saving failed.");
        }

    }

    /**
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
