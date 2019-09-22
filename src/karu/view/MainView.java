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
        vueRunes = new VueRunes(model.getRunes());
        vueTaux = new VueTaux(model.getRunes(), (VueRunes) vueRunes);
        vueRecherche = new VueRecherche();
        panel = new JPanel();

        panel.setLayout(new BoxLayout(panel,BoxLayout.X_AXIS));

        panel.add(new JScrollPane(vueTaux));
        panel.add(vueRecherche);
        panel.add(new JScrollPane(vueRunes));

        main.add(panel);
        main.setSize(Constants.WIDTH,Constants.HEIGHT);
        main.setTitle("KARU");
        main.setLocationRelativeTo(null);
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.setVisible(true);
    }

    public JComponent getVueRunes() {
        return vueRunes;
    }
}
