package model;

import java.io.Serializable;

public class Coordinates implements Serializable, Validatable {

    private Double x; //Поле не может быть null

    private Double y; //Значение поля должно быть больше -500, Поле не может быть null

    public Coordinates() {
        this.x = 0.0;
        this.y = 0.0;
    }
    public Coordinates(Double x, Double y) {
        this.x = x;
        this.y = y;
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    @Override
    public boolean validate() {
        if (x == null){
            System.out.println("\u001B[31mError: X не должен быть null \u001B[0m");
            return false;
        }
        if (y == null || y <= -500){
            System.out.println("\u001B[31mError: Y не должен быть null и должен быть больше -500 \u001B[0m");
            return false;
        }
        return true;
    }
}