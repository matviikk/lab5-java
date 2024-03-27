package model;

import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

public class Location implements Serializable {
    @NotNull
    private Double x; //Поле не может быть null
    @NotNull
    private Long y; //Поле не может быть null
    private double z;
    @NotNull
    private String name; //Поле не может быть null

    public Location(Double x, Long y, double z, String name) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.name = name;
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Long getY() {
        return y;
    }

    public void setY(Long y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
