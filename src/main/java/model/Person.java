package model;

public class Person {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private java.time.LocalDateTime birthday; //Поле не может быть null
    private Integer height; //Поле может быть null, Значение поля должно быть больше 0
    private Location location; //Поле не может быть null
}
