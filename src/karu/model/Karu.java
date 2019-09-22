package karu.model;

import java.io.FileNotFoundException;

public class Karu  {

    private LesRunes runes;
    private LesEquipements equipements;

    public Karu() throws FileNotFoundException {
        runes = new LesRunes();
        equipements = new LesEquipements();
    }

    public LesRunes getRunes() {
        return runes;
    }

    public LesEquipements getEquipements() {
        return equipements;
    }

    @Override
    public String toString() {
        return "Karu{" +
                "runes=" + runes +
                '}';
    }
}
