package karu.model;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class LesEquipements {

    private ArrayList<Equipement> listEquipements;

    public LesEquipements(){
        listEquipements = new ArrayList<>();
    }

    public void create(){
        try
        {
            InputStream flux = getClass().getResourceAsStream("/karu/model/ressources/data.txt");
            InputStreamReader lecture = new InputStreamReader(flux);
            BufferedReader buff = new BufferedReader(lecture);

            Equipement e = new Equipement();
            int id = 0;
            String line;

            while((line=buff.readLine())!=null){
                //déplace le curseur a la ligne de nom
                while((line=buff.readLine()) == ""){

                }
                addNom(e,line);


                listEquipements.add(e);
                id++;
            }

        }
        catch (Exception e)
        {
            System.out.println(e.toString());
        }
    }

    public void addNom(Equipement e,String s){
        e.setNom(s);
    }

    public void addNiveau(Equipement e,String s){

    }

    public void addStat(Equipement e, String s){

    }
}
