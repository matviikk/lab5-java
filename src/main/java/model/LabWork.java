package model;

import jakarta.validation.constraints.*;

import java.io.Serializable;
import java.time.LocalDate;

public class LabWork implements Comparable<LabWork>, Serializable {
    private static Integer generatedId = 1;

    @Override
    public String toString() {
        return "LabWork{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", minimalPoint=" + minimalPoint +
                ", averagePoint=" + averagePoint +
                ", difficulty=" + difficulty +
                ", author=" + author +
                '}';
    }

    public LabWork() {
        this.id = generatedId++;
    }

    public LabWork(String name, Coordinates coordinates, LocalDate creationDate, Double minimalPoint, int averagePoint, Difficulty difficulty, Person author) {
        this.id = generatedId++;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.minimalPoint = minimalPoint;
        this.averagePoint = averagePoint;
        this.difficulty = difficulty;
        this.author = author;
    }

    @NotNull
    @DecimalMin(inclusive = false, value = "0")
    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    @NotNull
    @NotEmpty
    private String name; //Поле не может быть null, Строка не может быть пустой
    @NotNull
    private Coordinates coordinates; //Поле не может быть null
    @NotNull
    private java.time.LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    @NotNull
    @DecimalMin(inclusive = false, value = "0.0")
    private Double minimalPoint; //Поле может быть null, Значение поля должно быть больше 0
    @DecimalMin(inclusive = false, value = "0", message = "Значение средней оценки должно быть больше 0")
    private int averagePoint; //Значение поля должно быть больше 0
    @NotNull
    private Difficulty difficulty; //Поле может быть null
    @NotNull
    private Person author; //Поле может быть null

    public static Integer getGeneratedId() {
        return generatedId;
    }

    public static void setGeneratedId(Integer generatedId) {
        LabWork.generatedId = generatedId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public Double getMinimalPoint() {
        return minimalPoint;
    }

    public void setMinimalPoint(Double minimalPoint) {
        this.minimalPoint = minimalPoint;
    }

    public int getAveragePoint() {
        return averagePoint;
    }

    public void setAveragePoint(int averagePoint) {
        this.averagePoint = averagePoint;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public Person getAuthor() {
        return author;
    }

    public void setAuthor(Person author) {
        this.author = author;
    }

    @Override
    public int compareTo(LabWork o) {
        return Integer.compare(this.id, o.id);
    }
}