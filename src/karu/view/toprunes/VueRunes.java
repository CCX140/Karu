package karu.view.toprunes;

import karu.model.LesRunes;
import karu.model.Rune;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

import static karu.util.Constants.*;


public class VueRunes extends JPanel {

    private LesRunes lesRunes;

    public VueRunes(LesRunes lesRunes){
        super();
        this.lesRunes = lesRunes;

        //Titled borders
        TitledBorder title;
        title = BorderFactory.createTitledBorder("Top Runes");
        title.setTitleColor(new Color(WHITE_GRAY,WHITE_GRAY,WHITE_GRAY));
        this.setBorder(title);

        this.setLayout(new GridLayout(47,1));
        this.setBackground(new Color(R_GRAY,G_GRAY,B_GRAY));

    }



    public void update() {
        this.removeAll();

        lesRunes.TrierParTaux();

        for(Rune rune: lesRunes.getRunes()){
            if(rune.getTaux() != -1){
                this.add(new LigneTopRune(rune));
            }
        }
        this.updateUI();
    }
}
