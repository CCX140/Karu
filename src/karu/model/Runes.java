package karu.model;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Runes {

    private HashMap<String,Integer> listRunes;
    private ArrayList<Integer> prix;
    private ArrayList<Integer> taux;
    private ArrayList<String> spriteRunes;

    public Runes() throws FileNotFoundException {
        listRunes = new HashMap<>();
        spriteRunes = new ArrayList<>();
        taux = new ArrayList<>();
        prix = new ArrayList<>();

        try
        {
            InputStream flux = getClass().getResourceAsStream("/karu/model/ressources/runes.txt");
            InputStreamReader lecture = new InputStreamReader(flux);
            BufferedReader buff = new BufferedReader(lecture);
            String nomRune;
            String poidsRune;

            while((nomRune=buff.readLine())!=null){

                if((poidsRune = buff.readLine())!=null){
                    listRunes.put(nomRune,Integer.parseInt(poidsRune));
                    taux.add(0);
                    prix.add(0);
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

    public void calculTaux(){
        ArrayList<Integer> keys = new ArrayList(listRunes.values());
        for(int i = 0;i<listRunes.size();i++){
            if(prix.get(i) != null){
               taux.set(i, prix.get(i) / keys.get(i));
            }
        }
    }

    public void setPrixWithIndex(int index,int value ){
        prix.set(index,value);
    }

    public int getTauxWithIndex(int index){
        return taux.get(index);
    }

    @Override
    public String toString() {
        return "Runes{" +
                "listRunes=" + listRunes +
                ", spriteRunes=" + spriteRunes +
                '}';
    }
}
