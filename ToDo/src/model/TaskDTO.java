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

    public TaskDTO (String taskName, Date taskDate, String project, String taskNote) {

        this.taskName = taskName;        
        this.taskDate = taskDate;
        this.project = project;
        this.taskNote = taskNote;
        this.isDone = false;

    }


    public String getName() {
        return taskName;
    }

    public Date getDate() {
        return taskDate;
    }

    public boolean isDone() {
        return isDone;
    }

    public String getProject() {
        return project;
    }

    public String getNote() {
        return taskNote;
    }
    
}
