package karu.view.recherche;

import karu.model.Equipement;
import karu.model.LesEquipements;
import karu.model.LesRunes;
import karu.util.Constants;

import javax.swing.*;
import java.awt.*;
import java.text.Normalizer;

import static karu.util.Constants.*;

public class VueResultat extends JPanel {

    private LesEquipements lesEquipements;

    public VueResultat(LesEquipements lesEquipements){
        super();
        this.lesEquipements = lesEquipements;
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.setBackground(new Color(R_LIGHT_GRAY,G_LIGHT_GRAY,B_LIGHT_GRAY));
        update();
    }

    public void update(){

        this.removeAll();

        for(Equipement e: lesEquipements.getListEquipements()){
            this.add(new LigneResultat(e));
        }

        this.updateUI();
    }

    public void updateRecherche(String s,String stat){
        this.removeAll();

        for(Equipement e: lesEquipements.getListEquipements()){
            if(stripAccents(e.getNom().toLowerCase()).contains(s.toLowerCase())){ //compare sans accent et tout en minuscule
                if(e.contains(stat)){
                    this.add(new LigneResultat(e));
                }
            }
        }

        this.updateUI();
    }


    public static String stripAccents(String s)
    {
        s = Normalizer.normalize(s, Normalizer.Form.NFD);
        s = s.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        return s;
    }
}
