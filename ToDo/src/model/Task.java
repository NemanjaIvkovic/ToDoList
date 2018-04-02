package model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import view.PrintView;

/**
 * This is a single task which is created by the TaskList class.
 * 
 * @author Nemanja
 */
public class Task implements Comparable<Task> {

    private String taskName;
    private Date taskDate;
    private String project;
    private String taskNote;
    private boolean isDone;
    private PrintView printView;


    /**
     * Constructor of the task takes Name, Date, Project, Note and sets state of the
     * note to not done.
     *
     * @param taskDTO Name of the Task user is currently making.
     */
    public Task(TaskDTO taskDTO) {
        this.taskName = taskDTO.getName();
        this.taskDate = taskDTO.getDate();
        this.project = taskDTO.getProject();
        this.taskNote = taskDTO.getNote();
        this.isDone = taskDTO.isDone();
        this.printView = new PrintView();
    }

    /**
     * New dateFormat object for formating date as we need it for later use.
     */
    DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");

    public String getName() {
        return taskName;
    }

    public Date getDate() {
        return taskDate;
    }

    public String getNote() {
        return taskNote;
    }

    public String getProject() {
        return project;
    }

    public boolean getIsDone() {
        return isDone;
    }

    public void setIsDone() {
        isDone = true;
    }

    public void setTaskName(String TaskName) {
        this.taskName = TaskName;
    }

    public void setTaskDate(String taskDate) throws ParseException {
        this.taskDate = dateFormat.parse(taskDate);
    }

    /**
     * Set new project when user wants to edit project.
     * @param project New project form user.
     */
    public void setProject(String project) {
        this.project = project;
    }

    /**
     * Set new taskNote when user wants to edit taskNote.
     * @param taskNote New taskNote from user.
     */
    public void setTaskNote(String taskNote) {
        this.taskNote = taskNote;
    }

    /**
     * Returns status in a more suitable form for user ro read.
     * @return status of the task set as Done or Undone.
     */
    public String getStatus() {
        String status = "Undone";
        if (isDone == true) {
            status = "Done";
        }
        return status;
    }

    /**
     * Compares two tasks on order to decide earlier due date.
     * @param other Temporary task to compare with current one.
     * @return Task with closer due date.
     */
    @Override
    public int compareTo(Task other) {
        return this.taskDate.compareTo(other.getDate());
    }

    /**
     * Edits fields of task, sets new name, date, project, note or status to the wanted task.
     */
    public void editTask() {
        boolean invalidChoice = true;
        while (invalidChoice) {
            Scanner reader = new Scanner(System.in);
            printView.printMessage("To edit Name press: 1 \nTo edit Date press: 2 \nTo edit project press: 3 \nTo edit Note press: 4 \nTo edit status press: 5");
            printView.printInput("");
            String command = reader.nextLine();

            if (command.equals("1")) {
                printView.printMessage("Enter new name of task: ");
                String newName = reader.nextLine();
                setTaskName(newName);
                printView.printMessage("New name of the task is: " + newName);
                invalidChoice = false;
            }
            else if (command.equals("2")) {
                boolean correctDateFormat = true;
                while (correctDateFormat) {
                    printView.printMessage("Enter new due date.");
                    printView.printMessage("Correct date format is dd/mm/yyyy");
                    try {
                        setTaskDate(reader.nextLine());
                        printView.printMessage("New due date is: ");
                        correctDateFormat = false;
                    } catch (ParseException e) {
                        printView.printMessage("Date format is not correct.");
                    }
                }
                invalidChoice = false;
            }
            else if (command.equals("3")) {
                printView.printMessage("Enter new project: ");
                String newProject = reader.nextLine();
                setProject(newProject);
                printView.printMessage("New project: " + newProject);
                invalidChoice = false;
            }
            else if (command.equals("4")) {
                printView.printMessage("Enter new note: ");
                String newTaskNote = reader.nextLine();
                setTaskNote(newTaskNote);
                printView.printMessage("New note is: " + newTaskNote);
                invalidChoice = false;
            }
            else if (command.equals("5")) {
                setIsDone();
                printView.printMessage("New status of the task is: " + getStatus());
                invalidChoice = false;
            } else {
                printView.printMessage("Please enter the valid number.");
                invalidChoice = true;
            }
        }
    }



    /**
     * Casts everything to String in order to be used for printing and storing.
     **/
    @Override
    public String toString(){
    	return String.format("%s;%s;%s;%s;%s", taskName, taskDate, taskNote, project, isDone);
    }
}
