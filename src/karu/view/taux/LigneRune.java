package karu.view.taux;

import karu.model.Rune;

import javax.swing.*;
import java.awt.*;

public class LigneRune extends JPanel {

    private JLabel nomRune;
    private JTextField prixRune;
    private JLabel tauxRune;
    private Rune rune;

    public LigneRune(String s,Rune r){
        nomRune = new JLabel(s);
        prixRune = new JTextField();
        tauxRune = new JLabel();
        rune = r;

        nomRune.setSize(100,30);
        prixRune.setSize(100,30);
        tauxRune.setSize(100,30);
        this.add(nomRune);
        this.add(prixRune);
        this.add(tauxRune);
    }
}
