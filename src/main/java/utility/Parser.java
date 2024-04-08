package utility;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import model.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;
import java.util.Set;

public class Parser {
    Scanner scanner;

    public Parser(Scanner scanner) {
        this.scanner = scanner;
    }

    public LabWork parseLabWork(){
        LabWork newLabwork = new LabWork();
        newLabwork.setName(scanLabWorkName());
        newLabwork.setCoordinates(parseCoordinates());
        newLabwork.setMinimalPoint(scanMinimalPoint());
        newLabwork.setAveragePoint(scanAveragePoint());
        Difficulty difficulty = parseDifficulty();
        newLabwork.setDifficulty(difficulty);
        newLabwork.setAuthor(parsePerson());
        return newLabwork;
    }
    public String scanLabWorkName(){
        while (true){
            System.out.print("Введите название лабораторной работы: ");
            String s = scanner.nextLine();
            if (s.isEmpty()){
                System.out.println("\u001B[31mError: Название не должно быть null \u001B[0m");
                continue;
            }
            try {
                String name = s.trim();
                return name;
            } catch (Exception e) {
                System.out.println("\u001B[31mError: Неверный формат данных \u001B[0m");
            }
        }
    }
    public Double scanMinimalPoint(){
        while (true){
            System.out.print("Введите минимальную оценку: ");
            String s = scanner.nextLine();
            if (s.isEmpty()){
                System.out.println("\u001B[31mError: Минимальная оценка не должна быть null \u001B[0m");
                continue;
            }
            try {
                Double minimalPoint = Double.parseDouble(s);
                if (minimalPoint <= 0){
                    System.out.println("\u001B[31mError: Минимальная оценка должна быть больше 0 \u001B[0m");
                    continue;
                }
                return minimalPoint;
            } catch (Exception e) {
                System.out.println("\u001B[31mError: Неверный формат данных \u001B[0m");
            }
        }
    }
    public int scanAveragePoint(){
        while (true){
            System.out.print("Введите среднюю оценку: ");
            String s = scanner.nextLine();
            try {
                int averagePoint = Integer.parseInt(s);
                if (averagePoint <= 0){
                    System.out.println("\u001B[31mError: Среденяя оценка должна быть больше 0 \u001B[0m");
                    continue;
                }
                return averagePoint;
            } catch (Exception e) {
                System.out.println("\u001B[31mError: Неверный формат данных \u001B[0m");
            }
        }
    }
    public Person parsePerson(){
        Person newPerson = new Person();
        newPerson.setName(scanPersonName());
        newPerson.setBirthday(scanPersonBirthday());
        newPerson.setHeight(scanHeight());
        Location location = parseLocation();
        newPerson.setLocation(location);
        return newPerson;
    }
    public String scanPersonName(){
        while (true){
            System.out.print("Введите имя автора: ");
            String s = scanner.nextLine();
            if (s.isEmpty()){
                System.out.println("\u001B[31mError: Имя не должно быть null \u001B[0m");
                continue;
            }
            try {
                String name = s.trim();
                return name;
            } catch (Exception e) {
                System.out.println("\u001B[31mError: Неверный формат данных \u001B[0m");
            }
        }
    }
    public LocalDateTime scanPersonBirthday(){
        while (true){
            System.out.print("Введите дату рождения: ");
            String s = scanner.nextLine();
            if (s.isEmpty()){
                System.out.println("\u001B[31mError: Дата рождения не должна быть null \u001B[0m");
                continue;
            }
            try {
                LocalDateTime birthday = LocalDateTime.of(LocalDate.of(Integer.parseInt(s.split(" ")[0]),Integer.parseInt(s.split(" ")[1]), Integer.parseInt(s.split(" ")[2])), LocalTime.MIN);
                return birthday;
            } catch (Exception e) {
                System.out.println("\u001B[31mError: Неверный формат данных \u001B[0m");
            }
        }
    }
    public Integer scanHeight(){
        while (true){
            System.out.print("Введите рост: ");
            String s = scanner.nextLine();
            if (s.isEmpty()){
                return null;
            }
            try {
                int height = Integer.parseInt(s);
                if (height <= 0){
                    System.out.println("\u001B[31mError: Рост должен быть больше 0 \u001B[0m");
                    continue;
                }
                return height;
            } catch (Exception e) {
                System.out.println("\u001B[31mError: Неверный формат данных \u001B[0m");
            }
        }
    }
    public Location parseLocation(){
        Location newLocation = new Location();
        System.out.print("Введите место рождения: ");
        newLocation.setX(scanLocationX());
        newLocation.setY(scanLocationY());
        newLocation.setZ(scanLocationZ());
        newLocation.setName(scanLocationName());
        return newLocation;
    }
    public Double scanLocationX(){
        while (true){
            System.out.print("Введите X: ");
            String s = scanner.nextLine();
            if (s.isEmpty()){
                System.out.println("\u001B[31mError: Координата X не должна быть null \u001B[0m");
                continue;
            }
            try {
                Double x = Double.parseDouble(s);
                return x;
            } catch (Exception e) {
                System.out.println("\u001B[31mError: Неверный формат данных \u001B[0m");
            }
        }
    }
    public Long scanLocationY(){
        while (true){
            System.out.print("Введите Y: ");
            String s = scanner.nextLine();
            if (s.isEmpty()){
                System.out.println("\u001B[31mError: Координата Y не должна быть null \u001B[0m");
                continue;
            }
            try {
                long y = Long.parseLong(s);
                return y;
            } catch (Exception e) {
                System.out.println("\u001B[31mError: Неверный формат данных \u001B[0m");
            }
        }
    }
    public Double scanLocationZ(){
        while (true){
            System.out.print("Введите Z: ");
            String s = scanner.nextLine();
            if (s.isEmpty()){
                System.out.println("\u001B[31mError: Координата Z не должна быть null \u001B[0m");
                continue;
            }
            try {
                double z = Double.parseDouble(s);
                return z;
            } catch (Exception e) {
                System.out.println("\u001B[31mError: Неверный формат данных \u001B[0m");
            }
        }
    }
    public String scanLocationName(){
        while (true){
            System.out.print("Введите название места рождения: ");
            String s = scanner.nextLine();
            if (s.isEmpty()){
                System.out.println("\u001B[31mError: Название не должно быть null \u001B[0m");
                continue;
            }
            try {
                String name = s.trim();
                return name;
            } catch (Exception e) {
                System.out.println("\u001B[31mError: Неверный формат данных \u001B[0m");
            }
        }
    }
    public Coordinates parseCoordinates(){
        Coordinates newCoordinates = new Coordinates();
        System.out.print("Введите координаты: ");
        newCoordinates.setX(scanCoordinatesX());
        newCoordinates.setY(scanCoordinatesY());
        return newCoordinates;
    }
    public Double scanCoordinatesX(){
        while (true){
            System.out.print("Введите X: ");
            String s = scanner.nextLine();
            if (s.isEmpty()){
                System.out.println("\u001B[31mError: Координата X не должна быть null \u001B[0m");
                continue;
            }
            try {
                Double x = Double.parseDouble(s);
                return x;
            } catch (Exception e) {
                System.out.println("\u001B[31mError: Неверный формат данных \u001B[0m");
            }
        }
    }
    public Double scanCoordinatesY(){
        while (true){
            System.out.print("Введите Y: ");
            String s = scanner.nextLine();
            if (s.isEmpty()){
                System.out.println("\u001B[31mError: Координата Y не должна быть null \u001B[0m");
                continue;
            }
            try {
                Double y = Double.parseDouble(s);
                if (y <= -500){
                    System.out.println("\u001B[31mError: Координата Y должна быть больше -500 \u001B[0m");
                    continue;
                }
                return y;
            } catch (Exception e) {
                System.out.println("\u001B[31mError: Неверный формат данных \u001B[0m");
            }
        }
    }
    public Difficulty parseDifficulty() {
        Difficulty difficulty;
        do {
            System.out.print("Введите сложность: ");
            for (Difficulty dif: Difficulty.values()){
                System.out.print(dif + " ");
            }
            System.out.println();
            difficulty = Difficulty.findByValue(scanner.nextLine().trim());
            if (difficulty == null){
                System.out.println("\u001B[31mError: Такой сложности нету \u001B[0m");
            }
        } while (difficulty == null);
        return difficulty;
    }
}
