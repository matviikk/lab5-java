package model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Person implements Serializable {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private java.time.LocalDateTime birthday; //Поле не может быть null
    private Integer height; //Поле может быть null, Значение поля должно быть больше 0
    private Location location; //Поле не может быть null

    public Person(String name, LocalDateTime birthday, Integer height, Location location) {
        this.name = name;
        this.birthday = birthday;
        this.height = height;
        this.location = location;
    }
}
