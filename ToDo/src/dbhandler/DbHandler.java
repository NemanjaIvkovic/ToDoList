package dbhandler;
import model.Task;
import model.TaskDTO;
import model.TaskList;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class DbHandler {
    private Path path;
    private SimpleDateFormat dateFormat;
    private Scanner scanner;

    public static final String FILE_NAME = "list";
    public static final String FILE_FORMAT = ".txt";

    public DbHandler(){
        path = Paths.get(FILE_NAME + FILE_FORMAT);
        dateFormat = new SimpleDateFormat("dd/mm/yyyy");


        File file = new File(".");                                                  //TODO Solve the problem of the missing txt file
        for(String fileNames : file.list()) System.out.println(fileNames);


        try{
            scanner = new Scanner(Files.newBufferedReader(path, Charset.defaultCharset()));
        }
        catch (IOException e){
            e.printStackTrace();
            System.out.println("File not found.");
            System.out.println(path);
        }
    }

    public ArrayList<TaskDTO> loadFromFile(){
        ArrayList<TaskDTO> tasks = new ArrayList<>();
        while (scanner.nextLine() != null) {
            String task = scanner.nextLine();
            String[] taskData = task.split("%%%");
            String taskName = taskData[0];

            Date taskDate = null;
            try {
                taskDate = dateFormat.parse(taskData[1]);
            } catch (ParseException e) {
                System.out.println("Invalid date format!");
            }

            String project = taskData[2];
            String taskNote = taskData[3];

            tasks.add(new TaskDTO(taskName, taskDate, project, taskNote));
        }
        return tasks;
    }

    public void writeToFile(ArrayList<Task> tasks, File fileName) throws IOException {

        Path filePath = Paths.get(FILE_NAME + FILE_FORMAT).toAbsolutePath();
        FileWriter writer = new FileWriter(filePath.toString());
        try(BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            for (Task task : tasks) {
                bufferedWriter.write(task.getNote() + "%%%" + dateFormat.format(task.getDate()) + "%%%" + task.getProject() +
                        "%%%" + task.getNote() + "\n");
            }
            bufferedWriter.close();
        }
        catch (IOException e){
            System.out.println("IOException");
        }
    }
}
