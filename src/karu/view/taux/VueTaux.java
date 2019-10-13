package karu.view.taux;

import karu.model.LesRunes;
import karu.model.Rune;
import karu.view.toprunes.VueRunes;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

import static karu.util.Constants.*;


public class VueTaux extends JPanel {

    private LesRunes lesRunes;
    private VueRunes vueRunes;

    public VueTaux(LesRunes lr,VueRunes vr){
        super();
        this.lesRunes = lr;
        vueRunes = vr;

        //Titled borders
        TitledBorder title;
        title = BorderFactory.createTitledBorder("Taux des Runes");
        title.setTitleColor(new Color(WHITE_GRAY,WHITE_GRAY,WHITE_GRAY));
        this.setBackground(new Color(R_DARK_GRAY,G_DARK_GRAY,B_DARK_GRAY));
        this.setBorder(title);

        this.setLayout(new GridLayout(47,1));

        this.setBackground(new Color(R_GRAY,G_GRAY,B_GRAY));


        for(Rune r : lesRunes.getRunes()){
            LigneRune ligneRune = new LigneRune(r,vueRunes);
            ligneRune.setAlignmentX(Component.LEFT_ALIGNMENT);
            this.add(ligneRune);
        }

    }
}
