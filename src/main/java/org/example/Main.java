package org.example;

import Commands.Save;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import model.*;
import utility.CommandManager;
import utility.ScannerManager;

import java.io.*;
import java.util.*;

/**
 * Основной класс приложения, управляющий загрузкой данных и выполнением команд.
 */
public class Main {
    /**
     * Набор всех лабораторных работ, упорядоченных по их уникальным идентификаторам.
     */
    public static TreeSet<LabWork> treeSet = new TreeSet<>();
    /**
     * История введенных команд.
     */
    public static Deque<String> history = new ArrayDeque<>();
    /**
     * Менеджер для обработки ввода от пользователя.
     */
    public static ScannerManager scannerManager = new ScannerManager();
    /**
     * Флаг, указывающий на то, продолжается ли выполнение программы.
     */
    public static boolean isRunning = true;
    /**
     * Менеджер команд, отвечающий за исполнение доступных команд.
     */
    public static CommandManager commandManager;
    private static Save saver;
    /**
     * Точка входа в программу. Инициализирует обработку входных данных и управляет основным циклом выполнения команд.
     *
     * @param args Аргументы командной строки, первый из которых ожидается как путь к файлу данных.
     * @throws IOException Если происходит ошибка ввода/вывода при работе с файлами.
     */
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
        saver = new Save(treeSet, path);
        while (isRunning) {
            System.out.print("$ ");
            try {
                if (!scannerManager.hasNextLine()) {
                    saveAndExit(); // Здесь вызываем сохранение и выход при EOF (Ctrl+D)
                }
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
    /**
     * Выполняет сохранение и выход из программы, при вызове исключения.
     */
    public static void saveAndExit() {
        try {
            saver.save();
            System.out.println("Data saved successfully. Exiting program...");
        } catch (IOException e) {
            System.err.println("Failed to save data: " + e.getMessage());
        }
        System.exit(0);
    }
    /**
     * Выполняет команду, указанную пользователем.
     *
     * @param string Строка, содержащая команду и её аргументы.
     */
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