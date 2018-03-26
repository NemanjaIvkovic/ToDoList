/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import java.util.Date;

/**
 *
 * @author Nemanja
 */
public class TaskDTO {
    
    private String taskName;
    private Date taskDate;
    private String project;
    private String taskNote;
    private boolean isDone;

    public TaskDTO (String taskName, String project, Date dueDate) {

        this.taskName = taskName;        
        this.project = project;
        this.taskDate = taskDate;
        this.isDone= false;
    }


    public String getTitle() {
        return taskName;
    }

    public Date getTaskDate() {
        return taskDate;
    }

    public boolean isDone() {
        return isDone;
    }

    public String getProject() {
        return project;
    }
    
}
