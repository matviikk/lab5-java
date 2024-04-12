package Commands;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.Main;
import utility.Parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import utility.ScannerManager;
/**
 * Команда для выполнения набора команд из файла скрипта.
 */
public class ExecuteScript implements Command {

    ScannerManager scannerManager;
    /**
     * Конструктор класса ExecuteScript.
     * @param scannerManager Экземпляр ScannerManager для управления чтением данных.
     */
    public ExecuteScript(ScannerManager scannerManager) {
        this.scannerManager = scannerManager;
    }
    /**
     * Выполняет команды, перечисленные в файле скрипта.
     * @param args Массив аргументов, первым из которых должен быть путь к файлу скрипта.
     * @throws JsonProcessingException Если при выполнении команды произойдет ошибка обработки JSON.
     * @throws FileNotFoundException Если указанный файл скрипта не найден.
     */
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
