package model;

import java.io.Serializable;

public class Location implements Serializable, Validatable {

    private Double x; //Поле не может быть null

    private Long y; //Поле не может быть null
    private double z;

    private String name; //Поле не может быть null

    public Location() {
        this.x = 0.0;
        this.y = 0L;
        this.z = 0.0;
        this.name = "empty";
    }

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

    @Override
    public boolean validate() {
        if (x == null){
            System.out.println("\u001B[31mError: Координата X не должна быть null \u001B[0m");
            return false;
        }
        if (y == null){
            System.out.println("\u001B[31mError: Координата Y не должна быть null \u001B[0m");
            return false;
        }
        if (name == null){
            System.out.println("\u001B[31mError: Название места рождения не должно быть null \u001B[0m");
            return false;
        }
        return true;
    }
}
