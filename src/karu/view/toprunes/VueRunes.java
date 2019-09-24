package karu.view.toprunes;

import karu.model.LesRunes;
import karu.model.Rune;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;


public class VueRunes extends JPanel {

    private LesRunes lesRunes;

    public VueRunes(LesRunes lesRunes){
        super();
        this.lesRunes = lesRunes;

        //Titled borders
        TitledBorder title;
        title = BorderFactory.createTitledBorder("Top Runes");
        this.setBorder(title);

        this.setLayout(new GridLayout(47,1));

    }



    public void update() {
        this.removeAll();

        lesRunes.TrierParTaux();

        for(Rune rune: lesRunes.getRunes()){
            if(rune.getTaux() != -1){
                System.out.println(rune.getNom());
                this.add(new LigneTopRune(rune));
            }
        }

        this.updateUI();
    }
}
