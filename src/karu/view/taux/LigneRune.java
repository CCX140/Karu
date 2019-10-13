package karu.view.taux;

import karu.model.Rune;
import karu.view.toprunes.VueRunes;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.regex.Pattern;

import static karu.util.Constants.*;

public class LigneRune extends JPanel {

    private JLabel nomRune;
    private JTextField prixRune;
    private JLabel tauxRune;
    private Rune rune;
    private VueRunes vueRunes;

    public LigneRune(Rune r,VueRunes vr){
        super();
        vueRunes = vr;
        nomRune = new JLabel(r.getNom());
        prixRune = new JTextField("prix/unité");
        tauxRune = new JLabel();
        rune = r;

        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.setBackground(new Color(R_GRAY,G_GRAY,B_GRAY));

        nomRune.setPreferredSize(new Dimension(100,20));
        nomRune.setBackground(new Color(R_GRAY,G_GRAY,B_GRAY));
        nomRune.setForeground(Color.white);
        prixRune.setPreferredSize(new Dimension(100,20));
        prixRune.setBackground(new Color(R_LIGHT_GRAY,G_LIGHT_GRAY,B_LIGHT_GRAY));
        prixRune.setForeground(Color.white);
        prixRune.setCaretColor(Color.white);
        prixRune.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        tauxRune.setPreferredSize(new Dimension(150,20));
        tauxRune.setBackground(new Color(R_GRAY,G_GRAY,B_GRAY));
        tauxRune.setForeground(Color.white);

        prixRune.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                update();
                vueRunes.update();
            }
        });


        this.add(nomRune);
        this.add(prixRune);
        this.add(tauxRune);

    }

    public void update(){

        String prix = prixRune.getText();
        boolean integer= true;

        integer = prix.matches("\\d+");
        if (prix.length()>8){
            integer = false;
        }

        if(integer){
            rune.setPrix(Integer.parseInt(prix));
            rune.calcuTaux();
            tauxRune.setText("Taux :  "+rune.getTaux());
        }
        else{
            prixRune.setText("");
            rune.setPrix(-1);
            rune.setTaux(-1);
            tauxRune.setText("");
        }
    }
}
