package model;


import java.util.Date;

/**
 * Class TaskDTO holds the parameters temporarily to be stored later on in Task.
 * @author Nemanja
 */
public class TaskDTO {
    
    private String taskName;
    private Date taskDate;
    private String project;
    private String taskNote;
    private boolean isDone;

    /**
     * Constructor of the taskDTO object.
     * @param taskName Name of the task
     * @param taskDate Due date of the task
     * @param project Project to which task belongs
     * @param taskNote Users note for the task
     */
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
