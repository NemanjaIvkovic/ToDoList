package controller;

import model.TaskDTO;
import model.TaskList;
import java.text.ParseException;

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



        //TaskDTO dto = new TaskDTO(title, date, project, note);
/*
        //check date



        boolean isLegalDate(String s) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
            sdf.setLenient(false);
            return sdf.parse(s, new ParsePosition(0)) != null;
        }

        Task t;
        try {
            t = new Task(dto);
        }
        catch (ParseException e) {
            System.out.println("Please name your Task.");
        }

        if (t != null) {
            taskList.addTask(t);
        }
*/
    }
/*
    public void getNumberOfAllTasks(){
        taskList.getNumberOfTasks();
    }
*/
    public void getDoneTasks(){
        taskList.getDoneTasks();
    }

    public void getUndoneTasks(){
        taskList.getUndoneTasks();
    }

    public void printTaskList(){
        taskList.printTaskList();
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

}
