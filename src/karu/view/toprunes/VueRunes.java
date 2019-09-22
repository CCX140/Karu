package karu.view.toprunes;

import karu.model.LesRunes;
import karu.view.taux.LigneRune;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.util.Observable;
import java.util.Observer;


public class VueRunes extends JPanel {

    private LesRunes lesRunes;

    public VueRunes(LesRunes lesRunes){
        super();
        this.lesRunes = lesRunes;

        //Titled borders
        TitledBorder title;
        title = BorderFactory.createTitledBorder("Top Runes");
        this.setBorder(title);

        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
    }



    public void update() {
        this.removeAll();

        lesRunes.TrierParTaux();

        System.out.println("update");
    }
}
