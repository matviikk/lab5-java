package org.example;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import model.*;
import utility.CommandManager;
import utility.ScannerManager;

import java.io.*;
import java.util.*;

public class Main {
    public static TreeSet<LabWork> treeSet = new TreeSet<>();
    public static Deque<String> history = new ArrayDeque<>();
    public static ScannerManager scannerManager = new ScannerManager();
    public static boolean isRunning = true;
    public static CommandManager commandManager;

    public static void main(String[] args) throws IOException {
        String path = args[0];
        System.out.println("Введите \"help\" для справки по командам.");
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.registerModule(new JavaTimeModule());
        Scanner fileScanner = new Scanner(new File(path));
        int maxId = -1;
        while (fileScanner.hasNext()) {
            LabWork lb = xmlMapper.readValue(fileScanner.nextLine(), LabWork.class);
            treeSet.add(lb);
            maxId = Math.max(maxId, lb.getId());
        }
        LabWork.setGeneratedId(maxId + 1);
        commandManager = new CommandManager(treeSet, scannerManager, path);
        while (isRunning) {
            try {
                String string = scannerManager.nextLine();
                history.addFirst(string);
                if (history.size() > 9) {
                    history.removeLast();
                }
                executeCommand(string);
            } catch (Exception e) {
                System.out.println("\u001B[31mError: Ошибка ввода. \u001B[0m");
                System.out.println("\u001B[31mError: Экстренное завершение программы... \u001B[0m");
                return;
            }
        }
    }


    public static void executeCommand(String string) {
        String[] commandArray = string.split(" ");
        String commandName = commandArray[0];
        String[] args = new String[commandArray.length - 1];
        System.arraycopy(commandArray, 1, args, 0, args.length);
        if (!commandManager.getCommands().containsKey(commandName)) {
            System.out.println("Такой команды не существует.");
            return;
        }
        try {
            commandManager.getCommands().get(commandName).execute(args);
        } catch (NoSuchElementException e) {
            System.out.println("Нет входных данных для команды :(");
        } catch (Exception e) {
            System.out.println("Произошла ошибка при выполнении команды...");
        }
    }
}