package karu.model;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Runes {

    private HashMap<String,Integer> listRunes;
    private ArrayList<String> spriteRunes;

    public Runes() throws FileNotFoundException {
        listRunes = new HashMap<>();
        spriteRunes = new ArrayList<>();

        try
        {
            InputStream flux = new FileInputStream("ressources/runes.txt");
            InputStreamReader lecture = new InputStreamReader(flux);
            BufferedReader buff = new BufferedReader(lecture);
            String nomRune;
            String poidsRune;

            while((nomRune=buff.readLine())!=null){

                if((poidsRune = buff.readLine())!=null){
                    listRunes.put(nomRune,Integer.parseInt(poidsRune));
                }
            }

        }
        catch (Exception e)
        {
            System.out.println(e.toString());
        }
    }

    public HashMap<String, Integer> getListRunes() {
        return listRunes;
    }

    public ArrayList<String> getSpriteRunes() {
        return spriteRunes;
    }

    @Override
    public String toString() {
        return "Runes{" +
                "listRunes=" + listRunes +
                ", spriteRunes=" + spriteRunes +
                '}';
    }
}
