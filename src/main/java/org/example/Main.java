package org.example;

import Commands.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import model.*;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.chrono.ChronoLocalDate;
import java.util.*;

public class Main {
    public static TreeSet<LabWork> treeSet = new TreeSet<>();
    public static Deque<String> history = new ArrayDeque<>();
    public static Scanner scanner = new Scanner(System.in);
    public static String path;
    public static Map<String, Command> map = new HashMap<String, Command>();
    public static boolean isRunning = true;
    public static ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    public static void init() {
        map.put("help", new Help());
        map.put("info", new Info(treeSet));
        map.put("show", new Show(treeSet));
        map.put("add", new Add(scanner, treeSet));
        map.put("update", new Update(scanner, treeSet));
        map.put("remove_by_id", new RemoveById(scanner, treeSet));
        map.put("clear", new Clear(treeSet));
        map.put("save", new Save(treeSet, path));
        map.put("exit", new Exit());
        map.put("remove_greater", new RemoveGreater(scanner, treeSet));
        map.put("remove_lower", new RemoveLower(scanner, treeSet));
        map.put("history", new History());
        map.put("remove_any_by_difficulty", new RemoveAnyByDifficulty(scanner, treeSet));
        map.put("average_of_average_point", new AverageOfAveragePoint(treeSet));
        map.put("print_descending", new PrintDescending(treeSet));
        map.put("execute_script", new ExecuteScript(scanner));
    }
    public static void main(String[] args) throws IOException {
        path = args[0];
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
            String string = scanner.next();
            history.addFirst(string);
            if (history.size() > 9) {
                history.removeLast();
            }
            executeCommand(string);
        }
    }

    public static LabWork parseLabWork(Scanner scanner){
//        return new LabWork();
        System.out.print("Введите имя: ");
        String name = scanner.next();
        System.out.print("Введите координаты: ");
        Coordinates coordinates = parseCoordinates(scanner);
        LocalDate localeDate = LocalDate.now();
        System.out.print("Введите минимальную оценку: ");
        Double minimalPoint = scanner.nextDouble();
        System.out.print("Введите среднюю оценку: ");
        int averagePoint = scanner.nextInt();
        Difficulty difficulty = parseDifficulty(scanner);
        System.out.print("Введите автора: ");
        Person person = parsePerson(scanner);
        LabWork newLabwork = new LabWork(name, coordinates, localeDate, minimalPoint, averagePoint, difficulty, person);
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<LabWork>> violations = validator.validate(newLabwork);
        if (!violations.isEmpty()) {
            for (ConstraintViolation<LabWork> violation: violations) {
                System.out.println(violation.getMessage());
            }
            return parseLabWork(scanner);
        }
        return newLabwork;
    }
    public static Person parsePerson(Scanner scanner){
        System.out.print("Введите имя: ");
        String name = scanner.next();
        System.out.print("Введите дату рождения: ");
        int year = scanner.nextInt();
        int month = scanner.nextInt();
        int day = scanner.nextInt();
        LocalDateTime localDateTime = LocalDateTime.of(LocalDate.of(year, month, day), LocalTime.MIN);
        System.out.print("Введите рост: ");
        int height = scanner.nextInt();
        Location location = parseLocation(scanner);
        return new Person(name, localDateTime, height, location);
    }
    public static Location parseLocation(Scanner scanner){
        System.out.print("Введите место рождения: ");
        System.out.print("Введите X: ");
        Double x = scanner.nextDouble();
        System.out.print("Введите Y: ");
        long y = scanner.nextLong();
        System.out.print("Введите Z: ");
        double z = scanner.nextDouble();
        System.out.print("Название место рождения: ");
        String name = scanner.next();
        return new Location(x, y, z, name);
    }
    public static Coordinates parseCoordinates(Scanner scanner){
        System.out.print("Введите X: ");
        Double x = scanner.nextDouble();
        System.out.print("Введите Y: ");
        Double y = scanner.nextDouble();
        Coordinates coordinates = new Coordinates(x, y);
        return coordinates;
    }
    public static Difficulty parseDifficulty(Scanner scanner) {
        System.out.print("Введите сложность: ");
        for (Difficulty difficulty: Difficulty.values()){
            System.out.println(difficulty);
        }
        Difficulty difficulty = Difficulty.valueOf(scanner.next());
        return difficulty;
    }
    public static void executeCommand(String commandName) {
        if (!map.containsKey(commandName)) {
            System.out.println("Такой команды не существует");
            return;
        }
        try {
            map.get(commandName).execute();
        } catch (Exception e) {
            System.out.println("Произошла ошибка при выполнении команды");
        }
    }
}