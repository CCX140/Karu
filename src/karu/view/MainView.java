package karu.view;

import karu.model.Karu;
import karu.util.Constants;
import karu.view.recherche.VueRecherche;
import karu.view.taux.VueTaux;
import karu.view.toprunes.VueRunes;

import javax.swing.*;
import java.awt.*;

public class MainView {
    private Karu model;
    private JFrame main;
    private JMenuBar menuBar;
    private JPanel panel;
    private JComponent vueTaux;
    private JComponent vueRunes;
    private JComponent vueRecherche;

    public MainView(Karu model){
        this.model = model;
        main = new JFrame();
        menuBar = new JMenuBar();
        vueTaux = new VueTaux(model.getRunes());
        vueRunes = new VueRunes(model.getRunes());
        vueRecherche = new VueRecherche();
        panel = new JPanel();

        panel.setLayout(new BoxLayout(panel,BoxLayout.X_AXIS));
        panel.add(vueTaux);
        panel.add(vueRecherche);
        panel.add(vueRunes);

        main.add(panel);
        main.setSize(Constants.WIDTH/2,Constants.HEIGHT/2);
        main.setTitle("KARU");
        main.setLocationRelativeTo(null);
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.setVisible(true);
    }
}
