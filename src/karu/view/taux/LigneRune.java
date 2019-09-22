package karu.view.taux;

import karu.model.Rune;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.regex.Pattern;

public class LigneRune extends JPanel {

    private JLabel nomRune;
    private JTextField prixRune;
    private JLabel tauxRune;
    private Rune rune;

    public LigneRune(Rune r){
        nomRune = new JLabel(r.getNom());
        prixRune = new JTextField("prix/unité");
        tauxRune = new JLabel();
        rune = r;

        Border border = BorderFactory.createLineBorder(new Color(150,150,150));
        this.setBorder(border);
        this.setLayout(new FlowLayout(FlowLayout.LEFT));

        nomRune.setPreferredSize(new Dimension(100,20));
        prixRune.setPreferredSize(new Dimension(100,20));
        tauxRune.setPreferredSize(new Dimension(100,20));

        prixRune.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                calculTaux();
            }
        });


        this.add(nomRune);
        this.add(prixRune);
        this.add(tauxRune);
    }

    public void calculTaux(){

        String prix = prixRune.getText();
        boolean integer= true;

        integer = prix.matches("\\d+");

        if(integer){
            rune.setPrix(Integer.parseInt(prix));
            rune.calcuTaux();
            tauxRune.setText(""+rune.getTaux());
        }
        else{
            prixRune.setText("");
        }
    }
}
