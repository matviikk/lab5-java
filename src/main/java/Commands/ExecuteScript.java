package Commands;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ExecuteScript implements Command {

    Scanner scanner;
    public ExecuteScript(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void execute(String... args) throws JsonProcessingException, FileNotFoundException {
        String filepath = args[0];
        Scanner fileScanner = new Scanner(new File(filepath));
        while (fileScanner.hasNext()) {
            Main.executeCommand(fileScanner.next());
        }
    }
}
