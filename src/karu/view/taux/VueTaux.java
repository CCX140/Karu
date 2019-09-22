package karu.view.taux;

import karu.model.LesRunes;
import karu.model.Rune;
import karu.view.toprunes.VueRunes;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;


public class VueTaux extends JPanel {

    private JLabel label;
    private JTable table;
    private LesRunes lesRunes;
    private VueRunes vueRunes;

    public VueTaux(LesRunes lesRunes,VueRunes vr){
        super();
        this.lesRunes = lesRunes;
        vueRunes = vr;

        //Titled borders
        TitledBorder title;
        title = BorderFactory.createTitledBorder("Taux des Runes");
        this.setBorder(title);

        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));


        for(Rune r : lesRunes.getRunes()){
            LigneRune ligneRune = new LigneRune(r,vueRunes);
            ligneRune.setAlignmentX(Component.LEFT_ALIGNMENT);
            this.add(ligneRune);
        }

    }
}
