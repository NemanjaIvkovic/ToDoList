package view;

import controller.Controller;
import model.TaskDTO;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Parser {

    private CommandWords commands;
    private Controller controller;
    private PrintView printView;
    private Scanner reader;

    public Parser() {

        commands = new CommandWords();
        controller = new Controller();
        printView = new PrintView();
        reader = new Scanner(System.in);
    }

    /**
     * Reads user input and takes first two words in order to create a <code>Command</code> object.
     *
     * @return New command detected from user input.
     */

    public Command getCommand() {
        String inputLine;
        String word1 = null;
        String word2 = null;

        printView.printInput("");

        inputLine = reader.nextLine();

        Scanner tokanizer = new Scanner(inputLine);

        if (tokanizer.hasNext()) {

            word1 = tokanizer.next();

            if (tokanizer.hasNext()) {

                word2 = tokanizer.next();
            }
        }

        return new Command(commands.getCommandWord(word1), word2);
    }

    /**
     * Analyzes the <code>Command</code> received from the user and calls appropriate function.
     *
     * @param command - command inputted by the user.
     * @return If the <code>quit</code> command is detected returns <code>true</code>, if not returns <code>false<code/>.
     */

    public boolean processCommand(Command command) throws ParseException {
        boolean wantToQuit = false;
        CommandWord commandWord = command.getCommandWord();
        switch (commandWord) {
            case UNKNOWN:
                printView.printMessage("This is unknown");
                break;
            case HELP:
                printView.printMessage("This is help");
                showCommands();
                System.out.println();
                break;
            case NEW:
                printView.printMessage("Now you are making a new Task.");
                newTask();
                break;
            case TASKS:
                printView.printMessage("Here are all of your tasks:");
                printView.printMessage("___________________________");
                controller.printTaskList();
                printView.printMessage("***************************");
                break;
            case DATE:
                printView.printMessage("List of tasks sorted by date in the ascending order.");
                controller.getTasksByDate();
                break;
/*
            case PROJECT:
                printView.printMessage("List of tasks from the wanted project");
                controller.getTasksByProject();
                break;
*/
            case DONE:
                printView.printMessage("Done Tasks:");
                controller.getDoneTasks();
                break;
            case UNDONE:
                printView.printMessage("Undone tasks:");
                controller.getUndoneTasks();
                break;
            case EDIT:
                printView.printMessage("Enter the number of the task that you want to edit:");
                //controller.editTask();
                break;
            case REMOVE:
                printView.printMessage("This is remove");
                break;
            case DELETE:
                printView.printMessage("Your task list is deleted.");
                controller.deleteTaskList();
                break;
            case QUIT:
                wantToQuit = quit();
                break;
        }
        return wantToQuit;
    }

    /**
     * Shows all valid commands
     */

    public void showCommands() {
        printView.printMessage("Available commands are: ");
        System.out.println();
        commands.showAll();
    }

    /**
     * Performs <code>quit</code> command and quits the application
     *
     *
     *
     * @return false is there are two words and true if it is only <code>quit</code> command
     */

    private boolean quit() {
            return true;
        }

    /**
     * Prints out beginning message
     */

    public void getPrintStart() {

        printView.printMessage("Welcome to the ToDo Application");
        printView.printMessage("------------------------------");
    }

    public void getPrintExit() {

        printView.printMessage("Thank for using ToDo Application");
        printView.printMessage("-------------------------------");
    }


    private void newTask() throws ParseException {
        String taskName;
        String project;
        boolean correctDateFormat = true;
        Date taskDate = null;
        String taskNote;
        DateFormat dateParser = new SimpleDateFormat("dd/mm/yyyy");



        printView.printInput("What is the name of your task?");
        taskName = reader.nextLine();

        printView.printMessage("Enter the due date for the task?");
        //taskDate = reader.nextLine();

        while(correctDateFormat){
            printView.printInput("Correct date input format is dd/mm/yyyy");

            try {
                taskDate = dateParser.parse(reader.nextLine());
                correctDateFormat = false;
            } catch (ParseException e) {
                printView.printMessage("Date format is not correct.");
            }
        }
        printView.printInput("To which project does it belong?");
        project = reader.nextLine();

        printView.printMessage("Add a note to your task:");
        taskNote = reader.nextLine();

        TaskDTO taskDTO = new TaskDTO(taskName, taskDate, project, taskNote);

        System.out.println();

        controller.makeNewTask(taskDTO);
        printView.printMessage("New task is created successfully.");
        printView.printMessage("---------------------------------");

    }
}