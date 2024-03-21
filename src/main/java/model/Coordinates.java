package model;

import java.io.Serializable;

public class Coordinates implements Serializable {
    private Double x; //Поле не может быть null
    private Double y; //Значение поля должно быть больше -500, Поле не может быть null

    public Coordinates(Double x, Double y) {
        this.x = x;
        this.y = y;
    }
}