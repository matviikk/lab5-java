package model;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

public class Coordinates implements Serializable {
    @NotNull
    private Double x; //Поле не может быть null
    @NotNull
    @DecimalMin(inclusive = false, value = "-500.0")
    private Double y; //Значение поля должно быть больше -500, Поле не может быть null

    public Coordinates(Double x, Double y) {
        this.x = x;
        this.y = y;
    }

    public Coordinates() {
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
}