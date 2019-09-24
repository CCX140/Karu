package karu.view.recherche;

import karu.model.Equipement;

import javax.swing.*;
import java.awt.*;

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
        taux = new JLabel("Score : "+model.getScore());

        if(model.getScore() > 1000){
            color = new Color(147,112,219);
        }
        else if(model.getScore() > 800){
            color = new Color(255,40,40);
        }
        else if(model.getScore() > 600){
            color = new Color(255,120,40);
        }
        else if(model.getScore() > 400){
            color = new Color(250,200,40);
        }
        else if(model.getScore() > 200){
            color = new Color(200,200,150);
        }
        else {
            color = new Color(240,240,240);
        }

        this.setBackground(color);

        this.setLayout(new GridLayout(1,3));
        this.setBorder(BorderFactory.createRaisedBevelBorder());
        this.add(niveau);
        this.add(nom);
        this.add(taux);

    }


}
