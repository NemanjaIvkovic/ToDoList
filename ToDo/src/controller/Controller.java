package controller;

import model.Task;
import model.TaskDTO;
import model.TaskList;
import dbhandler.DbHandler;

import java.io.File;
import java.text.ParseException;
import java.util.ArrayList;

/**
 *
 * @author Nemanja
 */
public class Controller {


    private TaskList taskList;



    public Controller(){
        taskList = new TaskList();
    }

    public void makeNewTask(TaskDTO taskDTO) throws ParseException {
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

    }

}
