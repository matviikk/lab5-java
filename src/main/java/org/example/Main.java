package org.example;

import Commands.*;
import model.*;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.chrono.ChronoLocalDate;
import java.util.*;

public class Main {
    public static TreeSet<LabWork> treeSet = new TreeSet<>();
    public static Scanner scanner = new Scanner(System.in);
    public static Map<String, Command> map = new HashMap<String, Command>(){{
        put("help", new Help());
        put("info", new Info(treeSet));
        put("show", new Show(treeSet));
        put("add", new Add(scanner, treeSet));
    }};
    public static void main(String[] args) {
        while (true){
            String string = scanner.next();
            map.get(string).execute();
        }
    }

    public static LabWork parseLabWork(Scanner scanner){
        System.out.print("Введите имя: ");
        String name = scanner.next();
        System.out.print("Введите координаты: ");
        Coordinates coordinates = parseCoordinates(scanner);
        LocalDate localeDate = LocalDate.now();
        System.out.print("Введите минимальную оценку: ");
        Double minimalPoint = scanner.nextDouble();
        System.out.print("Введите среднюю оценку: ");
        int averagePoint = scanner.nextInt();
        System.out.print("Введите сложность: ");
        for (Difficulty difficulty: Difficulty.values()){
            System.out.println(difficulty);
        }
        Difficulty difficulty = Difficulty.valueOf(scanner.next());
        System.out.print("Введите автора: ");
        Person person = parsePerson(scanner);
        return new LabWork(name, coordinates, localeDate, minimalPoint, averagePoint, difficulty, person);
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
    public static void update(Integer id, LabWork labWork){
        LabWork temp = null;
        for (LabWork lb: treeSet){
            if (Objects.equals(lb.getId(), id)){
                temp = lb;
            }
        }
        treeSet.remove(temp);
        labWork.setId(id);
        treeSet.add(labWork);
    }
    public static void removeById(Integer id){
        LabWork temp = null;
        for (LabWork lb: treeSet){
            if (Objects.equals(lb.getId(), id)){
                temp = lb;
            }
        }
        treeSet.remove(temp);
    }
    public static void clear(){
        treeSet = new TreeSet<>();
    }
    public static void removeGreater(LabWork labWork){
        List<LabWork> temp = new ArrayList<>();
        for (LabWork lb: treeSet){
            if (labWork.compareTo(lb) > 0){
                temp.add(lb);
            }
        }
        for (LabWork lb: temp){
            treeSet.remove(lb);
        }
    }
    public static void removeLower(LabWork labWork){
        List<LabWork> temp = new ArrayList<>();
        for (LabWork lb: treeSet){
            if (labWork.compareTo(lb) < 0){
                temp.add(lb);
            }
        }
        for (LabWork lb: temp){
            treeSet.remove(lb);
        }
    }
    public static void removeAnyByDifficulty(Difficulty difficulty){
        LabWork temp = null;
        for (LabWork lb: treeSet){
            if (lb.getDifficulty().equals(difficulty)){
                temp = lb;
            }
        }
        if (temp != null){
            treeSet.remove(temp);
        }
    }
    public static void save() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\Matve\\OneDrive\\Рабочий стол\\sss.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
    }
}