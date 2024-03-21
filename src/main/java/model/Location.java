package model;

import java.io.Serializable;

public class Location implements Serializable {
    private Double x; //Поле не может быть null
    private Long y; //Поле не может быть null
    private double z;
    private String name; //Поле не может быть null

    public Location(Double x, Long y, double z, String name) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.name = name;
    }
}
