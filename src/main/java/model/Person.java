package model;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Person implements Serializable {
    @NotNull
    @NotEmpty
    private String name; //Поле не может быть null, Строка не может быть пустой
    @NotNull
    private java.time.LocalDateTime birthday; //Поле не может быть null
    @NotNull
    @DecimalMin(inclusive = false, value = "0")
    private Integer height; //Поле может быть null, Значение поля должно быть больше 0
    @NotNull
    private Location location; //Поле не может быть null

    public Person(String name, LocalDateTime birthday, Integer height, Location location) {
        this.name = name;
        this.birthday = birthday;
        this.height = height;
        this.location = location;
    }

    public Person() {
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
}
