package karu.view.toprunes;
import karu.model.Rune;

import javax.swing.*;
import java.awt.*;


public class LigneTopRune extends JPanel {

     private Rune rune;
     private JLabel nom;
     private JLabel score;
     private Color color;

     public LigneTopRune(Rune r){
         super();
         rune = r;
         nom = new JLabel(r.getNom());
         score = new JLabel(" Taux = "+rune.getTaux());

         this.setSize(300,25);
         this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
         if(rune.getTaux() > 300){
             color = new Color(147,60,255);
         }
         else if(rune.getTaux() > 250){
             color = new Color(255,40,40);
         }
         else if(rune.getTaux() > 200){
             color = new Color(255,120,40);
         }
         else if(rune.getTaux() > 150){
             color = new Color(255,255,40);
         }
         else if(rune.getTaux() > 100){
             color = new Color(200,200,150);
         }
         else {
             color = new Color(200,200,200);
         }

         this.setLayout(new FlowLayout(FlowLayout.LEFT));
         nom.setPreferredSize(new Dimension(150,20));
         score.setPreferredSize(new Dimension(150,20));
         this.add(nom);
         this.add(score);
         this.setBackground(color);

     }

}
