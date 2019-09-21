package karu.view.taux;

import karu.model.LesRunes;
import karu.model.Rune;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;


public class VueTaux extends JPanel implements Scrollable{

    private JLabel label;
    private JTable table;
    private LesRunes lesRunes;

    public VueTaux(LesRunes lesRunes){
        super();
        this.lesRunes = lesRunes;

        //Titled borders
        TitledBorder title;
        title = BorderFactory.createTitledBorder("Taux des Runes");
        this.setBorder(title);

        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        for(Rune r : lesRunes.getRunes()){
            LigneRune ligneRune = new LigneRune(r.getNom(),r);
            ligneRune.setAlignmentX(Component.LEFT_ALIGNMENT);
            this.add(ligneRune);
        }

    }

    @Override
    public Dimension getPreferredScrollableViewportSize() {
        return null;
    }

    @Override
    public int getScrollableUnitIncrement(Rectangle visibleRect, int orientation, int direction) {
        return 0;
    }

    @Override
    public int getScrollableBlockIncrement(Rectangle visibleRect, int orientation, int direction) {
        return 0;
    }

    @Override
    public boolean getScrollableTracksViewportWidth() {
        return false;
    }

    @Override
    public boolean getScrollableTracksViewportHeight() {
        return false;
    }
}
