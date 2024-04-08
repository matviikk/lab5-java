package model;

import java.io.Serializable;

public enum Difficulty implements Serializable {
    HARD,
    IMPOSSIBLE,
    INSANE;

    public static Difficulty findByValue(String value) {
        for (Difficulty difficulty : values()) {
            if (difficulty.name().equals(value)) {
                return difficulty;
            }
        }
        return null;
    }
}
