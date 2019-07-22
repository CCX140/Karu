package karu.model;

import java.io.FileNotFoundException;

public class Karu {

    private LesRunes runes;

    public Karu() throws FileNotFoundException {
        runes = new LesRunes();
    }

    public LesRunes getRunes() {
        return runes;
    }

    @Override
    public String toString() {
        return "Karu{" +
                "runes=" + runes +
                '}';
    }
}
