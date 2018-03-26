package view;

/**
 * List of valid commands that represent application functionalities
 */

public enum CommandWord {

    NEW("new"), TASK("task"), TASKS("tasks"), EDIT("edit"), REMOVE("remove"), HELP("help"), QUIT("quit"), UNKNOWN("?");


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
