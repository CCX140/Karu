package karu.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

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

    public void sortByTaux(){

    }

    public int getIndexIemeMeilleureRune(int ind) {
       return 0;
    }

    public void setPrixWithIndex(int index,int value ){

    }

    public int getTauxWithIndex(int index){
       return 0;
    }

    public String getRuneWithIndex(int index){
       return "";
    }

    @Override
    public String toString() {
        return "LesRunes{" +
                "runes=" + runes +
                '}';
    }
}
