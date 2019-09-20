package karu.view;

import karu.util.Constants;
import karu.view.recherche.VueRecherche;
import karu.view.taux.VueTaux;
import karu.view.toprunes.VueRunes;

import javax.swing.*;
import java.awt.*;

public class MainView {
    private JFrame main;
    private JMenuBar menuBar;
    private JPanel panel;
    private VueTaux vueTaux;
    private VueRunes vueRunes;
    private VueRecherche vueRecherche;

    public MainView(){
        main = new JFrame();
        menuBar = new JMenuBar();
        vueTaux = new VueTaux();
        vueRunes = new VueRunes();
        vueRecherche = new VueRecherche();
        panel = new JPanel(new BorderLayout());

        panel.add(vueTaux,BorderLayout.WEST);
        panel.add(vueRunes,BorderLayout.EAST);
        panel.add(vueRecherche,BorderLayout.CENTER);

        main.add(panel);
        main.setSize(Constants.WIDTH/2,Constants.HEIGHT/2);
        main.setTitle("KARU");
        main.setLocationRelativeTo(null);
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.setVisible(true);
    }
}
