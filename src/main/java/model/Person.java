package model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.time.LocalDateTime;

public class Person implements Serializable, Validatable {

    private String name; //Поле не может быть null, Строка не может быть пустой

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private java.time.LocalDateTime birthday; //Поле не может быть null

    private Integer height; //Поле может быть null, Значение поля должно быть больше 0

    private Location location; //Поле не может быть null

    public Person() {
        this.name = "empty";
        this.birthday = LocalDateTime.now();
        this.height = 1;
        this.location = new Location(0.0, 0L, 0, "empty");
    }

    public Person(String name, LocalDateTime birthday, Integer height, Location location) {
        this.name = name;
        this.birthday = birthday;
        this.height = height;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public boolean validate() {
        if (name == null || name.isEmpty()){
            System.out.println("\u001B[31mError: имя не должно быть null и не должно быть пустым \u001B[0m");
            return false;
        }
        if (birthday == null){
            //System.out.println("\u001B[31mError: День роджения не должно быть null \u001B[0m");
            return false;
        }
        if (height == null || height <= 0){
            System.out.println("\u001B[31mError: Рост не должен быть null и должен быть больше 0 \u001B[0m");
            return false;
        }
        if (location == null){
            System.out.println("\u001B[31mError: Место рождения не должно быть null \u001B[0m");
            return false;
        }
        return true;
    }
}
