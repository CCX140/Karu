package karu.model;

import java.io.FileNotFoundException;

public class Karu {

    private Runes runes;

    public Karu() throws FileNotFoundException {
        runes = new Runes();
    }

    public Runes getRunes() {
        return runes;
    }

    @Override
    public String toString() {
        return "Karu{" +
                "runes=" + runes +
                '}';
    }
}
