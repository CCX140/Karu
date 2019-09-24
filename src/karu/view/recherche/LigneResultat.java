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
        niveau = new JLabel(model.getNiveau()+"");
        nom = new JLabel(model.getNom());
        taux = new JLabel(""+model.getScore());

        if(model.getScore() > 800){
            color = new Color(147,112,219);
        }
        else if(model.getScore() > 600){
            color = new Color(255,40,40);
        }
        else if(model.getScore() > 400){
            color = new Color(255,120,40);
        }
        else if(model.getScore() > 200){
            color = new Color(255,255,40);
        }
        else if(model.getScore() > 100){
            color = new Color(200,200,150);
        }
        else {
            color = new Color(200,200,200);
        }

        this.setBackground(color);

        this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
    }


}
