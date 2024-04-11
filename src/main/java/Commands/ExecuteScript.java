package Commands;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.Main;
import utility.Parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import utility.ScannerManager;

public class ExecuteScript implements Command {

    ScannerManager scannerManager;
    public ExecuteScript(ScannerManager scannerManager) {
        this.scannerManager = scannerManager;
    }

    @Override
    public void execute(String... args) throws JsonProcessingException, FileNotFoundException {
        String filepath = args[0];
        scannerManager.setFileScanner(new Scanner(new File(filepath)));
        scannerManager.setReadingFile(true);
        while (scannerManager.hasNext()) {
            String s = scannerManager.nextLine();
            if (!s.split(" ")[0].equals("execute_script")) Main.executeCommand(s);
        }
        scannerManager.setReadingFile(false);
    }
}
