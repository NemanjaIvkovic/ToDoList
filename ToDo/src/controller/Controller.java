package controller;

import model.TaskDTO;
import model.TaskList;

/**
 *
 * @author Nemanja
 */
public class Controller {

    private TaskList taskList;

    public Controller(){
        taskList = new TaskList();
    }

    public void makeNewTask(TaskDTO taskDTO){
        taskList.addTask(taskDTO);
    }

    public void getDoneTasks(){
        taskList.getDoneTasks();
    }

    public void getUndoneTasks(){
        taskList.getUndoneTasks();
    }

    public void printTaskList(){
        taskList.printTaskList();
    }

    public void deleteTask(int taskIndex){
        taskList.deleteTask(taskIndex);
    }

    public boolean deleteTaskList(){
        return taskList.removeCollection();
    }

    public void getTasksByDate(){
        taskList.sortTasksByDate();
    }

    public void getTasksByProject(String project){
        taskList.getTasksByProject(project);
    }

    public void editTask(int taskIndex){
        taskList.editTask(taskIndex);
    }

    public void loadFromFile(){
        taskList.loadFromFile();
    }

    public void writeToFile(){
        taskList.writeToFile();
    }
}
