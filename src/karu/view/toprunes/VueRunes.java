package karu.view.toprunes;

import karu.model.LesRunes;
import karu.view.taux.LigneRune;

import javax.swing.*;
import javax.swing.border.TitledBorder;


public class VueRunes extends JPanel{


    private JTable table;
    private LesRunes lesRunes;

    public VueRunes(LesRunes lesRunes){
        super();
        this.lesRunes = lesRunes;
        //Titled borders
        TitledBorder title;
        title = BorderFactory.createTitledBorder("Top Runes");
        this.setBorder(title);
        table = new JTable();
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        this.add(new JLabel("edfghj"));


    }

}
