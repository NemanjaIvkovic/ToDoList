/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

	/**
	 * Constructor of the task takes Name, Date, Project, Note and sets state of the
	 * note to not done.
	 * 
	 * @param taskDTO Name of the Task user is currently making.
	 *
	 */
	public Task(TaskDTO taskDTO) {
		this.taskName = taskDTO.getName();
		this.taskDate = taskDTO.getDate();
		this.project = taskDTO.getProject();
		this.taskNote = taskDTO.getNote();
		this.isDone = taskDTO.isDone();
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

    public boolean getIsDone(){
	    return isDone;
    }

    public void setIsDone() {
        isDone = true;
    }

    public void setTaskName(String TaskName){
	    this.taskName = TaskName;
    }

    public void setTaskDate(String taskDate) throws ParseException {
        this.taskDate = dateFormat.parse(taskDate);
    }

    public void setProject(String project) {
        this.project = project;
    }

    public void setTaskNote(String taskNote) {
        this.taskNote = taskNote;
    }

    public String getStatus() {
        String status = "Undone";
        if (isDone == true) {
            status = "Done";
        }
        return status;
    }

    @Override
    public int compareTo(Task other){
	    return this.taskDate.compareTo(other.getDate());
    }

    public void editTask(){

    }

    /**
     * Casts everything to String in order to be used for printing and storing.
     **/
    @Override
    public String toString(){
    	return String.format("%s;%s;%s;%s;%s", taskName, taskDate, taskNote, project, isDone);
    }
}
