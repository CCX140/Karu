package karu.view.recherche;

import karu.model.Equipement;

import javax.swing.*;
import java.awt.*;

import static karu.util.Constants.*;

public class LigneResultat extends JPanel {

    private Equipement model;
    private JLabel niveau;
    private JLabel nom;
    private JLabel taux;
    private Color color;

    public LigneResultat(Equipement equipement){
        model = equipement;
        niveau = new JLabel("Niveau : "+model.getNiveau());
        nom = new JLabel(model.getNom());
        taux = new JLabel("| Score : "+model.getScore());

        if(model.getScore() > 750){
            color = new Color(147,60,255);
        }
        else if(model.getScore() > 650){
            color = new Color(255,40,40);
        }
        else if(model.getScore() > 500){
            color = new Color(255,120,40);
        }
        else if(model.getScore() > 300){
            color = new Color(255,255,40);
        }
        else if(model.getScore() > 100){
            color = new Color(200,200,150);
        }
        else {
            color = new Color(240,240,240);
        }

        this.setBackground(color);
        niveau.setForeground(new Color(R_BLACK_GRAY,G_BLACK_GRAY,B_BLACK_GRAY));
        nom.setForeground(new Color(R_BLACK_GRAY,G_BLACK_GRAY,B_BLACK_GRAY));
        taux.setForeground(new Color(R_BLACK_GRAY,G_BLACK_GRAY,B_BLACK_GRAY));

        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.setSize(400,20);
        this.add(niveau);
        this.add(nom);
        this.add(taux);

    }


}
