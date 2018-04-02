package view;

/**
 * List of valid commands that represent application functionalities
 */

public enum CommandWord {

    NEW("new"), TASK("task"), TASKS("tasks"), DATE("date"), PROJECT("project"), DONE("done"), UNDONE("undone"), EDIT("edit"),
    REMOVE("remove"), HELP("help"), DELETE("delete"), LOAD("load"), QUIT("quit"), UNKNOWN("?");


    private String commandString;

    CommandWord (String commandString) {

            this.commandString = commandString;
    }

    /**
     * @return String value of the valid command
     */

    public String toString() {

            return commandString;
        }

}
