package karu.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class LesRunes {

    private ArrayList<Rune> runes;

    public LesRunes() throws FileNotFoundException {
        runes = new ArrayList<>();
        try
        {
            InputStream flux = getClass().getResourceAsStream("/karu/model/ressources/runes.txt");
            InputStreamReader lecture = new InputStreamReader(flux);
            BufferedReader buff = new BufferedReader(lecture);
            String nomRune;
            String poidsRune;

            int id = 0;
            while((nomRune=buff.readLine())!=null){
                if((poidsRune = buff.readLine())!=null){
                    runes.add(new Rune(id,Integer.parseInt(poidsRune),nomRune));
                }
                id++;
            }

        }
        catch (Exception e)
        {
            System.out.println(e.toString());
        }
    }


    public void calculTaux(){
         for(Rune r : runes){
             if(r.getPrix() != -1) {
                 r.setTaux(r.getPrix() / r.getPoids());
             }
         }
    }

    
    public void TrierParTaux(){
        Collections.sort(runes, new Comparator<Rune>() {
            @Override
            public int compare(Rune o1, Rune o2) {
                return (int) (o1.getTaux() - o2.getTaux());
            }
        });
    }

    public ArrayList<Rune> getRunes() {
        return runes;
    }

    @Override
    public String toString() {
        return "LesRunes{" +
                "runes=" + runes +
                '}';
    }
}
