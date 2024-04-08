package org.example;

import Commands.*;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import model.*;

import java.io.*;
import java.util.*;

public class Main {
    public static TreeSet<LabWork> treeSet = new TreeSet<>();
    public static Deque<String> history = new ArrayDeque<>();
    public static Scanner scanner = new Scanner(System.in);
    public static String path;
    public static Map<String, Command> map = new HashMap<String, Command>();
    public static boolean isRunning = true;
    public static void init() {
        map.put("help", new Help());
        map.put("info", new Info(treeSet));
        map.put("show", new Show(treeSet));
        map.put("add", new Add(scanner, treeSet));
        map.put("update", new Update(scanner, treeSet));
        map.put("remove_by_id", new RemoveById(scanner, treeSet));
        map.put("clear", new Clear(treeSet)); // не работает
        map.put("save", new Save(treeSet, path));
        map.put("exit", new Exit());
        map.put("remove_greater", new RemoveGreater(scanner, treeSet)); // работает неправильно
        map.put("remove_lower", new RemoveLower(scanner, treeSet)); // работает неправильно
        map.put("history", new History());
        map.put("remove_any_by_difficulty", new RemoveAnyByDifficulty(scanner, treeSet));
        map.put("average_of_average_point", new AverageOfAveragePoint(treeSet));
        map.put("print_descending", new PrintDescending(treeSet));
        map.put("execute_script", new ExecuteScript(scanner)); // сделать
    }
    public static void main(String[] args) throws IOException {
        path = args[0];
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
        LabWork.setGeneratedId(maxId+1);
        init();
        while (isRunning){
            try {
                String string = scanner.nextLine();
                history.addFirst(string);
                if (history.size() > 9) {
                    history.removeLast();
                }
                executeCommand(string);
            } catch (Exception e){
                System.out.println("\u001B[31mError: Ошибка ввода. \u001B[0m");
                System.out.println("\u001B[31mError: Экстренное завершение программы... \u001B[0m");
                return;
            }
        }
    }


    public static void executeCommand(String string) {
        String[] commandArray = string.split(" ");
        String commandName = commandArray[0];
        String[] args = new String[commandArray.length-1];
        System.arraycopy(commandArray, 1, args, 0, args.length);
        if (!map.containsKey(commandName)) {
            System.out.println("Такой команды не существует.");
            return;
        }
        try {
            map.get(commandName).execute(args);
        } catch (Exception e) {
            System.out.println("Произошла ошибка при выполнении команды...");
        }
    }
}