package karu.view.recherche;

import karu.model.Equipement;
import karu.model.LesEquipements;
import karu.model.LesRunes;

import javax.swing.*;
import java.awt.*;

public class VueResultat extends JPanel {

    private LesEquipements lesEquipements;

    public VueResultat(LesEquipements lesEquipements){
        super();
        this.lesEquipements = lesEquipements;
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        update();
    }

    public void update(){

        this.removeAll();

        for(Equipement e: lesEquipements.getListEquipements()){
            this.add(new LigneResultat(e));
        }

        this.updateUI();
    }

    public void updateRecherche(String s){
        this.removeAll();

        for(Equipement e: lesEquipements.getListEquipements()){
            if(e.getNom().contains(s)){
                this.add(new LigneResultat(e));
            }
        }

        this.updateUI();
    }

}
