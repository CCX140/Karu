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

        for(Equipement e: lesEquipements.getListEquipements()){
            this.add(new LigneResultat(e));
        }

    }

}
